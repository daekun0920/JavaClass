-- ����.sql

/*

[tblcountry]
1. ������� �������� �������ÿ�
SELECT name, capital FROM tblcountry 
*/
SELECT name, capital FROM tblcountry;


/*
2. �Ʒ��� ���� �������ÿ�.
- ��Ī(Alias)
- �÷� ����

[������] [����] [�α���] [����] [���]
���ѹα�  ����   4405     50     AS

*/
SELECT name as ������, capital as ����, population as �α���, area as ����, continent as ��� FROM tblcountry; 


/*
<<tblname>>
3. �Ʒ��� ���� �������ÿ�.
[�̸�] [Ű]   [������] [����]
���缮 178cm    64kg    �޶ѱ�
...
*/
SELECT last || first  as �̸�, height || 'cm' as Ű, weight || 'kg' as ������, nick as ���� FROM tblname;

/*
<<tblcountry>>
4. �Ʒ��� ���� �������ÿ�.
[��������]
������: ���ѹα�, ������: ����, �α���: 4405�� 
..
*/
SELECT '������ : ' || name || ', ' || '������ : ' || capital || ', ' || '�α��� : ' || population as �������� FROM tblcountry;


/*
<<employees>>
5. ������, �̸���, ����ó, �޿��� �������ÿ�
[�̸�]        [�̸���]              [����ó]       [�޿�]
Steven king   SKING@Gmail.com      515.123.4567   $24000
*/
SELECT first_name || ' ' || last_name as �̸�, email as �̸���, phone_number as ����ó, salary as �޿� FROM employees;

desc employees;


/*
<<tblname>>
6. �Ʒ��� ���� �������ÿ�.
[�̸�]    [���]
���缮    ���缮�� ������ '�޶ѱ�' �Դϴ�.
.. \' \' 
*/
SELECT last || first as �̸�, last || first || '�� ������ ' || '' || nick || '' || '�Դϴ�.' as ��� FROM tblname;


/*
<<tblsalary>> 
7. �Ʒ��� ���� �������ÿ�
[�̸�] [����] [��ձ޿�]
ȫ�浿  3100     250
*/
SELECT name as �̸�
            , m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10 + m11 + m12 as ����
            ,  (m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10 + m11 + m12) / 12 as ��ձ޿� 
            FROM tblsalary;


desc tblsalary;
SELECT * FROM tblsalary;

SELECT '������ ''�޶ѱ�''�Դϴ�.' FROM dual;


/*

WHERE�� + ������

<<tblcountry>>
1. ����(area)�� 100������ ������ �̸��� ������ �������ÿ� 

*/
SELECT name as �̸�, area as ���� FROM tblcountry WHERE area <= 100;
/*

2. �ƽþ�(AS)�� ����(EU) ����� ���� ������ �������ÿ�.

*/
SELECT * FROM tblcountry WHERE continent = 'AS' or continent = 'EU';

/*
<<employee>>
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)    
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE         
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2)  
COMMISSION_PCT          NUMBER(2,2)  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)  

3. ���� (JOB_ID)�� ���α׷���(it_prog)�� ������ �̸�(Ǯ����)�� ����ó �������ÿ�.
*/
desc employees;

SELECT LAST_NAME || FIRST_NAME as �̸�, PHONE_NUMBER as ����ó FROM employees WHERE job_id = 'IT_PROG';

/*

4. last_name�� 'Grant'�� ������ Ǯ����, ����ó, ��볯¥�� �������ÿ�.

*/
SELECT last_name || ' ' || first_name as Ǯ����, phone_number as ����ó, hire_date as ��볯¥ FROM employees WHERE last_name = 'Grant';
/*

5. Ư�� �Ŵ���(120)�� �����ϴ� ������ �̸�, �޿�, ����ó�� �������ÿ�.

*/
SELECT last_name || ' ' || first_name as �̸�, salary as �޿�, phone_number as ����ó FROM employees WHERE MANAGER_ID = '120';

