package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;

import oracle.jdbc.internal.OracleTypes;

public class Ex08_CallableStatement {
	public static void main(String[] args) {
		// Ex08_CallableStatement.java
		
		// 1. Statement : 정적 쿼리 실행
		// 2. PreparedStatement : 동적 쿼리 실행
		// 3. CallableStatement : 프로시저 호출 전용
		
		// SELECT * FROM tblinsa WHERE buseo = 입력값;
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		m8();
	}
	private static void m8() {
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			conn = DBUtil.open("localhost", "han", "java1234");
			
			String sql = "{ call proc_grade_test_status(?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setInt(1, 1);
			stat.setString(2, "없음");
			stat.registerOutParameter(3, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(3);
			
			while(rs.next()) {
				System.out.println(rs.getString("과목명") + "-" + rs.getString("과목시작날짜") + "-" + rs.getString("과목종료날짜") + "-" + rs.getString("선생님성함") + "-" + rs.getString("성적등록여부") + "-" + rs.getString("시험날짜등록여부"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	private static void m7() {
		Connection conn = null;
		CallableStatement stat = null;
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_listbuy(?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setInt(1, 5);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "-" + rs.getString("item") + "-" + rs.getString("qty") + "-" + rs.getString("regdate"));
			}	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	private static void m6() {
		
		Connection conn = null;
		CallableStatement stat = null;
		Random random = new Random();
		
		try {
			String[] names = {"홍길동", "아무개", "하하하", "테스트", "호호호"};
			String[] items = {"키보드", "마우스", "모니터", "프린터"};
			
			conn = DBUtil.open();
			String sql = "{ call proc_addbuy(?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			
			for (int i = 0 ; i < 100; i++) {
				stat.setString(1, names[random.nextInt(names.length)]);
				stat.setString(2, items[random.nextInt(items.length)]);
				stat.setInt(3, random.nextInt(10));
				
				stat.executeUpdate();
			}
			System.out.println("완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void m5() {
		// 5. 전화번호 일부 입력 -> 직원 명단을 출력(이름, 부서, 직위, 전화번호)
		// 번호 입력 : 123
		// proc_m5(?, ?)
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m5(?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "123");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "-" + rs.getString("buseo") + "-" + rs.getString("jikwi") + "-" + rs.getString("tel"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void m4() {
		// 4. 커서 반환
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m4(?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "서울");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				System.out.println(rs.getString("name") + "-" + rs.getString("buseo"));
			}
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	private static void m3() {
		// 3. 반환값 O
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
//			String sql = "{ call proc_m3(?) }";
//			stat = conn.prepareCall(sql);
//			
//			// out 매개변수 등록
//			stat.registerOutParameter(1, OracleTypes.INTEGER); // OUT 변수 생성
//			
//			stat.executeQuery(); // out 변수 채우기 
//			
//			// ?
//			int count = stat.getInt(1); // OUT 변수값 접근 
//			
//			System.out.println(count);
			
//			String sql = "{ call proc_m3(?, ?, ?) }";
//			stat = conn.prepareCall(sql);
//			
//			stat.registerOutParameter(1, OracleTypes.VARCHAR); // pname
//			stat.registerOutParameter(2, OracleTypes.INTEGER); // page
//			stat.registerOutParameter(3, OracleTypes.VARCHAR); // ptel
//			
//			stat.executeQuery();
//			
//			System.out.println(stat.getString(1));
//			System.out.println(stat.getInt(2));
//			System.out.println(stat.getString(3));
			
			String sql = "{ call proc_m3(?, ?, ?, ?) }";
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "64"); // pseq 
			stat.registerOutParameter(2, OracleTypes.VARCHAR); // pname
			stat.registerOutParameter(3, OracleTypes.INTEGER); // page
			stat.registerOutParameter(4, OracleTypes.VARCHAR); // ptel
			
			stat.executeQuery();
			
			System.out.println(stat.getString(2));
			System.out.println(stat.getInt(3));
			System.out.println(stat.getString(4));
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	private static void m2() {
		
		// 2. 매개변수X, 반환값X
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m2 }";
			stat = conn.prepareCall(sql);
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			System.out.println("tbladdress 초기화 완료");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	private static void m1() {
		
		// 1. 반환값이 없는 SQL(프로시저)
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call proc_m1(?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "아무개");
			stat.setInt(2, 25);
			stat.setString(3, "010-5555-5555");
			stat.setString(4, "서울시 강남구 대치동");
			
			stat.executeUpdate();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
}
