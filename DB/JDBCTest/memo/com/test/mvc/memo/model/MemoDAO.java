package com.test.mvc.memo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.jdbc.DBUtil;
import com.test.mvc.memo.auth.Auth;
import com.test.mvc.model.DataSource;

public class MemoDAO {
	private Connection conn;
	private Statement stat;
	private DataSource ds;
	
	public MemoDAO() {
		try {
			ds = new DataSource();
			conn = DBUtil.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println("MemoDAO.Constructor" + e.toString());
		}
	}
	// MemoClass가 메모 입력내용을 주고 DB에 INSERT 해달라고...
	public int add(MemoDTO dto) {
		
		try {
			// 포인트 증가
			PreparedStatement stat = conn.prepareStatement(ds.get("memo.updatepoint"));
			
			stat.setInt(1, 100); // 메모 쓰기 + 100 포인트
			stat.setString(2, Auth.mseq);
			 
			stat.executeUpdate();
			
			// 메모쓰기
			stat = conn.prepareStatement(ds.get("memo.add"));
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getMseq());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemoDAO.add : " + e.toString());
		}
		return 0; 

	}
	// MemoClass가 메모 목록을 달라고 요청..
	public ArrayList<MemoDTO> list(String search) {
		
		try {
			
			PreparedStatement stat = null;
			
			if (search.isEmpty()) {
				stat = conn.prepareStatement(ds.get("memo.list"));
			} else {
				stat = conn.prepareStatement(ds.get("memo.search"));
				stat.setString(1, search);
			}
			
			ResultSet rs = stat.executeQuery();
			
			// rs -> ArrayList<MemoDTO>
			ArrayList<MemoDTO> list = new ArrayList<MemoDTO>();
			
			while (rs.next()) {
				// 1회전 -> 메모 1건 -> MemoDTO 1개
				MemoDTO dto = new MemoDTO(); // *** (안쪽에서 선언)
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				//dto.setMseq(rs.getString("mseq"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setMname(rs.getString("mname"));
				
				list.add(dto); // ***
			}
			rs.close();
			
			return list;
		} catch (Exception e) {
			System.out.println("MemoDAO.list : " + e.toString());
		}
		
		return null;
	}
	
	// MemoClass가 메모 번호를 줄테니 작성자 번호를 다오...
	public String getMseq(String seq) {
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("memo.getMseq"));
			
			stat.setString(1, seq);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("mseq");
			}
			
		} catch (Exception e) {
			System.out.println("MemoDAO.getMseq : " + e.toString());
		}
		
		
		return null;
	}
	
	// MemoClass가 삭제할 메모 번호를 줄테니 지워다오..
	public void del(String seq) {
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("memo.del"));
			
			stat.setString(1, seq);
			
			stat.executeUpdate();
			
			// 포인트 감소
			stat = conn.prepareStatement(ds.get("memo.updatepoint"));
			stat.setInt(1, -50);
			stat.setString(2, Auth.mseq);
			stat.executeUpdate();
			
			// conn.commit();
		} catch (Exception e) {
			System.out.println("MemoDAO.del : " + e.toString());
			// conn.rollback();
		}
			
			
	}
	
}
