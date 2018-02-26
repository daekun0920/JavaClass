package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class Ex03_Statement {
	/*
	
	Ex03_Statement.java
	  
	Statement 클래스
	- SQL 구문을 실행하는 역할 
	- 스스로는 해당 쿼리를 어떤 DB? -> Connection 객체에 의존
	- 모든 DML은 자동 커밋이 된다.
	
	Statement 종류
	1. Statement
		- 기본
	
	2. PreparedStatement
		- 인자값과 관련된 작업이 특화
		- 코드 안정성 높음. 가독성 높음 
		- 코드량 많음.
	-------------------------------------- 텍스트 쿼리 용도
	3. CallableStatement
		- 프로시저 전용 Statement 
	-------------------------------------- 프로시저 용도 
	
	*/
	
	//localhost > hr > 
	public static void main(String[] args) {
		//1. 접속
		Connection conn = null;
		
		try {
			// 1. 접속
			conn = DBUtil.open();
			
			// 2. 질의 - 문장 종결자(;) 사용 불가능 
			String sql = "INSERT INTO tbladdress (seq, name, age, tel, address, regdate) VALUES (address_seq.nextval, '후후후', 20, '010-1111-1111', '서울시', default)";
			
			// 2. Statement 객체 생성
			Statement stat = conn.createStatement();
			
			// 반환값이 없는 쿼리
			// - stat.executeUpdate()
			
			// 반환값이 있는 쿼리 
			// - stat.executeQuery()
			
			stat.executeUpdate(sql); // DataGrip : Ctrl + Enter 동일 -> JDBC 오토 커밋 (모든 DML 쿼리를 날릴때마다 오토커밋)
			
			// 3. 종료
			stat.close();
			conn.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	
}
