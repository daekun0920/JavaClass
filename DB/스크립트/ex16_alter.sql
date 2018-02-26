/*

ex16_ALTER.sql

���̺� ���� - CREATE
���̺� ���� - DROP
���̺� ���� - ALTER

���̺� �����ϱ�
1. ���̺� ���� -> ���̺� (����) ���� -> ������ ����(INSERT) // ������Ʈ �ʱ�ܰ� 
2. ALTER ��ɾ� -> ������ ���� + ������ ����  // ������Ʈ ���Ĺ� �ܰ� : ALTER ��ɾ�� �ǵ��� ����� ��Ȳ�� �� ����°�...

���̺� ���� �۾�
1. ���ο� �÷� �߰��ϱ� - ���̵� �� 
2. ���� �÷� �����ϱ� 
3. ���� �÷� �����ϱ� 


*/

CREATE TABLE tbledit
(
    seq NUMBER NOT NULL,
    data VARCHAR2(10) NOT NULL
);

INSERT INTO tbledit VALUES(1, 'Ű����');
INSERT INTO tbledit VALUES(2, '���콺');

-- 1. ���ο� �÷� �߰��ϱ� (NOT NULL�� �ȵ�)
ALTER TABLE tbledit
    ADD (price number(5) NULL);

ALTER TABLE tbledit
    ADD (regdate DATE NULL);

ALTER TABLE tbledit      -- ORA-01758: table must be empty to add mandatory (NOT NULL) column
    ADD (qty NUMBER(1) NOT NULL);

-- �� NN ������ �ɸ� �÷��� ���� �߰��ؾ��ϴ� ���? 1
-- 1.
ALTER TABLE tbledit 
    ADD (qty NUMBER(1) NULL);
-- 2.
UPDATE tbledit SET qty = 1;

-- 3.
ALTER TABLE tbledit
    MODIFY (qty NUMBER(1) NOT NULL);

-- �� NN ������ �ɸ� �÷��� ���� �߰��ؾ��ϴ� ���? 2
ALTER TABLE tbledit
    ADD (color VARCHAR2(30) DEFAULT '����' NOT NULL); -- ��� ���� ���ڵ��� ���÷��� DEFAULT�� ����ȴ�.


INSERT INTO tbledit VALUES (3, '�����', NULL, NULL, NULL); -- ORA-01400: cannot insert NULL into ("HR"."TBLEDIT"."QTY")

SELECT * FROM tbledit;



-- 2. ���� �÷� �����ϱ� 
-- : �÷� ���� + ������ ���� 
ALTER TABLE tbledit
    DROP COLUMN qty;

ALTER TABLE tbledit
    DROP COLUMN regdate;



SELECT * FROM tbledit;

-- 3. ���� �÷� �����ϱ�
-- : �ڷ���(Ÿ��, ����), �������(NOT NULL ��...) ���� �ٲٱ�
INSERT INTO tbledit VALUES (3, '�����', 1000, '����');
INSERT INTO tbledit VALUES (4, '�޸�', 2000, '���');

SELECT * FROM tbledit;

-- ���� �÷� ���̴� ���� ����־�� ������ �����ϴ�.
ALTER TABLE tbledit
    MODIFY (price NUMBER (4));
    
-- NN �����ϱ�
ALTER TABLE tbledit
    MODIFY (price NUMBER (4) NULL);

ALTER TABLE tbledit
    MODIFY (price NUMBER (4) NOT NULL); -- ���� : ���� ������ ���� �ִٰ� ���� 

ALTER TABLE tbledit 
    MODIFY (color VARCHAR2(30) DEFAULT '����' 
                CHECK (color IN ('����', '����', '���', '����', '�Ķ�')));


ALTER TABLE tbl_subject RENAME COLUMN basic_book TO basic_book_seq;
ALTER TABLE tbl_subject RENAME COLUMN detail_teacher TO detail_teacher_seq;

ALTER TABLE tbl_student_quit RENAME COLUMN student_enrollment TO student_enrollment_seq;


CREATE TABLE tbledit
(
    seq NUMBER NOT NULL,
    data VARCHAR2(10) NOT NULL
);

-- ���� ���� �߰��ϱ� 
-- : NOT NULL ������ ������ ������ ���� ���� �߰��ϱ� 
ALTER TABLE tbledit
    ADD CONSTRAINT tbledit_seq_pk PRIMARY KEY (seq);

ALTER TABLE tbledit
    DROP CONSTRAINT tbledit_seq_pk;
    
ALTER TABLE tbledit 
    DROP CONSTRAINT SYS_C007309;
    


/*

���̺��� ��� ���� �����ϱ� 
- ���̺� �ʱ�ȭ(������ �״�� �ΰ� �����͸� �ʱ�ȭ)
- ���� -> �׽�Ʈ -> �Ϸ� -> �ʱ�ȭ 

1. DROP -> CREATE 
- ��� 
- ��� �� ����
- �ǵ����� �Ұ���(���� �Ұ���)

2. DELETE
- ����
- ��� �� OR �Ϻ� ��(���ڵ�)
- �ǵ����� ����(���� ����)

3. TRUNCATE ��ɾ�(���� �Լ� TRUNC�Լ��� �ٸ� ��ɾ�) 
- ����
- ���̺��� ��� ���� �����ϴ� ��ɾ�(DELETE ���������� ����ϴ� �Ͱ� ����)
- �ǵ����� �Ұ���(���� �Ұ���)

*/

TRUNCATE TABLE tbledit; -- ���� �Ұ���
DELETE FROM tbledit; -- ���� ����

SELECT * FROM tbledit;

CREATE TABLE ������
AS
SELECT * FROM tblinsa WHERE BUSEO = '������';

SELECT * FROM ������;

COMMIT;
ROLLBACK;

DELETE FROM ������;
TRUNCATE TABLE ������;












