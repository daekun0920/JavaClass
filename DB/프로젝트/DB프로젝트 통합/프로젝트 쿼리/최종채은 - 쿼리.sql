
--WHERE 절로 basic_info_seq  = ?붙이면 

--[학생의 개인 과목 / 점수를 출력하기 위한 뷰]

CREATE OR REPLACE VIEW vw_subject_forstudent
AS
SELECT 
b.BASIC_INFO_SEQ AS basic_info_seq,
b.STUDENT_NAME AS 교육생이름,
k.BASIC_SUBJECT_SEQ AS 과목번호,
k.BASIC_SUBJECT_NAME AS 과목명,
to_char(j.SUBJECT_START_DATE,'yyyy-mm-dd') ||'-'|| to_char(j.SUBJECT_END_DATE,'yyyy-mm-dd') AS 과목기간,
'['||l.BASIC_BOOK_PUBLISHER||']'||l.BASIC_BOOK_NAME AS 교재명,
n.TEACHER_NAME AS 교사명,
s.GRADING_ATTENDANCE AS 출석배점,
s.GRADING_WRITING AS 필기배점,
s.GRADING_PRACTICAL AS 실기배점,
r.student_grade_attendance AS 출석점수,
r.STUDENT_GRADE_WRITING AS 필기점수,
r.STUDENT_GRADE_PRACTICAL AS 실기점수,
substr(s.EXAM_DATE,1,10) AS 시험일
FROM tbl_basic_info a --회원기초정보
INNER JOIN tbl_detail_student b -- 학생상세정보
ON a.basic_info_seq = b.BASIC_INFO_SEQ
INNER JOIN tbl_key_student_enrollment c -- 교육수강현황/학생상세키
ON b.detail_student_seq = c.detail_student_seq
INNER JOIN tbl_student_enrollment d --교육생 수강현황
ON d.student_enrollment_seq = c.student_enrollment_seq
INNER JOIN tbl_key_enrollment_course e -- 교육생 수강현황/과정키
ON d.student_enrollment_seq = e.student_enrollment_seq
INNER JOIN tbl_course f -- 과정
ON f.course_seq = e.course_seq
INNER JOIN tbl_basic_course z -- 기초 과정정보
ON f.basic_course_seq = z.basic_course_seq
INNER JOIN TBL_STUDENT_GRADE r -- 학생성적
ON r.STUDENT_ENROLLMENT_SEQ = d.STUDENT_ENROLLMENT_SEQ
INNER JOIN TBL_KEY_GRADE_SUBJECT q --학생성적/과목키
ON q.STUDENT_GRADE_SEQ = r.STUDENT_GRADE_SEQ
INNER JOIN TBL_SUBJECT j -- 과목
ON j.SUBJECT_SEQ = q.SUBJECT_SEQ
INNER JOIN TBL_BASIC_SUBJECT k -- 기초과목정보
ON k.BASIC_SUBJECT_SEQ = j.SUBJECT_SEQ 
INNER JOIN TBL_BASIC_BOOK l-- 책기초정보
ON j.basic_book_seq = l.basic_book_seq 
INNER JOIN TBL_KEY_TEACHER_SUBJECT m --선생님 상세정보/과목키
ON j.SUBJECT_SEQ= m.SUBJECT_SEQ
INNER JOIN TBL_DETAIL_TEACHER n--선생님 상세정보
ON m.DETAIL_TEACHER_SEQ = n.DETAIL_TEACHER_SEQ
INNER JOIN TBL_KEY_STANDARD_SUBJECT w --배점정보/과목키
ON w.SUBJECT_SEQ =j.SUBJECT_SEQ 
INNER JOIN TBL_GRADING_STANDARD s
ON w.GRADING_STANDARD_SEQ = s.GRADING_STANDARD_SEQ;

---------------------------------------------------------------------------------

--WHERE 절로 basic_info_seq  = ?붙이면 

--[학생의 개인 정보 / 과정을 출력하기 위한 뷰]


CREATE OR REPLACE VIEW vw_course_forstudent
AS
SELECT
a.BASIC_INFO_SEQ AS basic_info_seq,
b.student_name AS 교육생이름,
b.STUDENT_TEL AS 전화번호,
to_char(b.STUDENT_REGDATE,'yyyy-mm-dd') AS 등록일,
h.BASIC_COURSE_NAME AS 과정명,
to_char(f.COURSE_START_DATE,'yyyy-mm-dd') || '-' || to_char(f.COURSE_END_DATE,'yyyy-mm-dd') AS 과정기간,
g.CLASSROOM_NAME AS 강의실

FROM tbl_basic_info a --회원기초정보
INNER JOIN tbl_detail_student b -- 학생상세정보
ON a.basic_info_seq = b.detail_student_seq
INNER JOIN tbl_key_student_enrollment c -- 교육수강현황/학생상세키
ON b.detail_student_seq = c.detail_student_seq
INNER JOIN tbl_student_enrollment d --교육생 수강현황
ON d.student_enrollment_seq = c.student_enrollment_seq
INNER JOIN tbl_key_enrollment_course e -- 교육생 수강현황/과정키
ON d.student_enrollment_seq = e.student_enrollment_seq
INNER JOIN tbl_course f -- 과정
ON e.course_seq = f.course_seq
INNER JOIN tbl_classroom g --강의실
ON g.classroom_seq = f.classroom_seq
INNER JOIN tbl_basic_course h -- 기초과정정보
ON h.basic_course_seq  = f.basic_course_seq;


------------------------------------------------------------------------------

--출결 전체를 볼수있는 뷰 생성 

