CREATE TABLE tblSpringMember (

	id VARCHAR2(50) PRIMARY KEY,
	pw VARCHAR2(50) NOT NULL,
	name VARCHAR2(50) NOT NULL



);

CREATE TABLE tblSpringCategory (
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(50) NOT NULL


);

CREATE TABLE tblSpringMemo (

	
	seq NUMBER PRIMARY KEY,
	id VARCHAR2(50) NOT NULL references tblSpringMember(id),
	memo VARCHAR2(2000) NOT NULL,
	regDate date default sysdate NOT NULL,
	category NUMBER NOT NULL references tblSpringCategory(seq)
	


);

INSERT INTO tblSpringMember VALUES ('hong', '1111', '홍길동);
INSERT INTO tblSpringMember VALUES ('aaaa', '1111', '홍길동);
INSERT INTO tblSpringMember VALUES ('bbbb', '1111', '홍길동);
INSERT INTO tblSpringMember VALUES ('cccc', '1111', '홍길동);

INSERT INTO tblSpringCategory VALUES ('hong', '1111', '홍길동);