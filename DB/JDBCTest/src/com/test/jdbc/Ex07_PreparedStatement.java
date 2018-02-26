package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex07_PreparedStatement {
	public static void main(String[] args) {
		
		// Ex07_PreparedStatement.java
		
		// Statement -> PreparedStatement
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		// INSERT 작업 + 사용자 입력 
		String name = "홍길동's house";
		String age = "20";
		String tel = "010-5555-5555";
		String address = "서울시 강남구";
		
		try {
			conn = DBUtil.open();
			
			// 1. Statement
			stat = conn.createStatement();
			
			// 1. a SQL 작성
			String sql = String.format("INSERT INTO tbladdress VALUES (address_seq.nextval, '%s', %s, '%s', '%s', default)", name, age, tel, address);
			
			// 1. b SQL 실행
			// stat.executeUpdate(sql);
			
			// 1. c 마무리
			stat.close();
			System.out.println("실행 완료");
			
			// 2. PreparedStatement
			// - Statement 비교
			//  a. SQL 작성이 쉽다. (매개변수를 ? 로 처리)
			//  b. 값으로 적당하지 않은 모든 것들을 미리 유효하게 전처리(')
			//  c. Statement 보단 코드량이 증가
			
			// 매개변수가 없는 질의 : Statement
			// 매개변수가 있는 질의 : PreparedStatement
			
			// Statement : 정적 쿼리 실행 객체
			// PreparedStatement : 동적 쿼리 실행 객체 
			
			// 2. a SQL 작성
			// - ? : 오라클의 매개변수 표현
			sql = "INSERT INTO tbladdress VALUES (address_seq.nextval, ?, ?, ?, ?, default)";
			
			// 2. b 객체 생성 -> 매개변수값 넣기
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, name);
			pstat.setString(2, age);
			pstat.setString(3, tel);
			pstat.setString(4, address);
			
			// 2. c SQL 실행
			pstat.executeUpdate();
			
			System.out.println("완료.");
			pstat.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
