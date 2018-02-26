-- ex02_select.sql


/*

SQL은 대소문자를 구분하지 않는다.

1. SQL 키워드 : 대문자
2. 객체 식별자 : 소문자(풀)
    a. memberpoint
    b. memberPoint
    c. member_point
    d. MEMBER_POINT
    
    사용자(명령)-(SQL(명령어)로) -> 클라이언트(수행) ->  서버에서 데이터를 가져온다  
    
    
SQL 자료형    
- DBMS에 따라 차이가 심함 

1. 숫자형
    a. NUMBER(모든 숫자 > 정수, 실수 상관없이)
        - 정수 + 실수
        - (유효자리)38자리 이하의 숫자를 표현 -> 자바 double와 생김새가 비슷함 -> 20byte 차지 
        - number(precision, scale)
            1. precision : 소수 이하를 포함한 전체 자릿수(1 ~ 38)
            2. scale : 소숫점 이하 자릿수 
            
            ex) 
                number : 38자리까지 표현이 가능한 모든 숫자(정수, 실수)
                number(3) : 최대 3자리까지 표현이 가능한 숫자(-999 ~ 999)
                number(4,2) : 최대 4자리까지 + 소수이하 2자리 포함(-99.99 ~ 99.99)
                number(10,3) : -9999999.999 ~ 9999999.999
                
                
            
    b. 나머지 타입
        - INTEGER, DOUBLE, DECIMAL, REAL 등... -> 실제로 사용안함 -> 왜 존재? -> 다른 시스템 or 예전 버전들과의 호환성 때문에..
                
        
    
2. 문자형
    - 자바 : 문자(char) + 문자열(String)
    - 오라클은 문자와 문자열의 구분이 없다. 모두 다 문자형으로 취급한다.
    
    - 오라클 기본 인코딩 
        : ~ 8 (EUC-KR) -> 9i ~ 12c(UTF-8)
    
    a. CHAR / NCHAR
        - 고정 자릿수 -> 쓰고 남은 공간은 그대로 남고 남은 공간 재사용 불가 -> 비용 적음 
        - CHAR(N) : N자리 문자열 (길이 - 바이트)
        ex) CHAR(3) : 3바이트까지 문자를 저장 (abc, 홍길동 -> 인코딩에 따라 다름)
        - 최대 크기 : 2000바이트 
        - 최소 크기 : 1바이트 
        
    b. VARCHAR / NVARCHAR -> VARCHAR2 / NVARCHAR2
        - 가변 자릿수 -> 쓰고 남은 공간을 잘라서 회수 -> 비용 많음
        - VARCHAR2(N) : N자리 문자열(길이 - 바이트)
        - 최대크기 : 4000바이트
        - 최소크기 : 1바이트
        
        
    c. N의 유무
        - 문자셋의 차이 
        1. N이 없으면 : 오라클의 기본 인코딩 사용(UTF-8)
            - ex) CHAR(3) : UTF-8 3바이트  
        2. N이 있으면 : 오라클의 기본 인코딩과 상관없이 무조건 UTF-16을 사용
            - ex) NCHAR(3) : 영어 한글 상관없이 3글자 -> 한글 사용때 유리함 -> 하지만 사용빈도 높지않음
        
        
3. 날짜 시간형
    a. DATE
        - 거의 이 자료형만 사용 
        - 자바의 Calendar 유사
        - 날짜 + 시간 포함
        - 시각 데이터 
        - 7 byte
        - B.C 4712년 1월 1일 ~ A.D 9999년 12월 31일
        - 최소단위 : 초까지 
        
    b. TIMESTAMP
        - DATE의 버전업
        - 10억분의 1초까지 (나노초)
        
    c. INTERVAL
        - 시간 데이터
        - 틱값 
        

4. 대용량 자료형
    a. lob(롭), Large Object
        - 참조형(속도 느림)
        - 인덱스 대상 X 
        1. BLOB (Binary Large Object)
            - 대용량 바이너리 데이터
            - 큰 이미지, 동영상 등...
            - 최대 크기 : 4GB
        2. CLOB (Character Large Object)
            - 대용량 문자 데이터
            - 최대 크기 : 4GB
        
컬럼 -> 레코드 -> 테이블  

F5 - 전체 실행

*/  

