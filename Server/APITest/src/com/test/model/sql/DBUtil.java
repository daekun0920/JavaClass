package com.test.model.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	
	
	
	public static Connection open() {
		
		Connection conn = null;
		
		
		String url = "jdbc:oracle:thin:@mydb.cbhjmmimec9s.ap-northeast-1.rds.amazonaws.com:1521/ORCL";
		String id = "apitest";
		String pw = "drinky12#$";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			conn = DriverManager.getConnection(url,id,pw); // DB접속
			
			return conn;
			
		} catch (Exception e) {
			System.out.println("main : " + e.toString());
		}
		
		
		return null;
		
		
	}
	

	
	public static Connection open(String serverIP, String id, String pw) {
		
		Connection conn = null;
		
		
		String url = "jdbc:oracle:thin:@"+ serverIP +":1521:xe";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			conn = DriverManager.getConnection(url,id,pw); // DB접속
			return conn;
			
		} catch (Exception e) {
			System.out.println("main : " + e.toString());
		}
		
		
		return null;
		
		
	}
	

}
