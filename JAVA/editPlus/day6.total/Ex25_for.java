import java.io.*;

class Ex25_for {

	public static void main(String[] args)throws Exception{
		
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
		//m2();
		//m3();
		//m4();
		//m5();
		m6();

	} // main()
	public static void m6() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 요구사항) 사용자가 입력한 10개의 숫자의 총합을 구하시오.
		// 입력) 숫자 : 5
		//       숫자 : 7
		// ...
		//       숫자: 10
		// 출력) 총합 : 424


		// 누적변수
		// for문 안에다 넣으면 안됨
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			

			// 누적
			sum += num;
			
		}	
		System.out.println(sum);
	
	
	
	
	}

	public static void m5() {
		
		// 루프 -> 누적값 구하기 

		//요구사항) 1 ~ 10 까지의 합 구하기
		//    0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		//   (0 + 1) + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		//  ((0 + 1) + 2) + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		// (((0 + 1) + 2) + 3) + 4 + 5 + 6 + 7 + 8 + 9 + 10

		// 누적 변수
		//   - 누적 변수는 누적 연산에 영향을 주지 않기 위해서 항상 0으로 초기화

		int sum = 0; // for문이 실행된다는 보장이 없기때문에 초기화를 해야한다 // for문이 실행되도 Null + 1 이 되기때문에 반드시 초기화 해야함

		for (int i = 1; i <= 10; i++) {
			sum = sum + i; // 누적
		}
		System.out.println(sum);
		

		// 1 ~ 100 사이의 짝수의 합
		sum = 0;
		for ( int i = 2; i <= 100; i += 2) {
			sum += i; // sum = sum + i 

		}
		System.out.println(sum);
		
		// 1 ~ 100 사이의 홀수의 합
		sum = 0;
		for ( int i = 1; i <= 100; i += 2) {
			sum += i; // sum = sum + i 

		}
		System.out.println(sum);



		int stack = 0;

		for (int i = 1; i <= 10; i++) {
			stack = stack + i;
			System.out.println(stack);
		}

	
	}

	
	public static void m4() throws Exception {

		// 구구단 출력하기
		// 5 x 1  = 5
		// 5 x 2 = 10 
		// 5 x 3 = 15
		// ..
		// 5 x 9 = 45
		// System.out.println("===============");
		// System.out.println("      5단");
		// System.out.println("===============");
		
		for (int i = 1; i < 10; i++) {
			//System.out.printf("5 x %d = %2d\n", i, 5 * i);
									// 2 자리 공간 얻어오기
		}							// 양수 - 우측정렬, 음수 - 좌측정렬
		// 요구사항) 사용자로부터 원하는 단과 최대값을 입력받아서 구구단을 출력하시오.
		// 입력) 단: 5
		//   최대값: 15
		// 출력) 5 x 1 = 5
		//       ..
		//       5 x 15 = 75
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int dan = 0;
		int max = 0;

		System.out.print("단 : ");
		dan = Integer.parseInt(reader.readLine());

		System.out.print("최대값 : ");
		max = Integer.parseInt(reader.readLine());

		System.out.println("===============");
		System.out.printf("      %d단\n", dan);
		System.out.println("===============");

		for (int i = 1; i <= max; i++) {
			System.out.printf("%2d x %2d = %4d\n", dan, i, dan * i);
		
		
		}
		
		
	
	} // m4

	public static void m3() {
		
		for (int i = 1; i <= 10; i++) {  // 1 부터 10 까지 
			// System.out.println(i + "\t");
			System.out.println(11 - i + "\t");
		}
		System.out.println();
		
		//요구사항) 10 ~ 1 출력
		for (int i = 10; i >= 1; i--) {
			System.out.println(i + "\t");
		
		}
	
	
	
	} // m3




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
