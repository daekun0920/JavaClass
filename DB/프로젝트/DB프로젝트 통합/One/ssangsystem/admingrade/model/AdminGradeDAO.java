package admingrade.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.OracleTypes;

public class AdminGradeDAO {
	private Connection conn;
	private DataSource ds;
	private PreparedStatement stat;
	
	
	public AdminGradeDAO() {
		try {
			ds = new DataSource();
			conn = DBAccess.open();
			
		} catch (Exception e) {
			System.out.println("AdminGradeDAO.Constructor " + e.toString());
		}
	}

	public ArrayList<AdminSubjectDTO> subject_grade_list() {
		ArrayList<AdminSubjectDTO> list = new ArrayList<AdminSubjectDTO>();
		
		try {
			stat = conn.prepareStatement(ds.get("admingrade.subjectgradelist"));
			
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				AdminSubjectDTO dto = new AdminSubjectDTO();
				
				dto.setSubject_seq(rs.getString("과목번호"));
				dto.setSubject_name(rs.getString("과목명"));
				dto.setSubject_book(rs.getString("교재명"));
				dto.setSubject_classroom(rs.getString("강의실"));
				dto.setSubject_teacher("교사명");
				dto.setCourse_name(rs.getString("과정명"));
				dto.setCourse_start_date(rs.getString("과정시작일"));
				dto.setCourse_end_date(rs.getString("과정종료일"));
				
				list.add(dto);
				
			}
			
			rs.close();
			stat.close();
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminGradeDTO.subject_grade_list " + e.toString());
		}
		return null;
		
	}
	

	public ArrayList<AdminCourseDTO> course_list() {
		ArrayList<AdminCourseDTO> list = new ArrayList<AdminCourseDTO>();
		try {
			stat = conn.prepareStatement(ds.get("admingrade.courselist"));
			
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				AdminCourseDTO dto = new AdminCourseDTO();
				
				dto.setCourse_seq(rs.getString("과정번호"));
				dto.setCourse_name(rs.getString("과정명"));
				dto.setCourse_start_date(rs.getString("과정시작일"));
				dto.setCourse_end_date(rs.getString("과정종료일"));
				dto.setCourse_stu_num(rs.getString("수강인원"));
				
				list.add(dto);
			}
			rs.close();
			stat.close();
			
			return list;
		} catch (SQLException e) {
			System.out.println("AdminGradeDAO.course_list " + e.toString());
		}
		
		return null;
		
	}



	public ArrayList<AdminSubjectStatusDTO> subject_list(int num) {
		ArrayList<AdminSubjectStatusDTO> list = new ArrayList<AdminSubjectStatusDTO>();
		
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("admingrade.subjectlist"));
			
			cstat.setInt(1, num);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeUpdate();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				AdminSubjectStatusDTO dto = new AdminSubjectStatusDTO();
				
				dto.setSubject_name(rs.getString("과목명"));
				dto.setSubject_start_date(rs.getString("과목시작일"));
				dto.setSubject_end_date(rs.getString("과목종료일"));
				dto.setSubject_if_grade(rs.getString("성적등록여부"));
				dto.setSubject_if_test(rs.getString("시험날짜등록여부"));
				
				list.add(dto);
			}
			
			rs.close();
			cstat.close();
			
			return list;
		} catch (SQLException e) {
			System.out.println("AdminGradeDAO.subject_list " + e.toString());	
		}
		return null;
	}

	public ArrayList<AdminStuSubGradeDTO> student_grade_list(int num) {
		ArrayList<AdminStuSubGradeDTO> list = new ArrayList<AdminStuSubGradeDTO>();
		
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("admingrade.substugradelist"));
			
			cstat.setInt(1, num);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeUpdate();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				AdminStuSubGradeDTO dto = new AdminStuSubGradeDTO();
				
				dto.setStudent_name(rs.getString("학생명"));
				dto.setStudent_ssn(rs.getString("주민번호"));
				dto.setStudent_attendance(rs.getString("출결"));
				dto.setStudent_writing(rs.getString("필기"));
				dto.setStudent_practical(rs.getString("실기"));
				
				list.add(dto);
			}
			
			rs.close();
			cstat.close();
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminGradeDAO.student_grade_list " + e.toString());
		}
		
		return null;
	}

	public ArrayList<AdminStudentInfoDTO> student_grade_list() {
		ArrayList<AdminStudentInfoDTO> list = new ArrayList<AdminStudentInfoDTO>();
		
		try {
			stat = conn.prepareStatement(ds.get("admingrade.studentgradelist"));
			
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				AdminStudentInfoDTO dto = new AdminStudentInfoDTO();
				
				dto.setStudent_seq(rs.getString("회원번호"));
				dto.setStudent_name(rs.getString("학생이름"));
				dto.setStudent_ssn(rs.getString("주민등록번호"));
				dto.setCourse_name(rs.getString("과정명"));
				dto.setCourse_start_date(rs.getString("과정시작일"));
				dto.setCourse_end_date(rs.getString("과정종료일"));
				dto.setCourse_classroom(rs.getString("강의실명"));
				
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			
			return list;
		} catch (Exception e) {
			System.out.println("AdminGradeDAO.student_grade_list " + e.toString());
		}
		
		return null;
	}

	public ArrayList<AdminStudentGradeDTO> private_grade_list(int num) {
		ArrayList<AdminStudentGradeDTO> list = new ArrayList<AdminStudentGradeDTO>();
		
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("admingrade.privategradelist"));
			
			cstat.setInt(1, num);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeUpdate();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				AdminStudentGradeDTO dto = new AdminStudentGradeDTO();
				
				dto.setSubject_name(rs.getString("개설과목명"));
				dto.setSubject_start_date(rs.getString("과목시작일"));
				dto.setSubject_end_date(rs.getString("과목종료일"));
				dto.setSubject_teacher(rs.getString("교사명"));
				dto.setStudent_attendance(rs.getString("출결"));
				dto.setStudent_writing(rs.getString("필기"));
				dto.setStudent_practical(rs.getString("실기"));
				
				list.add(dto);
			}
			
			rs.close();
			cstat.close();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("AdminGradeDAO.private_grade_list " + e.toString());
		}
		
		
		return null;
	}
}
