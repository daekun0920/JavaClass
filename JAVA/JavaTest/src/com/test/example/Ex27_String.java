package com.test.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex27_String {

	// ctrl + space = 코드 템플릿 (자동 완성)
	public static void main(String[] args) throws IOException {
		
		
		// 인텔리센스(VS), Code Assist(Eclipse) // 코드 템플릿과 엄연히 다름
		System.out.println("아무개");
		
		
		System.out.println(); // syso + ctrl + space 키워드
		
		// Shift + Alt + Y = 자동 줄바꿈
		// ctrl + d = 라인 단위 삭제
		//    주석 단축키 ctrl + /
		// ctrl + shift + f 정리정돈 ( + 블럭 지정 )  
		//int a;
		//int b;
		//int c;
		
		
		/**/  
		
		// 다중 라인 주석 ctrl + Shift + / , 주석 풀기 ctrl + Shift + \ 
		
		/*
		int d;
		int e;
		int f;
		*/
		
		// int a = 10
		
		
     	/*
		
		문자열
		- 기본형(원시형) vs 참조형
		- 문자열은 참조형이다.
		- String 클래스
		
		*/
		
		//m1();
		//m2();   // ctrl + 1 == 스텁(stub) 생성  
		//m3();  // f3 해당 메소드로 이동 / 해당 변수 선언 지점으로 이동
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//q1();
		//m10();
		//m11();
		//m12();
		//m13();
		//m14();
		//m15();
		//m16();
		//m17();
		//m18();
		//m19();
		
		// 발표
		//   - 시연 횟수 늘리기
		//       -> 올바른, 올바르지않은 경우, 예외 상황.. 
		
		
		
		/*int a = -10;
		
		if (a > 0)                     // 참2 // 컴파일러는 괄호없는 경우 참2를 if문 외의 실행 구문으로 인식한다.
			System.out.println("참");
			System.out.println("참2");
		
		
		for (int i = 0; i < 5; i++)   // 실행 구문이 하나뿐일때는 괄호를 쓰지않아도 된다.
			System.out.println(i);*/
		
		
		
	} // main
	
	
	
	
	
				
	
	





	private static void m19() {
			
		// 12자리 루프로 접근(x 2 ... 9 -> 총합)
		
		String jumin = "951211-1021547";
		jumin = jumin.replace("-", "");
		
		for (int i = 0; i < 12; i++) {
			// 문자열의 문자 추출 -> 정수 변환
			// 1. charAt() -> 문자코드값(Code - 48)
			// 2. substring() -> Integer.parseInt() // 추천
			int n = Integer.parseInt(jumin.substring(i, i + 1));
			System.out.println(n + "," + (i % 8 + 2)); // 2 ~ 9 ~ 5
		}
		
	} // m19













	private static void m18() {
		
		//숫자를 n자리로 만들기
		// 1 -> 001
		
		String result = paddingZero(4, 10);
		System.out.println(result); // "0010"
		
		result = paddingZero(8, 123);
		System.out.println(result); // "00000123"

	} // m18










	private static String paddingZero(int size, int num) {
		// - for 사용
		String stack = "";
		String strNum = num + "";
		
		for (int i = 0; i < size - strNum.length(); i++) {
			stack = stack + "0";
			
		}
		stack = stack + num;
		
		return stack;
	} // paddingZero













	private static boolean idCheck(String id) { // 메소드로 빼서 하는것이 추천된다.

		// 1. 4자 ~ 12자 이내
		if (id.length() < 4 || id.length() > 12) {
			System.out.println("4자 ~ 12자 이내로 입력 ㄱㄱ");
			return false;
		}

		// 2. 영문자 숫자
		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '_') {

				System.out.println("영문자 + 숫자 + _");
				return false;

			}

		}

		// 3. 숫자로 시작 불가능
		char c = id.charAt(0);
		if (c >= '0' && c <= '9') {
			System.out.println("숫자로 시작 불가능");
			return false;
		}
        return true; // 아무것도 걸리지않으면 true 
	}




	private static void m17() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		
		
		// 최종
		if (idCheck(id)) {
			System.out.printf("입력한 아이디 '%s'는(은) 사용가능합니다.\n", id);
		} else {
			System.out.printf("입력한 아이디 '%s'는(은) 사용 불가능합니다.\n", id);
		}
		
		
	} // m17
	

	private static void m16() {
		
		// 유효성 검사
		// 아이디 입력 
		// 1. 4자 ~ 12자 이내
		// 2. 영문자 + 숫자 + 언더바
		// 3. 숫자로는 시작 불가능
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		// 1. 잘못된 부분을 조건으로 검사
		// 2. 결과 boolean을 사용해서 판단.
		
		boolean isValid = true;
		// 잘못된것을 찾기!
		
		// 1. 4자 ~ 12자 이내
		if (id.length() < 4 || id.length() > 12) {
			System.out.println("4자 ~ 12자 이내로 입력 ㄱㄱ");
			isValid = false;
		} 
		
		// 2. 영문자 숫자
		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '_') {
				
				System.out.println("영문자 + 숫자 + _");
				isValid = false;
				break;
				
			}
			
			
		}
		
		//3. 숫자로 시작 불가능 
		char c = id.charAt(0);
		if (c >= '0' && c <= '9' ) {
			System.out.println("숫자로 시작 불가능");
			isValid = false;
		}
		
		// 최종
		if (isValid) {
			System.out.printf("입력한 아이디 '%s'는(은) 사용가능합니다.\n", id);
		} else {
			System.out.printf("입력한 아이디 '%s'는(은) 사용 불가능합니다.\n", id);
		}
		
		
		
		
	}


	private static void m15() {

		// 사용자 입력
		//   - System.in.read() -> BufferedReader -> Scanner

	
		Scanner scan = new Scanner(System.in); // java.util , throws Exception 필요 x
		
		// 이름(문자열) 입력 
		System.out.print("이름 입력 : ");
		String name = scan.nextLine(); 	
		
		System.out.println(name);
		
		// 숫자 입력 
		System.out.println("숫자 입력 : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println(num + 10);
		
		System.out.println("숫자 입력 : ");
		num = scan.nextInt();  // 위에 처럼 궂이 문자로 받아 숫자로 변환할 필요없이 처음부터 숫자로 받는다.
		System.out.println(num + 10);
		
		System.out.println("숫자 입력 : ");
		num = Integer.parseInt(scan.nextLine());
		System.out.println(num + 10);
		
		// Scanner 사용 시 주의쩜
		// nextInt() -> nextLine() 사용시 (숫자형 -> 문자열)
		// nextInt 사용하고 그 뒤에바로 nextLine 사용하게되면
		// - > nextInt() 가 \r\n 남겨버린다. -> \r\n을 nextLine()이 무시한다 
		
		// scan.nextLine(); // 엔터를 버려준다
		scan.skip("\r\n");
		
		
		System.out.println("문자열 입력 : ");
		String str = scan.nextLine();
		System.out.println(str);
		
		// aaa bbb ccc
		String s1 = scan.nextLine(); // 공백이 있어도 다 출력함
		String s2 = scan.next();     // 첫 토큰 하나만 출력함 (공백으로 구분되는 단어 하나 = 토큰(Token))
		
		System.out.println(s1);
		
		System.out.println(s2); /// aaa
		System.out.println(s2); /// bbb 
		
		
	} // m15

	private static void m14() {
		
		// 형식 문자열 지원
		//   - printf() : 화면 출력만... // 콘솔 전용 (웹에서는 사용 불가)
		//   - String format() : 형식 문자를 사용해서 형식을 가공한 문자열을 출력이 아닌 그대로 반환
		
//		System.out.printf("%d\n", 100);
//		System.out.println("%d\n", 100);
//		System.out.print("%d\n", 100);
		
		String name = "홍길동";
		String result = String.format("안녕하세요. %s님", name);
		
		System.out.println(result);
		
	} // m14













	private static void m13() {
		
		// 대소문자 변환
		
		String str = "Hello~ Hong!!";
		String result = ""; // 누적변수
		
		for (int i =0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			// String c = str.substring(i, i+1) // 문자코드값x
			
			if (c >= 'a' && c <= 'z') {
				result += (char)(c - 32); // 문자열 + 문자 = 문자열 //비교시 좀 더 큰 자료형으로 자체적으로 변환된다  (연산자 때문임)
			} else {
				result += c;
			}
			
			
		}
		System.out.println(result);
		
		// 대 소문자 변환 
		// - String toUpperCase() 
		// - String toLowerCase()
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		System.out.println("Java".equals("java"));
		
		String content = "대상 문자열.. 글내용.. Java가 어쩌구";
		String search = "java";
			// 순서대로 (메소드 체인) ***
			//					 컷
		if (content.toLowerCase().contains(search.toLowerCase())) {
			System.out.println("검색 결과 있음");
		} else {
			System.out.println("검색 결과 없음");
		}
		
		String s1 = "Hong";
		String s2 = "hong";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.toUpperCase().equals(s2.toUpperCase()));
		
		System.out.println(s1.equalsIgnoreCase(s2)); // 대소문자 상관없이 비교해줌
		
		
		
		str = "";
		
		// 비어있습니까?
		//if (str.equals("")) {
		if (isEmpty(str)) { // str.isEmpty()
			System.out.println("비었음");
		} else {
			System.out.println("뭔가 있음");
		}
		
		// 자바 메소드명
		// 1. isXXX() : 확인? -> boolean 반환
		// 2. getXXX() : 값을 반환 + 읽기
		// 3. setXXX() : 값을 전달 + 세팅 + 쓰기 
		
	
	}
	
	public static boolean isEmpty(String str) {
		
		if (str.equals("")) {
			return true;
		} else {
			return false;
		}
		
		
		
	
	
	}




	private static void m12() {
		
	
		// 특정 문자열의 포함 유무
		//   - boolean contains(String word)
		String str = "안녕하세요. 홍길동.";
		
		System.out.println(str.contains("홍길동"));
		System.out.println(str.contains("아무개"));
		
		System.out.println(str.indexOf("홍길동") > -1); // 값이 존재하지않을경우 -1를 리턴해주기때문에 이 경우엔 contains와 똑같은 역할
		
	
	
	
	}

	private static void m11() {
		
		// 문자열 치환, 바꾸기
		
		//   - 대상 문자열에서 특정 문자열을 찾아서 다른 문자열로 바꾸기
		//   - String replace(String old, String new)
		
		String str = "안녕하세요. 홍길동님. 안녕히가세요. 홍길동님.";
		
		String word1 = "홍길동";
		String word2 = "아무개";
		
		// str : word1 => word2 
		
		String sub1 = str.substring(0, str.indexOf(word1)); // 안녕하세요. //
		String sub2 = str.substring(str.indexOf(word1) + word1.length());  // 님.
		
		System.out.println(sub1 + word2 + sub2); // 안녕하세요. 아무개님. 안녕하가세요. 홍길동님.
		
		System.out.println(str.replace(word1, word2)); // 안녕하세요. 아무개님. // 다 바뀜 //replace 메소드 오버로딩 지원 ㅇㅇ charSequence = String과 호환 ㅇㅇ 
		System.out.println(str.replace(word1, ""));
		System.out.println(str.replace(" ", "")); // 공백제거 (trim 은 앞뒤 공백만제거 / 이것은 모든 공백 제거)
		
		// 주민번호 입력 -> '-' 입력
		String jumin = "951220-2012457";
		
		System.out.println(jumin.replace("-", ""));
		
		// 게시판 글쓰기 -> 금지어 "바보"
		String content = "게시판 바보야!!";
		
		System.out.println(content.replace("바보", "**"));
	}



	private static void m10() {

		// 지역 변수
		// - 메소드나 제어문안에서 선언된 변수
		int m = 10;
		int n = 0;

		if (m > 0) {
			n = 10; // 지역 변수
			System.out.println(n); // 10
		}

		System.out.println(n); // 10
		int i = 0;
		for (i = 0; i < 10; i++) { // 10이 된다음 쫓겨남

		}

		// i ?
		System.out.println(i);

		for (int j = 0; j < 10; j++) {

		}
		
	} // m10









	private static void q1() {
			
		//요구사항)
		// - 경로 : "D:\Class\Java\JavaTest\src\Ex27_String.java"
		// - 경로 : "C:\Images\dog.png"
		
		// 1. 파일명? -> Ex27_String.java
		// 2. 확장자를 뺀 순수한 파일명? -> Ex27_String
		// 3. 확장자? -> ".java"
		
		// 사용)
		// 1. indexOf / lastIndexOf
		// 2. substring
		
		String path = "D:\\Class\\Java\\JavaTest\\src\\Ex27_String.java";
		String path2 = "C:\\Images\\dog.png";
	
		// 1.
		int locat = (path.lastIndexOf("\\") + 1);
		System.out.println(path.substring(locat)); // 파일명(전체)
		
		// 2.
		
		int fileType = (path.lastIndexOf("."));
		System.out.println(path.substring(locat, fileType)); // 파일명 
		
		// 3. 
		
		System.out.println(path.substring(fileType)); //확장자명
		
	
	}









	private static void m9() {
		
		// 문자열 추출
		
		//   - char charAt(int index)
		//   - String substring(int start, int end)
		//                           포함     미포함
		
		String str = "안녕하세요. 홍길동님.";
		
		System.out.println(str.substring(3, 8)); // 세요. 홍 // 3 인덱스에서 7 인덱스 까지 출력 
		System.out.println(str.substring(7, 10));
		
		String jumin = "951220-2014587";
		
		// 성별?
		if (jumin.substring(7, 8).equals("1")) { // 7 
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		// 몇년생?
		System.out.println("19" + jumin.substring(0, 2)); // 0 ~ 1
		
		// 몇월생?
		System.out.println(jumin.substring(2, 4)); // 2 ~ 3
	
		System.out.println(str.substring(3, 8)); // 3 ~ 7
		System.out.println(str.substring(3));    // 3 ~ 끝까지 / 이걸 더 잘씀
		System.out.println(str.substring(3, str.length())); // 3 ~ 끝까지
		
	} // m9


	private static void m8() {
		
		// 패턴 검색
		
		//    - boolean startsWith(String str)
		//    - boolean endsWith(String str)
		
		String name = "홍길동";
		
		// '홍'씨 입니까?
		System.out.println(name.startsWith("홍"));
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf("홍") == 0);
		
		// '동'으로 끝납니까?
		System.out.println(name.endsWith("동"));
		System.out.println(name.charAt(name.length() - 1) == '동');
		System.out.println(name.lastIndexOf("동") == name.length() - 1); // 그냥 indexOf 를 쓰면 글자가 중복될 경우에 마지막 글자가 아닌 그보다 먼저 온 글자를 찾아올수도 있어서 lastIndexOf를 사용
		
		
		
		
	} // m8



	private static void m7() {
		
		// 문자열 검색(****)
		//   - 문자열내에서 원하는 문자(열)을 검색 -> 찾은 위치를 반환
		//   - 반환값 int indexOf(char c)
		//   - int indexOf(String c)
		//   - int indexOf(char c, int starIndex)
		//   - int indexOf(String s, int startIndex)
		//   - int lastIndexOf(char c)
		//   - int lastIndexOf(char c)
		
		String str = "안녕하세요. 홍길동님.";
		
		
		
		
		System.out.println(str.indexOf('홍'));  // 7
		System.out.println(str.indexOf("홍길동")); // 7 (첫글자의 위치가 반환; 한 덩어리로 본다)
		System.out.println(str.indexOf("아무개")); // -1 (존재하지 않음)
	
			// "홍길동"이 있다면
		if (str.indexOf("홍길동") > -1) {
			System.out.println("홍길동 발견!!");
		} else {
			System.out.println("홍길동 없음;;");
		}
		
		String jumin = "951220-2102145";
		
//		if (jumin.charAt(6) == '-') {   인덱스 넘버의 문자를 불러옴
		if (jumin.indexOf('-') == 6) {  // 해당 문자(열) 이 있는 인덱스 넘버를 불러옴
			System.out.println("올바름");
		} else {
			System.out.println("올바르지 않음");
		}
		
		
		// 게시판 글쓰기
		//   - 관리자 모드
		//   - 금지어
		String content = "게시판 테스트입니다. 바보 어쩌구 저쩌구";
		String word = "바보";

		// content 에서 word를 찾는다 
		if (content.indexOf(word) > -1) {
			System.out.println("금지어 사용 불가!!!");
		} else {
			System.out.println("글쓰기 완료!!");
		}
		
		
																//      35 v 
		str = "안녕하세요. 홍길동님. 안녕히가세요. 홍길동님. 안녕히가세요. 홍길동님.";
		
		System.out.println(str.indexOf("홍길동")); // 7 (처음 발견한것을 돌려줌)
		System.out.println(str.lastIndexOf("홍길동")); // 뒤에서 부터 찾기 (역시 제일 첫글자 위치를 돌려줌)
		System.out.println(str.indexOf("홍길동", 10)); // 21 
											//   님 부터 찾기
		
		
		//변화에 강해지는 코드
		int index = str.indexOf("홍길동");		
		System.out.println(index);
								 // +  글자 길이 
		index = str.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);
		
		index = str.indexOf("홍길동", index + "홍길동".length());
		System.out.println(index);
		
		
		
		
	} // m7









	private static void m6() {
		
		// 문자열 공백 제거 (맨 앞에 있는 공백과 맨 뒤에 있는 공백 제거)
		//   - String trim()
		
		String str = "     하나     둘     셋      넷";
		System.out.printf("[%s]\n", str);    	 // [     하나     둘     셋      넷]
		System.out.printf("[%s]\n", str.trim()); // [하나     둘     셋      넷]
		

	} // m6


	private static void m5() {
		
		// 주민번호 입력 -> 반드시 '-' 입력
		String jumin = "951220-1014785";
		    // 문자 빼오기 & 문자열 타입 char 타입으로 형변환
		if (jumin.charAt(6) == '-') {
			System.out.println("올바릅니다.");
		} else {
			System.out.println("올바르지 않습니다.");
		}
		
		
		
		if (jumin.charAt(7) == '1') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		} 
		
	} // m5


	private static void m4() throws IOException {
		// TODO 내일 오후에 반드시 구현해 놓을 것!!!! (to do; 할일 들)  > window > showview > task  에서 확인 가능 
		
		// 사용자 아이디 입력 -> 유효성 검사 
		// 조건)
		// 1. 영어 소문자만
		// 2. 길이 4자 ~ 12자 이내
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아이디 입력: ");
		String id = reader.readLine();
		
		boolean flag = false;
		
		
		// 한 글자씩 추출 -> 문자 코드값 비교 
		for (int i = 0; i < id.length(); i++) {
			
			char c = id.charAt(i);
			
//			if (c >= 'a' && c <= 'z') {
//				System.out.println("1");
//			} else {
//				System.out.println("2");
//				
//			}
			
			//유효성 검사 -> 잘못된 것을 찾는 조건을 사용한다.
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) { // 소문자나 대문자가 아니냐?
				flag = true;  // 한글자라도 조건을 충족하지못하면 flag가 변질되서 break를 타고 for문을 빠져나간다
				break;
			}

		} // for 
		
		// 길이 검사
		if (id.length() < 4 || id.length() > 12) {
			flag = true;
		}
		
		
		// 마무리
		if (!flag) {
			System.out.println("아이디 사용 가능");
		} else {
			System.out.println("아이디 사용 불가능");
		}
		
	} // m4









	// Alt + 위아래 방향키 		  // 코드 이동 
	// ctrl + alt + 위아래 방향키 // 코드 복제 
	// 블럭 잡기 > 오른클릭 > 리팩터 > 익스트랙트 메소드 = 다른 메소드로 따로 빼줌
	
	public static void m1() {
		
		// 문자열, String
		//   - 자바에서 String 클래스내에 여러가지 기능을 구현
		
		// 문자열의 길이
		//   - 문자열을 구성하는 문자의 갯수
		//   - 영문자, 숫자, 한글, 특수문자 등에 상관없이 문자 1개당 1개로 계산 (유니 코드 기반으로 계산된다)
		//   - int length()
		
		String str = "홍길동 입니다.";
		System.out.println(str.length()); // 8 
		
		
		
	} // m1


	private static void test() {
		System.out.println("홍길동");
		int a = 10;
		int b = 20;
	}
									// throws Exception 
	private static void m2() throws IOException {
		// TODO Auto-generated method stub // stub 생성 
		
		// 유효성 검사
		// 회원 가입 > 이름 >  길이 제한
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "";
		
		System.out.print("이름 입력: ");
		name = reader.readLine();
		
		// System.out.println(name.length());
		if (name.length() >= 2 && name.length() <= 5) {
			System.out.println("회원 가입 완료");
		} else {
			System.out.println("이름을 다시 입력하세요.");
		}
		
		
		System.out.println(name.length());
		System.out.println("홍길동".length()); // 상수에도 length() 할수 있음
		
	} // m2 

	private static void m3() {
		
		// 문자열 추출
		//   - char chatAt(int index)
		//   - 문자열 내에 특정 위치에 있는 문자 1개를 추출
		//   - 자바는 서수를 0부터 시작. Zero-based index 사용 
		//   - 문자열 첨자 범위 : 0 ~ (길이 - 1)
		
		
		String str = "안녕하세요. 홍길동님.";
		
		char c = str.charAt(3);
		
		System.out.println(c);
		
	    c = str.charAt(11);
		System.out.println(c);
		
		
		// java.lang.StringIndexOutOfBoundsException 존재하지 않는 순서 쓰면 에러 
		// c = str.charAt(12);
		// System.out.println(c);
		
		c = str.charAt(3);
		System.out.println(c);
		
		System.out.println(str);

					// 마지막 글자를 가져오시오 
		c = str.charAt(str.length() - 1);
		System.out.println(c);
		System.out.println();
		
		
		str = "가나다라마바사"; // 사용자 입력
		
		// 요구사항) str을 1문자씩 추출해주세요.
		// str.charAt(0)
		// str.charAt(1)
		// str.charAt(2)
		// str.charAt(3)
		// str.charAt(4)
		 
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			
		} // for 
		
		
	
	}
	
} // class
