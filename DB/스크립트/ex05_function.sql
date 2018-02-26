/*
ex05_function.sql

오라클 함수
- 수많은 기능 -> 함수 형태로 제공


집계 함수, 통계 함수, 집약 함수, 집합 함수
-> 집계 결과를 만들어 낸다.
-> 복수의 행을 입력받아 단일 값을 반환한다.

1. count() : 갯수
2. sum() : 합계
3. avg() : 평균
4. max() : 최댓값
5. min() : 최솟값


*/

/*
1. count()
- number count(컬럼명)***
- number count(연산식)
- number count(상수)
- 해당 컬럼값을 가지고 있는 레코드의 수를 반환(Null값이 아닌) (행 갯수 반환)
- count(*, 레코드 단위로 센다) -> 모든 컬럼중에 하나라도 값을 가지고 있으면 레코드는 존재 하는것이므로 카운트 +1 된다.
*/
SELECT * FROM tblname;
SELECT count(*) FROM tblname;
SELECT count(*) FROM tblinsa;
SELECT count(*) FROM employees;

SELECT * FROM tblinsa;
SELECT count(name) FROM tblinsa; -- name 컬럼에 값을 가지고 있는 레코드가 몇개냐?
SELECT count(tel) FROM tblinsa; 

SELECT count(*) FROM tbltodo; -- 모든 할일의 갯수
SELECT count(completedate) FROM tbltodo; -- null값이 들어있는 레코드 제외한 갯수 -> 완료한 일의 갯수 

-- 아직 해야할 일의 갯수?
SELECT count(*) - count(completedate) FROM tbltodo;

SELECT count(*) FROM tbltodo WHERE completedate is NULL;

SELECT count(*) FROM tbltodo; -- count(*, 레코드 단위로 센다) -> 모든 컬럼중에 하나라도 값을 가지고 있으면 레코드는 존재 하는것이므로 카운트 +1 된다.


-- tblinsa
-- 서울 사는 직원은 몇명?
SELECT * FROM tblinsa WHERE city = '서울';
SELECT count(*) FROM tblinsa WHERE city = '서울';

-- 상여금 -> 1000000000원
-- 1 / N
SELECT count(*) FROM tblinsa;
SELECT 1000000000 / 60 FROM tblinsa; -- 안좋은 쿼리
SELECT 1000000000 / count(*) FROM tblinsa; 

SELECT BUSEO FROM tblinsa;
-- 너희 회사에는 어떤 부서가?
SELECT distinct BUSEO FROM tblinsa;
-- 너희 회사에는 부서가 총 몇개?
SELECT count(DISTINCT BUSEO) FROM tblinsa;

-- 집계 함수 사용시 주의할 것!!!!!
-- 1. 집계함수의 결과는 일반 컬럼과 함꼐 컬럼 리스트에 나올 수 없다. -> 개인 데이터(name)와 공용 데이터(count)의 분리 
-- : ORA-00937: not a single-group group function
-- 2. 집계함수의 결과는 WHERE절에서 사용할 수 없다.
-- : ORA-00934: group function is not allowed here
SELECT name, count(*) FROM tblinsa;

SELECT name FROM tblinsa;
SELECT count(*) FROM tblinsa;


SELECT avg(basicpay) FROM tblinsa;
SELECT * FROM tblinsa WHERE basicpay >= avg(basicpay); -- 불가능 ORA-00934: group function is not allowed here

/*

2. sum()
- number sum(컬럼명)
- 해당 컬럼값의 총 합을 반환
- 숫자 컬럼만을 대상으로..


*/
SELECT sum(height) FROM tblname; -- O
SELECT sum(nick) FROM tblname; -- X 
SELECT sum(*) FROM tblname; -- X '*' 은 count 함수만 사용

SELECT sum(weight), sum(weight + 10), sum(weight) + 10 FROM tblname;

SELECT sum(sudang * 2) FROM tblinsa;
SELECT sudang * 2 FROM tblinsa;

