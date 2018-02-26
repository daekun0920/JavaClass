-------------------------3. 교사계정 ----------------------------------------------
----------------------------------------------------------[등록]
  -- 교사 정보 등록 순서
  -- tbl_basic_info -> tbl_detail_teacher -> tbl_teacher_subject
--[프로시저] 교사 정보를 등록해주는 프로시저

CREATE OR REPLACE PROCEDURE  proc_teacher_add(
  pid VARCHAR2, -- 기초정보id
  pssn VARCHAR2, -- 기초정보ssn
  ptype VARCHAR2, --기초정보type
  pname VARCHAR2, --상세정보name
  ptel VARCHAR2, --상세정보tel
  pbasic_subject_seq NUMBER, --기초과목seq
  presult OUT NUMBER
)
IS
  vcount NUMBER;
  vvcount NUMBER;
  vvvcount NUMBER;

BEGIN

  -- 교사 10명까지 등록 가능
  SELECT count(*) INTO vcount FROM TBL_DETAIL_TEACHER;

  -- 전화번호 같으면 ㄴㄴ
  SELECT count(*) INTO vvcount FROM TBL_DETAIL_TEACHER WHERE TEACHER_TEL = ptel;

  -- 같은 강의 ㄴㄴ
 -- SELECT count(*) INTO vvvcount FROM TBL_TEACHER_SUBJECT WHERE BASIC_SUBJECT_SEQ = pbasic_subject_seq;

 IF vcount <= 10 AND vvcount = 0  THEN

  INSERT INTO TBL_BASIC_INFO(BASIC_INFO_SEQ, ID, SSN, TYPE)
    VALUES (basic_info_seq.nextval, pid, pssn, ptype);

  INSERT INTO TBL_DETAIL_TEACHER(DETAIL_TEACHER_SEQ, TEACHER_NAME, TEACHER_TEL, BASIC_INFO_SEQ)
    VALUES (detail_teacher_seq.nextval , pname, ptel, basic_info_seq.currval);

  INSERT INTO TBL_TEACHER_SUBJECT(DETAIL_TEACHER_SEQ, BASIC_SUBJECT_SEQ)
    VALUES (detail_teacher_seq.currval, pbasic_subject_seq);

   presult := 1;
        COMMIT;
    END IF;

EXCEPTION
  WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;


-------------------------------------------------------------[조회]
-- [뷰] 교사 전체 명단정보 (이름, 주민번호, 전화번호, 강의 가능 과목)
-- 교사번호, 교사이름, 주민번호, 전화번호, 강의가능과목
CREATE OR REPLACE VIEW vw_teacher_list
AS
SELECT a.BASIC_INFO_SEQ as 교사번호 ,
        b.TEACHER_NAME as 교사이름,
        a.SSN as 주민번호,
        b.TEACHER_TEL as 전화번호,
        d.BASIC_SUBJECT_NAME as 강의가능과목 FROM TBL_BASIC_INFO a
  INNER JOIN TBL_DETAIL_TEACHER b
    ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
      INNER JOIN TBL_TEACHER_SUBJECT c
        ON b.DETAIL_TEACHER_SEQ = c.DETAIL_TEACHER_SEQ
          INNER JOIN TBL_BASIC_SUBJECT d
            ON c.BASIC_SUBJECT_SEQ = d.BASIC_SUBJECT_SEQ
              ORDER BY a.BASIC_INFO_SEQ ASC;

--[뷰] 교사 전체명단 출력후 특정교사를 선택시에 개설과목명, 개설과목기간, 교재명, 강의실명, 강의진행여부를 보여줌
-- 교사번호, 교사이름, 개설과목명, 개설과목기간, 과정명, 교재명, 강의실명, 강의진행여부
CREATE OR REPLACE VIEW vw_teacher_list_select
  AS
