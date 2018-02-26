package adminsubject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import admincourse.model.AdminCourseListDTO;
import admincourse.model.admincoursedayDTO;
import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class AdminSubjectDAO {

	private Connection conn;
	private PreparedStatement stat;
	private DataSource ds;

	public AdminSubjectDAO() {

		try {

			ds = new DataSource();
			conn = DBAccess.open();

		} catch (Exception e) {
			System.out.println("AdminSubjectDAO" + e.toString());
		}

	}

	public int add(AdminSubjectAddDTO dto) {

		try {

			CallableStatement cstat = conn.prepareCall(ds.get("adminsubject.add"));

			cstat.setString(1, dto.getCourse_seq());
			cstat.setString(2, dto.getBaiscsubjectseq());
			cstat.setDate(3, java.sql.Date.valueOf(dto.getSubjectstart()));
			cstat.setDate(4, java.sql.Date.valueOf(dto.getSubjectend()));
			cstat.setString(5, dto.getBasicbook());
			cstat.setString(6, dto.getTeaseq());
			cstat.registerOutParameter(7, OracleTypes.NUMBER);
			cstat.executeUpdate();
			
			return cstat.getInt(7);

			

		} catch (Exception e) {
			System.out.println("AdminSubjectAddDTO" + e.toString());
		}

		return 0;

	}

	public int edit(AdminSubjectEditDTO dto) {

		try {

			CallableStatement cstat = conn.prepareCall(ds.get("adminsubject.edit"));

			cstat.setString(1, dto.getCourse_seq());
			cstat.setString(2, dto.getSubjectseq());
			cstat.setString(3, dto.getBaiscsubjectseq());
			cstat.setDate(4, java.sql.Date.valueOf(dto.getSubjectstart()));
			cstat.setDate(5, java.sql.Date.valueOf(dto.getSubjectend()));
			cstat.setString(6, dto.getBasicbook());
			cstat.setString(7, dto.getTeaseq());
			cstat.registerOutParameter(8, OracleTypes.NUMBER);
			cstat.executeUpdate();
			
			return cstat.getInt(8);

		} catch (Exception e) {
			System.out.println("AdminSubjectEditDTO" + e.toString());
		}

		return 0;

	}

	public ArrayList<AdminSubjectListDTO> listsubject() {

		try {

			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("admincourse.subjectvw"));

			stat.executeQuery();
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<AdminSubjectListDTO> list = new ArrayList<AdminSubjectListDTO>();

			while (rs.next()) {

				AdminSubjectListDTO dto = new AdminSubjectListDTO();

				dto.setCourseseq(rs.getString("과정번호"));
				dto.setCoursename(rs.getString("과정명"));
				dto.setCoursestart(rs.getString("과정시작기간"));
				dto.setCourseend(rs.getString("과정종료기간"));
				dto.setClassroom(rs.getString("강의실명"));
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
			System.out.println("listsubjectselect" + e.toString());
		}

		return null;

	}


	public ArrayList<AdminSelectedListDTO> listsubjectselect(String subjectseq) {

		try {

			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("adminsubject.selectvw"));
			
			
			
			stat.setString(1, subjectseq);
			ResultSet rs = stat.executeQuery();

			ArrayList<AdminSelectedListDTO> list = new ArrayList<AdminSelectedListDTO>();

			while (rs.next()) {

				AdminSelectedListDTO dto = new AdminSelectedListDTO();

				dto.setCourseseq(rs.getString("과정번호"));
				dto.setCoursename(rs.getString("과정명"));
				dto.setCoursestart(rs.getString("과정시작기간"));
				dto.setCourseend(rs.getString("과정종료기간"));
				dto.setClassroom(rs.getString("강의실명"));
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
			System.out.println("listsubjectselect" + e.toString());
		}

		return null;

	}

	public int del(String num) {

		try {

			CallableStatement qstat = conn.prepareCall(ds.get("adminsubject.del"));
			qstat.setString(1, num);
			qstat.registerOutParameter(2, OracleTypes.NUMBER);
			qstat.executeUpdate();
			return qstat.getInt(2);

		} catch (Exception e) {
			System.out.println("adminsubject.del :" + e.toString());
		}
		return 0;
	}

	public ArrayList<AdminbasicSubjectListDTO> listbaiscsubject() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareCall(ds.get("adminsubject.basic"));

			ResultSet rs = stat.executeQuery();

			ArrayList<AdminbasicSubjectListDTO> list = new ArrayList<AdminbasicSubjectListDTO>();

			while (rs.next()) {

				AdminbasicSubjectListDTO dto = new AdminbasicSubjectListDTO();

				dto.setSubjectbasicseq(rs.getString("BASIC_SUBJECT_SEQ"));
				dto.setSubjectbasicname(rs.getString("BASIC_SUBJECT_NAME"));
				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("listbaiscsubject" + e.toString());
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

	public ArrayList<AdminbasicbookDTO> listbasicbook() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("adminsubject.basicbook"));

			ResultSet rs = stat.executeQuery();

			ArrayList<AdminbasicbookDTO> list = new ArrayList<AdminbasicbookDTO>();

			while (rs.next()) {

				AdminbasicbookDTO dto = new AdminbasicbookDTO();

				dto.setBookseq(rs.getString("BASIC_BOOK_SEQ"));
				dto.setBookname(rs.getString("BASIC_BOOK_NAME"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("AdminbasicbookDTO.listbasicbook" + e.toString());
		}

		return null;

	}

	public ArrayList<AdmindetilteacherDTO> teachername() {

		try {
			PreparedStatement stat = null;

			stat = conn.prepareStatement(ds.get("adminsubject.teacher"));

			ResultSet rs = stat.executeQuery();

			ArrayList<AdmindetilteacherDTO> list = new ArrayList<AdmindetilteacherDTO>();

			while (rs.next()) {

				AdmindetilteacherDTO dto = new AdmindetilteacherDTO();

				dto.setTeacherseq(rs.getString("detail_teacher_seq"));
				dto.setTeachername(rs.getString("teacher_name"));

				list.add(dto);
			}
			rs.close();

			return list;

		} catch (Exception e) {
			System.out.println("AdminbasicbookDTO.listbasicbook" + e.toString());
		}

		return null;

	}

	public ArrayList<AdminCourseListDTO> course_list() {

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

}
