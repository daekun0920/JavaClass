DROP TABLE tbl_key_subject_course;
DROP TABLE tbl_key_student_quit_course;
DROP TABLE tbl_key_enrollment_course;
DROP TABLE tbl_key_complete_course;
DROP TABLE tbl_key_teacher_subject;
DROP TABLE tbl_key_standard_subject;
DROP TABLE tbl_key_grade_subject;
DROP TABLE tbl_key_student_enrollment;
DROP TABLE tbl_student_quit;
DROP TABLE tbl_student_complete;
DROP TABLE tbl_student_grade;
DROP TABLE tbl_review;
DROP TABLE tbl_attendance_status;
DROP TABLE tbl_student_attendance;
DROP TABLE tbl_student_enrollment;
DROP TABLE tbl_teacher_subject;
DROP TABLE tbl_grading_standard;
DROP TABLE tbl_subject;
DROP TABLE tbl_detail_teacher;
DROP TABLE tbl_detail_student;
DROP TABLE tbl_course;
DROP TABLE tbl_classroom_capacity;
DROP TABLE tbl_classroom;
DROP TABLE tbl_basic_book;
DROP TABLE tbl_basic_subject;
DROP TABLE tbl_basic_course;
DROP TABLE tbl_basic_info;

ALTER TABLE tbl_subject RENAME 
SELECT * FROM tbl_subject;