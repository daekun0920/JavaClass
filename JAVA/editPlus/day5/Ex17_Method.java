class Ex17_Method {

	public static void main(String[] args) {
		// Ex17_Method.java
		
		// 메소드
		//   - 행동의 단위(1가지 목적을 가지고 있는 코드의 집합)
		//   - 프로그램의 전체 흐름 : main() 메소드 -> 메소드 -> 메소드
		//   - 메소드 호출 -> 해당 메소드 정의부로 제어가 이동 -> 해당 메소드 종료 -> 메소드 호출했던 곳으로 돌아가기 : 흐름 파악(***)
		//   - 메소드 구성 요소 : 메소드명, 인자리스트(매개 변수), 반환값

		String str = "둘";
		
		int result = m1(str);
		
		System.out.printf("'%s'는 숫자 '%d'입니다.\n"
						  , str, result);

		// 문자열 더하기 연산자 -> 연산자 실행 순서
		System.out.println(10 + 20 + 30);   //     60
		System.out.println(10 + 20 + "30"); //   3030 
		System.out.println(10 + "20" + 30); // 102030  //  "10"     20    "1020"   30
 		System.out.println("10" + 20 + 30); // 102030  // 문자열 + 숫자 = 문자열 + 숫자 = 문자열 
		
		int a = 10;
		int b = 20;
		System.out.println(a + " + " + b + " = " + a + b);
		System.out.println(a + " + " + b + " = " + (a + b));
		
		// 변수
		// 1. 지역 변수, Local Variable
		//    - 특정 지역내에서 선언된 변수
		//    - 지역 : 메소드, 제어문 등
		// 2. 멤버 변수, Memeber Variable
		//    - 클래스 변수, Class Variable
		
		
		// 지역 변수의 생명 주기(Life Cycle)
		//    - 변수가 언제 태어나고,      언제 죽는지?
		//    -            (메모리 할당)    (메모리 소멸)
		//    - 변수 선언문이 실행될 때 태어나고, 변수 선언문이 포함된 블럭에서 제어가 벗어날 때 소멸된다.
		m2(); // 다른 메소드를 부를땐 돌아올것이기 때문에 메소드의 지역 변수가 죽지않는다

		
		
		int num = 10;
		
		m3(); 

		System.out.println(num);

		m4(num);
		
		System.out.println(num);

	} // main
		
		public static void m4(int num) {
			System.out.println(num);  // 10
			num = 20;

	
	
	
	}


		public static void m3() {
		

			int num = 20;
	
	
	
	
	
	}




	// 모듈화 (쪼개기)
	public static int m1(String str) { // 매개변수
		
			  // str == "하나"
		int n = str.equals("하나") ? 1 : (str.equals("둘") ? 2 : (str.equals("셋") ? 3 : 0));

		return n; // 반환값 
	
	
	
	}
	
	public static void m2() {

		int n = 10;   // 이 메소드가 종료될때 이 변수는 죽는다 
		System.out.println(n);

	
	
	}



}
