-- 단일 라인 주석 

--ex01.sql

/*

다중 라인 주석 

데이터 베이스

1. Oracle : oracle

2. MySQL

데이터베이스 클라이언트 툴

1. SQL developer : Oracle - 메인 

2. Datagrip : Jetbrain

3. QueryBox : 국내

4. SQLGate : 국내

5. 이클립스

6. Toad(토드)  

모델링 툴

1. eXERD : 국내 

2. ER-WIN


오라클, Oracle

- 회사명

- 제품명(데이터베이스 + 데이터베이스 관리 시스템)



오라클 설치 후 동작 확인?

1. services.msc

2. OracleXXX 패턴의 서비스명 
    - XE : SID(Service ID) - 오라클 프로그램 이름 
    - orcl -> 엔터프라이즈 버전  
    
    a. OracleServiceXE -> OracleServiceOrcl (엔터프라이즈 - 정식판)
        - 데이터베이스 프로그램 (DB)
        - 우리가 부르는 "오라클" 
        - DB
    b. OracleXETNSListener -> OracleOrclTNSListener (엔터프라이즈 - 정식판)
        - 데이터베이스(오라클)가 외부의 클라이언트들의 요청을 받기 위한 대화 서비스 
        
    
서비스 시작 * 멈춤
> cmd + 관리자 권한 실행  

1. net start 서비스명 
2. net stop 서비스명 

net start OracleServiceXE





데이터베이스, Database, DB

- 정보 -> 유효한 정보 -> 데이터(유효한 데이터) -> 집합 -> 데이터베이스


데이터베이스의 특징(자격)
- 실시간 접근성 제공 
- 지속적인 변화 관리
- 동시 공유(많은 사용자가 데이터를 사용해야 한다.) 


데이터베이스 모델

1. 계층형 모델, Hirerachial Model
    - 폴더 & 파일 형태의 구조로 데이터를 저장하는 방식
    - 현재 거의 사용 안함 
    
2. 관계형 모델, Relational Model
    - 1969년
    - 열과 행을 가지는 표 형태로 데이터를 저장하는 방식 (엑셀 처럼)
    - SQL 언어를 사용해서 조작한다.
    - 현재 대다수의 DB환경이 이 모델을 사용한다. (예) 오라클) 
    
    
3. 객체 지향 데이터베이스 Object Oriented Database, OODB
    - 데이터를 객체 단위로 저장하는 방식

4. XML 데이터베이스
    - XML 형식으로 저장하는 방식 
    
5. 키-값형 데이터 스토어 
    - 맵 형식으로 저장하는 방식(연관 배열 방식과 유사)
    - 대량의 데이터를 초고속으로 취급해야 하는 업무 
    - NoSQL(Not Only SQL)
    - 빅데이터
    - MongoDB, Couchbase, Cassandra...
    


관계형 데이터베이스

1. 수많은 데이터들이 테이블형태로 관리된다.
    - 세부 정보 : 컬럼
    - 세부 정보 집합 : 행
    
2. 관계?
    - RDB에서는 표를 관계 (Relational) 라고 부른다.
    

데이터베이스 관리 시스템, Database Management System, DBMS

- 데이터베이스를 관리하는 시스템(프로그램 + 환경 등...)

- 많은 양의 데이터를 꼭 DBMS 사용해서 관리해야 하나? 그냥 텍스트파일 or 엑셀 사용?

1. 다수의 사람이 데이터를 공유하기 쉽다.

2. 대량의 데이터를 다루기 쉽다.
    - 수백만, 수천만건의 데이터 

3. 읽기/쓰기를 자동화하기 쉽다.
    - 텍스트, 엑셀 -> 일반 유저 -> 프로그래밍화 
    - 사용법이 쉽다.
    
4. 만약의 사고에 대응하기 쉽다. (*****)
    - 백업/복구
    - 보안(유출)
    
DBMS 제품 종류 (DB + DBMS) 

1. ORACLE
    - ORACLE 사
    - 기업, 소호
    - Java와 같이 사용함.(많이)
    - 국내. 가장 많이 사용하는 제품
    
2. MS-SQL Server 
    - Microsoft 
    - 기업, 소호 
    - 윈도우에서만 구동
    
3. MS ACCESS
    - Mircrosoft
    - 대기업 부서용, 소호, 개인
    - 오피스에 포함 

4. DB2
    - IBM
    - 한동안 IBM 컴퓨터에서만 구동 -> 다른 시스템 구동 가능 
    

5. INFOMIX
    - INFOMIX
    - 오라클 경쟁상대
    - IBM에서 인수

6. MySQL
    - 오픈 소스(무료)
    - Oracle에서 인수
    - 개인 > 상용DB급
    
7. MariaDB
    - 오픈 소스 (무료)

8. MaxDB
    - SAP + MySQL -> MaxDB
    
9. PostgreSQL
    - 오픈소스

10. SQLite
    - 오픈 소스
    - 임베디드에서 많이 사용
    
11. 티베로
    - 티맥스
    - 오라클과 거의 동일(호환성)
    - 기업은행 등...
    

오라클 종료

1. Enterprise Edition
    - CPU 무제한
2. Standard Edition
3. Personal Edition
4. Express Edition
    - CPU 1개 제한 
    - 운영체제 32bit -> 64bit
    - 데이터 4GB 최대
    - 메모리 점유율 1GB 초과시 서버 다운 



오라클 버전
    - v1(1978년) ~ 12c(2013년)
    - 9i ~ 11g 가장 많이 쓰임
    - 9i : internet
    - 10g : grid (분산 컴퓨팅 환경)
    - 11g : grid
    - 12c : cloud (클라우드)


설치 프로그램

1. 데이터베이스
    - Oracle Server
    - 데이터 저장/관리 + 부가 기능 제공 
    
2. DB 클라이언트 툴
    - SQL Developer
    - QueryBox
    - 데이터베이스 서버로부터 서비스를 제공 받는 툴 
    
3. 모델링 툴
    - eXERD
    - 데이터베이스 설계 툴 



DB 관련 직책

1. DB 관리자, DB Admin(Administrator)
    - DB 총괄
    - DB 서비스를 안정적으로 운영/관리
    
2. DB 엔지니어 
    - H/W 관리

3. 백업 마스터
    - DB Admin 겸임

4. 모델러
    - DB 설계

5. 튜너
    - DB 튜닝
    
6. DB 개발자, DB 프로그래머
   - 1 ~ 5번의 하위 단계 
   - 데이터 조작 관련 업무 
   - 응용 프로그램 개발자도 많이 함.



*/ 

