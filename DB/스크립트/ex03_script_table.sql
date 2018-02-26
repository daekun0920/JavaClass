-- Hello 테이블
DROP TABLE tblhello;

CREATE TABLE tblhello
(
	name varchar2(30) not null,
	age number not null,
	tel varchar2(30) not null,
	address varchar2(100) not null
);

INSERT INTO tblhello VALUES ('홍길동', 20, '010-1234-5678', '서울시 강남구 역삼동');

COMMIT;











-- 국가 테이블
DROP TABLE tblcountry;

CREATE TABLE tblcountry
(
	name VARCHAR2(30) NOT NULL PRIMARY KEY, -- 국가명
	capital VARCHAR2(30) NULL, -- 수도
	population NUMBER NULL, -- 인구수
	continent VARCHAR2(2) NULL, -- 대륙(AS, NA, SA..)
	area NUMBER NULL -- 면적
);

INSERT INTO tblCountry VALUES ('대한민국','서울',4405,'AS',10);
INSERT INTO tblCountry VALUES ('중국','베이징',120660,'AS',959);
INSERT INTO tblCountry VALUES ('일본','도쿄',12461,'AS',37);
INSERT INTO tblCountry VALUES ('미국','워싱턴',24963,'SA',936);
INSERT INTO tblCountry VALUES ('영국','London',5741,'EU',24);
INSERT INTO tblCountry VALUES ('이집트','카이로',5969,'AF',99);
INSERT INTO tblCountry VALUES ('오스트레일리아','Canberra',1787,'AU',768);
INSERT INTO tblCountry VALUES ('칠레','산티아고',1339,'SA',75);
INSERT INTO tblCountry VALUES ('우루과이','몬테비디오',317,'SA',17);
INSERT INTO tblCountry VALUES ('아르헨티나','부에노스아이레스',3388,'SA',278);
INSERT INTO tblCountry VALUES ('인도네시아','자카르타',19134,'AS',191);
INSERT INTO tblCountry VALUES ('네덜란드','암스테르담',1476,'EU',4);
INSERT INTO tblCountry VALUES ('케냐','나이로비',NULL,'AF',58);
INSERT INTO tblCountry VALUES ('벨기에2','브뤼셀',1012,'EU',3);

COMMIT;









-- 자료형 테이블
DROP TABLE tbltype;

CREATE TABLE tbltype
(
	txt1 VARCHAR2(30) NOT NULL,	--문자열(문자)
	txt2 VARCHAR2(30) NOT NULL,  --문자열(숫자)
	num1 NUMBER NOT NULL, --숫자
	date1 DATE NOT NULL, --날짜
	date2 VARCHAR2(50) NOT NULL, --날짜
	txt3 CHAR(30) NOT NULL,
	txt4 VARCHAR2(30) NOT NULL
);

INSERT INTO tbltype values ('홍길동', '100', 123, to_date('2018-01-01', 'yyyy-mm-dd'), '2018-01-01', '하나둘셋', '하나둘셋');

COMMIT;











-- 이름 테이블
DROP TABLE TBLNAME;

CREATE TABLE TBLNAME
(
	first varchar2(20) not null,
	last varchar2(20) not null,
	gender varchar2(1) check(gender in ('m', 'f')) not null,
	height number not null,
	weight number not null,
	nick varchar2(50) not null
);

INSERT INTO TBLNAME VALUES ('재석', '유', 'm', 178, 64, '메뚜기');
INSERT INTO TBLNAME VALUES ('명수', '박', 'm', 172, 66, '하찮은');
INSERT INTO TBLNAME VALUES ('준하', '정', 'm', 184, 89, '정중앙');
INSERT INTO TBLNAME VALUES ('동훈', '하', 'm', 169, 65, '상꼬마');
INSERT INTO TBLNAME VALUES ('형돈', '정', 'm', 173, 85, '미존개오');
INSERT INTO TBLNAME VALUES ('나래', '박', 'f', 148, 58, '박가래');
INSERT INTO TBLNAME VALUES ('국주', '이', 'f', 167, 92, '김태우');
INSERT INTO TBLNAME VALUES ('세호', '조', 'm', 167, 82, '프로 억울러');
INSERT INTO TBLNAME VALUES ('준현', '김', 'm', 182, 113, '백돼지');
INSERT INTO TBLNAME VALUES ('민상', '유', 'm', 183, 129, '이십끼');

