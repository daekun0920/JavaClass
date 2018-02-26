package adminattendance.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.OracleTypes;

public class AdminAttendanceDAO {
	private Connection conn;
	private DataSource ds;
	private PreparedStatement stat;
	
	
	
	public AdminAttendanceDAO() {
		try {
			ds = new DataSource();
			conn = DBAccess.open();
			
		} catch (Exception e) {
			System.out.println("AdminAttendanceDAO.Constructor " + e.toString());
		}
		
	}



	public ArrayList<AdminAttendanceDTO> course_attendance(int num, String startdate, String enddate) {
		ArrayList<AdminAttendanceDTO> list = new ArrayList<AdminAttendanceDTO>();
		
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("adminattendance.courseattendance"));
			
			cstat.setInt(1, num);
			cstat.setString(2, startdate);
			cstat.setString(3, enddate);
			cstat.registerOutParameter(4, OracleTypes.CURSOR);
			
			cstat.executeUpdate();
			
			ResultSet rs = (ResultSet)cstat.getObject(4);
			
			while (rs.next()) {
				AdminAttendanceDTO dto = new AdminAttendanceDTO();
				
				dto.setSeq(rs.getString("회원번호"));
				dto.setName(rs.getString("학생명"));
				dto.setTel(rs.getString("전화번호"));
				dto.setInTime(rs.getString("등원시간"));
				dto.setOutTime(rs.getString("하원시간"));
				dto.setStatus(rs.getString("근태상황"));
				
				list.add(dto);
			}
			rs.close();
			cstat.close();
			return list;
		} catch (Exception e) {
			System.out.println("AdminAttendanceDAO.course_attendance " + e.toString());
		}
		
		
		return null;
	}



	public ArrayList<AdminAttendanceDTO> personal_attendance(int num) {
		boolean loop = true;
		
		ArrayList<AdminAttendanceDTO> list = new ArrayList<AdminAttendanceDTO>();
		
		try {
			CallableStatement cstat = conn.prepareCall(ds.get("adminattendance.personalattendance"));
			
			cstat.setInt(1, num);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeUpdate();
			
			ResultSet rs = (ResultSet)cstat.getObject(2);
			
			while(rs.next()) {
				AdminAttendanceDTO dto = new AdminAttendanceDTO();
				
				dto.setSeq(rs.getString("출결번호"));
				dto.setName(rs.getString("학생명"));
				dto.setCourse_name(rs.getString("과정명"));
				dto.setInTime(rs.getString("등원시간"));
				dto.setOutTime(rs.getString("하원시간"));
				dto.setStatus(rs.getString("근태상황"));
				
				list.add(dto);
			}
			rs.close();
			cstat.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("AdminAttendanceDAO.personal_attendance " + e.toString());
		}
		
		return null;
	}



	public int fix_attendance_status(int num, String sel) {
		try {
			stat = conn.prepareStatement(ds.get("adminattendance.fixattendancestatus"));
			
			stat.setString(1, sel);
			stat.setInt(2, num);
			
			int result = stat.executeUpdate();
			
			stat.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("AdminAttendanceDAO.fix_attendance_status " + e.toString());
		}
		return 0;
		
	}

}
