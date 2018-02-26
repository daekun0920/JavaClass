-- 문제.sql

/*

[tblcountry]
1. 국가명과 수도명을 가져오시오
SELECT name, capital FROM tblcountry 
*/
SELECT name, capital FROM tblcountry;


/*
2. 아래와 같이 가져오시오.
- 별칭(Alias)
- 컬럼 순서

[국가명] [수도] [인구수] [면적] [대륙]
대한민국  서울   4405     50     AS

*/
SELECT name as 국가명, capital as 수도, population as 인구수, area as 면적, continent as 대륙 FROM tblcountry; 


/*
<<tblname>>
3. 아래와 같이 가져오시오.
[이름] [키]   [몸무게] [별명]
유재석 178cm    64kg    메뚜기
...
*/
SELECT last || first  as 이름, height || 'cm' as 키, weight || 'kg' as 몸무게, nick as 별명 FROM tblname;

/*
<<tblcountry>>
4. 아래와 같이 가져오시오.
[국가정보]
국가명: 대한민국, 수도명: 서울, 인구수: 4405명 
..
*/
SELECT '국가명 : ' || name || ', ' || '수도명 : ' || capital || ', ' || '인구수 : ' || population as 국가정보 FROM tblcountry;


/*
<<employees>>
5. 직원명, 이메일, 연락처, 급여를 가져오시오
[이름]        [이메일]              [연락처]       [급여]
Steven king   SKING@Gmail.com      515.123.4567   $24000
*/
SELECT first_name || ' ' || last_name as 이름, email as 이메일, phone_number as 연락처, salary as 급여 FROM employees;

desc employees;


/*
<<tblname>>
6. 아래와 같이 가져오시오.
[이름]    [비고]
유재석    유재석의 별명은 '메뚜기' 입니다.
.. \' \' 
*/
SELECT last || first as 이름, last || first || '의 별명은 ' || '' || nick || '' || '입니다.' as 비고 FROM tblname;


/*
<<tblsalary>> 
7. 아래와 같이 가져오시오
[이름] [연봉] [평균급여]
홍길동  3100     250
*/
SELECT name as 이름
            , m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10 + m11 + m12 as 연봉
            ,  (m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10 + m11 + m12) / 12 as 평균급여 
            FROM tblsalary;


desc tblsalary;
SELECT * FROM tblsalary;

SELECT '별명은 ''메뚜기''입니다.' FROM dual;


/*

WHERE절 + 연산자

<<tblcountry>>
1. 면적(area)이 100이하인 국가의 이름과 면적을 가져오시오 

*/
SELECT name as 이름, area as 면적 FROM tblcountry WHERE area <= 100;
/*

2. 아시아(AS)와 유럽(EU) 대륙에 속한 나라만을 가져오시오.

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

3. 직업 (JOB_ID)이 프로그래머(it_prog)인 직원의 이름(풀네임)과 연락처 가져오시오.
*/
desc employees;

SELECT LAST_NAME || FIRST_NAME as 이름, PHONE_NUMBER as 연락처 FROM employees WHERE job_id = 'IT_PROG';

/*

4. last_name이 'Grant'인 직원의 풀네임, 연락처, 고용날짜를 가져오시오.

*/
SELECT last_name || ' ' || first_name as 풀네임, phone_number as 연락처, hire_date as 고용날짜 FROM employees WHERE last_name = 'Grant';
/*

5. 특정 매니저(120)가 관리하는 직원의 이름, 급여, 연락처를 가져오시오.

*/
SELECT last_name || ' ' || first_name as 이름, salary as 급여, phone_number as 연락처 FROM employees WHERE MANAGER_ID = '120';

/*
6. 특정 부서(60, 80, 100)에 속한 직원들의 이름, 연락처, 이메일, 부서ID를 가져오시오.
*/
SELECT last_name || ' ' || first_name as 이름, phone_number as 연락처, email as 이메일, DEPARTMENT_ID as 부서ID 
FROM employees WHERE DEPARTMENT_ID = '60' or DEPARTMENT_ID = '80'or DEPARTMENT_ID = '100'

/*
<<tblinsa>> 

7. 기획부 직원들 가져오시오

이름       널?       유형           
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

SELECT * FROM tblinsa WHERE BUSEO = '기획부';
/*


8. 서울에 있는 직원들 중 직위가 부장인 사람의 이름, 직위, 전화번호 가져오시오.
*/
SELECT name as 이름, jikwi as 직위, tel as 전화번호 FROM tblinsa WHERE city = '서울' and jikwi = '부장';

