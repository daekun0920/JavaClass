
-- 개설 과정 정보 출력시 개설 과정명, 개설 과정기간(시작 년월일, 끝 년월일), 강의실명, 개설 과목 등록 여부, 교육생 등록 인원을 출력한다.
--개설 과정 출력
CREATE OR REPLACE VIEW vw_course
AS
SELECT  q.COURSE_SEQ AS 개설과정번호,
        w.BASIC_COURSE_NAME AS 개설과정명, 
        q.COURSE_START_DATE AS 개설과정시작기간, 
         q.COURSE_END_DATE AS 개설과정종료기간, 
          e.CLASSROOM_NAME AS 강의실명, 
          (SELECT DECODE(COUNT(*), 10, '과목등록완료','과목등록비완료')FROM TBL_KEY_SUBJECT_COURSE WHERE COURSE_SEQ = Q.COURSE_SEQ) AS 과목등록여부, 
          (SELECT COUNT(*) FROM TBL_KEY_ENROLLMENT_COURSE r WHERE r.COURSE_SEQ = Q.COURSE_SEQ) AS 수강인원 
    FROM TBL_COURSE q 
        INNER JOIN TBL_BASIC_COURSE w ON q.BASIC_COURSE_SEQ = w.BASIC_COURSE_SEQ
            INNER JOIN TBL_CLASSROOM e ON q.CLASSROOM_SEQ = e.CLASSROOM_SEQ
                ORDER BY 개설과정번호, 강의실명 ASC;
                

-- 특정 개설 과정 선택시 개설 과정에 등록된 개설 과목 정보(과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명)
-- 특정 개설 과정 선택
CREATE OR REPLACE VIEW select_coursevw
AS
SELECT  a.COURSE_SEQ AS 과정번호,
        s.SUBJECT_SEQ AS 과목번호,
        d.BASIC_SUBJECT_NAME AS 과목명, 
        s.SUBJECT_START_DATE AS 과목시작기간, 
         s.SUBJECT_END_DATE AS 과목종료기간,
          f.BASIC_BOOK_NAME AS 교재명,
           h.TEACHER_NAME AS 교사명
FROM TBL_KEY_SUBJECT_COURSE a
    INNER JOIN TBL_SUBJECT s ON a.SUBJECT_SEQ = s.SUBJECT_SEQ
        INNER JOIN TBL_BASIC_SUBJECT d ON s.BASIC_SUBJECT_SEQ = d.BASIC_SUBJECT_SEQ
            INNER JOIN TBL_BASIC_BOOK f ON s.BASIC_BOOK_seq = f.BASIC_BOOK_SEQ
                INNER JOIN TBL_KEY_TEACHER_SUBJECT g ON s.SUBJECT_SEQ = g.SUBJECT_SEQ
                    INNER JOIN tbl_detail_teacher h ON g.DETAIL_TEACHER_SEQ = h.DETAIL_TEACHER_SEQ
                        INNER JOIN TBL_BASIC_INFO j ON h.BASIC_INFO_SEQ = j.BASIC_INFO_SEQ
                                    ORDER BY 과목시작기간 ASC;

--등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 전화번호, 등록일, 수료 및 중도탈락)조회

