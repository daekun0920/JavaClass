class Ex19_Method {

	public static void main(String[] args) {
		
		// Ex19_Method.java

		// 재귀 메소드, Recursive Method  // 이해가지 않을때는 직접 그려보며 하면 더욱 도움됨
		//  - 메소드가 실행 중에 자기 자신을 호출하는 형태의 메소드

		// m1();

		// 팩토리얼 구하기
		// 4! = 4 x 3 x 2 x 1 = 24
		int n = 4;
		int result = factorial(n); // 4!
		System.out.printf("%d! = %d\n", n, result);



	} // main

	public static int factorial(int n) {
		int temp = (n == 1) ? 1 : n * factorial(n - 1); // 재귀 구조
		return temp;
	
	
	
	
	} // factorial()

    // m1() : 재귀 메소드
	public static void m1() {
		System.out.println("m1() 실행");
		m1(); //이름이 같고 똑같이 생긴 서로 다른 메소드라고 생각하자(아예 m2라고 생각해도됨) // 재귀 호출(Recursive call)
	
	
	
	} // m1()
	

	
}
