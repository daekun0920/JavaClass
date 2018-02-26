import java.io.BufferedReader;
import java.io.InputStreamReader;


class Homework2  {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



	
		/*
문제.txt

문제1. 

요구사항) 나이를 입력받아  태어난 년도를 출력하시오.
입력) 나이 : 27
출력) 태어난 년도: 1990년
조건) 현재 년도 : 2017년

*/

		System.out.print("나이 : ");
		String input = reader.readLine();
		int birth_year = 2017 - Integer.parseInt(input);
		System.out.printf("태어난 년도 : %d\n\n\n", birth_year);













/*
문제2.

요구사항) 숫자 2개를 입력받아서 연산과정과 결과를 출력하시오
입력) 첫번째 숫자 : 5
      두번째 숫자 : 3
출력) 5 + 3 = 8
      5 - 3 = 2
      5 * 3 = 15
      5 / 3 = 1
      5 % 3 = 2

조건) 입력값은 정수
      숫자 천단위 표기
	  */

	  System.out.print("첫번째 숫자 : ");
	  String first_num_input = reader.readLine();
	  int first_num = Integer.parseInt(first_num_input);


	  System.out.print("두번째 숫자 : ");
	  String second_num_input = reader.readLine();
	  int second_num = Integer.parseInt(second_num_input);

	  System.out.printf("%d + %d = %d\n\n\n", first_num, second_num, first_num + second_num);




/*

문제3.

요구사항) 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
입력) 너비(cm) : 20cm
      높이(cm) : 10cm

출력) 넓이 : 200cm^2
      둘레 : 60cm

*/

System.out.print("너비(cm) : ");
String length_input = reader.readLine();
int length = Integer.parseInt(length_input);

System.out.print("높이(cm) : ");
String height_input = reader.readLine();
int height = Integer.parseInt(height_input);

System.out.printf("넓이 : %dcm^2\n둘레 : %dcm\n\n\n"
				  ,length * height, (height + length) * 2);

/*

문제4.

요구사항) 자전거 바퀴휠(지름 26인치). 페달수 입력받아 총 m를 갔는지 출력 하시오.
조건) 페달 1바퀴 -> 바퀴 1회전
      소수 이하 출력X
입력) 페달 수 : 1000
출력) 총 3,000m를 이동했습니다.

 인치 * 2.54 = cm
*/

System.out.print("페달 수 : ");
String pedalCount = reader.readLine();
int pedal = Integer.parseInt(pedalCount);

System.out.printf("총 %dm를 이동했습니다.\n\n\n", pedal * (int)((26 * 2.54) * 3.14) / 100);





/*
문제5.

요구사항) 영소문자를 1개 입력받아 대문자로 변환시켜 출력하시오.
입력) 문자: a
출력) 'a'의 대문자는 'A'입니다.
조건) 문자 코드값 + 형 변환 + (대문자와 소문자간의 차이?)

*/


System.out.print("문자 : ");
int small_letter_input = reader.read();
char capital_letter = (char)(small_letter_input - 32);
System.out.printf("'%s'의 대문자는 '%s'입니다.\n\n\n", (char)small_letter_input, capital_letter);




/*

문제6.

요구사항) 한달 수익을 입력받아 세후 금액을 출력하시오.
입력) 금액(원) : 1000000
출력) 세후(원) : 967,000원
조건) 세금 : 3.3%
      출력 소수점 이하x 

*/

/* 실행 오류 발생

System.out.print("금액(원) : ");
String salaryInput = reader.readLine();
int salary = Integer.parseInt(salaryInput);

System.out.printf("세후(원) : %d원\n\n\n", (int)salary + salary * 0.033);

*/



/*

문제7.

요구사항) 숫자를 2개 입력받아 그 중 큰 숫자를 출력하시오.
입력) 첫번째 숫자 : 5
      두번째 숫자 : 3
출력) 큰 수 : 5

입력) 첫번째 숫자 : 5
      두번째 숫자 : 3
      세번째 숫자 : 8
출력) 가장 큰 수  : 8
*/


/* 실행 오류 발생

System.out.println("첫번째 숫자 : ");
String first_input = reader.readLine();
int first_numb = Integer.parseInt(first_input);

System.out.print("두번째 숫자 : ");
String second_input = reader.readLine();
int second_numb = Integer.parseInt(second_input);

int bigger_num = (first_numb > second_numb) ? first_numb : second_numb;

System.out.print("세번째 숫자 : ");
String third_input = reader.readLine();
int third_numb = Integer.parseInt(third_input);

int biggest_num = (bigger_num > third_numb) ? bigger_num : third_numb;


System.out.printf("가장 큰 수 : %d\n", biggest_num);

*/





/*


문제8.

요구사항) 2017년 11월 1일은 수요일입니다. 2017년 11월 중 한 날짜를 입력받아 무슨 요일인지 출력하시오.
입력) 날짜 : 28
출력) 28일은 화요일입니다.


*/

/* 미완성
System.out.print("날짜 : ");
String date_input = reader.readLine();
int date = Integer.parseInt(date_input);
  
int dateRest = date % 7
*/



/*
문제9. // 문제 5번과 같이 실행시 오류발생 

요구사항) 영문자를 1개 입력받아 대문자인지 소문자인지 
입력) 문자 : a
출력) 'a'는 소문자 입니다.

입력) 문자 : H
출력) 'H'는 대문자입니다.
		*/


System.out.print("문자: ");
int letterRec = reader.read();
String result = (letterRec > 64 && letterRec < 97) ? "대문자" : "소문자";
char letter = (char)letterRec;
System.out.printf("'%s'는 %s입니다.\n\n\n", letter, result);




	}

}
