class Ex04_Variable 
{

	public static void main(String[] args) {
	
		
		//Ex04_Variable.java

		//변수, Variable
		// - 자료형을 사용해서 메모리에 얻은 공간
		// - 값(데이터)을 저장하는 공간(용도)
		
		//1. 변수 선언(생성)
		//	 -자료형 변수명;
		byte kor;

		//2. 변수 초기화
		//	 - 변수 = 값; // 대입 연산자
		kor = 100;

		//3. 변수 사용(호출, 접근 ..)
		System.out.println(kor);

		//4. 변수 치환
		kor = 95;
		// 변수 하나에는 데이터 하나만
		
		//byte(-128~127)중 양을 나타내는것이 아니라 경우의수중 하나임
		// 변수 vs 상수
		// - 변수 사용? 상수 사용?

		// 내 몸무게 출력
		//1. 상수
		System.out.println(70);
		//2. 변수 (무엇인지 유추하기위해 상수보단 변수 사용 = 데이터에 의미 부여가능)
		byte weight;
		weight = 70;
		System.out.println(weight);

		System.out.println(kor);



		//변수명 명명법
		//1. 영문자, 숫자, _(언더바) 사용
		//2. 숫자 시작 x
		//3. 예약어 사용 불가
		//4. 의미있게(*******)
		byte eng;
		byte MATH;
		byte name1;
		byte student_kor;
		// byte test+-; (특문 사용불가)
		byte 국어; // 유니코드라 인식 가능
		국어 = 80;
		System.out.println(국어);
		
		// byte 100kor;
		byte _100kor;
	 
	 //자료형, 식별자
		//byte class;
		//byte byte;

		byte a;
		byte b;
		byte c;
		
		// variable kor, eng are already defined in method main
		byte kor1;
		byte math;
		byte eng1;

		byte korScore;
		byte mathScore;

		//약어 x
		byte sn;
		
		//변수 선언
		
		int n1; //변수 선언
		n1 = 100; //변수 초기화

		int n2 = 200; //변수 선언 + 초기화

		int n3;
		int n4;

		int n5,n6,n7;

		int n9 = 10, n10 = 20, n11 = 30, n12, n13 = 30;

		int n14,n15 = 30;
		

	}

}
