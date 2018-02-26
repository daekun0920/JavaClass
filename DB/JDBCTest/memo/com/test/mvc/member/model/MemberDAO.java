package com.test.mvc.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.jdbc.DBUtil;
import com.test.mvc.model.DataSource;

// Data Access Object
// : 데이터베이스 업무 담당자
// : JDBC 관련 코드들은 이곳에서만 코딩..(절대로 다른 클래스에서 Connection, Statement, ResultSet이 발견되면 안된다.)
// : <-> DAO 이외의 나머지 객체는 DB업무를 하면 안된다.(***)
public class MemberDAO {
	private Connection conn;
	private DataSource ds;
	
	public MemberDAO() {
		try {
			ds = new DataSource();
			conn = DBUtil.open();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.Constructor" + e.toString());
		}
	}
	
	// MemberClass가 입력받은 회원 정보를 줄테니(dto) 그 정보를 DB에 insert 해줘라 
	public int add(MemberDTO dto) {
		try {
			PreparedStatement stat = conn.prepareStatement(ds.get("member.add"));
			
			stat.setString(1, dto.getName());
			stat.setString(2, dto.getAge());
			stat.setString(3, dto.getTel());
			stat.setString(4, dto.getEmail());
			stat.setString(5, dto.getPw());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.add:" + e.toString());
		}
		return 0;
	
		
	}

	// Auth가 이메일과 암호 줄테니 인증 처리를 해다오 
	public int auth(MemberDTO dto) {
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("auth.login"));
			
			stat.setString(1, dto.getEmail());
			stat.setString(2, dto.getPw());
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.auth : " + e.toString());
		}
		
		return 0;
	}

	public String getMseq(MemberDTO dto) {
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("member.getMseq"));
			
			stat.setString(1, dto.getEmail());
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("seq");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getMseq : " + e.toString());
		}
		return null;
	}
	
	// MemberClass가 회원 번호를 줄테니 삭제(업데이트)
	public int del(String mseq) {
		
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("member.del"));
			
			stat.setString(1, mseq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.del : " + e.toString());
		}
		return 0;
	}
	
	
}
