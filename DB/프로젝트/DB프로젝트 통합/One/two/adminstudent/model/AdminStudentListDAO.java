package adminstudent.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class AdminStudentListDAO {

	private Connection conn;
	private DataSource ds;
	
	public AdminStudentListDAO() {

		try {
			ds = new DataSource();
			conn = DBAccess.open();
			
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.Contructor : "  + e.toString());
		}
	}
	

	public ArrayList<AdminStudentListDTO> list() {
		
		try {
			
			PreparedStatement stat
				= conn.prepareStatement(ds.get("adminstudent.list"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminStudentListDTO> list = new ArrayList<AdminStudentListDTO>();
		
			while (rs.next()) {
				
				AdminStudentListDTO dto = new AdminStudentListDTO();
				
				dto.setSeq(rs.getString("기초번호"));
				dto.setSseq(rs.getString("교육생번호"));
				dto.setName(rs.getString("교육생이름"));
				dto.setSsn(rs.getString("주민번호"));
				dto.setTel(rs.getString("전화번호"));
				dto.setRegdate(rs.getString("등록일"));
				dto.setStatusCount(rs.getString("수강신청횟수"));
				
				list.add(dto);
			}
		
			rs.close();
			stat.close();
			
			return list;
		
		
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.list" + e.toString());
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		AdminStudentListDAO dao = new AdminStudentListDAO();
		ArrayList<AdminStudentSelectedListDTO> list = new ArrayList<>();
		list = dao.selected_list("20");
		
		System.out.println(list.size());
	}
	
	public ArrayList<AdminStudentSelectedListDTO> selected_list(String num) {

		try {
			
			CallableStatement stat
				= conn.prepareCall(ds.get("adminstudent.selectedlist"));
			
			stat.setString(1, num);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(2);
			
			ArrayList<AdminStudentSelectedListDTO> list = new ArrayList<AdminStudentSelectedListDTO>();
			
			while (rs.next()) {
				
				AdminStudentSelectedListDTO dto = new AdminStudentSelectedListDTO();
				
				dto.setSeq(rs.getString("교육생번호"));
				dto.setName(rs.getString("교육생이름"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseDate(rs.getString("과정기간"));
				dto.setClassroom(rs.getString("강의실"));
				dto.setStatus(rs.getString("수강현황"));
				dto.setStatusDate(rs.getString("수료및중도탈락날짜"));
				
				list.add(dto);
			}
			
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.selected_list : " + e.toString());
		}
		
		return null;
	}
	public ArrayList<AdminStudentSearchDTO> search(String search) {

		try {
			
			CallableStatement stat = null;
			
			stat = conn.prepareCall(ds.get("adminstudent.search"));
			stat.setString(1, search);
			stat.setString(2, search);
			stat.setString(3, search);
			stat.setString(4, search);
			stat.registerOutParameter(5, OracleTypes.CURSOR);
			stat.executeQuery();
			
			ResultSet rs = (ResultSet)stat.getObject(5);
			
			ArrayList<AdminStudentSearchDTO> list = new ArrayList<AdminStudentSearchDTO>();
			
			while (rs.next()) {
				AdminStudentSearchDTO dto = new AdminStudentSearchDTO();
				

				dto.setSeq(rs.getString("교육생번호"));
				dto.setName(rs.getString("교육생이름"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseDate(rs.getString("과정기간"));
				dto.setClassroom(rs.getString("강의실"));
				dto.setStatus(rs.getString("수강현황"));
				dto.setStatusDate(rs.getString("수료및중도탈락날짜"));
				
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.search : " + e.toString());
		}
		
		return null;
	}
	public ArrayList<AdminStudentCourseListDTO> course_list() {

		try {
			
			PreparedStatement stat = null;
			stat = conn.prepareStatement(ds.get("adminstudent.courselist"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminStudentCourseListDTO> list = new ArrayList<AdminStudentCourseListDTO>();
			
			while (rs.next()) {
				
				AdminStudentCourseListDTO dto = new AdminStudentCourseListDTO();
				
				dto.setCourseSeq(rs.getString("과정번호"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseDate(rs.getString("과정기간"));
				dto.setClassroom(rs.getString("강의실"));
				dto.setPersonnel(rs.getString("인원수"));
				dto.setCapacity(rs.getString("강의실정원"));
				
				list.add(dto);
			}
			
			rs.close();
			stat.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.course_list : " + e.toString());
		}
		
		return null;
	}
	public ArrayList<AdminStudentStatusListDTO> status_list() {

		try {
			
			PreparedStatement stat = null;
			
			stat = conn.prepareStatement(ds.get("duringcourse.list"));
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminStudentStatusListDTO> list = new ArrayList<AdminStudentStatusListDTO>();
			
			while (rs.next()) {
				
				AdminStudentStatusListDTO   dto = new AdminStudentStatusListDTO();
				
				dto.setSeq(rs.getString("교육생번호"));
				dto.setEseq(rs.getString("수강현황번호"));
				dto.setName(rs.getString("교육생명"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseDate(rs.getString("과정기간"));
				dto.setClassroom(rs.getString("강의실"));
				dto.setStatus(rs.getString("수강현황"));
				dto.setStatusDate(rs.getString("수료및중도탈락날짜"));

				list.add(dto);
			}
			
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AdminStudentListDAO.status_list : " + e.toString());
		}
		
		return null;
	}

}