-- 평균 급여
SELECT 급여합 / 직원수 FROM tblinsa;
SELECT sum(basicpay + sudang) / count(*) FROM tblinsa;
SELECT avg(basicpay + sudang) FROM tblinsa


/*

3. avg()
- number avg(컬럼명)
- 숫자 컬럼을 대상으로..

*/

SELECT population FROM tblcountry; -- NULL이 포함된 컬럼
SELECT sum(population) FROM tblcountry;
SELECT sum(population) / count(*) FROM tblcountry; -- 14475 -- 인구수가 NULL 값인 케냐까지 count(*)에 의해 포함되서 값이 더 작다 
SELECT sum(population) / count(population) FROM tblcountry; -- 15588
SELECT avg(population) FROM tblcountry; -- 15588

-- SELECT 10억 / 전체 직원수 FROM 사원; -- count(*)       count(*)
-- SELECT 10억 / 참여직원 FROM 사원;    -- count(프로젝트) avg()

-- SELECT avg(ibsadate) FROM tblinsa; -- 날짜 평균 X 

/*

4.max()
5.min()
- object max(컬럼명)
- object min(컬럼명)
- 해당 컬럼의 가장 큰값 or 작은값 반환
- 숫자, 문자, 날짜 모두 사용 가능

*/

SELECT basicpay FROM tblinsa;
SELECT avg(basicpay) FROM tblinsa; -- 1556526
SELECT max(basicpay) FROM tblinsa; -- 2650000
SELECT min(basicpay) FROM tblinsa; -- 840000

SELECT name FROM tblinsa WHERE basicpay = 2650000;
SELECT name FROM tblinsa WHERE basicpay = max(basicpay); -- X 사용 불가 

SELECT 
    count(*) as "총 직원수",
    sum(basicpay) as "총 급여 합",
    avg(basicpay) as "평균 급여",
    max(basicpay) as "최대 급여",
    min(basicpay) as "최소 급여",
    max(basicpay) - avg(basicpay) as "평균급여 초과분",
    avg(basicpay) - min(basicpay) as "평균급여 미달분"
FROM tblinsa;
    
/*

수학 함수
round()
- 반올림
- number round(컬럼명)
- number round(컬럼명, 자릿수)

*/



SELECT 3.14, round(3.14) FROM dual;
SELECT 3.56, round(3.56) FROM dual;

SELECT round(avg(basicpay)) FROM tblinsa;
SELECT round(avg(basicpay), 2) FROM tblinsa;-- 소수 2자리 까지 출력을 할것이기때문에 3자리에서 반올림 시켜버린다.
SELECT round(avg(basicpay), 0) FROM tblinsa;

/*

2. floor(), trunc()
- 절삭 함수 
- 무조건 내림 함수(무조건 버림)
- number floor(컬럼명)
- number trunc(컬럼, [자릿수])

*/
SELECT 123.4567 FROM dual;
SELECT floor(123.4567) FROM dual; -- 123
SELECT floor(123.9567), round(123.9567) FROM dual; -- 123, 124 

SELECT trunc(123.9567) FROM dual;
SELECT trunc(123.9567, 1) FROM dual; -- trunc 는 floor와 다르게 소숫점 몇자리 까지 자를수 있다.


/*

3. ceil()
- 무조건 올림 함수
- number ceil(컬럼명)

*/
SELECT 123.4567 FROM dual;
SELECT ceil(123.4567) FROM dual; -- 124
SELECT ceil(123.00000000001) FROM dual; -- 124
SELECT ceil(123) FROM dual; -- 123

/*

4. mod()
- 나머지 함수
- number mod(피제수, 제수)

*/

SELECT mod(10, 3) FROM dual; -- 1

-- 100분 -> 몇시간 몇분?
SELECT floor(100 / 60) as "시", mod(100, 60) as "분" FROM dual; -- 한글 표현식은 "" 붙히기


/*

문자열 함수

1. upper(), lower(), initcap()
- varchar2 upper(컬럼명)

*/

SELECT 
    'studentName',
    upper('studentName'), -- STUDENTNAME
    lower('studentName'), -- studentname
    initcap('studentName') -- Studentname
FROM dual;