SELECT a.BASIC_INFO_SEQ as 교사번호,
        b.TEACHER_NAME as 교사이름,
        BASIC_SUBJECT_NAME as 개설과목명,
        d.SUBJECT_START_DATE || ' ~ ' || d.SUBJECT_END_DATE as 개설과목기간,
        BASIC_COURSE_NAME as 개설과정명,
        COURSE_START_DATE || ' ~ ' || COURSE_END_DATE as 개설과정기간,
        '[' || f.BASIC_BOOK_PUBLISHER || ']' || f.BASIC_BOOK_NAME as 교재명,
        j.CLASSROOM_NAME as 강의실명,
        CASE
          WHEN h.COURSE_START_DATE <= sysdate AND h.COURSE_END_DATE >= sysdate THEN '강의중'
          WHEN h.COURSE_END_DATE > sysdate THEN '강의예정'
          WHEN h.COURSE_END_DATE < sysdate THEN '강의종료'
        END as 강의진행여부
    FROM TBL_BASIC_INFO a
    INNER JOIN TBL_DETAIL_TEACHER b
      ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
        INNER JOIN TBL_KEY_TEACHER_SUBJECT c
          ON b.DETAIL_TEACHER_SEQ = c.DETAIL_TEACHER_SEQ
            INNER JOIN TBL_SUBJECT d
              ON c.SUBJECT_SEQ = d.SUBJECT_SEQ
                INNER JOIN TBL_BASIC_SUBJECT e
                  ON d.BASIC_SUBJECT_SEQ = e.BASIC_SUBJECT_SEQ
                    INNER JOIN TBL_BASIC_BOOK f
                      ON d.BASIC_BOOK_SEQ = f.BASIC_BOOK_SEQ
                        INNER JOIN TBL_KEY_SUBJECT_COURSE g
                          ON d.SUBJECT_SEQ = g.SUBJECT_SEQ
                            INNER JOIN TBL_COURSE h
                              ON g.COURSE_SEQ = h.COURSE_SEQ
                                INNER JOIN TBL_BASIC_COURSE i
                                  ON h.BASIC_COURSE_SEQ = i.BASIC_COURSE_SEQ
                                    INNER JOIN TBL_CLASSROOM j
                                      ON h.CLASSROOM_SEQ = j.CLASSROOM_SEQ;


