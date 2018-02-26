-- 수료 & 중퇴하지 않은 모든 학생 조회
SELECT d.* FROM TBL_STUDENT_ENROLLMENT s
    INNER JOIN tbl_detail_student d ON s.student_enrollment_seq = d.DETAIL_STUDENT_SEQ
        WHERE s.STUDENT_ENROLLMENT_SEQ in (SELECT STUDENT_ENROLLMENT_SEQ
                                              FROM TBL_STUDENT_ENROLLMENT
                                                  MINUS
                                                      SELECT STUDENT_ENROLLMENT_SEQ
                                                          FROM TBL_STUDENT_COMPLETE
                                                              MINUS
                                                                  SELECT STUDENT_QUIT_SEQ
                                                                        FROM tbl_student_quit);
-- 값(학생번호) 입력 받고 밑에서 매개변수를 받음
INSERT INTO TBL_STUDENT_COMPLETE
    VALUES (수료번호, 수료날짜(매개변수), (SELECT COURSE_SEQ
                                            FROM TBL_STUDENT_ENROLLMENT
                                                WHERE DETAIL_STUDENT_SEQ = 매개변수), (SELECT STUDENT_ENROLLMENT_SEQ
                                                                                          FROM TBL_STUDENT_ENROLLMENT
                                                                                              WHERE DETAIL_STUDENT_SEQ = 매개변수));


-- [시험 관리 및 성적 조회 공통]
-- - 전체 개설 과정 정보를 출력할 경우 등록된 개설 과정 정보(과정명, 강의실, 수강인원)를 출력한다.
-- - 특정 개설 과정의 정보를 출력하는 경우 위 출력된 전체 개설 과정 정보 목록을 바탕으로 한 과정을 번호로 선택하여 출력한다.
-- - 특정 개설 과정 정보 출력 시 해당 과정에 등록된 개설 과목 정보(과목명, 개설 과목 기간, 교사명)와 개설 과목 별 성적 등록 여부, 시험 문제 파일 등록 여부를 확인 할 수 있다.
--
-- [시험 관리]
-- - 모든 시험은 오프라인으로 진행하고, 실행과 결과만을 시스템으로 관리한다.
-- - 시험 실행 시 무작위의 점수를 결과로 선점해 필기와 실기 성적에 각각 대입한다.

-- 전체 개설 과정 조회
CREATE VIEW vw_every_course
AS
SELECT c.COURSE_SEQ as 과정번호,
       b.BASIC_COURSE_NAME as 과정명,
       c.COURSE_START_DATE as 과정시작일,
       c.COURSE_END_DATE as 과정종료일,
       (SELECT count(*) FROM TBL_STUDENT_ENROLLMENT s WHERE s.COURSE_SEQ = c.COURSE_SEQ) as 수강인원
    FROM tbl_course c
      INNER JOIN TBL_BASIC_COURSE b
        ON c.BASIC_COURSE_SEQ = b.BASIC_COURSE_SEQ;

SELECT * FROM vw_every_course;

-- 개설 과목 별 성적등록 여부, 시험날짜 등록 여부

SELECT DISTINCT b.BASIC_SUBJECT_NAME as 과목명, s.SUBJECT_START_DATE as 과목시작날짜, s.SUBJECT_END_DATE as 과목종료날짜, t.TEACHER_NAME as 선생님성함,
CASE
  WHEN r.STUDENT_GRADE_ATTENDANCE is NULL AND r.STUDENT_GRADE_PRACTICAL is NULL AND r.STUDENT_GRADE_WRITING is NULL THEN '성적미등록'
  ELSE '성적등록'
END as 성적등록여부,
CASE
  WHEN EXAM_DATE is null THEN '시험날짜미등록'
  ELSE '시험날짜등록'
END as 시험날짜등록여부
  FROM TBL_SUBJECT s
    INNER JOIN TBL_BASIC_SUBJECT b ON s.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
      INNER JOIN TBL_GRADING_STANDARD g ON g.SUBJECT_SEQ = s.SUBJECT_SEQ
        INNER JOIN TBL_STUDENT_GRADE r ON r.SUBJECT_SEQ = s.SUBJECT_SEQ
           INNER JOIN TBL_DETAIL_TEACHER t ON t.DETAIL_TEACHER_SEQ = s.DETAIL_TEACHER_SEQ
              INNER JOIN TBL_COURSE c ON c.COURSE_SEQ = s.COURSE_SEQ
                INNER JOIN TBL_BASIC_COURSE b ON b.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
                 WHERE s.COURSE_SEQ = 1 OR b.BASIC_COURSE_NAME = 매개변수 -- 이름이나 번호 둘 중 하나를 선택적으로 입력받을수 있게 하려고. -- 자바에서 이 쿼리 통째로 날리기(매개변수 부분만 따로 받아서)
                    ORDER BY s.SUBJECT_START_DATE ASC; -- 매개변수(과정)


