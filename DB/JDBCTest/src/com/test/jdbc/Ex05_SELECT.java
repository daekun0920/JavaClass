package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Ex05_SELECT {
	
	public static void main(String[] args) {
		
		// Ex05_SELECT.java
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
	}
	private static void m9() {
		
		// rowcount = executeUpdate()
		// resultset = executeQuery()
		
		// tblinsa 기획부
		// 1. 몇명?
		// 2. 목록?
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			// 자신이 가지고 있는 데이터의 총 갯수를 미리 알 수 없다.
			// 스트림
			// 컬렉션 : 이터레이터
			// 결과셋
			
			// 1. 몇명?
			String sql = "SELECT * FROM tblinsa WHERE buseo = '기획부'";
			ResultSet rs = stat.executeQuery(sql);
			
			int count = 0;
			
			while (rs.next()) {
				count++;
			}
			rs.close(); // ResultSet 쓴다음에 재사용시엔 자원관리를 위하여 꼭 바로 닫아준다
			// stat.close() 닫으면 안됨 
			
			System.out.println(count);
			
			// 1. 몇명?
			sql = "SELECT count(*) as cnt FROM tblinsa WHERE buseo = '기획부'";
			// Statement 객체는 여러번 질의 가능 
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("cnt"));
				System.out.println(rs.getString(1));
			}
			rs.close(); // ResultSet 쓴다음에 재사용시엔 자원관리를 위하여 꼭 바로 닫아준다
			
			// 2. 목록
			sql = "SELECT * FROM tblinsa WHERE buseo = '기획부'";
			// ResultSet rs2 = stat.executeQuery(sql); // ResultSet 닫기가 헷갈리면 다시 만들어도 된다.
			rs = stat.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[부서]\t[직위]");
			
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n",
								  rs.getString("num"),
								  rs.getString("name"),
								  rs.getString("buseo"),
								  rs.getString("jikwi"));
			}
			
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	private static void m8() {
		
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtil.open();
				stat = conn.createStatement();
				
				// 시퀄(Sequel)
				String sql = "SELECT * FROM tblinsa";
				rs = stat.executeQuery(sql);
				
				// cursor = BOF
				if (rs.next()) {}
				if (rs.next()) {}
				if (rs.next()) {
					System.out.println(rs.getString("name"));
				}
				
				// 전진 커서
				// - 한번 지나간 레코드를 다시 읽기 불가능
				// - 다시 읽고 싶으면 ResultSet을 다시 열기 -> 커서가 다시 BOF 로 이동
				rs = stat.executeQuery(sql);
				if (rs.next()) {
					System.out.println(rs.getString("name"));
				}
				
				
				rs.close();
				stat.close();
				conn.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		
	
		
	}
	
	private static void m7() {
		
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtil.open();
				stat = conn.createStatement();
				
				String sql = "SELECT * FROM tblinsa WHERE num = 1001";
				rs = stat.executeQuery(sql);
				
				// 단일 레코드 -> if (rs.next()) {}
				// 다중 레코드 -> while (rs.next()) {}
				if (rs.next()) {
					// 1. 컬럼값 취하기
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("basicpay"));
					
					// 2. 레코드(컬럼) 정보 가져오기
					ResultSetMetaData rsmd = rs.getMetaData();
					System.out.println(rsmd.getColumnCount()); // 결과셋의 컬럼 개수 
					
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.println(rs.getString(i));
					}
					
					// 컬럼 index -> 컬럼명 반환 
					System.out.println(rsmd.getColumnLabel(1));
					System.out.println(rsmd.getColumnLabel(2));
					
					// 컬럼 index -> 컬럼 자료형 반환
					System.out.println(rsmd.getColumnTypeName(1));
					System.out.println(rsmd.getColumnTypeName(2));
					
					// 컬럼 사이즈
					System.out.println(rsmd.getColumnDisplaySize(2));
					
				}
			
				rs.close();
				stat.close();
				conn.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		
	}
	private static void m6() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "SELECT * FROM tblinsa";
			rs = stat.executeQuery(sql);
			
//			rs.next();
//			System.out.println(rs.getString("name"));
			
