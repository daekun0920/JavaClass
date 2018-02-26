package adminreview.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.OracleTypes;

public class AdminReviewDAO {
	Connection conn;
	PreparedStatement stat;
	DataSource ds;
	Scanner scan;
	
	public AdminReviewDAO() {
		conn = DBAccess.open();
		ds = new DataSource();
		scan = new Scanner(System.in);
	}

	public ArrayList<AdminReviewListDTO> review_list() {
		ArrayList<AdminReviewListDTO> list = new ArrayList<AdminReviewListDTO>();
		
		try {
			stat = conn.prepareStatement(ds.get("adminreview.list"));
			
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				AdminReviewListDTO dto = new AdminReviewListDTO();
				
				dto.setSeq(rs.getString("수강평번호"));
				dto.setName(rs.getString("과정명"));
				dto.setReview(rs.getString("수강평"));
				
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			
			return list;
		} catch (SQLException e) {
			System.out.println("AdminReviewDAO.review_list " + e.toString());
		}
		
		return null;
	}

	public int review_del(int num) {
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("adminreview.del"));
		
			cstat.setInt(1, num);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			
			cstat.executeUpdate();
			
			int result = cstat.getInt(2);
			
			cstat.close();
			
			
			
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("AdminReviewDAO.review_del " + e.toString());
		}
		
		return 0;
	}
	
	
	
	
}
