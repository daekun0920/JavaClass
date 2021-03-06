class Ex08_Casting {

	public static void main(String[] args) {
		
		// Ex08_Casting // 손 코딩 연습

		// 형변환
		// 1. 암시적인 형변환
		// 2. 명시적인 형변환

		// 정수 -> 정수

		byte b1 = 10; // 원본   1 byte
		long l1;	  // 복사본 8 byte
		
		// 암시적인 형변환(원본 손실 x)
		// l1 = b1;
		l1 = (long)b1; //컴파일러가 자동적으로 하지만 보편적으로 (long) 쓰는것을 권장
		
		System.out.println(l1); // 10 // 복사본 확인 

		// 실수형
		float f1 = 3.14F;  // 원본
		double d1;		  // 복사본
		
		// 암시적인 형변환
		d1 = f1;
		
		// 키 매크로 alt + 1
		
		System.out.println(d1);

		double d2 = 1.23456789012345; // 원본
		float f2;					  // 복사본
		
		System.out.println(d2);      // 1.23456789012345

		f2 = (float)d2;

		System.out.println(f2);      // 1.2345679 (반올림 됨)

		// 실수 <-> 정수
		
		double d3 = 3.994;	// 원본
 		int n3;				// 복사본
		
		// 명시적인 형변환 (8 byte -> 4 byte)
		n3 = (int)d3;

		System.out.println(n3);   // 3  // 소수값 무조건 버림(floor, trunc)

		float f4 = 3.14F;
		long l4;
		
		// 큰형(8) = 작은형(4) //f4가 더 큰형임 ( 표현을 할수있는 수의 범위가 훨씬 넓음) // 명시적인 형변환
		// 수의 범위(O), 바이트 크기 비교(X)
		l4 = (long)f4;

		System.out.println(l4); // 3.140000104904175

		// 기본형의 범위 비교 
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//           char(2)
		// boolean(1)
		// ** 기본형과 참조형끼리는 변환이 불가능(메모리 구조 때문에)
		
		// boolean은 형변환의 대상이 될 수 없다.

		// 문자형 형변환
		//  - 'A' -> 65(문자 코드값)  // 문자형은 정수형으로만 바꿀수 있다.
		
		char c5 = '가'; // 2 byte
		short s5;      // 2 byte
		// 숫자 = 문자
		s5 = (short)c5; // -21504  // 명시적 
		// char는 부호기호를 사용하지 않아서 2 byte 모두 사용하게 되서 최대 수는 60000(양수) 이지만
		// short 는 부호기호를 사용하므로 최대 양수가 대략 30000이라서 쓰레기값이 나온다.

		System.out.println(s5); // 65
		

		System.out.println((char)66); // B

		char c6 = '가'; // 2 byte
		int n6; // 4 byte
		
		n6 = c6;
		System.out.println(n6);  // 44032

		int n7 = 5;
		char c7 = '5';

		System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');   // 65
		System.out.println((int)'Z');	// 90	
		System.out.println((int)'a');	// 97
		System.out.println((int)'z');	// 122 
		System.out.println((int)'0');	// 48
		System.out.println((int)'9');	// 57
		
		System.out.println((int)'가');	// 44032
		System.out.println((int)'힣');	// 55203
		
		// 'A' 'a' '0'

		
















	}

}
