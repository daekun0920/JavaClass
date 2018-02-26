package com.test.example;

import java.util.Scanner;

// Build path > configure build path > library > add external jar
import com.test.util.Utility;

// mport temp.Tablet;

// import temp.Tablet; // 패키지.클래스
// import temp.Time;
// import temp.*;

public class Ex40 {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		int result = Utility.sum(a,  b);
		System.out.println(result);
		
		// 다른 클래스를 참조해서 사용하는 경우..
		// 1. 현재 클래스와 같은 패키지내에 들어있는 클래스
		Smartphone iphone = new Smartphone();
		// 정석
		com.test.example.Smartphone galaxy = new com.test.example.Smartphone();
		
		// 2. 현재 클래스와 다른 패키지내에 들어있는 클래스
		//temp.Tablet ipad = new temp.Tablet();
		//Tablet ipad2 = new Tablet();
		
		// 같은 패키지의 Time 사용 // 같은 패키지 보다 import가 우선 순위가 더 높다.
		// com.test.example.Time t1 = new com.test.example.Time();
		
		// Scanner scan = new Scanner(System.in);
		
		// 다른 패키지의 Time 사용
		// Time t2 = new Time();
		// temp.Time t3 = new temp.Time();
		
		// 충돌 날때는 풀네임 사용
		
		// 현재 소스의 모든 import 대상을 자동으로 처리 / 필요없는 import 삭제
		// -> Ctrl + Shift + o 
	}
}
