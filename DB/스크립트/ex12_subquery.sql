/*
ex12_subquery.sql


��������, Sub Query
-SQL �ȿ� �� �ٸ� SQL�� ����ִ� ����
- SELECT ���� �������� ���·� ���ȴ�.
- ���������� �� �� �ִ� ��ġ
    a. WHERE�� : ���������� ������� ���ǰ����� ���
    b. �÷�����Ʈ : ���������� ������� �� �ϳ��� �÷� �����ͷ� ���
    c. FROM�� : ���������� ������� �ϳ��� ���̺� ��� -- ��(View)
    d. ORDER BY��
    e. GROUP BY
*/

-- �ܰ��� ���� ���� ���Ǹ�?
SELECT max(price) FROM tblhousekeeping; -- 15000

SELECT item FROM tblhousekeeping WHERE price = 15000;

SELECT item FROM housekeeping WHERE price = max(price);

SELECT item FROM tblhousekeeping WHERE price = (SELECT max(price) FROM tblhousekeeping);

SELECT * FROM tbltodo;
-- ���� �ֱٿ� ����� ����?(adddate�� ���� ������ ��¥)

SELECT max(adddate) FROM tbltodo; -- 2018-01-12 12:30:23

SELECT title, adddate FROM tbltodo 
    WHERE adddate = to_date('2018-01-12 12:30:23', 'yyyy-mm-dd hh24:mi:ss');


-- ȸ�� ��� ����(155����)���� ���� �޴� ������ ���?
SELECT * FROM tblinsa;

SELECT avg(basicpay) FROM tblinsa;

SELECT * FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa);


SELECT DISTINCT BUSEO FROM tblinsa 
    WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa WHERE BUSEO = '�ѹ���')
        AND BUSEO <> '�ѹ���';


SELECT * FROM tblinsa WHERE name = 'ȫ�浿';

SELECT * FROM tblinsa 
    WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE name = 'ȫ�浿');

SELECT * FROM tblinsa 
    WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE JIKWI = '����'); -- ORA-01427: single-row subquery returns more than one row

SELECT * FROM tblinsa 
    WHERE basicpay > (SELECT max(basicpay) FROM tblinsa WHERE JIKWI = '����');
    
SELECT * FROM tblmen;
SELECT * FROM tblwomen;



-- ���� 170cm + ? -> ����ģ�� -> Ű?
SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL;

SELECT height FROM tblwomen 
    WHERE name = (SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL);

-- SELECT height FROM tblwomen WHERE name = (SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL);    


-- hr
SELECT * FROM employees;
SELECT * FROM departments;
SELECT * FROM locations;

-- ���� Steven King�� �Ҽӵ� �μ��� ��� ������ �ִ��� �ּҸ� �˷��ּ���.
SELECT * FROM locations
    WHERE location_id = (
        SELECT location_id FROM departments
             WHERE department_id = (
                SELECT department_id FROM employees 
                    WHERE upper(first_name || last_name) 
                        = upper(replace('steven king', ' ', ''))));

SELECT location_id FROM departments
    WHERE department_id = (
        SELECT department_id FROM employees 
            WHERE upper(first_name || last_name) 
                = upper(replace('steven king', ' ', '')));


SELECT department_id FROM employees 
    WHERE upper(first_name || last_name) = upper(replace('steven king', ' ', '')); 





-- �÷�����Ʈ�� �������� ���

-- ��ȹ�� �������� �浿�̺��� �󸶸� �� �ް� �󸶸� �� �޴��� ������ �ñ�?
SELECT name, basicpay, 2610000 - basicpay FROM tblinsa WHERE BUSEO = '��ȹ��';    

SELECT name, basicpay, (SELECT basicpay FROM tblinsa WHERE name = 'ȫ�浿') - basicpay FROM tblinsa WHERE buseo = '��ȹ��';

-- �����Լ��� �÷�����Ʈ�� ��� -> �������� 
SELECT name, basicpay, max(basicpay) FROM tblinsa;
SELECT name, basicpay, (SELECT max(basicpay) FROM tblinsa) FROM tblinsa;
SELECT name, basicpay, (SELECT max(basicpay) FROM tblinsa) - basicpay FROM tblinsa;

-- �ٱ��� ���̺��� �����͸� ���� ���̺��� �������� ��� - ���� 


-- FROM�� -> �������� 
SELECT * FROM (SELECT * FROM tblname WHERE gender = 'm'); -- �ӽ� ���� ���̺� 

CREATE TABLE tbltempmen
AS
SELECT * FROM tblname WHERE gender = 'm';

SELECT * FROM tbltempmen;


SELECT * FROM(SELECT name, ssn, jikwi, city FROM tblinsa WHERE BUSEO = '��ȹ��');


SELECT name, ssn, jikwi, city FROM(SELECT name, ssn as jumin, jikwi, city FROM tblinsa WHERE BUSEO = '��ȹ��'); --X ORA-00904: "SSN": invalid identifier

SELECT name, jumin, jikwi, city FROM(SELECT name, ssn as jumin, jikwi, city FROM tblinsa WHERE BUSEO = '��ȹ��');



-- ���������� ����� ���߰��� ��
-- 1. ���� ��
-- 2. ���� �÷�


-- ȫ�浿(����)�� �̼���(����)�� ���� �μ� �������� �������ÿ�.
SELECT name, buseo FROM tblinsa -- ���� 
    WHERE buseo in (SELECT BUSEO FROM tblinsa WHERE name = 'ȫ�浿' or name = '�̼���');

SELECT name, buseo FROM tblinsa
    WHERE buseo in ('��ȹ��', '���ߺ�');

SELECT BUSEO FROM tblinsa
    WHERE name = 'ȫ�浿' or name = '�̼���';
    
SELECT * FROM tblinsa;





SELECT buseo FROM tblinsa
    WHERE name = '������';


-- �����հ� ���� �μ��� �Ҽ� + ���� ������ ������ ���?
SELECT * FROM tblinsa
    WHERE buseo = '�λ��' and jikwi = '���';

SELECT * FROM tblinsa
    WHERE buseo = (SELECT BUSEO FROM tblinsa WHERE name = '������') 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE name = '������');

SELECT * FROM tblinsa
    WHERE buseo = (SELECT BUSEO FROM tblinsa WHERE num = 1035) 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE num = 1035);
    
SELECT * FROM tblinsa
    WHERE buseo = (SELECT BUSEO FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa))
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa));    
    
SELECT * FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT BUSEO, jikwi FROM tblinsa WHERE name = '������');   
    
SELECT * FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT BUSEO FROM tblinsa WHERE name = '������');   

-- ������ ������ �߿�
SELECT * FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT BUSEO, jikwi as position FROM tblinsa WHERE name = '������');   


-- ���� �÷� + ���� �� -> �������� ���ǰ����� ���
SELECT * FROM tblinsa
    WHERE (buseo, jikwi) in (SELECT BUSEO, jikwi FROM tblinsa);
        

    