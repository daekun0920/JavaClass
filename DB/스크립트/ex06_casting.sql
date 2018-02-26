/* 
ex06_casting.sql

����ȯ �Լ� 

1. to_char() : ���� -> ����

2. to_char() : ��¥ -> ���� *****

3. to_number() : ���� -> ���� 

4. to_date() : ���� -> ��¥ *****


1. ���� -> ���� 
- char to_char(�÷���, ���Ĺ��ڿ�)

���Ĺ��ڿ� ���� ���
- �Ʒ��� ��� �̿ܿ��� ���� ���ڿ��� ���Ե� �� ����.(***)
a. 9 : ���� 1�ڸ��� ���� 1���� �ٲٴ� ����(���ڶ� �ڸ��� �������� ä���) + �Ǿտ� ���� 1�� �߰�(��ȣ)
b. 0 : ���� 1�ڸ��� ���� 1���� �ٲٴ� ����(���ڶ� �ڸ��� 0���� ä���)
c. $ : �޷� ǥ�ÿ�
d. L : Locale(���� ��ȭ ǥ��)
e. . : �Ҽ��� ǥ�ÿ�
f. , : õ(1000) ���� ǥ��
*/
SELECT 100, '100' FROM dual;

SELECT to_char(100, '999') FROM dual; -- 100 -> '100' ���� -> ���ڿ��� ��ȯ (�տ� �� ���ڸ��� ��ȣ��Ʈ (+, -) �� ���ڸ�. �÷����� �Ⱥ��̴°ͻ�)
SELECT to_char(100, '000') FROM dual; -- 100 -> '100' ���� -> ���ڿ��� ��ȯ

SELECT to_char(10, '999') FROM dual; -- 10 -> ' 10' ���� -> ���ڿ��� ��ȯ
SELECT to_char(10, '000') FROM dual; -- 10 -> '010' ���� -> ���ڿ��� ��ȯ

SELECT '@' || to_char(1, '999') || '@' FROM dual; -- 1 -> '  1' 
SELECT '@' || to_char(1, '000') || '@' FROM dual; -- 1 -> '001' (�տ� �� ���ڸ��� ��ȣ��Ʈ (+, -) �� ���ڸ�. �÷����� �Ⱥ��̴°ͻ�)

SELECT to_char(1000, '999') FROM dual; -- #### - X

-- 100��
SELECT to_char(100, '$999') FROM dual; -- O
SELECT to_char(100, '999��') FROM dual; -- X
SELECT to_char(100, 'L999') FROM dual; -- O ������ �´� ��ȭ ǥ��
SELECT to_char(100, '999') || '��' FROM dual;

SELECT to_char(123.456, '999.999') FROM dual;
SELECT to_char(123.456, '999.99') FROM dual; -- �ݿø� + ���ڿ� ��ȯ 
SELECT to_char(123.456, '999.9') FROM dual;

SELECT to_char(1000000, '9,999,999') FROM dual;
SELECT to_char(1000000, '999,9999') FROM dual;
SELECT to_char(1000000, '9,9,9,9,9,9,9') FROM dual;

/*

2. ��¥ -> ����
-varchar2 to_char(�÷���, '���Ĺ��ڿ�')

���� ���ڿ��� ���� ���
- YYYY
- yy
- month 
- mon
- mm
- day
- dy 
- ddd, dd, d
- hh(hh12), hh24
- mi
- ss
- am(pm)

*/

