/*

ex18_union.sql

UNION, 유니온
- 테이블을 합치는 기술

JOIN : 컬럼 + 컬럼
UNION : 레코드 + 레코드 

*/

CREATE TABLE 과장 
AS
SELECT * FROM tblinsa WHERE jikwi = '과장';

CREATE TABLE 부장
AS
SELECT * FROM tblinsa WHERE jikwi = '부장';

SELECT * FROM 과장;  -- 8명
SELECT * FROM 부장;  -- 7명

SELECT * FROM 과장 
UNION 
SELECT * FROM 부장;  

-- 컬럼명은 상관없음
SELECT name, jikwi FROM 과장
UNION
SELECT name as nick, jikwi as position FROM 부장;


-- 컬럼갯수가 다름 -> 컬럼 갯수는 동일해야 한다.
SELECT name, jikwi,city FROM 과장
UNION
SELECT name , jikwi FROM 부장;

-- 컬럼 타입이 다른 경우 -> 반드시 일치 
SELECT name, jikwi FROM 과장
UNION
SELECT name , basicpay FROM 부장;

-- 같은 성격의 컬럼만 
SELECT jikwi, sudang FROM 과장
UNION
SELECT name , basicpay FROM 부장;






/*

평소에는 데이터를 분산 -> 요구에 따라 한번에 가져와야 할 때

게시판 
1. 테이블 1개 사용
2. 기간별 각각 테이블 사용 (프로젝트 시)

회사(부서별 게시판)
1. 테이블 1개 사용 
2. 부서별 각각 테이블 사용 

야구 선수 정보
1. 공격수 테이블, 수비수 테이블 

*/

-- 영업부, 총무부, 기획부 게시판
CREATE TABLE tblunion1 -- 영업부
(
    seq NUMBER PRIMARY KEY, -- 글번호
    subject VARCHAR2(200) NOT NULL -- 글제목

);

CREATE TABLE tblunion2 -- 총무부
(
    seq NUMBER PRIMARY KEY, -- 글번호
    subject VARCHAR2(200) NOT NULL -- 글제목

);

CREATE TABLE tblunion3 -- 기획부
(
    seq NUMBER PRIMARY KEY, -- 글번호
    subject VARCHAR2(200) NOT NULL -- 글제목

);

-- 게시물
INSERT INTO tblunion1 VALUES (1, '영업부 게시판 입니다.');
INSERT INTO tblunion1 VALUES (2, '영업부 게시판 입니다.');
INSERT INTO tblunion1 VALUES (3, '영업부 게시판 입니다.');


INSERT INTO tblunion2 VALUES (1, '총무부 게시판 입니다.');
INSERT INTO tblunion2 VALUES (2, '총무부 게시판 입니다.');

INSERT INTO tblunion3 VALUES (1, '기획부 게시판 입니다.');
INSERT INTO tblunion3 VALUES (2, '기획부 게시판 입니다.');

SELECT * FROM tblunion1;
SELECT * FROM tblunion2;
SELECT * FROM tblunion3;

-- 사장님 -> 모든 게시물 한번에 보여달라.
SELECT * FROM
(SELECT * FROM tblunion1
UNION
SELECT * FROM tblunion2
UNION
SELECT * FROM tblunion3)
    ORDER BY subject DESC;

-- 야구 선수 정보
-- 공격수 vs 수비수
CREATE TABLE tblunionA (name VARCHAR2(20) NOT NULL);
CREATE TABLE tblunionB (name VARCHAR2(20) NOT NULL);

INSERT INTO tblunionA VALUES ('홍길동'); -- v
INSERT INTO tblunionA VALUES ('아무개');
INSERT INTO tblunionA VALUES ('테스트'); -- v
INSERT INTO tblunionA VALUES ('하하하');
INSERT INTO tblunionA VALUES ('호호호');

INSERT INTO tblunionB VALUES ('무명씨');
INSERT INTO tblunionB VALUES ('후후후');
INSERT INTO tblunionB VALUES ('홍길동'); -- v
INSERT INTO tblunionB VALUES ('헤헤헤');
INSERT INTO tblunionB VALUES ('테스트'); -- v

SELECT * FROM tblunionA
UNION -- 수학의 합집합 개념(중복값은 제거 - distinct)
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
UNION ALL -- 중복값도 가져와라 
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
INTERSECT -- 수학의 교집합 개념(중복값만 가져와라) 
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
MINUS -- 차집합(tblunionA - tblunionB) 
SELECT * FROM tblunionB;















