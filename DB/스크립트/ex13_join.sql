/*

ex13_join.sql

-- ���� ���� + ������ ����ϴ� ������Ʈ ���� 
-- ���� ���̺�, ������Ʈ ���̺�

*/
DROP TABLE tblstaff;
CREATE TABLE tblstaff
(
    seq number PRIMARY KEY, -- ���� ��ȣ(PK)
    name varchar2(30) NOT NULL, -- ������
    salary NUMBER NOT NULL, -- �޿� 
    address varchar2(1000) NOT NULL, -- �ּ�
    projname varchar2(100) NULL -- ��� ������Ʈ ��

);

INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES (1, 'ȫ�浿', 250, '�����', 'ȫ�� ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES (2, '�ƹ���', 230, '�λ��', 'TV ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES (3, '������', 210, '�����', '���� �м�');

SELECT * FROM tblstaff;


-- 1���� ������ �������� ������Ʈ�� ����� �� �ִ�.
-- �����ͺ��̽� ������ : �ϳ��� ������ �ϳ��� ���� ������ �ִ�.
-- �����ͺ��̽��� �ߺ����� �Ⱦ��Ѵ�.
INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES (1, 'ȫ�浿', 250, '�����', 'ȫ�� ����');

DROP TABLE tblstaff;

CREATE TABLE tblstaff
(
    seq NUMBER PRIMARY KEY, --���� ��ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- ������
    salary NUMBER NOT NULL, -- �޿�
    address VARCHAR2(1000) NOT NULL-- �ּ�
    -- project NUMBER NOT NULL -- ��� ������Ʈ
);

CREATE TABLE tblproject
(
    seq NUMBER PRIMARY KEY, -- ������Ʈ��ȣ(PK)
    name VARCHAR2(200) NOT NULL, -- ������Ʈ ��
    staff NUMBER NOT NULL -- ��� ���� ��ȣ -- ��� ����(���߿� ���������)���� ����ؾ���(���ʿ��� ���ÿ� ����ϴ°��� ���������� �Ұ���)
);

INSERT INTO tblstaff(seq, name, salary, address) VALUES (1, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff(seq, name, salary, address) VALUES (2, '�ƹ���', 250, '��õ��');
INSERT INTO tblstaff(seq, name, salary, address) VALUES (3, '������', 180, '�λ��');

INSERT INTO tblproject(seq, name, staff) VALUES (1, 'ȫ�� ����', 1);
INSERT INTO tblproject(seq, name, staff) VALUES (2, 'TV ����', 2);
INSERT INTO tblproject(seq, name, staff) VALUES (3, '���� �м�', 2);
INSERT INTO tblproject(seq, name, staff) VALUES (4, '�븮�� �о�', 1);
INSERT INTO tblproject(seq, name, staff) VALUES (5, '���� ����', 3);

-- tblstaff(�⺻���̺�, �θ� ���̺�) + tblproject(�������̺�, �ڽ� ���̺�) : �� ���̺��� ����(relationship)�� �ΰ� �ִ�. -> tblproject ���̺��� tblstaff ���̺��� �����Ѵ�.

-- ���踦 �ΰ� �ִ� 2���� ���̺��� �����͸� �����ϸ� ����� �ϵ�...
-- 1. �θ� ���̺��� ����
-- 2. �ڽ� ���̺��� ���� 

-- 1. ���� ��� �Ի� -> �ű� ������Ʈ ����(���)

-- 1.a ���� ��� �߰� (O)
INSERT INTO tblstaff(seq, name, salary, address) VALUES (4, 'ȣȣȣ', 150, '�����');��

-- 1.b �ű� ������Ʈ �߰� (O)
INSERT INTO tblproject(seq, name, staff) VALUES (6, '���� ����', 4);

-- 1.c �ű� ������Ʈ �߰� (X)
INSERT INTO tblproject(seq, name, staff) VALUES (7, '�� ���', 5); -- ��ȿ�� staff ��ȣ ORA-02291: integrity constraint (HR.SYS_C007219) violated - parent key not found


-- 2. ȫ�浿 ���
-- 2.a ȫ�浿 ����
DELETE FROM tblstaff WHERE name = 'ȫ�浿'; -- WHERE SEQ = 1 -- ��(���ڵ�) ���� - ORA-02292: integrity constraint (HR.SYS_C007219) violated - child record found

-- 2.b ȫ�浿 �ùٸ� ��� ����
-- 2.b.a ȫ�浿�� ��� ������Ʈ -> ����
UPDATE tblproject SET staff = 3 WHERE staff = 1; -- �� ���� 

-- 2.b.b ȫ�浿 ����
DELETE FROM tblstaff WHERE name = 'ȫ�浿';

SELECT * FROM tblstaff;
SELECT * FROM tblproject;


-- �θ� ���̺� + �ڽ� ���̺� -> ���� ���� -> ���� ���� �߰�
-- �ܷ�Ű, Foreign Key(References)
-- : ���� ������ ���̺��� ���� �� ������ �ϴ� �÷��� ���� �׻� ��ȿ�ϰ� ���������ִ� ����
-- : �θ����̺��� PK�� �����ϴ� Ű + �θ� ���̺� �̹� �����ϴ� ���� ���� �� �ִ� �÷�
DROP TABLE tblstaff;
DROP TABLE tblproject;

CREATE TABLE tblstaff
(
    seq NUMBER PRIMARY KEY, --���� ��ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- ������
    salary NUMBER NOT NULL, -- �޿�
    address VARCHAR2(1000) NOT NULL-- �ּ�
);

CREATE TABLE tblproject
(
    seq NUMBER PRIMARY KEY, -- ������Ʈ��ȣ(PK)
    name VARCHAR2(200) NOT NULL, -- ������Ʈ ��
    staff NUMBER REFERENCES tblstaff(seq) NOT NULL -- ��� ���� ��ȣ -- ��� ����(���߿� ���������)���� ����ؾ���(���ʿ��� ���ÿ� ����ϴ°��� ���������� �Ұ���)
);




-- �� - �Ǹ�
-- �� ���̺�
CREATE TABLE tblcustomer
(
    seq NUMBER PRIMARY KEY, -- ����ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- ����
    tel VARCHAR2(15) NOT NULL, -- ����ó
    address VARCHAR2(100) NOT NULL -- �ּ�
    
);

-- �Ǹ� ���̺�
CREATE TABLE tblsales
(
    seq NUMBER PRIMARY KEY, -- �ǸŹ�ȣ(PK)
    item VARCHAR2(50) NOT NULL, -- ��ǰ��
    qty NUMBER NOT NULL, -- ����
    regdate DATE DEFAULT sysdate NOT NULL, -- �Ǹ� ��¥
    customer NUMBER REFERENCES tblcustomer(seq) -- ����ȣ(FK)
);

-- �θ� & �ڽ� ���̺�
-- 1. ���� ����
-- : �θ� ���� -> �ڽ� ����
-- 2. ���� ����
-- : �ڽ� ���� -> �θ� ���� 

DROP TABLE tblcustomer;
DROP TABLE tblsales;



-- ���� �뿩��

-- ȸ�� ����
CREATE TABLE tblmember
(
    seq NUMBER PRIMARY KEY, --ȸ����ȣ(PK)
    name VARCHAR2(20) NOT NULL, -- ȸ����
    grade NUMBER(1)
        CHECK (grade BETWEEN 1 AND 3) NOT NULL, -- ȸ�����(1, 2, 3)
    byear number(4) NOT NULL, -- ����
    tel VARCHAR2(15) NOT NULL, -- ����ó
    address VARCHAR2(300) NULL, -- �ּ�
    money NUMBER NOT NULL -- ��ġ��

);


-- �帣 ���̺�
CREATE TABLE tblgenre
(  
    seq NUMBER PRIMARY KEY, --�帣 ��ȣ(PK)
    name VARCHAR2(30) NOT NULL, --�帣��
    price NUMBER NOT NULL, -- �뿩 ����
    period NUMBER NOT NULL -- �뿩 �Ⱓ 
);


-- ���� ���̺�
CREATE TABLE tblvideo
(
    seq NUMBER PRIMARY KEY, --���� ��ȣ(PK)
    name VARCHAR2(100) NOT NULL, -- ���� 
    qty NUMBER NOT NULL, -- ���� ����
    company VARCHAR2(50) NULL, -- ���ۻ�
    director VARCHAR2(50) NULL, -- ����
    major VARCHAR2(50) NULL, -- �ֿ����
    genre NUMBER REFERENCES tblgenre(seq) NOT NULL -- �帣��ȣ(FK)

);


-- �뿩 ���̺� 
CREATE TABLE tblrent
(
    seq NUMBER PRIMARY KEY, -- �뿩��ȣ(PK)
    member NUMBER REFERENCES tblmember(seq) NOT NULL, -- �뿩�� ȸ�� ��ȣ(FK)
    video NUMBER REFERENCES tblvideo(seq) NOT NULL, -- �뿩�� ���� ��ȣ(FK)
    rentdate DATE DEFAULT sysdate NOT NULL, -- �뿩 ��¥
    retdate DATE NULL -- �ݳ� ��¥
);


-- ������ ��ü
CREATE SEQUENCE memberseq;
CREATE SEQUENCE genreseq;
CREATE SEQUENCE videoseq;
CREATE SEQUENCE rentseq;




-- �ٽ� �ʱ�ȭ
DROP TABLE tblrent;
DROP TABLE tblmember;
DROP TABLE tblgenre;
DROP TABLE tblvideo;

DROP SEQUENCE memberseq;
DROP SEQUENCE genreseq;
DROP SEQUENCE videoseq;
DROP SEQUENCE rentseq;


/*

����, Join
- 2�� �̻��� ���̺��� ������ 1���� ������� ����� �۾�
- ���踦 �ΰ� �ִ� ���̺��� ���ؼ�...

������ ����
1. �ܼ� ����, Cross Join
2. ���� ����, Inner Join
3. �ܺ� ����, Outer Join
4. ���� ����, Self Join

1. �ܼ� ����
*/

SELECT * FROM tblcustomer; -- 3��
SELECT * FROM tblsales; -- 9��

SELECT * FROM tblcustomer, tblsales; -- ����
SELECT * FROM tblcustomer CROSS JOIN tblsales; -- ���� / 3�� * 9�� = 27�� 


/*
 2. ���� ����
 : �ܼ� ���ο��� ��ȿ�� ���ڵ常 ���ϴ� ����
 : �θ� ���̺��� PK�� �ڽ� ���̺��� FK�� ������ ������ ���Ѵ�.-> ��ȿ�� ���ڵ�

SELECT �÷�����Ʈ FROM ���̺�A 
    INNER JOIN ���̺�B
        ON  ���̺�A.�÷�(PK) = ���̺�B.�÷�(FK)

*/
-- �ڹٿ��� rs.getString("seq");
-- ���ο��������̺�Ҽ� ������ , Alias ���� (�ʼ�) 
SELECT -- 3 
    c.seq as sseq, 
    s.seq as cseq,
    --name,
    --item
    c.name,
    s.item
FROM tblcustomer c -- ���̺� ��Ī(Alias) -- 1
    INNER JOIN tblsales s
        ON c.seq = s.customer; -- 2 ���ǽ� 
        
        
-- �� ���ϴ� �ൿ(���� ����� * ���� �������� �ൿ)        
SELECT * FROM tblcustomer c 
    INNER JOIN tblsales s
        ON c.seq = s.customer; 

-- �������� ������� �ʿ��� �����͸�
SELECT * FROM (SELECT c.name, c.address, s.item, s.qty FROM tblcustomer c 
    INNER JOIN tblsales s
        ON c.seq = s.customer);


-- ǥ�� SQL
SELECT * FROM tblcustomer c 
    INNER JOIN tblsales s
        ON c.seq = s.customer; 

-- ����Ŭ ����
SELECT * FROM tblcustomer c, tblsales s
    WHERE c.seq = s.customer;



-- ���� ��� �� �ϸ� �ȵǴ� �ൿ
SELECT * FROM tblrent;
SELECT * FROM tblhousekeeping;

-- ���踦 �ΰ� �������� ���̺� ������ ����
SELECT * FROM tblrent r
    INNER JOIN tblhousekeeping h
        ON r.member = h.qty;



SELECT * FROM tblcustomer; -- 3��
SELECT * FROM tblsales; -- 9��

-- '��Ʈ'��(tblsales) �簣 ȸ���� ����ó(tblcustomer)?

-- 1. ��������
SELECT name, tel FROM tblcustomer 
    WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

-- 2. ����
SELECT c.tel FROM tblcustomer c
    INNER JOIN tblsales s
        ON c.seq = s.customer
            WHERE s.item = '��Ʈ';





-- '��Ʈ'��(tblsales) �簣 ȸ���� ����ó(tblcustomer)�� ����?
-- ������ ������� ���� ����� 2�� �̻��� ���̺��� ���;� �Ѵٸ� -> ���� ���

-- 1. �������� -- X 
SELECT name, tel, qty FROM tblcustomer
    WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

SELECT name, tel, (SELECT qty FROM tblsales WHERE customer = c.seq and item = '��Ʈ') FROM tblcustomer c
    WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');
-- 2.
SELECT c.tel, s.qty FROM tblcustomer c
    INNER JOIN tblsales s
        ON c.seq = s.customer
            WHERE s.item = '��Ʈ';


/*

1. �ܼ� ����
2. ���� ����
3. �ܺ� ����
- ���� ���� + a 

*/
SELECT * FROM tblcustomer; -- 4�� 
SELECT * FROM tblsales; -- 9��

-- ** �� 1�� �߰� 
INSERT INTO tblcustomer VALUES (4, 'ȣȣȣ', '010-1234-5678', '�����');

-- ���� ����
-- ���θ����� 1ȸ(****) �̻� �����̷��� �ִ� ���� ������ ���� �̷��� �������ÿ�.
SELECT * FROM tblcustomer c 
    INNER JOIN tblsales s
        ON c.seq = s.customer; -- ���� (c�� PK�� s�� FK)

-- ���θ����� ��� ���� ������ ��� + �����̷��� �ִ� ȸ���� �����̷µ� ���� ��� 
-- ������ �׻� �θ� ���̺��� ����Ų��. �ڽ� ���̺��� ����Ű�� INNER JOIN�� ����������.
-- ������̺� ��������� �������� �ʴ´� 
SELECT * FROM tblcustomer c
    LEFT OUTER JOIN tblsales s -- �׻� �θ� ���̺��� ����Ų��  
        ON c.seq = s.customer;

SELECT * FROM tblstaff;   -- 5��
SELECT * FROM tblproject; -- 6�� 

INSERT INTO tblstaff VALUES (5, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff VALUES (6, '�׽�Ʈ', 250, '�����');

-- ����ȸ�� : ���� ��� + ������ �ִ� �����...
-- �츮 ���� ��� �����Ͷ� + ������Ʈ�� ����ϰ� �ִ� ������ ���ؼ�...
SELECT * FROM tblstaff s 
    INNER JOIN tblproject p
        ON s.seq = p.staff;

-- ����ȸ�� : ���� ��� + ������ �ִ� ��� ��...
-- �츮 ���� ��� �����Ͷ� + ������Ʈ ��� ���� ��� ����...
-- ǥ�� SQL
SELECT * FROM tblstaff s
    LEFT OUTER JOIN tblproject p 
        ON s.seq = p.staff;
    

-- ����Ŭ 
SELECT * FROM tblstaff s, tblproject p
    WHERE s.seq = p.staff(+);




/*
4. ���� ����
- 1���� ���̺� ������ ����
- �� ���� -> �ڽ��� �ڽ��� �����ϴ� Ű�� ������
*/

-- ���� ���� ���̺�
CREATE TABLE tblself
(
    seq NUMBER PRIMARY KEY, -- ���� ��ȣ(PK)
    name VARCHAR2(30) NOT NULL, -- ������
    department VARCHAR2(30) NULL, -- �μ�
    super NUMBER REFERENCES tblself(seq) NULL -- ���� ���(FK) 
    
);

INSERT INTO tblself VALUES (1, 'ȫ����', NULL, NULL);
INSERT INTO tblself VALUES (2, '������', '�ѹ���', 1);
INSERT INTO tblself VALUES (3, '������', '�ѹ���', 2);
INSERT INTO tblself VALUES (4, '�ٴ븮', '�ѹ���', 3);
INSERT INTO tblself VALUES (5, '����', '�ѹ���', 4);
INSERT INTO tblself VALUES (6, '������', '������', 1);
INSERT INTO tblself VALUES (7, '�ٰ���', '������', 6);


SELECT * FROM tblself;

SELECT s2.name as ������, s1.name as ���� FROM tblself s1
    RIGHT OUTER JOIN tblself s2
        ON s1.seq = s2.super; -- s1(PK, �θ����̺�) = s2(FK, �ڽ����̺�)


-- employees : manager_id
SELECT e2.first_name as ������, e1.first_name as �Ŵ����� 
    FROM employees e1   -- �Ŵ��� 
        INNER JOIN employees e2  -- ���� 
            ON e2.manager_id = e1.employee_id;


-- "�Ŵ�����"�� ����ϰ� �ִ� ���� ��?                                        (�ٱ� �����͸� �������� ���ؼ� ��Ī�� ��������)
SELECT (SELECT first_name || ' ' || last_name FROM employees WHERE employee_id = e2.manager_id), count(*) FROM employees e2
    GROUP BY manager_id;



-- ���� ����
-- ���̺� ���� �ø��� 

-- 1��
-- ������ ����?
SELECT * FROM tblvideo;

-- 2��
-- ��� ���� ����� �뿩 ����, �Ⱓ?
SELECT * FROM tblgenre g
    INNER JOIN tblvideo v
        ON g.seq = v.genre;

-- 3�� 
-- ��� ������ �뿩����, �Ⱓ + �뿩 ����?
SELECT * FROM tblgenre g
    INNER JOIN tblvideo v
        ON g.seq = v.genre
            INNER JOIN tblrent r
                ON r.video = v.seq;
            

-- 4��
-- ��� ������ �뿩����, �Ⱓ + �뿩 ���� + �뿩 ȸ���� ����?
SELECT * FROM tblgenre g
    INNER JOIN tblvideo v
        ON g.seq = v.genre
           LEFT OUTER JOIN tblrent r
                ON r.video = v.seq
                    RIGHT OUTER JOIN tblmember m 
                        ON m.seq = r.member;


-- �뿩 ��� ��� + ȸ���� + �������� + ���� + �ݳ� ����('�ݳ� �Ϸ�' or '�̹ݳ�') -case ��
desc tblvideo;
desc tblrent;

CREATE VIEW ���
AS
SELECT m.name as ȸ����,
       v.name as ��������, 
       g.rentdate as �뿩��¥,
    CASE
        WHEN g.retdate is NULL then '�̹ݳ�'
        ELSE '�ݳ� �Ϸ�'
    END as "�ݳ� ����"
FROM tblrent g 
    INNER JOIN tblmember m
        ON m.seq = g.member
            INNER JOIN tblvideo v 
                ON g.video = v.seq;






































