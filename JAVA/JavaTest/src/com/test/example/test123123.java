package com.test.example;

public class test123123 {
	public static void main(String[] args) {
		String[] list = new String[5];
		list[0] = "지드래곤";
		list[1] = "태양";
		list[2] = "승리";
		list[3] = "대성";
		list[4] = "탑";
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		for (String member : list) {
			System.out.println(member);
		}
		
	}
}
