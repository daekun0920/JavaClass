package com.test.spring.di;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex04_File implements IData {

	public int getCount() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("student.db"));
			
			String txt = "";
			int count = 0;
			
			while ((txt = reader.readLine()) != null) {
				
				//System.out.println(txt);
				count++;
			}
			
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
