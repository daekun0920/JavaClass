DROP TABLE tblmemo;

CREATE TABLE tblmemo (
    seq NUMBER PRIMARY KEY, -- 메모 번호
    name VARCHAR2(50) NOT NULL, -- 작성자
    memo VARCHAR2(1000) NOT NULL, -- 메모 내용
    regdate DATE DEFAULT sysdate NOT NULL, -- 작성 시간간간간간 
    priority NUMBER(1) CHECK (priority BETWEEN 1 AND 3) NOT NULL -- 우선순위 (1. 높음 ~ 3. 낮음)
);

DROP SEQUENCE memoseq;
CREATE SEQUENCE memoseq;

SELECT * FROM tblmemo;

INSERT INTO tblmemo VALUES (memoseq.nextval, '김길동', '메모', default, 2);
INSERT INTO tblmemo VALUES (memoseq.nextval, '박아무개', '모메', default, 1);
INSERT INTO tblmemo VALUES (memoseq.nextval, '하하하', '메모멤ㅁ', default, 3);

 COMMIT;
 
 
 
 
 
 -- CallableStatement 예제 프로시저 
 -- m1()
CREATE OR REPLACE PROCEDURE proc_m1
(
    pname tbladdress.name%type,
    page tbladdress.age%type,
    ptel tbladdress.tel%type,
    paddress tbladdress.address%type
)   
IS
BEGIN
    INSERT INTO tbladdress VALUES (address_seq.nextval, pname, page, ptel, paddress, default);
    COMMIT;
END;

-- m2()
CREATE OR REPLACE PROCEDURE proc_m2
IS
BEGIN

    DELETE FROM tbladdress;
    COMMIT;
    --TRUNCATE tbladdress;
END;
 
 
-- m3()
-- 반환값
-- a. out 파라미터
-- b. return 문
set serveroutput on;
CREATE OR REPLACE PROCEDURE proc_m3
(
    vcount OUT NUMBER
)
IS
BEGIN
    SELECT count(*) INTO vcount FROM tbladdress;
END;

DECLARE
    vcount NUMBER;
BEGIN
    proc_m3(vcount);
    dbms_output.put_line(vcount);
END;
 

CREATE OR REPLACE PROCEDURE proc_m3
(   
    pseq IN NUMBER,
    pname OUT VARCHAR2,
    page OUT NUMBER,
    ptel OUT VARCHAR2
       
)
IS
BEGIN
    SELECT name, age, tel INTO pname, page, ptel 
        FROM tbladdress
            WHERE seq = pseq;
END;
 
INSERT INTO tbladdress VALUES (address_seq.nextval, '홍길동', 20, '010-2020-2020', '서울시', default);
 
SELECT * FROM tbladdress;
 
 
 
CREATE OR REPLACE PROCEDURE proc_m4
(   
    pcity VARCHAR2,
    pcursor OUT SYS_REFCURSOR
)
IS 
BEGIN
    OPEN pcursor FOR
        SELECT name, buseo, jikwi FROM tblinsa
            WHERE city = pcity;
END;
 
 

CREATE OR REPLACE PROCEDURE proc_m5
(
    ptel VARCHAR2,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN pcursor FOR SELECT name, buseo, jikwi, tel FROM tblinsa WHERE replace(tel, '-', '') like '%' || ptel || '%';
END;
 
 
 
CREATE TABLE tblbuy
(
    seq NUMBER PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    item VARCHAR2(50) NOT NULL,
    qty NUMBER NOT NULL,
    regdate DATE DEFAULT sysdate NOT NULL
);
 
 CREATE SEQUENCE buyseq;
 
CREATE OR REPLACE PROCEDURE proc_addbuy 
(
    pname VARCHAR2,
    pitem VARCHAR2,
    pqty NUMBER
)
IS
vcount NUMBER;
BEGIN
    SELECT count(*) INTO vcount FROM tblbuy WHERE name = pname AND item = pitem;
    
    IF vcount > 0 THEN
        UPDATE tblbuy SET qty = qty + pqty WHERE name = pname AND item = pitem;
    ELSE 
        INSERT INTO tblbuy VALUES (buyseq.nextval, pname, pitem, pqty, default);
    END IF;
END;
 
 
 
CREATE OR REPLACE PROCEDURE proc_listbuy 
(
    pqty NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS 
BEGIN
    OPEN pcursor FOR SELECT name,item,qty,regdate FROM tblbuy WHERE qty > pqty;
END;
 

-- 성별 가져오기
CREATE VIEW vw_gender
AS
SELECT 
    distinct substr(ssn, 8, 1) as gender,
    CASE
        WHEN substr(ssn, 8, 1) = '1' THEN '남자'
        WHEN substr(ssn, 8, 1) = '2' THEN '여자'
    END as gender_name
FROM tblinsa;


-- 부서 가져오기
CREATE VIEW vw_buseo
AS
SELECT distinct buseo FROM tblinsa;



-- 지역 가져오기
CREATE VIEW vw_city
AS
SELECT distinct city FROM tblinsa;





-- 최종 목록 가져오기
CREATE OR REPLACE PROCEDURE proc_list_insa 
(
    pgender VARCHAR2, -- 1, 2
    pbuseo VARCHAR2, -- 부서명
    pcity VARCHAR2, -- 지역명
    pcursor OUT SYS_REFCURSOR -- 결과 테이블
)
IS
BEGIN
    OPEN pcursor FOR
        SELECT * FROM tblinsa
            WHERE substr(ssn, 8, 1) = pgender AND buseo = pbuseo AND city = pcity
                ORDER BY name ASC;
END;

select * from tblinsa;


UPDATE tblinsa SET city = '서울' WHERE name = '홍길동';
UPDATE tblinsa SET city = '경기' WHERE name = '이순신';
COMMIT;



-- 회원 + 메모

-- 회원 테이블
-- 회원번호, 회원명, 나이, 전화, 이메일, 포인트, 비밀번호, 탈퇴여부
CREATE TABLE tbl_member 
(
    seq NUMBER PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    age NUMBER NOT NULL,
    tel VARCHAR2(15) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    point NUMBER DEFAULT 1000 NOT NULL,
    pw VARCHAR2(50) NOT NULL,
    ing NUMBER(1) DEFAULT 1 NOT NULL -- 탈퇴여부(회원 : 1, 탈퇴 : 0)
);


-- 메모 테이블
-- 메모번호, 제목, 내용, 작성자(회원번호), 작성시간

CREATE TABLE tbl_memo
(
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(100) NOT NULL,
    content VARCHAR2(1000) NOT NULL,
    mseq NUMBER NOT NULL REFERENCES tbl_member(seq),
    regdate DATE DEFAULT sysdate NOT NULL
);
SELECT * FROM tbl_member;

CREATE SEQUENCE member_seq;
CREATE SEQUENCE memo_seq;


SELECT seq, subject, content, (SELECT name FROM tbl_member WHERE seq = m.mseq) as mname, regdate FROM tbl_memo m ORDER BY seq DESC;


SELECT * FROM tbl_member WHERE seq = 1;


select * from tbl_memo;
 
SELECT seq, subject, content, (SELECT name FROM tbl_member WHERE seq = m.mseq) as mname, regdate 
    FROM tbl_memo m 
        WHERE (SELECT ing FROM tbl_member WHERE seq = m.mseq) = 1
            ORDER BY seq DESC;

 