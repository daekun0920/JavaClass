package com.test.spring;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	
	public static Connection open() {
		
		Connection conn = null;
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
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