/*

9. 기본급여 + 수당 합쳐서 150만원 이상인 직원 중 서울에 있는 직원만 가져오시오
*/
SELECT * FROM tblinsa WHERE basicpay + sudang >= 1500000 and city = '서울';



/*

10. 수당이 15만원 이하인 직원 중 직위가 사원 or 대리인 직원만 가져오시오.
*/
SELECT * FROM tblinsa WHERE sudang <= 150000 and (jikwi = '사원' or jikwi = '대리');

/*

11. 수당을 제외한 기본 연봉(급여 x 12) 2천만원 이상 + 서울 + 과장(부장)만 가져오시오.
*/
SELECT * FROM tblinsa WHERE basicpay * 12 > 20000000 and city = '서울' and (jikwi = '과장' or jikwi = '부장');

/*

12. 1990년대에 입사한 직원 중 과장 or 부장을 달지 못한 사람만 가져오시오 . 

*/
SELECT * FROM tblinsa WHERE (ibsadate >= '1990-01-01' and ibsadate < '2000-01-01') and (jikwi <> '부장' and jikwi <> '과장');


/*
13. 2000년~ 2002년 사이에 입사한 홍보부 직원만 가져오시오.


*/
SELECT * FROM tblinsa WHERE (ibsadate >= '2000-01-01' and ibsadate < '2003-01-01') and buseo = '홍보부';

/*

<<tblname>>
14. 남자 중 키가 170 미만인 사람을 가져오시오.
*/
SELECT * FROM tblname WHERE height < 170 and gender = 'm';

/*
15. 박씨 성을 가진 여자만 가져오시오.

*/
SELECT * FROM tblname WHERE last = '박' and gender = 'f';
/*
<<tblsalary>>
16. 평균 급여가 250만원이 넘는 사람만 가져오시오.
*/

desc tblsalary;

SELECT * FROM tblsalary WHERE (m1+m2+m3+m4+m5+m6+m7+m8+m9+m10+m11+m12) / 12 > 250;



/*
17. 상반기(1~6)보다 상반기(7~12)에 더 많이 받은 사람만 가져오시오.

*/
SELECT * FROM tblsalary WHERE m7+m8+m9+m10+m11+m12 > m1+m2+m3+m4+m5+m6;



-----------------------------------------------------------------------


/*

조건절(where) - between, in, like, distinct

*/

/*
<<tblcountry>>
1. 국가명이 'O국' 인 나라를 가져오시오.
    a. 국가명 2글자 -> _
    b. 국가명 글자수 상관없이 -> %
    

*/
desc tblcountry;
SELECT * FROM tblcountry WHERE name like '_국'; 
SELECT * FROM tblcountry WHERE name like '%국';

/*

<<employees>>
2. 연락처가 515로 시작하는 직원들을 가져오시오.


*/
desc employees;
SELECT * FROM employees WHERE phone_number like '515%';

/*

3. 직업 ID가 'SA' 로 시작하는 직원들을 가져오시오.

*/
SELECT * FROM employees WHERE JOB_ID like 'SA%';
/*

4. first_name에 'de'가 들어간 직원들을 가져오시오.(대소문자 상관없이 - 문자열 함수x)

*/
SELECT * FROM employees WHERE first_name like '%de%' 
                    or first_name like '%De%'
                    or first_name like '%DE%'
                    or first_name like '%dE%';
/*
<<tblinsa>>
5. 남자 직원만 가져오시오 & 6. 여자 직원만 가져오시오 

*/
desc tblinsa;
SELECT * FROM tblinsa WHERE ssn like '______-1______';
SELECT * FROM tblinsa WHERE ssn like '______-2______';
/*

7. 여름에 태어난 직원들을 가져오시오. (7~8월생)

*/
SELECT * FROM tblinsa WHERE ssn like '___7__-_______'
                            or ssn like '___8__-_______';

/*

8. 서울, 인천에 사는 김씨들만 가져오시오.

*/
SELECT * FROM tblinsa WHERE city in ('서울', '인천') and name like '김__';

/*

9. 영업부, 총무부, 개발부 직원 중 사원급(사원, 대리) 인 010 사용자를 가져오시오.

*/
SELECT * FROM tblinsa WHERE buseo in ('영업부', '총무부', '개발부') 
                        and jikwi in ('사원', '대리') 
                        and Tel like '010-____-____';
/*

10. 서울, 인천, 경기에 살고 입사일이 1998~ 2000년 사이인 직원들을 가져오시오

*/
SELECT * FROM tblinsa WHERE city in ('서울', '인천', '경기') 
                        and ibsadate between '1998-01-01' AND '2000-12-31'; 
