package com.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;

public class saza {

	
	
	public static void main(String[] args) {
	
	
		
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();
//	m1();

	m2();

	

	}

	private static void m2() {
try {
			
			String line = "";
			String list = "";
			String path = "C:\\Users\\SIST40\\Desktop\\사자.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
				while((line =reader.readLine()) != null) {
					
					
					System.out.println(line);
				}
			
			
			
			reader.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	private static void m1() {
		try {
			
			String line = "";
			String list = "";
			String path = "C:\\Users\\SIST40\\Desktop\\변신사자.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
				while((line =reader.readLine()) != null) {
					
					
					System.out.println(line);
				}
			
			
			
			reader.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