/*
6. Ư�� �μ�(60, 80, 100)�� ���� �������� �̸�, ����ó, �̸���, �μ�ID�� �������ÿ�.
*/
SELECT last_name || ' ' || first_name as �̸�, phone_number as ����ó, email as �̸���, DEPARTMENT_ID as �μ�ID 
FROM employees WHERE DEPARTMENT_ID = '60' or DEPARTMENT_ID = '80'or DEPARTMENT_ID = '100'

/*
<<tblinsa>> 

7. ��ȹ�� ������ �������ÿ�

�̸�       ��?       ����           
-------- -------- ------------ 
NUM      NOT NULL NUMBER(5)    
NAME     NOT NULL VARCHAR2(20) 
SSN      NOT NULL VARCHAR2(14) 
IBSADATE NOT NULL DATE         
CITY              VARCHAR2(10) 
TEL               VARCHAR2(15) 
BUSEO    NOT NULL VARCHAR2(15) 
JIKWI    NOT NULL VARCHAR2(15) 
BASICPAY NOT NULL NUMBER(10)   
SUDANG   NOT NULL NUMBER(10)   



*/
desc tblinsa;

SELECT * FROM tblinsa WHERE BUSEO = '��ȹ��';
/*


8. ���￡ �ִ� ������ �� ������ ������ ����� �̸�, ����, ��ȭ��ȣ �������ÿ�.
*/
SELECT name as �̸�, jikwi as ����, tel as ��ȭ��ȣ FROM tblinsa WHERE city = '����' and jikwi = '����';

/*

9. �⺻�޿� + ���� ���ļ� 150���� �̻��� ���� �� ���￡ �ִ� ������ �������ÿ�
*/
SELECT * FROM tblinsa WHERE basicpay + sudang >= 1500000 and city = '����';



/*

10. ������ 15���� ������ ���� �� ������ ��� or �븮�� ������ �������ÿ�.
*/
SELECT * FROM tblinsa WHERE sudang <= 150000 and (jikwi = '���' or jikwi = '�븮');

/*

11. ������ ������ �⺻ ����(�޿� x 12) 2õ���� �̻� + ���� + ����(����)�� �������ÿ�.
*/
SELECT * FROM tblinsa WHERE basicpay * 12 > 20000000 and city = '����' and (jikwi = '����' or jikwi = '����');

/*

12. 1990��뿡 �Ի��� ���� �� ���� or ������ ���� ���� ����� �������ÿ� . 

*/
SELECT * FROM tblinsa WHERE (ibsadate >= '1990-01-01' and ibsadate < '2000-01-01') and (jikwi <> '����' and jikwi <> '����');


/*
13. 2000��~ 2002�� ���̿� �Ի��� ȫ���� ������ �������ÿ�.


*/
SELECT * FROM tblinsa WHERE (ibsadate >= '2000-01-01' and ibsadate < '2003-01-01') and buseo = 'ȫ����';

/*

<<tblname>>
14. ���� �� Ű�� 170 �̸��� ����� �������ÿ�.
*/
SELECT * FROM tblname WHERE height < 170 and gender = 'm';

/*
15. �ھ� ���� ���� ���ڸ� �������ÿ�.

*/
SELECT * FROM tblname WHERE last = '��' and gender = 'f';
/*
<<tblsalary>>
16. ��� �޿��� 250������ �Ѵ� ����� �������ÿ�.
*/

desc tblsalary;

SELECT * FROM tblsalary WHERE (m1+m2+m3+m4+m5+m6+m7+m8+m9+m10+m11+m12) / 12 > 250;



/*
17. ��ݱ�(1~6)���� ��ݱ�(7~12)�� �� ���� ���� ����� �������ÿ�.

*/
SELECT * FROM tblsalary WHERE m7+m8+m9+m10+m11+m12 > m1+m2+m3+m4+m5+m6;



-----------------------------------------------------------------------


