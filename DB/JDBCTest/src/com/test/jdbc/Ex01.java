package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	
	public static void main(String[] args) {
		
		/*
		
		 Ex01.java
		  
		 JDBC, Java Database Connectivity
		 - 자바 응용 프로그램(콘솔, 웹, 모바일 등..)과 데이터베이스 시스템(오라클, MySQL 등..) 간의 연결을 시켜주는 역할. 중간 계층
		 - 자바 프로그램 <-> 오라클 // 서로 종속적인 관계, 강한 결합, 코드 어려움.
		 - 자바 프로그램 <-> JDBC <-> 오라클 // 서로 비종속적인 관계, 약한 결합, 코드 쉬움.  
		 
		 - 사람(유저) <-> DataGrip(툴) <-> SQL(질의) <-> 오라클(서버)
		 - 자바(유저) <-> JDBC(툴) <-> SQL(질의) <-> 오라클(서버)
		 
		 String sql = "SELECT * FROM vwinsa";
		 
		 [DataGrip, SQL Developer]
		 1. 실행
		 2. 접속
		 	a. 호스트명 : 서버IP or 도메인주소 
		 	b. 포트번호 : 1521
		 	c. SID : xe 
		 	d. 드라이버 : thin(oci)
		 	e. 사용자명 : hr
		 	f. 비밀번호 : java1234
		 3. 질의(****)
		 	a. SQL 사용
		 	b. 반환값이 없는 쿼리
		 		-SELECT를 제외한 모든 쿼리
		 	c. 반환값이 있는 쿼리
		 		- 결과셋을 반환하는 쿼리
		 		- SELECT
		 		- 결과셋 -> 업무에 사용
		 4. 접속 종료
		 	a. COMMIT or ROLLBACK
		 	b. 접속 종료
		 	
		 [자바]
		 1. 응용 프로그램(Java) 실행
		 2. 접속
		 	- Connection 클래스 사용  
		 	a. 호스트명 : 서버IP or 도메인주소 
		 	b. 포트번호 : 1521
		 	c. SID : xe 
		 	d. 드라이버 : thin(oci)
		 	e. 사용자명 : hr
		 	f. 비밀번호 : java1234
		 3. 질의
		 	- Statement 클래스
		 	a. SQL 사용
		 	b. 반환값이 없는 쿼리
		 		- SELECT를 제외한 모든 쿼리
		 	c. 반환값이 있는 쿼리
		 		- ResultSet 클래스를 사용(DB의 결과테이블 참조)
		 		- 결과셋을 반환하는 쿼리
		 		- SELECT
		 		- 결과셋 -> 업무에 사용
		 4. 접속 종료
		 	- Connection 클래스 사용 
		 	a. COMMIT or ROLLBACK
		 	b. 접속 종료
		 
		 JDBC 관련 클래스 라이브러리 
		 - 데이터베이스 제작사에서 제공(*.jar 형태로..)
		 - DB 종류 or 버전에 따라 다양하게 제공 
		 
		 JDBC 라이브러리 참조(임포트)
		 - 콘솔 프로젝트일 경우..
		 
		 1. 외부 jar 참조
		 	- 외부 jar 참조
		 	- 누군가 jar를 훼손하면 프로젝트도 피해...
		 	- 다수의 프로젝트가 1개의 jar 참조 가능
		 	- 절대 경로 참조
		 2. jar를 프로젝트내에 복사
		 	- 자기 참조
		 	- 프로젝트만 옮기면.. 자동으로 참조되는 *.jar도 같이 옮겨짐(경로 수정 필요X)
		 	- 상대 경로 
		 	- 다수의 프로젝트가 각각의 jar 참조(재사용 불가)
		 */
		
		// 1. DB 접속
		// - Connection 클래스
		Connection conn = null;
		
		// 2. 연결 문자열 생성
		// - 접속에 필요한 정보로 구성된 문자열 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		try {
			
			// DB 작업 -> 외부 환경 -> 예외처리 필수
			// 3. 설치한 JDBC 드라이버 로딩 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 4. 접속
			// - Connection 객체 생성(new Connection();) + 접속 까지 
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println(conn.isClosed());
			
			// 5. 질의
			
			
			// 6. 접속 종료
			conn.close();
			System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
}









