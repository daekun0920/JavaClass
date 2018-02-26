package studentinout.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.OracleTypes;
import student.model.StudentMyScoreListDTO;
import student.view.StudentView;
import studentreview.model.StudentReviewAddDTO;

public class StudentinoutDAO {
	
	private StudentView view;
	private Scanner scan;

	private DataSource ds;
	private Connection conn;
	
	public StudentinoutDAO() {

		view = new StudentView();
		scan = new Scanner(System.in);

		try {
			ds = new DataSource();
			conn = DBAccess.open();
		} catch (Exception e) {
			System.out.println("StudentDAO.Construtor :" + e.toString());
		}
		
	}


	public ArrayList<StudentinoutDTO> myattendande(String mseq) {

		  try {
		         PreparedStatement stat = conn.prepareStatement(ds.get("myall"));
		      
		         stat.setString(1,mseq);
		         

		         ResultSet rs = stat.executeQuery();
		         
		         ArrayList<StudentinoutDTO> list = new ArrayList<StudentinoutDTO>();
		         while (rs.next()) {
		            

		    		StudentinoutDTO dto = new StudentinoutDTO();
		            dto.setName(rs.getString("학생이름"));
		            dto.setIn(rs.getString("등원시간"));
		            dto.setOut(rs.getString("하원시간"));
		            dto.setBigo(rs.getString("출결상태"));
		            
		            list.add(dto);
		            //쿼리의 컬럼명을 가져와서 dto에 넣는다.
		         }
		         
		         rs.close();
		         
		     	return list;
		         
		      } catch (Exception e) {
		         System.out.println("StudentinoutDAO.myattendande : " + e.toString());
		      }

		
		return null;
	}
	

	public int inAdd(StudentInoutdAddDTO dto) {

	try {
	
		CallableStatement stat = conn.prepareCall(ds.get("studentin"));
		
		stat.setString(1, dto.getStudentseq());
		stat.setString(2,dto.getRs());
		
		return stat.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println("StudentInout.inadd : " + e.toString());
	}
	
		return 0;
	
	
	}

	public int outAdd(StudentInoutdAddDTO dto) {

		try {
		
			CallableStatement stat = conn.prepareCall(ds.get("studentout"));
			
			stat.setString(1, dto.getStudentseq());
			stat.setString(2,dto.getRs());
		


			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("StudentInout.inadd : " + e.toString());
		}
		
		return 0;
		
		
	}

}
	

