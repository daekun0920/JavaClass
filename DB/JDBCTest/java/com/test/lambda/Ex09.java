package com.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex09 {
	
	private static String txt2 = "";
	
	public static void main(String[] args) {
		// Ex09.java
		// m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
	}
	
	private static void m7() {
		
		// 사용자 입력값 유효성 검사
		Scanner scan = new Scanner(System.in);
		
		// 4자 ~ 12자 이내 + 필수 입력 + 영문자, 숫자, _조합 + 숫자로 시작 불가능 
		System.out.print("이름 입력 : ");
		String input = scan.nextLine();
		
		String regex = "^[A-Za-z_]\\w{3,11}$";
		
		if (Pattern.matches(regex, input)) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("4자 ~ 12자 이내 + 필수 입력 + 영문자, 숫자, _조합 + 숫자로 시작 불가능");
		}
		
	}

	private static void m6() {
		
		Scanner scan = new Scanner(System.in);
		
		// 한글만 가능 + 2자 ~ 4자 이내 + 필수 입력 
		System.out.print("이름 입력 : ");
		String input = scan.nextLine();
		
		
		String regex = "^[가-힣]{2,4}$";
		
		if (Pattern.matches(regex, input)) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("한글만 가능 + 2자 ~ 4자 이내 + 필수 입력 ");
		}
		
	}

	private static void m5() {
		
		// 사용자 입력값 유효성 검사 
		Scanner scan = new Scanner(System.in);
		
		// 숫자 사용 + 1 ~ 3자리 이내 + 필수 입력
		System.out.print("나이 입력 : ");
		String input = scan.nextLine();
		
		// ^ : startWith
		// $ : 
		// String regex = "^[0-9]{1,3}$";
		String regex = "[0-9]{1,3}";
		
		if (Pattern.compile(regex).matcher(input).find()) {
			System.out.println("올바른 나이임 ㅋㅋ");
		} else {
			System.out.println("숫자 사용 + 1 ~ 3자리 이내 + 필수 입력");
		}
		
		if (Pattern.matches(regex, input)) { // ^ 와 $ 를 사용하지 않아도 자동 적용 됨 
			System.out.println("올바른 나이임 ㅋㅋ");
		} else {
			System.out.println("숫자 사용 + 1 ~ 3자리 이내 + 필수 입력");
		}
	}

	private static void m4() {
		
		String txt = "안녕하세요. 홍길동입니다. 나이는 20살 입니다. 연락처는 010-6543-0987 입니다. 혹시 전화를 안받으면 010-3232-5353로 연락주세요.";
		
		// $0 : 정규식으로 찾은 문자열 
		// $1 : 첫번째 () 내용
		// $2 : 두번쩨 () 내용
		// $3 : 세번째 () 내용
		// $9 : 아홉번째 () 내용 
		
		//String result = txt.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "***");
		//String result = txt.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "☏[$0]");
		//String result = txt.replaceAll("([0-9]{3})-([0-9]{3,4})-([0-9]{4})", "☏[$0 : $1-$2-$3]"); // $0 : 찾은 원본, $1 : 찾은것의 첫번째 괄호 부분 
		
		String result = txt.replaceAll("([0-9]{3})-([0-9]{3,4})-[0-9]{4}", "☏[$1-$2-****]"); // 마지막 자리 마스킹 
		System.out.println(result);
		
		
		
	}

	private static void m3() {
		
		// data.htm 내에서 이메일을 찾아내시오.
		
		// http://regexlib.com
		// 이메일 정규 표현식 : \w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}
		
		String path = "data.htm";
		String txt = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			//reader.lines();
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				txt += line + "\r\n";
			}
			
			reader.close();
			
			Pattern p = Pattern.compile("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}");
			Matcher m = p.matcher(txt);
			
			while (m.find()) {
				//System.out.println(m.group());
				
				System.out.printf("INSERT INTO tbl_email VALUES (%s)\n", m.group());
				
			}
			
			
			// 람다식에서는 지역변수를 final 취급한다. -> 멤버변수는 그렇지 않음
//			Stream<String> stream = reader.lines();
//			stream.forEach(str -> txt2 += str);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

	private static void m2() {
		String txt = "안녕하세요. 홍길동입니다. 나이는 20살 입니다. 연락처는 010-6543-0987 입니다. 혹시 전화를 안받으면 010-3232-5353로 연락주세요.";
		
		// 전화번호가 있느냐?
		Pattern p = Pattern.compile("\\d{3}-\\d{3,4}-\\d{4}");
		Matcher m = p.matcher(txt);
		
//		System.out.println(m.find()); // 1번째 전화번호
//		System.out.println(m.find()); // 2번째 전화번호 
//		System.out.println(m.find());

		while (m.find()) {
			//System.out.println("찾음");
			System.out.println(m.group());
		}
		
	}

	private static void m1() {
		
		String txt = "안녕하세요. 홍길동입니다. 나이는 20살 입니다. 연락처는 010-6543-0987 입니다. 혹시 전화를 안받으면 010-3232-5353로 연락주세요.";
		
		// txt에 전화번호가 있느냐? 
		
		
		// Pattern p = Pattern.compile("\\d{3}-\\d{3, 4}-\\d{4}"); 
		
		// txt에 주민번호가 있느냐?
		Pattern p = Pattern.compile("\\d{6}-\\d{7}"); 
		Matcher m = p.matcher(txt);
		
		if (m.find()) {
			System.out.println("전화번호 발견");
		} else {
			System.out.println("전화번호 없음");
		}
		
		
	}
}
