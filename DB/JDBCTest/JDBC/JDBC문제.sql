/*
=======================================================================

문제1.
<<요구사항>> 아이디 중복 검사를 구현하시오.

<<입출력>>
아이디 입력 : hong
이미 사용중입니다.
아이디 입력 : test
이미 사용중입니다.
아이디 입력 : bbb
사용이 가능합니다.

<<테이블>>
CREATE TABLE tblauth
(
	id VARCHAR2(50) PRIMARY KEY --아이디
);

INSERT INTO tblauth VALUES ('hong');
INSERT INTO tblauth VALUES ('test');
INSERT INTO tblauth VALUES ('aaa');

<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_auth(
	구현
)
IS
BEGIN
	구현
END;

=======================================================================
*/
CREATE TABLE tblauth
(
	id VARCHAR2(50) PRIMARY KEY --아이디
);

INSERT INTO tblauth VALUES ('hong');
INSERT INTO tblauth VALUES ('test');
INSERT INTO tblauth VALUES ('aaa');


CREATE OR REPLACE PROCEDURE proc_auth(
	pid VARCHAR2,
    presult OUT NUMBER
)
IS
    vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM tblauth WHERE id = pid;
    
    IF vcount > 0 THEN
        presult := 1;
    ELSE 
        presult := 0;
    END IF;
END;
/*
=========================================================================
문제2.
<<요구사항>> 직원 번호를 입력하면 조직도를 출력하시오.

<<입출력>>
직원 번호 입력 : 101
Neena Kochhar(515.123.4568)
        ▷ Nancy Greenberg(515.124.4569)
                ▷ Daniel Faviet(515.124.4169)
                ▷ John Chen(515.124.4269)
                ▷ Ismael Sciarra(515.124.4369)
                ▷ Jose Manuel Urman(515.124.4469)
                ▷ Luis Popp(515.124.4567)
        ▷ Jennifer Whalen(515.123.4444)
        ▷ Susan Mavris(515.123.7777)
        ▷ Hermann Baer(515.123.8888)
        ▷ Shelley Higgins(515.123.8080)
                ▷ William Gietz(515.123.8181)

<<테이블>>
employees

<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_employees(
	구현
)
IS
BEGIN
	구현
END;

=======================================================================

SELECT seq, lpad(' ', (level - 1) * 6) || name, prior name 
    FROM tblcomputer
        START WITH seq = 1
            CONNECT BY PRIOR seq = pseq;

*/
CREATE OR REPLACE PROCEDURE proc_employees
(
	pseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
	SELECT lpad(' ', (level - 1) * 6) || '▷' || (first_name || ' ' || last_name) || '(' || PHONE_NUMBER || ')' as result
        FROM employees 
            START WITH EMPLOYEE_ID = pseq 
                CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID;
END;

DESC employees;

DECLARE

BEGIN
    proc_employees(101);
END;

SELECT lpad(' ', (level - 1) * 6) || '▷' || (first_name || ' ' || last_name) || '(' || PHONE_NUMBER || ')' as result
        FROM employees 
            START WITH EMPLOYEE_ID = 101
                CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID;



/*
=======================================================================

문제4.
<<요구사항>> 부서별 비상 연락망을 만드시오.

<<조건>>
1. 부서별 출력
2. 부서내 직원명 오름차순으로 연결

<<입출력>>
[개발부]
김신애 ▷ 엄용수 ▷ 이기상 ▷ 이기자 ▷ 이미성 ▷ 이상헌 ▷ 이성길 ▷ 이순애 ▷ 임수봉 ▷ 장인철 ▷ 정영희 ▷ 채정희 ▷ 홍길남 ▷ 황진이 (종료)
[기획부]
권옥경 ▷ 김말자 ▷ 김신제 ▷ 이영숙 ▷ 이정석 ▷ 지재환 ▷ 홍길동 (종료)
[영업부]
고순정 ▷ 권영미 ▷ 김미나 ▷ 김숙남 ▷ 김인수 ▷ 김정훈 ▷ 김종서 ▷ 산마루 ▷ 손인수 ▷ 양미옥 ▷ 우재옥 ▷ 유관순 ▷ 전용재 ▷ 정한나 ▷ 지수환 ▷ 홍원신 (종료)
[인사부]
나윤균 ▷ 박문수 ▷ 박세열 ▷ 이남신 (종료)
[자재부]
김싱식 ▷ 문길수 ▷ 심심해 ▷ 유영희 ▷ 이미경 ▷ 이재영 (종료)
[총무부]
김말숙 ▷ 김영길 ▷ 이순신 ▷ 이현숙 ▷ 정정해 ▷ 한석봉 ▷ 허경운 (종료)
[홍보부]
김영년 ▷ 이미인 ▷ 정상호 ▷ 정한국 ▷ 조미숙 ▷ 최석규 (종료)

<<테이블>>
tblinsa

<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_mergency(
	구현
)
IS
BEGIN
	구현
END;

=======================================================================
*/
CREATE OR REPLACE PROCEDURE proc_mergency
(
    pbuseo VARCHAR2,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
	SELECT name FROM tblinsa WHERE buseo = pbuseo ORDER BY NAME ASC;
END;

DESC tblinsa;

SELECT name, buseo FROM tblinsa ORDER BY buseo, name;

/*
=======================================================================

문제3.
<<요구사항>> 카테고리 탐색을 구현하시오.

<<입출력>>
[대분류]
1. 전자제품
2. 식음료
3. 운동용품
선택 : 1

[중분류]
1. 모니터
2. 마우스
3. 키보드
선택 : 1

[소분류]
1. 소형
2. 중형
3. 대형
선택 : 3

[상품]
7. LG300(수량 : 72개)
8. Dell300(수량 : 23개)
9. HP300(수량 : 22개)

<<테이블>>
*/
--대분류
CREATE TABLE tbl_big_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL
);

--중분류
CREATE TABLE tbl_middle_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_big_category(seq)
);

