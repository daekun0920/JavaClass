package com.test.ajax;

public class ExString {
	public static void main(String[] args) {
		
		// 자바 문자열 조작
		// 1. String
		// 2. StringBuilder
		// 3. StringBuffer
		
		// String vs StringBuilder
		// - 자바 문자열 > 불변
		
		//  str += "." x 1000000
		String str1 = "홍길동";
		// String str2 = new String(new char[] {'홍', '길', '동'});
		
		StringBuilder str2 = new StringBuilder("아무개");
		
		str1 = str1 + "님";
		
		// str2 = str2 + "님";
		str2.append("님");
		
		System.out.println(str1);
		System.out.println(str2.toString());
		
	}
}
