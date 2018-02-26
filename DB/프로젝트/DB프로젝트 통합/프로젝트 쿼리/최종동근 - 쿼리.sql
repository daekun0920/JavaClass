/*
  교사
  교사 기본정보를 위한 뷰

  tbl_basic_info / tbl_detail_teacher / tbl_key_teacehr_subject -> vw_basic_info
 */
select * from tbl_basic_info where basic_info_seq = 201;
update tbl_basic_info set id = 'admin', ssn = 1234567 where basic_info_seq = 495;
update tbl_basic_info set id = 'teacher', ssn = 1234567 where basic_info_seq = 485;
update tbl_basic_info set id = 'student', ssn = 1234567 where basic_info_seq = 100;
commit;
-- 1번.
CREATE OR REPLACE VIEW vw_basic_info_forteacher
  AS
SELECT T1.BASIC_INFO_SEQ,
       T1.ID,
       T1.SSN,
       T1.TYPE,
       T2.TEACHER_NAME,
       T2.TEACHER_TEL,
       T3.SUBJECT_SEQ,
       T3.DETAIL_TEACHER_SEQ
FROM TBL_BASIC_INFO t1
  INNER JOIN TBL_DETAIL_TEACHER t2
    ON T1.BASIC_INFO_SEQ = T2.BASIC_INFO_SEQ
      INNER JOIN TBL_KEY_TEACHER_SUBJECT T3
        ON T2.DETAIL_TEACHER_SEQ = T3.DETAIL_TEACHER_SEQ;

-----------------------------------------------------------------------------------------------------------------------------------
/*
  교사
  교사 과목조회를 위한 뷰

  tbl_subject / tbl_basic_subject / tbl_basic_book -> vw_subject
 */

-- 2번.
CREATE OR REPLACE VIEW vw_subject_forteacher
AS
SELECT T1.SUBJECT_SEQ,
       T1.SUBJECT_START_DATE,
       T1.SUBJECT_END_DATE,
       T1.BASIC_SUBJECT_SEQ,
       T1.BASIC_BOOK_SEQ,
       T2.BASIC_SUBJECT_NAME,
       T3.BASIC_BOOK_NAME
FROM TBL_SUBJECT T1
  INNER JOIN TBL_BASIC_SUBJECT T2
    ON T1.BASIC_SUBJECT_SEQ = T2.BASIC_SUBJECT_SEQ
      INNER JOIN TBL_BASIC_BOOK T3
        ON T1.BASIC_BOOK_SEQ = T3.BASIC_BOOK_SEQ
order by SUBJECT_SEQ;

-----------------------------------------------------------------------------------------------------------------------------------
/*
  tbl_subject / tbl_basic_subject / tbl_basic_book -> vw_course

 */
-- 3번.
CREATE OR REPLACE VIEW vw_course_forteacher
AS
SELECT COURSE_SEQ,
       COURSE_START_DATE,
       COURSE_END_DATE,
       T1.CLASSROOM_SEQ,
       T1.BASIC_COURSE_SEQ,
       T2.BASIC_COURSE_NAME,
       T3.CLASSROOM_NAME
FROM tbl_course T1
  INNER JOIN TBL_BASIC_COURSE T2
    ON T1.BASIC_COURSE_SEQ = T2.BASIC_COURSE_SEQ
      INNER JOIN TBL_CLASSROOM T3
        ON T1.CLASSROOM_SEQ = T3.CLASSROOM_SEQ;

-----------------------------------------------------------------------------------------------------------------------------------

/*
  학생과 과정 과목 연결
  TBL_STUDENT_ENROLLMENT
  TBL_KEY_ENROLLMENT_COURSE
  TBL_COURSE
  TBL_KEY_SUBJECT_COURSE
  TBL_SUBJECT
 */
-- 4번.
CREATE OR REPLACE VIEW vw_student_relation_forteacher
AS
SELECT T1.STUDENT_ENROLLMENT_SEQ,
       T3.COURSE_SEQ,
       T3.COURSE_START_DATE,
       T3.COURSE_END_DATE,
       T3.BASIC_COURSE_SEQ,
       T5.SUBJECT_SEQ
