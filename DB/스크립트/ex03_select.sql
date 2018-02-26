-- ex03_select.sql

/*

SELECT 문
1. 테이블로부터 원하는 데이터를 가져오는 명령어 
  : 클라이언트 -> (SELECT 요청) -> 서버 -> (표 형태로 반환, ResultSet, ResultTable) 

2. 테이블이 아닌것으로부터 데이터를 가져오는 명령어 (오라클에서 사용 빈도 높지않음) 
  
  
서버 : 서비스를 제공하는측
클라이언트 : 서비스를 제공받는측 

클라이언트가 서버에게 서비스 요청 


*** SQL은 일반적으로 1개(2개) 이상의 구(절)이 조합되어 문장을 만든다.

SELECT 구문

SELECT 컬럼리스트 FROM 테이블명;
SELECT 컬럼리스트 FROM 테이블명 WHERE절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 ORDER BY절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 GROUP BY절 ORDER BY절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 GROUP BY절 HAVING절 ORDER BY절;

SELECT 컬럼리스트 FROM 테이블명 [WHERE절] [GROUP BY절] [HAVING절] [ORDER BY절]; -- [] -> 생략이 가능하다.


1. SELECT 컬럼리스트 
    : 가져올 컬럼을 지정한다.
2. FROM 테이블명;
    : 가져올 테이블을 지정한다.


쿼리?
*/

DESC tbltype;

SELECT txt1
FROM tbltype;

SELECT * FROM tabs; -- 모든 테이블 정보 불러오기 

SELECT * FROM tbltodo;

DESC tblname; -- NOT NULL -> 값을 무조건 넣어줘야한다(아무 컬럼도 NULL 일수 없다)


-- tblname 로부터 이름(first)을 가져오시오

SELECT first FROM tblname;
SELECT gender FROM tblname;
SELECT tel FROM tblname; -- ORA-00904: "TEL": invalid identifier -> ORA-00904 에러코드  

-- 성 + 이름
SELECT first, last FROM tblname;
SELECT last, first FROM tblname;
SELECT last, first, nick FROM tblname;
SELECT last, first, nick, gender, weight, height FROM tblname;
SELECT * FROM tblname; -- 메타문자 사용 

-- 컬럼리스트에는 동일한 컬럼이 1개 이상 올 수 있다.
SELECT nick FROM tblname;
SELECT nick, nick FROM tblname;
SELECT nick, LENGTH(nick) FROM tblname;
SELECT nick, nick, nick FROM tblname;



--SELECT first 
--FROM tblname;
--
--SELECT first 
--    FROM tblname;
--    
--SELECT 
--    first 
--FROM 
--    tblname;
    
SELECT * FROM tblcountry;
SELECT * FROM tbldiary;
SELECT * FROM tblhousekeeping;
SELECT * FROM tblinsa;
SELECT * FROM tblmen;
SELECT * FROM tblwomen;
SELECT * FROM tbltodo;


/* 오라클 상수 표현
1. 숫자형 
    a. 정수형
        ex) 10
    b. 실수형
        ex) 3.14 
        
2. 문자(문자열)형
    ex) '김', '홍길동'
    
3. 날짜형 상수
    ex) '2018-01-12' : 문자형 상수 -> (자동 형변환) -> 날짜형 : 문맥에 따라 달라짐
    ex) '100'
    ex) '2018년01월12일' -- X(국제 표기 기준)
    ex) '2018-01-12', '2018/01/12' -- O 
    
*/

-- 컬럼값의 연산
-- SELECT의 대상인 컬럼값들은 순수하게 반환받을 수 있고,
-- 혹은 연산이나 함수의 매가값으로 사용할 수 있다.
SELECT name, basicpay, basicpay * 1.1 FROM tblinsa;

SELECT last, first, weight, weight + 3 FROM tblname;

SELECT name, length(name) FROM tblcountry;

