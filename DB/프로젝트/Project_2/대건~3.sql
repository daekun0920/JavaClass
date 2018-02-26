SELECT distinct b.BASIC_SUBJECT_NAME as 과목명, s.SUBJECT_START_DATE as 과목시작날짜, s.SUBJECT_END_DATE as 과목종료날짜,
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
           WHERE s.COURSE_SEQ = 2
             ORDER BY s.subject_start_date; -- 매개변수(과정)
           
           
           
           