-- ex03_select.sql

/*

SELECT ��
1. ���̺�κ��� ���ϴ� �����͸� �������� ��ɾ� 
  : Ŭ���̾�Ʈ -> (SELECT ��û) -> ���� -> (ǥ ���·� ��ȯ, ResultSet, ResultTable) 

2. ���̺��� �ƴѰ����κ��� �����͸� �������� ��ɾ� (����Ŭ���� ��� �� ��������) 
  
  
���� : ���񽺸� �����ϴ���
Ŭ���̾�Ʈ : ���񽺸� �����޴��� 

Ŭ���̾�Ʈ�� �������� ���� ��û 


*** SQL�� �Ϲ������� 1��(2��) �̻��� ��(��)�� ���յǾ� ������ �����.

SELECT ����

SELECT �÷�����Ʈ FROM ���̺��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� ORDER BY��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� GROUP BY�� ORDER BY��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� GROUP BY�� HAVING�� ORDER BY��;

SELECT �÷�����Ʈ FROM ���̺�� [WHERE��] [GROUP BY��] [HAVING��] [ORDER BY��]; -- [] -> ������ �����ϴ�.


1. SELECT �÷�����Ʈ 
    : ������ �÷��� �����Ѵ�.
2. FROM ���̺��;
    : ������ ���̺��� �����Ѵ�.


����?
*/

DESC tbltype;

SELECT txt1
FROM tbltype;

SELECT * FROM tabs; -- ��� ���̺� ���� �ҷ����� 

SELECT * FROM tbltodo;

DESC tblname; -- NOT NULL -> ���� ������ �־�����Ѵ�(�ƹ� �÷��� NULL �ϼ� ����)


-- tblname �κ��� �̸�(first)�� �������ÿ�

SELECT first FROM tblname;
SELECT gender FROM tblname;
SELECT tel FROM tblname; -- ORA-00904: "TEL": invalid identifier -> ORA-00904 �����ڵ�  

-- �� + �̸�
SELECT first, last FROM tblname;
SELECT last, first FROM tblname;
SELECT last, first, nick FROM tblname;
SELECT last, first, nick, gender, weight, height FROM tblname;
SELECT * FROM tblname; -- ��Ÿ���� ��� 

-- �÷�����Ʈ���� ������ �÷��� 1�� �̻� �� �� �ִ�.
SELECT nick FROM tblname;
SELECT nick, nick FROM tblname;
SELECT nick, LENGTH(nick) FROM tblname;
SELECT nick, nick, nick FROM tblname;



--SELECT first 
--FROM tblname;
--
--SELECT first 
--    FROM tblname;
--    
--SELECT 
--    first 
--FROM 
--    tblname;
    
SELECT * FROM tblcountry;
SELECT * FROM tbldiary;
SELECT * FROM tblhousekeeping;
SELECT * FROM tblinsa;
SELECT * FROM tblmen;
SELECT * FROM tblwomen;
SELECT * FROM tbltodo;


/* ����Ŭ ��� ǥ��
1. ������ 
    a. ������
        ex) 10
    b. �Ǽ���
        ex) 3.14 
        
2. ����(���ڿ�)��
    ex) '��', 'ȫ�浿'
    
3. ��¥�� ���
    ex) '2018-01-12' : ������ ��� -> (�ڵ� ����ȯ) -> ��¥�� : ���ƿ� ���� �޶���
    ex) '100'
    ex) '2018��01��12��' -- X(���� ǥ�� ����)
    ex) '2018-01-12', '2018/01/12' -- O 
    
*/

-- �÷����� ����
-- SELECT�� ����� �÷������� �����ϰ� ��ȯ���� �� �ְ�,
-- Ȥ�� �����̳� �Լ��� �Ű������� ����� �� �ִ�.
SELECT name, basicpay, basicpay * 1.1 FROM tblinsa;

SELECT last, first, weight, weight + 3 FROM tblname;

SELECT name, length(name) FROM tblcountry;

-- BMI
SELECT last, first, weight / height * height FROM tblname;

