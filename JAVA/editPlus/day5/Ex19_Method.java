class Ex19_Method {

	public static void main(String[] args) {
		
		// Ex19_Method.java

		// ��� �޼ҵ�, Recursive Method  // ���ذ��� �������� ���� �׷����� �ϸ� ���� �����
		//  - �޼ҵ尡 ���� �߿� �ڱ� �ڽ��� ȣ���ϴ� ������ �޼ҵ�

		// m1();

		// ���丮�� ���ϱ�
		// 4! = 4 x 3 x 2 x 1 = 24
		int n = 4;
		int result = factorial(n); // 4!
		System.out.printf("%d! = %d\n", n, result);



	} // main

	public static int factorial(int n) {
		int temp = (n == 1) ? 1 : n * factorial(n - 1); // ��� ����
		return temp;
	
	
	
	
	} // factorial()

    // m1() : ��� �޼ҵ�
	public static void m1() {
		System.out.println("m1() ����");
		m1(); //�̸��� ���� �Ȱ��� ���� ���� �ٸ� �޼ҵ��� ��������(�ƿ� m2��� �����ص���) // ��� ȣ��(Recursive call)
	
	
	
	} // m1()
	

	
}
