package com.test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex10 {
	public static void main(String[] args) {
		// Ex10_Transaction.java
		// 트랜잭션 처리
		// 1. 오라클
		//	 a. 스크립트 작업 중 사용자가 직접 COMMIT or ROLLBACK
		//   b. 프로시저 내에서 
		//		- 논리 업무를 하나로 묶기 위한 작업에 사용
		// 2. 자바
		//   - 개발자가 원하는 SQL들을 마음대로 묶을 수 있다.
		//   - Connection 클래스 사용
		//   - 단, 텍스트 쿼리에 한해서.. (프로시저 제외)
		//   - 트랜잭션 설정은 반드시 질의를 하기 전에 설정해야 한다. ( + Statement 만들기 전)
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			// update -> insert
			conn = DBUtil.open();
			conn.setAutoCommit(false); // 자동 커밋 설정 - 사용자가 직접 트랜잭션을 처리하겠다.
			stat = conn.createStatement();
			
			// 첫번째 업무(성공)
			String sql = "UPDATE tblinsa SET city = '제주' WHERE name = '홍길동'";
			stat.executeUpdate(sql); // 자동 커밋
			
			// 두번째 업무(실패)
			sql = "UPDATE tblinsa SET city = '제주제주제주' WHERE name = '이순신'";
			stat.executeUpdate(sql); // 자동 커밋
			
			stat.close();
			
			conn.commit(); // 수동 커밋 
			
			conn.close();
			
			System.out.println("완료");
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			try {
				conn.rollback(); // 수동 롤백 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
