CREATE SEQUENCE attendance_seq START WITH 23841;

-- 학생 등원
CREATE OR REPLACE PROCEDURE proc_add_inTime
(
    pbasicseq NUMBER,
    presult OUT NUMBER
)
IS
    venrollment NUMBER;
BEGIN
    SELECT se.student_enrollment_seq 
        INTO venrollment 
            FROM tbl_student_enrollment se 
                INNER JOIN tbl_course c  
                    ON se.COURSE_SEQ = c.COURSE_SEQ
                        WHERE se.detail_student_seq = 
                            (SELECT detail_student_seq FROM tbl_detail_student WHERE basic_info_seq = pbasicseq) 
                                AND (c.course_start_date <= sysdate AND sysdate <= c.course_end_date);
    
    INSERT INTO TBL_STUDENT_ATTENDANCE 
        VALUES (attendance_seq.nextval, to_date(to_char(sysdate, 'YYYY-MM-DD hh:mi:ss'), 'YYYY-MM-DD hh:mi:ss'), null, venrollment);
    
    IF to_number(to_char(sysdate, 'HH')) < 9 THEN
        INSERT INTO TBL_ATTENDANCE_STATUS VALUES (attendance_seq.currval, '정상');
    ELSIF  to_number(to_char(sysdate, 'HH')) >= 9 THEN
        INSERT INTO TBL_ATTENDANCE_STATUS VALUES (attendance_seq.currval, '지각');
    END IF;
    
    presult := 1;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;

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
                INNER JOIN tbl_course c  
                    ON se.COURSE_SEQ = c.COURSE_SEQ
                        WHERE se.detail_student_seq = 
                            (SELECT detail_student_seq FROM tbl_detail_student WHERE basic_info_seq = pbasicseq) 
                                AND (c.course_start_date <= vcurrTime AND vcurrTime <= c.course_end_date);
   
   SELECT tbl_student_attendance_seq, attendance_in_time
    INTO vattendance, vinTime
        FROM (SELECT sa.* FROM tbl_student_attendance sa WHERE sa.student_enrollment_seq = venrollment ORDER BY sa.tbl_student_attendance_seq DESC) 
            WHERE rownum = 1;
  
   
    UPDATE TBL_STUDENT_ATTENDANCE SET attendance_out_time = to_date(to_char(vcurrTime, 'YYYY-MM-DD hh:mi:ss'), 'YYYY-MM-DD hh:mi:ss') 
        WHERE to_char(attendance_in_time, 'YYYY-MM-DD') = to_char(vcurrTime, 'YYYY-MM-DD')
            AND tbl_student_attendance_seq = vattendance;  
    
    
    IF to_number(to_char(vcurrTime, 'HH')) < 6 THEN
        UPDATE TBL_ATTENDANCE_STATUS SET attendance_status = '조퇴' WHERE TBL_STUDENT_ATTENDANCE_SEQ = vattendance;
    END IF;
    
    presult := 1;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
    ROLLBACK;
END;