--WHERE 절로 basic_info_seq  = ?붙이면 [학생의 개인 출결을 출력하기 위한 뷰]


CREATE OR REPLACE VIEW vw_attendance_list_forstudent AS SELECT a.basic_info_seq AS basic_info_seq,b.student_name AS 학생이름,e.attendance_in_time AS 등원시간,e.ATTENDANCE_OUT_TIME AS 하원시간,f.ATTENDANCE_STATUS AS 출결상태 FROM tbl_basic_info a INNER JOIN tbl_detail_student b ON a.basic_info_seq = b.BASIC_INFO_SEQ INNER JOIN tbl_key_student_enrollment c ON b.detail_student_seq = c.detail_student_seq INNER JOIN tbl_student_enrollment d ON c.student_enrollment_seq  = d.student_enrollment_seq INNER JOIN TBL_STUDENT_ATTENDANCE e  ON d.student_enrollment_seq = e.student_enrollment_seq  INNER JOIN TBL_ATTENDANCE_STATUS f   ON e.STUDENT_ATTENDANCE_SEQ =f.STUDENT_ATTENDANCE_SEQ;



------------------------------------------------------------------------



-- 학생 하원
CREATE OR REPLACE PROCEDURE proc_attendance_outTime
(
    pbasicseq NUMBER,
    presult OUT NUMBER
)
IS
    venrollment NUMBER;
    vattendance NUMBER;
    vinTime DATE;
    vcurrTime DATE;
BEGIN
   vcurrTime := sysdate;

   SELECT se.student_enrollment_seq 
        INTO venrollment 
            FROM tbl_student_enrollment se 
                INNER JOIN tbl_key_enrollment_course kec
                    ON kec.STUDENT_ENROLLMENT_SEQ = se.STUDENT_ENROLLMENT_SEQ
                        INNER JOIN tbl_course c  
                            ON kec.COURSE_SEQ = c.COURSE_SEQ
                                INNER JOIN tbl_key_student_enrollment kse
                                    ON kse.STUDENT_ENROLLMENT_SEQ = se.STUDENT_ENROLLMENT_SEQ
                                        WHERE kse.detail_student_seq = 
                                            (SELECT detail_student_seq FROM tbl_detail_student WHERE basic_info_seq = pbasicseq); 
                                                --AND (c.course_start_date <= vcurrTime AND vcurrTime <= c.course_end_date);
                   
   SELECT student_attendance_seq, attendance_in_time
    INTO vattendance, vinTime
        FROM (SELECT * FROM tbl_student_attendance WHERE student_enrollment_seq = venrollment ORDER BY student_attendance_seq DESC) 
            WHERE rownum = 1;
  
   
    UPDATE TBL_STUDENT_ATTENDANCE SET attendance_out_time = to_date(to_char(vcurrTime, 'YYYY-MM-DD hh:mi:ss'), 'YYYY-MM-DD hh:mi:ss') 
        WHERE to_char(attendance_in_time, 'YYYY-MM-DD') = to_char(vcurrTime, 'YYYY-MM-DD')
            AND student_attendance_seq = vattendance;  
    
    
    IF to_number(to_char(vcurrTime, 'HH')) < 6 THEN
        UPDATE TBL_ATTENDANCE_STATUS SET attendance_status = '조퇴' WHERE STUDENT_ATTENDANCE_SEQ = vattendance;
    END IF;
    
    presult := 1;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;

------------------------------------------------------------------------------
-- 학생 등원

CREATE OR REPLACE PROCEDURE proc_add_inTime
(
    pbasicseq NUMBER,
    presult OUT NUMBER
)
IS
    venrollment NUMBER;
    vcount NUMBER;
   
BEGIN
    
    
    SELECT se.student_enrollment_seq 
        INTO venrollment 
            FROM tbl_student_enrollment se 
                INNER JOIN tbl_key_enrollment_course kec
                    ON se.STUDENT_ENROLLMENT_SEQ = kec.STUDENT_ENROLLMENT_SEQ
                        INNER JOIN tbl_course c  
                            ON kec.COURSE_SEQ = c.COURSE_SEQ
                                INNER JOIN tbl_key_student_enrollment kse
                                    ON kse.student_enrollment_seq = se.STUDENT_ENROLLMENT_SEQ
                                        WHERE kse.detail_student_seq = 
                                            (SELECT detail_student_seq FROM tbl_detail_student WHERE basic_info_seq = pbasicseq); 
                                               -- AND (c.course_start_date <= sysdate AND sysdate <= c.course_end_date);
            
    SELECT count(*) INTO vcount 
        FROM tbl_student_attendance 
            WHERE STUDENT_ENROLLMENT_SEQ = venrollment AND (to_char(attendance_in_time, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD'));
    
    IF vcount = 0 THEN
    
    INSERT INTO TBL_STUDENT_ATTENDANCE 
        VALUES (attendance_seq.nextval, to_date(to_char(sysdate, 'YYYY-MM-DD hh:mi:ss'), 'YYYY-MM-DD hh:mi:ss'), null, venrollment);
    
    IF to_number(to_char(sysdate, 'HH')) < 9 THEN
        INSERT INTO TBL_ATTENDANCE_STATUS VALUES (attendance_seq.currval, '정상');
    ELSIF  to_number(to_char(sysdate, 'HH')) >= 9 THEN
        INSERT INTO TBL_ATTENDANCE_STATUS VALUES (attendance_seq.currval, '지각');
    END IF;
        
    presult := 1;
    COMMIT;
    
    ELSE 
        proc_attendance_outTime(pbasicseq, presult);
        
    END IF;
    
EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;


