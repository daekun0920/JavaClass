package adminteacher.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.OracleTypes;

public class AdminTeacherListDAO {

	private Connection conn;
	private DataSource ds;
	
	public AdminTeacherListDAO() {
		
		try {
			ds = new DataSource();
			conn = DBAccess.open();
			
		} catch (Exception e) {
			System.out.println("AdminTeacherListDAO.Contructor : " + e.toString());
			
		} 
	}
	
	public ArrayList<AdminTeacherListDTO> list() {

		try {
			
			PreparedStatement stat = null;
			
			stat = conn.prepareStatement(ds.get("adminteacher.list"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminTeacherListDTO> list = new ArrayList<AdminTeacherListDTO>();
			
			while (rs.next()) {
				
				AdminTeacherListDTO dto = new AdminTeacherListDTO();
				
				dto.setSeq(rs.getString("교사번호"));
				dto.setName(rs.getString("교사이름"));
				dto.setSsn(rs.getString("주민번호"));
				dto.setTel(rs.getString("전화번호"));
				dto.setSubjectName(rs.getString("강의가능과목"));
				
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminTeacherListDAO.list : " + e.toString());
			
		}
		
		return null;
	}
	
	public ArrayList<AdminTeacherSelectedListDTO> selected_list (String num) {
		
		try {
			
			CallableStatement stat
				= conn.prepareCall(ds.get("adminteacher.selectedlist"));
			
			stat.setString(1, num);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);

			ArrayList<AdminTeacherSelectedListDTO> list = new ArrayList<AdminTeacherSelectedListDTO>();
			
			while (rs.next()) {
			
				AdminTeacherSelectedListDTO dto = new AdminTeacherSelectedListDTO();
				
				dto.setSeq(rs.getString("교사번호"));
				dto.setName(rs.getString("교사이름"));
				dto.setSubjectName(rs.getString("개설과목명"));
				dto.setSubjectDate(rs.getString("개설과목기간"));
				dto.setCourseName(rs.getString("개설과정명"));
				dto.setCourseDate(rs.getString("개설과정기간"));
				dto.setBook(rs.getString("교재명"));
				dto.setClassroom(rs.getString("강의실명"));
				dto.setStatus(rs.getString("강의진행여부"));
				
				list.add(dto);
			}
			rs.close();
			
			return list;
			

			
			
		} catch (Exception e) {
			System.out.println("AdminTeacherListDAO.selected_list : " + e.toString());
		}
		return null;
	}

	public ArrayList<AdminTeacherSubjectListDTO> teacher_subject_list() {

		try {
			
			PreparedStatement stat = null;
			
			stat = conn.prepareStatement(ds.get("adminteacher.subjectlist"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminTeacherSubjectListDTO> list = new ArrayList<AdminTeacherSubjectListDTO>();
			
			while (rs.next()) {
				
				AdminTeacherSubjectListDTO dto = new AdminTeacherSubjectListDTO();
				
				dto.setSeq(rs.getString("교사번호"));
				dto.setName(rs.getString("교사이름"));
				dto.setSubjectName(rs.getString("과목명"));
				
				list.add(dto);
			}
			
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminTeacherSubjectListDTO.teacher_subject_list" + e.toString());
		}
		return null;
	}

	public ArrayList<AdminBasicSubjectListDTO> basic_subject_list() {
		
		try {
			
			PreparedStatement stat = null;
			
			stat = conn.prepareStatement(ds.get("basicsubject.list"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminBasicSubjectListDTO> list = new ArrayList<AdminBasicSubjectListDTO>();
			
			while (rs.next()) {
				
				AdminBasicSubjectListDTO dto = new AdminBasicSubjectListDTO();
				
				dto.setSubjectNum(rs.getString("basic_subject_seq"));
				dto.setSubjectName(rs.getString("basic_subject_name"));
				
				list.add(dto);
			}
			
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminTeacherAddDAO.basic_subject_list : " + e.toString());
		}
		
		return null;
	}

	public ArrayList<AdminTeacherListEditDTO> teacher_list_edit() {
		return null;
	}
	
}
