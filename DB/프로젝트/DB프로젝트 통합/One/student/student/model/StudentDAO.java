package student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import model.DBAccess;
import model.DataSource;

import student.view.StudentView;

public class StudentDAO {
	
	private StudentView view;
	private Scanner scan;

	private DataSource ds;
	private Connection conn;
	
	public StudentDAO() {

		view = new StudentView();
		scan = new Scanner(System.in);

		try {
			ds = new DataSource();
			conn = DBAccess.open();
		} catch (Exception e) {
			System.out.println("StudentDAO.Construtor :" + e.toString());
		}
	}

	public StudentMyInfoListDTO my(String mseq) {

		  StudentMyInfoListDTO dto = new StudentMyInfoListDTO();
		  try {
		         PreparedStatement stat = conn.prepareStatement(ds.get("mycourse"));
		      
		         stat.setString(1,mseq);

		         ResultSet rs = stat.executeQuery();
		         
		         if (rs.next()) {

		            dto.setName(rs.getString("교육생이름"));
		            dto.setTel(rs.getString("전화번호"));
		            dto.setCourse(rs.getString("과정명"));
		            dto.setDate(rs.getString("과정기간"));
		            dto.setRoom(rs.getString("강의실"));
		            //쿼리의 컬럼명을 가져와서 dto에 넣는다.
		         }
		         rs.close();
		         
		         return dto;
		         
		      } catch (Exception e) {
		         System.out.println("StudentDAO. studentTitle : " + e.toString());
		      }

		return null;
	}

	public ArrayList<StudentMyScoreListDTO> mysubject(String mseq) {

		  try {
		         PreparedStatement stat = conn.prepareStatement(ds.get("mysubject"));
		      
		         stat.setString(1,mseq);
		         
		         ResultSet rs = stat.executeQuery();
		         
		         ArrayList<StudentMyScoreListDTO> list = new ArrayList<StudentMyScoreListDTO>();
		         while (rs.next()) {
		            
		    		StudentMyScoreListDTO dto = new StudentMyScoreListDTO();
		            dto.setName(rs.getString("교육생이름"));
		            dto.setSeq(rs.getString("과목번호"));
		            dto.setSubject(rs.getString("과목명"));
		            dto.setDate(rs.getString("과목기간"));
		            dto.setBook(rs.getString("교재명"));
		            dto.setTeacher(rs.getString("교사명"));
		            dto.setGatten(rs.getString("출석배점"));
		            dto.setGwrite(rs.getString("필기배점"));
		            dto.setGprac(rs.getString("실기배점"));
		            dto.setAtten(rs.getString("출석점수"));
		            dto.setWrite(rs.getString("필기점수"));
		            dto.setPrac(rs.getString("실기점수"));
		            dto.setExam(rs.getString("시험일"));
		            
		            list.add(dto);
		            //쿼리의 컬럼명을 가져와서 dto에 넣는다.
		         }
		         
		         rs.close();
		         
		     	return list;
		         
		      } catch (Exception e) {
		         System.out.println("StudentDAO. studentTitle : " + e.toString());
		      }

		
		return null;
	}




	
	      
}
	
