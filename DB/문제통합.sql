-- 01. tblinsa ���̺� ��ü ���ڵ� ��ȸ
SELECT * FROM tblinsa;
-- 02. HR ����� ���� ���̺� ��� Ȯ��
SELECT * FROM tabs;
-- 03. tblinsa ���̺� ���� Ȯ��
desc tblinsa;
-- 04. tblinsa ���̺��� �̸�(name), �⺻��(basicpay) ��ȸ
SELECT name, basicpay FROM tblinsa;
-- 05. tblinsa ���̺��� �̸�(name), �⺻��(basicpay), ����(sudang), �⺻��+���� ��ȸ
SELECT name, basicpay, sudang, basicpay + sudang FROM tblinsa;
-- 06. �̸�(name), ��ŵ�(city), �μ���(buseo) ��ȸ. ���� ���.
SELECT name as �̸�, city as ��ŵ�, buseo as �μ��� FROM tblinsa;
-- 07. ���� ����� �̸�(name), ��ŵ�(city), �μ���(buseo), ����(jikwi) ��ȸ
SELECT name, city, buseo, jikwi FROM tblinsa WHERE city = '����';
-- 08. ��ŵ��� ���� ����̸鼭       --> WHERE ����
--     �⺻���� 150���� �̻��� ���   --> WHERE ����
--     ��ȸ (name, city, basicpay, ssn)
SELECT name, city, basicpay, ssn FROM tblinsa WHERE city = '����' AND basicpay >= 1500000;

-- 09. ��ŵ��� '��õ' �̸鼭, �⺻���� 100�����̻� ~ 200���� �̸��� ��츸 ������� ��ȸ.
SELECT * FROM tblinsa WHERE city = '��õ' AND basicpay >= 1000000 AND basicpay < 2000000;
-- 10. ��ŵ��� ���� ����̰ų� �μ��� ���ߺ��� �ڷ� ��ȸ (name, city, buseo)
SELECT name, city, buseo FROM tblinsa WHERE city = '����' or buseo = '���ߺ�';
-- 11. ��ŵ��� ����, ����� ����� ��ȸ (name, city, buseo). IN ������ ���.
SELECT name, city, buseo FROM tblinsa WHERE city in ('����', '���');
-- 12. �μ��� '���ߺ�' �̰ų� '������'�� ����� ������� ��ȸ. IN ������ ���.
SELECT * FROM tblinsa WHERE buseo in ('���ߺ�', '������');
-- 13. �޿�(basicpay + sudang)�� 250���� �̻��� ��� ��ȸ. --> WHERE ����
--     ��, �ʵ���� �ѱ۷� ���. --> ��Ī
--     (name, basicpay, sudang, basicpay+sudang)
SELECT name as �̸�, basicpay as �⺻��, sudang as ����, basicpay + sudang as �ѱ޿� FROM tblinsa WHERE basicpay + sudang >= 2500000;

-- 14. �ֹι�ȣ�� �������� ����(�������� 1, 3)�� ��ȸ. (�̸�(name), �ֹι�ȣ(ssn)). 
--     ��, SUBSTR() �Լ� �̿�.
SELECT name, ssn FROM tblinsa WHERE substr(ssn, 8, 1) = 1 OR substr(ssn, 8, 1) = 3;
 
-- 15. �ֹι�ȣ�� �������� 80��� �¾ ����� ���. (�̸�(name), �ֹι�ȣ(ssn)). 
--     ��, SUBSTR() �Լ� �̿�.
SELECT name, ssn FROM tblinsa WHERE substr(ssn, 1, 1) = 8;

-- 16. ���� ��� �߿��� 70��� �¾ ����� ���. SUBSTR() �Լ� �̿�.
SELECT * FROM tblinsa WHERE city = '����' AND substr(ssn, 1, 1) = 7;
    
-- 17. ���� ��� �߿��� 70��� �¾ ���ڸ� ���. SUBSTR() �Լ� �̿�.
SELECT * FROM tblinsa WHERE city = '����' AND substr(ssn, 1, 1) = 7 AND substr(ssn, 8, 1) = 1;
 
-- 18. ���� ����̸鼭 �达�� ���(������ 1�ڶ�� ����). (�̸�, ��ŵ�). 
-- SUBSTR() �Լ� �̿�.
SELECT name as �̸�, city as ��ŵ� FROM tblinsa WHERE city = '����' AND substr(name, 1, 1) = '��';