-- [성적]
-- - 성적 정보 출력시 개설 과목별, 교육생 개인별 중 선택하여 해당 조건에 맞춰 출력 할 수 있다.
-- - 과목별 출력 시 해당 과목이 속한 과정명, 개설 과정기간, 강의실명, 개설 과목명, 교사명, 교재명 등을 출력한다.
-- - 위 출력된 모든 과목 목록을 바탕으로 한 과목을 선택하여 밑의 교육생들의 성적 정보를 출력한다.
-- - 해당 개설 과목을 수강한 모든 교육생들의 성적 정보(교육생 이름, 주민번호 뒷자리, 출력, 필기, 실기)를 출력한다.
-- - 교육생 개인별 출력 시 전체 교육생 정보를 출력하여 해당 교육생 정보(이름, 주민번호, 수강 과정명, 과정기간, 강의실명) 를 출력한다.
-- - 위의 전체 교육생 정보를 출력 받은 그 목록을 토대로 선택하여 교육생 개인별 출력을 할 수 있다.
-- - 교육생 개인별 출력 시 교육생 개인이 수강한 모든 개설 과목에 대한 성적 정보(개설 과목명, 개설 과목 기간, 교사명, 출력, 필기, 실기)와 위의 전체 교육생 정보에 포함되었던 정보와 같이 출력한다.


-- - 과목별 출력 시 해당 과목이 속한 과정명, 개설 과정기간, 강의실명, 개설 과목명, 교사명, 교재명 등을 출력한다.
CREATE VIEW vw_subject
AS
SELECT s.SUBJECT_SEQ 과목번호,
       e.BASIC_COURSE_NAME as 과정명,
       c.COURSE_START_DATE as 과정시작일,
       c.COURSE_END_DATE as 과정종료일,
       l.CLASSROOM_NAME as 강의실명,
       b.BASIC_SUBJECT_NAME as 과목명,
       t.TEACHER_NAME as 교사명,
       k.BASIC_BOOK_NAME as 교재명
  FROM tbl_subject s
    INNER JOIN TBL_COURSE c ON s.COURSE_SEQ = c.COURSE_SEQ
      INNER JOIN TBL_BASIC_SUBJECT b ON s.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
        INNER JOIN TBL_BASIC_COURSE e ON e.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
          INNER JOIN TBL_CLASSROOM l ON l.CLASSROOM_SEQ = c.CLASSROOM_SEQ
            INNER JOIN TBL_DETAIL_TEACHER t ON t.DETAIL_TEACHER_SEQ = s.DETAIL_TEACHER_SEQ
              INNER JOIN TBL_BASIC_BOOK k ON k.BASIC_BOOK_SEQ = s.BASIC_BOOK_SEQ;


-- - 위 출력된 모든 과목 목록을 바탕으로 한 과목을 선택하여 밑의 교육생들의 성적 정보를 출력한다.
SELECT s.STUDENT_NAME as 학생이름, i.SSN as 주민등록번호, g.STUDENT_GRADE_ATTENDANCE as 출결, g.STUDENT_GRADE_WRITING as 필기, g.STUDENT_GRADE_PRACTICAL as 실기
    FROM TBL_STUDENT_GRADE g
       INNER JOIN tbl_student_enrollment e
            ON g.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
                INNER JOIN TBL_DETAIL_STUDENT s
                    ON e.DETAIL_STUDENT_SEQ = s.DETAIL_STUDENT_SEQ
                        INNER JOIN TBL_BASIC_INFO i
                            ON i.BASIC_INFO_SEQ = s.BASIC_INFO_SEQ
                               INNER JOIN TBL_SUBJECT j
                                  ON g.SUBJECT_SEQ = j.SUBJECT_SEQ
                                    INNER JOIN TBL_BASIC_SUBJECT t
                                        ON t.BASIC_SUBJECT_SEQ = j.BASIC_SUBJECT_SEQ
                                            WHERE g.SUBJECT_SEQ = 1 OR t.BASIC_SUBJECT_NAME = 매개변수 -- 매개변수 -- 이름이나 번호 둘 중 하나를 선택적으로 입력받을수 있게 하려고.
                                                ORDER BY 학생이름 ASC;


