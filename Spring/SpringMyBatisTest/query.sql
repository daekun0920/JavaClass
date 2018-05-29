CREATE TABLE tblMyBatis(
seq number PRIMARY KEY,
num number not null,
txt varchar2(100) not null
);

CREATE SEQUENCE mybatis_seq;

INSERT INTO tblMyBatis VALUES (mybatis_seq.nextval,0,'없음');
INSERT INTO tblMyBatis VALUES (mybatis_seq.nextval,1,'조금');
INSERT INTO tblMyBatis VALUES (mybatis_seq.nextval,2,'중간');
INSERT INTO tblMyBatis VALUES (mybatis_seq.nextval,3,'많음');

COMMIT ;