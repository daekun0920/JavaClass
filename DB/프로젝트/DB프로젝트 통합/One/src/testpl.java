import java.sql.CallableStatement;
import java.sql.Connection;

import model.DBAccess;
import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class testpl {

	public static void main(String[] args) {
		
		Connection conn = null;
		CallableStatement stat = null;
		
		try {
			conn = DBAccess.open("8899", "121.141.151.88", "test", "java1234");
			
			String sql = "{ call proc_login(?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "llksm2");
			stat.setString(2, "272621");
			
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.executeQuery();
			
			if(stat==null || stat.getString(3) ==null) {
				System.out.println("eeee");
			}else {
			
			System.out.println(stat.getString(3));
			}
			
			String str = null;
		} catch (Exception e) {
			System.out.println("testpl " + e.toString());
		} 
	}
}
