package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_Statement {
	
	public static void main(String[] args) {
		
		// Ex04_Statement.java
		// 고정값 -> 입력값
		
		Connection conn = null;
		Statement stat = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
//			System.out.println("이름 : "); String name = scan.nextLine();
//			System.out.println("나이 : "); String age = scan.nextLine();
//			System.out.println("전화 : "); String tel = scan.nextLine();
//			System.out.println("주소 : "); String address = scan.nextLine();
			
			// 자바의 자료형 <-> 오라클의 자료형
			// - 언어나 환경이 다르면 자료형은 아무 의미가 없y다.
			// - 호환성 0%
			
			// SQL 작성
			// String sql = String.format("INSERT INTO tbladdress (seq, name, age, tel, address, regdate) VALUES (address_seq.nextval, '%s', %s, '%s', '%s', default)", name, age, tel, address); 
			
			// String sql = "DELETE FROM tbladdress WHERE seq = 41"; 
			// String sql = "UPDATE tbladdress SET age = 32 WHERE seq = 21";
			// String sql = "CREATE TABLE tblhong (seq number primary key, data varchar2(100) not null)";
			String sql = "DROP TABLE tblhong";
			
			int result = stat.executeUpdate(sql); // 적용된 행 갯수 반환 = // SELECT를 제외한 모든 쿼리 실행하는 법
			
			if (result >= 1) {
				System.out.println("승공");	
			} else if (result == 0) {
				System.out.println("슬패");
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
