SELECT distinct b.BASIC_SUBJECT_NAME as �����, s.SUBJECT_START_DATE as ������۳�¥, s.SUBJECT_END_DATE as �������ᳯ¥,
CASE
  WHEN r.STUDENT_GRADE_ATTENDANCE is NULL AND r.STUDENT_GRADE_PRACTICAL is NULL AND r.STUDENT_GRADE_WRITING is NULL THEN '�����̵��'
  ELSE '�������'
END as ������Ͽ���,
CASE
  WHEN EXAM_DATE is null THEN '���賯¥�̵��'
  ELSE '���賯¥���'
END as ���賯¥��Ͽ���
  FROM TBL_SUBJECT s
    INNER JOIN TBL_BASIC_SUBJECT b ON s.BASIC_SUBJECT_SEQ = b.BASIC_SUBJECT_SEQ
      INNER JOIN TBL_GRADING_STANDARD g ON g.SUBJECT_SEQ = s.SUBJECT_SEQ
        INNER JOIN TBL_STUDENT_GRADE r ON r.SUBJECT_SEQ = s.SUBJECT_SEQ
           WHERE s.COURSE_SEQ = 2
             ORDER BY s.subject_start_date; -- �Ű�����(����)
           
           
           
           