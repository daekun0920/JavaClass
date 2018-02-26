package adminteacher.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class AdminTeacherDAO {

	private Connection conn;
	private Statement stat;
	private DataSource ds;
	
	public AdminTeacherDAO() {
		
		try {
			
			ds = new DataSource();
			conn = DBAccess.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println("AdminTeacherDAO.contructor : " + e.toString()); 
		}
	}
	
	public int add(AdminTeacherAddDTO dto) {
		try {
			CallableStatement stat
				= conn.prepareCall(ds.get("adminteacher.add"));
			
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getSsn());
			stat.setString(3, dto.getType());
			stat.setString(4, dto.getName());
			stat.setString(5, dto.getTel());
			stat.setString(6, dto.getSubjectNum());
			stat.registerOutParameter(7, OracleTypes.NUMBER);
			stat.executeUpdate();
			
			return stat.getInt(7);
			
		} catch (Exception e) {
			System.out.println("AdmintTeacherDAO.add : " + e.toString());
		}
		
		return 0;
	}
	
	public int del(String num) {

		try {
			
			CallableStatement stat
				= conn.prepareCall(ds.get("adminteacher.del"));
			
			stat.setString(1, num);
			stat.registerOutParameter(2, OracleTypes.INTEGER);
			
			stat.executeUpdate();
			return stat.getInt(2);
			
			
		} catch (Exception e) {
			System.out.println("AdminTeacherDAO.del : " + e.toString());
		}
		return 0;
	}
	
	public int edit_tel(AdminTeacherEditTelDTO dto) {

		try {
			CallableStatement stat
				= conn.prepareCall(ds.get("adminteacher.edittel"));
			
			stat.setString(1, dto.getSeq());
			stat.setString(2, dto.getTel());
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeUpdate();
			
			return stat.getInt(3);
			
			
		} catch (Exception e) {
			System.out.println("AdminTeacherDAO.edit_tel : " + e.toString());
		}
		
		return 0;
	}

	public int edit_subject(AdminTeacherEditSubjectDTO dto) {

		try {
			CallableStatement stat
				= conn.prepareCall(ds.get("adminteacher.editsubject"));
			
			stat.setString(1, dto.getSeq());
			stat.setString(2, dto.getSseq());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			
			stat.executeUpdate();
			
			return stat.getInt(3);
			
		} catch (Exception e) {
			System.out.println("AdminTeacherDAO.edit_subject : " + e.toString());
		}
		
		return 0;
	}

}
