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

SELECT * FROM tblBoard;



CREATE OR REPLACE VIEW vwBoard 
AS
    SELECT * FROM 
        (SELECT a.*, rownum as rnum FROM 
                                (SELECT seq, subject, id, to_char(regdate, 'yy-mm-dd') as regdate, readcount FROM tblBoard
                                    ORDER BY seq DESC) 
        a);
    
DROP VIEW vwBoard;




-- 고양이 위치값 테이블
CREATE TABLE tblPosition (
    seq NUMBER PRIMARY KEY, -- PK
    id VARCHAR2(100) NOT NULL, -- 태그 ID (cat1)
    x NUMBER NOT NULL,
    y NUMBER NOT NULL
);

CREATE SEQUENCE position_seq;

-- 추천 검색어
CREATE TABLE tblWord (
    
    word VARCHAR2(200)

);
SELECT * FROM tblWord;