/*

������(where) - between, in, like, distinct

*/

/*
<<tblcountry>>
1. �������� 'O��' �� ���� �������ÿ�.
    a. ������ 2���� -> _
    b. ������ ���ڼ� ������� -> %
    

*/
desc tblcountry;
SELECT * FROM tblcountry WHERE name like '_��'; 
SELECT * FROM tblcountry WHERE name like '%��';

/*

<<employees>>
2. ����ó�� 515�� �����ϴ� �������� �������ÿ�.


*/
desc employees;
SELECT * FROM employees WHERE phone_number like '515%';

/*

3. ���� ID�� 'SA' �� �����ϴ� �������� �������ÿ�.

*/
SELECT * FROM employees WHERE JOB_ID like 'SA%';
/*

4. first_name�� 'de'�� �� �������� �������ÿ�.(��ҹ��� ������� - ���ڿ� �Լ�x)

*/
SELECT * FROM employees WHERE first_name like '%de%' 
                    or first_name like '%De%'
                    or first_name like '%DE%'
                    or first_name like '%dE%';
/*
<<tblinsa>>
5. ���� ������ �������ÿ� & 6. ���� ������ �������ÿ� 

*/
desc tblinsa;
SELECT * FROM tblinsa WHERE ssn like '______-1______';
SELECT * FROM tblinsa WHERE ssn like '______-2______';
/*

7. ������ �¾ �������� �������ÿ�. (7~8����)

*/
SELECT * FROM tblinsa WHERE ssn like '___7__-_______'
                            or ssn like '___8__-_______';

/*

8. ����, ��õ�� ��� �达�鸸 �������ÿ�.

*/
SELECT * FROM tblinsa WHERE city in ('����', '��õ') and name like '��__';

/*

9. ������, �ѹ���, ���ߺ� ���� �� �����(���, �븮) �� 010 ����ڸ� �������ÿ�.

*/
SELECT * FROM tblinsa WHERE buseo in ('������', '�ѹ���', '���ߺ�') 
                        and jikwi in ('���', '�븮') 
                        and Tel like '010-____-____';
/*

10. ����, ��õ, ��⿡ ��� �Ի����� 1998~ 2000�� ������ �������� �������ÿ�

*/
SELECT * FROM tblinsa WHERE city in ('����', '��õ', '���') 
                        and ibsadate between '1998-01-01' AND '2000-12-31'; 
/*

<<employees>>

11.�μ��� ���� ������ �ȵ� �������� �������ÿ�.

*/
desc employees;
SELECT * FROM employees WHERE department_id is null;

/*

12. ������ � ������ �ִ���? (��, null�� ����)

*/
SELECT distinct JOB_ID FROM employees WHERE JOB_ID is not null;
/*

13. ������� 2002~2004�� ������ �������� ��� �μ��� �ٹ��ϴ���?

*/
SELECT distinct department_id FROM employees WHERE HIRE_DATE between '2002-01-01' and '2004-12-31';

/*

14. �޿��� 5000�� �̻��� �������� ��� �Ŵ����� ��������?

*/
SELECT distinct MANAGER_ID FROM employees WHERE SALARY >= 5000 and MANAGER_ID is not null;


/*
<<tblinsa>>
15. ���� ���� + 80���� -> ����?


*/

SELECT distinct jikwi FROM tblinsa WHERE ssn like '______-1______' and ssn like '8_____-_______';

/*

16. ���� 20���� �Ѵ� �������� ��� �����?

*/

SELECT distinct city FROM tblinsa WHERE sudang > 200000;

/*

17. ����ó�� ���� ���� ������ ��� �μ��� �Ҽ� �Ǿ� �ִ���?

*/

SELECT distinct buseo FROM tblinsa WHERE tel is null;

/*
<<tbldiary>>
18. 2018�� 1�� 20�� ���Ŀ� ������ �����?
*/

SELECT * FROM tbldiary;
SELECT WEATHER, REGDATE FROM tbldiary WHERE regdate > '2018-01-20';

