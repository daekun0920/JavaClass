import java.util.Calendar;
import java.util.Date;


class Ex21_DateTime {

	public static void main(String[] args) {
		
		// Ex21_DateTime.java

		// 날짜시간형
		//   - 참조형
		//   - Date 클래스
		//   - Calendar 클래스(***)
		
		// 8가지 기본형 + String + 날짜시간형

		// 시각 = 2017-12-04 12:30:30  // 위치를 표현하는 단위
		// 시간 = 1시간, 2시간         // 양을 표현하는 단위

		// 시각 + 시각 =       불가능  // 각 단위 진법이 다름
		// 시각 - 시각 = 시간  가능    // 2017-12-04 - 1995-09-20
		// 시간 + 시간 = 시간  가능 
		// 시각 + 시간 = 시각  가능    // 2017-12-04 12:30:30 + 2:30 = 2017-12-04 15:00:30
		// 시각 - 시간 = 시각  가능 
		// 1970.1.1 (기준일) 2018.6.20 21:30:40 (A) ----- 2017.11.5 9:40:15(B)
		// 기준일에서 각 지점까지 초 단위로 계산해서 구한 (기준점에서 A까지의 거리) - (기준점에서 B까지의 거리) 로 A와 B 간의 거리를 구한다
		
	// m1();
	// m2();
	// m3();
	// m4();
	// m5();
	// m6();
	m7();


	} // main

	public static void m7() {
	
		// 1. 현재 시각 얻기 : Calendar.getInstance();
		// 2. 특정 시각 얻기 : Calendar.getInstance(); -> set() 사용
		// 3. 특정 시간 얻기 : int 조작 
		// 4. 시각 - 시각 : tick값 사용 
		// 5. 시간 + 시간 : int 조작
		// 6. 시간 - 시간 : int 조작
		// 7. 시각 + 시간 : add() 사용
		// 8. 시각 - 시간 : add() 사용
		

	    // 2시간 30분 필요 (X) 2017년 ~월 ~일 2시 30분 (O)
		//Calendar c = Calendar.getInstance();
		//c.set(Calendar.HOUR, 2);
		//c.set(Calendar.MINUTE, 30);	
		
		// 특정 시간 얻기 
		int hour = 2;
		int min = 30;




	
	
	
	}





	public static void m6() {

		// 시각 - 시각 = 시간 (각 시각간의 차)
		//  : 특정 시점을 기준으로 해서 지난 시간을 누적 -> 단위를 통일 시킨 뒤 연산 

		// 태어난지 몇 시간?
		//  : 현재 - 생일 

		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1995, 2, 25, 13, 30, 0);

		// System.out.println(now - birthday);
		
		// tick 구하기 // 1970년 1월 1일부터 몇 밀리초가 흘렀는지의 값
		// 1. 현재 시각의 tick 
		System.out.println(System.currentTimeMillis()); // 현재 값만 가능

		// 2.
		Date nowDate = now.getTime(); // getTime? 
		long nowTick = nowDate.getTime();
		System.out.println(nowTick);
	
		Date birthdayDate = birthday.getTime(); // 시각을 일로 바꿔줌
		long birthdayTick = birthdayDate.getTime();
		System.out.println(birthdayTick);

		long span = nowTick - birthdayTick;

		System.out.println(span / 1000 / 60 / 60 / 24 ); // 두 포인트의 간격
					      // 밀리초 > 초 > 분 > 시간 > 일




		// 올해 크리스마스 며칠 남음?
		//  : 크리스마스 - 오늘
		Calendar christmas = Calendar.getInstance();
		christmas.set(2017, 11, 25, 0, 0, 0);
		

	 // 메소드 체이닝
		long christmasTick = christmas.getTime().getTime();
		
		span = christmasTick - nowTick; // ms 

