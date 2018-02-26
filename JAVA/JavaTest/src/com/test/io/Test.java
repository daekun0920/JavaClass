package com.test.io;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char chr;

		//System.out.println(scan.hasNextLine()); //
		
		while (scan.hasNextLine()) {//block(true or false 리턴)
			String input = scan.nextLine(); //read(위에서 값을 받는다)
			if (!(input.isEmpty() || input.length() > 100)) {
				for (int i = 0; i < input.length(); i++) {
					chr = input.charAt(i);
	
					// 알파벳 소문자, 대문자, 공백, 숫자
					if (chr >= 0x61 && chr <= 0x7A || (chr >= 0x41 && chr <= 0x5A) || (chr == ' ')
							|| (chr >= 0x30 && chr <= 0x39)) {

					} else { // 소문자, 대문자, 공백, 숫자가 아니면 break
						break;
					}
				}
				System.out.println(input);
			}
		}
		
		// 위와 같다.
		String input = "";
		
		while ((input = scan.nextLine())!= null) {
		
			if (!(input.isEmpty() || input.length() > 100)) {
				for (int i = 0; i < input.length(); i++) {
					chr = input.charAt(i);
	
					// 알파벳 소문자, 대문자, 공백, 숫자
					if (chr >= 0x61 && chr <= 0x7A || (chr >= 0x41 && chr <= 0x5A) || (chr == ' ')
							|| (chr >= 0x30 && chr <= 0x39)) {

					} else { // 소문자, 대문자, 공백, 숫자가 아니면 break
						break;
					}
				}
				System.out.println(input);
			}
		}

	}

}
