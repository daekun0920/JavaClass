/*

ex07_ddl.sql

DML
    - ������ ���۾� (SELECT, INSERT, UPDATE, DELETE)
    - SELECT : DQL(Data Query Language, ������ ���� ���) 
    
DDL
    - ������ ���Ǿ�
    - DB Object(���̺�, ��, ���ν���, �ε���, Ʈ���� ��...) ����/�����ϴ� ��ɾ� 
    - CREATE : �����
    - DROP : ����
    - ALTER : ����(�κ���, �Ǵ¾ְ� �ְ� �ȵǴ� �ְ� �ִ�)

���̺� �����ϱ�

CREATE TABLE ���̺��
(

    �÷� ����, 
    �÷� ����, 
    �÷� ����, 
    �÷� ����, 
    �÷� ����, 
    �÷� ����, 
    ex) �÷��� �ڷ���(����) �������

);

*/

CREATE TABLE tbltest
(

    num number(3), 
    txt varchar2(10),
    regdate date
    
);

SELECT * FROM tbltest;

INSERT INTO tbltest(num, txt, regdate) VALUES (100, 'test', '2018-01-16');

/*

���� ����, Constraint
- �÷����� ���� ����(��Ģ) -> ���� ���ϸ� �����͸� �� �ִ´�. -> ������ ��ȿ�� ����
- �����ͺ��̽� ���Ἲ ����(Integerity Contstraint Rule - ���Ἲ ���� ����)

1. NOT NULL
- �ݵ�� �÷����� ����(�ʼ� �Է°�)
- �÷� �����θ� ���� ����
*/

-- �޸� ���̺�
CREATE TABLE tblmemo
(

    seq NUMBER NULL, -- �Ϸù�ȣ + �ʼ��Է�(���� �Ұ���) 
    name VARCHAR2(20) NULL, -- �۾��� 
    memo VARCHAR2(1000) NULL, -- �޸𳻿�
    regdate DATE NULL -- �ۼ� �ð� 
    
);

SELECT * FROM tblmemo;

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�', NULL);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (3, 'ȫ�浿', NULL, NULL);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (4, NULL, NULL, NULL);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (NULL, NULL, NULL, NULL); -- �̷� �ൿ�� �� Ȯ�� 0.0000000000001%


DROP TABLE tblmemo;

CREATE TABLE tblmemo
(

    seq NUMBER NOT NULL, -- �Ϸù�ȣ + �ʼ��Է�(���� �Ұ���) 
    name VARCHAR2(20) NULL, -- �۾��� 
    memo VARCHAR2(1000) NOT NULL, -- �޸𳻿�
    regdate DATE NULL -- �ۼ� �ð� 
    
);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�', NULL);

INSERT INTO tblmemo(seq, name, memo, regdate) -- ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
    VALUES (3, 'ȫ�浿', NULL, NULL);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (3, NULL, '�޸��Դϴ�', NULL);

INSERT INTO tblmemo(seq, name, memo, regdate) -- ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ")
    VALUES (NULL, NULL, '�޸��Դϴ�', NULL);



/*

1. NOT NULL

2. PRIMARY KEY(PK)
- �⺻ Ű
- Ű(key) : �÷�
- ���̺��� ��� �÷����� ��ǥ(?)�ϴ� �÷� -> ��� ���� �����ϴ� �������� ���(������)
- �����ϰ� �ߺ����� ������ ���� �÷� 
- ���̺����� ���� �����ϱ� ���� ���� �ĺ���(PK �÷��� ���� ���̺��� �����ؾ� �Ѵ�.)
- 1���� ���̺��� �ݵ��(***) PK�� �����ؾ� �Ѵ�.
    a. ��� ���� �����ϱ� ���ؼ�...
    b. PK�� 1�� �̻� ���� ����(2�� �̻� PK -> �⺻Ű ���� -> ����Ű(Composite Key)

- PK�� �ڵ����� NOT NULL�� ����ȴ�.
- PK�� �ڵ����� NOT Duplicate �� ����ȴ�. -> UNIQUE
- NOT NULL + UNIQUE = PK

*/

