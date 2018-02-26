class Homework1 {

	public static void main(String[] args) {
		

		/*
		
		기본 자료형(8가지) + String 을 사용해서 주변의 데이터를 변수화 + 데이터 입력 + 문장 출력하시오.
		
		자료형 1개 x 10개

		*/

		// 내 몸무게
		// 1. 내 몸무게가 어떤 자료형에 속하는지?
		// 2. 변수명 <- 의미있게
		// 3. 상수 표기(대입)
		// 4. 출력

		float myWeight; 
		myWeight = 70.5F;
		System.out.println("내 몸무게는 " + myWeight + " kg입니다.");
		
		// byte, short, int, long
		// char, string
		// float, double
		// boolean
		
		// byte
		byte numberEgg = 7;
		System.out.println("총 달걀의 개수는 " + numberEgg + "개 입니다.");
		
		byte buildingHeight = 110;
		System.out.println("이 빌딩의 높이는 " + buildingHeight + "m 입니다.");

		byte studentNumber = 30;
		System.out.println("이 학급의 총 학생수는 " + studentNumber + "명 입니다.");

		byte speedLimit = 120;
		System.out.println("이 도로의 제한속도는 " + speedLimit + "km 입니다.");

		byte averageAge = 21;
		System.out.println("평균 나이는 " + averageAge + "세 입니다.");

		byte temperature = -35;
		System.out.println("시베리아의 기온은 " + temperature + "도 입니다.");

		byte address = 71;
		System.out.println("집의 번지수는 " + address + "번지 입니다.");

		byte programCount = 17;
		System.out.println("이 프로그램을 총 " + programCount + "회 실행 하였습니다."

		byte finishCourse = 47;
		System.out.println(finishCourse + "일 후에 종강합니다.");

		byte totalRemainingTime = 127;
		System.out.println("총 남은 시간: " + totalRemainingTime + "시간");


		// short
		short myHeight = 178;
		System.out.println("내 키는 " + myHeight + "cm 입니다.");

		short myFeetSize = 260;
		System.out.println("내 발사이즈는 " + myFeetSize + " 입니다.");

		short myBirthYear = 1995;
		System.out.println("제가 태어난 해는 " + myBirthYear + "년 입니다.");

		short koreanWar = 1950;
		System.out.println("한국전쟁이 일어난 해는 " + koreanWar + "년 입니다.");

		short dailyIncome = 30000;
		System.out.println("제 하루 일당은 " + dailyIncome + "원 입니다.");

		short minimumWage = 6470;
		System.out.println("최저시급은 " + minimumWage + "원 입니다.");

		short audience = 30000;
		System.out.println("총 관객의 수는 " + audience + "명 입니다.");

		short gdpKorea = 28000;
		System.out.println("대한민국의 1인당 생산량은 " + gdpKorea + "달러 입니다.");

		short olympicKorea = 2018;
		System.out.println("평창 올림픽은 " + olympicKorea + "년에 열립니다.");

		short admissionEverland = 20000;
		System.out.println("에버랜드의 입장료는 " + admissionEverland + "원 입니다.");
		

		// int
		int annualIncome = 100000000;
		System.out.println("나의 연봉은 " + annualIncome + "원 입니다.");
		
		int populationSuwon = 1500000;
		System.out.println("수원의 인구는 " + population + "명 입니다.");

		int monthlyIncome = 2000000;
		System.out.println("나의 월급은 " + monthlyIncome + "원 입니다.");

		int gdpUSA = 50000;
		System.out.println("미국의 1인당 생산량은 " + gdpUSA + "달러 입니다.");

		int populationChina = 1300000000;
		System.out.println("중국의 인구는 " + populationChina + "명 입니다.");

		int populationIndia = 1100000000;
		System.out.println("인도의 인구는 " + populationIndia + "명 입니다.");

		int accountBalance = -10000000;
		System.out.println("그의 통장 잔액은 " + accountBalance + "입니다.");

		int carPrice = 30000000;
		System.out.println("차 가격: " + carPrice + "원");

		int housePrice = 2000000000;
		System.out.println("아파트 매매가: " + housePrice + "원");

		int tution = 500000;
		System.out.println("이 과정의 강의료는 " + tution + "원 입니다.");

		// long
		long worldPopulation = 6000000000;
		System.out.println("세계 인구수는 " + worldPopulation + "명 입니다.");

		long company = 50000000000;
		System.out.println("이 회사의 시가 총액은 " + company + "원 입니다.");

		long asiaPopulation = 3000000000;
		System.out.pritnln("아시아의 총 인구수는 " + asiaPopulation + "명 입니다.");

		long probiotics = 10000000000;
		System.out.println("이 음식은 유산균 " + probiotics + "마리를 포함하고 있습니다.");

		long stockProfit = 30000000000;
		System.out.println("형이 주식으로 " + stockProfit + "원을 벌었다.");

		long gambleLoss = -70000000
		System.out.println("카지노에서 총 " + gambleLoss + "원의 손실을 보았다.");

		long investment = 1000000000000;
		System.out.println("그는 이 회사에 " + investment + "원을 투자 하였다.");

		long money = 10000000000;
		System.out.println("나는 " + money + "원이 가지고 싶다.");

		long annualProfit = 32424243234;
		System.out.prntln("이 기업의 연간 매출액은 " + annualProfit + "원 이다.");

		long landPrice = 1234567890;
		System.out.println("이 부지의 공시지가는 " + landPrice + "원 이다.");
		// char
		char score1 = '수', score2 = '우', score3 = '미', score4 = '양', score5 = '가';
		System.out.print("학생1 성적: " + score1 + "\n" + "학생2 성적: " + score2 + "\n" + "학생3 성적: "
						+ score3 + "\n" + "학생4 성적: " + score4 + "\n" + "학생5 성적: " + score5 + "\n");

		char rank1 = 'A', rank2 = 'B', rank3 = 'C', rank4 = "D";
		System.out.println("제품1 품질 등급: " + rank1 + "\n" + "제품2 품질 등급: " + rank2 + "\n" + "제품3 품질 등급: " + rank3 + "\n" 
							+ "제품4 품질 등급: " + rank4 + "\n");

		char surname = '한';
		System.out.println("제 이름은 " + surname + "대건 입니다.");
						
						
		// String


		// float


		// double


		// boolean

	}

}
