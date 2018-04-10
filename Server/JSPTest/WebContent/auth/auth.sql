
drop table tblMember;

CREATE table tblMember (
    id VARCHAR2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    lv number(1) not null check(lv between 1 and 3)
    

);

insert into tblMember values ('hong', '1111', '홍길동', 1);
insert into tblMember values ('test', '1111', '테스트', 1);
insert into tblMember values ('dog', '1111', '강아지', 1);
insert into tblMember values ('cat', '1111', '고양이', 1);
insert into tblMember values ('admin', '1111', '관리자', 3);


commit;