package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;

public class Homework11 {
	
	
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	static ArrayList<String> list = new ArrayList<String>();
	
	
	
	
	
	public static void main(String[] args) {
		
		/*
		 심플 콘솔 메모장
		 
		 요구사항)
		 - 메뉴(지난 예제 참조)
		 
		 
		 1. 쓰기
		 	a. 이름 // 입력
		 	b. 년월일 시분초 // Calendar
		 	c. 메모 내용 // 입력 - 한줄입력 // 메모 입력 형태 정하기 // append 모드 
		 	/*
		 	 
		 	 읽기) 
		 	 작성자 : 홍길동		
		 	 날짜 : 2017-12-20
		 	 메모입니다.
		 	 메모입니다.
		 	 ===========
		 	 아무개
		 	 2017-12-20
		 	 테스트입니다.
		 	 메모입니다.
		 	 메모입니다.
		 	 
		 	
		 	
																				
		 2. 읽기
		 	a. 모두 다 출력
		 
		 
		 추가)
		 1. 메모 내용을 여러줄 가능하게...
		 2. 최신 메모를 먼저 출력하게 ...
		 
		 */
		
		
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("=========메모장=========");
			System.out.println("========ver 0.1=======");
			System.out.println("======================");
			System.out.println("1. 파일 쓰기");
			System.out.println("2. 파일 읽기");
			System.out.println("3. 종료");
			System.out.println("======================");
			System.out.print("선택(번호입력) : ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				fileWrite();
			} else if (sel.equals("2")) {
				fileRead();
			} else if (sel.equals("3")) {
				loop = false;
			}
			
			
		}
		System.out.println("프로그램이 종료 되었습니다.");
		
		
	}
	
	
	
	private static void fileRead() {
		String path = "D:\\Class\\Java\\freeMemo.txt";
		
		
		
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line = "";
			int lineNumber = 1;
			
			while ((line = reader.readLine()) != null) {
				if (lineNumber == 1) {
					System.out.printf("이름 : %s\n", line);
					lineNumber++;
				} else if (lineNumber == 2) {
					System.out.printf("날짜 : %s\n", line);
					lineNumber++;
				} else if (lineNumber >= 3 && !line.contains("=")) {
					System.out.printf("%s\n", line);
					lineNumber++;
				} else if (line.contains("=")) {
					System.out.println(line);
					lineNumber = 1;
				}
				
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println("fileRead : " + e.toString()); // try catch 템플릿 변경 
		}
		System.out.println("파일 읽기 완료.\n");
		
		
	}
	
	
	
	private static void fileWrite() {
		try {
			
			String path = "D:\\Class\\Java\\freeMemo.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			String exMemo = "";
			
			while ((line = reader.readLine()) != null) {
				exMemo = exMemo + line + "\r\n";
			}
			
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			
			Calendar c = Calendar.getInstance();
			String time = String.format("%tF %tT", c, c);
			
			boolean loop = true;
			String memo = "";
			System.out.print("메모 입력: ");
			while (loop) {
				String type = scan.nextLine();
				
				if (type.equals("exit")) {
					break;
				}
				
				memo = memo + type + "\r\n";
			}
			
			
			String lines = "===================\r\n";
			String comp = String.format("%s\r\n%s\r\n%s\r\n%s\r\n", name, time, memo, lines);
			
			list.add(exMemo);
			list.add(comp);
			
			FileWriter writer = new FileWriter(path);
			
			for (int i = list.size() - 1; i >= 0; i--) {
				writer.write(list.get(i));
			}
			writer.close();
			list.clear();
			
		} catch (Exception e) {
			System.out.println("fileWrite : " + e.toString());
		}
		
		
		
	/*	try {
			FileWriter writer = new FileWriter("D:\\selfMemo.txt", true);
			
			System.out.print("메모 입력 : ");
			boolean loop = true;
			String memo = "";
			
			writer.write(name + "\r\n");
			writer.write(time + "\r\n");
			
			while (loop) {
				
				memo = scan.nextLine();
				
				if (memo.equals("exit")) {
					break;
				}
				
				writer.write(memo + "\r\n");
			}
			
			
			writer.write("===================\r\n");
			
			writer.close();
			
			
			
		} catch (Exception e) {
			System.out.println("fileWrite : " + e.toString());
		}*/
		
		
		System.out.println("파일 쓰기 완료.\n");
	}
	
}