-- 19. 2000�⵵�� �Ի��� ��� ���. (�̸�, ��ŵ�, �Ի���). 
-- SUBSTR() �Ǵ� TO_CHAR() �Լ� �̿�.
SELECT name as �̸�, city as ��ŵ�, ibsadate as �Ի��� FROM tblinsa WHERE substr(ibsadate, 1, 1) = '2';

-- 20. 2000�� 10���� �Ի��� ��� ���. (�̸�, ��ŵ�, �Ի���). 
SELECT name as �̸�, city as ��ŵ�, ibsadate as �Ի��� FROM tblinsa WHERE to_char(ibsadate, 'YYYY-MM') = '2000-10';

-- 21. �ֹι�ȣ�� �������� ������ ���� ���ϱ�(��, ��� ������ 1900��뿡 �¾�ٴ� ����). (�̸�, �ֹι�ȣ, ����)
SELECT name, ssn, to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) as ���� FROM tblinsa;  

-- 22. �ֹι�ȣ �������� ���� ���̴밡 40���� ����� ���.
SELECT * FROM 
    tblinsa 
        WHERE to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) >= 40 AND
            to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) <= 49;

-- 23. �ֹι�ȣ �������� 5���޻��� ���. SUBSTR() �Լ� �̿�.
SELECT * FROM tblinsa WHERE substr(ssn, 3, 2) = '05';

-- 24. �ֹι�ȣ �������� 5���޻��� ���. TO_CHAR() �Լ� �̿�. ---------------------------------------------
-- ���ڿ� -> ��¥ -> ���ڿ�
SELECT * FROM tblinsa WHERE to_date(ssn, "");

-- 25. ��ŵ� ������������ �����ϰ�, ��ŵ��� ������ �⺻�� ��������
SELECT * FROM tblinsa ORDER BY city DESC, basicpay DESC;
 
 
-- 26. ���� ��� �߿��� �⺻��+����(->�޿�) ������������ ����. 
-- (�̸�, ��ŵ�, �⺻��+����)
SELECT name, city, basicpay + sudang FROM tblinsa WHERE city = '����' ORDER BY basicpay + sudang DESC;


 
-- 27. ���� �� �μ� ������������ �����ϰ�, �μ��� ������ �⺻�� �������� ����. (�̸�, �ֹι�ȣ, �μ�, �⺻��)
SELECT name, ssn, buseo, basicpay FROM tblinsa ORDER BY BUSEO ASC, basicpay DESC;


-- 28. ���� �߿��� ���̸� �������� �������� �����ؼ� ���.
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = 1 ORDER BY to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) ASC;

-- 29. ���� ���� ����� �߿��� �Ի����� ���� ����� ���� ���.
SELECT * FROM tblinsa WHERE city = '����' ORDER BY ibsadate DESC;

-- 30. ������ �达�� �ƴ� ��� ���. (�̸�, ��ŵ�, �⺻��). 
-- LIKE ������ �Ǵ� SUBSTR() �Լ� �̿�.
SELECT name, city, basicpay FROM tblinsa WHERE name not like '��%'; 

-- 31. ��ŵ��� ����, �λ�, �뱸 �̸鼭 
-- ��ȭ��ȣ�� 5 �Ǵ� 7�� ���Ե� �ڷ� ����ϵ� 
-- �μ����� ������ �δ� ��µ��� �ʵ�����. 
-- (�̸�, ��ŵ�, �μ���, ��ȭ��ȣ)
SELECT name, city, substr(buseo, 1, 2), tel FROM tblinsa WHERE city in ('����', '�λ�', '�뱸') AND (tel like '%5%' OR tel like '%7%');

  
-- 32. ��ȭ��ȣ�� ������ '-'�� �����ϰ� ����ϰ�, ������ '��ȭ��ȣ����'�� ���
-- �߰�����) HR����, employees ���̺��� Ŀ�̼� �޴� ����� ���� 
-- �ȹ޴� ����� ���� ���
--COUNT(), NVL(), GROUP BY ����
SELECT 
    CASE
        WHEN TEL IS NOT NULL THEN replace(tel, '-', '')
        WHEN TEL IS NULL THEN '��ȭ��ȣ����'
    END
FROM tblinsa;