FROM TBL_STUDENT_ENROLLMENT T1
  INNER JOIN TBL_KEY_ENROLLMENT_COURSE T2
    ON T1.STUDENT_ENROLLMENT_SEQ = T2.STUDENT_ENROLLMENT_SEQ
      INNER JOIN TBL_COURSE T3
        ON T2.COURSE_SEQ = T3.COURSE_SEQ
          INNER JOIN TBL_KEY_SUBJECT_COURSE T4
            ON T4.COURSE_SEQ = T3.COURSE_SEQ
              INNER JOIN TBL_SUBJECT T5
                ON T5.SUBJECT_SEQ = T4.SUBJECT_SEQ
ORDER BY T5.SUBJECT_SEQ ASC;
-----------------------------------------------------------------------------------------------------------------------------------


/*
  과목별 교육생 숫자
  vw_student_relation
  TBL_KEY_STUDENT_ENROLLMENT
  TBL_DETAIL_STUDENT
 */
-- 5번
CREATE OR REPLACE VIEW vw_countby_forteacher
AS
SELECT SUBJECT_SEQ, count(*) AS 교육생인원
FROM vw_student_relation_forteacher V1
  INNER JOIN TBL_KEY_STUDENT_ENROLLMENT T1
    ON T1.STUDENT_ENROLLMENT_SEQ = V1.STUDENT_ENROLLMENT_SEQ
      INNER JOIN TBL_DETAIL_STUDENT T2
        ON T2.DETAIL_STUDENT_SEQ = T1.DETAIL_STUDENT_SEQ
GROUP BY SUBJECT_SEQ
ORDER BY SUBJECT_SEQ;

-----------------------------------------------------------------------------------------------------------------------------------
/*
  1-1 작업할 차례

  (1) TBL_STUDENT_COMPLETE
      TBL_STUDENT_QUITE
      VW_STUDENT_RELATION
 */
CREATE OR REPLACE VIEW vw_enroll_status_forteacher
AS
SELECT t1.STUDENT_ENROLLMENT_SEQ,
       '수료' AS 등록현황
FROM TBL_STUDENT_COMPLETE t1
UNION
SELECT t2.STUDENT_ENROLLMENT_SEQ,
      '중도포기' AS 등록현황
FROM TBL_STUDENT_QUIT t2;



--3번, 성적등록 여부를 위한 View
CREATE OR REPLACE VIEW vw_check_in_grading_forteacher
AS
SELECT T2.SUBJECT_SEQ AS 과목번호,
        T1.STUDENT_GRADE_ATTENDANCE,
        T1.STUDENT_GRADE_WRITING,
        T1.STUDENT_GRADE_PRACTICAL
FROM TBL_KEY_GRADE_SUBJECT k1
  INNER JOIN  TBL_STUDENT_GRADE t1
    ON k1.STUDENT_GRADE_SEQ = T1.STUDENT_GRADE_SEQ
      INNER JOIN TBL_SUBJECT T2
        ON T2.SUBJECT_SEQ = K1.SUBJECT_SEQ
ORDER BY T2.SUBJECT_SEQ ASC;

-----------------------------------------------------------------------------------------------------------------------------------
-- 뷰 작업 경계 라인
-----------------------------------------------------------------------------------------------------------------------------------
/*
  1. 교사 자신의 전체 강의 스케쥴 조회

  1. 강의일정 - 강의 예정 / 강의 중 / 강의 종료 [현재 날짜 기준]
  2. 과목번호
  3. 과목명
  4. 과목시작일
  5. 과목종료일
  6. 과정명
  7. 과정시작일
  8. 과정종료일
  9. 강의실
  10.교재명
  11.교육생등록인원
  12.회원번호
 */