COMMIT;






-- 급여 테이블
DROP TABLE tblsalary;

CREATE TABLE tblsalary
(
	name varchar2(30) not null,
	m1 number not null,
	m2 number not null,
	m3 number not null,
	m4 number not null,
	m5 number not null,
	m6 number not null,
	m7 number not null,
	m8 number not null,
	m9 number not null,
	m10 number not null,
	m11 number not null,
	m12 number not null
);

INSERT INTO tblsalary VALUES ('홍길동', 200, 220, 200, 210, 190, 180, 190, 200, 200, 220, 240, 250);
INSERT INTO tblsalary VALUES ('아무개', 150, 160, 160, 150, 160, 180, 190, 170, 160, 150, 170, 190);
INSERT INTO tblsalary VALUES ('테스트', 220, 230, 250, 220, 220, 230, 250, 230, 220, 250, 260, 240);
INSERT INTO tblsalary VALUES ('호호호', 260, 280, 260, 250, 290, 280, 290, 260, 290, 250, 280, 260);
INSERT INTO tblsalary VALUES ('무명씨', 110, 120, 100, 110, 190, 180, 190, 100, 100, 120, 140, 150);

COMMIT;

SELECT * FROM tblsalary;






-- 인사 테이블

DROP TABLE tblinsa;

CREATE TABLE tblinsa(
        num NUMBER(5) NOT NULL CONSTRAINT tblinsa_pk PRIMARY KEY
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부',
   '부장', 2610000, 200000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부',
   '사원', 1320000, 200000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부',
   '부장', 2550000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부',
   '대리', 1954200, 170000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부',
   '사원', 1420000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부',
   '과장', 2265000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부',
   '대리', 1250000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',
'사원', 950000 , 145000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부',
   '사원', 840000 , 220400);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부',
   '부장', 2540000, 130000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부',
   '사원', 1020000, 140000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부',
   '사원', 880000 , 114000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부',
   '대리', 1601000, 103000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부',
   '사원', 1100000, 130000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부',
   '사원', 1050000, 104000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부',
   '과장', 2350000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부',
   '사원', 950000 , 210000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부',
   '사원', 880000 , 123000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부',
   '과장', 2300000, 165000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부',
   '사원', 880000 , 140000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부',
   '사원', 875000 , 120000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부',
   '대리', 1960000, 180000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부',
   '부장', 2500000, 170000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부',
   '대리', 1900000, 170000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부',
   '사원', 1100000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부',
   '사원', 1050000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부',
   '과장', 2340000, 170000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부',
   '사원', 892000 , 110000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부',
   '사원', 920000 , 124000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부',
   '과장', 2304000, 124000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부',
   '부장', 2450000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부',
   '사원', 880000 , 108000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부',
   '사원', 1020000, 104000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부',
   '사원', 1100000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부',
   '사원', 1050000, 140000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부',
   '사원', 960400 , 190000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부',
   '과장', 2350000, 187000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부',
   '대리', 2000000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부',
   '대리', 2010000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부',
   '대리', 2100000, 130000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부',
   '과장', 2300000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부',
   '사원', 1020000, 200000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부',
   '사원', 1100000, 210000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부',
   '사원', 1060000, 220000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부',
   '사원', 960000 , 152000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부',
   '부장', 2650000, 150000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부',
   '대리', 2100000, 112000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부',
   '대리', 2050000, 106000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부',
   '사원', 1300000, 130000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부',
   '대리', 1950000, 103000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부',
   '과장', 2260000, 104000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부',
   '사원', 1020000, 105000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부',
   '사원', 960000 , 108000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부',
   '사원', 980000 , 114000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부',
   '사원', 1000000, 104000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부',
   '대리', 1950000, 200000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부',
   '부장', 2520000, 160000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부',
   '대리', 1950000, 180000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부',
   '사원', 890000 , 102000);
INSERT INTO tblinsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부',
   '사원', 900000 , 102000);

COMMIT;










-- 다이어리 테이블
DROP TABLE tbldiary;

CREATE TABLE tbldiary
(
	seq number primary key,
	subject varchar2(500) not null,
	weather varchar2(10) not null,
	regdate date not null
);

