/*

자바 콘솔 프로그램 작성

1. 프로그램 소수 작성
    - Java 언어 사용
	- *.java 저장
	- 클래스명과 파일명이 반드시 동일
	- 사용된 언어가 사람이 사용하는 언어 (사람이 사용하는 언어를 기계어(바이너리 코드)로 변환해주는것이 컴파일)

2. 컴파일, Compile
    - 소스 파일 -> 번역 -> 기계어
	- 컴파일러, Compiler // 프로그램
	- javac.exe // 자바 컴파일러
	- javac.exe 소스파일
	- 결과물 : 번역된 결과 -> *.class 파일(클래스 파일, 실행 파일, 바이너리 파일)

3. 실행, Run
	- *.java > javac.exe > *.class = 중간언어 > java.exe 와 JRE를 거쳐 해당 OS에 맞는 기계어로 2차 번역된다. 
	- *.java = 재료, *.class = 손질된 재료, 후 java.exe 와 JRE(셰프)를 거쳐 각 손님(OS) 취향에 맞게 조리
	
	- 2차 컴파일, 인터프리터
	- java.exe
	- 결과물 X - > 기계어
	- 컴파일 = 결과물 있음, 인터프리터 = 결과물 X 
	- 컴파일 = 초기 비용 많이듬 > 시간이 오래걸림, 인터프리터 = 그때그때 조금씩 동시통역, 심플하며 초기에 시간이 적게 걸림
	- JIT 컴파일러(Just In Time) = 컴파일도 아니고 인터프리터도 아닌 그 중간의 것(하이브리드)

*/

/*

식별자 규칙
- 폴더, 파일, 클래스명, 메소드명, 변수명 등등...
1. 영문자 + 숫자 + 특수문자중 "_" 만 (한글 x)
2. 숫자로 시작 x -> _2017
3. 의미있게(******) -> 약어 사용 x

소스 편집 -> 공백 사용 -> 자바 컴파일러는 (종류에 상관없이) 연속된 공백을 무시한다.
1. space
2. 엔터
3. 탭


코딩 컨벤션 = 코딩 스타일 규칙들

대소문자 철저하게 구분한다.
문법 엄격 -> 컴파일 방식

*/
import java.io.*;
class Ex02 
{

	public static void main(String[] args) throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\n\n\n입력 : ");
			int year = Integer.parseInt(reader.readLine());
			String yearAnswer = "";

		
		
			if (year % 4 != 0) {
				yearAnswer = System.out.println("평년");

			} else if (year % 100 != 0) { 
				yearAnswer = System.out.println("윤년");

			} else if (year % 400 == 0) {
				yearAnswer = System.out.println("윤년");

			} else {
				yearAnswer = System.out.println("평년");

			}
			System.out.printf("%d년은 '%s' 입니다.", year, yearAnswer);

	}

}
