-- 1번 테이블ㅋ
CREATE TABLE tbl_basic_info
(
  basic_info_seq NUMBER PRIMARY KEY NOT NULL ,
  id VARCHAR2(20) NOT NULL ,
  ssn VARCHAR2(30) NOT NULL ,
  type VARCHAR2(20) NOT NULL
);


-- 2번 테이블 ㅎ
CREATE TABLE tbl_basic_course
(
  basic_course_seq NUMBER PRIMARY KEY NOT NULL,
  basic_course_name VARCHAR2(50) NOT NULL
);


-- 3번 테이블 ㄷㄷ
CREATE TABLE tbl_basic_subject
(
  basic_subject_seq NUMBER PRIMARY KEY NOT NULL,
  basic_subject_name VARCHAR2(50) NOT NULL
);


-- 4번 테이블 ㅋㅋ
CREATE TABLE tbl_basic_book
(
  basic_book_seq NUMBER PRIMARY KEY NOT NULL,
  basic_book_name VARCHAR2(50) NOT NULL,
  basic_book_publisher VARCHAR2(30) NOT NULL
);


--5번 테이블
CREATE TABLE tbl_classroom
(
  classroom_seq NUMBER PRIMARY KEY NOT NULL,
  classroom_name VARCHAR2(20) NOT NULL
);


-- 6번 테이블
CREATE TABLE tbl_classroom_capacity
(
  classroom_seq NUMBER REFERENCES tbl_classroom (classroom_seq) PRIMARY KEY NOT NULL,
  capacity NUMBER NOT NULL
);


-- 7번 테이블
CREATE TABLE tbl_course
(
  course_seq NUMBER PRIMARY KEY NOT NULL,
  course_start_date DATE NOT NULL,
  course_end_date DATE NOT NULL,
  classroom_seq NUMBER REFERENCES tbl_classroom (classroom_seq) NOT NULL,
  basic_course_seq NUMBER REFERENCES tbl_basic_course (basic_course_seq) NOT NULL
);


-- 8번 테이블
CREATE TABLE tbl_detail_student
(
  detail_student_seq NUMBER PRIMARY KEY NOT NULL,
  student_name VARCHAR2(10) NOT NULL,
  student_tel VARCHAR2(30) NULL,
  student_regdate DATE DEFAULT sysdate NOT NULL,
  basic_info_seq NUMBER REFERENCES tbl_basic_info (basic_info_seq) NOT NULL
);


-- 9번 테이블
CREATE TABLE tbl_detail_teacher
(
  detail_teacher_seq NUMBER PRIMARY KEY NOT NULL,
  teacher_name VARCHAR2(10) NOT NULL,
  teacher_tel VARCHAR2(20) NULL,
  basic_info_seq NUMBER REFERENCES tbl_basic_info (basic_info_seq) NOT NULL
);


-- 10번 테이블
CREATE TABLE tbl_subject
(
  subject_seq NUMBER PRIMARY KEY NOT NULL,
  subject_start_date DATE NOT NULL,
  subject_end_date DATE NOT NULL,
  course_seq NUMBER REFERENCES tbl_course (course_seq) NOT NULL,
  basic_subject_seq NUMBER REFERENCES tbl_basic_subject (basic_subject_seq) NOT NULL,
  basic_book NUMBER REFERENCES tbl_basic_book (basic_book_seq) NOT NULL,
  detail_teacher NUMBER REFERENCES tbl_detail_teacher (detail_teacher_seq) NOT NULL
);


-- 11번 테이블
CREATE TABLE tbl_grading_standard
(
  subject_seq NUMBER REFERENCES tbl_subject (subject_seq) NOT NULL,
  grading_attendance NUMBER NULL,
  grading_writing NUMBER NULL,
  grading_practical NUMBER NULL,
  exam_date DATE NULL
);


-- 12번 테이블
CREATE TABLE tbl_teacher_subject
(
  detail_teacher_seq NUMBER REFERENCES tbl_detail_teacher (detail_teacher_seq) NOT NULL,
  basic_subject_seq NUMBER REFERENCES tbl_basic_subject (basic_subject_seq) NOT NULL
);


-- 13번 테이블
CREATE TABLE tbl_student_enrollment
(
  student_enrollment_seq NUMBER PRIMARY KEY NOT NULL,
  detail_teacher_seq NUMBER REFERENCES tbl_detail_teacher (detail_teacher_seq) NOT NULL,
  basic_subject_seq NUMBER REFERENCES tbl_basic_subject (basic_subject_seq) NOT NULL
);


-- 14번 테이블
CREATE TABLE tbl_student_attendance
(
  attendance_in_time DATE NULL,
  attendance_out_time DATE NULL,
  student_enrollment_seq NUMBER REFERENCES tbl_student_enrollment (student_enrollment_seq) NOT NULL
);


-- 15번 테이블
CREATE TABLE tbl_review
(
  student_enrollment_seq NUMBER NOT NULL,
  course_review VARCHAR2(300) NOT NULL
);


-- 16번 테이블
CREATE TABLE tbl_student_grade
(
  subject_seq NUMBER REFERENCES tbl_subject (subject_seq) NOT NULL,
  student_grade_attendance NUMBER NULL,
  student_grade_writing NUMBER NULL,
  student_grade_practical NUMBER NULL,
  student_enrollment_seq NUMBER REFERENCES tbl_student_enrollment (student_enrollment_seq) NOT NULL

);

-- 17번 테이블
CREATE TABLE tbl_student_complete
(
  student_complete_seq NUMBER PRIMARY KEY NOT NULL,
  student_complete_date DATE NOT NULL,
  course_seq NUMBER REFERENCES tbl_course (course_seq) NOT NULL,
  student_enrollment_seq NUMBER REFERENCES tbl_student_enrollment (student_enrollment_seq) NOT NULL
);


-- 18번 테이블
CREATE TABLE tbl_student_quit
(
  student_quit_seq NUMBER PRIMARY KEY NOT NULL,
  student_quit_date DATE NOT NULL,
  course_seq NUMBER REFERENCES tbl_course (course_seq) NOT NULL,
  student_enrollment NUMBER REFERENCES tbl_student_enrollment (student_enrollment_seq) NOT NULL
);









