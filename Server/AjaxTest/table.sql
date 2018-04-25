-- Class > Server > AjaxTest > table.sql

-- 설문 조사
create table tblResearch (
	seq number primary key,					--PK
	question varchar2(300) not null,		--질문
	answer1 varchar2(300) not null,		--항목1
	answer2 varchar2(300) not null,		--항목2
	answer3 varchar2(300) not null,		--항목3
	answer4 varchar2(300) not null,		--항목4
	cnt1 number default 0 not null,		--선택1
	cnt2 number default 0 not null,		--선택2
	cnt3 number default 0 not null,		--선택3
	cnt4 number default 0 not null		--선택4
);

insert into tblResearch values (1, '사용가능한 프로그래밍 언어는?'
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