INSERT INTO tbldiary VALUES (1, '오라클을 처음으로 설치했다', '맑음', '2018-01-18');
INSERT INTO tbldiary VALUES (2, '자바 스터디 하는 날. 저녁에 카페에서 모임', '맑음', '2018-01-19');
INSERT INTO tbldiary VALUES (3, '에러가 나는데 어디서 나는지 모르겠다;;', '흐림', '2018-01-20');
INSERT INTO tbldiary VALUES (4, '영화보러 갔다가 자다왔다.', '흐림', '2018-01-22');
INSERT INTO tbldiary VALUES (5, '버거킹에 가서 와퍼 먹었다.', '맑음', '2018-01-18');
INSERT INTO tbldiary VALUES (6, '본체랑 마우스랑 키보드 바꾼날~', '비', '2018-01-18');
INSERT INTO tbldiary VALUES (7, '처음으로 코딩하며 잠들다!!', '맑음', '2018-01-20');
INSERT INTO tbldiary VALUES (8, '지각 안하고 가까스로 세이프..', '맑음', '2018-01-25');
INSERT INTO tbldiary VALUES (9, '손끝에 굳은살이 베기기 시작했다.', '비', '2018-01-26');
INSERT INTO tbldiary VALUES (10, '왜 에러는 내 눈에만 안보일까?', '흐림', '2018-01-28');

COMMIT;






-- 매출 장부 테이블
DROP TABLE tblhousekeeping;

CREATE TABLE tblhousekeeping
(
	seq number primary key,
	item varchar2(50) not null,
	price number not null,
	qty number not null,
	buydate date not null,
	memo varchar2(1000) null
);



INSERT INTO tblhousekeeping VALUES (1, '양말', 2000, 5, '2018-01-05', null);
INSERT INTO tblhousekeeping VALUES (2, '티셔츠', 5000, 1, '2018-01-06', null);
INSERT INTO tblhousekeeping VALUES (3, '수저세트', 10000, 4, '2018-01-07', null);
INSERT INTO tblhousekeeping VALUES (4, '컵', 3000, 2, '2018-01-08', null);
INSERT INTO tblhousekeeping VALUES (5, '행주', 1000, 10, '2018-01-09', null);
INSERT INTO tblhousekeeping VALUES (6, '도마', 5000, 1, '2018-01-09', null);
INSERT INTO tblhousekeeping VALUES (7, '식칼', 15000, 1, '2018-01-10', null);
INSERT INTO tblhousekeeping VALUES (8, '위생봉투', 1000, 5, '2018-01-10', null);
INSERT INTO tblhousekeeping VALUES (9, '종이컵', 100, 100, '2018-01-10', null);
INSERT INTO tblhousekeeping VALUES (10, '물티슈', 1000, 50, '2018-01-13', null);
INSERT INTO tblhousekeeping VALUES (11, '건전지', 1000, 20, '2018-01-15', null);
INSERT INTO tblhousekeeping VALUES (12, '노트', 1400, 5, '2018-01-18', null);
INSERT INTO tblhousekeeping VALUES (13, '이쑤시개', 10, 3000, '2018-01-18', null);
INSERT INTO tblhousekeeping VALUES (14, '손톱깎이', 3000, 1, '2018-01-19', null);
INSERT INTO tblhousekeeping VALUES (15, '세제', 9000, 2, '2018-01-19', null);
INSERT INTO tblhousekeeping VALUES (16, '냄비받침대', 3000, 2, '2018-01-20', null);
INSERT INTO tblhousekeeping VALUES (17, '슬리퍼', 8000, 3, '2018-01-20', null);
INSERT INTO tblhousekeeping VALUES (18, '치약', 4000, 4, '2018-01-21', null);
INSERT INTO tblhousekeeping VALUES (19, '칫솔', 1700, 9, '2018-01-21', null);
INSERT INTO tblhousekeeping VALUES (20, '비누', 2500, 6, '2018-01-21', null);

COMMIT;









-- 남자 여자 테이블
DROP TABLE tblmen;
DROP TABLE tblwomen;


CREATE TABLE tblmen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);

CREATE TABLE tblwomen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);


