package com.test.example;

import java.util.Calendar;
import java.util.Scanner;

public class Ex66_Calendar {
	
	public static void main(String[] args) {
		
		// 달력
		// 1. 직접
		// 2. Calendar 사용
		
		int year = 0;
		int month = 0;
		int lastDay = 0; // 해당 달력의 마지막 날짜
		int day_of_week = 0; // 1일이 무슨 요일 
		
		Scanner scan = new Scanner(System.in);
		
		// System.out.println(Calendar.MONDAY); 
		// System.out.println(Calendar.MONTH); // get() 대상
		
		System.out.print("년 : ");
		year = scan.nextInt();
		
		System.out.print("월 : ");
		month = scan.nextInt();
	
		// lastDay = getLastDay(year, month);
		// day_of_week = getDayOfWeek(year, month);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1); // 0 ~ 11 
		c.set(Calendar.DATE, 1);
		
		lastDay = c.getActualMaximum(Calendar.DATE); // 마지막 날이 언제냐? (?)
		day_of_week = c.get(Calendar.DAY_OF_WEEK);//(?)
		
		// System.out.println(day_of_week);
		
		System.out.println();
		System.out.println("=========================================================");
		System.out.printf("                   %d년 %d월\n", year, month);
		System.out.println("=========================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		
		// 1일을 해당 요일의 위치에 맞추기 위해 공백을 출력
		for (int i = 1; i < day_of_week; i++) {
			System.out.print("\t");
		}
		
		// 날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			System.out.printf("%3d\t", day);
			// 토요일
			//if (day % 7 == 2) {
			if ((day + day_of_week - 2) % 7 == 6) {
				System.out.println();
			}
		}
		
	
	}
	
	private static int getDayOfWeek(int year, int month) {
		
		int totalDay = 0;
		
		for (int i = 1; i < year; i++) {
			if (isLeaf(year)) {
				totalDay += 366;
			} else {
				totalDay += 365;
			}
		}
		for (int i = 1; i < month; i++) {   // 12가 들어갈시 1월 부터 11월 까지 다른 메소드로 가서 30,31 일 값을 구해온다음
			totalDay += getLastDay(year, i); // totalDay에 더하고 밑에서 1일을 더해 11월 31일 에서 12월 1일을 만든다.
		}
		
		totalDay += 1; // 
		
		return totalDay % 7;
	
		
	}

	private static int getLastDay(int year, int month) { // 해당 달의 마지막일을 구하기 
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			if (isLeaf(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		
	}
	
	private static boolean isLeaf(int year) {
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
