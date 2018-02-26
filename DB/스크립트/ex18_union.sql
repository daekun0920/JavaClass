/*

ex18_union.sql

UNION, ���Ͽ�
- ���̺��� ��ġ�� ���

JOIN : �÷� + �÷�
UNION : ���ڵ� + ���ڵ� 

*/

CREATE TABLE ���� 
AS
SELECT * FROM tblinsa WHERE jikwi = '����';

CREATE TABLE ����
AS
SELECT * FROM tblinsa WHERE jikwi = '����';

SELECT * FROM ����;  -- 8��
SELECT * FROM ����;  -- 7��

SELECT * FROM ���� 
UNION 
SELECT * FROM ����;  

-- �÷����� �������
SELECT name, jikwi FROM ����
UNION
SELECT name as nick, jikwi as position FROM ����;


-- �÷������� �ٸ� -> �÷� ������ �����ؾ� �Ѵ�.
SELECT name, jikwi,city FROM ����
UNION
SELECT name , jikwi FROM ����;

-- �÷� Ÿ���� �ٸ� ��� -> �ݵ�� ��ġ 
SELECT name, jikwi FROM ����
UNION
SELECT name , basicpay FROM ����;

-- ���� ������ �÷��� 
SELECT jikwi, sudang FROM ����
UNION
SELECT name , basicpay FROM ����;






/*

��ҿ��� �����͸� �л� -> �䱸�� ���� �ѹ��� �����;� �� ��

�Խ��� 
1. ���̺� 1�� ���
2. �Ⱓ�� ���� ���̺� ��� (������Ʈ ��)

ȸ��(�μ��� �Խ���)
1. ���̺� 1�� ��� 
2. �μ��� ���� ���̺� ��� 

�߱� ���� ����
1. ���ݼ� ���̺�, ����� ���̺� 

*/

-- ������, �ѹ���, ��ȹ�� �Խ���
CREATE TABLE tblunion1 -- ������
(
    seq NUMBER PRIMARY KEY, -- �۹�ȣ
    subject VARCHAR2(200) NOT NULL -- ������

);

CREATE TABLE tblunion2 -- �ѹ���
(
    seq NUMBER PRIMARY KEY, -- �۹�ȣ
    subject VARCHAR2(200) NOT NULL -- ������

);

CREATE TABLE tblunion3 -- ��ȹ��
(
    seq NUMBER PRIMARY KEY, -- �۹�ȣ
    subject VARCHAR2(200) NOT NULL -- ������

);

-- �Խù�
INSERT INTO tblunion1 VALUES (1, '������ �Խ��� �Դϴ�.');
INSERT INTO tblunion1 VALUES (2, '������ �Խ��� �Դϴ�.');
INSERT INTO tblunion1 VALUES (3, '������ �Խ��� �Դϴ�.');


INSERT INTO tblunion2 VALUES (1, '�ѹ��� �Խ��� �Դϴ�.');
INSERT INTO tblunion2 VALUES (2, '�ѹ��� �Խ��� �Դϴ�.');

INSERT INTO tblunion3 VALUES (1, '��ȹ�� �Խ��� �Դϴ�.');
INSERT INTO tblunion3 VALUES (2, '��ȹ�� �Խ��� �Դϴ�.');

SELECT * FROM tblunion1;
SELECT * FROM tblunion2;
SELECT * FROM tblunion3;

-- ����� -> ��� �Խù� �ѹ��� �����޶�.
SELECT * FROM
(SELECT * FROM tblunion1
UNION
SELECT * FROM tblunion2
UNION
SELECT * FROM tblunion3)
    ORDER BY subject DESC;

-- �߱� ���� ����
-- ���ݼ� vs �����
CREATE TABLE tblunionA (name VARCHAR2(20) NOT NULL);
CREATE TABLE tblunionB (name VARCHAR2(20) NOT NULL);

INSERT INTO tblunionA VALUES ('ȫ�浿'); -- v
INSERT INTO tblunionA VALUES ('�ƹ���');
INSERT INTO tblunionA VALUES ('�׽�Ʈ'); -- v
INSERT INTO tblunionA VALUES ('������');
INSERT INTO tblunionA VALUES ('ȣȣȣ');

INSERT INTO tblunionB VALUES ('����');
INSERT INTO tblunionB VALUES ('������');
INSERT INTO tblunionB VALUES ('ȫ�浿'); -- v
INSERT INTO tblunionB VALUES ('������');
INSERT INTO tblunionB VALUES ('�׽�Ʈ'); -- v

SELECT * FROM tblunionA
UNION -- ������ ������ ����(�ߺ����� ���� - distinct)
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
UNION ALL -- �ߺ����� �����Ͷ� 
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
INTERSECT -- ������ ������ ����(�ߺ����� �����Ͷ�) 
SELECT * FROM tblunionB;

SELECT * FROM tblunionA
MINUS -- ������(tblunionA - tblunionB) 
SELECT * FROM tblunionB;















