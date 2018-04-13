--WebContent > code > table.sql

-- 회원 테이블 + 코드(게시물) 테이블

create table tblMember (
    id varchar2(30) primary key,        --아이디
    pw varchar2(30) not null, --암호
    name varchar2(30) not null, --이름
    lv number(1) not null check(lv between 1 and 3) --등급(1 : 일반, 2 : 관리자, 3 : 최고 관리자)
);

create table tblCode (
    seq number primary key, --게시물 번호
    subject varchar2(500) not null, --게시물제목
    content varchar2(2000) not null, --코드 설명
    code varchar2(2000) not null, --프로그래밍 코드
    category  number not null REFERENCES tblcategory(seq), --카테고리
    regdate date default sysdate not null, --작성시간
    id varchar2(30) not null REFERENCES tblMember(id), --작성자(FK)
    filename varchar2(100) null, --첨부파일명
    orgfilename varchar2(100) null --첨부파일명
);

select * from tblCode;

create SEQUENCE code_seq;

drop table tblcategory;
drop table tblCode;

create table tblcategory (
    seq number primary key, 
    name varchar2(100) not null
);

insert into tblcategory values ( 1, 'Java');
insert into tblcategory values ( 2, 'Oracle');
insert into tblcategory values ( 3, 'HTML');
insert into tblcategory values ( 4, 'CSS');
insert into tblcategory values ( 5, 'JavaScript');

commit;

--


SELECT c.seq, c.subject, c.content, c.code, c.category, c.regdate, c.id, c.filename, c.orgfilename, m.name, t.name as cname FROM tblcode C
    INNER JOIN tblmember M 
        ON M.ID = C.ID
            INNER JOIN tblcategory T
                ON T.seq = C.CATEGORY
                  order by seq desc;
            
SELECT C.seq, C.subject, C.CONTENT, C.code, C.CATEGORY, C.regdate, C.ID, C.filename, C.orgfilename, M.NAME FROM tblcode C
INNER JOIN tblmember M  ON M.ID = c.id order by seq desc;