package com.enter.company.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.enter.sql.DBUtil;

public class CompanyDAO {
	Connection conn;
	

	public CompanyDAO() {
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("ManagementDAO.Constructor" + e.toString());
		}
	}


	public ArrayList<NoticeDTO> noticelist(int nowPage, HashMap<String, String> map) {
		try {
			
			String sql = "SELECT * FROM tbl_main_notice n INNER JOIN tbl_staff f ON n.staff_seq = f.staff_seq INNER JOIN tbl_member m ON m.member_seq = f.member_seq WHERE n.main_notice_check = ?";
			
			if (map.get("isSearch") != null) {
				
				if (map.get("category").equals("stitle")) {
					sql += " AND n.main_notice_title like '%" + map.get("keyword") + "'  ORDER BY main_notice_seq DESC";
				}
				
			} else {
				
				sql += " ORDER BY main_notice_seq DESC";
				
			}
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "1");
			
			ResultSet rs  = pstat.executeQuery();
			ArrayList<NoticeDTO> list = new ArrayList<>();
			
			
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				
				
				dto.setSeq(rs.getString("main_notice_seq"));
				dto.setTitle(rs.getString("main_notice_title"));
				dto.setContent(rs.getString("main_notice_content"));
				dto.setTime(rs.getString("main_notice_time"));
				dto.setVisitors(rs.getString("main_notice_visitor"));
				dto.setCheck(rs.getString("main_notice_check"));
				dto.setFile(rs.getString("main_notice_file"));
				dto.setOrgfile(rs.getString("main_notice_orgfile"));
				dto.setStaffname(rs.getString("member_name"));
				
				
				list.add(dto);
			}
			
			int start = (nowPage * 10) - 9;
			int end = (nowPage * 10);
			
			
			sql = "SELECT * FROM (SELECT a.*, rownum as rnum FROM (SELECT * FROM tbl_main_notice n INNER JOIN tbl_staff f ON n.staff_seq = f.staff_seq INNER JOIN tbl_member m ON m.member_seq = f.member_seq WHERE n.main_notice_check = ? ORDER BY main_notice_seq DESC) a) WHERE rnum >= ? AND rnum <= ? ORDER BY main_notice_seq DESC";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "0");
			pstat.setInt(2, start);
			pstat.setInt(3, end);
			
			rs  = pstat.executeQuery();
			
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				
				
				dto.setSeq(rs.getString("main_notice_seq"));
				dto.setTitle(rs.getString("main_notice_title"));
				dto.setContent(rs.getString("main_notice_content"));
				dto.setTime(rs.getString("main_notice_time"));
				dto.setVisitors(rs.getString("main_notice_visitor"));
				dto.setCheck(rs.getString("main_notice_check"));
				dto.setFile(rs.getString("main_notice_file"));
				dto.setOrgfile(rs.getString("main_notice_orgfile"));
				dto.setStaffname(rs.getString("member_name"));
				
				
				list.add(dto);
			}
			
			
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int getTotalPage(HashMap<String, String> map) {
		try {
			
		
		String sql = "SELECT count(*) as cnt FROM tbl_main_notice WHERE main_notice_check = ?";
		
		if (map.get("isSearch") != null) {
			if (map.get("category").equals("stitle")) {
				sql += " AND stitle like '%" + map.get("keyword") + "'";
			}
		}
		
		PreparedStatement pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, "0");
		
		ResultSet rs  = pstat.executeQuery();
		
		
		int result = 0; 
		
		if (rs.next()) {
			
			result = (int) Math.ceil((double)rs.getInt("cnt") / 10);
			
		}
		
		
		conn.close();
		return result;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}


	public int addNotice(NoticeDTO dto) {
		try {
			String sql = "INSERT INTO tbl_main_notice VALUES (main_notice_seq.nextval, ?, ?, sysdate, 0, ?, ?, ?, ?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getCheck());
			pstat.setString(4, dto.getFile());
			pstat.setString(5, dto.getOrgfile());
			pstat.setString(6, dto.getStaffseq());
			
			int result= pstat.executeUpdate();
			
			conn.close();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public NoticeDTO getView(String seq) {
		try {
			String sql = "SELECT * FROM tbl_main_notice n INNER JOIN tbl_staff f ON n.staff_seq = f.staff_seq INNER JOIN tbl_member m ON m.member_seq = f.member_seq WHERE n.main_notice_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			ResultSet rs = pstat.executeQuery();
			
			NoticeDTO dto = new NoticeDTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("main_notice_seq"));
				dto.setTitle(rs.getString("main_notice_title"));
				dto.setContent(rs.getString("main_notice_content"));
				dto.setFile(rs.getString("main_notice_file"));
				dto.setOrgfile(rs.getString("main_notice_orgfile"));
				dto.setStaffname(rs.getString("member_name"));
				dto.setTime(rs.getString("main_notice_time"));
				dto.setStaffseq(rs.getString("staff_seq"));
				
			}
			
			conn.close();
			
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public void visitcount(String seq) {
		try {
			String sql = "UPDATE tbl_main_notice SET main_notice_visitor = main_notice_visitor + 1 WHERE main_notice_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			
			
			pstat.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public int delNotice(String seq) {
		try {
			String sql = "DELETE FROM tbl_main_notice WHERE main_notice_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			
			conn.close();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	

	public ArrayList<NoticeDTO> getIndexNotice() {
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, rownum as rnum FROM (SELECT * FROM tbl_main_notice n INNER JOIN tbl_staff f ON n.staff_seq = f.staff_seq INNER JOIN tbl_member m ON m.member_seq = f.member_seq WHERE n.main_notice_check = ? ORDER BY main_notice_seq DESC) a) WHERE rnum >= ? AND rnum <= ? ORDER BY main_notice_seq DESC";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "0");
			pstat.setString(2, "1");
			pstat.setString(3, "10");
			
			
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<NoticeDTO> list = new ArrayList<>();
			
			
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				
				dto.setSeq(rs.getString("main_notice_seq"));
				dto.setTitle(rs.getString("main_notice_title"));
				dto.setVisitors(rs.getString("main_notice_visitor"));
				
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
}