-- 33. tblinsa ���̺��� basicpay+sudang�� 100���� �̸�
-- , 100���� �̻�~200���� �̸�, 200���� �̻��� �������� �� ���.
--GROUP BY ����
SELECT �޿�����, count(*) FROM 
    (SELECT
        CASE 
           WHEN basicpay + sudang < 1000000 THEN '100�����̸�'
           WHEN basicpay + sudang >= 1000000 AND basicpay + sudang < 2000000 THEN '200�����̸�'
           WHEN basicpay + sudang >= 2000000 THEN '200�����̻�'
        END as �޿����� 
    FROM tblinsa)
GROUP BY �޿�����;
    
-- 34. tblinsa ���̺��� �ֹι�ȣ�� ������ ��������� �⵵�� ������ ���
SELECT substr(ssn, 1, 2) as �⵵, count(*) FROM tblinsa GROUP BY substr(ssn, 1, 2) ORDER BY substr(ssn, 1, 2) ASC;

-- 35. �ֹι�ȣ�� �������� ���� ��������, ���� ������ �⵵ �������� ���. 
-- (�̸�, �ֹι�ȣ) . SUBSTR() �Լ� �̿�.
SELECT name, ssn FROM tblinsa ORDER BY substr(ssn, 3, 2) ASC, substr(ssn, 1, 2) DESC;

-- 36. �Ի����� ��������  ���� ��������, ���� ������ �⵵ �������� ���. 
-- ����. �Ի����� �ڷ����� DATE�̴�.
SELECT * FROM tblinsa ORDER BY to_char(ibsadate, 'MM') ASC, to_char(ibsadate, 'YYYY') DESC;
    

-- 37. ��ü�ο���, �����ο���, �����ο����� ���� ���.-------------------------------------------
SELECT 
    CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '����'
        WHEN substr(ssn, 8, 1) = 2 THEN '����'
    END as ����,
    count(*) 
FROM tblinsa GROUP BY substr(ssn, 8, 1);

-- 38. ���ߺ�, ������, �ѹ��� �ο��� ���. COUNT(), DECODE() �Լ� �̿�.
SELECT count(decode(buseo, '������', NULL, '�ѹ���', NULL, '���ߺ�', '���ߺ�')) as ���ߺ�, 
       count(decode(buseo, '������', NULL, '�ѹ���', '�ѹ���', '���ߺ�', NULL)) as �ѹ���, 
       count(decode(buseo, '������', '������', '�ѹ���', NULL, '���ߺ�', NULL)) as ������
    FROM tblinsa 
        
-- 39. ���� ����� ���� �ο��� ���. ----------------------------
SELECT count(*) FROM tblinsa WHERE city = '����' AND substr(ssn, 8, 1) = 1;

-- 40. �μ��� �������̰�, ���� �ο���, ���� �ο��� ���.  COUNT(), DECODE() �Լ� �̿�.        ----------------
SELECT count(*) FROM tblinsa WHERE BUSEO = '������' GROUP BY substr(ssn, 8, 1);
    
-- 41. ���ߺ�, ������, �ѹ��� �ο��� ���. ��, ������ '����'�� ����.
SELECT count(decode(buseo, '������', NULL, '�ѹ���', NULL, '���ߺ�', '���ߺ�')) as ���ߺ�, 
       count(decode(buseo, '������', NULL, '�ѹ���', '�ѹ���', '���ߺ�', NULL)) as �ѹ���, 
       count(decode(buseo, '������', '������', '�ѹ���', NULL, '���ߺ�', NULL)) as ������ 
FROM tblinsa WHERE city = '����';
 
-- 42. ���� ����� ���ڿ� ������ �⺻���� ���.
SELECT  CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '����'
        WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����, sum(basicpay) FROM tblinsa WHERE city = '����' GROUP BY substr(ssn, 8, 1);

-- 43. ���ڿ� ������ �⺻�� ��հ� ���. AVG(), DECODE() �Լ� �̿�.
SELECT  CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '����'
        WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����, round(avg(basicpay)) FROM tblinsa GROUP BY substr(ssn, 8, 1);


-- 44. ���ߺ��� ����, ���� �⺻�� ��հ� ���.
SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = '���ߺ�' GROUP BY substr(ssn, 8, 1);

-- 45. �μ��� ���ڿ� ���� �ο��� ���ϱ�
SELECT  BUSEO, CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '����'
        WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����, count(*) FROM tblinsa GROUP BY BUSEO, substr(ssn, 8, 1)
        ORDER BY BUSEO ASC;
        
-- 46. ������ ���ڿ� ���� �ο��� ���ϱ�
SELECT city, CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '����'
        WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����, count(*) FROM tblinsa GROUP BY city, substr(ssn, 8, 1)
        ORDER BY city ASC;

