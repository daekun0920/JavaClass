--WebContent > code > table.sql

-- ȸ�� ���̺� + �ڵ�(�Խù�) ���̺�

create table tblMember (
    id varchar2(30) primary key,        --���̵�
    pw varchar2(30) not null, --��ȣ
    name varchar2(30) not null, --�̸�
    lv number(1) not null check(lv between 1 and 3) --���(1 : �Ϲ�, 2 : ������, 3 : �ְ� ������)
);

create table tblCode (
    seq number primary key, --�Խù� ��ȣ
    subject varchar2(500) not null, --�Խù�����
    content varchar2(2000) not null, --�ڵ� ����
    code varchar2(2000) not null, --���α׷��� �ڵ�
    category  number not null REFERENCES tblcategory(seq), --ī�װ�
    regdate date default sysdate not null, --�ۼ��ð�
    id varchar2(30) not null REFERENCES tblMember(id), --�ۼ���(FK)
    filename varchar2(100) null, --÷�����ϸ�
    orgfilename varchar2(100) null --÷�����ϸ�
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
DELETE FROM tblBoard WHERE seq = 33;
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