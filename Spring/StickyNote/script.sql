--수업 > Spring > StickyNote > script.sql

create table tblNote (
	seq number primary key,
	memo varchar2(1000) not null,
	color char(1) not null, -- 0, 1, 2, 3
	regdate date default sysdate not null
);

create sequence note_seq;

select * from tblNote;