/*

ex11_select.sql

group by ��
- ���ڵ���� Ư�� �÷����� ���缭 �׷��� ������ �۾� 
- �׷��� �� ������?
    1. �׷��� ������ �����Ϸ���? ���� ����? X
    2. ���� ���� �׷��� ������ ���̺�� ����� ���ؼ�?
    3. ������ �׷캰�� �����Լ��� �����ϱ� ���ؼ� (***) -> �����Լ��� �����ϸ� GROUP BY �ǹ� ����
- group by Ű 
    : �׷��� �����µ� ������ �Ǵ� �÷�(1�� or �̻�)
- group by ��� �� �÷�����Ʈ�� �� �� �ִ� ���
    a. ���� �Լ�
    b. group by Ű(group by ��� �÷�)
    c. �� �ܿ��� ������ �÷� ��� �Ұ���

group by ����
- SELECT �÷�����Ʈ
    from ���̺�
        [where ����]
            [group by �׷�]
                [order by ����]
*/


-- �μ��� ��� ����?
SELECT round(avg(basicpay)) FROM tblinsa; -- 155���� -- ��ü ������ ��� ����

SELECT DISTINCT BUSEO FROM tblinsa;

SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '�ѹ���'; -- 171
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '���ߺ�'; -- 138
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '������'; -- 160
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '��ȹ��'; -- 185
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '�λ��'; -- 153
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '�����'; -- 141
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = 'ȫ����'; -- 145

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO;
    
SELECT BUSEO, count(*) as �ο� FROM tblinsa
    GROUP BY BUSEO;
    
    
    
SELECT * FROM tblcountry -- ORA-00979: not a GROUP BY expression
    GROUP BY name; -- group by Ű���� PK�� ��� ����.
    
SELECT count(*), continent, name FROM tblcountry -- ORA-00979: not a GROUP BY expression
    GROUP BY continent;

SELECT * FROM tabs;

SELECT substr(ssn, 8, 1) FROM tblinsa;

SELECT count(*), substr(ssn, 8, 1) FROM tblinsa 
    GROUP BY substr(ssn, 8, 1);
    
SELECT count(*), to_char(ibsadate, 'mm') FROM tblinsa
    GROUP BY to_char(ibsadate, 'mm')
        ORDER BY to_char(ibsadate, 'mm') ASC;

SELECT count(*), substr(name, 1, 1) FROM tblinsa
    GROUP BY substr(name, 1, 1)
        ORDER BY count(*) DESC, substr(name, 1, 1) ASC;


SELECT count(*), floor(basicpay / 1000000) * 100 || '������' FROM tblinsa
    GROUP BY floor(basicpay / 1000000);
    
    
    
    
-- 1. SELECT    - 4
-- 2. FROM      - 1
-- 3. WHERE     - 2
-- 4. GROUP BY  - 3
-- 5. ORDER BY  - 5


-- ����?
-- ���� X : tblinsa���� buseo���� ��� �޿��� ����������.
-- ���� O : tblinsa���� �� ���� �� ���� ������ 2�鸸�� �̻��� ����鸸 ������ BUSEO�� �׷� > ��� �޿� 
SELECT BUSEO, avg(basicpay) 
    FROM tblinsa
        WHERE basicpay >= 2000000
            GROUP BY BUSEO;
    


-- ���� X : �������� �׷� ������ �� ������ ������ �� ���� ������ ���� ����� ����?
-- ���� O : �븮�� ����鿡 ���ؼ� �������� �׷� ������ ...
SELECT city, max(basicpay), count(*) 
    FROM tblinsa
        WHERE jikwi in ('�븮', '���')
            GROUP BY CITY;


/*

having ��(��)
- GROUP BY���� �Բ� ���
- ������(WHERE���� ���� ����)
- having�� �� �� �ִ� ����� GROUP BY ���� ���� 
- having ��� : �����Լ� or GROUP BY Ű

*/

-- �μ��� ��� ����?
SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO;

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    WHERE basicpay >= 2000000  -- ���� ������ 200���� �Ѵ� ������� �μ��� �׷�ȭ 
        GROUP BY BUSEO;

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO 
        HAVING avg(basicpay) >= 1500000; -- �μ� ����� 150���� �Ѵ� �μ��� �׷�ȭ(�׷� ����)

SELECT jikwi, count(*), round(avg(basicpay)) FROM tblinsa
    WHERE basicpay >= 1400000 -- ���� 140������ �Ѵ� ��� ���
        GROUP BY jikwi -- �������� ���´� 
            HAVING count(*) >= 3; -- �� �������� 3�� �̻��� �����ϴ� ������ �׷�ȭ
    

-- 1. SELECT    - 5
-- 2. FROM      - 1
-- 3. WHERE     - 2
-- 4. GROUP BY  - 3
-- 5. HAVING    - 4
-- 6. ORDER BY  - 6

SELECT BUSEO, JIKWI, count(*) FROM tblinsa
    GROUP BY BUSEO, JIKWI
        ORDER BY BUSEO ASC, JIKWI ASC; -- ������ �׷�ȭ














    







        






