SELECT * FROM tabs; -- tabs 라는 이름의 테이블에 무엇이 들어있어요?
                    -- 우측 상단에 어느 계정으로 시작하냐에 따라서 보여주는 테이블이 다르다(할당받은 스키마 영역이 다름 (권한))
                    -- 현재 접속이 누구로 되어있냐? -> 결과 다름 
/*

SQL
- 관계형 데이터베이스 시스템과 대화할 수 있는 언어(명령어)
- Structered Query Language, 구조화된 질의 언어 



SQL 명령어의 종류

1. DDL, Data Definition Language, 데이터 정의어
- 데이터를 저장하기 위한 데이터베이스 구조를 정의하는 명령어 
a. CREATE : 객체 생성, 만들어라 
b. DROP : 객체 삭제, 없애라
c. ALTER : 객체 수정 
- 데이터베이스 관리자(담당자), 프로그래머(일부)



2. DML, Data Manipulation Language, 데이터 조작어
- 데이터베이스에 데이터를 추가/검색/수정/삭제 하는 작업 
- SQL의 가장 기본셋
- CRUD 작업
a. SELECT : 데이터 가져오기
b. INSERT : 데이터 추가하기
c. UPDATE : 데이터 수정하기
d. DELETE : 데이터 삭제하기 
- 데이터베이스 관리자(담당자), 프로그래머


3. DCL, Data Control Language, 데이터 제어
-  트랜잭션, 보안 등 작업
a. COMMIT : 데이터 처리 승인
b. ROLLBACK : 데이터 처리 반려 
c. GRAND : 권한 부여
d. REVOKE : 권한 제거(박탈)


 
 SQL 표준화 및 종류
 
 - DBMS의 종류에 따라 구문이 조금 다르다.
 - ISO, ANSI -> SQL 표준화 -> 표준 SQL(ANSI SQL) : SQL-92, SQL-99, SQL-2003, SQL-2008 등
 - 대다수 DBMS들이 표준 SQL 지원


1. 표준 SQL
- DBMS 종류와 상관없이 모두 지원 
- 1986년

2. PL/SQL
- 오라클 전용 SQL

3. T-SQL
- MS-SQL 전용 SQL 

4. MySQL...



계정 

1. sys : 최고 관리자

2. system : 관리자 

3. sysoper : 관리자 

4. 사용자 계정 
    - 직접 생성
    - 직원별 / 업무별 
    - 데이터 테이블들을 사용자에 따라 나눈 그룹 -> 스키마(Schema) (DB에따라 데이터베이스라고 불리기도 한다)
    - Scott, HR 이라는 예제용 계정(스키마를 이미 할당받은)이 존재한다 .
        - scott / tiger
        - hr(Human Resources) / lion -> 샘플데이터가 인력관리 데이터 이다.
    
    
HR 계정
    - 오라클 설치 직후 -> 잠겨있음 -> 잠금 해제(활성화) + 암호 변경(java1234)
    - 위의 작업은 권한이 있는 계정이 할 수 있다.
    
현재 작성하고 있는 파일 -> 스크립트 파일    
흐름 존재 x -> 순서 없음(Batch 형식이 아님 -> 문장 단위로 실행 -> JAVA와 다르다)
*/

ALTER USER hr ACCOUNT UNLOCK; -- 잠금 해제 
ALTER USER hr IDENTIFIED BY java1234; -- 암호 변경 

ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY java1234; -- 동시에 
ALTER USER hr IDENTIFIED BY java1234 ACCOUNT UNLOCK;



-- 핑(Ping) 테스트, 루프 백(Loop Back) IP
-- 127.0.0.1
-- 자신을 뜻하는 주소 
-- localhost : 아무 기능없는 단어 

-- DNS 서버 (서비스)
-- 도메인 주소를 IP주소로 변환해 알려주는 서버 

-- 기본 클라이언트 틀 -> sqlplus (콘솔 기반)
-- > sqlplus

-- 관리자 암호 잊어버렸을때!
--> sqlplus /nolog
-- SQL> conn /as sysdba
-- ALTER USER hr IDENTIFIED BY java1234;



-- 포트 번호 (각 프로그램마다 하나의 번호를 독점한다) -> 네트워크 프로그램 끼리의 식별자 
-- 오라클이 쓰고있는 대표적인 포트번호 -> 1521, 8080(Apache에서 사용) 
-- 한 컴퓨터의 오라클을 다수 설치 가능하다. -> 실제 사용하지는 않음


-- tabs : Tables
-- 시스템 테이블 중 하나 
-- 해당 유저가 소유하고 있는 테이블의 목록 제공 -> 자신의 스키마 내부에 있는 테이블 자원 반환 

SELECT * FROM tabs;

SELECT * FROM employees;
SELECT * FROM departments;



























