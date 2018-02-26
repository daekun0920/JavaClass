class Ex25_for {

	public static void main(String[] args) {
		
		// Ex25_for.java

		/*

		for 문
		-  반복문
		-  조건을 만족하는 동안 (블럭을) 반복해서 실행해라

		for (초기식; 조건식; 증감식) {
			실행 코드;
		
		}
		
		*/
			
		//m1();
		m2();

	} // main()
	public static void m2() {

		//for (int i = 0; i < 10; i++) {
		//for (int i = 1; i <= 10; i++) {
		for (int i = 324; i <= 334; i++) {
			System.out.println("역삼동");

		}
		
		// 루프 변수의 역할
		// 1. 회전 수를 결정한다. (초급)
		// 2. 루프 변수의 값을 업무에 사용한다. (중/고급)

		// 요구사항) 숫자를 1 ~ 10000000까지 출력하시오
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		 // i = i + 1;	// 1, 3, 5, 7, 9		
		 // i += 1;
		 // i++
		 //	i = 5; // 무한 루프
		}
		
		// 요구사항) 숫자 1 ~ 10 사이의 짝수를 출력하시오.
		for (int i = 2; i < 11; i = i + 2) {  // 12가 된다음 쫓겨난다 
				//   1에서  10 까지
			System.out.println(i);
			
			//if (i % 2 == 0) {
			//System.out.println(i);
			//}
		}

		for (int i = 1; i < 11; i = i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		
		}
	
	} // m2



	public static void m1() {
		
		// 반복 -> loop
		// for i, j -> 루프 변수(지역 변수)
		for (int i = 0; i < 3; i++) {		  // 0 부터 시작 0 ~ 9							   // 초기식은 초반에 딱 한번만 실행 
			System.out.println("안녕하세요"); // i < 초기식 일경우 조건식 - 초기식 = 반복 횟수 // i <= 초기식 일경우 조건식 - 초기식 = 반복 횟수 + 1 
		
		
		
		} // 반복문은 끝블럭을 만나면 다시 올라간다 
		
		int j = 0;

		for (j = 0; j < 3; j++) {
			System.out.println("반갑습니다.");
		
		}
	
	
	} // m1



}
