/*

ex17_transaction.sql

트랜잭션, Transaction
- DCL 한 종류
- 오라클(DBMS)에서 발생하는 1개 이상의 명령어(SQL)들을 하나의 논리 집합으로 묶어 놓은 단위  -> 제어
- 트랜잭션에 의해서 관리되는 명령어 : DML만 해당된다.(INSERT, UPDATE, DELETE) SELECT 제외 

트랜잭션
1. COMMIT
2. ROLLBACK - 트랜잭션의 맨 처음으로 되돌아가는것 
3. SAVEPOINT

*/

CREATE TABLE 서울시
AS
SELECT * FROM tblinsa WHERE city = '서울';

SELECT * FROM 서울시; -- 20명 


-- HR 계정이 처음으로 오라클에 접속
-- : 트랜잭션이 시작된다.
SELECT * FROM 서울시; -- 20

-- 홍길동 삭제하기
DELETE FROM 서울시 WHERE name = '홍길동';
DELETE FROM 서울시 WHERE name = '한석봉';
DELETE FROM 서울시 WHERE name = '유관순';

-- 새접속 -> 트랜잭션 시작 -> SELECT -> DELETE(길동이) -> SELECT - > DELETE(한석봉) -> DELETE(유관순) -> SELECT

-- 현재 트랜잭션에 기록된 모든 작업을 없었던 일로...
-- 현재 트랜잭션의 모든 작업을 다시 되돌리고 새로운 트랜잭션을 시작한다.
ROLLBACK;

DELETE FROM 서울시 WHERE name = '홍길동';

SELECT * FROM 서울시;

ROLLBACK;

DELETE FROM 서울시 WHERE name = '홍길동';

SELECT * FROM 서울시;

-- 현재 트랜잭션의 모든 내용을 DB에 적용시키고, 현재 트랜잭션 완료 + 새 트랜잭션 시작 
COMMIT; -- 못 박기 (기존 행동 저장, 트랜잭션 끊기)

ROLLBACK;

SELECT * FROM 서울시;

-- 클라이언트 툴 -> Auto Commit : 끄고 작업
-- 종료시 -> 질문? Commit or rollback?
DELETE FROM 서울시 WHERE name = '한석봉';
SELECT * FROM tblinsa;



/*

새 트랜잭션이 새로 시작하는 경우(******)
1. 클라이언트 접속 직후

2. COMMIT 실행 직 후 

3. ROLLBACK 실행 직 후 

4. DDL, DCL 실행 직 후 

현재 트랜잭션이 종료되는 경우(*********)
1. 클라이언트 접속 종료 

2. COMMIT 실행 직 후  

3. ROLLBACK 실행 직 후 

4. DDL, DCL 실행 직 후(자동 COMMIT)

자동 커밋, Auto Commit
- 클라이언트 툴의 기능이 아님;;
- 사용자가(현재 접속중인 세션에서) 명시적으로 COMMIT을 실행하지 않아도 자동으로 COMMIT이 실행되는 상황
- DDL, DCL을 실행할 떄 사용자 모르게 자동으로 COMMIT이 발생한다.
    (CREATE, ALTER, DROP, TRUNCATE...) -> 구조를 조작하는 행동
    
*/
COMMIT;

SELECT * FROM 서울시;
DELETE FROM 서울시 WHERE NAME = '김말자';
DELETE FROM 서울시 WHERE NAME = '한석봉';

CREATE TABLE tbltemp2 ( seq NUMBER ); -- COMMIT 발생 

DELETE FROM 서울시 WHERE NAME = '유관순';

ROLLBACK;

SELECT * FROM tblinsa;

SELECT * FROM 서울시;

-- SAVEPOINT 
COMMIT;

SAVEPOINT a;

DELETE FROM 서울시 WHERE name = '유관순';

SAVEPOINT b;

DELETE FROM 서울시 WHERE name = '김인수';

SAVEPOINT c;

DELETE FROM 서울시 WHERE name = '김영년';

ROLLBACK; -- 트랜잭션 처음 (COMMIT 직 후로 돌아감) 
ROLLBACK TO c; -- c위치로 롤백
ROLLBACK TO b; -- b위치로 롤백
COMMIT;
SELECT * FROM 서울시;






