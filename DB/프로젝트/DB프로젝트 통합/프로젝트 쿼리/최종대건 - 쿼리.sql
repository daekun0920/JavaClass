-- [시험 관리 및 성적 조회 공통]
-- - 전체 개설 과정 정보를 출력할 경우 등록된 개설 과정 정보(과정명, 강의실, 수강인원)를 출력한다.
-- - 특정 개설 과정의 정보를 출력하는 경우 위 출력된 전체 개설 과정 정보 목록을 바탕으로 한 과정을 번호로 선택하여 출력한다.
-- - 특정 개설 과정 정보 출력 시 해당 과정에 등록된 개설 과목 정보(과목명, 개설 과목 기간, 교사명)와 개설 과목 별 성적 등록 여부, 시험 날짜 등록 여부를 확인 할 수 있다.


-- 전체 개설 과정 조회
CREATE OR REPLACE VIEW vw_every_course
AS
SELECT c.course_seq as 과정번호, 
       bc.BASIC_COURSE_NAME as 과정명,
       c.course_start_date as 과정시작일,
       c.course_end_date as 과정종료일, 
       (SELECT count(*) 
          FROM tbl_student_enrollment s 
            INNER JOIN TBL_KEY_ENROLLMENT_COURSE ec 
                ON s.STUDENT_ENROLLMENT_SEQ = ec.student_enrollment_seq 
                    WHERE ec.course_seq = c.course_seq) as 수강인원
        FROM tbl_course c
        INNER JOIN tbl_basic_course bc ON c.basic_course_seq = bc.BASIC_COURSE_SEQ;



-- 개설 과목 별 성적등록 여부, 시험날짜 등록 여부
CREATE OR REPLACE PROCEDURE proc_if_grade_test
(
    p_course_seq NUMBER,
    p_cursor OUT SYS_REFCURSOR 
)
IS
BEGIN
    OPEN p_cursor FOR
    SELECT bs.BASIC_SUBJECT_NAME as 과목명,
           s.subject_start_date as 과목시작일,
           s.subject_end_date as 과목종료일,
           CASE
             WHEN (SELECT count(*) FROM tbl_key_grade_subject WHERE subject_seq = s.subject_seq) > 0 THEN '성적 등록 완료'
             ELSE '성적 등록 미완료'
           END as 성적등록여부,
           CASE 
             WHEN gs.exam_date is not NULL THEN '시험 날짜 등록 완료'
             ELSE '시험 날짜 미등록'
           END as 시험날짜등록여부
    FROM tbl_subject s 
        INNER JOIN tbl_basic_subject bs 
            ON s.basic_subject_seq = bs.BASIC_SUBJECT_SEQ 
                INNER JOIN TBL_KEY_STANDARD_SUBJECT ss 
                    ON s.subject_seq = ss.subject_seq 
                        INNER JOIN tbl_grading_standard gs
                            ON ss.grading_standard_seq = gs.grading_standard_seq
                                INNER JOIN tbl_key_subject_course sc
                                    ON sc.subject_seq = s.subject_seq
                                        INNER JOIN tbl_course c 
                                            ON c.course_seq = sc.course_seq
                                                INNER JOIN tbl_basic_course bc
                                                    ON bc.basic_course_seq = c.basic_course_seq
                                                         WHERE c.course_seq = p_course_seq
                                                            ORDER BY s.SUBJECT_START_DATE, bs.BASIC_SUBJECT_NAME;
END;

-- [성적]
-- - 성적 정보 출력시 개설 과목별, 교육생 개인별 중 선택하여 해당 조건에 맞춰 출력 할 수 있다.
-- - 과목별 출력 시 해당 과목이 속한 과정명, 개설 과정기간, 강의실명, 개설 과목명, 교사명, 교재명 등을 출력한다.
-- - 위 출력된 모든 과목 목록을 바탕으로 한 과목을 선택하여 밑의 교육생들의 성적 정보를 출력한다.
-- - 해당 개설 과목을 수강한 모든 교육생들의 성적 정보(교육생 이름, 주민번호 뒷자리, 출력, 필기, 실기)를 출력한다.
-- - 교육생 개인별 출력 시 전체 교육생 정보를 출력하여 해당 교육생 정보(이름, 주민번호, 수강 과정명, 과정기간, 강의실명) 를 출력한다.
-- - 위의 전체 교육생 정보를 출력 받은 그 목록을 토대로 선택하여 교육생 개인별 출력을 할 수 있다.
-- - 교육생 개인별 출력 시 교육생 개인이 수강한 모든 개설 과목에 대한 성적 정보(개설 과목명, 개설 과목 기간, 교사명, 출력, 필기, 실기)와 위의 전체 교육생 정보에 포함되었던 정보와 같이 출력한다.


