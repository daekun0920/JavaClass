package com.test.mvc.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mvc.sql.DBUtil;

public class AdminDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	
	public AdminDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getUserCount() {
		try {
			
			String sql = "SELECT count(*) FROM tblMember";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int getPostCount() {
		try {
			String sql = "SELECT count(*) FROM tblBoard";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getCommentCount() {
		try {
			String sql = "SELECT count(*) FROM tblComment";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getMediaCount() {
		try {
			String sql = "SELECT count(filename) + count(movie) FROM tblBoard";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<String> getNames() {
		
		try {
			
			String sql = "select name from tblMember order by name asc";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<String> names = new ArrayList<String>();
			
			while (rs.next()) {
				names.add(rs.getString("name"));
			}
			
			return names;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<Integer> getPostsData() {
		try {
			
			String sql = "SELECT count(b.seq) as cnt FROM tblMember m LEFT OUTER JOIN tblBoard b ON m.id = b.id GROUP BY m.name ORDER BY m.name";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<Integer> posts = new ArrayList<Integer>();
			
			while (rs.next()) {
				posts.add(rs.getInt(1));
			}
			
			return posts;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	public ArrayList<Integer> getCommentsData() {
		try {
			
			String sql = "SELECT count(b.seq) as cnt FROM tblMember m LEFT OUTER JOIN tblComment b ON m.id = b.id GROUP BY m.name ORDER BY m.name";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<Integer> comments = new ArrayList<Integer>();
			
			while (rs.next()) {
				comments.add(rs.getInt(1));
			}
			
			return comments;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
}
