-- ex04_where.sql

/*

WHERE��
- SELECT �÷�����Ʈ FROM ���̺�� WHERE�� 
- ����ڰ� �����ͺ��̽� �����͸� ������ �� �׻� ��� �����͸� �������� �ʴ´�.
- ������ ������ �ؼ� �Ϻ� ���ڵ常 �������� �Ѵ�. -> ������
- ��, ������ �Ǵ��ϴ� ������� ��� -> �� ������ & �� ������ 


1. SELECT  - 3

2. FROM    - 1

3. WHERE   - 2 (�߿�) 

SELECT -> ���� ���͸�
WHERE  -> ���� ���͸� 

*/

SELECT * FROM tblname WHERE weight > 70;

SELECT * FROM tblname WHERE weight >= 70 and weight <= 90;

SELECT last || first as �̸�, weight as ������ FROM tblname WHERE weight >= 70 and weight <= 90;

SELECT last || first as �̸� FROM tblname WHERE weight >= 70 and weight <= 90;


-- ��ȣ
SELECT * FROM tblname WHERE last = '��';
SELECT * FROM tblname WHERE height = 184;
SELECT * FROM tblinsa WHERE ibsadate = '98/10/11'; 
SELECT * FROM tblinsa WHERE ibsadate = '1998-10-11'; -- ����

-- ����Ŭ�� ���ڿ� ����� ��¥������ �ڵ� ����ȯ�� �����ش�.
-- �ú��ʰ� ��������� �ڵ� ����ȯ �Ұ��� -> �Լ� �۾� 
SELECT * FROM tbltodo WHERE adddate = '2018-01-01 06:00:00';
SELECT * FROM tbltodo WHERE adddate = '2018-01-01'; -- �ú��ʱ��� ���Ѵ�. �ڵ� ����ȯ�� 0�� 0�� 0�ʸ� ����ִ´� 00:00:00


-- �� ����
SELECT * FROM tblname WHERE height >= 170;
SELECT * FROM tblname WHERE 1 = 1; -- ������ YES 
SELECT * FROM tblname WHERE 1 > 0;

SELECT * FROM tblname WHERE weight / height * height > 20;

SELECT * FROM tblcountry;

SELECT name, length(name) FROM tblcountry;

SELECT name, length(name) FROM tblcountry WHERE length(name) >= 4;

-- �� ���꿡 ���Ǵ� �ڷ���
-- 1. ������
-- 2. ������ if ("ȫ�浿" > "�ƹ���") -> if ("ȫ�浿".compareTo("�ƹ���") > 0)
-- 3. ��¥ �ð��� if (c1 > c2) -> tick

SELECT * FROM tblname WHERE weight > 70;
SELECT * FROM tblname WHERE first > '��';
SELECT * FROM employees WHERE first_name < 'D';
SELECT * FROM tblinsa WHERE ibsadate >= '2000-01-01';



98/10/11


/*

between 
- where������ ��� (�������� ���)
- ���� ���� ����
- �÷��� between �ּҰ� and �ִ밪 
- ������ ��� 
- �ּҰ�, �ִ밪 ��� ����(inclusive) 

*/

SELECT * FROM tblname
    WHERE weight >= 70 and weight <= 90; 

SELECT * FROM tblname
    WHERE weight BETWEEN 70 AND 90;
    
SELECT * FROM employees
    WHERE last_name BETWEEN 'D' and 'E';
    
SELECT * FROM tblinsa
    WHERE ibsadate BETWEEN '1999-01-01' AND '2000-12-31';
    
-- between �� ��� ���� > ��(��) �����ڸ� ����ϴ°� �ӵ��� �� ���� 


/*
in
- where������ ���(�������� ���)
- ������ ���� ��(���ð� �߿��� �ϳ��� �����ϸ� ��������)
- �÷��� in(������ ��)
*/
SELECT * FROM tblcountry
    WHERE continent = 'AS' or continent = 'EU';

SELECT * FROM tblcountry
    WHERE continent IN ('AS', 'EU');
    
SELECT * FROM tblinsa
    -- WHERE buseo = '��ȹ��';
    -- WHERE buseo = '��ȹ��' or buseo = '������' or buseo = '�ѹ���';
    WHERE buseo IN ('��ȹ��', '������', '�ѹ���')
        AND jikwi IN('����', '����')
        AND city IN ('����', '��õ')
        AND basicpay BETWEEN 2500000 AND 3000000;