-- - 과목별 출력 시 해당 과목이 속한 과정명, 개설 과정기간, 강의실명, 개설 과목명, 교사명, 교재명 등을 출력한다.

CREATE OR REPLACE VIEW vw_subject_grade
AS
SELECT s.SUBJECT_SEQ as 과목번호,
        bs.BASIC_SUBJECT_NAME as 과목명,
        bb.BASIC_BOOK_NAME as 교재명,
        cl.CLASSROOM_NAME as 강의실,
        dt.TEACHER_NAME as 교사명,
        bc.BASIC_COURSE_NAME as 과정명,
        c.COURSE_START_DATE as 과정시작일,
        c.COURSE_END_DATE as 과정종료일
            FROM tbl_subject s 
                INNER JOIN tbl_basic_subject bs     
                    ON s.basic_subject_seq = bs.BASIC_SUBJECT_SEQ 
                        INNER JOIN tbl_basic_book bb
                             ON bb.basic_book_seq = s.basic_book_seq
                                INNER JOIN tbl_key_subject_course sc
                                    ON sc.SUBJECT_SEQ = s.SUBJECT_SEQ
                                        INNER JOIN tbl_course c
                                            ON c.COURSE_SEQ = sc.COURSE_SEQ
                                                INNER JOIN tbl_classroom cl
                                                    ON cl.CLASSROOM_SEQ = c.CLASSROOM_SEQ
                                                        INNER JOIN tbl_key_teacher_subject kts
                                                            ON kts.subject_seq = s.subject_seq
                                                                INNER JOIN tbl_detail_teacher dt
                                                                    ON dt.detail_teacher_seq = kts.detail_teacher_seq
                                                                        INNER JOIN tbl_basic_course bc
                                                                            ON bc.basic_course_seq = c.basic_course_seq
                                                                                ORDER BY s.subject_seq ASC;



-- - 출력된 모든 과목 목록을 바탕으로 한 과목을 선택하여 밑의 교육생들의 성적 정보를 출력한다.

