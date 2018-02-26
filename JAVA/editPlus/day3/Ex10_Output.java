class Ex10_Output {

	public static void main(String[] args) {
		
	// Ex10_Output.java
		

		// printf()
		// 1. %숫자d
		//   - 출력할 내용을 최소 너비
		//   - 양수/음수
		//   - 모든 형식 문자에 적용
		System.out.printf("[%d]\n", 100);
		System.out.printf("[%10d]\n", 100); // [       100] // 100이 3칸을 소비 했으므로 7칸의 공백이 생김
		System.out.printf("[%-10d]\n", 100);  // [100       ] // 좌측 정렬

		System.out.printf("[%10d]\n", 123456789012L); // 123456789012 공간이 남아있지않으면 아무일도 일어나지 않음
		
		// 2. %.숫자f
		//   - 실수형에만 적용 가능
		//   - 소수 이하 자릿수 지정

		System.out.printf("%f\n", 3.1234); // 3.123400 // 소수 6자리 출력이 기본
		System.out.printf("%.1f\n", 3.1934); // 3.2 // 반올림 됨 

		// 3. %d 
		//   - 숫자형만 가능(%d, %f)
		//   - 자릿수 표기
		System.out.printf("%d\n", 12345678);   // 12345678
		System.out.printf("%,d\n", 12345678);  // 12,345,678

		// 한번에 모두 사용하기
		System.out.printf("%,15.2f\n", 21987.6773);  // 콤마 까지 포함해서 칸을 센다


		System.out.println();
		System.out.println();

		// 주소록
		String name1 = "홍길동";
		String address1 = "서울시 강남구 역삼동";
		String email1 = "hong@naver.com";
		int salary1 = 20000;


		String name2 = "테스트";
		String address2 = "서울시 중구";
		String email2 = "test@naver.com";
		int salary2 = 500;

		System.out.println("=======================================");
		System.out.println("		주소록");
		System.out.println("=======================================");
		System.out.println("[이름]\t[급여(원)]\t[주소]\t\t\t[이메일]");  // 숫자 데이터는 항상 단위를 써야한다

		System.out.printf("%s\t%,6d\t%-14s\t%s\n"                   //  홍길동   20,000  서울시 강남구 역삼동    hong@naver.com
						 , name1, salary1, address1, email1); 
		System.out.printf("%s\t%,6d\t%-14s\t%s\n"                   
						 , name2, salary2, address2, email2);


		// 출력 시 주의 사항
		//  1. 숫자는 단위기재(***)
		//  2. 정렬
		//     - a. 문자(열)
		//		 	 1. 좌측
		//				 - 가변 길이(게시판)
		//			 2. 가운데
		//				 - 고정 길이
		//		
	    //     - b. 숫자
		//			 1. 좌측
		//			 2. 가운데
		//				 - 주민등록번호, 전화번호
		//					 - 010-123-4567
		//					 - 010-1234-4567
		//			 3. 우측
		//				 - 수치(비교)	
		






	}

}