--SELECT * FROM tabs; -- 권장 

--select * from tabs;

-- 테이블 생성하기

DROP TABLE tbltype; -- 테이블 삭제 

CREATE TABLE tbltype -- 테이블 생성하기
(
 -- 컬럼 정의하기
 -- 컬럼명 자료형(길이) 제약사항 
 --age NUMBER,
 --height NUMBER(3),
 --weight NUMBER(4, 1)
 
 --name char(3)
 --name nchar(3)

 --txt varchar2(30)

txt1 char(30),
txt2 varchar2(30)

);





desc tbltype; -- 테이블 정보 가져오기 

-- 데이터 추가하기 (행을 추가, 셀을 추가한것이 아님)
INSERT INTO tbltype (age) VALUES (20); -- tbltype 테이블에 age컬럼에 20의 값을 넣어라 - 20, NULL, NULL
INSERT INTO tbltype (age) VALUES (220000000000000);
INSERT INTO tbltype (age) VALUES (12345678901234567890123456789012345678); -- 38자리 
INSERT INTO tbltype (age) VALUES (123456789012345678901234567890123456789); -- 39자
INSERT INTO tbltype (age) VALUES (12345678901234567890123456789012345678901234567890); -- 50자리 -> 초과분은 0으로 표기된다

INSERT INTO tbltype (age, height) VALUES (20, 180);
INSERT INTO tbltype (age, height) VALUES (20, 999);
INSERT INTO tbltype (age, height) VALUES (20, 1000); -- 오버 플로우 발생 -> 에러 
INSERT INTO tbltype (age, height) VALUES (20, -999);
INSERT INTO tbltype (age, height) VALUES (20, -1000); -- 오버 플로우 발생 -> 에러

INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 65.5);
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 999.9);
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 9999.9); -- 에러
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 999.99); -- 에러 
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 99.99); -- 20, 170, 100 (초과부분 반올림)
INSERT INTO tbltype (age, height, weight) VALUES (20, 170, 12.34); -- 초과부분 반올림

INSERT INTO tbltype (age, height, weight) VALUES (20, 3.14, 12.34); -- 20, 3, 12.3 (실수 부분 컷)



-- 데이터 가져오기
SELECT * FROM tbltype; 

-- name CHAR(3) : UTF-8 -> 3바이트 
INSERT INTO tbltype (name) VALUES ('abc'); -- O     자바와 다르게 "" 대신 '' 사용 
INSERT INTO tbltype (name) VALUES ('홍길동'); -- X  -- O(nchar)
INSERT INTO tbltype (name) VALUES ('홍'); -- O      3byte 딱맞음

-- txt VARCHAR2(30)
INSERT INTO tbltype (txt) VALUES('abcdeabcdeabcdeabcdeabcdeabcde'); -- O   30자
INSERT INTO tbltype (txt) VALUES('abcdeabcdeabcdeabcdeabcdeabcdef'); -- X  31자 
INSERT INTO tbltype (txt) VALUES('일이삼사오육칠팔구십'); -- O    10자 30 바이트 
INSERT INTO tbltype (txt) VALUES('일이삼사오육칠팔구십일'); -- X  11자 33바이트

INSERT INTO tbltype (txt) VALUES ('일이삼사오육칠팔구 ab'); -- O 30바이트 (공백 > 1바이트)
INSERT INTO tbltype (txt) VALUES ('일이삼사오육칠팔구 abc'); -- X 31바이트 (공백 > 1바이트)


INSERT INTO tbltype (txt1, txt2) VALUES ('홍길동', '홍길동'); -- '홍길동                     ', '홍길동'  -- 서로 엄연히 다르다 

SELECT * FROM tbltype WHERE txt1 = txt2; -- 두 값이 같으면 데이터를 가져와라
SELECT * FROM tbltype WHERE trim(txt1) = trim(txt2); -- trim 사용후 비교  







