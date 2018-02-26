/*
ex19_index.sql

�ε���, Index
- ����
- �÷������� ���δ�
- �˻�(SELECT)�� ���� �ӵ��� �ϱ� ���ؼ� ����ϴ� ����
- �ϳ��� ���̺� ������ ���� ���� -> �ʹݿ� �ִ� �����ʹ� ���� �ӵ� ����, �Ĺݿ� �ִ� �����ʹ� ���� �ӵ� ���� 
- -> ���� �˻��Ǵ� ��� �÷� -> �ε��� ���� -> ������ ���� : ǥ ��� X, �ε��� ��� O -> ���ϴ� ���ڵ��� ���� �ӵ� ��� 

- ����Ŭ�� ���̺� ���� �� �ε����� ��������� �������� �ʾƵ� �ڵ����� �����ȴ�. -> PK, UNIQUE ������ ���� �÷��� �ڵ����� �ε����� ���������.
- -> PK, UNIQUE �÷����� WHERE���� ���� Ȯ���� ���Ƽ�...

*/

CREATE TABLE tblIndex
AS
SELECT * FROM tblinsa;

INSERT INTO tblIndex
    SELECT * FROM tblIndex;

-- �� 8�鸸�� ������
SELECT count(*) FROM tblIndex;

-- ���� tblIndex ���̺��� ���� ������ �ƹ��͵� ���� ���� 

-- �ε��� ó���� �ȵ� ���¿����� �˻�
SELECT distinct name FROM tblIndex
    WHERE name = 'ȫ�浿'; -- 4.339�� 

-- �ε��� ����
CREATE INDEX idx_tblindex_name
    ON tblindex(name);
    
-- �ε����� ���� �÷��� �������� �ٽ� �˻�
SELECT distinct name FROM tblindex
    WHERE name = 'ȫ�浿'; -- 0.009


/*

�ε��� ���� / ����
- �˻� ó�� �ӵ��� ��� ��Ų��.
- �������� ��� �ʹ� ���� �߻� 

�ε��� ����ؾ� �ϴ� ���
1. ���̺� ���� ������ ���� ��� 
2. �ε����� ������ �÷��� WHERE���� ���� ���Ǵ� ���(************) 
3. JOIN�� ���Ǵ� �÷�(ON �θ����̺�.PK = �ڽ����̺�.FK)
4. �˻� ����� ���� ���̺� �������� 2 ~ 4%�� �ش��ϴ� ��� 
5. �ش� �÷��� NULL�� �����ϴ� ���(���ο� NULL�� ������)

�ε��� ����ϸ� ������ ���
1. ���̺� ���� ������ ���� ���
2. �˻� ����� ���� ����... (�˻�������� �������� ������ ȿ�� �϶�)
3. ���� ���̺��� ����, ����, ������ ����� ���...(********)(���� X)


�ε����� ����
1. ����� �ε���
2. ���� �ε���
3. ���� �ε���
4. ���� �ε���

*/

-- 1. ����� �ε���
-- : ������ ���� �ߺ� �����ϴ�.
CREATE INDEX idx_tblindex_buseo
    ON tblindex(buseo);

-- 2. ���� �ε��� (�ߺ����� ���� �÷� ��) PK)
-- : ������ ���� �ߺ� �Ұ����ϴ�. �����ϴ�.
CREATE UNIQUE INDEX idx_tblinsa_name
    ON tblinsa(name);

-- 3. ���� �ε���
-- : 1���� �÷��� ������� �ε��� ����
CREATE INDEX idx_tblindex_buseo
    ON tblindex(buseo);
CREATE INDEX idx_tblindex_buseo
    ON tblindex(name); -- **

SELECT * FROM tblinsa WHERE name = 'ȫ�浿'; -- idx_tblinsa_name ����
SELECT * FROM tblinsa WHERE name = 'ȫ�浿' AND jikwi = '����'; -- idx_tblinsa_name �̵��� 
SELECT * FROM tblinsa WHERE substr(name, 1, 1) = 'ȫ'; -- idx_tblinsa_name �̵��� 

-- 4. ���� �ε���
-- : 2�� �̻��� �÷��� ������� �ε��� ����
CREATE INDEX idx_tblinsa_name_jikwi
    ON tblinsa(name, jikwi); -- WHERE name = 'ȫ�浿 AND jikwi = '����';
    
    
-- 
CREATE INDEX idx_tblinsa_lastname
    ON tblinsa(substr(name, 1, 1)); -- WHERE substr(name, 1, 1) = 'ȫ';

CREATE INDEX idx_tblinsa_salary
    ON tblinsa(basicpay + sudang); --WHERE basicpay + sudang > 1500000



-- ����Ŭ(DBMS)�� Ű����� ��/�ҹ��ڸ� �������� �ʴ´�.(SQL Ư¡)
-- �������� ��/�ҹ��ڴ� �����Ѵ�.
-- ����Ŭ�� DDL�� ����ؼ� ������ ��� �ĺ��ڸ� �빮�ڷ� ��ȯ���Ѽ� �����Ѵ�.
-- ����Ŭ���� SQL �ۼ� �� �ĺ��ڸ� �빮�ڷ� �����..

SELECT * FROM user_tab_columns; -- �ý��� ���̺�

SELECT * FROM user_tab_columns 
    WHERE table_name = 'tblname';

SELECT * FROM user_tab_columns 
    WHERE table_name = 'TBLNAME';

SELECT * FROM tblname;