/*
19. '����Ŭ', '�ڹ�', '�ڵ�' �̶�� Ű���尡 �� ������ ������ �����?
*/

SELECT WEATHER FROM tbldiary WHERE SUBJECT like '%����Ŭ%' 
                                or SUBJECT like '%�ڹ�%'
                                or SUBJECT like '%�ڵ�%';

/*
<<tblhousekeeping>>
20. ���� �� ����(price * qty)�� 50000~100000�� �̳� ���?
*/

SELECT * FROM tblhousekeeping WHERE price * qty between 50000 and 100000;

/*
<<tbltodo>>
21. 2018�� 1�� 5�� ~ 2018�� 1�� 10�� �̳��� ����� ���� ���� �ϷḦ ���� �ϵ�?
22. '~�ϱ�' ��� ������ ���� �� �� �� �Ϸ��� �ϵ���?

*/

-- 21
SELECT * FROM tbltodo;

SELECT * FROM tbltodo WHERE ADDDATE between '2018-01-05' and '2018-01-10' and COMPLETEDATE is null;

-- 22
SELECT * FROM tbltodo WHERE TITLE like '%�ϱ�%' and COMPLETEDATE is not null;

/*
<<tblinsa>>
23 ���� �������� ����?
24. ȫ���� �������� ��°�?
*/

-- 23
SELECT distinct jikwi FROM tblinsa WHERE ssn like '______-2______';

-- 24
SELECT distinct city FROM tblinsa WHERE buseo = 'ȫ����';

/*
<<tblmen>>
25. ����ģ���� �����鼭 �����Ը� �˼� ���� ���?
26. ����ģ���� '��'���̸鼭 �ڽ��� '��'���λ��?

*/

-- 25
SELECT * FROM tblmen;
SELECT * FROM tblmen WHERE COUPLE is not null and WEIGHT is null;

-- 26
SELECT * FROM tblmen WHERE COUPLE like '��__' and NAME like '��__';


/*

count()

<<tblcountry>>
1. �ƽþƿ� ������ ���� ������ ���?

*/
SELECT * FROM tblcountry;
SELECT count(*) as "�ƽþ� ���� ����" FROM tblcountry WHERE continent in ('AS', 'EU') -- 7
/*
2. �α��� 5000 ~ 20000 ���̿� ���ϴ� ������ ���?

*/
SELECT count(*) FROM tblcountry WHERE population between 5000 and 20000; -- 4 
/*
<<employees>>
3. IT_PRO �߿��� �޿��� 5000�� �Ѵ� ���� ���?

*/
desc employees;
SELECT * FROM employees;
SELECT count(*) FROM employees WHERE JOB_ID = 'IT_PROG' and SALARY > 5000;  -- 2
/*
<<tblinsa>>
4. ����ó�� 010�� �ƴ� ����� ���?(����ó �ִ� ��� �߿���)
*/
SELECT count(*) FROM tblinsa WHERE tel not like '010-____-____' and tel is not NULL; -- 42

/*
5. ���� ��� ���� ���?

*/
SELECT count(*) FROM tblinsa WHERE city <> '����'; -- 40
/*
6. ���� ���� ���?

*/
desc tblinsa;
SELECT count(*) FROM tblinsa WHERE ssn like '______-2______'; -- 29