-- ���ڿ� ���ϱ� 
SELECT last, first, last + first FROM tblname;  -- ����Ŭ���� ���� x
SELECT last, first, last || first FROM tblname; -- || -> ���ڿ� ���ϱ� ������ 

SELECT last, last FROM tblname;

-- ������� �÷����� �ٲٱ� 
-- : ��Ī(Alias) �����ϱ� 
-- : �̸� �ٲٱ�(***������ �ٲ�� ���� �ƴ�) 
-- : �÷��� AS ����

SELECT last, first FROM tblname;

SELECT FIRST FROM tblname;

-- FROM ������ ������� �ڵ��ϼ� ��� ���� 
SELECT last, first, last || first AS fullName FROM tblname;
SELECT last AS ��, first AS �̸�, last || first AS ��ü�̸� FROM tblname;

SELECT last AS ��, first AS �̸�, last || first AS "��ü �̸�" FROM tblname; -- X �ĺ���(�÷���)�� ������ ���� ���� 
                                                                            -- -> " " (�ֵ���ǥ)�� ����ϸ� �����δ� �����ϴ�(����X)
SELECT ��, �̸�, "��ü �̸�" FROM �������̺�;

SELECT weight as "from" FROM tblname; -- �ĺ��ڰ� ������ ���Ƶ� " "(�ֵ���ǥ) �� �����ش� (����x)


-- ��ü ǥ���
SELECT * FROM tblname;
SELECT * FROM hr.tblname; -- ���ǰ� ����Ҷ�

-- ���� ǥ��� > ��Ű��(�����)��.���̺��.�÷��� 
SELECT first, last FROM hr.tblname;
SELECT tblname.first, tblname.last FROM hr.tblname;
SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT tblname.first, tblname.last FROM tblname;
SELECT n.first, n.last FROM tblname n; -- ���̺� ��Ī
SELECT first, last FROM tblname n;

SELECT *, weight + 100 FROM tblname;
SELECT tblname.*, weight + 100 FROM tblname; -- all(*) �� Ư�� �÷��� ���޾ƾ������� tblname.* 
SELECT n.*, weight + 100 FROM tblname n;

/*

SQL ��(��)�� ���� ����(�켱 ����)

1. SELECT �� - 2 

2. FROM ��   - 1



*/


-- �ý��� ���̺�
-- 1. tabs
--  : �ش� ������ �����ϰ� �ִ� ���̺� ��� 
-- 2. dual
--  : ���� ���̺�
--  : ���̺� ��ü�� �ǹ̰� ����;

-- sysdate : Calendar.getInstance() ���� �ð� ������ �Լ� 

SELECT sysdate FROM dual; -- X -> ���ڵ尡 1�� -> ������ �Լ��� ����ϱ� ����  -> ���� ���ϱ� ����  

SELECT sysdate FROM tblname;

SELECT 100 * 20 FROM dual;




/*


������

1. ��� ������ 
    - +, -, *, / 
    - ������ �����ڰ� ���� -> �Լ��� ����(mod())
  
2. �� ������ 
    - >, >=, <, <=
    - =(==), <>(!=)

3. �� ������
    - and(&&), or(||), not(!)
    
4. ���ڿ� ������ 
    - ||(concat)

5. SQL ������
    - Java : Instanceof, typeof...
    - in, between, like, is, any, all ��...
    
    
    
    
*/

SELECT 10 > 5 FROM dual;
SELECT '����' FROM dual WHERE 10 > 5; -- �����ϸ� ���� ���, ���� �Ҹ����� �ƹ����� ������� ���� 


-- NULL 
-- : �ڹ��� null�� ������ ǥ�� 
-- : SQL�� Null�� ������ ����� �� �� ����.(�ǿ����� �ڰ� X)
-- : SQL�� NULL�� ���Ե� ������ �ϰ� �Ǹ� ������ Null�� ��ȯ


SELECT 10 + NULL FROM dual; -- (null)
SELECT NULL * 300 FROM dual;
SELECT 100 / NULL FROM dual;
SELECT NULL - 20 FROM dual;