//			rs.next();
//			System.out.println(rs.getString("name"));
			
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
	private static void m5() {
		
		// 단일행, 여러 컬럼 반환 받기
		// : tblinsa.num 입력 -> 정보 출력
		// : SELECT * FROM tblinsa WHERE num = 1001;
		String num = "1001"; // 홍길동
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			// Join을 하면 자연스럽게 중복 컬럼명 발생 -> 반드시 Alias 추가 -> 유일하게..
			String sql = "SELECT m.name as mname, w.name as wname FROM tblmen m INNER JOIN tblwomen w ON m.couple = w.name";
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("mname"));
				System.out.println(rs.getString("wname"));
			} else {
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void m4() {
		
		// 단일행, 여러 컬럼 반환 받기
		// : tblinsa.num 입력 -> 정보 출력
		// : SELECT * FROM tblinsa WHERE num = 1001;
		String num = "1001"; // 홍길동
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "SELECT i.*, basicpay + sudang as 총급여 FROM tblinsa i WHERE num = " + num;
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				// 컬럼 여러개..
				String name = rs.getString("name");
				String buseo = rs.getString("buseo");
				String jikwi = rs.getString("jikwi");
				String basicpay = rs.getString("basicpay");
				String total = rs.getString("총급여");
				
				System.out.println(name);
				System.out.println(buseo);
				System.out.println(jikwi);
				System.out.println(basicpay);
				System.out.println(total);
				
			} else {
				System.out.printf("직원 번호 %s인 직원은 존재하지 않습니다.\n", num);
			}
			
		} catch (Exception e) {
			System.out.println("오류 ㅋㅋ");
		}
	}
	private static void m3() {
		
		// 날짜 /시간형 반환받기
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "SELECT min(completedate) as cdate FROM tbltodo";
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				// 보통 JDBC에서는 오라클의 Date를 취할 때 문자열로 가져온다. -> 자바로 가져오면 출력하는 경우가 대부분
				//Date cdate = rs.getDate("cdate");
	
				// System.out.printf("%tF %tT\n", cdate, cdate); // 연월일, 시분초 -> 시분초가 00:00:00 -> 안나옴 
				// 2018-01-01 18:30:00
				String cdate = rs.getString("cdate");
				System.out.println(cdate.split(" ")[0]);
				System.out.println(cdate.split(" ")[1]);
				
				
				
				// [오라클] -> [자바]
				// number      getInt() : 추가 산술 연산 필요
				// 			   getDouble() : 추가 산술 연산 필요 
				//			   getString() : 추가 산술 연산 필요 없음
				// varchar2    getString()
				// date		   getString() : 일반적으로..
				// 			   getDate() : 추가 작업 필요시..
				
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	private static void m2() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "SELECT name FROM tblinsa WHERE basicpay = (SELECT max(basicpay) FROM tblinsa) AND rownum = 1";
			
			rs = stat.executeQuery(sql);
			
//			rs.next();
//			
//			rs.getString(1);
//			rs.getString("name");
//			
//			String name = rs.getString("name");
//			System.out.println(name);
//			
//			rs.next(); // EOF 
//			
//			name = rs.getString("name"); // java.sql.SQLException: 결과 집합을 모두 소모했음
//			
//			System.out.println(name);
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			} else {
				System.out.println("데이터 음슴");
			}
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			} else {
				System.out.println("데이터 음슴");
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
		
	}
	private static void m1() {
		
		// 단일값 반환하기
		// : SELECT -> 1행 1열 -> 단일값 1개(숫자)  
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			if(!conn.isClosed()) {
				
				stat = conn.createStatement();
				// String sql = "SELECT count(*) FROM tbladdress";
				String sql = "SELECT name FROM tbladdress WHERE seq = 22";
				
				// executeUpdate() vs executeQuery()
				rs = stat.executeQuery(sql); // Ctrl + Enter
				
				// ResultSet -> 탐색
				// : 1행 1열짜리 테이블
				rs.next(); // 전진 커서 
				// int total = rs.getInt(1); // 컬럼 인덱스 혹은 컬럼 명 
				String total = rs.getString(1); // "아무개", "6"
				
				System.out.println(total);
				
				rs.close();
				stat.close();
				conn.close();
			} else {
				System.out.println("DB 접속이 원활하지 않습니다. 관리자에게 연락..");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
}
