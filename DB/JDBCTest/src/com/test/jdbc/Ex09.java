package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import oracle.jdbc.OracleTypes;

public class Ex09 {
	public static void main(String[] args) {
		
		// 조건부 셀렉트
		// 1. 성별
		// 2. 부서
		// 3. 지역
		// -------------------------- 텍스트 쿼리 
		// -> 목록 반환 -> 출력
		// -------------------------- 프로시저 
		
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[직원 검색]");
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "SELECT * FROM vw_gender ORDER BY gender ASC";
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			
			System.out.println("*** 성별을 선택하세요.");
			
			while (rs.next()) {
				System.out.printf("%s. %s\n", rs.getString("gender"), rs.getString("gender_name"));
			}
			rs.close();
			
			System.out.print("선택 : ");
			String selGender = scan.nextLine();
			
			// 부서 선택
			System.out.println();
			System.out.println("*** 부서를 선택해주세염");
			
			sql = "SELECT * FROM vw_buseo ORDER BY buseo ASC";
			rs = stat.executeQuery(sql);
			
			ArrayList<HashMap<String, Integer>> buseo = new ArrayList<HashMap<String, Integer>>();
			
			int n = 1;
			while (rs.next()) {
				//System.out.println(rs.getString("buseo"));
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put(rs.getString("buseo"), n);
				buseo.add(map);
				n++;
			}
			
			for (HashMap<String, Integer> m : buseo) {
				System.out.printf("%s. %s\n", 
								  m.get(m.keySet().toArray()[0].toString())
								  , m.keySet().toArray()[0]);
			}
			System.out.print("선택 : ");
			String selBuseo = scan.nextLine();
			
			// 지역 선택
			sql = "SELECT * FROM vw_city ORDER BY city ASC";
			
			HashMap<Integer, String> city = new HashMap<Integer, String>();
			rs = stat.executeQuery(sql);
			n = 1;
			
			while (rs.next()) {
				city.put(n, rs.getString("city"));
				n++;
			}
			rs.close();
			
//			Set<Integer> set = city.keySet(); // set은 순서가 없음 
//			Iterator<Integer> iter = set.iterator();
//			
//			while(iter.hasNext()) {
//				System.out.println(iter.next());
//			}
			
			Set<Integer> set = city.keySet();
			List<Integer> list = new ArrayList(set);
			// Collections.sort(list);
//			list.sort(new Comparator<Integer>() {
//				
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//				
//			});
			
			list.sort((o1, o2) -> o1 - o2);
			
			//System.out.println(list);
			System.out.println("*** 지역 선택 ㄱㄱ");
			for (int key : list) {
				System.out.printf("%d. %s\n",
								  key,
								  city.get(key));
			}
			System.out.print("선택 : ");
			String selCity = scan.nextLine();
			
			
			// 출력 
			sql = "{ call proc_list_insa(?, ?, ?, ?) }";
			CallableStatement cstat = conn.prepareCall(sql);
			
			// IN
			cstat.setString(1, selGender);
			//System.out.println(selGender);
			// map의 특정 값의 키값을 얻어오기
			// map.put("기획부", 1);
			// map.put("영업부", 2);
			// map.put("총무부", 3);
			// 선택 : 2
			// 반환 : 영업부
			for (HashMap<String, Integer> m : buseo) {
				String tempKey = m.keySet().toArray()[0].toString(); // 부서명
				int tempValue = m.get(tempKey);
				
				if (tempValue == Integer.parseInt(selBuseo)) {
					// System.out.println(tempKey);
					selBuseo = tempKey;
					break;
				}
			}
			cstat.setString(2, selBuseo);
			//System.out.println(selBuseo);
			
			cstat.setString(3, city.get(Integer.parseInt(selCity)));

		
			cstat.registerOutParameter(4, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(4);
		
			System.out.println("\n[검색 결과]");
			while (rs.next()) {
				System.out.printf("%s - %s - %s - %s",
								 rs.getString("name"),
								 rs.getString("ssn"),
								 rs.getString("buseo"),
								 rs.getString("city"));
			}
			rs.close();
			
			stat.close();
			cstat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
