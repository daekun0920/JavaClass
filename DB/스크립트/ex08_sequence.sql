/*

ex08_sequence.sql

시퀀스, Sequences
- 시퀀스 객체(DB Object 중 하나)
- 일련 번호 생성/관리


시퀀스 객체 생성하기 
- CREATE : 생성
- ALTER : 수정
- DROP : 삭제
- CREATE SEQUENCE 시퀀스명;

시퀀스 사용
1. testseq.nextval
2. testseq.currval


*/
CREATE SEQUENCE testseq;

SELECT testseq.nextval FROM dual;
SELECT testseq.currval FROM dual;

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER,  -- 일련 번호(1, 2, 3, 4...)
    name VARCHAR2(20), 
    memo VARCHAR2(1000) NOT NULL,
    
    CONSTRAINT tblmemo_seq_pk PRIMARY KEY (seq),
    CONSTRAINT tblmemo_name_uq UNIQUE(name),
    CONSTRAINT tblmemo_memo_ck CHECK (length(memo) >= 10)
);

CREATE SEQUENCE memoseq;

INSERT INTO tblmemo(seq, name, memo) VALUES (1, '홍길동', '시퀀스 테스트입니다.'); 
INSERT INTO tblmemo(seq, name, memo) VALUES (memoseq.nextval, '홍길동', '시퀀스 테스트입니다.'); 
INSERT INTO tblmemo(seq, name, memo) VALUES (memoseq.nextval, '아무개', '시퀀스 테스트입니다.'); 
INSERT INTO tblmemo(seq, name, memo) VALUES (memoseq.nextval, '테스트', '시퀀스 테스트입니다.'); 
INSERT INTO tblmemo(seq, name, memo) VALUES (memoseq.nextval, '호호호', '시퀀스 테스트입니다.'); 


SELECT memoseq.currval FROM dual;
SELECT memoseq.nextval FROM dual;

SELECT * FROM tblmemo;


-- 상품 테이블
-- : 상품코드, 상품명, 가격, 수량 
-- : 상품코드(PK) -> 1, 2, 3, 4..(X)
-- : 상품코드(PK) -> AA015

CREATE TABLE tblproduct 
(
    seq VARCHAR2(5) PRIMARY KEY, -- 상품코드
    name VARCHAR2(50) NOT NULL,
    price NUMBER NOT NULL,
    qty NUMBER NOT NULL
);

-- AA001, AA002, AA003
CREATE SEQUENCE productseq;


INSERT INTO tblproduct(seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval, '000')), '진공 청소기', 100000, 1); -- +, - 부호 

INSERT INTO tblproduct(seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval, '000')), '걸레', 100000, 1);

INSERT INTO tblproduct(seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval, '000')), '행주', 100000, 1);

INSERT INTO tblproduct(seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval, '000')), '새상품', 100000, 1);

SELECT * FROM tblproduct;


-- 시퀀스 객체 초기화(1부터 다시 시작하도록...)

SELECT productseq.nextval FROM dual;

-- 1. 다시 만들기 
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq;


-- 2. 수정하기(제어하기)
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq 
    INCREMENT BY -1  -- 증감치 
    START WITH 1    -- 시작값
    MAXVALUE 10     -- 최대값 -> 최대값 초과시 -> ORA-08004: sequence PRODUCTSEQ.NEXTVAL exceeds MAXVALUE and cannot be instantiated
    MINVALUE -5     -- 최소값 -> 최소값 초과시 -> ORA-08004: sequence PRODUCTSEQ.NEXTVAL goes below MINVALUE and cannot be instantiated
    CYCLE  -- 최대 / 최소값 도달후 다시 순환 
    CACHE 20 -- 하드디스크(DB)에서 오라클(DBMS)로 미리 일정 값만큼 가져와서 쓴다 -> 과정 단축 -> 속도 증가 -> 정상적이지 않은 종료시 숫자가 5 > 20 같이 뛸수 있음
    ;

SELECT productseq.nextval FROM dual;
CREATE SEQUENCE ppseq START WITH 7;

SELECT ppseq.nextval FROM dual;













































