-- 47. �Ի�⵵�� ���ڿ� ���� �ο��� ���ϱ�
SELECT to_char(ibsadate, 'YYYY'), 
        CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '����'
            WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����
        ,count(*) FROM tblinsa GROUP BY to_char(ibsadate, 'YYYY'), substr(ssn, 8, 1)
        ORDER BY to_char(ibsadate, 'YYYY') ASC;

-- 48. ������, �ѹ��� �ο����� ������ �Ի�⵵�� ���ڿ� ���� �ο��� ���ϱ�
SELECT to_char(ibsadate, 'YYYY'), 
        CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '����'
            WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����,
    count(*)
    FROM tblinsa
        WHERE buseo in ('������', '�ѹ���')
          GROUP BY to_char(ibsadate, 'YYYY'), substr(ssn, 8, 1)
          ORDER BY to_char(ibsadate, 'YYYY');


-- 49. ���� ����� �μ��� ���ڿ� �����ο���, ���ڿ� ���� �޿��� ���.
SELECT BUSEO, CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '����'
            WHEN substr(ssn, 8, 1) = 2 THEN '����'
        END as ����,
        count(*), sum(basicpay) FROM tblinsa WHERE city = '����' GROUP BY BUSEO, substr(ssn, 8, 1)
        ORDER BY BUSEO ASC;


-- 50. �μ��� �ο��� ���. �ο����� 10 �̻��� ��츸.
SELECT BUSEO, count(*) FROM tblinsa GROUP BY BUSEO HAVING count(*) > 10
    ORDER BY BUSEO ASC;


-- 51. �μ��� ��,�� �ο��� ���. �����ο����� 5�� �̻��� �μ��� ���. -----------------------------
SELECT count(*) FROM tblinsa GROUP BY BUSEO, substr(ssn, 8, 1); 

 
-- 52. �̸�, ����, ���� ���
--        ����: �ֹι�ȣ 1,3->����, 2,4->���� (DECODE ���)
--        ����: �ֹι�ȣ �̿��ؼ�
SELECT 
    name, 
    decode(substr(ssn, 8, 1), 1, '����', 2, '����', 3, '����', 4, '����'),
    to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2))
FROM tblinsa;

 
-- 53. ���� ��� �߿��� �⺻���� 200���� �̻��� ���. (�̸�, �⺻��)
SELECT name, basicpay FROM tblinsa WHERE city = '����' AND basicpay >= 2000000;


 
-- 54. �Ի���� �ο��� ���ϱ�. (��, �ο���)   COUNT, GROUP BY, TO_CHAR ���
--         ������� ----------
--         ��      �ο���
--         1��    10��
--         2��    25��
SELECT to_char(ibsadate, 'MM') as ��, count(*) as �ο��� 
    FROM tblinsa 
        GROUP BY to_char(ibsadate, 'MM')
            ORDER BY to_char(ibsadate, 'MM') ASC;


-- 55. �̸�, �������, �⺻��, ������ ���.
--        ��������� �ֹι�ȣ ���� (2000-10-10 �������� ���)
--        �⺻���� \1,000,000 �������� ���
SELECT name, '19' || substr(ssn, 1, 2) || '-' || substr(ssn, 3, 2) || '-' || substr(ssn, 5, 2), ltrim(to_char(basicpay, '9,999,999')), sudang FROM tblinsa
     ORDER BY sudang DESC, name ASC;
 
-- 56. �̸�, ��ŵ�, �⺻���� ����ϵ� ��ŵ� �������� ���(1�� ���� ����). 
-- ��ŵ��� ������ �⺻�� �������� ���(2�� ���� ����).
SELECT name, city, basicpay FROM tblinsa ORDER BY city DESC, basicpay ASC; 
 
-- 57. ��ȭ��ȣ�� NULL�� �ƴѰ͸� ���. (�̸�, ��ȭ��ȣ)
SELECT name, tel FROM tblinsa WHERE tel is not null;

-- 58. �ٹ������ 15�� �̻��� ��� ���. (�̸�, �Ի���)
SELECT name, ibsadate FROM tblinsa WHERE (sysdate - ibsadate) / 365 >= 15
ORDER BY IBSADATE ASC, NAME ASC;  
 
