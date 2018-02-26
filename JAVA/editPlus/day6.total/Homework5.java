import java.io.*;
import java.util.Calendar;

class Homework5 {

	public static void main(String[] args) throws Exception{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
			
		if문(switch문)

문제1. (Date nowDate = now.getTime()); < 뭐지 

요구사항) 숫자를 2개 입력받아 큰 수와 작은 수를 출력하시오.
입력) 첫번째 숫자 : 5
      두번째 숫자 : 3
출력) 큰 수는 5이고, 작은 수는 3입니다.

		*/
		

		//getNum();

        

		/*

문제2.

요구사항) 점수를 입력받아 성적을 출력하시오.
입력) 점수 : 85
출력) 입력한 점수 85점은 B입니다.
조건) 90 ~ 100 : A
      80 ~ 89 : B
      70 ~ 79 : C
      60 ~ 69 : D
      0 ~ 59 : F
추가) 유효성 검사(점수 0 ~ 100)
사용) if, switch(생각 - 범위 검사X)

		*/

		//getGrade();
		
		
	
		

		/*

문제3.

요구사항) 숫자 2개와 연산자 1개를 입력받아 연산과정과 결과를 출력하시오.
입력) 숫자1: 5
      숫자2: 3
      연산자: *
출력) 5 * 3 = 15
조건) 입력(정수)
      출력(나누기 소수이하 1자리까지)
      연산자(산술연산)
사용)if 

		*/


		calcNum();

		




		/*

문제4.

요구사항) 문제 1개를 입력받아 아래와 같이 출력하시오.
입력) 문자 : f
출력) Father
조건) f, F -> Father 
      m, M -> Mother
      s, S -> Sister
      b, B -> Brother
사용) if, switch

        */
		
		//family();
		
		
		
		
		
		/*********

문제5.

요구사항) 영문자 1개를 입력받아 대/소문자를 변환/출력하시오.
입력) 문자 : a
출력) 결과 : A

입력) 문자 : F
출력) 결과 : f

		*/
		
		//engWord();
		
		
		
		/*

문제6.

요구사항) 주차요금을 계산하시오.
입력) <들어온 시간>
      시 : 13
      분 : 30
      <나간 시간>
      시 : 14 
      분 : 20

출력) 주차 요금은 4,000원 입니다.
조건) 무료 주차: 30분
      초과 10분 : 2,000원

		*/

		 park();


		


		/*

문제7.

요구사항) 년도를 입력받아 "평년" 인지 "윤년"인지 출력하시오.
입력) 입력 : 2017
출력) 2017년은 '평년' 입니다.
조건) A. 년도를 4로 나눠서 떨어지면 B. 검사
						   떨어지지 않으면 "평년"

	  B. 년도를 100으로 나눠서 떨어지면 C 검사
	  						   떨어지지 않으면 "윤년"
		
	  C. 년도를 400으로 나눠서 떨어지면 "윤년"
	  떨어지않으면 "평년"

Calendar 사용 금지
		
		*/

			//leapYear();


	} // main() 



		public static void getNum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("첫번째 숫자 : ");
			int firstNum = Integer.parseInt(reader.readLine());

			System.out.print("두번째 숫자 : ");
			int secondNum = Integer.parseInt(reader.readLine());

			if (firstNum > secondNum) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.", firstNum, secondNum);
		
			} else {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.", secondNum, firstNum);
		
		
			}	 
		
		} // getNum

		public static void getGrade() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("\n\n\n입력 : ");
			int score = Integer.parseInt(reader.readLine());
			String grade = "";
		
			
			if (score >= 0 && score <= 100) { 	
				if (score >= 90) {
					grade = "A";
				} else if (score >= 80) {
					grade = "B";
				} else if (score >= 70) {
					grade = "C";
				} else if (score >= 60) {
					grade = "D";
				} else {
					grade = "F";
				}
		
			}
		System.out.printf("입력한 점수 %d은 %s입니다.\n\n\n", score, grade);
		
		
		
		} // getGrade

		public static void calcNum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("숫자1 : ");
			int num1 = Integer.parseInt(reader.readLine());

			System.out.print("숫자2 : ");
			int num2 = Integer.parseInt(reader.readLine());

			System.out.print("연산자 : ");
			String oper = reader.readLine();
		
			int answer = 0;

			if (oper.equals("+")) {
				answer = num1 + num2;
			} else if (oper.equals("-")) {
				answer = num1 - num2;
			} else if (oper.equals("*")) {
				answer = num1 * num2;     
			} else if (oper.equals("/")) {
				float answerFloat = (float)num1 / num2; // 이 부분 !!!  어떻게 float 으로 계산 ?
				System.out.printf("%d %s %d = %.1f\n\n\n",num1, oper, num2, answerFloat);
			} else {
				answer = num1 % num2;	
			}
		
			System.out.printf("%d %s %d = %d\n\n\n",num1, oper, num2, answer);
		
		
		
		} // calcNum

		public static void family() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("문자 : ");
			String letter = reader.readLine();
			String family = "";

			if (letter.equals("f") || letter.equals("F")) {
				family = "Father";
			} else if (letter.equals("m") || letter.equals("M")) {
				family = "Mother";
			} else if (letter.equals("s") || letter.equals("S")) {
				family = "Sister";
			} else if (letter.equals("b") || letter.equals("B")) {
				family = "Brother";
			}
		
			System.out.println(family);
		
		
		} // family

		public static void engWord() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("\n\n\n문자 : ");
			char word = (char)(reader.read());
			char wordAnswer;
	
			if (word >= 'a' && word <= 'z') {
				wordAnswer = (char)(word - 32);
			} else {
				wordAnswer = (char)(word + 32);
			}	
			System.out.printf("결과 : %s", wordAnswer);
			
		
		
		} // engWord 

		public static void park() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
			/*

문제6.

요구사항) 주차요금을 계산하시오.
입력) <들어온 시간>
      시 : 13
      분 : 30
      <나간 시간>
      시 : 14 
      분 : 20

출력) 주차 요금은 4,000원 입니다.
조건) 무료 주차: 30분
      초과 10분 : 2,000원

		*/
			
			System.out.println("<들어온 시간>");
			System.out.print("시 : ");
			int hour = Integer.parseInt(reader.readLine());
			System.out.print("분 : ");
			int minute = Integer.parseInt(reader.readLine());

			System.out.println("<나간 시간>");
			System.out.print("시 : ");
			int hourOut = Integer.parseInt(reader.readLine());
			System.out.print("분 : ");
			int minuteOut = Integer.parseInt(reader.readLine());

			int parkFair = (((((hourOut * 60 + minuteOut) - (hour * 60 + minute)) - 30) / 10) * 2000);
			
			System.out.printf("주차 요금은 %d원 입니다.", parkFair);

		
		}
		

		public static void leapYear() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				/******

문제7.

요구사항) 년도를 입력받아 "평년" 인지 "윤년"인지 출력하시오.
입력) 입력 : 2017
출력) 2017년은 '평년' 입니다.
조건) A. 년도를 4로 나눠서 떨어지면 B. 검사
						   떨어지지 않으면 "평년"

	  B. 년도를 100으로 나눠서 떨어지면 C 검사
	  						   떨어지지 않으면 "윤년"
		
	  C. 년도를 400으로 나눠서 떨어지면 "윤년"
	  떨어지않으면 "평년"

Calendar 사용 금지
		
		*/

			/*

			System.out.print("\n\n\n입력 : ");
			int year = Integer.parseInt(reader.readLine());
			String yearAnswer = "";

		
		
			if (year % 4 != 0) {
				yearAnswer = System.out.println("평년");

			} else if (year % 100 != 0) { 
				yearAnswer = System.out.println("윤년");

			} else if (year % 400 == 0) {
				yearAnswer = System.out.println("윤년");

			} else {
				yearAnswer = System.out.println("평년");

			}
			System.out.printf("%d년은 '%s' 입니다.", year, yearAnswer);
		
		*/
		}
} // class
