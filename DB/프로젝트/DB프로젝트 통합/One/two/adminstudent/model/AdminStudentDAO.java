package adminstudent.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class AdminStudentDAO {

	private Connection conn;
	private Statement stat;
	private DataSource ds;
	
	public AdminStudentDAO() {
		
		try {
			
			ds = new DataSource();
			conn = DBAccess.open();
			stat = conn.createStatement();
			
		} catch (Exception e) {
			System.out.println("AdminStudentDAO.contructor : " + e.toString());
		}
		
	}
	
	public int add(AdminStudentAddDTO dto) {

		try {
			
			CallableStatement stat
				= conn.prepareCall(ds.get("adminstudent.add"));
			
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getSsn());
			stat.setString(3, dto.getType());
			stat.setString(4, dto.getName());
			stat.setString(5, dto.getTel());
			stat.setString(6, dto.getCseq());
			stat.registerOutParameter(7, OracleTypes.NUMBER);
			stat.executeUpdate();
			
			return stat.getInt(7);
			
		} catch (Exception e) {
			System.out.println("AdmintStudentDAO.add" + e.toString());
		}
		
		return 0;
	}

	public int del(String num) {

		try {
			
			CallableStatement stat
				= conn.prepareCall(ds.get("admintstudent.del"));
			
			stat.setString(1, num);
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			stat.executeUpdate();
			
			return stat.getInt(2);
			
		} catch (Exception e) {
			System.out.println("AdminStudentDAO.del : " + e.toString());
		}
		return 0;
	}

	public int quit_enrollment(AdminStudentQuitDTO dto) {

		try {
			CallableStatement stat
				= conn.prepareCall(ds.get("quite_add"));
			
			stat.setString(1, dto.getSeq());
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			
			stat.executeUpdate();
			
			return stat.getInt(2);
			
		} catch (Exception e) {
			System.out.println("AdminStudentDAO.quit_enrollment : " + e.toString());
		}
		
		return 0;
	}

	public int edit(AdminStudentEditDTO dto) {

		try {
			CallableStatement stat
				= conn.prepareCall(ds.get("adminstudent.edit"));
			
			stat.setString(1, dto.getSeq());
			stat.setString(2, dto.getTel());
			stat.registerOutParameter(3, OracleTypes.INTEGER);
			
			stat.executeUpdate();
			
			return stat.getInt(3);
			
			
			
		} catch (Exception e) {
			System.out.println("AdminsStudentDAO.edit : " + e.toString());
		}
		
		return 0;
	}
	
	

}