-- 59. �ֹι�ȣ�� �������� 75~82��� ���. (�̸�, �ֹι�ȣ, ��ŵ�). 
-- SUBSTR() �Լ�, BEWTEEN AND ����, TO_NUMBER() �Լ� �̿�.
SELECT name, ssn, city FROM tblinsa WHERE substr(ssn, 1, 2) BETWEEN 75 AND 82; 

-- 60. �ٹ������ 15~20���� ��� ���. (�̸�, �Ի���)
SELECT name, ibsadate FROM tblinsa WHERE (sysdate - ibsadate) / 365 >= 15 AND (sysdate - ibsadate) / 365 <= 20;
 
-- 61. �达, �̾�, �ھ��� ��� (�̸�, �μ�). SUBSTR() �Լ� �̿�.
SELECT name, buseo FROM tblinsa WHERE substr(name, 1, 1) in ('��', '��', '��');
 
-- 62. �Ի����� "��-��-�� ����" �������� ���ڸ� ��� (�̸�, �ֹι�ȣ, �Ի���)
SELECT name, ssn, ibsadate || ' ' || to_char(ibsadate, 'dy') FROM tblinsa WHERE substr(ssn, 8, 1) = '1';


-- 63. �μ��� ������ �޿��� ���ϱ�. (�μ�, ����, �޿���)
SELECT buseo, jikwi, sum(basicpay)  FROM tblinsa GROUP BY buseo, jikwi;

-- 64. �μ��� ������ �ο���, �޿���, �޿���� ���ϱ�. (�μ�, ����, �޿���)
SELECT buseo, jikwi, count(*), sum(basicpay), round(avg(basicpay)) FROM tblinsa GROUP BY buseo, jikwi;
 
-- 65. �μ��� ������ �ο����� ���ϵ� �ο����� 5�� �̻��� ��츸 ���.
SELECT buseo, jikwi, count(*) FROM tblinsa GROUP BY buseo, jikwi HAVING count(*) >= 5;

-- 66. 2000�⿡ �Ի��� �����. (�̸�, �ֹι�ȣ, �Ի���)
SELECT name, ssn, ibsadate FROM tblinsa WHERE to_char(ibsadate, 'yyyy') = '2000' AND substr(ssn, 8, 1) = '2';
 
-- 67. ������ �� ����(��, ��, �� ��)��� �����Ͽ� ������ �ο��� (����, �ο���)
SELECT substr(name, 1, 1), count(*) FROM tblinsa GROUP BY substr(name, 1, 1);
    
-- 68. ��ŵ�(CITY)�� ���� �ο���.
SELECT city, 
CASE
    WHEN substr(ssn, 8, 1) = '1' THEN '����'
    WHEN substr(ssn, 8, 1) = '2' THEN '����'
END,
count(*)

FROM tblinsa GROUP BY city, substr(ssn, 8, 1);
 
-- 69. �μ��� �����ο����� 5�� �̻��� �μ��� �����ο���.
SELECT buseo, count(*) FROM tblinsa WHERE substr(ssn, 8, 1) = '1' GROUP BY buseo HAVING count(*) >= 5;
 
-- 70. �Ի�⵵�� �ο���.
SELECT to_char(ibsadate, 'yyyy'), count(*) FROM tblinsa GROUP BY to_char(ibsadate, 'yyyy');

-- 71. ��ü�ο���, 2000��, 1999��, 1998�⵵�� �Ի��� �ο��� ������ �������� ���.---------------
--         2000 1999 1998
--          x    x    x
SELECT distinct (SELECT count(*) FROM tblinsa),
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '2000%') as "2000",
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '1999%') as "1999",
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '1998%') as "1998" FROM tblinsa; 

-- 72. �Ʒ� �������� ������ �ο��� ���.--------------------------
--          ����  ��õ  ���
--           x     x     x
SELECT distinct (SELECT count(*) FROM tblinsa),
                (SELECT count(*) FROM tblinsa WHERE city = '����') as "2000",
                (SELECT count(*) FROM tblinsa WHERE city = '��õ') as "1999",
                (SELECT count(*) FROM tblinsa WHERE city = '���') as "1998" FROM tblinsa; 

-- 73. �⺻��(basicpay)�� ��� ������ ��� ���. (�̸�, �⺻��). AVG() �Լ�. ��������.
SELECT name, basicpay FROM tblinsa WHERE basicpay <= (SELECT avg(basicpay) FROM tblinsa);