INSERT INTO tblmen VALUES ('홍길동', 25, 180, 70, '장도연');
INSERT INTO tblmen VALUES ('아무개', 22, 175, NULL, '이세영');
INSERT INTO tblmen VALUES ('하하하', 27, NULL, 80, NULL);
INSERT INTO tblmen VALUES ('무명씨', 21, 177, 72, NULL);
INSERT INTO tblmen VALUES ('유재석', 29, NULL, NULL, '김숙');
INSERT INTO tblmen VALUES ('박명수', 30, 170, NULL, '김지민');
INSERT INTO tblmen VALUES ('정준하', 31, 183, NULL, '신보라');
INSERT INTO tblmen VALUES ('정형돈', 28, NULL, 92, NULL);
INSERT INTO tblmen VALUES ('양세형', 22, 166, 55, '김민경');
INSERT INTO tblmen VALUES ('조세호', 24, 165, 58, '오나미');

INSERT INTO tblwomen VALUES ('박나래', 23, 150, 55, NULL);
INSERT INTO tblwomen VALUES ('장도연', 28, 177, 65, '홍길동');
INSERT INTO tblwomen VALUES ('김지민', 30, 160, NULL, '박명수');
INSERT INTO tblwomen VALUES ('김숙', 34, 158, NULL, '유재석');
INSERT INTO tblwomen VALUES ('오나미', 27, NULL, NULL, '조세호');
INSERT INTO tblwomen VALUES ('김민경', 22, 169, 88, '양세형');
INSERT INTO tblwomen VALUES ('홍현희', 20, 158, 75, NULL);
INSERT INTO tblwomen VALUES ('신보라', 26, 170, 60, '정준하');
INSERT INTO tblwomen VALUES ('이세영', 28, 163, NULL, '아무개');
INSERT INTO tblwomen VALUES ('신봉선', 27, 162, NULL, NULL);


COMMIT;









-- 할일 테이블
DROP TABLE tbltodo;

CREATE TABLE tbltodo
(
	seq number primary key,
	title varchar2(200) not null,
	adddate date not null,
	completedate date null
);

INSERT INTO tbltodo VALUES (1, '새해 계획 세우기', to_date('2018-01-01 06:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-01 18:30:00', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (2, '마트 장보기', to_date('2018-01-03 13:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-04 20:28:30', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (3, '자바 콘솔 프로젝트 에러잡기', to_date('2018-01-11 14:22:24', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-11 17:32:54', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (4, '내방 청소하기', to_date('2018-01-08 22:00:00', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (5, '강아지 산책시키기', to_date('2018-01-07 10:11:34', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (6, '다이어트 시작하기', to_date('2018-01-01 12:53:20', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (7, '데이터베이스 책 대여하기', to_date('2018-01-02 11:34:52', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-15 12:10:15', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (8, '노트북 포맷하기', to_date('2018-01-02 19:32:12', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-02 19:50:22', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (9, '치과 예약하기', to_date('2018-01-04 11:22:33', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-08 12:32:02', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (10, '아마존에서 키보드 직구하기', to_date('2018-01-08 09:21:11', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (11, '스타벅스 다이어리 예약하기', to_date('2018-01-02 17:23:43', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-03 15:43:21', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (12, '헌혈하기', to_date('2018-01-09 23:33:23', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-12 15:48:52', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (13, '친구에게 전화하기', to_date('2018-01-09 14:42:21', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-09 15:32:34', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (14, '비행기 티켓 예약하기', to_date('2018-01-06 12:23:53', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-11 09:46:22', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (15, '아르바이트 계약서 작성하기', to_date('2018-01-12 12:30:23', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-12 15:32:45', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (16, '과제 제출하기', to_date('2018-01-10 15:03:21', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (17, 'AS 센터 방문하기', to_date('2018-01-11 22:44:22', 'yyyy-mm-dd hh24:mi:ss'), to_date('2018-01-12 16:30:52', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbltodo VALUES (18, '스터디 그룹 짜기', to_date('2018-01-03 22:10:20', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (19, '운전 면허 갱신하기', to_date('2018-01-06 21:21:02', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tbltodo VALUES (20, '헬스 등록하기', to_date('2018-01-05 19:24:42', 'yyyy-mm-dd hh24:mi:ss'), NULL);

COMMIT;