SELECT * FROM employees 
    -- WHERE lower(first_name) like '%' || lower('An') || '%'; -- 동등하게 바꾼뒤 비교 
    -- WHERE upper(first_name) = upper('Diana');
    


/*

2. substr
- 자바 : substring
- 문자열 추출
- varchar2 substr(컬럼명, 시작위치, 개수)
- varchar2 substr(컬럼명, 시작위치) : 끝까지
- SQL은 서수가 1부터 시작한다.

*/

SELECT '가나다라마바사아자차카타파하' FROM dual;
SELECT substr('가나다라마바사아자차카타파하', 3, 5) FROM dual; -- 오라클은 인덱스 1부터 시작(one base)
SELECT substr('가나다라마바사아자차카타파하', 3) FROM dual; 

SELECT name, substr(name, 1, 1) as "성", substr(name, 2) as "이름" FROM tblinsa;

SELECT 
    name, 
    '19' || substr(ssn, 1, 2) as "년생", 
    substr(ssn, 3, 2) as "월생",
    CASE
        WHEN substr(ssn, 8, 1) = '1' THEN '남자'
        WHEN substr(ssn, 8, 1) = '2' THEN '여자'
    END as "성별",
    
    CASE
        WHEN substr(ssn, 3, 2) >= 3 and substr(ssn, 3, 2) <= 5 THEN '봄'
        WHEN substr(ssn, 3, 2) >= 6 and substr(ssn, 3, 2) <= 8 THEN '여름'
        WHEN substr(ssn, 3, 2) >= 9 and substr(ssn, 3, 2) <= 11 THEN '가을'
        ELSE '겨울'
    END as "계절"
FROM tblinsa
-- WHERE ssn like '______-1______';
-- WHERE ssn like '%-1%';
-- WHERE substr(ssn, 8, 1) = '2';
-- WHERE substr(ssn, 8, 1) = '2' or substr(ssn, 8, 1) = '4';
WHERE substr(ssn, 8, 1) in ('2', '4', '6', '8', '0');
-- WHERE mod(substr(ssn, 8, 1), 2) = 0;

-- 집계 함수
-- : 컬럼리스트 O, where 절 X
-- 수학 함수, 문자열 함수
-- : 컬럼리스트 O, where절 O, ORDER BY 절 O

-- 태어난 날짜순으로 정렬
SELECT * FROM tblinsa
    ORDER BY substr(ssn, 5, 2) ASC;
    
/*
3. length()
- 문자열 길이
- number length(컬럼명)
*/
SELECT first_name, length(first_name)           -- 3
    FROM employees                              -- 1
        WHERE length(first_name) >= 5           -- 2
            ORDER BY length(first_name) DESC;   -- 4

/*

4. instr
- indexOf()
- 검색어의 위치를 반환 함수
- number instr(컬럼명, 검색어)
- number instr(컬럼명, 검색어, 시작위치)

*/

SELECT '안녕하세요, 홍길동님' FROM dual;
SELECT instr('안녕하세요, 홍길동님', '홍길동') FROM dual; -- 8
SELECT instr('안녕하세요, 홍길동님', '아무개') FROM dual; -- 0

-- SELECT instr('안녕하세요, 홍길동님', '아무개') FROM dual; -- 0
SELECT * FROM employees
    WHERE instr(first_name, 'an') > 0; -- first_name like '%an%'




/*

5. lpad(), rpad()
- varchar2 lpad(컬럼, 개수, 문자)
- varchar2 rpad(컬럼, 개수, 문자)

*/

SELECT first_name, lpad(first_name, 20, '☆') FROM employees; -- 나머지를 문자로 채우기 
SELECT first_name, rpad(first_name, 20, '☆') FROM employees;
SELECT first_name, lpad(first_name, 20, '-') FROM employees; -- 나머지를 문자로 채우기 

SELECT 
    item,
    qty,
    lpad(' ', qty + 1, '☆') 

FROM tblhousekeeping;




