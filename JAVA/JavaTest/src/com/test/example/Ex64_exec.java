package com.test.example;

import java.io.IOException;
import java.util.Scanner;

public class Ex64_exec {
	
	public static void main(String[] args) {
		// 스레드 -> 실행되고있는 메소드의 최소단위 
		// Ex64_exec.java
		
		// 프로젝트에 활용
		
		// 자바는 외부와 관계된 행동에는 반드시 예외 처리를 요구한다. -> 프로그램이 중단되지 않음
		//   - DB 입출력
		//   - Network 입출력 
		//   - 콘솔 입력
		//   - 파일 입출력
		
		// 자바 프로그램에서 외부 프로그램 호출하기
		//   - 콘솔, 웹 등..
		//   - 예외 처리 필수
		
		// 메모장 실행
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. 메모장");
			System.out.println("2. 그림판");
			System.out.println("3. 워드패드");
			System.out.println("4. 윈도우 탐색기");
			System.out.println("5. 익스플로러");
			System.out.println("6. 계산기");
			System.out.print("실행할 프로그램 선택 : ");
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				// path 가 걸린 프로그램은 바로 호출가능, 아닌경우 그 프로그램 풀주소 입력해야함
				Process notepad = new ProcessBuilder("notepad.exe", "D:\\텍스트.txt" ).start(); // notepad에서 텍스트.txt 를 실행한다
			} else if (input.equals("2")) {
				Process notepad = new ProcessBuilder("mspaint.exe").start();
			} else if (input.equals("3")){
				Process notepad = new ProcessBuilder("wordpad.exe").start();
			} else if (input.equals("4")){
				Process notepad = new ProcessBuilder("explorer.exe", "D:\\Class\\Java").start(); // 탐색기에서 Java 파일을 띄워라
			} else if (input.equals("5")){
				new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "https://youtu.be/OwJPPaEyqhI").start(); // chrome 에서 해당 주소를 띄워라
			} else if(input.equals("6")) {
				new ProcessBuilder("calc.exe").start(); // 객체 변수를 꼭 기재하지 않아도 됨 
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
