-- Class > Server > AjaxTest > table.sql

-- ���� ����
create table tblResearch (
	seq number primary key,					--PK
	question varchar2(300) not null,		--����
	answer1 varchar2(300) not null,		--�׸�1
	answer2 varchar2(300) not null,		--�׸�2
	answer3 varchar2(300) not null,		--�׸�3
	answer4 varchar2(300) not null,		--�׸�4
	cnt1 number default 0 not null,		--����1
	cnt2 number default 0 not null,		--����2
	cnt3 number default 0 not null,		--����3
	cnt4 number default 0 not null		--����4
);

insert into tblResearch values (1, '쌍용교육센터'
							, 'JAVA', 'SQL', 'HTML', 'JavaScript'
							, default, default, default, default);

commit;

select * from tblResearch;

update tblResearch set
	cnt1 = 15,
	cnt2 = 12,
	cnt3 = 19,
	cnt4 = 8
		where seq = 1;

SELECT * FROM tblinsa;




