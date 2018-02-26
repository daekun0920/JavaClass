/*
ex20_account.sql

사용자 관련 SQL
- DCL(TRANSACTION...계정...) 일부 
- 계정 생성(소멸)
- 리소스 접근 권한 제어

사용자 계정 생성하기
1. 시스템 권한을 가지고 있는 계정만 가능하다.
    - 관리자급 계정(sys, system - java1234)
    - 계정 생성할 수 있는 권한만 가지는 계정

*/

-- SYSTEM 계정으로 실행 중..
-- 새 계정 생성하기
-- CREATE USER 계정명 IDENTIFIED BY 암호;
-- ALTER USER 계정명 IDENTIFIED BY 암호;
-- DROP USER 계정명;

CREATE USER daekun IDENTIFIED BY java1234;


-- 접속 권한 할당하기
-- GRANT 권한 TO 유저명;
GRANT CREATE SESSION TO TEAM; -- 권한 1개 
GRANT CREATE TABLE TO team;   -- 권한 1개 
GRANT CREATE VIEW TO team;    -- 권한 1개

GRANT RESOURCE to team; -- ROLE 부여(권한의 집합)

/*

관리자 시스템 권한
1. CREATE USER : 계정 생성 권한
2. DROP USER : 계정 삭제 권한
3. DROP ANY TABLE : 보통 테이블의 삭제 권한은 본인이 가진다.(혹은 DROP ANY TABLE 권한을 가진 관리자급)

사용자 시스템 권한 
1. CREATE SESSION : DB 접속 권한
2. CREATE TABLE : 테이블 생성 권한 
3. CREATE VIEW : 뷰 생성 권한 
4. CREATE SEQUENCE : 시퀀스 생성 권한 
5. CREATE PROCEDURE : 프로시저 생성 권한 

140여가지..



*/


-- 객체 권한 부여하기 
-- : 테이블, 뷰, 시퀀스 등에 대해서 객체별로 DML을 사용할 수 있는 권한 
-- : GRANT OBJECT_PRIVILEGE ON 대상객체 TO 유저명;

-- HR 소유 테이블을 team 계정에게 읽기 권한 부여하기 
-- : 이 작업이 가능한 계정(관리자, HR)
GRANT SELECT 
    ON hr.tblinsa
        TO team;


-- 권한 뺏기 
-- : REVOKE GRANT OBJECT_PRIVILEGE ON 대상객체 FROM 유저명;
REVOKE SELECT
    ON hr.tblinsa
        FROM team;
        
        

/*

역할, Role
- 사용자에게 여러가지의 권한을 한번에 주기 위한 권한 그룹

자주 사용하는 역할
1. connect
- 사용자가 DB접속 + 행동 기본적인 권한 모음

2. resource
- 사용자가 객체를 생성하거나 조작하는 권한 모음

3. dba



*/

-- 프로젝트 작업 시 
-- 1. 계정 생성
CREATE USER team IDENTIFIED BY java1234;

-- 2. Role 추가
GRANT connect to team;
GRANT resource to team;

-- 3. 추가
GRANT CREATE VIEW to team;




GRANT connect to daekun;
GRANT resource to daekun;
GRANT CREATE VIEW to daekun;






