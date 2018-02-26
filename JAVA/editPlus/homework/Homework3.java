import java.io.BufferedReader;
import java.io.InputStreamReader;

class Homework3 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 
		메소드 문제

문제1. 

요구사항) 이름을 건내주면 이름뒤에 "님"를 붙여서 반환하는 메소드 선언
입력) 이름 : 홍길동
출력) 고객 : 홍길동님
서명) String getName(String name)
		*/
		System.out.print("이름 : ");
		String name = reader.readLine();
		System.out.println(getName(name));
		
	
		
		
		
		/*

문제2.

요구사항) 숫자를 건내주면 '짝수'인지 '홀수'인지 반환하는 메소드 선언
입력) 숫자 : 5
출력) 입력하신 숫자 5는(은) '홀수'입니다.
서명) String getNumber(int num)

*/
		System.out.print("숫자 : ");
		String numInput = reader.readLine();
		int num = Integer.parseInt(numInput);
		String answer = getNumber(num);
		System.out.printf("입력하신 숫자 %d는 %s입니다.\n\n\n", num, answer);
	

		
		

/*

문제3.

요구사항) 국/영/수 점수를 건내주면 합격/불합격을 반환하는 메소드
입력) 국어 : 80
      영어 : 75
      수학 : 60

출력) (불)합격입니다.
조건) 평균 60점 이상 합격, 미만 불합격
추가조건) 과락 40점 미만 불합격
서명) String test(int kor, int eng, int math) // 서로 가장작은수 비교후 과락 점수 해당하는지 ( 낮으면 과락, 가장 낮은수가 과락보다 높으면 패스)

*/
		System.out.print("국어 : ");
		String strKor = reader.readLine();
		int kor = Integer.parseInt(strKor);
		System.out.print("영어 : ");
		String strEng = reader.readLine();
		int eng = Integer.parseInt(strEng);
		System.out.print("수학 : ");
		String strMath = reader.readLine();
		int math = Integer.parseInt(strMath);
		
		String finalAnswer = test(kor, eng, math);
		System.out.printf("%s입니다.\n\n\n", finalAnswer);


/*

문제4.

요구사항) 지하철 역의 개수, 환승 횟수 입력받아 총 소요시간을 반환하는 메소드
입력) 역의 개수 : 15
      환승 횟수 : 1

출력) 총 소요 시간은 33분 입니다.
조건) 각 역의 소요시간 : 2분 
      환승 시간 : 3분
서명) int getTime(int, int) 역 개수, 환승 횟수

추가) 역의 개수 : 15
      환승 횟수 : 1
      구분 : 평상

추가) 환승 소요시간 
      - 평상 : 3분 
      - 출근 : 4분
      - 퇴근 : 5분

서명) int getTime(int, int, String)
*/
		System.out.print("역의 개수 : ");
		String stationsNum = reader.readLine();
		int stations = Integer.parseInt(stationsNum);
		System.out.print("환승 횟수 : ");
		String transferNum = reader.readLine();
		int transfer = Integer.parseInt(transferNum);
		System.out.print("구분 : ");
		String timeStatus = reader.readLine();

		
		int totalTime = getTime(stations, transfer, timeStatus);
		System.out.printf("총 소요 시간은 %d분 입니다.\n\n\n", totalTime);



/*


문제5.

요구사항) 사과나무. 며칠 지났을 때 사과가 몇개가 열리는지?
입력) 맑은 날 : 20
      흐린 날 : 5
 
출력) 사과가 총 x 개 열렸습니다.

조건) 사과나무 처음 심었을때 : 높이 0m
      맑은 날 성장률 : 5cm 
      흐린 날 성장률 : 2cm
      사과나무가 1m 넘는 시점부터 사과가 열린다.
      1m 넘는 시점은 10cm 자랄때마다 사과가 1개씩 열린다. // 110cm 부터

서명) int getApple(int, int)
	

	*/
		

	System.out.print("맑은 날 : ");
	String goodWeather = reader.readLine();
	int niceDay = Integer.parseInt(goodWeather);

	System.out.print("흐린 날 : ");
	String badWeather = reader.readLine();
	int badDay = Integer.parseInt(badWeather);

	int appleNum = getApple(niceDay, badDay);
	
	System.out.printf("사과가 총 %d개 열렸습니다.\n\n\n", appleNum);
	







	} // main

	public static int getApple(int niceDay, int badDay) throws Exception {
		int heightTree = 0;
		heightTree = (heightTree + ((niceDay * 5) + (badDay * 2)));
		heightTree = heightTree - 100;
		int appleNum = heightTree / 10;
		return appleNum;

   // ctrl + d = 날짜

	} // getApple

	public static String getName(String name) throws Exception {
	

	return ("고객 : " + name + "님\n\n\n");


	} // getName
	
	public static String getNumber(int num) throws Exception {
	
	String answer = num % 2 == 1 ? "홀수" : "짝수";

	return answer;

	} // getNumber
	
	public static String test (int kor, int math, int eng) throws Exception {
	
	 String answer = (kor + math + eng) / 3 < 60  ? "불합격" : "합격";
	 int smallerNum = kor < math ? kor : math;
	 int smallestNum = smallerNum < eng ? smallerNum : eng;
	 String answer1 = smallestNum < 40 ?  "불합격" : "합격";
	 String finalAnswer = answer == "합격" && answer1 == "합격" ? "합격" : "불합격";

	 return finalAnswer;



	
	} // test

 
	public static int getTime (int stations, int transfer1, String timeStatus) throws Exception {
	int zero = 0; // 환승 부분 계속 0으로 나옴

	//***모든 참조형(문자열)의 비교는 비교 연산자(==, !=)를 사용하면 안된다 (결과 예측 불가). -> equals() 메소드 사용
	int time1 = timeStatus.equals("평상") ? transfer1 * 3 : zero;
	int time2 = timeStatus.equals("출근") ? transfer1 * 4 : zero;
	int time3 = timeStatus.equals("퇴근") ? transfer1 * 5 : zero;
	System.out.println(transfer1);
	System.out.println(timeStatus);
	int biggerNum = time1 > time2 ? time1 : time2;
	int biggestNum = biggerNum > time3 ? biggerNum : time3;
	System.out.println(time1);
	System.out.println(time2);
	System.out.println(time3);

	return (stations * 3) + biggestNum;

	
	
	
	
	} // getTime

	



} // class