/*

6. trim(), ltrim(), rtrim()
- varchar2 trim(컬럼명)

*/
SELECT '     홍길동     ' FROM dual;
SELECT trim('     홍길동     ') || '*' FROM dual;
SELECT ltrim('     홍길동     ') || '*' FROM dual;
SELECT rtrim('     홍길동     ') || '*' FROM dual;

-- char vs varchar2 비교 
DROP TABLE tbltemp;

CREATE TABLE tbltemp
(
    name1 char(50) not null,
    name2 varchar2(50) not null,
    age number not null

);

INSERT INTO tbltemp (name1, name2, age) VALUES ('홍길동', '홍길동', 20);

COMMIT;

SELECT * FROM tbltemp WHERE name1 = '홍길동';      -- char, 컬럼과 상수 비교 > 내부적으로 trim 처리가 되서 비교를함 
SELECT * FROM tbltemp WHERE name2 = '홍길동';      -- varchar2
SELECT * FROM tbltemp WHERE trim(name1) = name2;   -- 컬럼과 컬럼 비교 > 내부적으로 trim 하지 않아 값을 찾지 못함 > 따로 해줘야함
SELECT length(name1), length(name2) FROM tbltemp;  -- 44, 3

/*
char vs varchar2


1. char
    - 고정 자리수
    - 공간을 비효율적으로 사용
    - 비용 적게 발생(속도 빠름)
    - 데이터의 특성이 길이가 거의 변함이 없는 데이터 -> ex) 주민등록번호, 생년월일, 이름(우리나라 기준)
    
2. varchar2
    - 가변 자리수
    - 공간을 효율적으로 사용
    - 비용 많이 발생(속도 느림) 
    - 길이가 들쑥날쑥 -> 주소, 글 내용
    
    
3. 결론
    - 모든 문자열 거의 무조건 varchar2
    
*/



/*

7. replace()
- 문자열 치환 함수
- varchar2 replace(컬럼명, 찾을 문자열, 바꿀 문자열)

*/
SELECT '홍길동', replace('홍길동', '홍', '김') FROM dual; -- 홍길동, 김길동 

SELECT 
    last || first as name,
    gender,
    CASE
        WHEN gender = 'm' THEN '남자'
        WHEN gender = 'f' THEN '여자'
    END as gender2,
    
    replace(replace(gender, 'm', '남자'), 'f', '여자') -- name.replace("m", "남자").replace("f", "여자")
    
FROM tblname;


SELECT 
    name,
    replace(replace(substr(ssn, 8, 1), '1', '남자'), '2', '여자') 
FROM tblinsa;


SELECT name, replace(replace(replace(replace(replace(continent, 'AS', '아시아'), 'SA', '아메리카'),'EU', '유럽'), 'AF', '아프리카'), 'AU', '오스트레일리아') as 대륙 FROM tblcountry;

/*

8. decode()
- 문자열 치환 함수 
- replace()와 유사
- varchar2 decode(컬럼명, 찾을 문자열, 바꿀 문자열 [찾을 문자열, 바꿀 문자열] x n)
- 치환 불가능 하면 NULL 반환(***)
- 찾지 못하면 replace처럼 원본을 반환하는것이 아니라 null을 반환


*/
SELECT 
    name,
    decode(continent, 'AS', '아시아', 'EU', '유럽', 'SA', '아메리카', 'AF', '아프리카', 'AU', '호주')
FROM tblcountry;

-- 총무부 사람이 몇명?
SELECT count(*) FROM tblinsa WHERE BUSEO = '총무부'; -- 7

-- 영업부 사람이 몇명?
SELECT count(*) FROM tblinsa WHERE BUSEO = '영업부'; -- 16

-- 홍보부 사람이 몇명?
SELECT count(*) FROM tblinsa WHERE BUSEO = '홍보부'; -- 6


/*
-- 위의 결과 3개를 동시에 가져오고 싶다.

[부서] [인원수]
총무부    7    
영업부   16
홍보부    6

[총무부]     [영업부]      [홍보부]  
   7            16            6
     
     
*/

