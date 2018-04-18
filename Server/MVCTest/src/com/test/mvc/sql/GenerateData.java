package com.test.mvc.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class GenerateData {
	public static void main(String[] args) {
		
		// 더미 데이터
		Connection conn = DBUtil.open();
		
		PreparedStatement stat = null;
		
		try {
			
			String sql = "INSERT INTO tblBoard VALUES (board_seq.nextval, ?, '내용입니다잉', ?, DEFAULT, DEFAULT, 'n')";
			
			stat = conn.prepareStatement(sql);
			
			String[] subject = {
				"질문받는다.", "이거 실화인거 ㄹㅇ?", "아니 형님들", "헬로 방가방가", "안녕하세염 방가워염", "온라인 바카라 최대 1000만원", "앙금모띠~", "ㅄ", "신입받아라", "국비다닌다 질문받는다."	
				
			};
			
			String[] id = {"hong", "test", "cat", "dog", "admin"};
			
			Random rnd = new Random();
			
			for (int i = 0; i < 500; i++) {
				
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, id[rnd.nextInt(id.length)]);
				
				stat.executeUpdate();
				System.out.printf("%d insert.. \n", i);
			}
			
			
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
