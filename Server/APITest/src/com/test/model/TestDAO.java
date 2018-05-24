package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.model.sql.DBUtil;


public class TestDAO {
Connection conn;
	
	public TestDAO() {
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("TestDAO.Constructor" + e.toString());
		}
	}

	public int checknpush(String id, String name) {
		try {
			
			String sql = "SELECT count(*) FROM tbl_naver WHERE id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			ResultSet rs = pstat.executeQuery();
			
			int result = 0;
			
			if (rs.next()) {
				
				result = rs.getInt(1);
				
			}
			
			if (result == 1) {
				
				return 0;
			} else {
				sql = "INSERT INTO tbl_naver VALUES (naver_seq.nextval, ?, ?)";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, id);
				pstat.setString(2, name);
				
				
				return pstat.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
}
