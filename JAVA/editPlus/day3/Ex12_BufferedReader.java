// Ex12_BufferedReader

// import java.io.BufferedReader;  // 클래스를 import
// import java.io.InputStreamReader;
import java.io.*; // io 안에 들어있는 모든 클래스를 가져온다  // 패키지를 import 

	 // java 폴더 안에 io 폴더에 BufferedReader

// 클래스를 담는 단위 > 패키지(폴더)

// java.lang // 기본 패키지라서 import 없어도 사용가능 (string, system 담고있음)

class Ex12_BufferedReader {

	public static void main(String[] args) throws Exception {
	
		
		// Ex12_BufferedReader.java

		// System.in.read(); // 바이트 단위 입력
		// BufferedReader    // 문자 단위 입력 (유니코드 지원)

		// System.out.print("문자 입력: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		

		// int n = reader.read(); // 입력점
		// System.out.println((char)n);

	    // String str = reader.readLine();
		// System.out.println(str);

		// str = reader.readLine(); // readLine은 개행 라인(엔터값 = \r\n)을 만나기 직전 까지만 읽고 버퍼에 있는 엔터값을 readLine에서 버린다(걸러준다)
		// System.out.println(str);

		
		// 입력받을 수 있는 데이터의 형태?

		// 1. 문자
		// System.in.read()
		
		// reader.read() // 입력점 - 문자 코드 반환
		// reader.readLine()       - 문자열 반환
		
		// 요구사항) 숫자 1개 입력 + 100 을 하시오.
		// String num = reader.readLine(); 
		// System.out.println(num + 100);
		
		// int code = reader.read();
		// System.out.println(code - 48 + 100); // 실제숫자와 48의 간격이 있어서 빼주면 실제 숫자가 된다

		// 요구사항) 숫자 2자리 입력 + 100 을 하시오.
		
		

		/*****

		int num;

		int code = reader.read(); // 정수를 입력해도 문자로 들어감
		System.out.println(code - 48);
		
		num = (code - 48) * 10;

		code = reader.read();
		System.out.println(code - 48);

		num = num + (code - 48);

		System.out.println(num + 100);

		*/
		

		/*****

		String str = reader.readLine();  // 기본적으로 참조형은 정수형으로 못바꿈
		System.out.println(str + 100);   // "25" -> 25
		System.out.println(Integer.parseInt(str) + 100); // 이렇게 하면 가능
		
		*/

		// 문자열 -> int

		// 자료형 -> Wrapper Class(Util Class)
		// byte -> Byte
		// short -> Short
		// int -> Integer
		// long -> Long
		// float -> Float
		// double -> Double
		// boolean -> Boolean

		// System.out.println(Integer.parseInt("100")); // 기억하기 // 100 
		// System.out.println(Byte.parseInt("100"));
		// System.out.println(Double.parseInt("3.14"));
		// System.out.println(Boolean.parseInt("true"));


		// int의 최대값
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		

		// reader.readLine() 사용 시
		// - 숫자 입력 -> "문자열" -> Util Class ParseXXX() 사용 -> 숫자
		// - 문자열 입력 -> 문자열
		// - 문자 입력 -> "문자열" -> '문자'

		String str = reader.readLine();
		System.out.println(str); // "a" -> 'a' // (char)str 이렇게는 안됨  
		System.out.println((int)str.charAt(0));



	}

}
