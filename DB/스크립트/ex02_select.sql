-- ex02_select.sql


/*

SQL�� ��ҹ��ڸ� �������� �ʴ´�.

1. SQL Ű���� : �빮��
2. ��ü �ĺ��� : �ҹ���(Ǯ)
    a. memberpoint
    b. memberPoint
    c. member_point
    d. MEMBER_POINT
    
    �����(���)-(SQL(��ɾ�)��) -> Ŭ���̾�Ʈ(����) ->  �������� �����͸� �����´�  
    
    
SQL �ڷ���    
- DBMS�� ���� ���̰� ���� 

1. ������
    a. NUMBER(��� ���� > ����, �Ǽ� �������)
        - ���� + �Ǽ�
        - (��ȿ�ڸ�)38�ڸ� ������ ���ڸ� ǥ�� -> �ڹ� double�� ������� ����� -> 20byte ���� 
        - number(precision, scale)
            1. precision : �Ҽ� ���ϸ� ������ ��ü �ڸ���(1 ~ 38)
            2. scale : �Ҽ��� ���� �ڸ��� 
            
            ex) 
                number : 38�ڸ����� ǥ���� ������ ��� ����(����, �Ǽ�)
                number(3) : �ִ� 3�ڸ����� ǥ���� ������ ����(-999 ~ 999)
                number(4,2) : �ִ� 4�ڸ����� + �Ҽ����� 2�ڸ� ����(-99.99 ~ 99.99)
                number(10,3) : -9999999.999 ~ 9999999.999
                
                
            
    b. ������ Ÿ��
        - INTEGER, DOUBLE, DECIMAL, REAL ��... -> ������ ������ -> �� ����? -> �ٸ� �ý��� or ���� ��������� ȣȯ�� ������..
                
        
    
2. ������
    - �ڹ� : ����(char) + ���ڿ�(String)
    - ����Ŭ�� ���ڿ� ���ڿ��� ������ ����. ��� �� ���������� ����Ѵ�.
    
    - ����Ŭ �⺻ ���ڵ� 
        : ~ 8 (EUC-KR) -> 9i ~ 12c(UTF-8)
    
    a. CHAR / NCHAR
        - ���� �ڸ��� -> ���� ���� ������ �״�� ���� ���� ���� ���� �Ұ� -> ��� ���� 
        - CHAR(N) : N�ڸ� ���ڿ� (���� - ����Ʈ)
        ex) CHAR(3) : 3����Ʈ���� ���ڸ� ���� (abc, ȫ�浿 -> ���ڵ��� ���� �ٸ�)
        - �ִ� ũ�� : 2000����Ʈ 
        - �ּ� ũ�� : 1����Ʈ 
        
    b. VARCHAR / NVARCHAR -> VARCHAR2 / NVARCHAR2
        - ���� �ڸ��� -> ���� ���� ������ �߶� ȸ�� -> ��� ����
        - VARCHAR2(N) : N�ڸ� ���ڿ�(���� - ����Ʈ)
        - �ִ�ũ�� : 4000����Ʈ
        - �ּ�ũ�� : 1����Ʈ
        
        
    c. N�� ����
        - ���ڼ��� ���� 
        1. N�� ������ : ����Ŭ�� �⺻ ���ڵ� ���(UTF-8)
            - ex) CHAR(3) : UTF-8 3����Ʈ  
        2. N�� ������ : ����Ŭ�� �⺻ ���ڵ��� ������� ������ UTF-16�� ���
            - ex) NCHAR(3) : ���� �ѱ� ������� 3���� -> �ѱ� ��붧 ������ -> ������ ���� ��������
        
        
3. ��¥ �ð���
    a. DATE
        - ���� �� �ڷ����� ��� 
        - �ڹ��� Calendar ����
        - ��¥ + �ð� ����
        - �ð� ������ 
        - 7 byte
        - B.C 4712�� 1�� 1�� ~ A.D 9999�� 12�� 31��
        - �ּҴ��� : �ʱ��� 
        
    b. TIMESTAMP
        - DATE�� ������
        - 10����� 1�ʱ��� (������)
        
    c. INTERVAL
        - �ð� ������
        - ƽ�� 
        

4. ��뷮 �ڷ���
    a. lob(��), Large Object
        - ������(�ӵ� ����)
        - �ε��� ��� X 
        1. BLOB (Binary Large Object)
            - ��뷮 ���̳ʸ� ������
            - ū �̹���, ������ ��...
            - �ִ� ũ�� : 4GB
        2. CLOB (Character Large Object)
            - ��뷮 ���� ������
            - �ִ� ũ�� : 4GB
        
�÷� -> ���ڵ� -> ���̺�  

F5 - ��ü ����

*/  

