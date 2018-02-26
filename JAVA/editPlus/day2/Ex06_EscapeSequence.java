class Ex06_EscapeSequence {

	public static void main(String[] args) {
		

		// Ex06_EscapeSequence.java

		// Escape Sequence, 이스케이프 시퀀스
		// - 특수 문자 (비추천)
		// - Escape Character
		// - 자료형이 char
		// - 출력을 위한 데이터가 아니라 이미 약속된 행동을 하기위한 특수한 문자

		// 1. \n
		//   - new line
		//	 - 개행 문자
		char c1 = '\n';
		
		String s1 = "안녕하세요. \n홍길동님"; 
		System.out.println(s1);
		
		// 2. \r
		//   - carriage return
		//   - 캐럿(caret)의 위치를 현재 라인의 처음(첫번째 컬럼)으로 이동해라
		System.out.println("하나둘\r셋넷");  // 셋넷둘
		
		// 엔터 = \r + \n
		System.out.println("하나\n둘");   
		System.out.println("하나\r\n둘");

		// 3. \b
		//   -backspace
		System.out.println("홍길\b동");     // 홍동 ( 백스페이스 하나당 한칸씩 이동 > 덮어쓰기)
		System.out.println("홍길동아\b\b\b\b무개"); // 무개동아 

		// 4. \t
		//   - tab
		//   - 주로 열을 맞추는데에 사용됨
		//	 - 일정 간격으로 탭의 위치가 정해져있음
		//   - 가장 가까운 탭의 위치로 이동하라 

		System.out.println("홍\t길동");	
		
		String name = "홍길동";
		String height = "180";
		String address = "서울시 강남구 역삼동";
		
		System.out.println("이름 : \t" + name);       // concat (붙여 출력)
		System.out.println("키 : \t" + height + "cm");
		System.out.println("집주소 : \t" + address);  // 서로 가까운 탭이 다름

		System.out.println("문자열" + 100); // 100을 문자열로 간주해서 붙여 출력함
											// 문자열 * 숫자 는 안됨 (되는 언어 있음 ex. 파이썬)
		
		// 5. \" , \' , \\

		// 요구사항 = 화면에 <안녕하세요, "홍길동" 입니다.> 출력하시오.
		System.out.println("안녕하세요. \"홍길동\"입니다.");  // 안녕하세요, "홍길동" 입니다.

		// 요구사항 = 현재 수업 폴더의 경로를 출력
		// String path = "D:\Class\Java";   ->  illegal escape character (Error)
		String path = "D:\\Class\\Java"; // -> Correct 
		System.out.println(path);

		// \f, \a
		// Java 에선 쓰이진 않고 C# 에선 아직 가능한 오래된 escape sequence

		// 숫자 데이터를 사용할 때 생각할 점
		
		// 주민번호의 앞자리를 저장해야 한다.
		// - 901220
		int jumin1 = 901220;
		System.out.println("주민번호: " + jumin1); // 주민번호: 901220
		
		jumin1 = 011125;  // 0으로 시작해서 8진수로 인식한다.
		System.out.println("주민번호: " + jumin1);

		String jumin2 = "011125";
		System.out.println("주민번호: " + jumin2);

		// 주민번호, 전화번호, 상품번호, 학생번호, 글번호 등...
		// - 형태는 숫자이지만 실제 성질은 문자열
		// - 내가 가진 데이터가 산술 연산을 할꺼냐? ex) 전화번호 * 20 , 주민번호 + 100 ... 

		// 식별자 표기법 - > 패턴

		// 1. 헝가리언 표기법
		//   - 자료형을 식별자에 넣는 방법
		//   - 자바) 인터페이스명(ITest) 대문자 I = 인터페이스
		String _name;    // 어떠한 자료형인지 후에 구별 힘듬
		String strName;

		int num;
		int inum;

		// 2. 파스칼 표기법
		//   - 식별자가 한 단어 혹은 한 단어 이상으로 구성 -> 모든 단어를 공백없이 연결 + 모든 문자 소문자 + 각 단어의 첫 문자를 대문자로 바꿈
		//   - 자바) 클래스명
		String StudentName;

		// NumberParser = 클래스명
		
		// 3. 캐멀 표기법
		//   - 식별자가 한 단어 혹은 한 단어 이상으로 구성 -> 모든 단어를 공백없이 연결 + 모든 문자 소문자 + 각 단어의 첫 문자를 대문자로 바꿈
		//   - But, 시작 문자만은 소문자로
		//   - 자바) 변수명, 메소드명
		String studentName;
		







	}

}