/*

<<employees>>

11.부서가 아직 배정이 안된 직원들을 가져오시오.

*/
desc employees;
SELECT * FROM employees WHERE department_id is null;

/*

12. 직업이 어떤 종류가 있는지? (단, null은 제외)

*/
SELECT distinct JOB_ID FROM employees WHERE JOB_ID is not null;
/*

13. 고용일이 2002~2004년 사이인 직원들은 어느 부서에 근무하는지?

*/
SELECT distinct department_id FROM employees WHERE HIRE_DATE between '2002-01-01' and '2004-12-31';

/*

14. 급여가 5000불 이상인 직원들의 담당 매니저는 누구인지?

*/
SELECT distinct MANAGER_ID FROM employees WHERE SALARY >= 5000 and MANAGER_ID is not null;


/*
<<tblinsa>>
15. 남자 직원 + 80년대생 -> 직급?


*/

SELECT distinct jikwi FROM tblinsa WHERE ssn like '______-1______' and ssn like '8_____-_______';

/*

16. 수당 20만원 넘는 직원들은 어디 사는지?

*/

SELECT distinct city FROM tblinsa WHERE sudang > 200000;

/*

17. 연락처가 아직 없는 직원은 어느 부서에 소속 되어 있는지?

*/

SELECT distinct buseo FROM tblinsa WHERE tel is null;

/*
<<tbldiary>>
18. 2018년 1월 20일 이후에 날씨가 어땠는지?
*/

SELECT * FROM tbldiary;
SELECT WEATHER, REGDATE FROM tbldiary WHERE regdate > '2018-01-20';

/*
19. '오라클', '자바', '코딩' 이라는 키워드가 들어간 날들은 날씨가 어땠는지?
*/

SELECT WEATHER FROM tbldiary WHERE SUBJECT like '%오라클%' 
                                or SUBJECT like '%자바%'
                                or SUBJECT like '%코딩%';

/*
<<tblhousekeeping>>
20. 구매 총 가격(price * qty)이 50000~100000원 이내 목록?
*/

SELECT * FROM tblhousekeeping WHERE price * qty between 50000 and 100000;

/*
<<tbltodo>>
21. 2018년 1월 5일 ~ 2018년 1월 10일 이내에 등록한 일중 아직 완료를 안한 일들?
22. '~하기' 라고 제목을 붙인 할 일 중 완료한 일들은?

*/

-- 21
SELECT * FROM tbltodo;

SELECT * FROM tbltodo WHERE ADDDATE between '2018-01-05' and '2018-01-10' and COMPLETEDATE is null;

-- 22
SELECT * FROM tbltodo WHERE TITLE like '%하기%' and COMPLETEDATE is not null;

/*
<<tblinsa>>
23 여자 직원들의 직위?
24. 홍보부 직원들이 사는곳?
*/

-- 23
SELECT distinct jikwi FROM tblinsa WHERE ssn like '______-2______';

-- 24
SELECT distinct city FROM tblinsa WHERE buseo = '홍보부';

/*
<<tblmen>>
25. 여자친구가 있으면서 몸무게를 알수 없는 사람?
26. 여자친구가 '김'씨이면서 자신은 '박'씨인사람?

*/

-- 25
SELECT * FROM tblmen;
SELECT * FROM tblmen WHERE COUPLE is not null and WEIGHT is null;

-- 26
SELECT * FROM tblmen WHERE COUPLE like '김__' and NAME like '박__';


/*

count()

<<tblcountry>>
1. 아시아와 유럽에 속한 국가는 몇개국?

*/
SELECT * FROM tblcountry;
SELECT count(*) as "아시아 유럽 국가" FROM tblcountry WHERE continent in ('AS', 'EU') -- 7
/*
2. 인구가 5000 ~ 20000 사이에 속하는 국가는 몇개국?

*/
SELECT count(*) FROM tblcountry WHERE population between 5000 and 20000; -- 4 
/*
<<employees>>
3. IT_PRO 중에서 급여가 5000불 넘는 직원 몇명?

*/
desc employees;
SELECT * FROM employees;
SELECT count(*) FROM employees WHERE JOB_ID = 'IT_PROG' and SALARY > 5000;  -- 2
/*
<<tblinsa>>
4. 연락처가 010이 아닌 사람이 몇명?(연락처 있는 사람 중에서)
*/
SELECT count(*) FROM tblinsa WHERE tel not like '010-____-____' and tel is not NULL; -- 42

/*
5. 서울 사람 빼고 몇명?

*/
SELECT count(*) FROM tblinsa WHERE city <> '서울'; -- 40
/*
6. 여자 직원 몇명?

*/
desc tblinsa;
SELECT count(*) FROM tblinsa WHERE ssn like '______-2______'; -- 29

