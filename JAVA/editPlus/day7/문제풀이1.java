import java.io.*;
import java.util.*;

class Home05 {

	public static void main(String[] args) throws Exception {

		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();

	}

	public static void m1() throws Exception {
		/*
			문제1.
			요구사항] 이름과 횟수를 입력받아서 횟수만큼 인사하시오.
			입력] 이름 : 홍길동
				  횟수 : 3
			출력] 홍길동님 안녕하세요~
				  홍길동님 안녕하세요~
				  홍길동님 안녕하세요~
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String name = "";
		int count = 0;

		System.out.print("이름 : ");
		name = reader.readLine();

		System.out.print("횟수 : ");
		count = Integer.parseInt(reader.readLine());

		for (int i=0; i<count; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}
	}

	public static void m2() throws Exception {
		/*
			문제2.
			요구사항] 숫자 1개를 입력받아 1부터 ~ 입력 숫자까지의 합을 출력하시오.
			입력] 숫자 : 5
			출력] 1 ~ 5 : 15
			조건] 천단위 출력
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 0;
		int sum = 0;

		System.out.print("숫자 : ");
		num = Integer.parseInt(reader.readLine());

		for (int i=1; i<=num; i++) {
			sum += i;
		}

		System.out.printf("1 ~ %d : %,d\n", num, sum);

	}

	public static void m3() throws Exception {
		/*
			문제3.
			요구사항] 숫자 10개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
			입력] 숫자 : 5
				  숫자 : 7
				  ..
				  숫자 : 10
			출력] 짝수의 합 : 52
				  홀수의 합 : 46
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int oddSum = 0;
		int evenSum = 0;

		for (int i=0; i<10; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 1) {
				oddSum += num;
			} else {
				evenSum += num;
			}
		}

		System.out.printf("짝수의 합 : %,d\n", evenSum);
		System.out.printf("홀수의 합 : %,d\n", oddSum);

	}

	public static void m4() {
		/*
			문제4.
			요구사항] 아래와 같이 출력하시오.
			출력] 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
			출력] 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		*/




		int sum = 0;

		for (int i=1; i<=10; i++) {
			sum += i;
			System.out.printf("%d + ", i);
		}

		System.out.printf("\b\b= %,d\n", sum);












		sum = 0;

		for (int i=1; i<=10; i++) {

			if (i % 2 == 0) {
				sum -= i;			
				System.out.printf("%d + ", i);
			} else {
				sum += i;			
				System.out.printf("%d - ", i);
			}
		}

		System.out.printf("\b\b= %,d\n", sum);
	}







	public static void m5() {
		/*
			문제5.
			요구사항] 아래와 같이 출력하시오.
			출력] 1 + 2 + 3 + 4 + 5 + ... + ? = 10XX
			조건] 누적값이 1000을 넘어가는 순간까지만 출력하시오.
			사용] 무한 루프 + break
		*/

		int sum = 0;
		
		for (int i=1; ; i++) {
			sum += i;
			System.out.printf("%d + ", i);

			if (sum >= 1000) {
				break;
			}
		}

		System.out.printf("\b\b= %,d\n", sum);

	}






	public static void m6() throws Exception {
		/*
			문제6.
			요구사항] 서기 1년 1월 1일부터 2017년 12월 6일까지 총 며칠이 지났는지 구하시오.
			출력] 총 4,563,543일 지났습니다.
			조건] Calendar 사용 금지
			사용] for문 사용, 윤년 계산
			검증] 결과 % 7 = 3
		*/
		
		int year = 2017;
		int month = 12;
		int date = 6;
		int totalDay = 0;
		

		//1.1.1 ~ 2016.12.31
		for (int i=1; i<year; i++) {
			if (isLeafYear(i)) {
				totalDay += 366;
			} else {
				totalDay += 365;
			}
		}

		//2017.1.1 ~ 2017.11.30
		for (int i=1; i<month; i++) {
			totalDay += getMaxDay(year, i);
		}

		//2017.12.1 ~ 2017.12.6
		totalDay += date;

	
		System.out.printf("총 %,d일 지났습니다.\n", totalDay);
		System.out.println(totalDay % 7);







		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.set(1, 0, 1, 0, 0, 0);

		long span = c2.getTime().getTime() - c1.getTime().getTime();
		System.out.println(span / 1000 / 60 / 60 / 24);

	}

	public static boolean isLeafYear(int year) {
		if (year % 4 == 0) {			
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}			
			} else {
				return true;
			}		
		} else {
			return false;		
		}
	}

	public static int getMaxDay(int year, int month) {
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (isLeafYear(year)) {
					return 29;
				} else {
					return 28;
				}
			default:
				return 0;
		}
	}

	public static void m7() {
		/*
			문제7.
			요구사항] 369 게임을 출력하시오.
			출력] 1	2	짝	4	5	짝	...
			조건] 100까지
				  33 - 짝짝
		*/

		for (int i=1; i<=100; i++) {
			
			int d1 = i / 100;
			int d2 = i / 10 % 10;
			int d3 = i % 10;

			boolean flag = false;

			if (d1 != 0 && d1 % 3 == 0) {
				System.out.print("짝");
				flag = true;
			}

			if (d2 != 0 && d2 % 3 == 0) {
				System.out.print("짝");
				flag = true;
			}

			if (d3 != 0 && d3 % 3 == 0) {
				System.out.print("짝");
				flag = true;
			}
			
			/*
			if (flag) {
				System.out.print("\t");
			} else {
				System.out.print(i + "\t");
			}
			*/

			if (!flag) {
				System.out.print(i);
			} 
			
			System.out.print("\t");
		}

	}

}


















