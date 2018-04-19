-- MVCTest > board.sql

DROP TABLE tblBoard;

-- 2. 게시판 테이블(원글)
CREATE TABLE tblBoard (
    seq NUMBER PRIMARY KEY, -- 시퀀스
    subject VARCHAR2(500) NOT NULL, -- 글 제목
    content VARCHAR2(2000) NOT NULL, -- 글내용
    id VARCHAR2(30) not null REFERENCES tblMember(id), -- 작성자
    regdate DATE DEFAULT sysdate NOT NULL, -- 글쓴시각
    readcount NUMBER DEFAULT 0 NOT NULL, -- 조회수
    tag VARCHAR2(1) NOT NULL CHECK(tag in('y', 'n')),-- 글 내용에 태그 허용
    thread NUMBER NOT NULL, -- 답변형(정렬)
    depth NUMBER NOT NULL, -- 답변형(들여쓰기)
    filename VARCHAR2(100) NULL, -- 첨부 파일(물리명)
    orgfilename VARCHAR2(100) NOT NULL, -- 첨부 파일명(원본명),
    dowloadcount NUMBER default 0 NULL
);

CREATE TABLE tblBoard (
    seq NUMBER PRIMARY KEY, -- 시퀀스
    subject VARCHAR2(500) NOT NULL, -- 글 제목
    content VARCHAR2(2000) NOT NULL, -- 글내용
    id VARCHAR2(30) not null REFERENCES tblMember(id), -- 작성자
    regdate DATE DEFAULT sysdate NOT NULL, -- 글쓴시각
    readcount NUMBER DEFAULT 0 NOT NULL, -- 조회수
    tag VARCHAR2(1) NOT NULL CHECK(tag in('y', 'n')),-- 글 내용에 태그 허용
    thread NUMBER NOT NULL, -- 답변형(정렬)
    depth NUMBER NOT NULL -- 답변형(들여쓰기)
    
);
CREATE SEQUENCE board_seq;

INSERT INTO tblBoard (seq, subject, content, id, regdate, readcount, tag)
    VALUES (board_seq.nextval, '게시판 첫글입니다.', '내용입니다.', 'hong', default, default, 'y');

SELECT * FROM tblBoard;



DROP TABLE tblComment;
-- 댓글 테이블
CREATE TABLE tblComment (
    seq NUMBER PRIMARY KEY, -- 댓글번호(PK)
    id VARCHAR2(30) NOT NULL REFERENCES tblMember(id), -- 글쓴이
    content VARCHAR2(1000) NOT NULL, -- 댓글 내용
    regdate DATE DEFAULT SYSDATE NOT NULL, -- 글쓴 시각
    pseq NUMBER NOT NULL REFERENCES tblBoard(seq) -- 부모글(FK)
    
);

CREATE SEQUENCE comment_seq;

SELECT * FROM tblComment;



SELECT * FROM tblBoard;

SELECT c.*, (SELECT name FROM tblMember WHERE id = c.id) as name FROM tblComment c WHERE pseq = 32 ORDER BY seq DESC;





SELECT seq, subject, id, (SELECT name FROM tblMember WHERE id = b.id) as name, regdate, readcount, content, (SELECT count(*) FROM tblComment WHERE b.SEQ = PSEQ) as ccount, round((sysdate - regdate) * 24 * 60) as gap FROM tblBoard b;