SELECT -- count 함수는 null을 제외 시킨다  
    count(decode(buseo, '총무부', 1)) as 총무부,
    count(decode(buseo, '영업부', 1)) as 영업부,
    count(decode(buseo, '홍보부', 1)) as 홍보부 
FROM tblinsa;


SELECT 
    decode(buseo, '총무부', 1) as 총무부,
    decode(buseo, '영업부', 1) as 영업부,
    decode(buseo, '홍보부', 1) as 홍보부 
FROM tblinsa;

SELECT 
    count(decode(substr(ssn, 8, 1), '1', 1)) as 남자,
    count(decode(substr(ssn, 8, 1), '2', 1)) as 여자
FROM tblinsa;


SELECT 
    count(decode(substr(name, 1, 1), '김', 1)) || '명' as 김씨, 
    count(decode(substr(name, 1, 1), '이', 1)) || '명' as 이씨,
    count(decode(substr(name, 1, 1), '박', 1)) || '명' as 박씨,
    count(decode(substr(name, 1, 1), '최', 1)) || '명' as 최씨,
    count(decode(substr(name, 1, 1), '정', 1)) || '명' as 정씨
FROM tblinsa;

/*

nvl
- null 함수, null value
- object nvl(컬럼명, 대체값)
- 해당 컬럼이 null이 들어있으면 대체값을 대신 반환 
- 대체값은 반드시 해당 컬럼이 가지는 자료형에 한해서...

*/

SELECT name, population FROM tblcountry;
SELECT name, nvl(population, 0) as ppl FROM tblcountry;
-- SELECT name, nvl(population, '미기재') as ppl FROM tblcountry; -- 다른 값들과 자료형이 달라서 안됨.
SELECT name, nvl(tel, '연락처 없음') FROM tblinsa;


/*
날짜 시간 함수

1. sysdate
- 현재 시간 반환
- date sysdate
- Calendar.getInstance() 동일함
*/

SELECT sysdate FROM dual;

-- 날짜 연산
-- date + 숫자 : 일단위 누적 연산

-- 시각 + 시간(일) = 시각
SELECT sysdate + 1 FROM dual;
SELECT sysdate - 1 FROM dual;
SELECT name, ibsadate, ibsadate + 1000 FROM tblinsa;
SELECT 고객명, 대여일, 대여일 + 7 as 반납일 FROM 도서대여;

-- 시각 - 시각 = 시간 
SELECT name, ibsadate FROM tblinsa;
SELECT name, ibsadate, sysdate - ibsadate as 근무일수 FROM tblinsa;
SELECT name, ibsadate, (sysdate - ibsadate) / 365 as 근무년수 FROM tblinsa;
SELECT name, ibsadate, round((sysdate - ibsadate) / 365) as 근무년수 FROM tblinsa; -- 반올림
SELECT name, ibsadate, floor((sysdate - ibsadate) / 365) as 근무년수 FROM tblinsa; -- 무조건 버림
SELECT name, ibsadate, ceil((sysdate - ibsadate) / 365) as 근무년수 FROM tblinsa;  -- 무조건 올림



                        -- 일로 반환 
SELECT title, adddate, completedate - adddate FROM tbltodo
    ORDER BY completedate - adddate ASC; 









/*

2. last_day
- 해당 시각이 포함된 달의 마지막 날짜
- date last_day(컬럼명)

*/
SELECT last_day(sysdate) FROM dual; -- 2018-01-31 12:26:10


/*

3. months_between
- number months_between(date, date) : 월 
- date - date : 일 

*/

SELECT 
    name,
    ibsadate,
    (sysdate - ibsadate) / 365 as 근무년수, -- X
    months_between(sysdate, ibsadate) / 12 as "근무년수(월)" -- O 
FROM tblinsa;

/*

4. add_months
- date add_months(date, number)

*/

SELECT sysdate + 1, add_months(sysdate, 1) FROM dual;
SELECT sysdate - 1, add_months(sysdate, -1) FROM dual;

/*

시각, 시간 연산
1. date + 일, date - 일
2. date - date = 시간차(일)
3. months_between(date, date) = 시간차(월)
4. add_months(date, 월) = date 

*/



