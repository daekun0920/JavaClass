package main.view;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainView {

	public void menu() {
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		m2();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("\t\t\t\t"+"1. 로그인/로그아웃");
		System.out.println("\t\t\t\t"+"2. 관리자 모드");
		System.out.println("\t\t\t\t"+"3. 교사 모드");
		System.out.println("\t\t\t\t"+"4. 교육생 모드");
		System.out.println("\t\t\t\t"+"5. 프로그램 종료");
		System.out.println();
		
		System.out.print("\t\t\t\t"+"선택 : ");
		
	}

	public void close() {
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	 private static void m2() {
		 try {
		          
		          String line = "";
		          String list = "";
		          String path = "./lib/사자.txt";
		          BufferedReader reader = new BufferedReader(new FileReader(path));
		          
		             while((line =reader.readLine()) != null) {
		                
		                
		                System.out.println(line);
		             }
		         
		          reader.close();
		         
		       } catch (Exception e) {
		          System.out.println(e.toString());
		       }
	  
		    }
}
