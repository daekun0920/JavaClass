package com.test.spring;

import java.util.Scanner;

public class InputData {
	public String getName() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 : ");
		
		String name = scan.nextLine();
		
		return name;
	}
}