CREATE OR REPLACE VIEW vw_schedule_forteacher
AS
SELECT CASE
          WHEN SYSDATE > V2.SUBJECT_END_DATE THEN '강의종료'
          WHEN SYSDATE < V2.SUBJECT_START_DATE THEN '강의예정'
          ELSE '강의중'
       END AS 강의일정,
       V2.SUBJECT_SEQ AS 과목번호,
       V2.BASIC_SUBJECT_NAME AS 과목명,
       V2.SUBJECT_START_DATE AS 과목시작일,
       V2.SUBJECT_END_DATE AS 과목종료일,
       V3.BASIC_COURSE_NAME AS 과정명,
       V3.COURSE_START_DATE AS 과정시작일,
       V3.COURSE_END_DATE AS 과정종료일,
       V3.CLASSROOM_NAME AS 강의실명,
       V2.BASIC_BOOK_NAME AS 교재명,
        (SELECT 교육생인원 FROM vw_countby_forteacher WHERE vw_countby_forteacher.SUBJECT_SEQ = V2.SUBJECT_SEQ) AS 교육생등록인원,
       V1.BASIC_INFO_SEQ AS 회원번호

FROM vw_basic_info_forteacher v1
  INNER JOIN vw_subject_forteacher v2
    ON V1.SUBJECT_SEQ = V2.SUBJECT_SEQ
      INNER JOIN TBL_KEY_SUBJECT_COURSE K1
        ON V2.SUBJECT_SEQ = K1.SUBJECT_SEQ
          INNER JOIN vw_course_forteacher V3
            ON K1.COURSE_SEQ = V3.COURSE_SEQ;
/*
  1-1 과목번호 입력 -> 과정에 등록된 교육생 정보 출력

  과목번호 IN

  교육생 이름
  전화번호
  등록일
  수료 / 중도탈락

 */
SELECT V1.SUBJECT_SEQ AS 과목번호,
       T2.STUDENT_NAME AS 교육생이름,
       T2.STUDENT_TEL AS 전화번호,
       T2.STUDENT_REGDATE AS 등록일,
       CASE
         WHEN V2.등록현황 = '수료' THEN '수료'
         WHEN V2.등록현황 = '중도포기' THEN '중도포기'
         ELSE '미정'
       END AS 등록현황
FROM vw_student_relation_forteacher V1
  INNER JOIN TBL_KEY_STUDENT_ENROLLMENT T1
    ON V1.STUDENT_ENROLLMENT_SEQ = T1.STUDENT_ENROLLMENT_SEQ
      INNER JOIN TBL_DETAIL_STUDENT T2
        ON T1.DETAIL_STUDENT_SEQ = T2.DETAIL_STUDENT_SEQ
          left OUTER JOIN vw_enroll_status_forteacher V2
            ON V2.STUDENT_ENROLLMENT_SEQ = V1.STUDENT_ENROLLMENT_SEQ;
            

-----------------------------------------------------------------------------------------------------------------------------------

/*
	2. 배점을 위한 조회 >>>>>>>>>강의 종료된 과목만<<<<<<<<<
	
	vw_subject
	tbl_key_subject_course
	vw_course
	tbl_key_standard_subject
	tbl_grading_standard
    
>> 출력컬럼
    과목번호
    과목명
    과목시작일
    과목종료일
    과정명
    과정시작일
    과정종료일
    강의실
    교재명
    출결배점
    필기배점
    실기배점
*/
CREATE OR REPLACE VIEW vw_grading_list_forteacher
AS
SELECT v2.SUBJECT_SEQ AS 과목번호,
       v2.BASIC_SUBJECT_NAME AS 과목명,
       v2.SUBJECT_START_DATE AS 과목시작일,
       v2.SUBJECT_END_DATE AS 과목종료일,
       v1.BASIC_COURSE_NAME AS 과정명,
       v1.COURSE_START_DATE AS 과정시작일,
       v1.COURSE_END_DATE AS 과정종료일,
       v1.CLASSROOM_NAME AS 강의실명,
       v2.BASIC_BOOK_NAME AS 교재명,
       t1.GRADING_ATTENDANCE AS 출결배점,
       t1.GRADING_WRITING AS 필기배점,
       t1.GRADING_PRACTICAL AS 실기배점,
       t1.exam_date AS 시험날짜,
       t1.GRADING_STANDARD_SEQ AS 배점번호
