package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex75_Data {
	
	public static void main(String[] args) {
		// Ex75_Data.java
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		
		//m6();
		
		//m7();
		//m8();
		
		//m9();
		m10();
		
	}

	private static void m10() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("gif", "100");
		map.put("jpg", "100");
		map.put("png", "100");
		
		
		Set<String> set = map.keySet();
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			
			String key = iter.next();
			System.out.println(key + " : " + map.get(key)); // 키값만 출력 
		}
	}

	private static void m9() {
		String path = "D:\\Class\\Java\\JavaTest\\src\\com\\test\\io\\Ex75_Data.java";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = "";
			int lineNumber = 1;
			
			
			// 홀수줄을 버리지 않고 살려두기 위해서 변수에다 넣어준다 
			while ((line = reader.readLine()) != null) {
				System.out.printf("%03d: %s\n", lineNumber, line);
				lineNumber++;		// 0을 붙이면 나머지 공백을 붙여준다.
				
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println("m9 : " + e.toString());
		}
		
		
	}

	private static void m8() {
		
		try {
			
			// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// String txt = reader.readLine();
			
			// ***** 파일 라인 단위로 읽기 
			BufferedReader reader = new BufferedReader(new FileReader("D:\\data.txt"));
			
//			String txt = reader.readLine();
//			System.out.println(txt);
//			
//			txt = reader.readLine();
//			System.out.println(txt);
//			
//			txt = reader.readLine();
//			System.out.println(txt);
//			
//			txt = reader.readLine();
//			System.out.println(txt);
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				
			}
			
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("m8 : " + e.toString());
		}
		
		
	}

	private static void m7() {
		
		// 데이터 쓰기
		//   - 문자 & 문자열 쓰기
		//   - 유니코드 지원
		
		try {
			// BufferedWriter <-> BufferedReader
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\data.txt", true));
			
			writer.write("하나");
			writer.write("둘");
			writer.write("셋");
			
			writer.newLine();   // \r\n 출력 
			
			writer.write("넷");
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("m7 : " + e.toString());
			
		}
		
		
		
		
	}

	private static void m6() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일의 위치 : ");
		String path = scan.nextLine();
		
		try {
			
			// 읽기
			//   - 문자 단위 읽기
			FileReader reader = new FileReader(path);
			
			// 유니코드 지원 (한 글자씩 읽어옴)
			// int code = reader.read();
			
			// 외우기 
			int code = -1;
			
			
			while ((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			// Clean up 코드
			reader.close();
			scan.close();
			
		} catch (Exception e) {
			System.out.println("m6 : " + e.toString());
		}
		
	}

	private static void m5() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[메모장]");
		
		System.out.print("파일명 : ");
		String fileName = scan.nextLine();
		try {
			FileWriter writer = new FileWriter("D:\\" + fileName + ".txt", true);
			
			while (true) {
				
				String txt = scan.nextLine();
				
				if (txt.equals("exit")) {
					break;
				}
				
				writer.write(txt + "\r\n");
				
			}
			
			writer.close();
			scan.close();
			
			System.out.println("쓰기 완료");
			
		} catch (Exception e) {
			System.out.println("m5 : " + e.toString());
		}
		
	}

	private static void m4() {
		
		
		// 데이터 쓰기
		//   - 문자(2 byte) 단위 쓰기
		
		
		try {
			
			//FileOutputStream				 // 생성 모드
			FileWriter writer = new FileWriter("D:\\member.txt");
			
			writer.write(65);
			
			writer.write("ABCD");
			// 한글 작성 가능 
			writer.write("안녕하세요.");
			
			// 무조건 닫아주어야 함 
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println("m4 : " + e.toString());
		}
		
		
		
		
		
	}

	private static void m3() {
		
		// 데이터 읽기
		//   - 바이트 단위 읽기(ASCII)
		//   - System.in.read() 유사
		
		try {
			
			// 읽기 전용 스트림
			FileInputStream stream
			= new FileInputStream("D:\\data.txt");
//			
//			int code = stream.read();
//			System.out.println(code); // 65
//			
//			code = stream.read();
//			System.out.println(code); // 66
//			
//			code = stream.read();
//			System.out.println(code); // 67
//			
//			code = stream.read();
//			System.out.println(code); // 13
//			
//			code = stream.read();
//			System.out.println(code); // 10
			
			// ***** 외우기 *****
			int code = -1;
			// 읽다가 데이터가 더이상 존재하지 못해 읽지못하는 끝(EOF)을 만나면 -1을 돌려준다 
			// 파일 데이터의 시작 : BOF, 파일 데이터의 끝 : EOF 
			while ((code = stream.read()) != -1) {
				System.out.print((char)code);
			}
			//////////////////////
			
			stream.close();
			
		} catch (Exception e) {
			System.out.println("m3 : " + e.toString());
		}
		
	}

	private static void m2() {
		
		// 이어 쓰기
		try {
			
			// true : 이어쓰기 모드
			// false(or 생략) : 생성 모드 (덮어 쓰기)
			FileOutputStream stream					// append 모드 
				= new FileOutputStream("D:\\data.txt", true);
			
			stream.write(65);
			stream.write(66);
			stream.write(67);
			
			//stream.write(13); // 엔터
			//stream.write(10); // 
			stream.write((int)'\r');
			stream.write((int)'\n');
			
			stream.write((int)'A');
			stream.write((int)'B');
			stream.write((int)'C');
			
			stream.write('A');
			stream.write('B');
			stream.write('C');
			// stream.write("D");
			
			stream.write((int)'\r');
			stream.write((int)'\n');
			
			String str = "Hello~ Hi~ Hong!!";
			
			// 루프로 일괄 처리 
			for (int i = 0; i < str.length(); i++) {
				stream.write(str.charAt(i));
			}
			
			stream.close();
			
			System.out.println("종료");
			
			Process notedpad = new ProcessBuilder("notepad.exe", "D:\\data.txt").start();
			
		} catch (Exception e) {
			System.out.println("m2 : " + e.toString());
		}
		
	}

	private static void m1() {

		// 파일 입출력
		//   - try catch 필수
		
		// 파일의 데이터가 이동하는 빨대 -> 스트림
		// 읽기/쓰기 전용 빨대가 각각 따로 있다.
		// 스트림은 일방통행이다
		// 양방향 스트림도 존재하지만 단방향 스트림보다 느리다
		
		// 쓰기
		// 1. 바이트 단위 쓰기
		//    - 1바이트 단위 > 문자 코드값 1바이트 > ASCII 코드 지원
		
		// 파일에 데이터 저장하기
		// 1. 스트림 객체 생성하기(스트림 객체 열기)(쓰기 전용 스트림)
		// 2. 스트림 객체를 사용해서 데이터 쓰기
		// 3. 스트림 객체 닫기 
		
		try {
			
			File file = new File("D:\\data.txt");
			
			// 쓰기 전용 스트림 // 해당파일에 빨대 꼽기 // 파일 자동 생성
			// + 생성 모드(Create Mode) - 파일이 없으면 직접 생성, 있으면 덮어써라
			FileOutputStream stream = new FileOutputStream(file);
			
			// 쓰기 작업
			stream.write(100); // 출력버퍼(메모리)에 작성한다 // 프로그램에서 하드디스크로 바로 작성하기에는 속도가 너무 느리다 
			stream.write(101);
			stream.write(102);
			
			// 스트림 닫기 - 반드시!
			stream.close();  // 하드디스크(해당파일)로 출력버퍼에 적어놓은것을 옮겨적는다 // 없을시(닫지 않을시) 파일에 입력한 데이터가 저장이 되지 않는다.
			
			// Scanner scan = new Scanner(System.in);
			// scan.hasNextLine();
			
			System.out.println("쓰기 완료");
			
		} catch (Exception e) {
			System.out.println("m1 : " + e.toString());
		}
		
		
	}
	
}
