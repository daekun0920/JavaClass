/*

ex10_update.sql

UPDATE 
- �����͸� �����ϴ� ��ɾ�

UPDATE ����
- UPDATE ���̺�� SET 
    �÷��� = �����Ұ�
    [,�÷��� = �����Ұ�] x N 
    WHERE ����; -- ������ ���� �����ϴ� ����(SELECT ���� ����� WHERE�� ���� 100% ����)
    
*/
COMMIT;
ROLLBACK;

UPDATE tblname SET 
    gender = 'f'
    WHERE first = '�缮' and last = '��'; -- �Ϲ������δ� pk�� ��������...
    
SELECT * FROM tblname;


SELECT * FROM tblinsa;
-- ���� �� ����(���� 1�� -> �ĺ� -> PK -> num �÷� -> num�� ��������..)
UPDATE tblinsa SET
    jikwi = '�̻�'
        WHERE num = 1001;


-- ���� �� ����(��ȹ�� ���� -> �޿� �λ� -> 10% �λ� -> BUSEO �÷�)
UPDATE tblinsa SET
    basicpay = basicpay * 1.1 -- ����   (basicpay *= 1.1 <-(����Ŭ���� ���� ���� ������ X))
        WHERE BUSEO = '��ȹ��';



-- PK �÷��� ����(����� XXXXXXXXXX)
UPDATE tblinsa SET 
    num = 1100
        WHERE num = 1001;


SELECT * FROM tblinsa;




/*
DELETE
- �� ������ ������ ���� -> UPDATE
- ��(���ڵ�) ������ �����͸� �����ϴ� ��ɾ� -> DELETE
- Ư�� �÷����� ���� X -> UPDATE ������ Ư�� �÷����� NULL ���� 

DELETE ��
- DELETE [FROM] ���̺�� [WHERE��] <- WHERE �� ������ ��ü ����
*/
SELECT * FROM tblinsa;

SELECT * FROM tblcountry;

DELETE FROM tblcountry WHERE name = '�߱�';

DELETE FROM tblcountry WHERE name = '�Ϻ�';

DELETE FROM tblcountry WHERE continent = 'AS';

ROLLBACK;










