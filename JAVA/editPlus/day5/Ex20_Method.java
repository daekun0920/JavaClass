class Ex20_Method {

	public static void main(String[] args) {
		
		// Ex20_Method.java

		// "."
		//  - 멤버 접근 연산자
		//  - 부모.자식

		// 메소드를 호출하는 방법
		// 1. 메소드명()                    // 같은 클래스내에 있는 메소드에만 사용 가능
		// 2. 클래스명.메소드()
		// 3. 패키지명.클래스명.메소드명()  // 정석
		

		
		m1();             // 1 
		Ex20_Method.m1(); // 2

	} // main
	
	public static void m1() {
		System.out.println("m1");
	
	
	
	}


}
