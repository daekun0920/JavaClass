import java.io.*;
import java.util.Random;

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
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		//m13();
		//m14();
		m15();
	
	
	
	} // main()
	public static void m15() {

		// 2중 for문 -> 별찍기

		for (int i = 0; i < 5; i++) {	// 행
			for (int j = 0; j < (5 - i); j++) { // 셀 
				System.out.print("*");

			}
			System.out.println();
		}


	
	
	
	
	}

	public static void m14() {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {


				if (j > 5 || i < 3) {
					//break;
					continue;
				}


				System.out.printf("i : %d, j : %d\n", i, j);

			}

		}

	
	}

	
	public static void m13() {
		




		// 구구단 출력



		for (int j = 2; j < 10; j++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d x %d = %2d\n", j, i, j * i);

			}
			System.out.println();
		}


	}

	public static void m12() {
		
		// 25명
		// 6강의실
		// 학생들이 순서대로 지문 체크
		for (int i = 1; i <= 6; i++) {		// 강의실
			for (int j = 1; j <= 25; j++) { // 학생
				System.out.printf("%d 강의실 %d번 학생 지문체크\n"
								 , i , j);
			}
		}
		// 아파트
		for (int k = 1; k <= 5; k++) {
			// 5개동
			for (int j = 1; j <= 23; j++) {
				// 23층
				for (int i = 1; i <= 10; i++) {
					// 10세대
					// 1층 1호 -> 101호
					// 1층 12호 -> 112호 
					System.out.printf("%d동 %d%s호\n", k, j, getNum(i));

				}
			}
		}
	}


	public static String getNum(int i) {
		//  1 -> "01"
		// 10 ->  10
		if (i < 10) {
			return "0" + i;
		
		
		} else {
			//return String.valueOf(i); // 문자열로 변환
			return i + ""; // 문자열로 변환
		}	
	
	}

	public static void m11() {
		
		// 중첩
		//   - for문안에 또 다른 for문을 사용 
		
		// 2중 for문 
		/*
		for (int i = 0; i < 12; i++) {
			// x 10회
			// System.out.println("Hi~");
			for (int j = 0; j < 60; j++) {
				// x 10회
				// System.out.println("안녕~");
				System.out.printf("i : %d, j : %d\n", i, j);
			}

		}
		*/

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					System.out.printf("i : %d, j : %d, k : %d\n"
									  , i, j, k);

				}

			}

		}

	
	} // m11

	public static void m10() {

		// break, continue
		//   - 독립적인 사용을 안하고 다른 제어문과 함께 사용한다.
		//   - 반복문과 같이 잘 사용한다.
		
		// break
		//   - 자신이 속한 제어문을 탈출한다. (메소드의 return과 같음(return은 메소드 탈출))
		//   - if문 제외(if문은 인식하지 않는다.) (if문을 뺀 나머지 제어문을 탈출)

		// continue
		//   - 하던일을 멈추고 다시 꼭대기(증감식)로 돌아가라
		//   - if문 제외(if문은 인식하지 않는다.)

		for (int i = 1; i <= 10; i++) {
			
			
			if (i == 5) {
				//break;
				continue;  // 하던일을 멈추고 다시 꼭대기(증감식)로 돌아가라
			}
			System.out.println(i); // 1 2 3 4 6 7 8 9
		}
		//요구사항) 학교 담임 선생님 -> 학생 상담 -> 번호 순서대로 ...
		for (int i = 1; i <= 30; i++) {

			// 15번까지만..
			//if (i == 16) {
			//	break;

			//}
			


			// 7번 결석
			if (i == 7 || i == 12 || i == 25) {
				continue;
			
			}
			System.out.printf("%2d번 학생 상담중...\n", i);

		} // for 
	

	} // m10 

	public static void m9() {
		Random rnd = new Random();

		// 루프 변수 // 초기식이나 증감식은 2개가 가능하지만 조건식은 and 나 or로 가능
		for (int i = 0, j = 0; i < 10 && j < 50; i++, j += 2 + i) {
			System.out.printf("i : %d, j : %d\n", i, j);
		}
	}


	public static void m8() {
		Random rnd = new Random();
		// 무한 루프

		// for (int i = 0; i >= 0; i++) {
		// for (int i = 0; true; i++) {
		// for (;;) { // 가장 fm으로 돌리는 무한루프 (아무값도 넣지않음)
		for (int i = 1;;i += 3) { // 조건식 써주지 않아도됨
			// System.out.println(rnd.nextInt(1000));  // 0 에서 999 까지
			System.out.println(i);
		
		
		}



	}


	public static void m7() {
		
		// 난수 -> 임의의 수

		// 자바 난수 생성기
		// Random 클래스java.util 

		Random rnd = new Random();
		int sum = 0;

		// Math 클래스  java.lan
		
		// * 10 (곱하기 10) 
		// 0.0 -> 0.0
		// 0.1 -> 1.0
		// 0.2 -> 2.0
		// 0.3 -> 3.0
		// 0.4 -> 4.0 
		// 0.99 -> 9.9  // 0 ~ 9 
		

		// 0(inclusive) ~ 1(exclusive) (0 이상 1 미만) 사이의 실수 반환 
		for (int i = 0; i < 10; i++) {
			// Math 클래스 
			// System.out.println(Math.random());

			// 1 ~ 10
			// System.out.println((int)(Math.random() * 10) + 1);  // 정수 변환 
			
			// 1 ~ 45
			// System.out.println(((int)Math.random() * 45) + 1);

			// Random 클래스 
			// System.out.println(rnd.nextInt(10));	 // 최솟값 0 최댓값 9
			// System.out.println(rnd.nextInt(10) + 1); // 최솟값 0 최댓값 10
			// System.out.println(rnd.nextDouble());
			// System.out.println(rnd.nextBoolean());
			
			sum += rnd.nextInt(10) + 1; // 0 부터 10까지의 무작위 수를 10개 더하시오

		} // for 
		System.out.println(sum);
	
	
	} // m7


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
