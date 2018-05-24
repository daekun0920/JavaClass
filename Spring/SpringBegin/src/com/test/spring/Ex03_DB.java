package com.test.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex03_DB {

	public int getCount() {
		try {
			Connection conn = DBUtil.open();
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery("SELECT count(*) FROM tblDI");
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}

}
