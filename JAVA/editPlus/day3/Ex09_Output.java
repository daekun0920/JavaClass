class Ex09_Output {

	public static void main(String[] args) {
		
		
		// Ex09_Output

		// 콘솔 기본 입출력, Console Input / Output -> IO
		//   - 기본 입력 장치 : 키보드
		//   - 기본 출력 장치 : 모니터
		//   - 기본 에러 장치 : 모니터
		
	 // 클래스.프로퍼티.메소드();
   //	System.out.println();
   		
		// 콘솔 출력
		// 1. print 메소드
		//   - 내용을 출력하고 그냥 종료
		// 2. pritnln 메소드
		//   - 내용을 출력하고 개행하고 종료
		// 3. printf 메소드, print format (문자열 포맷팅) 
		//   - 형식 문자를 지원하는 출력
		//   - 출력하는 문자열에 대한 형식을 만들기 쉽도록 지원
		//   - 형식 문자 사용
		//      a. %s : String
		//		b. %d : Decimal(byte, short, int)
		//		c. %f : Float(float, double)
		//		d. %c : Char(char)
		//		e. %b : Boolean(boolean)



		System.out.print(100);        
		System.out.print(200);
		System.out.println();
		System.out.print(300 + "\n"); 
		
		/*  100200
			300
			계속하시려면 아무 키나 누르십시오...
											*/
		
		System.out.println();
		System.out.println();
		
		// 성적표
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("홍길동\t80\t100\t95");
		System.out.print("아무개\t");
		System.out.print("85\t");
		System.out.print("77\t");
		System.out.print("60");
		System.out.println();

		/*
		  [이름]  [국어]  [영어]  [수학]
		  홍길동  80	  100     95  
		  아무개  85      77      60 
		  계속하시려면 아무 키나 누르십시오...

		  */
		 
		 // printf (문자열 포맷팅)
		 // 요구사항) "홍길동님. 안녕하세요." 출력
		String name = "홍길동";
		System.out.println(name + "님. 안녕하세요.");

		System.out.printf("%s님. 안녕하세요. \n", name);

		 
		int age = 20;
		System.out.println("홍길동의 나이는 " + age + "살입니다.");

		System.out.printf("홍길동의 나이는 %d살입니다. \n", age);

		System.out.println("저는 " + name + "입니다. 제 나이는 " + age + "살입니다.");

		System.out.printf("저는 %s입니다. 제 나이는 %d살입니다.", 
							name, age);




		// 오라클 -> SQL
		// insert into tblStudent (num, name, age, address) values ( 10, '홍길동', 20, '서울시 강남구')

		int num = 10;
		String address = "서울시 강남구";
		System.out.println("insert into tblStudent (num, name, age, address) values (" + num + ", '" + name + "', " + age + ", '" + address + "')");

		System.out.printf("insert into tblStudent (num, name, age, address) values ( %d, '%s', %d, '%s')\n",
																					num, name, age, address);


		System.out.printf("문자열 : %s\n", "홍길동");
		System.out.printf("정수 : %d\n", 100);
		System.out.printf("실수: %f\n", 3.14);
		System.out.printf("문자 : %c\n", 'A');
		System.out.printf("논리형 : %b\n", true);

		System.out.printf("정수형 : %s\n", 200);		 // 정수형 : 200 %s로도 가능은 하지만 용도에 적합한 형식 문자(포맷)을 사용하는것이 권장됨
		System.out.printf("정수형 : %d\n", (int)3.14);   // 3
		System.out.printf("문자형 : %d\n", (int)'A');    // 65
		System.out.printf("문자형 : %c\n", 65);          // A

		
		
		







				 		





	}

}
