import java.io.*;

class Homework6 {

	public static void main(String[] args) throws Exception{
		/*
		for문

문제1.

요구사항) 이름과 횟수를 입력받아서 획수만큼 인사
입력) 이름 : 홍길동
      횟수 : 3
출력) 홍길동님 안녕하세요~
      홍길동님 안녕하세요~
      홍길동님 안녕하세요~
		*/
		//greet();
		/*
문제2.

요구사항) 숫자 1개를 입력받아 1부터 ~ 입력한 숫자까지의 합을 출력하시오.
입력) 숫자 : 5
출력) 1 ~ 5 : 15 
추가) 천 단위 출력
		*/
		//sum();

		/*

문제3. 

요구사항) 숫자 10개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오 .
입력) 숫자 : 5
      숫자 : 7
      ...
출력) 짝수의 합: 52
      홀수의 합: 46
		*/
		//evenOdd();

		/*


문제4.

요구사항) 아래와 같이 출력하시오.
출력) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
출력) 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		sumLine();
		*/
		//sumLine();
		/*
문제5.

요구사항) 아래와 같이 출력하시오.
출력) 1 + 2 + 3 + 4 + 5 + ... + ? = 10xx
조건) 누적값이 1000을 넘어가는 순간까지만 출력하시오.
		
	
		*/
		thousand();
		
		/*
문제6.  /*****

요구사항) 서기 1년 1월 1일부터 2017년 12월 6일까지 총 며칠이 지났는지 구하시오.
출력) 총 4,564,422 일 지났습니다.
조건) Calendar 사용 금지
사용) for문 사용, 윤년 계산
검증) 결과 % 7 = ? 
		dayCount(); 736,669
*/
	//dayCount();
/*

문제7. /*****

요구사항) 369 게임을 출력하시오.
출력) 1 2 짝 4 5 짝 ....
조건) 100 까지
       33 - 짝짝 

	int d1 = 1/ 100;
	int d2 = i / 10 % 10;
	int d3 = i % 10; 


		*/
	//threeSixNine();
	
	} // main

	public static void threeSixNine() {
		
		for	(int i = 1; i <= 100; i++) {
			
		}
					
	}


	public static void dayCount()	{
	
	int yearCount = 0;
	int i = 0;
	int leapYear = 0;

	for (i = 1;;i++) {
		if (i == 365) {
			yearCount++;
			i = 1;
			if (leapYear % 4 == 0 || leapYear % 100 != 0 || leapYear % 400 == 0) {
				leapYear++;
			}
		if (yearCount == 2017) {
			break;
		}
		}
	}
	int totalDay = (((yearCount * 365 + (2017 / 4)) - 25) - leapYear);
	System.out.printf("총 %d 일 지났습니다.", totalDay);
	
	} // dayCount()
	
	
	
	
	public static void thousand() {
		/*

문제5.

요구사항) 아래와 같이 출력하시오.
출력) 1 + 2 + 3 + 4 + 5 + ... + ? = 10xx
조건) 누적값이 1000을 넘어가는 순간까지만 출력하시오.
		
		*/

		int sum = 0;
		
		for (int i = 1;;i++) {
			sum += i;
			if (i != 1000) {
			System.out.printf(" %d +", i);
			} else {
			sum += i;
			System.out.printf(" %d = %d\n\n\n", i, sum);	
			break;
			
			
		
			} // if 
		
		} // for
		
	} // thousand()
	
	
	
	
	public static void sumLine() {
			/*

문제4.

요구사항) 아래와 같이 출력하시오.
출력) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
출력) 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		sumLine();

		*/
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
			if (i < 10) { 
			System.out.printf("%d + ", i);
			} else {
			System.out.printf("%d = %d\n", i, sum);
			}
			
		}

		int add = 0;
		for (int i = 1; i <= 10; i++) {
			
			if (i % 2 == 0 && i != 10) {
				add = add - i;
				System.out.printf("- %d +", i);
			
			} else if (i % 2 == 1) {
				add = add + i;
				System.out.printf(" %d ", i);
		
			} else {
				add = add - i;
				System.out.printf("- %d = %d\n\n\n", i, add);
			
			}
		} // for

	} // sumLine()


	public static void evenOdd () throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			/*

문제3. 

요구사항) 숫자 10개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오 .
입력) 숫자 : 5
      숫자 : 7
      ...
출력) 짝수의 합: 52
      홀수의 합: 46
			*/

		
		int sumEven = 0;
		int sumOdd = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());

			if (num % 2 == 0) {
				sumEven += num;
			} else {
				sumOdd += num;
			}

		} // for

		System.out.printf("짝수의 합: %d\n홀수의 합: %d\n\n\n", sumEven, sumOdd);
		

	
	
	
	
	}
	
	
	
	public static void sum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				/*
문제2.

요구사항) 숫자 1개를 입력받아 1부터 ~ 입력한 숫자까지의 합을 출력하시오.
입력) 숫자 : 5
출력) 1 ~ 5 : 15 
추가) 천 단위 출력
				*/
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.printf("1 ~ %d : %d\n\n\n", num, sum);

	
	
	} // sum();
	
	
	
	public static void greet() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			/*
		for문

문제1.

요구사항) 이름과 횟수를 입력받아서 획수만큼 인사
입력) 이름 : 홍길동
      횟수 : 3
출력) 홍길동님 안녕하세요~
      홍길동님 안녕하세요~
      홍길동님 안녕하세요~
		*/
		System.out.print("이름 : ");
		String name = reader.readLine();
		
		System.out.print("횟수 : ");
		int count = Integer.parseInt(reader.readLine());

		for (int i = 0; i < count; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		
		}
		
	} // greet();


	
}