SELECT * FROM tblcountry;

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(

    seq NUMBER PRIMARY KEY, -- �ߺ�X, ����X, ���̺��� ������ �ĺ��� �÷� -> PK
    name VARCHAR2(20) NULL, 
    memo VARCHAR2(1000) NOT NULL, 
    regdate DATE NULL 
    
);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) -- ORA-00001: unique constraint (HR.SYS_C007106) violated
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (NULL, 'ȫ�浿', '�޸��Դϴ�', sysdate);


-- Ư�� ��(���ڵ�) 1���� ������ ���� �ݵ�� PK�� �������� �Ǵ�.
SELECT * FROM tblmemo
    WHERE seq = 1; -- ���� ���ϴ� �޸� 1�� ����
    
    
/*

3. UNIQUE
- �ش� �÷����� ���̺����� ������ �� �̾�� �Ѵ�.(�ߺ����� �־�� �ȵȴ�)
- NULL�� ���� �� �ִ�.
- �ĺ��ڷ� ����ϸ� ���� �ȵ�!!!!!!!!(NULL�� �ֱ⶧����)

*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(

    seq NUMBER PRIMARY KEY,   -- �ߺ�X, ����X, ���̺��� ������ �ĺ��� �÷� -> PK
    name VARCHAR2(20) UNIQUE, -- �ѻ���� 1�� �޸� �ۼ������ϰԵ�  
    memo VARCHAR2(1000) NOT NULL, 
    regdate DATE NULL 
    
);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (2, '�ƹ���', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) -- ORA-00001: unique constraint (HR.SYS_C007109) violated
    VALUES (3, 'ȫ�浿', '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (4, NULL, '�޸��Դϴ�', sysdate);
    
INSERT INTO tblmemo(seq, name, memo, regdate) -- NULL�� �ߺ��� ���࿡ �ɸ��� �ʴ´�.
    VALUES (5, NULL, '�޸��Դϴ�', sysdate);
    
SELECT * FROM tblmemo;

/*
4. check
- ������, ���� �񱳵��� ���� 
- WHERE�� ����
*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER PRIMARY KEY,   -- �ߺ�X, ����X, ���̺��� ������ �ĺ��� �÷� -> PK
    name VARCHAR2(20) UNIQUE, -- �ѻ���� 1�� �޸� �ۼ������ϰԵ�  
    memo VARCHAR2(1000) NOT NULL, 
    --regdate DATE NULL,
    -- color VARCHAR2(20) NOT NULL, -- red, yellow, blue
    -- page NUMBER(1) NOT NULL      -- 1 ~ 9
    color VARCHAR2(20) CHECK (color IN('red', 'yellow', 'blue')) NOT NULL,
    -- page NUMBER(1) CHECK (page >= 1 and page <= 9) NOT NULL
    page NUMBER(1) CHECK (page BETWEEN 1 and 9) NOT NULL,
    
    -- ��¥ �Ⱓ ���� 
    -- regdate date CHECK (regdate BETWEEN '2018-01-15' AND '2018-01-31') NOT NULL 
    -- regdate date CHECK (regdate BETWEEN to_date('2018-01-15', 'yyyy-mm-dd') AND to_date('2018-01-31', 'yyyy-mm-dd')) NOT NULL 
    
    -- �������� ����
    -- regdate date CHECK (to_char(regdate, 'hh24') BETWEEN 0 AND 11) NOT NULL
    
    -- ��, �Ͽ��Ͽ��� ����
    regdate date CHECK (to_char(regdate, 'd') IN (1, 7) AND to_char(regdate, 'hh24') BETWEEN 0 AND 11)   NOT NULL
);

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate, 'blue', 1);

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (2, '�ƹ���', '�޸��Դϴ�', sysdate, 'white', 1); -- ORA-02290: check constraint (HR.SYS_C007118) violated

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (3, '������', '�޸��Դϴ�', sysdate, 'blue', 1); -- ORA-02290: check constraint (HR.SYS_C007119) violated


INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate, 'blue', 1);

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (2, '�ƹ���', '�޸��Դϴ�', to_date('2018-01-10 10:05:50', 'yyyy-mm-dd hh24:mi:ss'), 'blue', 1); -- ORA-02290: check constraint (HR.SYS_C007128) violated


INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate, 'blue', 1);

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�', to_date('2018-01-17 15:05:50', 'yyyy-mm-dd hh24:mi:ss'), 'blue', 1); -- ORA-00933: SQL command not properly ended (regdate)

INSERT INTO tblmemo(seq, name, memo, regdate, color, page) 
    VALUES (3, '�ƹ���', '�޸��Դϴ�', to_date('2018-01-20 10:05:50', 'yyyy-mm-dd hh24:mi:ss'), 'blue', 1);


/*

5. default
- �÷� �⺻��
- �ش� �÷��� ���� ���� ������ NULL�� �Է����� ����, �ڵ����� �̸� �غ�� ���� �־��

*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER PRIMARY KEY,   
    name VARCHAR2(20) DEFAULT '�͸�' NULL,  
    memo VARCHAR2(1000) NOT NULL, 
    regdate DATE DEFAULT sysdate NULL
);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�', sysdate);

INSERT INTO tblmemo(seq, name, memo, regdate) 
    VALUES (2, NULL, '�޸��Դϴ�', sysdate);

INSERT INTO tblmemo(seq, memo) -- �̸�, ��¥ ���� 
    VALUES (3, '�޸��Դϴ�');



SELECT * FROM tblmemo;


/*

���� ������ ����� ���

1. �÷� ���ؿ��� ����� ���
    - �÷��� ���� ���� �Ŵ� ���(1 : 1)
    - �÷��� �ڷ��� ��������
    - �÷��� �ڷ��� constraint ����� �������� 
    
2. ���̺� ���ؿ��� ����� ���
    
   
   
        
*/



DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    -- seq NUMBER PRIMARY KEY
    -- seq NUMBER CONSTRAINT aaa PRIMARY KEY,
    seq NUMBER CONSTRAINT tblmemo_seq_pk PRIMARY KEY,
    memo VARCHAR2(1000) CONSTRAINT tblmemo_memo_ck CHECK (length(memo) >= 20) NOT NULL
    
);

INSERT INTO tblmemo(seq, memo) VALUES(1, '�޸��Դϴ�.'); -- ORA-02290: check constraint (HR.TBLMEMO_MEMO_CK) violated
INSERT INTO tblmemo(seq, memo) VALUES(1, '�޸��Դϴ�.'); -- ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated


CREATE TABLE tblmemo
(
    seq number,
    memo VARCHAR2(1000) NOT NULL, -- NOT NULL�� �÷� ���ؿ����� ���� ���� (CONSTRAINT�� ����)
    color VARCHAR2(20),
    page number(1),

    CONSTRAINT tblmemo_seq_pk PRIMARY KEY(seq), -- ���̺� ������ ����
    CONSTRAINT tblmemo_color_ck CHECK (color in('white', 'black')),
    CONSTRAINT tblmemo_page_ck CHECK (page BETWEEN 1 AND 9)
);

INSERT INTO tblmemo(seq, memo) VALUES (1, '�޸��Դϴ�.');

INSERT INTO tblmemo(seq, memo, color, page) VALUES (1, '�޸��Դϴ�.', 'white', 1);

INSERT INTO tblmemo(seq, memo, color, page) VALUES (2, '�޸��Դϴ�.', 'blue', 1); -- ORA-02290: check constraint (HR.TBLMEMO_COLOR_CK) violated

INSERT INTO tblmemo(seq, memo, color, page) VALUES (3, '�޸��Դϴ�.', 'black', -1); -- ORA-02290: check constraint (HR.TBLMEMO_PAGE_CK) violated

