		System.out.println(span / 1000.0 / 60 / 60 / 24 );

		
	
	
	}
	






	public static void m5() {
	
		// 연산 
		// void add(int, int)
		// 원본을 수정한다.

		// 100일째?
		// = 오늘(시각) + 100일(시간)

		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 100);   // today에 Calendar.DATE의 값에 100일 추가 
	 // today.add(Calendar.YEAR, 100);   // 100년 추가

		System.out.printf("100일째 : %tF\n", today);
		
		today = Calendar.getInstance();  // 초기화
		
		today.add(Calendar.HOUR, 5);     // 5시간 추가
		today.add(Calendar.MINUTE, 35);  //  35분 추가

		System.out.printf("%tF %tT\n", today, today);


		// 100일 기념 커플 -> 만난날?

		today = Calendar.getInstance();

		today.add(Calendar.DATE, -100);

		System.out.printf("100일전 : %tF\n", today);
	
	
	
	
	
	
	}

















	public static void m4() {
	

		// printf() 메소드
		//  - 날짜/시간 지원
		Calendar c = Calendar.getInstance();

		System.out.printf("%tF\n", c);  // %tF 형식문자 사용               // 2017-12-04
		System.out.printf("%tT\n", c);  // %tT 형식문자 사용               // 14:48:40
		System.out.printf("%tR\n", c);  // %tR                             // 14:49
		System.out.printf("%tr\n", c);  // %tr                             // 02:50:12 오후
		System.out.printf("%tA\n", c);	// %tA							   // 월요일

		
		// System.out.printf("%d-%d-%d\n", birth.get(Calendar.YEAR)        // 2017-12-04
		//							     , birth.get(Calendar.MONTH) + 1
		//							     , birth.get(Calendar.DATE));




	
	
	
	} // m4








	public static void m3() {
	
		// m1(), m2() -> 현재 시각
		// m3() -> 특정 시각

		// 내 생일 : 1995년 3월 25일 15시 30분 0초
		Calendar birth = Calendar.getInstance();

		// 내 생일로 고치기(값 수정)
		// void set(int, int)
		// void set(int, int, int)				  // set 메소드가 오버로딩을 지원한다
		// void set(int, int, int, int, int, int) // 년 월 일 시 분 초 

		// birth.set(Calendar.YEAR, 1995);
		// birth.set(Calendar.MONTH, 2);
		// birth.set(Calendar.DATE, 25);
		
		
		// birth.set(1995, 2, 25); // 셋 다 바꿔야할때 // 시 분 초만 바꾸려면 오버로딩말고 일부분 수정 해야됨 
		
		// 2017-12-1
		// birth.set(2017, 11, 1);
		// birth.set(Calendar.DATE, 1); // 일부만
		
		birth.set(1995, 2, 25, 13, 30, 0); // 오버로딩 한꺼번에 

		System.out.printf("%d-%d-%d\n", birth.get(Calendar.YEAR)
									  , birth.get(Calendar.MONTH) + 1
									  , birth.get(Calendar.DATE));
	
	

	
	
	
	} // m3








	public static void m2() {
		
		Calendar c = Calendar.getInstance();
		
		// int get(int)
		// System.out.println((c.get(1)));  //c의 1번에 해당하는값을 가져온다 2017
		// System.out.println((c.get(2)));
		// System.out.println((c.get(3)));
		// System.out.println((c.get(4)));
		// System.out.println((c.get(5))); 
		// 위 경우엔 각 숫자가 의미하는바를 기억하기 어려워서 변수에 넣어주는것이 더 쉬움

		int year = 1;
		int month = 2;

		
		System.out.println(c.get(year));
		System.out.println(c.get(month));
		
		// 캘린더 상수
		System.out.println(Calendar.YEAR);  // 변수임 // 1 
		System.out.println(Calendar.MONTH); // 2
	
	
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		
		
		
		System.out.println(c.get(Calendar.YEAR));			// 년
		System.out.println(c.get(Calendar.MONTH));			// 월(0 ~ 11)
		System.out.println(c.get(Calendar.DATE));			// 일 
		System.out.println(c.get(Calendar.HOUR));			// 시(12시간 체계)
		System.out.println(c.get(Calendar.HOUR_OF_DAY));    // 시(24시간 체계)
		System.out.println(c.get(Calendar.MINUTE));			// 분
		System.out.println(c.get(Calendar.SECOND));			// 초
		System.out.println(c.get(Calendar.MILLISECOND));	// 밀리초(1000분의 1초)
		System.out.println(c.get(Calendar.DAY_OF_WEEK));    // 요일(일요일 1 ~ 7)
		System.out.println(c.get(Calendar.AM_PM));			// 오전(0) 오후(1)
		

		// 오늘 날짜는 2017년 12월 4일입니다. - 출력 
		System.out.printf("오늘 날짜는 %d년 %d월 %d일입니다.\n",
						  c.get(Calendar.YEAR),
						  c.get(Calendar.MONTH) + 1,
						  c.get(Calendar.DATE));


	
	
	} // m2
	
	
	
	
	
	
	public static void m1()  {
		
		//현재 시스템의 시각을 얻어오기
		int a;
		a = 10;

		String b; 
		b = "문자열";

		Calendar c; // 변수 선언 한것임.
		c = Calendar.getInstance();

		System.out.println(c);
	
	
	
	} // m1

	

} // class 
