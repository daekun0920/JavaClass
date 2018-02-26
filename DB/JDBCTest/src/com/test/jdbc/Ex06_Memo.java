package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex06_Memo {
	
	private static Scanner scan;
	private static Connection conn;
	private static Statement stat;
	
	static {
		scan = new Scanner(System.in);
		conn = DBUtil.open();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 메모장
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("===============================");
			System.out.println("    메모장");
			System.out.println("===============================");
			System.out.println("    1. 메모 쓰기");
			System.out.println("    2. 메모 읽기");
			System.out.println("    3. 메모 삭제");
			System.out.println("    4. 메모 검색");
			System.out.println("    5. 종료");
			System.out.println("    선택 : ");
			int input = scan.nextInt();
			scan.skip("\r\n");
			// scan.nextLine();
			
				try {
					if (input == 1) addMemo();
					else if (input == 2) listMemo();
					else if (input == 3) delMemo();
					else if (input == 4) searchMemo();
					else loop = false;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("관리자에게 연락 ㄱㄱ싱");
				}
			
		} // while
		System.out.println("메모장을 종료합니다.");
		
		try {
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("관리자에게 연락 ㄱㄱ싱");
		}
		
		
	}
	
	private static void addMemo() throws SQLException {
		System.out.println("[메모 추가]");
		
		System.out.println("작성자 : ");
		String name = scan.nextLine();
		name = name.replace("'", "''"); // 쿼리 오류방지 치환 
		
		System.out.println("메모 내용 : ");
		String memo = scan.nextLine();
		memo = memo.replace("'", "''");
		
		System.out.println("우선 순위 (1. 높음, 2. 중간, 3. 낮음) : ");
		String priority = scan.nextLine();
		
		String sql = String.format("INSERT INTO tblmemo VALUES (memoseq.nextval, '%s', '%s', default, %s)", name, memo, priority);
		System.out.println(sql);
		int result = stat.executeUpdate(sql);
		
		if (result == 1) {
			System.out.println("추가 완료");
		} else {
			System.out.println("추가 실패");
		}
		scan.nextLine();
	}
	
	private static void listMemo() throws SQLException {
		System.out.println("[메모 읽기]");
		
		String sql = "SELECT seq, name, to_char(regdate, 'hh24:mi:ss') as regdate, CASE WHEN priority = 1 THEN '높음' WHEN priority = 2 THEN '앵간' WHEN priority = 3 THEN '낮음' END as priority, memo FROM tblmemo ORDER BY seq DESC";
		
		ResultSet rs = stat.executeQuery(sql);
		
		System.out.println("[번호]\t[작성자]\t[작성시간]\t\t[우선순위]\t[메모]");
		
		while (rs.next()) {
			System.out.printf("%s\t%s\t\t%s\t%s\t\t%s\n",
							  rs.getString("seq"),
							  rs.getString("name"),
							  rs.getString("regdate"),
							  rs.getString("priority"),
							  rs.getString("memo"));
		}
		
		rs.close();
		
		System.out.println("출력 완료.");
		scan.nextLine();
		
	}
	
	private static void delMemo() throws SQLException {
		
		System.out.println("[메모 삭제]");
		
		System.out.println("삭제할 메모 번호 : ");
		String seq = scan.nextLine();
		
		String sql = "DELETE FROM tblmemo WHERE seq = " + seq;
		
		int result = stat.executeUpdate(sql);
		
		if (result == 1) {
			System.out.println("삭제 ㅇㅋ");
		} else { 
			System.out.println("삭제 ㄴㄴ");
		}
	}
	
	private static void searchMemo() throws SQLException {
		System.out.println("[메모 검색]");
		
		System.out.println("검색어 : ");
		String word = scan.nextLine();
		
		//String sql = "SELECT seq, name, to_char(regdate, 'hh24:mi:ss') as regdate, CASE WHEN priority = 1 THEN '높음' WHEN priority = 2 THEN '앵간' WHEN priority = 3 THEN '낮음' END as priority, memo "
				//+ "FROM tblmemo WHERE upper(memo) like '%' || upper('" +  word + "') || '%' ORDER BY seq DESC";
		
		String sql = String.format("SELECT seq, name, to_char(regdate, 'hh24:mi:ss') as regdate, CASE WHEN priority = 1 THEN '높음' WHEN priority = 2 THEN '앵간' WHEN priority = 3 THEN '낮음' END as priority, memo "
							     + "FROM tblmemo WHERE memo like '%%%s%%' ORDER BY seq DESC", word); // % 이스케이프
		
		ResultSet rs = stat.executeQuery(sql);
		
		System.out.println("[번호]\t[작성자]\t[작성시간]\t\t[우선순위]\t[메모]");
		
		while (rs.next()) {
			System.out.printf("%s\t%s\t\t%s\t%s\t\t%s\n",
							  rs.getString("seq"),
							  rs.getString("name"),
							  rs.getString("regdate"),
							  rs.getString("priority"),
							  rs.getString("memo"));
		}
		
		rs.close();
		
		System.out.println("출력 완료.");
		scan.nextLine();
		
		
		
		
	}
}
