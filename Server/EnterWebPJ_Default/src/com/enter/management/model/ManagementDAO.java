package com.enter.management.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.enter.sql.DBUtil;
import com.enter.sql.DataSource;

public class ManagementDAO {
	DataSource ds;
	Connection conn;
	
	
	public ManagementDAO() {
		try {
			ds = new DataSource();
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("ManagementDAO.Constructor" + e.toString());
		}
	}
	
	public ArrayList<ArtistDTO> searchartists(String keyword, String type) {
		String sql = "";
		try {
			
			if (type.equals("1") || type.equals("2")) {
				sql = "SELECT member_name, artist_seq FROM vw_search_stars WHERE member_name = ?";
				
			} else if (type.equals("3")) {
				sql = "SELECT group_name, artist_seq FROM vw_search_group WHERE group_name = ?";
					
			}
			
			ArrayList<ArtistDTO> list = new ArrayList<>();
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, keyword);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				ArtistDTO dto = new ArtistDTO();
				
				dto.setName(rs.getString(1));
				dto.setArtist_seq(rs.getString(2));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			
			
			
		}
		
		
		return null;
	}

}
