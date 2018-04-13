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
    tag VARCHAR2(1) NOT NULL CHECK(tag in('y', 'n'))-- 글 내용에 태그 허용

);

CREATE SEQUENCE board_seq;

INSERT INTO tblBoard (seq, subject, content, id, regdate, readcount, tag)
    VALUES (board_seq.nextval, '게시판 첫글입니다.', '내용입니다.', 'hong', default, default, 'y');

SELECT * FROM tblBoard;























