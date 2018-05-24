-- 연예인 검색(목록 불러오기)

CREATE OR REPLACE VIEW vw_search_stars
AS
SELECT m.member_seq, m.member_id, m.member_name, a.type_seq, a.ARTIST_SEQ FROM tbl_member m 
    INNER JOIN tbl_star s ON m.member_seq = s.member_seq 
        INNER JOIN tbl_artist a ON s.star_seq = a.star_seq;

SELECT * FROM tbl_main_notice n INNER JOIN tbl_staff f ON n.staff_seq = f.staff_seq INNER JOIN tbl_member m ON m.member_seq = f.member_seq WHERE n.main_notice_seq = 29;
commit;
CREATE OR REPLACE VIEW vw_search_group
AS
SELECT g.group_seq, g.GROUP_NAME, a.ARTIST_SEQ, a.star_seq FROM tbl_group g 
    INNER JOIN tbl_artist a ON g.group_seq = a.group_seq WHERE a.star_seq is NULL;

INSERT INTO tbl_schedule_state VALUES (1, '수락');
INSERT INTO tbl_schedule_state VALUES (2, '미수락');

INSERT INTO tbl_schedule_type VALUES (1, '드라마');
INSERT INTO tbl_schedule_type VALUES (2, '영화');
INSERT INTO tbl_schedule_type VALUES (3, '예능');
INSERT INTO tbl_schedule_type VALUES (4, '녹음');
INSERT INTO tbl_schedule_type VALUES (5, '공연');
INSERT INTO tbl_schedule_type VALUES (6, '라디오');

INSERT INTO tbl_schedule VALUES (8, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (9, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (10, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (11, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (12, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (13, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (14, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (15, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (16, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (17, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (18, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);
INSERT INTO tbl_schedule VALUES (19, '테스트2', 11, 1, '역삼역', '2018-05-03', '2018-05-22', 20000, 1, 2);

SELECT * FROM 
    (SELECT tt.*, rownum as rnum FROM 
        (SELECT * FROM tbl_schedule s 
            INNER JOIN tbl_artist a ON s.artist_seq = a.artist_seq  
                INNER JOIN tbl_schedule_type t ON s.schedule_type_seq = t.schedule_type_seq 
                    WHERE s.schedule_state_seq = 0)
    tt) WHERE rnum >= ? AND rnum <= ?;
    
    
CREATE OR REPLACE PROCEDURE proc_addoffer 
(
    pschedule_name IN tbl_schedule.schedule_name%TYPE,
    partist_seq IN tbl_schedule.artist_seq%TYPE,
    pmember_seq IN tbl_schedule.member_seq%TYPE,
    pschedule_place IN tbl_schedule.schedule_place%TYPE,
    pschedule_start IN tbl_schedule.schedule_start%TYPE,
    pschedule_end IN tbl_schedule.schedule_end%TYPE,
    pschedule_pay IN tbl_schedule.schedule_pay%TYPE,
    pschedule_type IN tbl_schedule.schedule_type_seq%TYPE,
    presult OUT NUMBER
)
IS
    cnt NUMBER;
BEGIN
    
    IF pschedule_start > pschedule_end THEN
        presult := 2;
    ELSE 
        
        INSERT INTO tbl_schedule VALUES (schedule_seq.nextval, pschedule_name, partist_seq, pmember_seq, pschedule_place, pschedule_start, pschedule_end, pschedule_pay, pschedule_type, 2);
        presult := 1;
    END IF;
    

END;

commit;
CREATE TABLE tbl_staff_type (

    staff_type_seq NUMBER PRIMARY KEY,
    staff_type_name VARCHAR2(30)
    
);

CREATE SEQUENCE staff_type_seq;

ALTER TABLE tbl_staff_matching ADD(staff_type_seq REFERENCES tbl_staff_type(staff_type_seq)); 
SELECT * FROM tbl_schedule;
CREATE OR REPLACE PROCEDURE proc_match_staff 
(
    pstaff_seq IN tbl_staff_matching.staff_seq%TYPE,
    partist_seq IN tbl_artist.artist_seq%TYPE,
    pstaff_type IN tbl_staff_type.staff_type_seq%TYPE,
    presult OUT NUMBER
)
IS

chk NUMBER;

BEGIN

    SELECT count(*) INTO chk FROM tbl_staff_matching WHERE artist_seq = partist_seq AND staff_type_seq = pstaff_type;
    
    IF chk > 0 THEN
        
        UPDATE tbl_staff_matching SET staff_seq = pstaff_seq WHERE artist_seq = partist_seq AND staff_type_seq = pstaff_type;
        presult := 1;
    ELSE 
    
        INSERT INTO tbl_staff_matching VALUES (staff_matching_seq.nextval, pstaff_seq, partist_seq, pstaff_type);
        presult := 1;
    END IF;


END;

INSERT INTO tbl_staff_type VALUES (1, '스타일리스트');
INSERT INTO tbl_staff_type VALUES (2, '운전기사');
INSERT INTO tbl_staff_type VALUES (3, '트레이너');



CREATE TABLE tbl_main_notice (
    main_notice_seq NUMBER PRIMARY KEY,
    main_notice_title VARCHAR2(500),
    main_notice_content VARCHAR2(2000),
    main_notice_time DATE,
    main_notice_visitor NUMBER,
    main_notice_check VARCHAR2(1),
    main_notice_file VARCHAR2(150) NULL,
    main_notice_orgfile VARCHAR2(150) NULL,
    staff_seq NUMBER REFERENCES tbl_staff(staff_seq)

);

CREATE SEQUENCE main_notice_seq;

INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '1', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '1', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '1', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);
INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, '안녕하세요~', '안녕하세요~', sysdate, 0, '0', null, null, 1);


commit;