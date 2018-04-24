-- MVCTest > board.sql

DROP TABLE tblBoard;
DELETE FROM tblBoard;
commit;
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
    orgfilename VARCHAR2(100) NULL, -- 첨부 파일명(원본명),
    downloadcount NUMBER default 0 NULL,
    notice VARCHAR2(1) NOT NULL check (notice in ('1', '0')), -- 공지(1), 일반(0)
    secret VARCHAR2(1) NOT NULL check (secret in ('1', '0')), -- 비밀글(1), 일반(0)
    movie VARCHAR2(100) null
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
    depth NUMBER NOT NULL, -- 답변형(들여쓰기)
    filename VARCHAR2(100) NULL, -- 첨부 파일(물리명)
    orgfilename VARCHAR2(100) NULL, -- 첨부 파일명(원본명),
    downloadcount NUMBER default 0 NULL,
    notice VARCHAR2(1) NOT NULL check (notice in ('1', '0')), -- 공지(1), 일반(0)
    secret VARCHAR2(1) NOT NULL check (secret in ('1', '0')) -- 비밀글(1), 일반(0)
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
    depth NUMBER NOT NULL, -- 답변형(들여쓰기)
    filename VARCHAR2(100) NULL, -- 첨부 파일(물리명)
    orgfilename VARCHAR2(100) NULL, -- 첨부 파일명(원본명),
    downloadcount NUMBER default 0 NULL,
    notice VARCHAR2(1) NOT NULL check (notice in ('1', '0')) -- 공지(1), 일반(0)
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

-- 전체 회원수 
SELECT count(*) FROM tblMember;


-- 전체 게시물 수
SELECT count(*) FROM tblBoard;


-- 전체 댓글수 
SELECT count(*) FROM tblComment;


-- 미디어 수(첨부 이미지, 첨부 동영상)
SELECT count(filename) + count(movie) FROM tblBoard;

-- 회원별 게시물 카운트
--SELECT cnt FROM (SELECT count(*) as cnt, (SELECT name FROM tblMember WHERE id = b.id) as name FROM tblBoard b
--    GROUP BY id) ORDER BY name ASC;

SELECT count(*) FROM tblMember m LEFT OUTER JOIN tblBoard b ON m.id = b.id GROUP BY m.name ORDER BY m.name;
    
-- 회원별 댓글 카운트
SELECT count(b.seq) FROM tblMember m LEFT OUTER JOIN tblComment b ON m.id = b.id GROUP BY m.name ORDER BY m.name;



SELECT * FROM tblBoard;

SELECT c.*, (SELECT name FROM tblMember WHERE id = c.id) as name FROM tblComment c WHERE pseq = 32 ORDER BY seq DESC;


SELECT * FROM (SELECT b*
                       (SELECT name FROM tblMember ms WHERE ms.id = b.id) as name,
                       (SELECT count(*) FROM tblComment cc WHERE b.SEQ = cc.PSEQ) as ccount,
                       round((sysdate - regdate) * 24 * 60) as gap,
                       rownum as rnum 
                       FROM tblBoard b
                       WHERE notice = 0
                       ORDER BY thread DESC) WHERE rnum <= 15 AND rnum >= 1 ;


SELECT seq, subject, id, (SELECT name FROM tblMember WHERE id = b.id) as name, regdate, readcount, content, (SELECT count(*) FROM tblComment WHERE b.SEQ = PSEQ) as ccount, round((sysdate - regdate) * 24 * 60) as gap FROM tblBoard b;


SELECT * FROM 
    (SELECT se.*,
            rownum as rnum,
            (SELECT name FROM tblMember ms WHERE ms.id = se.id) as name,
            (SELECT count(*) FROM tblComment cc WHERE se.SEQ = cc.PSEQ) as ccount,
            round((sysdate - regdate) * 24 * 60) as gap
            FROM 
            (SELECT * FROM tblBoard WHERE notice = 0 order by thread DESC) se) WHERE rnum >= 16 AND rnum <= 20;
-- 좋아요 싫어요

CREATE SEQUENCE good_seq;
DROP TABLE tblGood;
CREATE TABLE tblGood (
    seq NUMBER PRIMARY KEY, -- PK
    state VARCHAR2(1) NOT NULL CHECK (state in ('g', 'b')), -- g: 좋아요, b: 싫어요
    id VARCHAR2(30) NOT NULL REFERENCES tblMember(id), -- 회원(FK)
    bseq NUMBER NOT NULL REFERENCES tblBoard(seq) -- 게시물(FK)

);

SELECT
(SELECT count(*) FROM tblGood WHERE bseq = 622 AND state = 'g') as good,
(SELECT count(*) FROM tblGood WHERE bseq = 622 AND state = 'b') as bad
FROM dual;


    SELECT * FROM tblBoard WHERE notice = 0;

SELECT * FROM tblBoard
ORDER BY notice DESC, thread DESC;
SELECT * FROM tblBoard WHERE notice = 0 ORDER BY seq ASC;

SELECT * FROM
(
SELECT s.*,  (SELECT name FROM tblMember WHERE id = s.id) as name,
            (SELECT count(*) FROM tblComment WHERE s.SEQ = PSEQ) as ccount,
            round((sysdate - regdate) * 24 * 60) as gap,
             rownum as rnum
                FROM tblBoard s WHERE notice = 1
UNION
SELECT se.*, rownum as rnum FROM (SELECT b.*, (SELECT name FROM tblMember WHERE id = b.id) as name,
                      (SELECT count(*) FROM tblComment WHERE b.SEQ = PSEQ) as ccount,
                      round((sysdate - regdate) * 24 * 60) as gap,
                      rownum as rnum 
                        FROM tblBoard b 
                            WHERE notice = 0 ORDER BY SEQ DESC) se
) WHERE rnum >= 1 AND rnum <= 100 ORDER BY NOTICE DESC, THREAD DESC;

SELECT * FROM tblBoard;

-- 해시태그 테이블

CREATE TABLE tblHashTag (
    seq NUMBER PRIMARY KEY,
    tag VARCHAR2(100) NOT NULL, -- 해시태그
    bseq NUMBER NOT NULL REFERENCEs tblBoard(seq)
    

);
SELECT * FROM tblHashTag;

CREATE SEQUENCE hashtag_seq;
DELETE FROM tblHashTag WHERE bseq = 653;
commit;
DROP TABLE tblHashTag;


SELECT * FROM (SELECT s.*, (SELECT name FROM tblMember m WHERE m.id = s.id) as name,
                   (SELECT count(*) FROM tblComment c WHERE s.SEQ = c.PSEQ) as ccount,     
                                       round((sysdate - regdate) * 24 * 60) as gap,            
                                                                     rownum as rnam        
FROM tblBoard s WHERE notice = 1)UNION SELECT b.*, (SELECT name FROM tblMember ms WHERE ms.id = b.id) as name,    
(SELECT count(*) FROM tblComment cc WHERE b.SEQ = cc.PSEQ) as ccount,                      round((sysdate - regdate) * 24 * 60) as gap,     
rownum as rnum                         FROM tblBoard b              
WHERE notice = 0)  WHERE rnum >= 1 AND rnum <= 15  
ORDER BY notice DESC, thread DESC