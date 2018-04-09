-- JSPTest > WebContent > address > table.sql

SELECT * FROM tabs ORDER BY table_name asc;


CREATE TABLE tbladdress(
    
    seq NUMBER PRIMARY KEY, -- 기본키
    name VARCHAR2(30) NOT NULL, -- 이름
    address VARCHAR2(300) NOT NULL, -- 주소
    age NUMBER NOT NULL, -- 나이
    gender VARCHAR2(1) CHECK (gender in ('m','f')) NOT NULL, -- 성별(m, f)
    tel VARCHAR2(15) NOT NULL
    
)


DROP SEQUENCE address_seq;
CREATE SEQUENCE address_seq;

SELECT * FROM tbladdress;