--SELECT * FROM tabs; -- ���� 

--select * from tabs;

-- ���̺� �����ϱ�

DROP TABLE tbltype; -- ���̺� ���� 

CREATE TABLE tbltype -- ���̺� �����ϱ�
(
 -- �÷� �����ϱ�
 -- �÷��� �ڷ���(����) ������� 
 --age NUMBER,
 --height NUMBER(3),
 --weight NUMBER(4, 1)
 
 --name char(3)
 --name nchar(3)

 --txt varchar2(30)

txt1 char(30),
txt2 varchar2(30)

);





desc tbltype; -- ���̺� ���� �������� 

-- ������ �߰��ϱ� (���� �߰�, ���� �߰��Ѱ��� �ƴ�)
INSERT INTO tbltype (age) VALUES (20); -- tbltype ���̺� age�÷��� 20�� ���� �־�� - 20, NULL, NULL
INSERT INTO tbltype (age) VALUES (220000000000000);
INSERT INTO tbltype (age) VALUES (12345678901234567890123456789012345678); -- 38�ڸ� 
INSERT INTO tbltype (age) VALUES (123456789012345678901234567890123456789); -- 39��
INSERT INTO tbltype (age) VALUES (12345678901234567890123456789012345678901234567890); -- 50�ڸ� -> �ʰ����� 0���� ǥ��ȴ�

INSERT INTO tbltype (age, height) VALUES (20, 180);
INSERT INTO tbltype (age, height) VALUES (20, 999);
INSERT INTO tbltype (age, height) VALUES (20, 1000); -- ���� �÷ο� �߻� -> ���� 
INSERT INTO tbltype (age, height) VALUES (20, -999);
INSERT INTO tbltype (age, height) VALUES (20, -1000); -- ���� �÷ο� �߻� -> ����

INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 65.5);
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 999.9);
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 9999.9); -- ����
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 999.99); -- ���� 
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 99.99); -- 20, 170, 100 (�ʰ��κ� �ݿø�)
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 12.34); -- �ʰ��κ� �ݿø�

INSERT INTO tbltype (age, height, weight) VALUES (20, 3.14, 12.34); -- 20, 3, 12.3 (�Ǽ� �κ� ��)



-- ������ ��������
SELECT * FROM tbltype; 

-- name CHAR(3) : UTF-8 -> 3����Ʈ 
INSERT INTO tbltype (name) VALUES ('abc'); -- O     �ڹٿ� �ٸ��� "" ��� '' ��� 
INSERT INTO tbltype (name) VALUES ('ȫ�浿'); -- X  -- O(nchar)
INSERT INTO tbltype (name) VALUES ('ȫ'); -- O      3byte ������

-- txt VARCHAR2(30)
INSERT INTO tbltype (txt) VALUES('abcdeabcdeabcdeabcdeabcdeabcde'); -- O   30��
INSERT INTO tbltype (txt) VALUES('abcdeabcdeabcdeabcdeabcdeabcdef'); -- X  31�� 
INSERT INTO tbltype (txt) VALUES('���̻�����ĥ�ȱ���'); -- O    10�� 30 ����Ʈ 
INSERT INTO tbltype (txt) VALUES('���̻�����ĥ�ȱ�����'); -- X  11�� 33����Ʈ

INSERT INTO tbltype (txt) VALUES ('���̻�����ĥ�ȱ� ab'); -- O 30����Ʈ (���� > 1����Ʈ)
INSERT INTO tbltype (txt) VALUES ('���̻�����ĥ�ȱ� abc'); -- X 31����Ʈ (���� > 1����Ʈ)


INSERT INTO tbltype (txt1, txt2) VALUES ('ȫ�浿', 'ȫ�浿'); -- 'ȫ�浿                     ', 'ȫ�浿'  -- ���� ������ �ٸ��� 

SELECT * FROM tbltype WHERE txt1 = txt2; -- �� ���� ������ �����͸� �����Ͷ�
SELECT * FROM tbltype WHERE trim(txt1) = trim(txt2); -- trim ����� ��  