SELECT sysdate FROM dual;
SELECT to_char(sysdate, 'YYYY') FROM dual;  -- 2018 �� (4�ڸ�)
SELECT to_char(sysdate, 'yy') FROM dual;    -- 18 �� (2�ڸ�)
SELECT to_char(sysdate, 'month') FROM dual; -- 1��, ������(Ǯ����(January, ������ ���� ǥ�� �ٸ�) 
SELECT to_char(sysdate, 'mon') FROM dual;   -- 1��, ������(���(JAN)
SELECT to_char(sysdate, 'mm') FROM dual;    -- 01, 2�ڸ� ����(****************)
SELECT to_char(sysdate, 'day') FROM dual;   -- ȭ����, ������(Ǯ����)
SELECT to_char(sysdate, 'dy') FROM dual;    -- ȭ, ������(���)
SELECT to_char(sysdate, 'ddd') FROM dual;   -- 016, ��¥(���� : 1�� 1��, ���ص� ����°����)
SELECT to_char(sysdate, 'dd') FROM dual;    -- 16, ��¥(���� : �ش� ������ ������ �귶����)
SELECT to_char(sysdate, 'd') FROM dual;     -- 3, ��¥ (���� : �̹��ָ� ��������(����))
SELECT to_char(sysdate, 'hh') FROM dual;    -- 02, 12�ð� ü�� ��
SELECT to_char(sysdate, 'hh24') FROM dual;  -- 14, 24�ð� ü�� �� 
SELECT to_char(sysdate, 'mi') FROM dual;    -- ��
SELECT to_char(sysdate, 'ss') FROM dual;    -- ��
SELECT to_char(sysdate, 'am') FROM dual;    -- ����
SELECT to_char(sysdate, 'pm') FROM dual;    -- ����

SELECT to_char(sysdate, 'yyyy-mm-dd') FROM dual;
SELECT to_char(sysdate, 'yyyy��mm��dd��') FROM dual; -- X 

SELECT to_char(sysdate, 'hh24:mi:ss') FROM dual;  -- 14:47:24
SELECT to_char(sysdate, 'am hh-mi-ss') FROM dual; -- ���� 02-47-24

-- �������� ���
-- date���� ���ڿ� �Լ��� ������� ����!!!
-- date�� -> ���ڿ��� ����ȯ -> ���ڿ� �Լ� ��� 

-- 12���� �Ի��� ����?
SELECT name, ibsadate, substr(ibsadate, 1) -- X
    FROM tblinsa;
       
SELECT name, ibsadate, to_char(ibsadate, 'mm')
    FROM tblinsa
        WHERE to_char(ibsadate, 'mm') = '12';
        
        
SELECT * 
    FROM tbltodo
        -- WHERE to_char(adddate, 'am') = '����';
        WHERE to_char(adddate, 'd') = 7; -- ����� ����� ����


-- 97 ~ 99�� ���̿� �Ի��� ���
SELECT * FROM tblinsa
    -- WHERE ibsadate BETWEEN '1997-01-01' AND '2000-01-01';
    WHERE to_char(ibsadate, 'yyyy') BETWEEN 1997 AND 1999; -- O 


-- ���� 
SELECT * FROM tblinsa
    -- ORDER BY ibsadate DESC;
    ORDER BY to_char(ibsadate, 'mm') ASC, to_char(ibsadate, 'yyyy') ASC,
             to_char(ibsadate, 'dd') ASC, num ASC;



/*

3. ���� -> ����
- number to_number(���ڿ�)
- Integer.parseInt(���ڿ�)


*/

SELECT to_number('123') FROM dual;
SELECT '123' * 2 FROM dual; -- �ڵ� ����ȯ�� �����ؼ� �� ����� ���� ����.



/*

4. ���� -> ��¥ (***)
- date to_date(�÷���, '���Ĺ��ڿ�')
- 2������ ����� ���� ���ڿ��� ���� 

*/

SELECT '2018-01-16', sysdate FROM dual; -- '2018-01-16' : ���ڿ�
SELECT * FROM tblinsa WHERE ibsadate < '2018-01-16'; -- '2018-01-16' : date(�ڵ� ����ȯ) 

-- ���� ���ڿ� ����� ��� -> ���� ������ ������ �״�� ǥ��(�����ϱ�)
SELECT to_date('2018-01-16', 'YYYY-MM-DD'), sysdate FROM dual;
SELECT to_date('2018.01.16', 'YYYY.MM.DD'), sysdate FROM dual;
SELECT to_date('20180116', 'YYYYMMDD'), sysdate FROM dual;

SELECT to_date('2018-01-16 17:56:22', 'yyyy-mm-dd hh24:mi:ss'), sysdate FROM dual; -- �����ϰ� ��,��,�� ����� ��¥Ÿ�� ����� �ٲٴ� ��


