CREATE OR REPLACE PROCEDURE proc_course_student(
    pcourse_seq number,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
SELECT f.COURSE_SEQ as 과정번호,
        b.STUDENT_NAME as 교육생명,
            a.SSN as 교육생주민번호,
                b.STUDENT_TEL as 전화번호,
                    b.STUDENT_REGDATE as 등록일,
        CASE
          WHEN 수강현황 = '수료' THEN '수료'
          WHEN 수강현황 = '중도탈락' THEN '중도탈락'
          WHEN f.COURSE_START_DATE <= sysdate AND f.COURSE_END_DATE >= sysdate THEN '수강중'
          WHEN 수강현황 IS NULL THEN '미정'
          END as 수강현황
    FROM TBL_BASIC_INFO a
      INNER JOIN TBL_DETAIL_STUDENT b ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
          INNER JOIN TBL_KEY_STUDENT_ENROLLMENT c ON b.DETAIL_STUDENT_SEQ = c.DETAIL_STUDENT_SEQ
              INNER JOIN TBL_STUDENT_ENROLLMENT d ON c.STUDENT_ENROLLMENT_SEQ = d.STUDENT_ENROLLMENT_SEQ
                  INNER JOIN TBL_KEY_ENROLLMENT_COURSE e ON d.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
                      INNER JOIN TBL_COURSE f ON e.COURSE_SEQ = f.COURSE_SEQ
                          INNER JOIN TBL_BASIC_COURSE g ON f.BASIC_COURSE_SEQ = g.BASIC_COURSE_SEQ
                              INNER JOIN TBL_CLASSROOM h ON f.CLASSROOM_SEQ = h.CLASSROOM_SEQ
                                  LEFT OUTER JOIN (SELECT  STUDENT_ENROLLMENT_SEQ as 학생번호,'수료' as 수강현황, STUDENT_COMPLETE_DATE  FROM TBL_STUDENT_COMPLETE
                                  UNION
                                  SELECT  STUDENT_ENROLLMENT_SEQ , '중도탈락', STUDENT_QUIT_DATE  FROM TBL_STUDENT_QUIT) i
                                    ON i.학생번호 = d.STUDENT_ENROLLMENT_SEQ
                                        WHERE f.COURSE_SEQ = pcourse_seq;
END;

--개설과정등록(프로시저)
CREATE OR REPLACE PROCEDURE proc_add_course
  (
    pbasic_course_seq NUMBER,
    pcourse_start_date date,
    pcourse_end_date date,
    pclassroom_seq NUMBER, 
    presult OUT NUMBER -- 성공유무
  )
IS
BEGIN 
    INSERT INTO tbl_course(course_seq,course_start_date,course_end_date,classroom_seq,basic_course_seq)
      VALUES(course_seq.nextval,pcourse_start_date,pcourse_end_date,pclassroom_seq,pbasic_course_seq);
    presult :=1;
    COMMIT;
 
EXCEPTION
    WHEN OTHERS THEN
     presult :=0;
        ROLLBACK;
END;


--개설과정수정 프로시저
CREATE OR REPLACE PROCEDURE proc_edit_course
  (
    pcourse_seq number,
    pbasic_course_seq NUMBER,
    pcourse_start_date DATE,
    pcourse_end_date DATE,
    pclassroom_seq NUMBER,
    presult OUT NUMBER -- 성공유무
  )
  IS
    vcount NUMBER;
  BEGIN
    SELECT count(*) INTO vcount FROM tbl_course WHERE COURSE_SEQ = pcourse_seq;
      IF vcount = 1 THEN
          UPDATE tbl_course SET
            basic_course_seq = pbasic_course_seq,
            course_start_date = pcourse_start_date,
            course_end_date = pcourse_end_date,
            classroom_seq = pclassroom_seq  
            WHERE COURSE_SEQ = pCOURSE_SEQ;
  
        presult :=1;
        COMMIT;
  
      END IF;
      
  EXCEPTION
    WHEN OTHERS THEN
        presult :=0;
        ROLLBACK;

  END;



--개설과정삭제 프로시저
CREATE OR REPLACE PROCEDURE proc_del_course
(
    pcourse_seq NUMBER,
    vresult OUT NUMBER
)
IS
  vcount NUMBER;
BEGIN
    SELECT count(*) INTO vcount FROM tbl_course WHERE COURSE_SEQ = pCOURSE_SEQ;
    IF vcount = 1 THEN
        DELETE FROM TBL_KEY_SUBJECT_COURSE WHERE course_seq = pcourse_seq; 
        DELETE FROM TBL_KEY_STUDENT_QUIT_COURSE WHERE course_seq = pcourse_seq;
        DELETE FROM TBL_KEY_ENROLLMENT_COURSE WHERE course_seq = pcourse_seq;
        DELETE FROM TBL_KEY_COMPLETE_COURSE WHERE course_seq = pcourse_seq;
        
        
        
        DELETE FROM tbl_course WHERE COURSE_SEQ = pCOURSE_SEQ;
        vresult :=1;
        COMMIT;
    ELSE
        vresult :=2;
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        vresult :=0;
        ROLLBACK;
END;



--개설 과목 조회
CREATE OR REPLACE VIEW vw_subjectselect
AS
SELECT  c.course_seq as 과정번호,
        k.BASIC_COURSE_NAME AS 과정명, c.COURSE_START_DATE AS 과정시작기간,c.COURSE_END_DATE AS 과정종료기간,
        v.CLASSROOM_NAME AS 강의실명, b.BASIC_SUBJECT_NAME AS 과목명, z.SUBJECT_START_DATE AS 과목시작기간,
        z.SUBJECT_END_DATE 과목종료기간, n.BASIC_BOOK_NAME AS 교재명, l.TEACHER_NAME AS 교사명
FROM TBL_SUBJECT z
    INNER JOIN TBL_KEY_SUBJECT_COURSE x ON z.SUBJECT_SEQ = x.SUBJECT_SEQ
        INNER JOIN TBL_COURSE c ON x.COURSE_SEQ = c.COURSE_SEQ
            INNER JOIN TBL_BASIC_COURSE k ON c.BASIC_COURSE_SEQ = K.BASIC_COURSE_SEQ
                INNER JOIN TBL_CLASSROOM v ON c.CLASSROOM_SEQ = v.CLASSROOM_SEQ
                    INNER JOIN TBL_BASIC_SUBJECT b ON z.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
                        INNER JOIN TBL_BASIC_BOOK n ON z.BASIC_BOOK_SEQ = n.BASIC_BOOK_SEQ
                            INNER JOIN TBL_KEY_TEACHER_SUBJECT m ON z.SUBJECT_SEQ = m.SUBJECT_SEQ
                                INNER JOIN TBL_DETAIL_TEACHER l ON m.DETAIL_TEACHER_SEQ = l.DETAIL_TEACHER_SEQ;                

--과목 조회(삭제시 보여줌)
CREATE OR REPLACE VIEW vw_subject
AS
SELECT  c.course_seq as 과정번호, k.BASIC_COURSE_NAME AS 과정명, c.COURSE_START_DATE AS 과정시작기간,c.COURSE_END_DATE AS 과정종료기간,
        v.CLASSROOM_NAME AS 강의실명, z.subject_seq AS 과목번호, b.BASIC_SUBJECT_NAME AS 과목명, z.SUBJECT_START_DATE AS 과목시작기간,
        z.SUBJECT_END_DATE 과목종료기간, n.BASIC_BOOK_NAME AS 교재명, l.TEACHER_NAME AS 교사명
FROM TBL_SUBJECT z
    INNER JOIN TBL_KEY_SUBJECT_COURSE x ON z.SUBJECT_SEQ = x.SUBJECT_SEQ
        INNER JOIN TBL_COURSE c ON x.COURSE_SEQ = c.COURSE_SEQ
            INNER JOIN TBL_BASIC_COURSE k ON c.BASIC_COURSE_SEQ = K.BASIC_COURSE_SEQ
                INNER JOIN TBL_CLASSROOM v ON c.CLASSROOM_SEQ = v.CLASSROOM_SEQ
                    INNER JOIN TBL_BASIC_SUBJECT b ON z.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
                        INNER JOIN TBL_BASIC_BOOK n ON z.BASIC_BOOK_SEQ = n.BASIC_BOOK_SEQ
                            INNER JOIN TBL_KEY_TEACHER_SUBJECT m ON z.SUBJECT_SEQ = m.SUBJECT_SEQ
                                INNER JOIN TBL_DETAIL_TEACHER l ON m.DETAIL_TEACHER_SEQ = l.DETAIL_TEACHER_SEQ
                                    ORDER BY 과목시작기간 ASC;


-- 개설 과목 등록
CREATE OR REPLACE PROCEDURE proc_add_subject
  ( 
    pcourse_seq number,
    pbasic_subject_seq NUMBER,
    psubject_start_date DATE,
    psubject_end_date DATE,
    pbasic_book_seq NUMBER,
    pdetail_teacher_seq number,
    presult OUT NUMBER -- 성공유무
  )
IS
BEGIN     
    INSERT INTO TBL_GRADING_STANDARD(grading_standard_seq)VALUES(grading_standard_seq.nextval); -- 배점정보 등록
        -- 과목테이블
     INSERT INTO tbl_subject(subject_seq,basic_subject_seq,subject_start_date,subject_end_date,basic_book_seq)
      VALUES(subject_seq.nextval,pbasic_subject_seq,psubject_start_date,psubject_end_date,pbasic_book_seq);
        -- 과정 과목테이블
      INSERT INTO TBL_KEY_SUBJECT_COURSE(course_seq,subject_seq)VALUES(pcourse_seq,subject_seq.currval);--과목/과정키  
        -- 교사 과목테이블
      INSERT INTO TBL_KEY_TEACHER_SUBJECT(subject_seq,detail_teacher_seq)VALUES(subject_seq.currval,pdetail_teacher_seq);--선생님/과목키
        -- 배점정보테이블시퀀스생성
      INSERT INTO TBL_KEY_STANDARD_SUBJECT(subject_seq,grading_standard_seq)VALUES(subject_seq.currval,grading_standard_seq.currval);--배점정보/과목키
      
    presult :=1;
    COMMIT;
    
EXCEPTION

      WHEN OTHERS THEN
        presult :=0;
        ROLLBACK;

END;

-- 개설 과목 수정 프로시저
CREATE OR REPLACE PROCEDURE proc_edit_subject
  (
    pcourse_seq number,
    psubject_seq number,
    pbasic_subject_seq NUMBER,
    psubject_start_date DATE,
    psubject_end_date DATE,
    pbasic_book_seq NUMBER,
    pdetail_teacher_seq number,
    presult OUT NUMBER -- 성공유무
  )
IS
BEGIN
     
          UPDATE tbl_subject SET
            subject_seq = psubject_seq,
            basic_subject_seq = pbasic_subject_seq,
            subject_start_date = psubject_start_date,
            subject_end_date = psubject_end_date,
            basic_book_seq = pbasic_book_seq
            WHERE subject_seq = psubject_seq;
            update TBL_KEY_SUBJECT_COURSE set
            course_seq = pcourse_seq;
            update TBL_KEY_TEACHER_SUBJECT set
            detail_teacher_seq = pdetail_teacher_seq;
              
       
        presult :=1;
        COMMIT;
   
  EXCEPTION
      WHEN OTHERS THEN
        presult :=0;
        ROLLBACK;

  END;


  -- 개설 과목 삭제 프로시저
CREATE OR REPLACE PROCEDURE proc_del_subject
(
    psubject_seq NUMBER,
    vresult OUT NUMBER
)
IS
  vcount NUMBER;
BEGIN
        SELECT count(*) INTO vcount FROM tbl_subject WHERE subject_seq = psubject_seq;
        
        IF vcount = 1 THEN
        
        DELETE FROM TBL_KEY_STANDARD_SUBJECT WHERE subject_seq = psubject_seq;
        DELETE FROM TBL_KEY_TEACHER_SUBJECT WHERE subject_seq = psubject_seq;           
        DELETE FROM TBL_KEY_SUBJECT_COURSE WHERE subject_seq = psubject_seq;
        DELETE FROM TBL_KEY_GRADE_SUBJECT WHERE subject_seq = psubject_seq;
        DELETE FROM TBL_SUBJECT WHERE subject_seq = psubject_seq;
        
        vresult :=1;
        COMMIT;
    ELSE
        vresult :=2;
    END IF;


END;

CREATE OR REPLACE FORCE VIEW VW_DATE 
as
SELECT seq as 날짜번호, datefirst as 날짜시작기간, dateend as 날짜종료기간 FROM tbl_date WHERE  3 < seq and 15> seq;
