-- WebContent > code > table.sql

-- 회원 테이블 + 코드(게시물) 테이블

DROP TABLE tblCategory;

CREATE table tblMember (
    id VARCHAR2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    lv number(1) not null check(lv between 1 and 3)
    
);



CREATE TABLE tblCategory (

    seq NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL

);

INSERT INTO tblCategory VALUES (1, 'Java');
INSERT INTO tblCategory VALUES (2, 'Oracle');
INSERT INTO tblCategory VALUES (3, 'HTML');
INSERT INTO tblCategory VALUES (4, 'CSS');
INSERT INTO tblCategory VALUES (5, 'JavaScript');


DROP TABLE tblCode;

CREATE SEQUENCE code_seq;

CREATE TABLE tblCode (

    seq NUMBER PRIMARY KEY, -- 게시물 번호
    subject VARCHAR2(500) NOT NULL, -- 게시물 제목
    content VARCHAR2(2000) NOT NULL, -- 코드 설명
    code VARCHAR2(2000) NOT NULL, -- 프로그래밍 코드
    category NUMBER NOT NULL REFERENCES tblCategory(seq), -- 카테고리
    regdate DATE DEFAULT sysdate NOT NULL, -- 작성시간
    id VARCHAR2(30) NOT NULL REFERENCES tblMember(id), -- 작성자(FK)
    filename varchar2(100) null,   -- 첨부파일명
    orgfilename varchar2(100) null -- 첨부파일명
);



commit;
SELECT * FROM tblCode;

