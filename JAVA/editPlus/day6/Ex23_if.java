import java.util.Calendar;

class Ex23_if {

	public static void main(String[] args) {
		
		// Ex23_if.java

		// m1();
		// m2();
		// System.out.println(m3());
		// m4();
		// m5();
		m6();
	} // main
	public static void m6() {

		// 요구사항) 문자 1개 입력 -> 영소문자?

		String input = "e";

		char c = input.charAt(0);   // "e" -> 'e' 캐릭터 화 

		int code = (int)c; // 101
		
	 // if (code >= 97 && code <=)
	 // if (code >= (int)'a' && (int)'z' <=)
		if (c >= 'a' && c <= 'z') {
			System.out.println("소문자O");
		
		} else {
			System.out.println("소문자X");
		
		}
		

		c = 'A';
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
								   || (c >= '0' && c <= '9')) {
			System.out.println("영문자O + 숫자O");
		
		} else {
			System.out.println("영문자X + 숫자 X");
		
		}


	
	
	
	
	} // m6





	public static void m5() {
		
		// 중첩된 if문, Nested if Statements
		/*

			if () {
				if () {
					if () {
					
					}	
				}	
			} else if () {
				if () {
					
				}	
			} else {
				if () {
					
				}	
			}
		*/

		// 국어 점수 입력 -> 합격, 불합격?
		// 조건 : 60점 이상
		
		int kor = 90;
		
		if (kor >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		

		kor = 85;
		// 유효성 검사
		if (kor >= 0 && kor <= 100) {      
			
			// 비즈니스 코드, 업무 코드
			if (kor >= 60) {                    
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}

		} else {
			
		    // 예외 처리 코드
			System.out.println("점수 다시 입력");  // true절 = 비즈니스 코드, false절 = 예외 처리 코드
		}

		
	} // m5

	public static void m4() {
		
		System.out.println("하나");
		
		Calendar c = Calendar.getInstance();

		if (c.get(Calendar.SECOND) % 2 == 0) {
			return;   // 빈 return문 -> 메소드를 중지 시키는 목적(잘 씀)

		}

		System.out.println("둘");

		System.out.println("셋");


	} // m4



	public static String m3() {

		// return문
		
		int num = 10;

		if (num > 0) {    // 컴파일러는 true인지 false인지 모름 (실행할때만 알수있음) true일때만 리턴이 있으면 false의 경우에는 리턴이 없고 컴파일러는 true인지 false인지 알지 못한다. 그래서 컴파일러 오류가 남						(false일 경우의 리턴값도 넣어야함*******)
			return "통과";
		}
			return "실패";
			
	
	
	
	} // m3
		




	public static void m2() {
		
		if (true) {   // 사용 X
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		
		boolean flag = true;
		
		if (flag) {   // 사용 O 
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		// C -> Java // C언어 : Boolean이 없다. -> true(1), false(0)
		// C언어 : Boolean이 없다.
		// - 정수 : 0(false), 나머지(true)
		// - 실수 : 0.0(false), 나머지(true)
		// - 문자 : '\0' (false), 나머지(true)
		// - 문자열 : "" (false), 나머지(true)
		if (true) {     
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
			
	} // m2

	public static void m1() {

		// 요구사항) 숫자 1개 입력받아 짝수? 홀수?
		int num = 5;
		String result = ""; // 모든 변수는 무슨값이던지 초기화를 시켜주는것이 좋다. // String result; 처럼 초기값이 없으면(else가 else if일 경우에는) else if 의 값을 만족 못할것을 대비하여 result의 값이 존재하지 않으므로 컴파일러 오류가 생긴다 

		if (num % 2 == 0) {
		    // 짝수
			// System.out.printf("입력한 숫자 %d는 짝수입니다.\n", num);
			result = "짝수";
		} else {
			// 홀수
			// System.out.printf("입력한 숫자 %d는 홀수입니다.\n", num);
			result = "홀수";
		}
	System.out.printf("입력한 숫자 %d은 %s입니다.\n", num, result);     // 보다 효율적인 코드임. 바꿀때 여러줄 바꿀 필요없음 
	
	} // m1



}