--소분류
CREATE TABLE tbl_small_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_middle_category(seq)
);

--상품
CREATE TABLE tbl_product
(
	seq NUMBER PRIMARY KEY ,
	name varchar2(100) NOT NULL ,
	qty NUMBER NOT NULL ,
	pseq NUMBER NOT NULL REFERENCES tbl_small_category(seq)
);
DROP
--데이터
INSERT INTO tbl_big_category VALUES (1, '전자제품');
INSERT INTO tbl_big_category VALUES (2, '식음료');
INSERT INTO tbl_big_category VALUES (3, '운동용품');

INSERT INTO tbl_middle_category VALUES (1, '모니터', 1);
INSERT INTO tbl_middle_category VALUES (2, '마우스', 1);
INSERT INTO tbl_middle_category VALUES (3, '키보드', 1);

INSERT INTO tbl_middle_category VALUES (4, '과일음료', 2);
INSERT INTO tbl_middle_category VALUES (5, '건강음료', 2);
INSERT INTO tbl_middle_category VALUES (6, '인스턴스 식품', 2);

INSERT INTO tbl_middle_category VALUES (7, '야구', 3);
INSERT INTO tbl_middle_category VALUES (8, '축구', 3);
INSERT INTO tbl_middle_category VALUES (9, '농구', 3);

INSERT INTO tbl_small_category VALUES (1, '소형', 1);
INSERT INTO tbl_small_category VALUES (2, '중형', 1);
INSERT INTO tbl_small_category VALUES (3, '대형', 1);

INSERT INTO tbl_small_category VALUES (4, '일반', 2);
INSERT INTO tbl_small_category VALUES (5, '인체공학', 2);
INSERT INTO tbl_small_category VALUES (6, '버티컬', 2);

INSERT INTO tbl_small_category VALUES (7, '기계식', 3);
INSERT INTO tbl_small_category VALUES (8, '블루투스', 3);
INSERT INTO tbl_small_category VALUES (9, '일반', 3);


INSERT INTO tbl_product VALUES (1, 'LG100', 50, 1);
INSERT INTO tbl_product VALUES (2, 'Dell100', 20, 1);
INSERT INTO tbl_product VALUES (3, 'HP100', 25, 1);

INSERT INTO tbl_product VALUES (4, 'LG200', 15, 2);
INSERT INTO tbl_product VALUES (5, 'Dell200', 53, 2);
INSERT INTO tbl_product VALUES (6, 'HP200', 23, 2);

