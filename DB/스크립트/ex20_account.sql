/*
ex20_account.sql

����� ���� SQL
- DCL(TRANSACTION...����...) �Ϻ� 
- ���� ����(�Ҹ�)
- ���ҽ� ���� ���� ����

����� ���� �����ϱ�
1. �ý��� ������ ������ �ִ� ������ �����ϴ�.
    - �����ڱ� ����(sys, system - java1234)
    - ���� ������ �� �ִ� ���Ѹ� ������ ����

*/

-- SYSTEM �������� ���� ��..
-- �� ���� �����ϱ�
-- CREATE USER ������ IDENTIFIED BY ��ȣ;
-- ALTER USER ������ IDENTIFIED BY ��ȣ;
-- DROP USER ������;

CREATE USER daekun IDENTIFIED BY java1234;


-- ���� ���� �Ҵ��ϱ�
-- GRANT ���� TO ������;
GRANT CREATE SESSION TO TEAM; -- ���� 1�� 
GRANT CREATE TABLE TO team;   -- ���� 1�� 
GRANT CREATE VIEW TO team;    -- ���� 1��

GRANT RESOURCE to team; -- ROLE �ο�(������ ����)

/*

������ �ý��� ����
1. CREATE USER : ���� ���� ����
2. DROP USER : ���� ���� ����
3. DROP ANY TABLE : ���� ���̺��� ���� ������ ������ ������.(Ȥ�� DROP ANY TABLE ������ ���� �����ڱ�)

����� �ý��� ���� 
1. CREATE SESSION : DB ���� ����
2. CREATE TABLE : ���̺� ���� ���� 
3. CREATE VIEW : �� ���� ���� 
4. CREATE SEQUENCE : ������ ���� ���� 
5. CREATE PROCEDURE : ���ν��� ���� ���� 

140������..



*/


-- ��ü ���� �ο��ϱ� 
-- : ���̺�, ��, ������ � ���ؼ� ��ü���� DML�� ����� �� �ִ� ���� 
-- : GRANT OBJECT_PRIVILEGE ON ���ü TO ������;

-- HR ���� ���̺��� team �������� �б� ���� �ο��ϱ� 
-- : �� �۾��� ������ ����(������, HR)
GRANT SELECT 
    ON hr.tblinsa
        TO team;


-- ���� ���� 
-- : REVOKE GRANT OBJECT_PRIVILEGE ON ���ü FROM ������;
REVOKE SELECT
    ON hr.tblinsa
        FROM team;
        
        

/*

����, Role
- ����ڿ��� ���������� ������ �ѹ��� �ֱ� ���� ���� �׷�

���� ����ϴ� ����
1. connect
- ����ڰ� DB���� + �ൿ �⺻���� ���� ����

2. resource
- ����ڰ� ��ü�� �����ϰų� �����ϴ� ���� ����

3. dba



*/

-- ������Ʈ �۾� �� 
-- 1. ���� ����
CREATE USER team IDENTIFIED BY java1234;

-- 2. Role �߰�
GRANT connect to team;
GRANT resource to team;

-- 3. �߰�
GRANT CREATE VIEW to team;




GRANT connect to daekun;
GRANT resource to daekun;
GRANT CREATE VIEW to daekun;






