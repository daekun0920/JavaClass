package com.test.mvc.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mvc.sql.DBUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement stat;
	
	public BoardDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// AddOk 서블릿이 dto를 줄테니 글을 써달라고 요청
	public int add(BoardDTO dto) {
		
		try {
			
			String sql = "INSERT INTO tblBoard(seq, subject, content, id, regdate, readcount, tag) VALUES (board_seq.nextval, ?, ?, ?, DEFAULT, DEFAULT, ?)";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getId());
			stat.setString(4, dto.getTag());
			
			
			
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	// List 서블릿이 DB에서 목록 주세요.. 위임
	public ArrayList<BoardDTO> list() {
		
		try {
			
			String sql = "SELECT seq, subject, id, (SELECT name FROM tblMember WHERE id = b.id) as name, regdate, readcount, round((sysdate - regdate) * 24 * 60) as gap FROM tblBoard b ORDER BY seq DESC";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			// rs -> list
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				// 레코드 1개 -> DTO 1개
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setGap(rs.getInt("gap"));
			
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	// View 서블릿이 글번호를 줄테니 레코드(DTO)를 주세요..
	public BoardDTO get(String seq) {
		
		 try {
			
			 String sql = "SELECT b.*, (SELECT name FROM tblMember WHERE id = b.id) as name FROM tblBoard b WHERE seq = ?";
			 stat = conn.prepareStatement(sql);
			 stat.setString(1, seq);
			 
			 ResultSet rs = stat.executeQuery();
			 
			 // rs -> dto
			 BoardDTO dto = new BoardDTO();
			 
			 if (rs.next()) {
				 // 레코드 1건 -> dto 1개
				 dto.setSeq(rs.getString("seq"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setContent(rs.getString("content"));
				 dto.setId(rs.getString("id"));
				 dto.setName(rs.getString("name"));
				 dto.setRegdate(rs.getString("regdate"));
				 dto.setReadcount(rs.getInt("readcount"));
				 dto.setTag(rs.getString("tag"));
				 
				 
			 }
			 
			 return dto;
			 
		 } catch (Exception e) {
			System.out.println("BoardDAO.get : " + e.toString());
		 }
		
		 return null;
		 
	}

	public void updateReadCount(String seq) {
		
		try {
			
			String sql = "UPDATE tblBoard SET readcount = readcount + 1 WHERE seq = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
