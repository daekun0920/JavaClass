import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex16_Method {

	public static void main(String[] args) throws Exception {
		
		// Ex16_Method.java

		/*
		
		메소드 선언

		접근지정자 정적키워드 반환명 메소드명(인자리스트) {
		
		구현부


	     }

		*/
		
		// 인자 리스트(Parameters, Arguments)

		// 요구사항) "홍길동님 안녕하세요." - 출력 메소드
		// System.out.println("홍길동님 안녕하세요.");
		// hello();
		
		//public static void hi(String name)
		hi("홍길동");  // 인자(파라미터) 넘겨주기 

		// 추가사항) "아무개님 안녕하세요." 출력
		// System.out.println("아무개님 안녕하세요.");
		// hello();
		hi("아무개");

		// 추가사항) 우리 강의실의 모든 사람 대상
		// 추가사항) 한독 건물
		// 추가사항) 지구인


		// hi(); // 파라미터(Parameters, Arguments) 없이는 컴파일 불가능
		// hi(100);
		// hi("하하하", 100);
		add(10, 20);
		add(142, 22);
		add(5350, 1440);
		add(12, 775);
		

		check("홍길동", 25);
		check("아무개", 12);
		check("하하하", 80);

		int n = num();
		System.out.println(n);
		
		bye();
		
		int m = 5;

		int result = getSquare(m); // 실인자(매개변수 값)
		System.out.println(result);
      // 밑에 경우 변수를 하나 줄일수 있음 (가독성은 다소 떨어짐) 
		System.out.println(getSquare(m));

	} // main

	public static void hello() {
		
		System.out.println("홍길동님 안녕하세요.");
	

	} // hello
	
	public static void hi(String name) {
		// String name = "홍길동";
		System.out.println(name + "님 안녕하세요.");
	

	

	}
	
	public static void add(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);



	}

	public static void check(String name, int age) {
		String result = (age >= 20 && age < 60) ? "통과" : "탈락";
		System.out.printf("고객 '%s'님은 '%s'입니다.\n"
						  , name, result);


	
	
	}

	public static int num() {
	
		
		//리턴문, 반환문 
		return 10; // int여야함 (반환명 int)
	
	
	
	
	
	}
	
	// 이름을 입력하면 인사하기
	// void = 반환값이 없다 
						//  BufferedReader 가 있는곳과 그곳을 호출한곳 
	public static void bye() throws Exception {
		BufferedReader reader
			= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 입력: ");

		
		String name = reader.readLine();

		System.out.printf("%s님 안녕하세요.\n", name);
		

	}

	// 숫자 1개 전달 -> 제곱값을 반환
	// 2 -> 4
	// 8 -> 64
	
	// 메소드 헤더
	//   -> 메소드 시그너쳐(Signature)
	//   -> 메소드 서명       

	// 반환값(리턴) 자료형과 반환명 자료형이 같아야함
	public static int getSquare(int n) { // 가인자(매개 변수)
		
		int result = 0;
		
		result = n * n;
		

		System.out.println("작업이 완료되었습니다.");

		return result; // 메소드 종료


		// return n * n; (이게 나음)
		
		// System.out.println("작업이 완료되었습니다."); -> return 에서 메소드가 종료되기때문에 도달하지못해서 오류가 나옴
	
	
	}

	

}