/*

like
- where ������ ���(�������� ���)
- ���� ����(Ư���� ������ ������ ���ڿ� �˻�)
- �÷��� like '���� ���ڿ�'
- �������� ������� �˻� 

���� ���ڿ� ���� ���
1. _: ������ ���� 1��
2. %: ������ ���� 0 ~ ���Ѵ� 

*/

SELECT name FROM tblinsa
    -- WHERE name like '��__';
    WHERE name like '��%'; -- �� ���ڼ��� Ư�� ������ ������ 
        
SELECT * FROM employees
    -- WHERE first_name like 'N____';
    -- WHERE first_name like 'N%';
    -- WHERE first_name like '__n_e';
    -- WHERE first_name like 'N%e';
    -- WHERE first_name like '%e';
    -- WHERE first_name like '%te';
    WHERE first_name like '%an%'; -- a �� ����? 

-- ���̹� �˻�?
SELECT * from ���̹�
    -- WHERE subject = '�ڹ�'; -- X 
    -- WHERE subject like '�ڹ�&' -- X
    -- WHERE subject like '%�ڹ�%'; -- O
    WHERE subject like '%�ڹ�%����%'
        or subject like '%����%�ڹ�%'; -- O
        or subject like '%����%';
        or subject like '%�ڹ�%';
    
SELECT * from tblinsa
    -- WHERE ssn like '______-1______'; 
    WHERE tel like '019-____-____';



/*
null ���� 
- where ������ ���
- null �ǿ����ڷ� ��� �Ұ� -> ���ǿ��� ��� �Ұ�
- �÷��� is null (�÷��� == null ?)
*/
-- �α����� �̱����� ����?

SELECT * FROM tblcountry
    -- WHERE population = NULL; -- ����Ŭ���� ����� null�� �ǿ����ڷ� ����� �� ����. if (pop == null)
    WHERE population is null;

-- tblinsa ����ó �̱��� ����?
SELECT * FROM tblinsa
    WHERE tel is null;
    
-- �α��� ����� ����
SELECT * FROM tblcountry 
    WHERE population is not null;

-- ����ó�� ����� �����
SELECT * FROM tblinsa WHERE tel is not null; -- ���� 
SELECT * FROM tblinsa WHERE not tel is null; -- ������ �� 

SELECT * FROM tblinsa WHERE city in ('����', '��õ', '�λ�');
SELECT * FROM tblinsa WHERE not city in ('����', '��õ', '�λ�');
SELECT * FROM tblinsa WHERE not name like '��%';

-- completedate : ���� �Ϸ� �ð�
-- ���� ���� �Ϸ� ���Ѱ͵鸸 ��������
SELECT * FROM tbltodo WHERE completedate is null;
SELECT * FROM tbltodo WHERE completedate is not null;

-- ������ �뿩 ���̺�
-- �뿩��, �ݳ��� 
SELECT * FROM �뿩���̺� WHERE �ݳ��� is null; -- ���� �뿩���� ���



/*

distinct
- �÷� ����Ʈ���� ���
- distinct �÷���
- �ߺ��� ���� 
- null�� �������� �� ������ �ν��Ѵ�. -> Null�� ������ ���ڵ�鵵 �ߺ��� ���� �� 1�� ��ȯ 
- ���� �÷��� ������� distinct ���

*/

-- ���� ���̺� ����� �� �ִ���?
SELECT continent FROM tblcountry;
SELECT distinct continent FROM tblcountry;

-- ���� ����?
SELECT gender FROM tblname;
SELECT distinct gender FROM tblname;

-- tblinsa ������ ��͵��� �ִ���?
SELECT jikwi FROM tblinsa;
SELECT distinct jikwi FROM tblinsa;


SELECT distinct last FROM tblname;
SELECT distinct first FROM tblname; -- �ߺ��� ������� ���� ���� 

SELECT distinct population FROM tblcountry
    WHERE population is not Null; -- NULL �� ���� �� �ߺ��� ���� 
    
DROP TABLE tblmen;
DROP TABLE tblwomen;
    

SELECT * FROM tblmen WHERE couple is null; -- �ַ� 
SELECT * FROM tblwomen WHERE couple is null; -- �ַ�

