package com.test.spring;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 : ");
		
		String name = scan.nextLine();
		
		System.out.printf("안녕하세요. %s님\n", name);
		
		
		/////////////////
		
		
		InputData data = new InputData();
		
		name = data.getName();
			
		System.out.printf("안녕하세요. %s님\n", name);
	}
	
}
