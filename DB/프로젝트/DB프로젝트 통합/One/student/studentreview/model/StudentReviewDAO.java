package studentreview.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;

public class StudentReviewDAO {
	
	
	private Connection conn;
	private DataSource ds;
	
	public StudentReviewDAO() {
	
			try {
				ds = new DataSource();
				conn = DBAccess.open();
			} catch (Exception e) {
				System.out.println("StudentReviewDAO.Contructor : " + e.toString());
			}
		}
		
	public ArrayList<StudentReviewListDTO> list() {

		try {
			PreparedStatement stat = null;
			
			stat = conn.prepareStatement(ds.get("review.list"));
		

			ResultSet rs = stat.executeQuery();

			
			ArrayList<StudentReviewListDTO> list = new ArrayList<StudentReviewListDTO>();
			
			while (rs.next()) {
		
				StudentReviewListDTO dto = new 	StudentReviewListDTO();
				dto.setStudent_enrollment_seq(rs.getString("student_enrollment_seq"));
				dto.setCourse_review(rs.getString("course_review"));
			
				
	
				
				list.add(dto);//**				
			}
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("StudentReviewDAO.list : " + e.toString());
		}
		
		return null;
	}			
	
	public int reviewAdd(StudentReviewAddDTO dto) {

		try {
		
			PreparedStatement stat = conn.prepareStatement(ds.get("review.add"));
			
			stat.setString(1, dto.getStudent_enrollment_seq());
			stat.setString(2, dto.getCourse_review());

			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StudentReviewDAO.add : " + e.toString());
		}
		
		return 0;
	}


	
	public int reviewdle( StudentReviewDelDTO dto) {

		try {
		
			PreparedStatement stat = conn.prepareStatement(ds.get("review.del"));
			
			stat.setString(1, dto.getStudent_enrollment_seq());
	

			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StudentReviewDAO.del : " + e.toString());
		}
		
		return 0;
	}
	
	

	public int reviewupd( StudentReviewEditDTO dto) {

		try {
		
			PreparedStatement stat = conn.prepareStatement(ds.get("review.upd"));
			
			stat.setString(1, dto.getCourse_review());
			stat.setString(2, dto.getStudent_enrollment_seq());
	

			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StudentReviewDAO.upd : " + e.toString());
		}
		
		return 0;
	}
	
}