CREATE TABLE tblSpringMember (

	id VARCHAR2(50) PRIMARY KEY,
	pw VARCHAR2(50) NOT NULL,
	name VARCHAR2(50) NOT NULL



);

CREATE TABLE tblSpringCategory (
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(50) NOT NULL


);
SELECT m.*, (SELECT name FROM tblSpringMember WHERE id = m.id) as name, (SELECT name FROM tblSpringCategory WHERE seq = m.category) as categoryName FROM tblSpringMemo m;

CREATE TABLE tblSpringMemo (

	
	seq NUMBER PRIMARY KEY,
	id VARCHAR2(50) NOT NULL references tblSpringMember(id),
	memo VARCHAR2(2000) NOT NULL,
	regDate date default sysdate NOT NULL,
	category NUMBER NOT NULL references tblSpringCategory(seq)
	


);

SELECT * FROM tblSpringMemo;

commit;
INSERT INTO tblSpringMember VALUES ('hong', '1111', '홍길동');
INSERT INTO tblSpringMember VALUES ('dddd', '1111', '홍길동');
INSERT INTO tblSpringMember VALUES ('bbbb', '1111', '홍길동');
INSERT INTO tblSpringMember VALUES ('cccc', '1111', '홍길동');
commit;
INSERT INTO tblSpringCategory VALUES (1, '할일');
INSERT INTO tblSpringCategory VALUES (2, '스터');
INSERT INTO tblSpringCategory VALUES (3, '업무');
INSERT INTO tblSpringCategory VALUES (4,'서비스');