/*
<<tblmen>>
7. 솔로가 몇명?

*/
SELECT count(*) FROM tblmen WHERE couple is NULL; -- 3
/*
<<tblhousekeeping>>
8. 구매 총액이 10만원을 넘는 구매를 총 몇회?

*/
SELECT * FROM tblhousekeeping;
SELECT count(*) FROM tblhousekeeping WHERE price * qty > 30000; -- 0
/*
sum()

1. EU와 AF에 속한 나라의 총 인구합?
*/
SELECT sum(population) FROM tblcountry WHERE continent in ('EU', 'AF'); -- 14198
/*
2. 매니저(108)가 관리하는 직원의 급여 합

*/
desc employees;
SELECT sum(SALARY) FROM employees WHERE MANAGER_ID = '108'; -- 39600
/*
3. 직업(ST_CLERK, SH_CLERK)을 가지는 직원 급여 합?

*/
SELECT sum(SALARY) FROM employees WHERE JOB_ID in ('ST_CLERK', 'SH_CLERK');  -- 120000
/*
4. 서울과 부산에 있는 직원들의 급여 합(급여 + 수당)?

*/
SELECT sum(basicpay + sudang) FROM tblinsa WHERE city in ('서울', '부산'); -- 41060400
/*
5. 부장, 과장들의 총 급여합?
*/
desc tblinsa;
SELECT sum(basicpay) FROM tblinsa WHERE jikwi in ('부장', '과장'); -- 36289000

/*
avg()

1. 아시아에 속한 국가의 평균 인구수?

*/
SELECT avg(population) FROM tblcountry WHERE continent = 'AS'; -- 39165
/*
2. 이름(first_name)에 'AN'이 포함된 직원들의 급여 평균(대소문자 구분없이) -- 6270.4

*/
desc employees;
SELECT avg(SALARY) 
FROM employees 
    WHERE first_name like '%an%'
        or first_name like '%An%'
        or first_name like '%aN%'
        or first_name like '%AN%';
/*
3. 간부급(과장, 부장) 의 평균 급여

*/
SELECT avg(basicpay) FROM tblinsa WHERE jikwi in ('과장', '부장'); -- 2419266.6666666...
/*
4. 사원급(대리, 사원) 의 평균 급여?

*/
SELECT avg(basicpay) FROM tblinsa WHERE jikwi in ('대리', '사원'); -- 1268946.66666.....
/*
max(), min()

1. 면적이 가장 넓은 나라의 면적?

*/
desc tblcountry;
SELECT max(area) FROM tblcountry; -- 959
/*
2. 급여(급여 + 수당)가 가장 적게 받는 사람의 금액

*/
SELECT min(basicpay + sudang) FROM tblinsa; -- 988000
/*
3. tblhousekeeping 가장 크게 지른 금액? (price * qty)

*/
SELECT max(price * qty) FROM tblhousekeeping; -- 50000




/*
문자열 함수 

1. 직원명과 생년을 가져오시오.(1900년대 생 -> ssn)
[이름]        [생년]
홍길동         1980
아무게         1985


*/
SELECT * FROM tblinsa;

SELECT name as 이름, '19'|| substr(ssn, 1, 2) as 생년 FROM tblinsa ;


/*
2. 서울에 사는 여직원 중 80년대생 몇명인지?
*/
SELECT count(*) || '명'
    FROM tblinsa 
        WHERE city = '서울' and substr(ssn, 8, 1) = '2' and substr(ssn, 1, 1) = '8';  -- 8

/*
3. 간부급(과장/부장)들은 어떤 성(김,이,박) 이 있는지?
*/
SELECT distinct substr(name, 1, 1) FROM tblinsa WHERE jikwi in ('과장', '부장');


/*
4. 직원들을 태어난 월순으로 정렬해서 가져오시오.(오름차순 -> 월, 이름)

*/
SELECT * FROM tblinsa ORDER BY substr(ssn, 3, 2) ASC, substr(name, 1, 1) ASC;

/*

5. 이름(first_name + last_name)이 가장 긴 순서대로 가져오시오.

*/
desc employees;
SELECT * FROM employees ORDER BY length(first_name || last_name) DESC;

/*
6. 이름(first_name + last_name)이 가장 긴 사람은 몇 글자?

*/
SELECT max(length(first_name || last_name)) FROM employees; 
/*
7. last_name이 4자인 사람들은 first_name이 몇글자?

*/
SELECT first_name || ' ' || last_name, length(first_name) FROM employees WHERE length(last_name) = 4;