-- 74. �⺻�� ���� 10%�� ���. (�̸�, �⺻��)
SELECT name, basicpay FROM tblinsa WHERE basicpay <= (SELECT max(basicpay) FROM tblinsa) AND basicpay >= (SELECT max(basicpay) - max(basicpay) / 10 FROM tblinsa);


-- 75.�⺻�� ������ 5���������� ���
SELECT name, basicpay, rownum FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) WHERE rownum <= 5;


-- 76. �Ի����� ���� ������ 5���������� ���.
SELECT * FROM (SELECT * FROM tblinsa ORDER BY ibsadate DESC) WHERE rownum <= 5;


-- 77. ��� �޿����� ���� �޿��� �޴� ���� ���  
SELECT * FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa);

-- 78. '�̼���' ������ �޿����� �� ���� �޿��� �޴� ���� ���.
SELECT name, basicpay FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE name = '�̼���');


-- 79. �ѹ����� ��� �޿����� ���� �޿��� �޴� �������� �̸�, �μ��� ���.
SELECT name, buseo FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa WHERE buseo = '�ѹ���');


-- 80. �ѹ��� �����麸�� �� ���� �޿��� �޴� ���� ����.
SELECT * FROM tblinsa WHERE basicpay > (SELECT min(basicpay) FROM tblinsa);


-- 81. ���� ��ü ��� �޿����� ���� �޿��� �޴� ������ �� ���.
SELECT count(*) FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa);


-- 82. 'ȫ�浿' ������ ���� �μ��� ���� ����.
SELECT * FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = 'ȫ�浿');


-- 83. '��ž�' ������ ���� �μ�, ������ ���� ���� ����
SELECT * FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = '��ž�') AND jikwi = (SELECT jikwi FROM tblinsa WHERE name = '��ž�');

            


-- 84. �μ��� �⺻���� ���� ���� ��� ���. (�μ�, �⺻��)     
SELECT buseo, max(basicpay) FROM tblinsa GROUP BY buseo;
       


-- 85. ���� �⺻�� ���� ���.
    -- ���� �⺻�� ���� ���.
SELECT a.*, rownum as ���� FROM (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC) a; 
SELECT b.*, rownum as ���� FROM (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '2' ORDER BY basicpay DESC) b; 
        
-- 86. ����(city)���� �޿�(�⺻��+����) 1���� ������ ���.
SELECT city, max(basicpay + sudang) FROM tblinsa GROUP BY city;


-- 87. �μ��� �ο����� ���� ���� �μ� �� �ο��� ���.
SELECT * FROM (SELECT buseo, count(*) FROM tblinsa GROUP BY buseo ORDER BY count(*) DESC) WHERE rownum = '1';

        
-- 88. ����(city)�� �ο����� ���� ���� ���� �� �ο��� ���.
SELECT * FROM (SELECT city, count(*) FROM tblinsa GROUP BY city ORDER BY count(*) DESC) WHERE rownum = '1';


-- 89. ����(city)�� ��� �޿�(basicpay+sudang)�� 
 --      ���� ���� ���� �� ��ձ޿� ���.
SELECT * FROM (SELECT city, round(avg(basicpay + sudang)) FROM tblinsa GROUP BY city ORDER BY round(avg(basicpay + sudang)) DESC) WHERE rownum = 1;


-- 90. ���� �ο����� ���� ���� �μ� �� �ο��� ���.
SELECT * FROM 
    (SELECT buseo, count(*) FROM tblinsa WHERE substr(ssn, 8, 1) = '2' GROUP BY BUSEO ORDER BY count(*) DESC)
        WHERE rownum = 1;


    
-- 91. ������ �ο��� ���� ���.
SELECT city, count, rownum as ���� FROM (SELECT city, count(*) as count FROM tblinsa a GROUP BY city ORDER BY count(*) DESC) ORDER BY rownum ASC;

                
-- 92. ������ �ο��� ���� ����ϵ� 5���������� ���.

SELECT * FROM (SELECT city, count(*) FROM tblinsa GROUP BY city ORDER BY count(*) DESC) WHERE rownum <= 5;

 
-- 93. �̸�, �μ�, ��ŵ�, �⺻��, ����, �⺻��+����, ����, �Ǽ��ɾ� ���
--        ����: �ѱ޿��� 250���� �̻��̸� 2%, 200���� �̻��̸� 1%, ������ 0.
--        �Ǽ��ɾ�: �ѱ޿�-����
--        CASE~END �� ���.
SELECT name, buseo, city, basicpay, sudang, basicpay + sudang, 
    CASE 
        WHEN basicpay + sudang >= 2500000 THEN (basicpay + sudang) * 0.02 
        WHEN basicpay + sudang >= 2000000 THEN (basicpay + sudang) * 0.01
        ELSE 0
    END as ����,
    basicpay + sudang - CASE 
                            WHEN basicpay + sudang >= 2500000 THEN (basicpay + sudang) * 0.02 
                            WHEN basicpay + sudang >= 2000000 THEN (basicpay + sudang) * 0.01
                            ELSE 0
                         END as �Ǽ��ɾ�
FROM tblinsa;

-- 94. �μ��� ��� �޿��� ����ϵ�, A, B, C ������� ������ ���.
-- 200���� �ʰ� - A���
-- 150~200���� - B���
-- 150���� �̸� - C���
SELECT buseo,
CASE
    WHEN round(avg(basicpay)) > 2000000 THEN 'A���'
    WHEN round(avg(basicpay)) >= 1500000 AND round(avg(basicpay)) <= 2000000 THEN 'B���'
    WHEN round(avg(basicpay)) < 1500000 THEN 'C���'
END
FROM tblinsa GROUP BY buseo;

 
-- 95. �⺻��+������ ���� ���� ����� �̸�, �⺻��+���� ���. 
-- MAX() �Լ�, ���� ���� �̿�.
SELECT * FROM (SELECT * FROM tblinsa ORDER BY basicpay + sudang DESC) WHERE rownum = 1;


-- 96. tblinsa. 80���� ���� �������� ��� ����(basicpay)���� �� ���� �޴� 70���� ���������� ���.
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '2' AND basicpay > (SELECT avg(basicpay) FROM tblinsa WHERE substr(ssn, 1, 1) = '8');


-- 97. tblStaff, tblProject. ���� �������� ��� ������ �̸�, �ּ�, ����, ���������Ʈ���� ���.
SELECT s.name, s.address, s.salary, p.name FROM tblStaff s INNER JOIN tblProject p ON s.seq = p.staff;

-- 98. tblVideo, tblRent, tblMember. '�ǻ��ұ��' ��� ������ ������ ȸ���� �̸�?
desc tblVideo;
desc tblRent;
desc tblMember;

SELECT name FROM tblMember WHERE seq = (SELECT member FROM tblRent WHERE video = (SELECT seq FROM tblVideo WHERE name = '�ǻ��ұ��'));

-- 99. tblinsa. ��� �̻��� ������ �޴� ������?
SELECT * FROM tblinsa WHERE basicpay >= (SELECT avg(basicpay) FROM tblinsa);

-- 100. tblStaff, tblProejct. '���������'�� ����� ������ ����?
SELECT SALARY FROM tblStaff WHERE seq = (SELECT staff FROM tblProject WHERE name = '���� ����');
SELECT salary FROM tblStaff s INNER JOIN tblProject p ON s.seq = p.staff WHERE p.name = '���� ����'; 
-- 101. tblMember. ���� ���̰� ���� ȸ���� �ּ�? (bYear)
desc tblMember;

SELECT address FROM (SELECT * FROM tblMember ORDER BY byear ASC) WHERE rownum = 1;

-- 102. tblvideo. '�й̳�����' ������ �ѹ��̶� �������� ȸ������ �̸�?
SELECT * FROM tblRent;
SELECt * FROM tblVideo;

SELECT * FROM tblMember 
    WHERE seq 
        in (SELECT member FROM tblRent r INNER JOIN tblVideo v ON r.video = v.seq WHERE  v.name = '�й̳�����'); 

SELECT * FROM tblMember 
    WHERE seq 
        in (SELECT member FROM tblRent WHERE video = (SELECT seq FROM tblVideo WHERE name = '�й̳�����')) 
            ORDER BY seq ASC;
            
-- 103. tblStaff, tblProject. ����ÿ� ��� ������ ������ ������ ��������
--     �̸�, ����, ���������Ʈ���� ����Ͻÿ�.
SELECT s.name, s.salary, p.name  
    FROM tblStaff s INNER JOIN tblProject p 
        ON s.seq = p.staff 
            WHERE s.address <> '�����'; 

-- 104. tblCustomer, tblSales. ��ǰ�� 2��(���ϻ�ǰ) �̻� ������ ȸ����
--    ����ó, �̸�, ���Ż�ǰ��, ���� ���
desc tblCustomer;
desc tblSales;
SELECT * FROM tblSales;