FROM vw_course_forteacher v1
	INNER JOIN tbl_key_subject_course k1
		ON v1.course_seq = k1.course_seq
			INNER JOIN vw_subject_forteacher v2
				ON k1.subject_seq = v2.subject_seq
					INNER JOIN tbl_key_standard_subject k2
						ON k2.subject_seq = v2.subject_seq
							INNER JOIN tbl_grading_standard t1
								ON t1.grading_standard_seq = k2.grading_standard_seq
                                WHERE v2.SUBJECT_END_DATE < SYSDATE
                                ORDER BY v2.subject_end_date desc;

                                
CREATE OR REPLACE VIEW vw_subjectnum_forteacher
AS
SELECT tbi.basic_info_seq AS 회원번호,
       ts.subject_seq AS 과목번호
FROM TBL_BASIC_INFO TBI
    INNER JOIN TBL_DETAIL_TEACHER TDT
        ON TBI.BASIC_INFO_SEQ = TDT.BASIC_INFO_SEQ
            INNER JOIN TBL_KEY_TEACHER_SUBJECT TKTS
                ON TKTS.DETAIL_TEACHER_SEQ = TDT.DETAIL_TEACHER_SEQ
                    INNER JOIN TBL_SUBJECT TS
                        ON TS.SUBJECT_SEQ = TKTS.SUBJECT_SEQ;

-----------------------------------------------------------------------------------------------------------------------------------

/*
    2-1 특정 과목번호 입력 -> 배점 입력화면으로 전환

    출결
    필기
    실기
    시험 날짜
*/








-----------------------------------------------------------------------------------------------------------------------------------

/*
    3 성적 입출력
    
    강의를 마친 과목 출력 -> 교사 본인의 강의를 마친 과목들(뷰)
    
    과목번호
    과목시작일
    과목종료일
    과정명
    과정시작일
    과정종료일
    강의실
    교재명
    출결배점
    필기배점
    실기배점
    성적등록여부(해당 과목 수강생 전체에 값이 입력되어 있다면 y 아니면 n)

*/
--종료된 강의 목록
CREATE OR REPLACE VIEW vw_list_grade_forteacher
AS
SELECT  b.과목번호,
        b.과목시작일,
        b.과목종료일,
        b.과정명,
        b.과정시작일,
        b.과정종료일,
        b.강의실명,
        b.교재명,
        b.출결배점,
        b.필기배점,
        b.실기배점,
        CASE
          WHEN b.성적등록여부 = 0 THEN '등록완료'
          WHEN b.성적등록여부 > 0 THEN '입력대기 중'
        END AS "성적등록여부"
FROM
  (select v2.*,
  (SELECT COUNT(*) FROM vw_check_in_grading_forteacher v1 WHERE v1.과목번호 = v2.과목번호 AND (V1.STUDENT_GRADE_ATTENDANCE IS NULL OR
        V1.STUDENT_GRADE_WRITING IS NULL OR
        V1.STUDENT_GRADE_PRACTICAL IS NULL)) AS 성적등록여부
FROM vw_grading_list_forteacher v2
order by 과목번호) b;



/*
  3-1. 특정과목번호에 해당하는 교육생 전체(중도 탈락 교육생 포함)

  이름,
  전화번호
  수료 및 중도탈락
  출결,
  필기,
  실기
 */
CREATE OR REPLACE VIEW vw_student_info_forteacher
AS
SELECT tbi.BASIC_INFO_SEQ AS 학생번호,
       tds.STUDENT_NAME AS 학생이름,
       tds.STUDENT_TEL AS 학생전화번호,
       tsg.STUDENT_GRADE_ATTENDANCE AS 출결점수,
       tsg.STUDENT_GRADE_WRITING AS 필기점수,
       tsg.STUDENT_GRADE_PRACTICAL AS 실기점수,
       CASE
         WHEN VSES.등록현황 = '중도포기' THEN '중도포기'
       END AS 중도탈락여부,
        (SELECT STUDENT_QUIT_DATE FROM TBL_STUDENT_QUIT WHERE STUDENT_ENROLLMENT_SEQ = TSE.STUDENT_ENROLLMENT_SEQ) AS 중도탈락날짜,
        TS.SUBJECT_SEQ AS 과목번호,
        tsg.student_grade_seq AS 학생성적번호
