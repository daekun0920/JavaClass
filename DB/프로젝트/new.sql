CREATE TABLE sss (
  seq NUMBER PRIMARY KEY
);

CREATE SEQUENCE sss_seq
  START WITH 6;

DROP SEQUENCE sss_seq;

SELECT * FROM sss;
SELECT sss_seq.currval FROM dual;
SELECT sss_seq.nextval FROM dual;

INSERT INTO sss VALUES (sss_seq.nextval);
ROLLBACK;
COMMIT;