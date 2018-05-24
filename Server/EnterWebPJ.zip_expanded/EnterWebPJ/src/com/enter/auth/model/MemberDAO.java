package com.enter.auth.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.enter.sql.DBUtil;

public class MemberDAO {
	Connection conn;
	
	public MemberDAO() {
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("ManagementDAO.Constructor" + e.toString());
		}
	}

	public ArrayList<ChartDTO> getSchedules() {
		try {
			
			String sql = "SELECT member_name, count(*) FROM tbl_schedule s INNER JOIN tbl_artist a ON s.artist_seq = a.artist_seq INNER JOIN tbl_star ss ON ss.star_seq = a.star_seq INNER JOIN tbl_member m ON m.member_seq = ss.member_seq WHERE s.schedule_type_seq = 1 GROUP BY m.member_name " + 
					"UNION" + 
					" SELECT group_name, count(*) FROM tbl_schedule s INNER JOIN tbl_artist a ON s.artist_seq = a.artist_seq INNER JOIN tbl_group g ON g.group_seq = a.group_seq WHERE a.star_seq is null AND s.schedule_type_seq = 1 GROUP BY g.group_name";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<ChartDTO> list = new ArrayList<>();
			
			
			while (rs.next()) {
				ChartDTO dto = new ChartDTO();
				
				dto.setStar_name(rs.getString(1));
				dto.setTimes(rs.getString(2));
				
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
