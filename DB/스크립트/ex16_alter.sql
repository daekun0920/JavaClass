/*

ex16_ALTER.sql

테이블 생성 - CREATE
테이블 삭제 - DROP
테이블 수정 - ALTER

테이블 수정하기
1. 테이블 삭제 -> 테이블 (수정) 생성 -> 데이터 복구(INSERT) // 프로젝트 초기단계 
2. ALTER 명령어 -> 구조만 변경 + 데이터 유지  // 프로젝트 중후반 단계 : ALTER 명령어는 되도록 사용할 상황을 안 만드는게...

테이블 수정 작업
1. 새로운 컬럼 추가하기 - 난이도 하 
2. 기존 컬럼 삭제하기 
3. 기존 컬럼 수정하기 


*/

CREATE TABLE tbledit
(
    seq NUMBER NOT NULL,
    data VARCHAR2(10) NOT NULL
);

INSERT INTO tbledit VALUES(1, '키보드');
INSERT INTO tbledit VALUES(2, '마우스');

-- 1. 새로운 컬럼 추가하기 (NOT NULL은 안됨)
ALTER TABLE tbledit
    ADD (price number(5) NULL);

ALTER TABLE tbledit
    ADD (regdate DATE NULL);

ALTER TABLE tbledit      -- ORA-01758: table must be empty to add mandatory (NOT NULL) column
    ADD (qty NUMBER(1) NOT NULL);

-- 꼭 NN 제약이 걸린 컬럼을 새로 추가해야하는 경우? 1
-- 1.
ALTER TABLE tbledit 
    ADD (qty NUMBER(1) NULL);
-- 2.
UPDATE tbledit SET qty = 1;

-- 3.
ALTER TABLE tbledit
    MODIFY (qty NUMBER(1) NOT NULL);

-- 꼭 NN 제약이 걸린 컬럼을 새로 추가해야하는 경우? 2
ALTER TABLE tbledit
    ADD (color VARCHAR2(30) DEFAULT '미정' NOT NULL); -- 모든 기존 레코드의 새컬럼에 DEFAULT가 적용된다.


INSERT INTO tbledit VALUES (3, '모니터', NULL, NULL, NULL); -- ORA-01400: cannot insert NULL into ("HR"."TBLEDIT"."QTY")

SELECT * FROM tbledit;



-- 2. 기존 컬럼 삭제하기 
-- : 컬럼 삭제 + 데이터 삭제 
ALTER TABLE tbledit
    DROP COLUMN qty;

ALTER TABLE tbledit
    DROP COLUMN regdate;



SELECT * FROM tbledit;

-- 3. 기존 컬럼 수정하기
-- : 자료형(타입, 길이), 제약사항(NOT NULL 등...) 제약 바꾸기
INSERT INTO tbledit VALUES (3, '모니터', 1000, '검정');
INSERT INTO tbledit VALUES (4, '메모리', 2000, '노랑');

SELECT * FROM tbledit;

-- 숫자 컬럼 길이는 값이 비어있어야 조절이 가능하다.
ALTER TABLE tbledit
    MODIFY (price NUMBER (4));
    
-- NN 수정하기
ALTER TABLE tbledit
    MODIFY (price NUMBER (4) NULL);

ALTER TABLE tbledit
    MODIFY (price NUMBER (4) NOT NULL); -- 주의 : 기존 값들이 전부 있다고 가정 

ALTER TABLE tbledit 
    MODIFY (color VARCHAR2(30) DEFAULT '미정' 
                CHECK (color IN ('미정', '검정', '노랑', '빨강', '파랑')));


ALTER TABLE tbl_subject RENAME COLUMN basic_book TO basic_book_seq;
ALTER TABLE tbl_subject RENAME COLUMN detail_teacher TO detail_teacher_seq;

ALTER TABLE tbl_student_quit RENAME COLUMN student_enrollment TO student_enrollment_seq;


CREATE TABLE tbledit
(
    seq NUMBER NOT NULL,
    data VARCHAR2(10) NOT NULL
);

-- 제약 사항 추가하기 
-- : NOT NULL 제약을 제외한 나머지 제약 사항 추가하기 
ALTER TABLE tbledit
    ADD CONSTRAINT tbledit_seq_pk PRIMARY KEY (seq);

ALTER TABLE tbledit
    DROP CONSTRAINT tbledit_seq_pk;
    
ALTER TABLE tbledit 
    DROP CONSTRAINT SYS_C007309;
    


/*

테이블의 모든 행을 삭제하기 
- 테이블 초기화(구조는 그대로 두고 데이터만 초기화)
- 개발 -> 테스트 -> 완료 -> 초기화 

1. DROP -> CREATE 
- 편법 
- 사용 빈도 있음
- 되돌리기 불가능(복구 불가능)

2. DELETE
- 정식
- 모든 행 OR 일부 행(레코드)
- 되돌리기 가능(복구 가능)

3. TRUNCATE 명령어(수학 함수 TRUNC함수와 다른 명령어) 
- 정식
- 테이블의 모든 행을 삭제하는 명령어(DELETE 조건절없이 사용하는 것과 동일)
- 되돌리기 불가능(복구 불가능)

*/

TRUNCATE TABLE tbledit; -- 복구 불가능
DELETE FROM tbledit; -- 복구 가능

SELECT * FROM tbledit;

CREATE TABLE 영업부
AS
SELECT * FROM tblinsa WHERE BUSEO = '영업부';

SELECT * FROM 영업부;

COMMIT;
ROLLBACK;

DELETE FROM 영업부;
TRUNCATE TABLE 영업부;












