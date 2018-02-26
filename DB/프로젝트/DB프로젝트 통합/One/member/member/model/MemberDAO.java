package member.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class MemberDAO {

	private Connection conn;
	private DataSource ds;
	
	public MemberDAO() {
		//conn = DBAccess.open("8899", "121.141.151.88", "test", "java1234");
		conn = DBAccess.open();
		ds = new DataSource();
	}
	
	//Auth 가 넘겨준 id/pw 로 인증 처리
	public int auth(MemberDTO dto) {
		
		try {
			
			PreparedStatement stat = conn.prepareCall(ds.get("auth.login"));
			
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getPw());
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("MemberDAO.auth " + e.toString());
		}
		return 0;
	}
	public static void main(String[] args) {
		MemberDAO t = new MemberDAO();
		MemberDTO tmp = new MemberDTO();
		tmp.setId("llksm72");
		tmp.setPw("2726321");
		t.auth(tmp);
		System.out.println(t.auth(tmp));
	}

	public String getType(MemberDTO dto) {
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("member.getType"));
			
			stat.setString(1, dto.getId());
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return rs.getString("TYPE");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getType : " + e.toString());
		}
		
		return null;
	}

	public String getMseq(MemberDTO dto) {

		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("member.getMseq"));
			
			stat.setString(1, dto.getId());
			
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				return rs.getString("BASIC_INFO_SEQ");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getMseq : " + e.toString());
		}
		
		return null;
	}
}