SELECT c.tel, c.name, s.item, s.qty 
    FROM tblSales s INNER JOIN tblCustomer c ON c.seq = s.customer 
        WHERE qty >= 2; 


-- 105. tblvideo. ��� ���� ����, ��������, �뿩������ ���
SELECT v.name, v.qty, g.price FROM tblvideo v INNER JOIN tblgenre g ON v.genre = g.seq;
SELECT * FROM tblgenre;

-- 106. tblvideo. 2007�� 2���� �뿩�� ���ų����� ����Ͻÿ�. ȸ����, ������, ����, �뿩����
SELECT m.name, v.name, r.rentdate, g.price FROM tblVideo v 
    INNER JOIN tblRent r ON v.seq = r.video 
        INNER JOIN tblgenre g ON v.GENRE = g.seq 
            INNER JOIN tblMember m ON m.seq = r.member
                WHERE r.RENTDATE like '2007-02%';

desc tblrent;
-- 107. tblvideo. ���� �ݳ��� ���� ȸ����� ������, �뿩��¥ ���.
SELECT m.name, v.name, r.rentdate FROM tblRent r INNER JOIN tblvideo v ON r.video = v.seq INNER JOIN tblmember m ON m.seq = r.member WHERE RETDATE is null;



-- 108. tblhousekeeping. ���� ����(���� * ����) �� ���� ���� �ݾ��� ������ ���� 3������ ���.
SELECT * FROM (SELECT * FROM tblhousekeeping ORDER BY price * qty DESC) WHERE rownum <= 3;


-- 109. tblinsa. ��� �޿� 2���� �μ��� ���� �������� ���
SELECT * FROM tblinsa 
    WHERE buseo = 
        (SELECT buseo 
            FROM (SELECT buseo, rownum as rnum FROM 
                    (SELECT buseo FROM tblinsa GROUP BY buseo ORDER BY avg(basicpay) DESC)) WHERE rnum = 2);


-- 110. tblinsa. �μ��� �ְ� ������ �޴� �������� ���(7��)
SELECT buseo, max(basicpay * 12) FROM tblinsa GROUP BY buseo ORDER BY max(basicpay * 12) DESC;


-- 111. tbltodo. ��� �� ���� ������ �Ϸ��� ������ ������� 5�� ���
SELECT * FROM (SELECT * FROM tbltodo ORDER BY completedate - adddate) WHERE rownum <= 5;


-- 112. tblinsa. ���� ���� �߿��� �޿��� 3��°�� ���� �޴� ������ 9��°�� ���� �޴� ������ �޿� ������ ��?

SELECT distinct

(SELECT basicpay 
    FROM 
    (SELECT basicpay, rownum as rnum 
        FROM 
            (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC)) 
                WHERE rnum = 3) -
(SELECT basicpay 
    FROM 
    (SELECT basicpay, rownum as rnum 
        FROM 
            (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC))
                WHERE rnum = 9) as ��
            
FROM (SELECT basicpay 
        FROM 
            (SELECT basicpay, rownum as rnum 
                FROM 
                    (SELECT * 
                        FROM tblinsa
                            WHERE substr(ssn, 8, 1) = '1' 
                                ORDER BY basicpay DESC)) 
                                    WHERE rnum = 3 or rnum = 9);



SELECT s.SUBJECT_SEQ as �����ȣ,
       bs.BASIC_SUBJECT_NAME as �����,
       s.SUBJECT_START_DATE as ���������,
       s.SUBJECT_END_DATE as ����������,
       bc.BASIC_COURSE_NAME as ������,
       c.COURSE_START_DATE as ����������,
       c.COURSE_END_DATE as ����������,
       bb.BASIC_BOOK_NAME as �����
  FROM tbl_subject s
    INNER JOIN tbl_course c
      ON s.COURSE_SEQ = c.COURSE_SEQ
        INNER JOIN TBL_BASIC_COURSE bc
          ON bc.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
            INNER JOIN TBL_BASIC_SUBJECT bs
              ON bs.BASIC_SUBJECT_SEQ = s.BASIC_SUBJECT_SEQ
                INNER JOIN TBL_BASIC_BOOK bb
                  ON bb.BASIC_BOOK_seq = s.BASIC_BOOK
                    INNER JOIN TBL_STUDENT_ENROLLMENT se
                      ON se.COURSE_SEQ = c.COURSE_SEQ
                        WHERE s.DETAIL_TEACHER_SEQ = 1;



