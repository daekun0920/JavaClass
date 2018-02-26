/*

ex17_transaction.sql

Ʈ�����, Transaction
- DCL �� ����
- ����Ŭ(DBMS)���� �߻��ϴ� 1�� �̻��� ��ɾ�(SQL)���� �ϳ��� �� �������� ���� ���� ����  -> ����
- Ʈ����ǿ� ���ؼ� �����Ǵ� ��ɾ� : DML�� �ش�ȴ�.(INSERT, UPDATE, DELETE) SELECT ���� 

Ʈ�����
1. COMMIT
2. ROLLBACK - Ʈ������� �� ó������ �ǵ��ư��°� 
3. SAVEPOINT

*/

CREATE TABLE �����
AS
SELECT * FROM tblinsa WHERE city = '����';

SELECT * FROM �����; -- 20�� 


-- HR ������ ó������ ����Ŭ�� ����
-- : Ʈ������� ���۵ȴ�.
SELECT * FROM �����; -- 20

-- ȫ�浿 �����ϱ�
DELETE FROM ����� WHERE name = 'ȫ�浿';
DELETE FROM ����� WHERE name = '�Ѽ���';
DELETE FROM ����� WHERE name = '������';

-- ������ -> Ʈ����� ���� -> SELECT -> DELETE(�浿��) -> SELECT - > DELETE(�Ѽ���) -> DELETE(������) -> SELECT

-- ���� Ʈ����ǿ� ��ϵ� ��� �۾��� ������ �Ϸ�...
-- ���� Ʈ������� ��� �۾��� �ٽ� �ǵ����� ���ο� Ʈ������� �����Ѵ�.
ROLLBACK;

DELETE FROM ����� WHERE name = 'ȫ�浿';

SELECT * FROM �����;

ROLLBACK;

DELETE FROM ����� WHERE name = 'ȫ�浿';

SELECT * FROM �����;

-- ���� Ʈ������� ��� ������ DB�� �����Ű��, ���� Ʈ����� �Ϸ� + �� Ʈ����� ���� 
COMMIT; -- �� �ڱ� (���� �ൿ ����, Ʈ����� ����)

ROLLBACK;

SELECT * FROM �����;

-- Ŭ���̾�Ʈ �� -> Auto Commit : ���� �۾�
-- ����� -> ����? Commit or rollback?
DELETE FROM ����� WHERE name = '�Ѽ���';
SELECT * FROM tblinsa;



/*

�� Ʈ������� ���� �����ϴ� ���(******)
1. Ŭ���̾�Ʈ ���� ����

2. COMMIT ���� �� �� 

3. ROLLBACK ���� �� �� 

4. DDL, DCL ���� �� �� 

���� Ʈ������� ����Ǵ� ���(*********)
1. Ŭ���̾�Ʈ ���� ���� 

2. COMMIT ���� �� ��  

3. ROLLBACK ���� �� �� 

4. DDL, DCL ���� �� ��(�ڵ� COMMIT)

�ڵ� Ŀ��, Auto Commit
- Ŭ���̾�Ʈ ���� ����� �ƴ�;;
- ����ڰ�(���� �������� ���ǿ���) ��������� COMMIT�� �������� �ʾƵ� �ڵ����� COMMIT�� ����Ǵ� ��Ȳ
- DDL, DCL�� ������ �� ����� �𸣰� �ڵ����� COMMIT�� �߻��Ѵ�.
    (CREATE, ALTER, DROP, TRUNCATE...) -> ������ �����ϴ� �ൿ
    
*/
COMMIT;

SELECT * FROM �����;
DELETE FROM ����� WHERE NAME = '�踻��';
DELETE FROM ����� WHERE NAME = '�Ѽ���';

CREATE TABLE tbltemp2 ( seq NUMBER ); -- COMMIT �߻� 

DELETE FROM ����� WHERE NAME = '������';

ROLLBACK;

SELECT * FROM tblinsa;

SELECT * FROM �����;

-- SAVEPOINT 
COMMIT;

SAVEPOINT a;

DELETE FROM ����� WHERE name = '������';

SAVEPOINT b;

DELETE FROM ����� WHERE name = '���μ�';

SAVEPOINT c;

DELETE FROM ����� WHERE name = '�迵��';

ROLLBACK; -- Ʈ����� ó�� (COMMIT �� �ķ� ���ư�) 
ROLLBACK TO c; -- c��ġ�� �ѹ�
ROLLBACK TO b; -- b��ġ�� �ѹ�
COMMIT;
SELECT * FROM �����;