FROM TBL_BASIC_INFO TBI
  INNER JOIN TBL_DETAIL_STUDENT TDS
    ON TBI.BASIC_INFO_SEQ = TDS.BASIC_INFO_SEQ
      INNER JOIN TBL_KEY_STUDENT_ENROLLMENT TKSE
        ON TKSE.DETAIL_STUDENT_SEQ = TDS.DETAIL_STUDENT_SEQ
          INNER JOIN TBL_STUDENT_ENROLLMENT TSE
            ON TSE.STUDENT_ENROLLMENT_SEQ = TKSE.STUDENT_ENROLLMENT_SEQ
              INNER JOIN TBL_STUDENT_GRADE TSG
                ON TSG.STUDENT_ENROLLMENT_SEQ = TSE.STUDENT_ENROLLMENT_SEQ
                  INNER JOIN TBL_KEY_GRADE_SUBJECT TKGS
                    ON TKGS.STUDENT_GRADE_SEQ = TSG.STUDENT_GRADE_SEQ
                      INNER JOIN TBL_SUBJECT TS
                        ON TS.SUBJECT_SEQ = TKGS.SUBJECT_SEQ
                          LEFT OUTER JOIN vw_enroll_status_forteacher vses
                            ON VSES.STUDENT_ENROLLMENT_SEQ = TSE.STUDENT_ENROLLMENT_SEQ;
--------------------------------------------------------------------------------------------------
--학생 성적 입력에 사용되는 프로시저

CREATE OR REPLACE PROCEDURE proc_update_grade(
    patt NUMBER,
    pwriting NUMBER,
    ppractical NUMBER,
    pseq NUMBER,
    presult OUT NUMBER
)
IS
BEGIN
    UPDATE TBL_STUDENT_GRADE SET student_grade_attendance = patt, STUDENT_GRADE_WRITING = pwriting, STUDENT_GRADE_PRACTICAL = ppractical WHERE STUDENT_GRADE_SEQ = pseq;
    COMMIT;
    presult := 1;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK;
END;



----------------------------------------------------------------------------------------------------------
--학생 출결 조회를 위해 사용되는 뷰

CREATE OR REPLACE VIEW vw_att_list_forteacher
AS
SELECT distinct tds.student_name AS 학생이름,
       tsa.ATTENDANCE_IN_TIME AS 학생출근시간,
       tsa.ATTENDANCE_OUT_TIME AS 학생퇴근시간,
       tas.attendance_status AS 학생근태,
       tbi.basic_info_seq AS 교사번호
FROM tbl_detail_student tds
    inner join tbl_key_student_enrollment tkse
        on tkse.detail_student_seq = tds.DETAIL_STUDENT_SEQ
            inner join tbl_key_enrollment_course tkec
                on tkse.student_enrollment_seq = tkse.student_enrollment_seq
                    inner join tbl_key_subject_course tksc
                        on tksc.COURSE_SEQ = tkec.COURSE_SEQ
                            inner join tbl_key_teacher_subject tkts
                                on tkts.SUBJECT_SEQ = tksc.SUBJECT_SEQ
                                    inner join tbl_detail_teacher tdt
                                        on tdt.detail_teacher_seq = tkts.detail_teacher_seq
                                            inner join tbl_basic_info tbi
                                                on tbi.basic_info_seq = tdt.basic_info_seq
                                                    inner join tbl_student_attendance tsa
                                                        on tsa.student_attendance_seq = tkse.student_enrollment_seq
                                                            inner join tbl_attendance_status tas
                                                                on tas.student_attendance_seq = tsa.student_attendance_seq;