CREATE OR REPLACE PROCEDURE proc_students_grade
(
    pseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
SELECT ds.STUDENT_NAME as 학생명,
        bi.SSN as 주민번호,  
        sg.STUDENT_GRADE_ATTENDANCE as 출결,
        sg.STUDENT_GRADE_WRITING as 필기,
        sg.STUDENT_GRADE_PRACTICAL as 실기
        FROM tbl_detail_student ds 
            INNER JOIN tbl_basic_info bi 
            ON ds.BASIC_INFO_SEQ = bi.BASIC_INFO_SEQ
                    INNER JOIN TBL_KEY_STUDENT_ENROLLMENT kse
                    ON kse.DETAIL_STUDENT_SEQ = ds.DETAIL_STUDENT_SEQ
                            INNER JOIN tbl_student_enrollment se
                            ON se.STUDENT_ENROLLMENT_SEQ = kse.STUDENT_ENROLLMENT_SEQ
                                    INNER JOIN tbl_student_grade sg
                                    ON sg.STUDENT_ENROLLMENT_SEQ = se.STUDENT_ENROLLMENT_SEQ
                                            INNER JOIN tbl_key_grade_subject kgs
                                            ON kgs.STUDENT_GRADE_SEQ = sg.STUDENT_GRADE_SEQ
                                                    INNER JOIN tbl_subject s
                                                    ON s.SUBJECT_SEQ = kgs.SUBJECT_SEQ 
                                                            INNER JOIN tbl_basic_subject bs
                                                            ON bs.BASIC_SUBJECT_SEQ = s.BASIC_SUBJECT_SEQ
                                                                    WHERE s.SUBJECT_SEQ = pseq
                                                                        ORDER BY 학생명 ASC;
END;



-- - 교육생 개인별 출력 시 이미 끝난 & 현재 교육생 정보를 출력하여 해당 교육생 정보(이름, 주민번호, 수강 과정명, 과정기간, 강의실명) 를 출력한다.
-- - 교육생 정보를 출력 받은 그 목록을 토대로 선택하여 교육생 개인별 출력을 할 수 있다.(개설 과목명, 개설 과목 기간, 교사명, 출력, 필기, 실기)
-- - 중도포기 학생은 제외하고 출력한다

CREATE OR REPLACE VIEW vw_curr_past_students
AS
SELECT bi.basic_info_seq as 회원번호,
       ds.STUDENT_NAME as 학생이름,
       bi.ssn as 주민등록번호,
       bc.basic_course_name as 과정명,
       c.course_start_date as 과정시작일,
       c.course_end_date as 과정종료일,
       cl.CLASSROOM_NAME as 강의실명
    FROM tbl_basic_info bi 
        INNER JOIN tbl_detail_student ds 
        ON bi.BASIC_INFO_SEQ = ds.BASIC_INFO_SEQ 
                INNER JOIN tbl_key_student_enrollment kse
                ON kse.detail_student_seq = ds.detail_student_seq
                        INNER JOIN tbl_student_enrollment se 
                        ON se.student_enrollment_seq = kse.student_enrollment_seq
                                INNER JOIN tbl_key_enrollment_course kec
                                ON kec.student_enrollment_seq = se.student_enrollment_seq
                                        INNER JOIN tbl_course c 
                                        ON c.course_seq = kec.course_seq
                                                INNER JOIN tbl_basic_course bc
                                                ON c.basic_course_seq = bc.basic_course_seq
                                                        INNER JOIN tbl_classroom cl
                                                        ON cl.classroom_seq = c.classroom_seq
                                                                WHERE c.COURSE_START_DATE < sysdate AND
                                                                    (SELECT count(*) FROM tbl_student_quit WHERE student_enrollment_seq = se.STUDENT_ENROLLMENT_SEQ) = 0
                                                                        ORDER BY 회원번호 ASC;

CREATE OR REPLACE PROCEDURE proc_stu_sub_grade
(
    pseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
SELECT bs.BASIC_SUBJECT_NAME as 개설과목명,
       s.subject_start_date as 과목시작일,
       s.subject_end_date as 과목종료일, 
       dt.teacher_name as 교사명,
       sg.student_grade_attendance as 출결,
       sg.student_grade_writing as 필기,
       sg.student_grade_practical as 실기
    FROM tbl_subject s 
        INNER JOIN tbl_basic_subject bs 
        ON s.basic_subject_seq = bs.basic_subject_seq
            INNER JOIN tbl_key_teacher_subject kts
            ON kts.subject_seq = s.subject_seq
                INNER JOIN tbl_detail_teacher dt
                ON dt.detail_teacher_seq = kts.detail_teacher_seq
                    INNER JOIN tbl_key_grade_subject kgs
                    ON kgs.subject_seq = s.subject_seq
                        INNER JOIN tbl_student_grade sg
                        ON sg.student_grade_seq = kgs.student_grade_seq
                            INNER JOIN tbl_student_enrollment se
                            ON se.STUDENT_ENROLLMENT_SEQ = sg.STUDENT_ENROLLMENT_SEQ
                                INNER JOIN tbl_key_student_enrollment kse
                                ON kse.STUDENT_ENROLLMENT_SEQ = se.STUDENT_ENROLLMENT_SEQ
                                    INNER JOIN tbl_detail_student ds
                                    ON ds.DETAIL_STUDENT_SEQ = kse.DETAIL_STUDENT_SEQ
                                        INNER JOIN tbl_basic_info bi 
                                        ON bi.basic_info_seq = ds.BASIC_INFO_SEQ
                                             INNER JOIN tbl_detail_student ds
                                                ON ds.BASIC_INFO_SEQ = bi.BASIC_INFO_SEQ
                                                    WHERE bi.BASIC_INFO_SEQ = pseq;
END;                                      

-- - 전체 개설 과정 목록을 출력하여 그 목록에서 특정 개설 과정을 선택하는 경우
-- - 해당 개설 과정을 수강하는 모든 교육생의 출결을 일정 기간을 입력하여 조회할 수 있어야 한다.
-- - 모든 출결 조회는 근태 상황을 구분할 수 있어야 한다.(정상, 지각, 조퇴, 외출, 병가, 기타) -- 외출, 병가는 관리자 소관

CREATE OR REPLACE PROCEDURE proc_attendance_search
(
    pseq IN NUMBER,
    pstartdate IN DATE,
    penddate IN DATE,
    pcursor OUT SYS_REFCURSOR

)
IS
BEGIN
OPEN pcursor FOR
SELECT bi.basic_info_seq as 회원번호,
       ds.student_name as 학생명,
       ds.student_tel as 전화번호, 
       sa.attendance_in_time as 등원시간,
       sa.attendance_out_time as 하원시간,
       ts.ATTENDANCE_STATUS as 근태상황
       FROM tbl_detail_student ds
        INNER JOIN tbl_key_student_enrollment kse
            ON kse.detail_student_seq = ds.detail_student_seq
                INNER JOIN tbl_student_enrollment se
                    ON se.student_enrollment_seq = kse.student_enrollment_seq
                        INNER JOIN tbl_student_attendance sa 
                            ON se.student_enrollment_seq = sa.student_enrollment_seq
                                INNER JOIN tbl_attendance_status ts
                                    ON ts.student_attendance_seq = sa.student_attendance_seq
                                        INNER JOIN tbl_key_enrollment_course kec
                                        ON kec.student_enrollment_seq = se.STUDENT_ENROLLMENT_SEQ
                                            INNER JOIN tbl_course c
                                            ON c.course_seq = kec.course_seq
                                                INNER JOIN tbl_basic_course bc
                                                ON c.basic_course_seq = bc.BASIC_COURSE_SEQ
                                                    INNER JOIN tbl_basic_info bi
                                                    ON bi.basic_info_seq = ds.basic_info_seq
                                                        WHERE (c.course_seq = pseq) AND (pstartdate <= sa.ATTENDANCE_IN_TIME AND sa.ATTENDANCE_OUT_TIME <= penddate);
END;                                            -- 과정 시퀀스와 각 날짜는 매개변수이다 (자바에서 직접 입력받는다, 선 과정 번호 입력 or 과정명 입력 후 기간 입력 받기 (연, 월 , 일 별로 입력받기 )







-- - 위에서 특정 학생의 번호를 입력하여 해당 학생의 기본 정보와 출결 현황을 조회 할 수 있다.

-- 같이쓰는 보조기능 -- "해당 학생의 출결날짜 목록 출력"
-- 정상, 지각, 조퇴를 제외한 외출과 병가는 학생 번호와 날짜를 선택 받아 관리자 권한으로만 지정할 수 있다.
-- (먼저 과거 & 현재 학생 목록 출력하여 학생 선택 후 -> "해당 학생의 출결날짜 목록 출력" -> 한 날짜 선택)
CREATE OR REPLACE PROCEDURE proc_personal_attendance
(
    pbasicseq IN NUMBER,
    pcursor OUT SYS_REFCURSOR 
)
IS
BEGIN
OPEN pcursor FOR
SELECT
       sa.STUDENT_ATTENDANCE_SEQ as 출결번호,
       ds.student_name as 학생명,
       bc.BASIC_COURSE_NAME as 과정명, 
       sa.ATTENDANCE_IN_TIME as 등원시간,
       sa.ATTENDANCE_OUT_TIME as 하원시간,
       ts.ATTENDANCE_STATUS as 근태상황
    FROM tbl_detail_student ds 
        INNER JOIN tbl_key_student_enrollment kse 
        ON ds.detail_student_seq = kse.DETAIL_STUDENT_SEQ
            INNER JOIN tbl_student_enrollment se
            ON se.STUDENT_ENROLLMENT_SEQ = kse.STUDENT_ENROLLMENT_SEQ
                INNER JOIN tbl_student_attendance sa
                ON sa.STUDENT_ENROLLMENT_SEQ = se.student_enrollment_seq
                    INNER JOIN tbl_attendance_status ts
                    ON ts.student_attendance_Seq = sa.student_attendance_Seq 
                        INNER JOIN tbl_basic_info bi
                        ON bi.BASIC_INFO_SEQ = ds.BASIC_INFO_SEQ
                            INNER JOIN tbl_key_enrollment_course kec
                            ON kec.STUDENT_ENROLLMENT_SEQ = se.STUDENT_ENROLLMENT_SEQ
                                INNER JOIN tbl_course c
                                ON c.COURSE_SEQ = kec.course_seq
                                    INNER JOIN tbl_basic_course bc
                                    ON bc.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
                                        WHERE bi.basic_info_seq = pbasicseq;
END;


-- 강의 스케쥴 조회 메뉴를 선택한 이후의 화면
-- 개설 과정, 개설 과목을 조인한 뷰에서 교사 본인의 고유 정보를 포함하는 레코드 즉 교사와 관련된 강의 레코드를 SELECT 한다.
-- 해당 정보에는 아래와 같은 컬럼이 포함되어 있다.
-- <과목번호, 과목명, 과목시작일, 과목종료일, 과정명, 과정시작일, 과정종료일, 교재명
-- 교육생 등록 인원>
--
-- ->강의 종료 / 강의 중 / 강의 예정의 구별은 현재 시각을 과목 시작일과 종료일과 비교하여 나타낸다.

CREATE OR REPLACE PROCEDURE proc_teacher_schedule
(
    pseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
SELECT s.subject_seq as 과목번호,
       bs.basic_subject_name as 과목명,
       s.subject_start_date as 과목시작일,
       s.subject_end_date as 과목종료일,
       bc.BASIC_COURSE_NAME as 과정명,
       c.COURSE_START_DATE as 과정시작일,
       c.COURSE_END_DATE as 과정종료일,
       bb.basic_book_name as 교재명,
       cl.CLASSROOM_NAME as 강의실,
       (SELECT count(*) FROM TBL_KEY_ENROLLMENT_COURSE WHERE COURSE_SEQ = c.COURSE_SEQ) as 학생수,
        CASE
            WHEN s.SUBJECT_END_DATE < sysdate THEN '강의 종료'
            WHEN s.SUBJECT_START_DATE <= sysdate AND sysdate <= s.SUBJECT_END_DATE THEN '강의 중'
            WHEN s.SUBJECT_START_DATE > sysdate THEN '강의 예정'
            ELSE '알수없음'
        END as 과목진행상황
    FROM tbl_subject s
        INNER JOIN tbl_basic_subject bs 
        ON bs.basic_subject_seq = s.basic_subject_seq
                INNER JOIN tbl_key_subject_course ksc
                ON ksc.subject_seq = s.subject_seq
                        INNER JOIN tbl_course c
                        ON c.course_seq = ksc.course_seq
                                INNER JOIN tbl_basic_course bc
                                ON bc.basic_course_seq = c.basic_course_seq
                                        INNER JOIN tbl_basic_book bb
                                        ON bb.basic_book_seq = s.basic_book_seq
                                                INNER JOIN tbl_classroom cl
                                                ON cl.classroom_seq = c.classroom_seq
                                                        INNER JOIN tbl_key_teacher_subject kts
                                                        ON kts.subject_seq = s.subject_seq
                                                                INNER JOIN tbl_detail_teacher dt
                                                                ON dt.detail_teacher_seq = kts.detail_teacher_seq
                                                                        INNER JOIN tbl_basic_info bi
                                                                        ON bi.BASIC_INFO_SEQ = dt.BASIC_INFO_SEQ
                                                                                WHERE bi.BASIC_INFO_SEQ = pseq
                                                                                    ORDER BY 과목번호 ASC;
END;



---- 학생 강의평 조회, 삭제 
CREATE OR REPLACE VIEW vw_review
AS
SELECT r.STUDENT_ENROLLMENT_SEQ as 수강평번호, bc.BASIC_COURSE_NAME as 과정명, r.COURSE_REVIEW as 수강평
    FROM tbl_review r 
        INNER JOIN tbl_student_enrollment se 
            ON r.student_enrollment_seq = se.student_enrollment_seq
                INNER JOIN tbl_key_enrollment_course kec
                    ON kec.student_enrollment_seq = se.STUDENT_ENROLLMENT_SEQ
                        INNER JOIN tbl_course c
                            ON c.COURSE_SEQ = kec.COURSE_SEQ
                                INNER JOIN tbl_basic_course bc
                                    ON bc.basic_course_seq = c.basic_course_seq;

-- 강의평 삭제
CREATE OR REPLACE PROCEDURE proc_delete_review 
(
    pseq IN NUMBER,
    presult OUT NUMBER
)
IS
    vcount NUMBER;
BEGIN
    SELECT count(*) INTO vcount FROM tbl_review WHERE student_enrollment_seq = pseq;
    
    IF vcount = 1 THEN
    
        DELETE FROM tbl_review WHERE student_enrollment_seq = pseq;
        presult := 1;
        COMMIT;
        
    ELSE
        presult := 0;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
    presult := 2;
    ROLLBACK;
END;

