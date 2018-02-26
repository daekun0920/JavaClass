/*

ex09_insert.sql


DML : select, insert, update, delete

INSERT ��
- INSERT INTO ���̺�� (�÷�����Ʈ) VALUES (�� ����Ʈ)

*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER PRIMARY KEY, -- �޸��ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- �۾���
    memo VARCHAR2(1000) NOT NULL, -- �޸�
    regdate date DEFAULT sysdate NOT NULL, -- ��¥
    etc VARCHAR2(500) DEFAULT '��� ����' NULL, -- ���
    page NUMBER NULL -- ������ ��
); 

SELECT memoseq.nextval FROM dual;
SELECT memoseq.currval FROM dual; -- �ϵ��ũ�� �ƴ� CACHE(�޸�)�� �ִ� ��ȣ�� �������� ��ɾ� -> ���α׷� ������ ������ CACHE�� ����� -> �۵� �ȵ� -> nextval �� CACHE�� �� �ٽ� �������� �۵� ��


-- INSERT���� ����

-- 1. ǥ�� : ���� ���̺��� ���� �÷� ������� �÷�����Ʈ�� ������Ʈ�� ǥ��
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);

-- �÷� ����Ʈ�� ������ �� ����Ʈ�� ������ �ݵ�� ����     
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', '���', sysdate, 1); -- ORA-01841: (full) year must be between -4713 and +9999, and not be 0

INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���');    -- ORA-00947: not enough values

INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1); -- ORA-00913: too many values


-- 2. �÷�(��)�� ���� �ٲٱ�
-- �÷�����Ʈ�� ������Ʈ�� ������ �ݵ�� ���� ���̺��� ���ǿ� ��ġ�� �ʿ䰡 ����.
INSERT INTO tblmemo(name, memo, regdate, etc, page, seq)
    VALUES ('ȫ�浿', '�޸�', sysdate, '���', 1, memoseq.nextval);


-- 3. NULL ������ ���� �÷��� �Է��ϱ� 
-- Ư�� �÷��� NULL�� �����ϰ� �ʹ�.

-- 3.a ��� �÷��� ���� �����ϸ� �ȴ�.
INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���');

INSERT INTO tblmemo(seq, name, memo, regdate) -- DEFAULT�� ���ؼ� �÷��� �� ������ NULL�� �ƴ� ���̺� ������ �Է��� DEFAULT�� '��� ����'�� �Էµȴ�.
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate);

-- 3.b ��������� NULL�� ���� -> NULL ����� ����Ѵ�.
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', NULL);
    
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, NULL, NULL); -- DEFAULT�� ��� ������ NULL ���� ���


SELECT * FROM tblmemo;


-- 4. DEFAULT �� �Է�

-- 4.a DEFAULT�� ���ǵǾ� �־ ���� ���� �Է��ϴ� ��� > DEFAULT�� �ƴ� ����ڰ� ���� �Է��� ���� ���� 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);

-- 4.b DEFAULT �÷��� ����> DEFAULT ���� ���� 
INSERT INTO tblmemo(seq, name, memo, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', 1);

-- 4.c DEFAULT + NULL ����� �÷� ���� NULL ����� �Է��ϸ� DEFAULT ���� ����.
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, NULL, 1);

-- 4.d ��������� DEFAULT �� ���� 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', DEFAULT, DEFAULT, 1);

SELECT * FROM tblmemo;


-- 5. �÷� ����Ʈ ����
INSERT INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);

-- 5.a �ݵ�� ���̺��� ������� ����� �÷�������� ������Ʈ�� ����� �Ѵ�.
INSERT INTO tblmemo VALUES ('ȫ�浿', '�޸�', sysdate, '���', 1, memoseq.nextval); -- ORA-01722: invalid number

-- 5.b  DEFAULT ó���� ���� �� ������ �Ұ����ϴ�.
INSERT INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', 1); -- ORA-00947: not enough values

-- 5.c DEFAULT ����ϰ� ������ ������ �Ұ��� ������ DEFAULT ����� �����ϴ�. *****
INSERT INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', DEFAULT, DEFAULT, 1);


------------------------------------------------------- �Ϲ����� INSERT~


SELECT * FROM tblmemo;

CREATE TABLE tblmemobackup
(
    seq NUMBER PRIMARY KEY, -- �޸��ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- �۾���
    memo VARCHAR2(1000) NOT NULL, -- �޸�
    regdate date DEFAULT sysdate NOT NULL, -- ��¥
    etc VARCHAR2(500) DEFAULT '��� ����' NULL, -- ���
    page NUMBER NULL -- ������ ��
); 

-- tblmemo -> (����) -> tblmemobackup
INSERT INTO tblmemobackup 
    SELECT * FROM tblmemo; -- ���� ���� 

INSERT INTO tblmemobackup 
    SELECT * FROM tblmemo WHERE page = 1; -- page�� 1�� �׸��

SELECT * FROM tblmemobackup;


-- tblmemo ���� page�� 1�� �׸�鸸 ������ ������ ���̺� ����~~~
CREATE TABLE tblmemoonepage
AS
SELECT * FROM tblmemo WHERE page = 1;

SELECT * FROM tblmemoonepage;

--
SELECT * FROM tblinsa;

-- ������ ���̺�
CREATE TABLE ������ 
AS
SELECT * FROM tblinsa WHERE buseo = '������';

SELECT * FROM ������;


/*
1. ���� ���̺� A -> (������ ����) -> ���� ���̺� B
- insert + select
- ������ O, ������ �׽�Ʈ�� O

2. ���� ���̺� A -> (���̺� ���� + ������ ����) -> ���� ���̺� B
- CREATE + SELECT
- ������ X, ������ �׽�Ʈ�� O
- ���̺��� ������ �� �����ʹ� ���簡 �Ǵµ�... ��������� ���簡 �ȵȴ�.

*/
