/*
<<tblmen>>
7. �ַΰ� ���?

*/
SELECT count(*) FROM tblmen WHERE couple is NULL; -- 3
/*
<<tblhousekeeping>>
8. ���� �Ѿ��� 10������ �Ѵ� ���Ÿ� �� ��ȸ?

*/
SELECT * FROM tblhousekeeping;
SELECT count(*) FROM tblhousekeeping WHERE price * qty > 30000; -- 0
/*
sum()

1. EU�� AF�� ���� ������ �� �α���?
*/
SELECT sum(population) FROM tblcountry WHERE continent in ('EU', 'AF'); -- 14198
/*
2. �Ŵ���(108)�� �����ϴ� ������ �޿� ��

*/
desc employees;
SELECT sum(SALARY) FROM employees WHERE MANAGER_ID = '108'; -- 39600
/*
3. ����(ST_CLERK, SH_CLERK)�� ������ ���� �޿� ��?

*/
SELECT sum(SALARY) FROM employees WHERE JOB_ID in ('ST_CLERK', 'SH_CLERK');  -- 120000
/*
4. ����� �λ꿡 �ִ� �������� �޿� ��(�޿� + ����)?

*/
SELECT sum(basicpay + sudang) FROM tblinsa WHERE city in ('����', '�λ�'); -- 41060400
/*
5. ����, ������� �� �޿���?
*/
desc tblinsa;
SELECT sum(basicpay) FROM tblinsa WHERE jikwi in ('����', '����'); -- 36289000

/*
avg()

1. �ƽþƿ� ���� ������ ��� �α���?

*/
SELECT avg(population) FROM tblcountry WHERE continent = 'AS'; -- 39165
/*
2. �̸�(first_name)�� 'AN'�� ���Ե� �������� �޿� ���(��ҹ��� ���о���) -- 6270.4

*/
desc employees;
SELECT avg(SALARY) 
FROM employees 
    WHERE first_name like '%an%'
        or first_name like '%An%'
        or first_name like '%aN%'
        or first_name like '%AN%';
/*
3. ���α�(����, ����) �� ��� �޿�

*/
SELECT avg(basicpay) FROM tblinsa WHERE jikwi in ('����', '����'); -- 2419266.6666666...
/*
4. �����(�븮, ���) �� ��� �޿�?

*/
SELECT avg(basicpay) FROM tblinsa WHERE jikwi in ('�븮', '���'); -- 1268946.66666.....
/*
max(), min()

1. ������ ���� ���� ������ ����?

*/
desc tblcountry;
SELECT max(area) FROM tblcountry; -- 959
/*
2. �޿�(�޿� + ����)�� ���� ���� �޴� ����� �ݾ�

*/
SELECT min(basicpay + sudang) FROM tblinsa; -- 988000
/*
3. tblhousekeeping ���� ũ�� ���� �ݾ�? (price * qty)

*/
SELECT max(price * qty) FROM tblhousekeeping; -- 50000




/*
���ڿ� �Լ� 

1. ������� ������ �������ÿ�.(1900��� �� -> ssn)
[�̸�]        [����]
ȫ�浿         1980
�ƹ���         1985


*/
SELECT * FROM tblinsa;

SELECT name as �̸�, '19'|| substr(ssn, 1, 2) as ���� FROM tblinsa ;


/*
2. ���￡ ��� ������ �� 80���� �������?
*/
SELECT count(*) || '��'
    FROM tblinsa 
        WHERE city = '����' and substr(ssn, 8, 1) = '2' and substr(ssn, 1, 1) = '8';  -- 8

/*
3. ���α�(����/����)���� � ��(��,��,��) �� �ִ���?
*/
SELECT distinct substr(name, 1, 1) FROM tblinsa WHERE jikwi in ('����', '����');


/*
4. �������� �¾ �������� �����ؼ� �������ÿ�.(�������� -> ��, �̸�)

*/
SELECT * FROM tblinsa ORDER BY substr(ssn, 3, 2) ASC, substr(name, 1, 1) ASC;

/*

5. �̸�(first_name + last_name)�� ���� �� ������� �������ÿ�.

*/
desc employees;
SELECT * FROM employees ORDER BY length(first_name || last_name) DESC;

/*
6. �̸�(first_name + last_name)�� ���� �� ����� �� ����?

*/
SELECT max(length(first_name || last_name)) FROM employees; 
/*
7. last_name�� 4���� ������� first_name�� �����?

*/
SELECT first_name || ' ' || last_name, length(first_name) FROM employees WHERE length(last_name) = 4;








