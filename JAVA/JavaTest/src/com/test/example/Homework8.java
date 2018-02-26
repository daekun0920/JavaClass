package com.test.example;
import java.util.Scanner;

public class Homework8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
	문자열 문제 

	문제1.

	요구사항) 문장을 입력받아 역순으로 출력하시오.
	입력) 문자 : 안녕하세요. 홍길동입니다.
	출력) 결과 : .다니입동길홍 .요세하녕안
	힌트) 첨자(index)
	*/
	//reverseString();	
		
	
	
	

	/*
	문제2.

	요구사항) 숫자를 입력받아 항상 3자리로 출력하시오오오.
	입력)숫자: 1
	출력)결과: 001
	입력)숫자: 24
	출력)결과 : 024
	입력)숫자 : 123
	출력) 결과: 123

	조건) 최대 3자리까지만 입력.
	*/
	//numExtend();
	/*
	System.out.print("숫자 : ");
	int num = scan.nextInt();
	
	if (num < 10) {
		System.out.println("00" + num);
	} else if (num < 100){
		System.out.println("0" + num);
	} else if (num >= 100){
		System.out.println(num);
	} else {
		System.out.println("최대 3자리까지만 입력 가능합니다.");
	}
	*/
	
	/*
	문제3.

	요구사항) 숫자를 입력받아 3자리마다 ','를 붙이시오.
	입력) 숫자 : 1234567
	출력) 결과 : 1,234,567
	조건) %, d 사용불가 
	
	*/
		/*System.out.println("숫자 : ");
		String num = scan.nextLine();
		String reversed = flip(num);
		String stack = "";
		String sub1 = "";
		while (stack.length() <= 3) {
			sub1 = sub1 + reversed.charAt(stack.length());
			
		}
		sub1 = sub1 + ",";
	*/
 	
	/*
	문제4.

	요구사항) 숫자를 입력받아 한글로 바꿔서 출력하시오.
	입력) 금액(원) : 1500
	출력) 결과 : 일천오백원 
	조건) 입력값은 최대 천단위
	*/
		
	System.out.print("금액(원) : ");
	int total = scan.nextInt();
	
	int thouNum = total / 1000;
	int hunNum = (total % 1000) / 100;
	int tenNum = ((total % 1000) % 100) / 10;
	int oneNum = (((total % 1000) % 100) % 10);
	
	if (thouNum == 1) {
		System.out.print("일천");
	} else if (thouNum == 2) {
		System.out.print("이천");
	} else if (thouNum == 3) {
		System.out.print("삼천");
	} else if (thouNum == 4) {
		System.out.print("사천");
	} else if (thouNum == 5) {
		System.out.print("오천");
	} else if (thouNum == 6) {
		System.out.print("육천");
	} else if (thouNum == 7) {
		System.out.print("칠천");
	} else if (thouNum == 8) {
		System.out.print("팔천");
	} else if (thouNum == 9) {
		System.out.print("구천");
	} 
	
	if (hunNum == 1) {
		System.out.print("백");
	} else if (hunNum == 2) {
		System.out.print("이백");
	} else if (hunNum == 3) {
		System.out.print("삼백");
	} else if (hunNum  == 4) {
		System.out.print("사백");
	} else if (hunNum  == 5) {
		System.out.print("오백");
	} else if (hunNum  == 6) {
		System.out.print("육백");
	} else if (hunNum == 7) {
		System.out.print("칠백");
	} else if (hunNum  == 8) {
		System.out.print("팔백");
	} else if (hunNum  == 9) {
		System.out.print("구백");
	} 
	
	if (tenNum == 1) {
		System.out.print("십");
	} else if (tenNum == 2) {
		System.out.print("이십");
	} else if (tenNum == 3) {
		System.out.print("삼십");
	} else if (tenNum == 4) {
		System.out.print("사십");
	} else if (tenNum == 5) {
		System.out.print("오십");
	} else if (tenNum == 6) {
		System.out.print("육십");
	} else if (tenNum == 7) {
		System.out.print("칠십");
	} else if (tenNum == 8) {
		System.out.print("팔십");
	} else if (tenNum == 9) {
		System.out.print("구십");
	} 
	
	if (oneNum == 1) {
		System.out.print("일");
	} else if (oneNum == 2) {
		System.out.print("이");
	} else if (oneNum == 3) {
		System.out.print("삼");
	} else if (oneNum == 4) {
		System.out.print("사");
	} else if (oneNum == 5) {
		System.out.print("오");
	} else if (oneNum == 6) {
		System.out.print("육");
	} else if (oneNum == 7) {
		System.out.print("칠");
	} else if (oneNum == 8) {
		System.out.print("팔");
	} else if (oneNum == 9) {
		System.out.print("구");
	} 
	
	System.out.print("원");
	
	
	
	
 	/*
	문제5.

	요구사항) 특정 단어가 몇번 들어갔는지 세시오.
	상황) String content = "안녕~ 길동아~ 잘가~ 길동아~";
		  String word = "길동";
		  
	출력) '길동'을 총 2회 발견했습니다.
	힌트) 1. indexOf()
		  2. replace(word, "")
	*/
		/*String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int count = 0;
		
		for (int i = 0; i < ; i++) {
			int index = content.indexOf(word);
			if (content.indexOf(word) > -1) {
				content.indexOf(word, index + word.length());
				count++;
				
			}
			
		}
		System.out.println(count);
	*/
		
	/*
	문제6.
	
	요구사항) 주민번호 유효성 검사
	입력) 주민번호 : 951220-1021547
	출력) 결과 : 올바른(올바르지 않은) 주민번호입니다.
	추가) '-' 선택
	
	*/
	/*
	 문제7.
	 
	 요구사항) 이메일 주소를 입력받아 아이디.도메인을 추출하시오~
	 입력) 이메일 : hong@naver.com
	 출력) 아이디 : hong
	 	   도메인 : naver.com
	 */
	
	/*
	 문제 8.
	 
	 요구사항) 숫자를 입력받아 각 숫자의 합을 구하시오오오오오
	 입력) 숫자 : 314
	 출력) 결과: 3 + 1 + 4 = 8
	 생각) 1. nextLine() -> "314"
	  	   2. nextIn() -> 314
	 조건) 최대 5자리까지만.. 	 
	 */
	
	/*
	 문제9.
	 
	 요구사항) 공백 제거하시오오오오
	 원본) 문자열 : "      하나       둘     셋      "
	 출력) 문자열 : "      하나둘셋      "
	 */
	
	/*
	 
	 문제 10.
	 
	 요구사항) 영어 단어를 입력받아 아래와 같이 출력하시오.
	 입력) 단어 : StudentName
	 출력) 결과 : Student Name
	 조건) 입력은 파스칼 표기법으로만... : ) 
     	
	 
	 */
	
	/*
	 문제11.
	 
	 요구사항) 파일명 x 10개입력 -> 확장자별로 갯수 출력하시오.
	 입력) 파일명 : dog.gif
	 	   파일명 : cat.jpg
	 	   파일명 : 컵.jpg
	 	   파일명 : 이력서.hwp
	 	   파일명 : 책상.jpg
	 	   ..
	 
	 출력) gif : 1개
	 	   jpg : 3개
	 	   hwp : 1개 
	 
	 조건) 확장자(gif, jpg, png, hwp, doc)
	 	   확장자 추출 + 누적값 구하기 
	 */
	
	} // main
	public static String flip (String num) {
		String result = "";
		for (int i = num.length() - 1; i >= 0; i--) {
			result = result + num.charAt(i);
			
			
			
		}
		return result;
		
		
	}
	
	public static void numExtend( ) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = scan.nextInt();
		
		if (num < 10) {
			System.out.println("00" + num);
		} else if (num < 100){
			System.out.println("0" + num);
		} else if (num >= 100){
			System.out.println(num);
		} else {
			System.out.println("최대 3자리까지만 입력 가능합니다.");
		}
		
		
	}
	
	
	
	public static void reverseString( ) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("문자 : ");
		String reverse = scan.nextLine();
		String result = "";
		
		for (int i = reverse.length() - 1; i >= 0; i--) {
			result = result + reverse.charAt(i);
			
		}
		System.out.println(result);
		
		
		
		
	}

	
}