DROP TABLE TBL_STUDENT_GRADE;


-- - 교육생 개인별 출력 시 이미 끝난 & 현재 교육생 정보를 출력하여 해당 교육생 정보(이름, 주민번호, 수강 과정명, 과정기간, 강의실명) 를 출력한다.
-- - 위의 전체 교육생 정보를 출력 받은 그 목록을 토대로 선택하여 교육생 개인별 출력을 할 수 있다.(개설 과목명, 개설 과목 기간, 교사명, 출력, 필기, 실기)
SELECT e.DETAIL_STUDENT_SEQ as 학생번호, d.STUDENT_NAME as 학생이름, b.SSN as 주민등록번호, o.BASIC_COURSE_NAME as 과정명, c.COURSE_START_DATE as 과정시작일, c.COURSE_END_DATE as 과정종료일, r.CLASSROOM_NAME as 강의실명 FROM TBL_DETAIL_STUDENT d
    INNER JOIN TBL_BASIC_INFO b ON b.BASIC_INFO_SEQ = d.BASIC_INFO_SEQ
      INNER JOIN TBL_STUDENT_ENROLLMENT e ON e.DETAIL_STUDENT_SEQ = d.DETAIL_STUDENT_SEQ
          INNER JOIN TBL_COURSE c ON c.COURSE_SEQ = e.COURSE_SEQ
            INNER JOIN TBL_BASIC_COURSE o ON o.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
                INNER JOIN TBL_CLASSROOM r ON r.CLASSROOM_SEQ = c.CLASSROOM_SEQ
                    WHERE c.COURSE_START_DATE < sysdate;


SELECT  distinct      b.BASIC_SUBJECT_NAME as 개설과목명,
                      s.SUBJECT_START_DATE as 과목시작일,
                      s.SUBJECT_END_DATE as 과목종료일,
                      t.TEACHER_NAME as 교사명,
                      g.STUDENT_GRADE_ATTENDANCE as 출결,
                      g.STUDENT_GRADE_WRITING as 필기,
                      g.STUDENT_GRADE_PRACTICAL as 실기
  FROM tbl_subject s
    INNER JOIN TBL_BASIC_SUBJECT b ON s.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
      INNER JOIN TBL_DETAIL_TEACHER t ON t.DETAIL_TEACHER_SEQ = s.DETAIL_TEACHER_SEQ
        INNER JOIN TBL_STUDENT_GRADE g ON g.SUBJECT_SEQ = s.SUBJECT_SEQ
          INNER JOIN TBL_STUDENT_ENROLLMENT e ON g.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
            INNER JOIN TBL_DETAIL_STUDENT d ON d.DETAIL_STUDENT_SEQ = e.DETAIL_STUDENT_SEQ
                WHERE d.DETAIL_STUDENT_SEQ = 매개변수 OR d.STUDENT_NAME = 매개변수; -- 이름이나 번호 둘 중 하나를 선택적으로 입력받을수 있게 하려고.



-- - 전체 개설 과정 목록을 출력하여 그 목록에서 특정 개설 과정을 선택하는 경우
-- - 해당 개설 과정을 수강하는 모든 교육생의 출결을 조회할 수 있어야 한다.
-- - 위의 과정별 출결 조회  -> 추가로 일정 기간을 입력하여 그 기간 안의 출결 조회할 수 있어야 한다.
-- - 특정 학생의 이름을 입력하여 해당 학생의 기본 정보와 출결 현황을 조회 할 수 있다.
-- - 모든 출결 조회는 근태 상황을 구분할 수 있어야 한다.(정상, 지각, 조퇴, 외출, 병가, 기타) -- 외출, 병가는 관리자 소관

SELECT s.STUDENT_NAME as 학생명, s.STUDENT_TEL as 전화번호, a.ATTENDANCE_IN_TIME as 등원시간, a.ATTENDANCE_OUT_TIME as 하원시간,
CASE
  WHEN to_number(to_char(a.ATTENDANCE_IN_TIME, 'hh')) < 9 AND to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) >= 6 THEN '정상'
  WHEN to_number(to_char(a.ATTENDANCE_IN_TIME, 'hh')) >= 9 AND to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) >= 6 THEN '지각'
  WHEN to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) < 6 THEN '조퇴'