-- BMI
SELECT last, first, weight / height * height FROM tblname;

-- 문자열 더하기 
SELECT last, first, last + first FROM tblname;  -- 오라클에서 지원 x
SELECT last, first, last || first FROM tblname; -- || -> 문자열 더하기 연산자 

SELECT last, last FROM tblname;

-- 결과셋의 컬럼명을 바꾸기 
-- : 별칭(Alias) 지정하기 
-- : 이름 바꾸기(***원본이 바뀌는 것이 아님) 
-- : 컬럼명 AS 별명

SELECT last, first FROM tblname;

SELECT FIRST FROM tblname;

-- FROM 절부터 써놓으면 자동완성 기능 제공 
SELECT last, first, last || first AS fullName FROM tblname;
SELECT last AS 성, first AS 이름, last || first AS 전체이름 FROM tblname;

SELECT last AS 성, first AS 이름, last || first AS "전체 이름" FROM tblname; -- X 식별자(컬럼명)에 공백은 들어갈수 없다 
                                                                            -- -> " " (쌍따옴표)를 사용하면 억지로는 가능하다(권장X)
SELECT 성, 이름, "전체 이름" FROM 위의테이블;

SELECT weight as "from" FROM tblname; -- 식별자가 예약어와 같아도 " "(쌍따옴표) 로 묶어준다 (권장x)


-- 객체 표기법
SELECT * FROM tblname;
SELECT * FROM hr.tblname; -- 남의것 사용할때

-- 정석 표기법 > 스키마(사용자)명.테이블명.컬럼명 
SELECT first, last FROM hr.tblname;
SELECT tblname.first, tblname.last FROM hr.tblname;
SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT tblname.first, tblname.last FROM tblname;
SELECT n.first, n.last FROM tblname n; -- 테이블 별칭
SELECT first, last FROM tblname n;

SELECT *, weight + 100 FROM tblname;
SELECT tblname.*, weight + 100 FROM tblname; -- all(*) 과 특정 컬럼을 연달아쓰기위해 tblname.* 
SELECT n.*, weight + 100 FROM tblname n;

/*

SQL 구(절)의 실행 순서(우선 순위)

1. SELECT 절 - 2 

2. FROM 절   - 1



*/


-- 시스템 테이블
-- 1. tabs
--  : 해당 유저가 소유하고 있는 테이블 목록 
-- 2. dual
--  : 더미 테이블
--  : 테이블 자체는 의미가 없음;

-- sysdate : Calendar.getInstance() 현재 시간 얻어오는 함수 

SELECT sysdate FROM dual; -- X -> 레코드가 1개 -> 대상없는 함수를 사용하기 위함  -> 값만 취하기 위해  

SELECT sysdate FROM tblname;

SELECT 100 * 20 FROM dual;




/*


연산자

1. 산술 연산자 
    - +, -, *, / 
    - 나머지 연산자가 없음 -> 함수로 제공(mod())
  
2. 비교 연산자 
    - >, >=, <, <=
    - =(==), <>(!=)

3. 논리 연산자
    - and(&&), or(||), not(!)
    
4. 문자열 연산자 
    - ||(concat)

5. SQL 연산자
    - Java : Instanceof, typeof...
    - in, between, like, is, any, all 등...
    
    
    
    
*/

SELECT 10 > 5 FROM dual;
SELECT '만족' FROM dual WHERE 10 > 5; -- 만족하면 값을 출력, 조건 불만족시 아무값도 출력하지 않음 


-- NULL 
-- : 자바의 null과 유사한 표현 
-- : SQL은 Null은 연산의 대상이 될 수 없다.(피연산자 자격 X)
-- : SQL은 NULL이 포함된 연산을 하게 되면 무조건 Null을 반환


SELECT 10 + NULL FROM dual; -- (null)
SELECT NULL * 300 FROM dual;
SELECT 100 / NULL FROM dual;
SELECT NULL - 20 FROM dual;





