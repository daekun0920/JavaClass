class Ex11_Input {

	public static void main(String[] args) throws Exception {
		
		// Ex11_Input.java

		// 콘솔 입력 -> 키보드를 통한 입력(내용)을 자바 프로그램에서 사용하기

		// 1. System.in.read()
		// 2. BufferedReader 클래스
		// 3. Scanner 클래스

		// 요구사항) 사용자로부터 문자 1개를 입력받아서 그대로 출력하시오.
		
		// 속어 : block 걸렸다.
		// 입력 대기 상태..
		

		/*

		System.out.print("문자입력 : ");	                         // Label				  
		

		int n = System.in.read();			                         // a 입력시 97(코드값) 출력 // 유니코드 x, ASCI 코드만 가능
		System.out.printf("입력하신 문자는 '%c'입니다.\n", (char)n);

		*/		

		System.out.print("문자입력 : "); // a 입력시 97, 13, 10 다시 a 입력시 97, 13 = 총 97, 13, 10, 97, 13
		int n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);
		
		
		
		
		// 키보드(a 와 엔터 입력 > a\r\n(a와 엔터) 보냄) > 입력 버퍼(임시 값 저장소) > 프로그램이 버퍼에 찾아가 값(a(97)과 \r(13), \n(10))을 가져옴 > 버퍼에 값이 더이상 없어 2개의 값을 더 받으러옴
	}

}