END AS 근태현황
FROM TBL_DETAIL_STUDENT s
  INNER JOIN TBL_STUDENT_ENROLLMENT e ON s.DETAIL_STUDENT_SEQ = e.DETAIL_STUDENT_SEQ
    INNER JOIN TBL_STUDENT_ATTENDANCE a ON a.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
      INNER JOIN TBL_COURSE o ON o.COURSE_SEQ = e.COURSE_SEQ
        INNER JOIN TBL_BASIC_COURSE c ON c.BASIC_COURSE_SEQ = o.BASIC_COURSE_SEQ
      WHERE (e.COURSE_SEQ = 1 OR c.BASIC_COURSE_NAME = 매개변수) AND ('2017-07-01'<= a.ATTENDANCE_IN_TIME AND a.ATTENDANCE_OUT_TIME <= '2017-08-01');
      -- 과정 시퀀스와 각 날짜는 매개변수이다 (자바에서 직접 입력받는다, 선 과정 번호 입력 or 과정명 입력 후 기간 입력 받기 (연, 월 , 일 별로 입력받기 )



SELECT s.STUDENT_NAME as 학생명, a.ATTENDANCE_IN_TIME as 등원시간, a.ATTENDANCE_OUT_TIME as 하원시간,
CASE
  WHEN to_number(to_char(a.ATTENDANCE_IN_TIME, 'hh')) < 9 AND to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) >= 6 THEN '정상'
  WHEN to_number(to_char(a.ATTENDANCE_IN_TIME, 'hh')) >= 9 AND to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) >= 6 THEN '지각'
  WHEN to_number(to_char(a.ATTENDANCE_OUT_TIME, 'hh')) < 6 THEN '조퇴'
  ELSE '미정'
END AS 근태현황
FROM TBL_DETAIL_STUDENT s
  INNER JOIN TBL_STUDENT_ENROLLMENT e ON s.DETAIL_STUDENT_SEQ = e.DETAIL_STUDENT_SEQ
    INNER JOIN TBL_STUDENT_ATTENDANCE a ON a.STUDENT_ENROLLMENT_SEQ = e.STUDENT_ENROLLMENT_SEQ
      INNER JOIN TBL_COURSE o ON o.COURSE_SEQ = e.COURSE_SEQ
        INNER JOIN TBL_BASIC_COURSE c ON c.BASIC_COURSE_SEQ = o.BASIC_COURSE_SEQ
          WHERE s.STUDENT_NAME = '하수수'; -- 학생명 매개변수로 받는다.



-- 강의 스케쥴 조회 메뉴를 선택한 이후의 화면
-- 개설 과정, 개설 과목을 조인한 뷰에서 교사 본인의 고유 정보를 포함하는 레코드 즉 교사와 관련된 강의 레코드를 SELECT 한다.
-- 해당 정보에는 아래와 같은 컬럼이 포함되어 있다.
-- <과목번호, 과목명, 과목시작일, 과목종료일, 과정명, 과정시작일, 과정종료일, 교재명
-- 교육생 등록 인원>
--
-- ->강의 종료 / 강의 중 / 강의 예정의 구별은 현재 시각을 과목 시작일과 종료일과 비교하여 나타낸다.

SELECT distinct s.SUBJECT_SEQ as 과목번호,
       bs.BASIC_SUBJECT_NAME as 과목명,
       --s.SUBJECT_START_DATE as 과목시작일,
       --s.SUBJECT_END_DATE as 과목종료일,
       bc.BASIC_COURSE_NAME as 과정명,
       --c.COURSE_START_DATE as 과정시작일,
       --c.COURSE_END_DATE as 과정종료일,
       bb.BASIC_BOOK_NAME as 교재명,
       cr.CLASSROOM_NAME as 강의실명,
      (SELECT count(*) FROM TBL_STUDENT_ENROLLMENT se WHERE se.COURSE_SEQ = c.COURSE_SEQ) as 학생수
  FROM tbl_subject s
    INNER JOIN tbl_course c
      ON s.COURSE_SEQ = c.COURSE_SEQ
    INNER JOIN TBL_BASIC_COURSE bc
      ON bc.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
    INNER JOIN TBL_BASIC_SUBJECT bs
      ON bs.BASIC_SUBJECT_SEQ = s.BASIC_SUBJECT_SEQ
    INNER JOIN TBL_BASIC_BOOK bb
      ON bb.BASIC_BOOK_seq = s.BASIC_BOOK_SEQ
    INNER JOIN TBL_STUDENT_ENROLLMENT se
      ON se.COURSE_SEQ = c.COURSE_SEQ
    INNER JOIN TBL_CLASSROOM cr
      ON cr.CLASSROOM_SEQ = c.CLASSROOM_SEQ
        WHERE s.DETAIL_TEACHER_SEQ = 4
          ORDER BY 과목번호 ASC;


