package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

	public static Connection open() {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "one";
		String pw = "java1234";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			return conn;
			
		} catch(Exception e) {
			System.out.println("DBAcess Class1 " + e.toString());
		}
		return null;
	}
	
	public static Connection open(String port, String serverIP, String id, String pw) {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@" + serverIP + ":"+ port + ":xe";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			return conn;
			
		} catch (Exception e) {
			
			System.out.println("DBAcess Class2 " + e.toString());
		}
		return null;
	}
	/*public static void main(String[] args) throws SQLException {
		
		
		Connection conn = DBAccess.open("8899", "121.141.151.88" , "test", "java1234");
		
		String sql = "SELECT * FROM TABS";
		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		int count = 0;
		
		while(rs.next()) {
			count++;
		}
		System.out.println(count);
		
		rs.close();
		
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	
	}*/
}
