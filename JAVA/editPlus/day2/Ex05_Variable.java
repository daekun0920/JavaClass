// class Ex05_Variable { = K&R 스타일(브라이언 커니핸 & 데니스 리치)

class Ex05_Variable
{ // Allman 스타일

	public static void main(String[] args) {
		//Ex05_Variable.java

		byte a;
		// 타입에 상관없이 모든 변수는 중복될수 없다.
		//byte a;
		//int a;
		//a = 10;

		//국어, 영어, 수학
		int kor, eng, math; // 국어, 영어, 수학

		// 1대1 대응 주석 달기가 더 보기 좋음
		int weight, // 몸무게
			height; // 키
		
		// 각자료형 변수 생성 + 데이터

		// 정수형
		// 1. byte

		//정수형 상수, 정수형 리터럴
		byte b1 = 10; //b1(변수), 10(데이터, 상수, Literal)
		// b1 = 128; < 오버플로우(overflow), Error
		// b1 = -129; < 언더플로우(underflow), Error

		//2. short
		short s1;
		s1 = 10;
		// s1 = 32768; // incompatible types: possible lossy conversation from int to short

		//3. int
		int n1 = 10;
		// n1 = 2200000000; // integer number too large: 2200000000
		//4. long
		long l1 = 10;
		l1 = 10000000000000000L; // interger number too large: 10000000000000000
		// Long 형 상수를 위해서는 상수(리터럴) 마지막에 L,l을 붙여주어야한다.

		// 모든 상수는 integer 타입 이다.

		// 대입 연산자
		// - 변수 = 값;
		// - LValue(변수) = RValue(변수, 상수);
		// - 반드시 LValue와 RValue의 자료형이 일치
		// 컴파일러에서 자동적으로 의역을 해준다 byte ~ short = 상수(int)

		int a1 = 10;
		int b;
		b = a1;

		// 실수형 
		float f1 = 3.14F;
		f1 = 1234567890123456789.12345678901234567890F;
		System.out.println(f1);

		// double = 좀 더 정교함, 기본 자료형
		double d1 = 2.58;
		d1 = 1234567890123456789.12345678901234567890;
		System.out.println(d1);

		// 논리형
		boolean flag = true;
		flag = false;
		System.out.println(flag);

		// 문자형
		char c1 = 'A';
		System.out.println(c1);

		c1 = '가';
		System.out.println(c1);

		//c1 = 'ABC'; > 글자 한개만 넣을수 있음(오류)
		//System.out.println(c1);

		c1 = '1'; // 숫자 1 이 아닌 문자로서의 '1' 임
		System.out.println(c1);

		// 기본형 x
		// 참조형 o

		// char : 문자 1 개
		// String : 문자 여러개

		// 홍길동
		
		String name = "홍길동"; // 문자 1 개 : ' ' , 문자 여러개 : " " 


		int num = 10;
		int Num = 20;
		int nuM = 30;
		int nUm = 40;

		// 자바에서..
		// 변수명 관례
		// 1. 단어를 소문자로 기재
		int NUM = 10; // 모두 대문자로 기재할경우 상수임
		int num1 = 10;

		// 학생 번호
		// Student Number
		int studentnumber; // 가독성 떨어짐, 첫 문자는 무조건 소문자로 시작해야함
		int studentNumber; // 캐멀 표기법
		int student_number; // 스네이크 표기법

		
		// 기수법(記數法)
		// 10진법, 2진법, 8진법, 16진법..

		int n2 = 10;   // 10 진수
		System.out.println(n2);

		int n3 = 010;  // 8 진수
		System.out.println(n3);

		int n4 = 0x10; // 16 진수
		System.out.println(n4);
		

		
	}

}
