package com.enter.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	
	public static Connection open() {
		
		Connection conn = null;
		
		
		String url = "jdbc:oracle:thin:@211.63.89.45:1521:XE";
		String id = "entertainment";
		String pw = "enter1234";
		
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
