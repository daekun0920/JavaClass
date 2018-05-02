-- 검색 된 연예인/그룹 스케쥴 불러오기
CREATE OR REPLACE PROCEDURE proc_schedule 
(
    p_type IN NUMBER,
    p_seq IN NUMBER,
    p_date IN DATE,
    p_cursor SYS_REFCURSOR
)
IS
v_seq NUMBER;
v_file VARCHAR;
BEGIN

IF p_type = 1 OR p_type = 2 THEN

    OPEN p_cursor FOR
    SELECT * FROM tbl_schedule s 
        WHERE s.artist_seq = (SELECT artist_seq, star_photo INTO v_seq, v_file FROM tbl_artist WHERE star_seq = p_seq)
            AND to_char(s.schedule_start, 'yyyy-mm') like p_date || '%';
    
ELSIF p_type = 3 THEN

    OPEN p_cursor FOR
    SELECT * FROM tbl_schedule s 
        WHERE s.artist_seq = (SELECT artist_seq, star_photo INTO v_seq, v_file FROM tbl_artist WHERE group_seq = p_seq) 
            AND to_char(s.schedule_start, 'yyyy-mm') like p_date || '%';
    
END IF;

END;