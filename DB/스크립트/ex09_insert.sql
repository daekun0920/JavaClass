/*

ex09_insert.sql


DML : select, insert, update, delete

INSERT 문
- INSERT INTO 테이블명 (컬럼리스트) VALUES (값 리스트)

*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER PRIMARY KEY, -- 메모번호(PK)
    name VARCHAR2(30) NOT NULL, -- 글쓴이
    memo VARCHAR2(1000) NOT NULL, -- 메모
    regdate date DEFAULT sysdate NOT NULL, -- 날짜
    etc VARCHAR2(500) DEFAULT '비고 없음' NULL, -- 비고
    page NUMBER NULL -- 페이지 수
); 

SELECT memoseq.nextval FROM dual;
SELECT memoseq.currval FROM dual; -- 하드디스크가 아닌 CACHE(메모리)에 있는 번호를 가져오는 명령어 -> 프로그램 종료후 재실행시 CACHE값 사라짐 -> 작동 안됨 -> nextval 로 CACHE에 값 다시 가져오면 작동 됨


-- INSERT문의 패턴

-- 1. 표준 : 원본 테이블의 정의 컬럼 순서대로 컬럼리스트와 값리스트를 표기
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고', 1);

-- 컬럼 리스트이 순서와 값 리스트의 순서는 반드시 동일     
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', '비고', sysdate, 1); -- ORA-01841: (full) year must be between -4713 and +9999, and not be 0

INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고');    -- ORA-00947: not enough values

INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고', 1); -- ORA-00913: too many values


-- 2. 컬럼(값)의 순서 바꾸기
-- 컬럼리스트와 값리스트의 순서는 반드시 원본 테이블의 정의와 일치할 필요가 없다.
INSERT INTO tblmemo(name, memo, regdate, etc, page, seq)
    VALUES ('홍길동', '메모', sysdate, '비고', 1, memoseq.nextval);


-- 3. NULL 제약을 가진 컬럼값 입력하기 
-- 특정 컬럼에 NULL을 대입하고 싶다.

-- 3.a 대상 컬럼과 값을 생략하면 된다.
INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고');

INSERT INTO tblmemo(seq, name, memo, regdate) -- DEFAULT로 인해서 컬럼과 값 생략시 NULL이 아닌 테이블 생성시 입력한 DEFAULT의 '비고 없음'이 입력된다.
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate);

-- 3.b 명시적으로 NULL을 대입 -> NULL 상수를 사용한다.
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고', NULL);
    
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, NULL, NULL); -- DEFAULT의 경우 유일한 NULL 삽입 방법


SELECT * FROM tblmemo;


-- 4. DEFAULT 값 입력

-- 4.a DEFAULT가 정의되어 있어도 값을 직접 입력하는 경우 > DEFAULT가 아닌 사용자가 직접 입력한 값이 대입 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고', 1);

-- 4.b DEFAULT 컬럼을 생략> DEFAULT 값이 대입 
INSERT INTO tblmemo(seq, name, memo, page)
    VALUES (memoseq.nextval, '홍길동', '메모', 1);

-- 4.c DEFAULT + NULL 선언된 컬럼 에서 NULL 상수를 입력하면 DEFAULT 동작 안함.
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', sysdate, NULL, 1);

-- 4.d 명시적으로 DEFAULT 값 대입 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, '홍길동', '메모', DEFAULT, DEFAULT, 1);

SELECT * FROM tblmemo;


-- 5. 컬럼 리스트 생략
INSERT INTO tblmemo VALUES (memoseq.nextval, '홍길동', '메모', sysdate, '비고', 1);

-- 5.a 반드시 테이블이 만들어질 당시의 컬럼순서대로 값리스트를 맞춰야 한다.
INSERT INTO tblmemo VALUES ('홍길동', '메모', sysdate, '비고', 1, memoseq.nextval); -- ORA-01722: invalid number

-- 5.b  DEFAULT 처리를 위해 값 생략이 불가능하다.
INSERT INTO tblmemo VALUES (memoseq.nextval, '홍길동', '메모', 1); -- ORA-00947: not enough values

-- 5.c DEFAULT 사용하고 싶으면 생략은 불가능 하지만 DEFAULT 상수는 가능하다. *****
INSERT INTO tblmemo VALUES (memoseq.nextval, '홍길동', '메모', DEFAULT, DEFAULT, 1);


------------------------------------------------------- 일반적인 INSERT~


SELECT * FROM tblmemo;

CREATE TABLE tblmemobackup
(
    seq NUMBER PRIMARY KEY, -- 메모번호(PK)
    name VARCHAR2(30) NOT NULL, -- 글쓴이
    memo VARCHAR2(1000) NOT NULL, -- 메모
    regdate date DEFAULT sysdate NOT NULL, -- 날짜
    etc VARCHAR2(500) DEFAULT '비고 없음' NULL, -- 비고
    page NUMBER NULL -- 페이지 수
); 

-- tblmemo -> (복사) -> tblmemobackup
INSERT INTO tblmemobackup 
    SELECT * FROM tblmemo; -- 서브 쿼리 

INSERT INTO tblmemobackup 
    SELECT * FROM tblmemo WHERE page = 1; -- page가 1인 항목들

SELECT * FROM tblmemobackup;


-- tblmemo 에서 page가 1인 항목들만 가지고 별도의 테이블 생성~~~
CREATE TABLE tblmemoonepage
AS
SELECT * FROM tblmemo WHERE page = 1;

SELECT * FROM tblmemoonepage;

--
SELECT * FROM tblinsa;

-- 영업부 테이블
CREATE TABLE 영업부 
AS
SELECT * FROM tblinsa WHERE buseo = '영업부';

SELECT * FROM 영업부;


/*
1. 존재 테이블 A -> (데이터 복사) -> 존재 테이블 B
- insert + select
- 업무용 O, 개발자 테스트용 O

2. 존재 테이블 A -> (테이블 생성 + 데이터 복사) -> 생성 테이블 B
- CREATE + SELECT
- 업무용 X, 개발자 테스트용 O
- 테이블이 생성될 때 데이터는 복사가 되는데... 제약사항은 복사가 안된다.

*/
















