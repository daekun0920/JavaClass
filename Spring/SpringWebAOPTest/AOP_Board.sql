
CREATE TABLE tblLog(
    seq NUMBER PRIMARY KEY,
    id VARCHAR2(50) DEFAULT 'guest' NOT NULL,
    regdate DATE DEFAULT SYSDATE NOT NULL,
    page VARCHAR2(500) NOT NULL -- list.aop?page=10, add.aop, view.aop


);