package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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
				
				
			} else {
				sql = "INSERT INTO tbl_naver VALUES (naver_seq.nextval, ?, ?)";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, id);
				pstat.setString(2, name);
				
				
				
			}
			sql = "SELECT naver_seq FROM tbl_naver WHERE id = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				result = rs.getInt(1);
				
			}
			System.out.println(result + "res!");
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql = "SELECT count(*) as cnt FROM tbl_board";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			ResultSet rs = pstat.executeQuery();
			
			int result = 0;
			
			if (rs.next()) {
				
				result = rs.getInt("cnt");
				
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, r.name, rownum as rnum FROM (SELECT * FROM tbl_board a ORDER BY a.board_seq DESC) a INNER JOIN tbl_naver r ON a.naver_seq = r.naver_seq) WHERE rnum >= ? AND rnum <= ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, map.get("start"));
			pstat.setString(2, map.get("end"));
			
			
			ResultSet rs = pstat.executeQuery();
			
			
			list = new ArrayList<>();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_seq(rs.getString("board_seq"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regtime"));
				dto.setSubject(rs.getString("title"));
				dto.setViews(rs.getString("views"));
				
				
				list.add(dto);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int write(String title, String content, Integer seq) {
		try {
			String sql = "INSERT INTO tbl_board VALUES (board_seq.nextval, ?, ?, ?, ?, sysdate)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, title);
			pstat.setString(2, content);
			pstat.setInt(3, 0);
			pstat.setInt(4, seq);
			
			int result = pstat.executeUpdate();
			
			
			conn.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public BoardDTO getView(String seq) {
		try {
			String sql = "SELECT * FROM tbl_board b INNER JOIN tbl_naver r ON r.naver_seq = b.naver_seq WHERE board_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
					
			ResultSet rs = pstat.executeQuery();
			
			BoardDTO dto = new BoardDTO();
			
			if (rs.next()) {
				dto.setSubject(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNaver_seq(rs.getString("naver_seq"));
				dto.setRegdate(rs.getString("regtime"));
				dto.setName(rs.getString("name"));
				
			}
			
			sql = "UPDATE tbl_board SET views = views + 1 WHERE board_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
			
			return dto;
		} catch (Exception e) {

		}
		return null;
	}
}
