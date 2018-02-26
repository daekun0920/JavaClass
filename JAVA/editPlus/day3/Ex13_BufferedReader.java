// 1.
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex13_BufferedReader {

	public static void main(String[] args) throws Exception{ // 2.
		
		// Ex13_BufferedReader.java
		
		char c1 = ' ';  // 스페이스도 문자 코드값을 가지고 있음
		System.out.println(c1);

		String s1 = ""; // 빈 문자열(Empty String), string은 내용이 비어있어도 문제없음
		System.out.println(s1);





		// int num;
		// System.out.println(num); // 아무것도 없음, 연산도 안됨 

		// 3.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 이 3단계는 바로 반사적으로 바로나올정도로 익숙해져야함(외워야 함)
																					  // 코드는 머리를 써서 쓰는것도 있지만 대부분 자주쓰이는 코드 패턴을 외워서 반복적인 코드를 작성하는것이 업무임
		

		// 요구사항) 태어난 년도를 입력받아 나이를 출력하시오.
		//          2017 - 태어난 년도 = 나이
		
		System.out.print("태어난 년도 : ");

		String input = reader.readLine(); // "1990" > 문자열
		
		int age = 2017 - Integer.parseInt(input);

		System.out.printf("%s년도에 태어난 사람은 %d세입니다.\n"
							, input, age);

		// 요구사항) 숫자를 2개 입력받아 아래와 같은 연산식을 출력
		//			2.5 + 3.4 = 5.9
		// 조건) 소수이하 1자리까지만 출력

		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		double num1 = Double.parseDouble(input1);

		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		double num2 = Double.parseDouble(input2);

		System.out.printf("%.1f + %.1f = %.1f\n"
							, num1, num2, num1 + num2);
		







		


	}

}
