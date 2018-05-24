package com.enter.promotion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.enter.sql.DBUtil;

public class PromotionDAO {
	Connection conn;

	public PromotionDAO() {
		try {
			
			// ds = new DataSource();
			
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("PromotionDAO.Constructor" + e.toString());
		}
	}
	
	public String loadfilenames(String profseq) {
		String sql = "SELECT star_list_file, star_list_orgfile FROM tbl_star_list WHERE star_profile_seq = ?";
		
		try {
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, profseq);
			
			ResultSet rs = pstat.executeQuery();
			
			String filename = "";
			
			if (rs.next()) {
		
				filename = rs.getString("star_list_file");
				
			}
			
			conn.close();
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
		
	}

	public void putFiles(String filename, String orgfilename, String profileseq) {
		try {
			String sql = "SELECT count(*) FROM tbl_star_list WHERE star_profile_seq = ?"; 
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, profileseq);
			
			ResultSet rs = pstat.executeQuery();
			int check = 0;
			
			if (rs.next()) {
				
				check = rs.getInt(1);
				
			}
			
			if (check == 0) {
				sql = "INSERT INTO tbl_star_list VALUES (star_list_seq.nextval, ?, ? ,?, ?)";
					
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, "2");
				pstat.setString(2, filename);
				pstat.setString(3, orgfilename);
				pstat.setInt(4, 1);
				
				
				pstat.executeUpdate();
			} else {
				sql = "UPDATE tbl_star_list SET star_list_file = ?, star_list_orgfile = ? WHERE star_profile_seq = ?";
				
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, filename);
				pstat.setString(2, orgfilename);
				pstat.setString(3, profileseq);
				
				pstat.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