--[프로시저] 교사 전체명단 출력후 특정교사를 선택시에 개설과목명, 개설과목기간, 교재명, 강의실명, 강의진행여부를 보여줌
CREATE OR REPLACE PROCEDURE proc_teacher_selected_list(
  pbasic_info_seq NUMBER, --기초정보 seq
  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN

  OPEN pcursor FOR
    SELECT * FROM vw_teacher_list_select WHERE 교사번호 = pbasic_info_seq;
END;


-------------------------------------------------[수정]
-- [프로시저] 교사 정보 수정 프로시저(전화번호)
CREATE OR REPLACE PROCEDURE proc_edit_teacher_tel (
  pbasic_info_seq NUMBER, -- 기초 정보seq
  ptel VARCHAR2,  -- 전화번호
  presult OUT NUMBER
)
IS
  vcount NUMBER;
BEGIN

  SELECT count(*) INTO vcount FROM TBL_DETAIL_TEACHER WHERE BASIC_INFO_SEQ = pbasic_info_seq;

  IF vcount = 1 THEN
    UPDATE TBL_DETAIL_TEACHER SET
      TEACHER_TEL = ptel
        WHERE BASIC_INFO_SEQ = pbasic_info_seq;
      presult := 1;
      COMMIT;
    ELSE
      presult := 2;
    END IF;
EXCEPTION
  WHEN OTHERS THEN
      presult := 0;
      ROLLBACK;
END;

-- 교사의 강의가능과목
  CREATE OR REPLACE VIEW vw_teacher_subject
    AS
  SELECT d.BASIC_INFO_SEQ as 교사번호,
          TEACHER_NAME as 교사이름,
          BASIC_SUBJECT_NAME as 과목명
  FROM TBL_DETAIL_TEACHER a
    INNER JOIN tbl_teacher_subject b
      ON a.DETAIL_TEACHER_SEQ = b.DETAIL_TEACHER_SEQ
        INNER JOIN TBL_BASIC_SUBJECT c
          ON b.BASIC_SUBJECT_SEQ = c.BASIC_SUBJECT_SEQ
            INNER JOIN TBL_BASIC_INFO d
              ON a.BASIC_INFO_SEQ = d.BASIC_INFO_SEQ
                ORDER BY a.DETAIL_TEACHER_SEQ asc;

  -- [프로시저] 교사정보 강의가능과목 추가 프로시저
CREATE OR REPLACE PROCEDURE proc_edit_teacher_subject(
  pbasic_info_seq NUMBER,
  pbasic_subjec_seq NUMBER, --과목seq
  presult OUT NUMBER
)
IS
  vcount NUMBER;
  vvcount NUMBER;
  vvvcount NUMBER;
BEGIN

SELECT DETAIL_TEACHER_SEQ INTO vcount FROM TBL_DETAIL_TEACHER WHERE BASIC_INFO_SEQ = pbasic_info_seq;

  --강의가능과목이 20개까지, 강의가능과목이 겹치지않게
  SELECT count(*) INTO vvvcount FROM TBL_TEACHER_SUBJECT WHERE DETAIL_TEACHER_SEQ = vcount AND BASIC_SUBJECT_SEQ = pbasic_subjec_seq;
    SELECT count(basic_subject_seq) INTO vvcount FROM tbl_teacher_subject WHERE detail_teacher_seq = vcount;

  IF vvcount < 20 AND vvvcount = 0  THEN

    INSERT INTO TBL_TEACHER_SUBJECT(DETAIL_TEACHER_SEQ, BASIC_SUBJECT_SEQ)
      VALUES (vcount, pbasic_subjec_seq);
    presult :=1;
    COMMIT;

  END IF;

  EXCEPTION
  WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;





-------------------------------------------[삭제]
--[프로시저] 교사정보 삭제 순서
-- tbl_key_teacher_subject, tbl_teacher_subejct -> tbl_detail_teacher -> tbl_basic_info
CREATE OR REPLACE PROCEDURE proc_teacher_del(
  pbasic_info_seq NUMBER, -- 기초정보 seq
  presult OUT NUMBER
)
IS
  vcount NUMBER;
  vvcount NUMBER;
BEGIN

  SELECT count(*) INTO vcount FROM TBL_BASIC_INFO WHERE BASIC_INFO_SEQ = pbasic_info_seq;

  IF vcount = 1 THEN
    SELECT DETAIL_TEACHER_SEQ INTO vvcount FROM TBL_DETAIL_TEACHER WHERE BASIC_INFO_SEQ = pbasic_info_seq;

    DELETE FROM TBL_TEACHER_SUBJECT WHERE DETAIL_TEACHER_SEQ = vvcount;
    DELETE FROM TBL_KEY_TEACHER_SUBJECT WHERE DETAIL_TEACHER_SEQ = vvcount;
    DELETE FROM TBL_DETAIL_TEACHER WHERE DETAIL_TEACHER_SEQ = vvcount;
    DELETE FROM TBL_BASIC_INFO WHERE BASIC_INFO_SEQ = pbasic_info_seq;
    presult := 1;
    COMMIT;
  ELSE
    presult := 2;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    presult :=0;
    ROLLBACK ;
END;

------------------------------------------------------------6.교육생
-- SELECT SUBJECT_SEQ FROM TBL_KEY_SUBJECT_COURSE WHERE COURSE_SEQ = 2;
---------------------------------------[등록]
-- [프로시저] 교육생 정보 등록 순서
-- tbl_baisc_info -> tbl_detail_student ->
-- tbl_student_enrollment ->
-- tbl_key_student_enrollment, tbl_key_enrollment_course ->
-- (tbl_student_grade -> tbl_key_grade_subject) (과목수씩)
CREATE OR REPLACE PROCEDURE proc_student_add(
  pid VARCHAR2, -- 기초정보id
  pssn VARCHAR2, -- 기초정보ssn
  ptype VARCHAR2, --기초정보type
  pname VARCHAR2, --상세정보name
  ptel VARCHAR2, --상세정보tel
  pcourse_seq NUMBER, --과정seq
  presult OUT NUMBER
)
IS
  vcount NUMBER;
  vvcount NUMBER;
  vnum NUMBER;
  CURSOR vcursor
  is
   SELECT SUBJECT_SEQ INTO vvcount FROM TBL_KEY_SUBJECT_COURSE WHERE COURSE_SEQ = pcourse_seq;
BEGIN

  --전화번호 같으면 ㄴㄴ
 select count(*) INTO vcount FROM TBL_DETAIL_STUDENT WHERE STUDENT_TEL = ptel;

  IF vcount = 0  THEN
  --회원 기초정보
  INSERT INTO TBL_BASIC_INFO(BASIC_INFO_SEQ, ID, SSN, TYPE)
    VALUES (basic_info_seq.nextval, pid, pssn, ptype);

  -- 학생 상세정보
  INSERT INTO TBL_DETAIL_STUDENT(DETAIL_STUDENT_SEQ, STUDENT_NAME, STUDENT_TEL, BASIC_INFO_SEQ)
    VALUES (detail_student_seq.nextval, pname, ptel, basic_info_seq.currval);

  --교육생 수강현황
  INSERT INTO TBL_STUDENT_ENROLLMENT(STUDENT_ENROLLMENT_SEQ)
    VALUES (student_enrollment_seq.nextval);

  --교육생 수강현황/학생상세키
  Insert INTO TBL_KEY_STUDENT_ENROLLMENT(STUDENT_ENROLLMENT_SEQ, DETAIL_STUDENT_SEQ)
    VALUES (student_enrollment_seq.currval, detail_student_seq.currval);


  INSERT INTO TBL_KEY_ENROLLMENT_COURSE(COURSE_SEQ, STUDENT_ENROLLMENT_SEQ)
    VALUES (pcourse_seq, student_enrollment_seq.currval);

    vnum := 1;

    OPEN vcursor;

    WHILE vnum <10 LOOP

      fetch vcursor INTO vvcount;

    INSERT INTO TBL_STUDENT_GRADE(STUDENT_GRADE_SEQ, STUDENT_ENROLLMENT_SEQ)
      VALUES (student_grade_seq.nextval, student_enrollment_seq.currval);

      INSERT INTO TBL_KEY_GRADE_SUBJECT(SUBJECT_SEQ, STUDENT_GRADE_SEQ)
        VALUES (vvcount, student_grade_seq.currval);

      EXIT when vcursor%NOTFOUND ;

END LOOP;
    close vcursor;

    presult := 1;
        COMMIT;
  END IF;

EXCEPTION
  WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;

-- SELECT * FROM TBL_BASIC_INFO a
--   INNER JOIN TBL_DETAIL_STUDENT b
--   ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
--   INNER JOIN TBL_KEY_STUDENT_ENROLLMENT c
--     ON b.DETAIL_STUDENT_SEQ = c.DETAIL_STUDENT_SEQ
--       INNER JOIN TBL_STUDENT_ENROLLMENT d
--         ON c.STUDENT_ENROLLMENT_SEQ = d.STUDENT_ENROLLMENT_SEQ
--           INNER JOIN TBL_STUDENT_GRADE e
--             ON d.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
--               INNER JOIN TBL_KEY_GRADE_SUBJECT f
--                 ON e.STUDENT_GRADE_SEQ = f.STUDENT_GRADE_SEQ
--                   WHERE a.BASIC_INFO_SEQ = 531;
--  DECLARE
--
--   vnumber NUMBER;
--
--    CURSOR vcursor
--      IS
--     SELECT SUBJECT_SEQ FROM TBL_KEY_SUBJECT_COURSE WHERE COURSE_SEQ = 1;
--
--    BEGIN
--
--    OPEN vcursor;
--
--    LOOP
--      FETCH vcursor INTO vnumber;
--     EXIT when vcursor%NOTFOUND;
--      dbms_output.put_line(vnumber);
--    END LOOP;
-- CLOSE vcursor;
--  END;

-- SELECT SUBJECT_SEQ  FROM TBL_KEY_SUBJECT_COURSE WHERE COURSE_SEQ = 1;




  -- 개설과정정보 조회
  CREATE or REPLACE VIEW vw_course_list
    AS
  SELECT a.COURSE_SEQ as 과정번호,
          BASIC_COURSE_NAME as 과정명,
          COURSE_START_DATE || ' ~ ' || COURSE_END_DATE as 과정기간,
          CLASSROOM_NAME as 강의실,
          count(STUDENT_ENROLLMENT_SEQ) as 인원수,
          CAPACITY as 강의실정원
      FROM TBL_COURSE a
    INNER JOIN tbl_basic_course b
      ON a.BASIC_COURSE_SEQ = b.BASIC_COURSE_SEQ
        INNER JOIN TBL_CLASSROOM c
          ON a.CLASSROOM_SEQ = c.CLASSROOM_SEQ
            INNER JOIN TBL_KEY_ENROLLMENT_COURSE d
              ON a.COURSE_SEQ = d.COURSE_SEQ
                INNER JOIN TBL_CLASSROOM_CAPACITY e
                  ON c.CLASSROOM_SEQ = e.CLASSROOM_SEQ
                    GROUP BY a.COURSE_SEQ, BASIC_COURSE_NAME, COURSE_START_DATE, COURSE_END_DATE, CLASSROOM_NAME,CAPACITY
                      ORDER BY 과정기간 asc, 강의실 asc;

-----------------------------------------[조회]
-- 교육생 정보 (교육생 이름, 주민번호 뒷자리, 전화번호, 등록일, 수강신청횟수)
-- 교육생번호, 교육생이름, 주민번호, 전화번호, 등록일, 수강신청횟수
CREATE OR REPLACE VIEW vw_student_list
AS
SELECT a.BASIC_INFO_SEQ as 기초번호,
        b.DETAIL_STUDENT_SEQ as 교육생번호,
        b.STUDENT_NAME as 교육생이름,
        a.SSN as 주민번호,
        b.STUDENT_TEL as 전화번호,
        b.STUDENT_REGDATE as 등록일,
        count(c.STUDENT_ENROLLMENT_SEQ) as 수강신청횟수
  FROM TBL_BASIC_INFO a
  INNER JOIN TBL_DETAIL_STUDENT b
    ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
      INNER JOIN TBL_KEY_STUDENT_ENROLLMENT c
        ON b.DETAIL_STUDENT_SEQ = c.DETAIL_STUDENT_SEQ
          GROUP BY a.BASIC_INFO_SEQ, STUDENT_NAME, SSN, STUDENT_TEL, STUDENT_REGDATE, b.DETAIL_STUDENT_SEQ
            ORDER BY a.BASIC_INFO_SEQ asc;


-- [뷰] 특정 교육생 선택시  교육생의 수강중인 혹은 수강했던 개설 과정 정보(과정명, 과정기간, 강의실, [수료 및 중도 탈락 여부, 수료 및 중도 탈락 날짜])를 출력한다.
-- 교육생번호, 교육생명, 과정명, 과정기간, 강의실, 수강현황, 수료및중도탈락날짜
CREATE OR REPLACE VIEW vw_student_selected_list
  AS
SELECT a.BASIC_INFO_SEQ as 교육생번호,
        b.STUDENT_NAME as 교육생이름,
        g.BASIC_COURSE_NAME as 과정명,
        f.COURSE_START_DATE || ' ~ ' || COURSE_END_DATE as 과정기간,
        h.CLASSROOM_NAME as 강의실,
        CASE
          WHEN 수강현황 = '수료' THEN '수료'
          WHEN 수강현황 = '중도탈락' THEN '중도탈락'
          WHEN f.COURSE_START_DATE <= sysdate AND f.COURSE_END_DATE >= sysdate THEN '수강중'
          WHEN 수강현황 IS NULL THEN '수강예정'
          END as 수강현황,
        i.STUDENT_COMPLETE_DATE 수료및중도탈락날짜
    FROM TBL_BASIC_INFO a
      INNER JOIN TBL_DETAIL_STUDENT b
        ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
          INNER JOIN TBL_KEY_STUDENT_ENROLLMENT c
            ON b.DETAIL_STUDENT_SEQ = c.DETAIL_STUDENT_SEQ
              INNER JOIN TBL_STUDENT_ENROLLMENT d
                ON c.STUDENT_ENROLLMENT_SEQ = d.STUDENT_ENROLLMENT_SEQ
                  INNER JOIN TBL_KEY_ENROLLMENT_COURSE e
                    ON d.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
                      INNER JOIN TBL_COURSE f
                        ON e.COURSE_SEQ = f.COURSE_SEQ
                          INNER JOIN TBL_BASIC_COURSE g
                            ON f.BASIC_COURSE_SEQ = g.BASIC_COURSE_SEQ
                              INNER JOIN TBL_CLASSROOM h
                                ON f.CLASSROOM_SEQ = h.CLASSROOM_SEQ
                                  LEFT OUTER JOIN (SELECT  STUDENT_ENROLLMENT_SEQ as 학생번호,'수료' as 수강현황, STUDENT_COMPLETE_DATE  FROM TBL_STUDENT_COMPLETE
                                  UNION
                                  SELECT  STUDENT_ENROLLMENT_SEQ , '중도탈락', STUDENT_QUIT_DATE  FROM TBL_STUDENT_QUIT) i
                                    ON i.학생번호 = d.STUDENT_ENROLLMENT_SEQ;

---- 특정 교육생 선택시  교육생의 수강중인 혹은 수강했던 개설 과정 정보(과정명, 과정기간, 강의실, [수료 및 중도 탈락 여부, 수료 및 중도 탈락 날짜])를 출력한다.
-- 프로시저
CREATE OR REPLACE PROCEDURE proc_student_selected_list(
  pbasic_info_seq NUMBER, --기초 정보 seq
  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN

  OPEN pcursor FOR
    SELECT * FROM vw_student_selected_list WHERE 교육생번호 = pbasic_info_seq;
END;


------------------------------------------------------[수정]
-- [프로시저] 교육생 정보 수정 프로시저
CREATE OR REPLACE PROCEDURE proc_student_edit(
  pbasic_info_seq NUMBER, -- 기초정보seq
  ptel VARCHAR2, --전화번호
  presult OUT NUMBER
)
IS
  vcount NUMBER;
BEGIN

  SELECT count(*) INTO vcount FROM TBL_DETAIL_STUDENT WHERE BASIC_INFO_SEQ = pbasic_info_seq;

  IF vcount = 1 THEN
    UPDATE TBL_DETAIL_STUDENT SET
      STUDENT_TEL = ptel
      WHERE BASIC_INFO_SEQ = pbasic_info_seq;

      presult := 1;
      COMMIT;
    ELSE
      presult := 2;
    END IF;

EXCEPTION
  WHEN OTHERS THEN
      presult := 0;
      ROLLBACK;
END;

  ------------------------------------------[삭제]
-- [프로시저] 교육생 정보 삭제 순서
-- tbl_key_student_enrollment -> tbl_detail_student -> tbl_basic_info
CREATE OR REPLACE PROCEDURE proc_student_del(
  pbasic_info_seq NUMBER,     --기초정보 seq
  presult OUT NUMBER
)
IS
  vcount NUMBER;
 vvcount NUMBER;
BEGIN

  SELECT count(*) INTO vcount FROM TBL_BASIC_INFO WHERE BASIC_INFO_SEQ = pbasic_info_seq;

   IF vcount =1 THEN
    SELECT DETAIL_STUDENT_SEQ INTO vvcount FROM TBL_DETAIL_STUDENT WHERE BASIC_INFO_SEQ = pbasic_info_seq;

    DELETE FROM TBL_KEY_STUDENT_ENROLLMENT WHERE DETAIL_STUDENT_SEQ = vvcount;
    DELETE FROM TBL_DETAIL_STUDENT WHERE DETAIL_STUDENT_SEQ = vvcount;
    DELETE FROM TBL_BASIC_INFO WHERE BASIC_INFO_SEQ = pbasic_info_seq;
    presult := 1;
    COMMIT;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    presult :=0;
    ROLLBACK ;
END;

-----------------------------[검색 기능]
CREATE OR REPLACE PROCEDURE proc_student_search(
  pname VARCHAR2,   -- 교육생이름
  pcourse VARCHAR2, -- 과정
  pstatus VARCHAR2, -- 수강현황
  pclassroom VARCHAR2, -- 강의실
  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN pcursor FOR
    SELECT * FROM vw_student_selected_list
      WHERE 교육생이름 like '%' || pname || '%' OR
             과정명 LIKE '%' ||upper(pcourse) || '%' OR
            강의실 LIKE '%' || pclassroom ||'%' OR
             수강현황 LIKE '%' || pstatus || '%';
END;

------------------------------[view] 날짜 NULL일때 course_end_date 가 끝났을떄
--수강중인 아이들만 조회해주는 뷰
CREATE OR REPLACE VIEW vw_student_duringcourse
  AS
  SELECT a.BASIC_INFO_SEQ as 교육생번호,
        d.STUDENT_ENROLLMENT_SEQ as 수강현황번호,
        b.STUDENT_NAME as 교육생명,
        g.BASIC_COURSE_NAME as 과정명,
        f.COURSE_START_DATE || ' ~ ' || COURSE_END_DATE as 과정기간,
        h.CLASSROOM_NAME as 강의실,
       CASE
          WHEN 수강현황 = '수료' THEN '수료'
          WHEN 수강현황 = '중도탈락' THEN '중도탈락'
          WHEN f.COURSE_START_DATE <= sysdate AND f.COURSE_END_DATE >= sysdate THEN '수강중'
          WHEN 수강현황 IS NULL THEN '수강예정'
          END as 수강현황,
        i.STUDENT_COMPLETE_DATE 수료및중도탈락날짜
    FROM TBL_BASIC_INFO a
      INNER JOIN TBL_DETAIL_STUDENT b
        ON a.BASIC_INFO_SEQ = b.BASIC_INFO_SEQ
          INNER JOIN TBL_KEY_STUDENT_ENROLLMENT c
            ON b.DETAIL_STUDENT_SEQ = c.DETAIL_STUDENT_SEQ
              INNER JOIN TBL_STUDENT_ENROLLMENT d
                ON c.STUDENT_ENROLLMENT_SEQ = d.STUDENT_ENROLLMENT_SEQ
                  INNER JOIN TBL_KEY_ENROLLMENT_COURSE e
                    ON d.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
                      INNER JOIN TBL_COURSE f
                        ON e.COURSE_SEQ = f.COURSE_SEQ
                          INNER JOIN TBL_BASIC_COURSE g
                            ON f.BASIC_COURSE_SEQ = g.BASIC_COURSE_SEQ
                              INNER JOIN TBL_CLASSROOM h
                                ON f.CLASSROOM_SEQ = h.CLASSROOM_SEQ
                                  LEFT OUTER JOIN (SELECT  STUDENT_ENROLLMENT_SEQ as 학생번호,'수료' as 수강현황, STUDENT_COMPLETE_DATE  FROM TBL_STUDENT_COMPLETE
                                  UNION
                                  SELECT  STUDENT_ENROLLMENT_SEQ , '중도탈락', STUDENT_QUIT_DATE  FROM TBL_STUDENT_QUIT) i
                                    ON i.학생번호 = d.STUDENT_ENROLLMENT_SEQ
                                      WHERE f.COURSE_START_DATE <= sysdate AND f.COURSE_END_DATE >= sysdate;
                                      
                                      
                                      
------------------------ 중도탈락 지정
CREATE OR REPLACE PROCEDURE proc_student_quit_insert (
  pbasic_info_seq NUMBER, --기초정보seq
  presult OUT NUMBER --
)
IS
  vcount NUMBER;
  vvcount NUMBER;
  vvvcount NUMBER;
BEGIN

  -- 수강중인 교육생들만

  SELECT count(*) INTO vcount FROM vw_student_duringcourse WHERE 교육생번호 = pbasic_info_seq;

  IF vcount = 1 THEN

    SELECT 수강현황번호 INTO vvcount FROM vw_student_duringcourse WHERE 교육생번호 = pbasic_info_seq;

    INSERT INTO TBL_STUDENT_QUIT(STUDENT_QUIT_SEQ, STUDENT_QUIT_DATE, STUDENT_ENROLLMENT_SEQ)
      VALUES (student_quit_seq.nextval, sysdate, vvcount);

    SELECT COURSE_SEQ INTO vvvcount FROM TBL_KEY_ENROLLMENT_COURSE where STUDENT_ENROLLMENT_SEQ = vvcount;

    INSERT INTO TBL_KEY_STUDENT_QUIT_COURSE(COURSE_SEQ, STUDENT_QUIT_SEQ)
      VALUES (vvvcount, student_quit_seq.currval);

    presult := 1;

    END IF;
  COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;

