import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Homework4 {

	public static void main(String[] args)throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		/*
날짜/시간 문제
   - 제어문 사용 x
   - 삼항 연산자 o


문제1. 

요구사항) 태어난 년도를 입력받아 나이를 출력하시오.
입력) 년도 : 1995
출력) 나이 : 23세
조건) 현재 년도를 기준, 우리나라 나이
		*/

	getAge();
	



/*
문제2.

요구사항) 남자와 여자의 이름 입력 + 만난날 입력 -> 기념일 출력 
입력) 남자 : 홍길동
      여자 : 호호호
        년 : 2017
	월 :   12
	일 :    4
출력) 
=====================================
   '홍길동'와(과) '호호호'의 기념일  
=====================================
100일  : 2018년 3월 28일
200일  : 2018년 7월 10일
300일  : 2018년 11월  25일
500일  :
1000일 :
*/
	anniversary();





/*
문제3.

요구사항) 배달을 동시에 받기를 원하는 고객. 각각의 음식을 언제 주문?
조건) 짜장면 10분 후 도착 
        치킨 18분 후 도착
	피자 25분 후 도착 

입력) 원하는 도착 시각
      시 : 17
      분 : 30
출력) 짜장면 : 17시 20분
        치킨 : 17시 12분
	피자 : 17시  5분

		*/
	delivery();

	

	} // main()

	public static void delivery() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("원하는 도착 시각");
	System.out.print("시 : ");
	String hourInput = reader.readLine();
	int hour = Integer.parseInt(hourInput); 

	System.out.print("분 : ");
	String minInput = reader.readLine();
	int min = Integer.parseInt(minInput);

	// 시 : 17 분 : 30 

	Calendar rightTime = Calendar.getInstance();
	rightTime.set(Calendar.HOUR_OF_DAY, hour);
	rightTime.set(Calendar.MINUTE, min);
	
	
	rightTime.add(Calendar.MINUTE, -10);
	System.out.printf("짜장면 : %d시 %d분\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	rightTime.add(Calendar.MINUTE, -8);
	System.out.printf("  치킨 : %d시 %d분\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	rightTime.add(Calendar.MINUTE, -7);
	System.out.printf("  피자 : %d시 %d분\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	
	
	
	
	
	
	
	} // delivery();






	public static void anniversary() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	System.out.print("남자 : ");
	String nameMale = reader.readLine();

	System.out.print("여자 : ");
	String nameFemale = reader.readLine();
	
	System.out.print("년 : ");
	String yearInput = reader.readLine();
	int year = Integer.parseInt(yearInput);
	
    System.out.print("월 : ");
	String monthInput = reader.readLine();
	int month = Integer.parseInt(monthInput);

	System.out.print("일 : ");
	String dayInput = reader.readLine();
	int day = Integer.parseInt(dayInput);
	

	System.out.printf("\n=====================================\n   '%s'와(과) '%s'의 기념일  \n=====================================\n", nameMale, nameFemale);
    Calendar today = Calendar.getInstance();
	
	today.set(Calendar.YEAR, year);
	today.set(Calendar.MONTH, month + 1);
	today.set(Calendar.DATE, day);

	today.add(Calendar.DATE, 100);
    System.out.printf("100일 : %d년 %d월 %d일\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 100);
	System.out.printf("200일 : %d년 %d월 %d일\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 100);
    System.out.printf("300일 : %d년 %d월 %d일\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
    today.add(Calendar.DATE, 200);
    System.out.printf("500일 : %d년 %d월 %d일\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 500);
    System.out.printf("1000일 : %d년 %d월 %d일\n\n\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	
	
	
	
	
	
	} // anniversary();


	public static void getAge() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	Calendar now = Calendar.getInstance();
	Calendar birthday = Calendar.getInstance();
	
	
	System.out.print("년도 : ");
	String birthYearInp = reader.readLine();
	int birthYear = Integer.parseInt(birthYearInp);

	
	birthday.set(Calendar.YEAR, birthYear);

	System.out.printf("나이 : %d\n\n\n", (now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR)) + 1);
	
	
	
	
	
	} // getAge()


 } // class
