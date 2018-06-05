-- transaction


-- 게시판
CREATE TABLE tblTranBoard (
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(500) NOT NULL



);

-- 댓글
CREATE TABLE tblTranComment (
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(500) NOT NULL,
    bseq NUMBER NOT NULL REFERENCES tblTranBoard(seq)
);

INSERT INTO tblTranBoard VALUES (1, '게시판 입니다');

INSERT INTO tblTranComment VALUES (1, '1', 1);
INSERT INTO tblTranComment VALUES (2, '2', 1);
SELECT * FROM tblTranComment;
commit;