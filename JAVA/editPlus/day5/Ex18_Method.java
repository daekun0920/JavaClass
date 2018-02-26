class Ex18_Method {

	public static void main(String[] args) {
	
		// Ex18_Method.java

		// �޼ҵ� �����ε�, Method Overloading // ������ ������� ���� ***
		//  - ���� �̸��� �޼ҵ带 ������ ����� ���
		//  - ������ ������ Ÿ���� �ٸ��� ������ �̸��� �޼ҵ带 ������ ������ �� �ִ�.

		// �޼ҵ� �����ε� ���� ����
		//  - ���� ����
		//       or 
		//  - ���� Ÿ��

		// �޼ҵ� �����ε� ���� ���� X
		//  - ���� �̸�
		//  - ��ȯ�� Ÿ��
		
		// �����ε��� ���� �Ǵ�
		//  - ȣ���� ���� ��Ȳ�� ����(***)
		
		// test();			// 2
		// test(10);		// ��������� ���� ������ �ȵ�(�Ű������� �̸��� �ٸ��ٰ��ؼ� ������ ��������)
		// test("ȫ�浿");  // 6
		// test(10, 20);	// 7
		// int num = test();
		// test();
		
		// test(10);        // 4

		// byte b = 10;     // 9
		// test(b);

		// �ҽ��� �ۼ� ��...
		// 1. main()
		// 2. public static void test() {} // O
		// 3. public static void test() {} // X(2)
		// 4. public static void test(int n) {} // O 
		// 5. public static void test(int m) {} // X(4)
		// 6. public static void test(String s) {} // O
		// 7. public static void test(int n, int m) {} // O
		// 8. public static int test() {} // X(2)
		// 9. public static void test(byte n) {} // O // ���� ������ ����

		// �䱸����) �� ���� �����͸� ���ڷ� ���� -> ���ؼ� ����ϴ� �޼ҵ�
		//   - int + int
		//   - double + double
		//   - String + String
		add(10, 20);
		add(5, 7);
		add(33, 99);
		

		add(3.1, 2.5);
		add("ȫ�浿", "�ƹ���");

	} // main
	public static void println(int a) {
	
	}

	// �ڹٴ� �޼ҵ带 ������ �� �޼ҵ���� ����Ѵ�.(X)
	// �ڹٴ� �޼ҵ带 ������ �� �޼ҵ��� ���ڸ���Ʈ�� ����Ѵ�.(O)

	// add(*******)
	//  - �޼ҵ��� �̸����� add��� �ܾ ���� ������ ���
	public static void add(int a, int b) {
		
		System.out.printf("%d + %d = %d\n", a, b, a + b);


	
	
	
	
	
	} 

	public static void add(double a, double b) {
		
		System.out.printf("%.1f + %.1f = %.1f\n", a, b, a + b);


	
	
	
	
	
	} 
	public static void add(String a, String b) {
		
		System.out.printf("%s + %s = %s\n", a, b, a + b);


	
	
	
	
	
	} 


}
