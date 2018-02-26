package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class JDBC_questions {
	public static void main(String[] args) {
		//q1();
		//q2();
		//q3();
		q4();
		//q5();
	}
	private static void q5() {
		Connection conn = null;
		CallableStatement stat = null;
		Statement state = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			conn = DBUtil.open();
			String sqlSub = "SELECT count(*) FROM tbl_point";
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(sqlSub);
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			for (int i = 1; i <= count; i++) {
				String sql = "{ call proc_distance(?, ?) }";
				
				stat = conn.prepareCall(sql);
				
				stat.setInt(1, i);
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				
				stat.executeQuery();
				
				rs = (ResultSet)stat.getObject(2);
				
				while (rs.next()) {
					String distance = "";
					if (rs.getString(3).startsWith(".")) {
						distance = "0" + rs.getString(3);
					} else {
						distance = rs.getString(3);
					}
					
					//System.out.println(rs.getString(1) + "에서 " + rs.getString(2) + "까지 " + distance + "입니다.");
					list.add(rs.getString(1) + "에서 " + rs.getString(2) + "까지 " + distance + "입니다.");
				}
				
			}
			
			
			list.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
				
			});
			for (String line : list) {
				System.out.println(line);
			}
			rs.close();
			stat.close();
			state.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}
	private static void q4() {
		/*
		  =======================================================================

			문제4.
			<<요구사항>> 부서별 비상 연락망을 만드시오.
			
			<<조건>>
			1. 부서별 출력
			2. 부서내 직원명 오름차순으로 연결
			
			<<입출력>>
			[개발부]
			김신애 ▷ 엄용수 ▷ 이기상 ▷ 이기자 ▷ 이미성 ▷ 이상헌 ▷ 이성길 ▷ 이순애 ▷ 임수봉 ▷ 장인철 ▷ 정영희 ▷ 채정희 ▷ 홍길남 ▷ 황진이 (종료)
			[기획부]
			권옥경 ▷ 김말자 ▷ 김신제 ▷ 이영숙 ▷ 이정석 ▷ 지재환 ▷ 홍길동 (종료)
			[영업부]
			고순정 ▷ 권영미 ▷ 김미나 ▷ 김숙남 ▷ 김인수 ▷ 김정훈 ▷ 김종서 ▷ 산마루 ▷ 손인수 ▷ 양미옥 ▷ 우재옥 ▷ 유관순 ▷ 전용재 ▷ 정한나 ▷ 지수환 ▷ 홍원신 (종료)
			[인사부]
			나윤균 ▷ 박문수 ▷ 박세열 ▷ 이남신 (종료)
			[자재부]
			김싱식 ▷ 문길수 ▷ 심심해 ▷ 유영희 ▷ 이미경 ▷ 이재영 (종료)
			[총무부]
			김말숙 ▷ 김영길 ▷ 이순신 ▷ 이현숙 ▷ 정정해 ▷ 한석봉 ▷ 허경운 (종료)
			[홍보부]
			김영년 ▷ 이미인 ▷ 정상호 ▷ 정한국 ▷ 조미숙 ▷ 최석규 (종료)
			
			<<테이블>>
			tblinsa
			
			<<프로시저>>
			CREATE OR REPLACE PROCEDURE proc_mergency(
				구현
			)
			IS
			BEGIN
				구현
			END;
			
			=======================================================================
		 
		 */
		
		Connection conn = null;
		CallableStatement stat = null;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			conn = DBUtil.open();
			String sql = "SELECT distinct buseo FROM tblinsa";
			stat = conn.prepareCall(sql);
			
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			rs.close();
			list.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
				
			});
			sql = "{ call proc_mergency(?, ?) }";
			stat = conn.prepareCall(sql);
			for(int i = 0; i < list.size(); i++) {
				
				stat.setString(1, list.get(i));
				stat.registerOutParameter(2, OracleTypes.CURSOR);
				
				stat.executeQuery();
				
				rs = (ResultSet)stat.getObject(2);
				System.out.printf("[%s]\n", list.get(i));
				while (rs.next()) {
					System.out.print(rs.getString("name") + " ▷ ");
				}
				System.out.print("(종료)\n");
				
			}
			rs.close();
			scan.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private static void q3() {
		/*
		 =======================================================================

			문제3.
			<<요구사항>> 카테고리 탐색을 구현하시오.
			
			<<입출력>>
			[대분류]
			1. 전자제품
			2. 식음료
			3. 운동용품
			선택 : 1
			
			[중분류]
			1. 모니터
			2. 마우스
			3. 키보드
			선택 : 1
			
			[소분류]
			1. 소형
			2. 중형
			3. 대형
			선택 : 3
			
			[상품]
			7. LG300(수량 : 72개)
			8. Dell300(수량 : 23개)
			9. HP300(수량 : 22개)
		=========================================================================	
		 */
		Connection conn = null;
		CallableStatement stat = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			conn = DBUtil.open();
			
			String sql = " { call proc_list_big_category(?) } ";
			
			stat = conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(1);
			System.out.println("[대분류]");
			while (rs.next()) {
				System.out.println(rs.getString("seq") + ". " + rs.getString("name"));
			}
			rs.close();
			System.out.print("입력 : ");
			String sel = scan.nextLine();
			
			sql = " { call proc_list_middle_category(?, ?) } ";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("[중분류]");
			while (rs.next()) {
				System.out.println(rs.getString("seq") + ". " + rs.getString("name"));
			}
			rs.close();
			System.out.print("입력 : ");
			sel = scan.nextLine();
			
			sql = " { call proc_list_small_category(?, ?) } ";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("[소분류]");
			while (rs.next()) {
				System.out.println(rs.getString("seq") + ". " + rs.getString("name"));
			}
			rs.close();
			System.out.print("입력 : ");
			sel = scan.nextLine();
			
			sql = " { call proc_list_product(?, ?) } ";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, sel);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("[상품]");
			while (rs.next()) {
				System.out.println(rs.getString("seq") + ". " + rs.getString("name")+ "-" + rs.getString("qty"));
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}
	
	private static void q2() {
		/*
		=========================================================================
		문제2.
		<<요구사항>> 직원 번호를 입력하면 조직도를 출력하시오.

		<<입출력>>
		직원 번호 입력 : 101
		Neena Kochhar(515.123.4568)
		        ▷ Nancy Greenberg(515.124.4569)
		                ▷ Daniel Faviet(515.124.4169)
		                ▷ John Chen(515.124.4269)
		                ▷ Ismael Sciarra(515.124.4369)
		                ▷ Jose Manuel Urman(515.124.4469)
		                ▷ Luis Popp(515.124.4567)
		        ▷ Jennifer Whalen(515.123.4444)
		        ▷ Susan Mavris(515.123.7777)
		        ▷ Hermann Baer(515.123.8888)
		        ▷ Shelley Higgins(515.123.8080)
		                ▷ William Gietz(515.123.8181)

		<<테이블>>
		employees

		<<프로시저>>
		CREATE OR REPLACE PROCEDURE proc_employees(
			구현
		)
		IS
		BEGIN
			구현
		END;

		=======================================================================

		SELECT seq, lpad(' ', (level - 1) * 6) || name, prior name 
		    FROM tblcomputer
		        START WITH seq = 1
		            CONNECT BY PRIOR seq = pseq;

		*/
		
	Connection conn = null;
	CallableStatement stat = null;
	Scanner scan = new Scanner(System.in);
	try {
		conn = DBUtil.open();
		
		System.out.print("직원 번호점여 : ");
		String id = scan.nextLine();
		
		String sql = "{ call proc_employees(?, ?) }";
		stat = conn.prepareCall(sql);
		
		stat.setString(1, id);
		stat.registerOutParameter(2, OracleTypes.CURSOR);
		
		stat.executeQuery();
		
		ResultSet rs = (ResultSet)stat.getObject(2);
		
		while (rs.next()) {
			System.out.println(rs.getString("result"));
		}
		
		rs.close();
		stat.close();
		conn.close();
	} catch (Exception e) {
		System.out.println(e.toString());
	}
		
	}
	private static void q1() {
				/*
				=======================================================================

				문제1.
				<<요구사항>> 아이디 중복 검사를 구현하시오.

				<<입출력>>
				아이디 입력 : hong
				이미 사용중입니다.
				아이디 입력 : test
				이미 사용중입니다.
				아이디 입력 : bbb
				사용이 가능합니다.

				<<테이블>>
				CREATE TABLE tblauth
				(
					id VARCHAR2(50) PRIMARY KEY --아이디
				);

				INSERT INTO tblauth VALUES ('hong');
				INSERT INTO tblauth VALUES ('test');
				INSERT INTO tblauth VALUES ('aaa');

				<<프로시저>>
				CREATE OR REPLACE PROCEDURE proc_auth(
					구현
				)
				IS
				BEGIN
					구현
				END;

				=======================================================================
				*/
		Connection conn = null;
		CallableStatement stat = null;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("아이디 입력 ㄱㄱ : ");
			String id = scan.nextLine();
			
			try {
				conn = DBUtil.open();
				
				
				String sql = "{ call proc_auth(?, ?) }";
				
				stat = conn.prepareCall(sql);
				stat.setString(1, id);
				stat.registerOutParameter(2, OracleTypes.INTEGER);
				
				stat.executeQuery();
				
				int result = stat.getInt(2);
				
				if (result == 1) {
					System.out.println("이미 사용중입니다.");
				} else {
					System.out.println("쓸수있음");
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			scan.close();
			
			try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
