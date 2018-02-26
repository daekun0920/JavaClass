/*
ex14_view.sql

뷰, View
- DB Object중 하나(테이블, 시퀀스, 뷰.. + 제약 사항)
- 가상 테이블
- 물리적인 테이블을 베이스로 논리적인 테이블 역할을 한다.
- 테이블의 복사본 -> 복사테이블, 뷰테이블, 가상테이블...
- 테이블처럼 취급하는 객체(*****)
- SQL(코드) 자체를 저장해 놓은 단위 객체 
- 뷰는 읽기 전용으로 사용한다.(*******)
*/

-- 뷰 생성
CREATE VIEW vwinsa
AS
SELECT * FROM tblinsa;

-- 뷰 실행
SELECT * FROM vwinsa;

-- 똑같은 의도 
CREATE TABLE vwinsa
AS
SELECT * FROM tblinsa;



-- 출근 : 인사부 + 부장(과장) 직원 SELECT x 500
SELECT * FROM tblinsa WHERE BUSEO = '인사부' AND JIKWI IN ('부장', '과장');

CREATE VIEW 인사부 -- 원본을 수정하면 뷰도 수정된다.(실시간 동기화) (View는 SQL(명령어) 자체를 저장한다. 자주쓰는 쿼리를 저장(꼭 메소드 같다.))
AS
SELECT * FROM tblinsa WHERE BUSEO = '인사부' AND JIKWI IN ('부장', '과장');

CREATE TABLE 총무부 -- 이렇겐 안함 -> 완전한 복사본 (값 복사 - 원본 수정시 영향을 받지 않음, 원본과 복사본을 분리)
AS
SELECT * FROM tblinsa WHERE BUSEO = '총무부' AND JIKWI IN ('부장', '과장');


SELECT * FROM 인사부;
SELECT * FROM 총무부;

UPDATE tblinsa SET city = '서울' WHERE num = 1046;
UPDATE tblinsa SET city = '제주' WHERE num = 1019;

SELECT * FROM tblinsa WHERE num = 1046;
SELECT * FROM tblinsa WHERE num = 1019;

-- 1. 자주 반복되는 질의 저장
CREATE VIEW vwinsa2
AS
SELECT name, basicpay, sudang, '19' || substr(ssn, 1, 2) as birthyear,
    CASE
        WHEN substr(ssn, 8, 1) = '1' THEN 'm'
        WHEN substr(ssn, 8, 1) = '2' THEN 'f'
    END as gender
FROM tblinsa;

SELECT * FROM vwinsa2;  

SELECT * FROM 장부;

-- 2. 자주 반복되지는 않더라도 질의에 의미를 부여해 놓고 가독성 높이기 위해 ...
CREATE VIEW 남자직원
AS
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1';


/*

뷰를 사용하는 이유
1. 자주 반복되는 질의 저장 
2. 질의에 의미를 부여해 놓고 가독성 높이기 위해..
3. 1개의 테이블을 여러 의미로 사용하고 싶을 때..
4. 보안
    - 사용자에게 권한에 따라 일부 데이터만 노출시키고자 할 떄

*/

SELECT * FROM tblinsa;

CREATE VIEW 사원
AS 
SELECT * FROM tblinsa WHERE jikwi = '사원';

-- 신입 
-- tblinsa : 모든 권한 박탈
-- 사원 : SELECT 권한 부여 
SELECT * FROM 사원; -- 유일한 권한


-- 뷰 삭제하기
DROP VIEW 인사부;
DROP VIEW vwsolo;

-- 뷰 수정하기 
CREATE OR REPLACE VIEW vwsolo
AS 
SELECT name, age, height, weight FROM tblmen WHERE couple IS NULL;

SELECT * FROM vwsolo;


-- 뷰는 읽기 전용이다.
SELECT * FROM tblmen;

CREATE OR REPLACE VIEW vwmen
AS
SELECT * FROM tblmen;

SELECT * FROM vwmen;

-- 뷰를 대상으로 INSERT 
INSERT INTO vwmen VALUES ('테스트', 20, 170, 60, NULL);

-- 뷰를 대상으로 UPDATE
UPDATE vwmen SET age = 22 WHERE name = '테스트';

-- 뷰를 대상으로 DELETE
DELETE FROM vwmen WHERE name = '테스트';


CREATE or REPLACE VIEW vwmen2
AS
SELECT name, height FROM tblmen;

SELECT * FROM vwmen2;
SELECT * FROM (SELECT name, height FROM tblmen); -- 같은 문장 (뷰는 서브쿼리의 일종이다, 이름이 붙은 서브쿼리 -> 왜? -> 재사용을 하기위해서)



INSERT INTO vwmen2 VALUES ('테스트', 170); -- ORA-01400: cannot insert NULL into ("HR"."TBLMEN"."AGE")
INSERT INTO vwmen2(name, height, age) VALUES ('테스트', 170, 20); -- ORA-00904: "AGE": invalid identifier