INSERT INTO tbl_product VALUES (7, 'LG300', 72, 3);
INSERT INTO tbl_product VALUES (8, 'Dell300', 23, 3);
INSERT INTO tbl_product VALUES (9, 'HP300', 22, 3);


CREATE OR REPLACE PROCEDURE proc_list_big_category 
(
    pcursor OUT SYS_REFCURSOR	
)
IS
BEGIN
OPEN pcursor FOR
    SELECT * FROM tbl_big_category ORDER BY seq ASC;
END;
 

CREATE OR REPLACE PROCEDURE proc_list_middle_category 
(
    pbigseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
        SELECT * FROM tbl_middle_category WHERE pseq = pbigseq ORDER BY seq;
END;


CREATE OR REPLACE PROCEDURE proc_list_small_category 
(
    pmiddleseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
        SELECT * FROM tbl_small_category WHERE pseq = pmiddleseq ORDER BY seq;
END;



CREATE OR REPLACE PROCEDURE proc_list_product 
(
    psmallseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
        SELECT * FROM tbl_product WHERE pseq = psmallseq ORDER BY seq ASC;
END;

/*
=======================================================================


문제5.
<<요구사항>> 각 장소간의 거리를 출력하시오.

<<입출력>>
강남역 2호선 ▷ 광화문 (9.22km)
강남역 2호선 ▷ 서울역 (8.17km)
강남역 2호선 ▷ 쌍용 교육원 강남 센터 (.65km)
강남역 2호선 ▷ 어린이 대공원 (7.72km)
강남역 2호선 ▷ 역삼역 2호선 (1.04km)
강남역 2호선 ▷ 이태원 (5.11km)
강남역 2호선 ▷ 인사동 (8.22km)
강남역 2호선 ▷ 홍대 입구 (13.03km)
광화문 ▷ 강남역 2호선 (9.22km)
광화문 ▷ 서울역 (2.19km)
광화문 ▷ 쌍용 교육원 강남 센터 (9.54km)
광화문 ▷ 어린이 대공원 (12.13km)
광화문 ▷ 역삼역 2호선 (9.7km)
광화문 ▷ 이태원 (4.29km)
광화문 ▷ 인사동 (1.21km)
광화문 ▷ 홍대 입구 (6.33km)
서울역 ▷ 강남역 2호선 (8.17km)
서울역 ▷ 광화문 (2.19km)
서울역 ▷ 쌍용 교육원 강남 센터 (8.6km)
서울역 ▷ 어린이 대공원 (12.5km)
서울역 ▷ 역삼역 2호선 (8.84km)
서울역 ▷ 이태원 (3.08km)
서울역 ▷ 인사동 (2.45km)
서울역 ▷ 홍대 입구 (5.47km)
쌍용 교육원 강남 센터 ▷ 강남역 2호선 (.65km)
쌍용 교육원 강남 센터 ▷ 광화문 (9.54km)
쌍용 교육원 강남 센터 ▷ 서울역 (8.6km)
쌍용 교육원 강남 센터 ▷ 어린이 대공원 (7.15km)
쌍용 교육원 강남 센터 ▷ 역삼역 2호선 (.39km)
쌍용 교육원 강남 센터 ▷ 이태원 (5.53km)
쌍용 교육원 강남 센터 ▷ 인사동 (8.5km)
쌍용 교육원 강남 센터 ▷ 홍대 입구 (13.56km)
어린이 대공원 ▷ 강남역 2호선 (7.72km)
어린이 대공원 ▷ 광화문 (12.13km)
어린이 대공원 ▷ 서울역 (12.5km)
어린이 대공원 ▷ 쌍용 교육원 강남 센터 (7.15km)
어린이 대공원 ▷ 역삼역 2호선 (6.78km)
어린이 대공원 ▷ 이태원 (10.04km)
어린이 대공원 ▷ 인사동 (10.93km)
어린이 대공원 ▷ 홍대 입구 (17.97km)
역삼역 2호선 ▷ 강남역 2호선 (1.04km)
역삼역 2호선 ▷ 광화문 (9.7km)
역삼역 2호선 ▷ 서울역 (8.84km)
역삼역 2호선 ▷ 쌍용 교육원 강남 센터 (.39km)
역삼역 2호선 ▷ 어린이 대공원 (6.78km)
역삼역 2호선 ▷ 이태원 (5.77km)
역삼역 2호선 ▷ 인사동 (8.64km)
역삼역 2호선 ▷ 홍대 입구 (13.86km)
이태원 ▷ 강남역 2호선 (5.11km)
이태원 ▷ 광화문 (4.29km)
이태원 ▷ 서울역 (3.08km)
이태원 ▷ 쌍용 교육원 강남 센터 (5.53km)
이태원 ▷ 어린이 대공원 (10.04km)
이태원 ▷ 역삼역 2호선 (5.77km)
이태원 ▷ 인사동 (3.52km)
이태원 ▷ 홍대 입구 (8.27km)
인사동 ▷ 강남역 2호선 (8.22km)
인사동 ▷ 광화문 (1.21km)
인사동 ▷ 서울역 (2.45km)
인사동 ▷ 쌍용 교육원 강남 센터 (8.5km)
인사동 ▷ 어린이 대공원 (10.93km)
인사동 ▷ 역삼역 2호선 (8.64km)
인사동 ▷ 이태원 (3.52km)
인사동 ▷ 홍대 입구 (7.35km)
홍대 입구 ▷ 강남역 2호선 (13.03km)
홍대 입구 ▷ 광화문 (6.33km)
홍대 입구 ▷ 서울역 (5.47km)
홍대 입구 ▷ 쌍용 교육원 강남 센터 (13.56km)
홍대 입구 ▷ 어린이 대공원 (17.97km)
홍대 입구 ▷ 역삼역 2호선 (13.86km)
홍대 입구 ▷ 이태원 (8.27km)
홍대 입구 ▷ 인사동 (7.35km)

<<공식>>
단위 : km
두 점간의 거리 = 루트((|x1-x2|)^2 + (|y1-y2|)^2)

두 포인트의 위도값의 차이 : 0.0012
두 포인트의 경도간의 차이 : 0.0002
두 포인트의 위도 간 실제 거리 = 0.0012*92 = 0.1104
두 포인트의 경도 간 거리 = 0.0002*114 = 0.0228
루트(0.01104^2 + 0.00228^2)
= 루트(0.01218816 + 0.00051984)
= 루트(0.012708)
= 0.112730 km

*/
-- CREATE p1.name as sname, p2.name as ename FROM tbl_point p1, tbl_point p2 WHERE p1.seq <> p2.seq;

CREATE TABLE tbl_point
(
	seq NUMBER PRIMARY KEY, --PK
	name VARCHAR(100) NOT NULL, --장소명
	latitude NUMBER NOT NULL, --위도
	longitude NUMBER NOT NULL --경도
);

CREATE SEQUENCE point_seq;

INSERT INTO tbl_point VALUES (point_seq.nextval, '쌍용 교육원 강남 센터', 37.499306, 127.033202);
INSERT INTO tbl_point VALUES (point_seq.nextval, '강남역 2호선', 37.497901, 127.027631);
INSERT INTO tbl_point VALUES (point_seq.nextval, '역삼역 2호선', 37.500649, 127.036476);
INSERT INTO tbl_point VALUES (point_seq.nextval, '광화문', 37.576015, 126.976914);
INSERT INTO tbl_point VALUES (point_seq.nextval, '홍대 입구', 37.556724, 126.923615);
INSERT INTO tbl_point VALUES (point_seq.nextval, '이태원', 37.534456, 126.993887);
INSERT INTO tbl_point VALUES (point_seq.nextval, '인사동', 37.571734, 126.986966);
INSERT INTO tbl_point VALUES (point_seq.nextval, '어린이 대공원', 37.549330, 127.081160);
INSERT INTO tbl_point VALUES (point_seq.nextval, '서울역', 37.553185, 126.971530);


CREATE OR REPLACE PROCEDURE proc_distance 
(
	pseq NUMBER,
    pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN pcursor FOR
        SELECT (SELECT name FROM tbl_point WHERE seq = pseq), 
            p.name, 
            round(SQRT(power(((SELECT latitude FROM tbl_point WHERE seq = pseq) - p.latitude) * 92, 2) + 
            power(((SELECT longitude FROM tbl_point WHERE seq = pseq) - p.longitude) * 114, 2)), 2) || 'km' as 거리
                 FROM tbl_point p 
                    WHERE seq <> pseq
                        ORDER BY name ASC;

END;
	

