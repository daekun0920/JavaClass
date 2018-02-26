/*
ex14_view.sql

��, View
- DB Object�� �ϳ�(���̺�, ������, ��.. + ���� ����)
- ���� ���̺�
- �������� ���̺��� ���̽��� ������ ���̺� ������ �Ѵ�.
- ���̺��� ���纻 -> �������̺�, �����̺�, �������̺�...
- ���̺�ó�� ����ϴ� ��ü(*****)
- SQL(�ڵ�) ��ü�� ������ ���� ���� ��ü 
- ��� �б� �������� ����Ѵ�.(*******)
*/

-- �� ����
CREATE VIEW vwinsa
AS
SELECT * FROM tblinsa;

-- �� ����
SELECT * FROM vwinsa;

-- �Ȱ��� �ǵ� 
CREATE TABLE vwinsa
AS
SELECT * FROM tblinsa;



-- ��� : �λ�� + ����(����) ���� SELECT x 500
SELECT * FROM tblinsa WHERE BUSEO = '�λ��' AND JIKWI IN ('����', '����');

CREATE VIEW �λ�� -- ������ �����ϸ� �䵵 �����ȴ�.(�ǽð� ����ȭ) (View�� SQL(��ɾ�) ��ü�� �����Ѵ�. ���־��� ������ ����(�� �޼ҵ� ����.))
AS
SELECT * FROM tblinsa WHERE BUSEO = '�λ��' AND JIKWI IN ('����', '����');

CREATE TABLE �ѹ��� -- �̷��� ���� -> ������ ���纻 (�� ���� - ���� ������ ������ ���� ����, ������ ���纻�� �и�)
AS
SELECT * FROM tblinsa WHERE BUSEO = '�ѹ���' AND JIKWI IN ('����', '����');


SELECT * FROM �λ��;
SELECT * FROM �ѹ���;

UPDATE tblinsa SET city = '����' WHERE num = 1046;
UPDATE tblinsa SET city = '����' WHERE num = 1019;

SELECT * FROM tblinsa WHERE num = 1046;
SELECT * FROM tblinsa WHERE num = 1019;

-- 1. ���� �ݺ��Ǵ� ���� ����
CREATE VIEW vwinsa2
AS
SELECT name, basicpay, sudang, '19' || substr(ssn, 1, 2) as birthyear,
    CASE
        WHEN substr(ssn, 8, 1) = '1' THEN 'm'
        WHEN substr(ssn, 8, 1) = '2' THEN 'f'
    END as gender
FROM tblinsa;

SELECT * FROM vwinsa2;  

SELECT * FROM ���;

-- 2. ���� �ݺ������� �ʴ��� ���ǿ� �ǹ̸� �ο��� ���� ������ ���̱� ���� ...
CREATE VIEW ��������
AS
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1';


/*

�並 ����ϴ� ����
1. ���� �ݺ��Ǵ� ���� ���� 
2. ���ǿ� �ǹ̸� �ο��� ���� ������ ���̱� ����..
3. 1���� ���̺��� ���� �ǹ̷� ����ϰ� ���� ��..
4. ����
    - ����ڿ��� ���ѿ� ���� �Ϻ� �����͸� �����Ű���� �� ��

*/

SELECT * FROM tblinsa;

CREATE VIEW ���
AS 
SELECT * FROM tblinsa WHERE jikwi = '���';

-- ���� 
-- tblinsa : ��� ���� ��Ż
-- ��� : SELECT ���� �ο� 
SELECT * FROM ���; -- ������ ����


-- �� �����ϱ�
DROP VIEW �λ��;
DROP VIEW vwsolo;

-- �� �����ϱ� 
CREATE OR REPLACE VIEW vwsolo
AS 
SELECT name, age, height, weight FROM tblmen WHERE couple IS NULL;

SELECT * FROM vwsolo;


-- ��� �б� �����̴�.
SELECT * FROM tblmen;

CREATE OR REPLACE VIEW vwmen
AS
SELECT * FROM tblmen;

SELECT * FROM vwmen;

-- �並 ������� INSERT 
INSERT INTO vwmen VALUES ('�׽�Ʈ', 20, 170, 60, NULL);

-- �並 ������� UPDATE
UPDATE vwmen SET age = 22 WHERE name = '�׽�Ʈ';

-- �並 ������� DELETE
DELETE FROM vwmen WHERE name = '�׽�Ʈ';


CREATE or REPLACE VIEW vwmen2
AS
SELECT name, height FROM tblmen;

SELECT * FROM vwmen2;
SELECT * FROM (SELECT name, height FROM tblmen); -- ���� ���� (��� ���������� �����̴�, �̸��� ���� �������� -> ��? -> ������ �ϱ����ؼ�)



INSERT INTO vwmen2 VALUES ('�׽�Ʈ', 170); -- ORA-01400: cannot insert NULL into ("HR"."TBLMEN"."AGE")
INSERT INTO vwmen2(name, height, age) VALUES ('�׽�Ʈ', 170, 20); -- ORA-00904: "AGE": invalid identifier









