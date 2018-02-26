package admincourse.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class AdminCourseDAO {

	private Connection conn;
	private PreparedStatement stat;
	private DataSource ds;

	public AdminCourseDAO() {

		try {
			ds = new DataSource();
			conn = DBAccess.open();

		} catch (Exception e) {
			System.out.println("AdminCourseDAO.Contructor : " + e.toString());
		}
	}

	public int add(AdminCourseAddDTO dto) {

		try {

			CallableStatement cstat = conn.prepareCall(ds.get("admincourse.add"));

			cstat.setString(1, dto.getBasiccourse());
			cstat.setDate(2, java.sql.Date.valueOf(dto.getCoursestart()));
			cstat.setDate(3, java.sql.Date.valueOf(dto.getCourseend()));
			cstat.setString(4, dto.getBasicclassroom());
			cstat.registerOutParameter(5, OracleTypes.NUMBER);

			int result = cstat.executeUpdate();

			return result;

		} catch (Exception e) {
			System.out.println("AdminCourseAddDTO" + e.toString());
		}

		return 0;

	}

	public int edit(AdminCourseEditDTO dto) {

		try {

			CallableStatement cstat = conn.prepareCall(ds.get("admincourse.edit"));

			cstat.setString(1, dto.getCourseseq());
			cstat.setString(2, dto.getBasiccourse());
			cstat.setDate(3, java.sql.Date.valueOf(dto.getCoursestart()));
			cstat.setDate(4, java.sql.Date.valueOf(dto.getCourseend()));
			cstat.setString(5, dto.getBasicclassroom());
			cstat.registerOutParameter(6, OracleTypes.NUMBER);
			int result = cstat.executeUpdate();
			
			return result;

		} catch (Exception e) {
			System.out.println("edit" + e.toString());
		}

		return 0;

	}

	public int del(String num) {

		try {

			CallableStatement cstat = conn.prepareCall(ds.get("admincourse.del"));
			cstat.setString(1, num);
			cstat.registerOutParameter(2, OracleTypes.NUMBER);
			cstat.executeUpdate();
			return cstat.getInt(2);

		} catch (Exception e) {
			System.out.println("adminCourseDAO.del :" + e.toString());
		}
		return 0;
	}

	public ArrayList<AdminCourseListDTO> list() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("admincourse.coursevw"));

			ResultSet rs = stat.executeQuery();

			ArrayList<AdminCourseListDTO> list = new ArrayList<AdminCourseListDTO>();

			while (rs.next()) {

				AdminCourseListDTO dto = new AdminCourseListDTO();

				dto.setCourseseq(rs.getString("개설과정번호"));
				dto.setCoursename(rs.getString("개설과정명"));
				dto.setCoursestart(rs.getString("개설과정시작기간"));
				dto.setCourseend(rs.getString("개설과정종료기간"));
				dto.setBasicclassroom(rs.getString("강의실명"));
				dto.setYesno(rs.getString("과목등록여부"));
				dto.setPeople(rs.getString("수강인원"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("AdminCourseDAO.list" + e.toString());
		}

		return null;

	}


	public ArrayList<AdminCourseSelectedListDTO> listselect(String courseseq) {

		try {
			CallableStatement cstat = null;

			
			cstat = conn.prepareCall(ds.get("admincourse.selectvw"));
		

			cstat.setString(1, courseseq);
			ResultSet rs = cstat.executeQuery();

			ArrayList<AdminCourseSelectedListDTO> list = new ArrayList<AdminCourseSelectedListDTO>();

			while (rs.next()) {

				AdminCourseSelectedListDTO dto = new AdminCourseSelectedListDTO();

				dto.setCourseseq(rs.getString("과정번호"));
				dto.setSubjectseq(rs.getString("과목번호"));
				dto.setSubjectname(rs.getString("과목명"));
				dto.setSubjectstart(rs.getString("과목시작기간"));
				dto.setSubjectend(rs.getString("과목종료기간"));
				dto.setBasicbook(rs.getString("교재명"));
				dto.setTeaname(rs.getString("교사명"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("AdminCourseDAO.list" + e.toString());
		}

		return null;

	}

	public ArrayList<admincoursedayDTO> daylist() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("admincourse.datevw"));

			ResultSet rs = stat.executeQuery();

			ArrayList<admincoursedayDTO> daylist = new ArrayList<admincoursedayDTO>();

			while (rs.next()) {

				admincoursedayDTO dto = new admincoursedayDTO();

				dto.setDayseq(rs.getString("날짜번호"));
				dto.setDaystart(rs.getString("날짜시작기간"));
				dto.setDayend(rs.getString("날짜종료기간"));

				daylist.add(dto);
			}
			rs.close();

			return daylist;

		} catch (Exception e) {
			System.out.println("admincoursedayDTO.daylist" + e.toString());
		}

		return null;

	}

	public ArrayList<AdminCoursebasicroomDTO> roomlist() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("admincourse.classroom"));

			ResultSet rs = stat.executeQuery();

			ArrayList<AdminCoursebasicroomDTO> list = new ArrayList<AdminCoursebasicroomDTO>();

			while (rs.next()) {

				AdminCoursebasicroomDTO dto = new AdminCoursebasicroomDTO();

				dto.setRoomseq(rs.getString("CLASSROOM_SEQ"));
				dto.setRoomname(rs.getString("CLASSROOM_NAME"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("admincoursedayDTO.daylist" + e.toString());
		}

		return null;

	}

	public ArrayList<AdminCoursestudentDTO> liststudent(String courseseq) {

		try {
			CallableStatement sstat = null;

			sstat = conn.prepareCall(ds.get("admincourse.stulist"));

			sstat.setString(1, courseseq);
			sstat.registerOutParameter(2, OracleTypes.CURSOR);
			sstat.executeQuery();
			ResultSet rs = (ResultSet) sstat.getObject(2);
			ArrayList<AdminCoursestudentDTO> list = new ArrayList<AdminCoursestudentDTO>();

			while (rs.next()) {

				AdminCoursestudentDTO dto = new AdminCoursestudentDTO();

				dto.setCourseseq(rs.getString("과정번호"));
				dto.setStuname(rs.getString("교육생명"));
				dto.setStussn(rs.getString("교육생주민번호"));
				dto.setStutel(rs.getString("전화번호"));
				dto.setSturegdate(rs.getString("등록일"));
				dto.setStuing(rs.getString("수강현황"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("AdminCoursestudentDTO.liststudent" + e.toString());
		}

		return null;
	}
}