-- distinct�� ���� �÷����� ������ �� �ִ�.
SELECT distinct price FROM tblhousekeeping;
SELECT price, qty FROM tblhousekeeping;
SELECT distinct price, qty FROM tblhousekeeping; -- �� �÷��� ���������� ���� �ߺ��Ǵ� ���� ���� 
-- SELECT price, distinct qty FROM tblhousekeeping;



/*

case 
- �÷� ����Ʈ�� ���
- ���������� ��� 
- �ڹٿ����� if + case���� ���� 

*/

SELECT last || first as name, 
    case 
        when gender = 'm' then '����'
        when gender = 'f' then '����'
    end AS gender
FROM tblname;
    

SELECT name, case when continent = 'AS' then '�ƽþ�' when continent = 'EU' then '����' end FROM tblcountry;

SELECT name, -- ������ �������� ���ϴ� ��쿡�� NULL���� ��ȯ �Ѵ�.
    case 
        when continent = 'AS' then '�ƽþ�'
        when continent = 'EU' then '����' 
        else '��Ÿ'
    end 
FROM tblcountry;


-- �̹��� �޿� -> ����(����)�� sudang x 2�� ����
SELECT name, basicpay, sudang,
    case
        WHEN jikwi = '����' then sudang * 2
        WHEN jikwi = '����' then sudang * 2
        WHEN jikwi = '�븮' then sudang 
        else sudang
    end as ���ʽ�
, jikwi FROM tblinsa;


SELECT name, basicpay,
    CASE -- ������ �����ʿ���� -> ������ ���� ���͸� �� 
        WHEN basicpay >= 2000000 then '��� ����'
        WHEN basicpay >= 1000000 then '�Ϲ� ����'
        else '���� ����'
    END 
FROM tblinsa;


SELECT name, weight, couple,

    CASE
        WHEN weight > 90 then '��ü��'
        WHEN weight > 60 then '����ü��'
        WHEN weight >= 0 then '��ü��'
        ELSE '����'
    END as ü�߻���,
    
    CASE
        WHEN couple is not NULL then '����ģ�� ����'
        WHEN couple is NULL then '�ַ�'
    END as ���ֻ���
    
FROM tblmen;

SELECT TITLE, 
    CASE
        WHEN completedate is NULL then '������..'
        WHEN completedate is not NULL then '�Ϸ�'
    END as �ϷῩ��
FROM tbltodo;


/* 

����, Sorting
- ������� ���ڵ��� ������ ����(���� ���̺���� ����)
- ���� ���̺� ���ڵ� ������ DBMS�� �˾Ƽ� ��
- ORDER BY �÷��� [ASC|DESC]
    - ORDER BY �÷��� ASC  // Ascending, �������� 
    - ORDER BY �÷��� DESC // Descending, ��������
    - ORDER BY �÷���      // ����, ��������

- ASC
    - 10 -> 20 -> 30 
    - '��' -> '��' -> '��'
    - '2016' -> '2017' -> '2018'


*/

SELECT * FROM tblinsa 
    -- ORDER BY name ASC;    
    -- ORDER BY ibsadate DESC;
    -- ORDER BY basicpay DESC;
    -- ORDER BY basicpay + sudang DESC; -- �ΰ� ���� ���� ���� ���� 
    ORDER BY BUSEO ASC, JIKWI ASC, BASICPAY DESC; -- 1. �μ�, 2. ����, 3. �⺻ �޿� -> ���� ���� 
    
-- �ֱ� �Ϸ��� ���Ϻ��� �������ÿ�.
SELECT * FROM tbltodo ORDER BY COMPLETEDATE DESC;        
            
-- ���� ��� NULL�� ���ԵǾ� ������ �Ϲ������� ���� �����Ѵ�.(���� �񱳰� �Ұ����ϱ� ������)
-- ���� NULL�� ���ԵǴ� �����̶��.. -> NULL�� ��ġ��? -> DBMS�� ���� �ٸ���.
SELECT * FROM tbltodo 
    WHERE COMPLETEDATE IS NOT NULL
        ORDER BY COMPLETEDATE DESC;        

/*          [����]
1. SELECT   - 3
2. FROM     - 1 
3. WHERE    - 2
4. ORDER BY - 4               
*/

SELECT last || first as name 
FROM tblname
-- WHERE name = '���缮';
-- WHERE last || first = '���缮'
-- ORDER BY last || first
ORDER BY name;

                        
                                
                                
                                    
        
        
            
            
                
                
                    
                        
    
        
            
                
                    
                        
                            
                                

