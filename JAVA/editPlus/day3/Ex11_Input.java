class Ex11_Input {

	public static void main(String[] args) throws Exception {
		
		// Ex11_Input.java

		// �ܼ� �Է� -> Ű���带 ���� �Է�(����)�� �ڹ� ���α׷����� ����ϱ�

		// 1. System.in.read()
		// 2. BufferedReader Ŭ����
		// 3. Scanner Ŭ����

		// �䱸����) ����ڷκ��� ���� 1���� �Է¹޾Ƽ� �״�� ����Ͻÿ�.
		
		// �Ӿ� : block �ɷȴ�.
		// �Է� ��� ����..
		

		/*

		System.out.print("�����Է� : ");	                         // Label				  
		

		int n = System.in.read();			                         // a �Է½� 97(�ڵ尪) ��� // �����ڵ� x, ASCI �ڵ常 ����
		System.out.printf("�Է��Ͻ� ���ڴ� '%c'�Դϴ�.\n", (char)n);

		*/		

		System.out.print("�����Է� : "); // a �Է½� 97, 13, 10 �ٽ� a �Է½� 97, 13 = �� 97, 13, 10, 97, 13
		int n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);

		n = System.in.read();
		System.out.println(n);
		
		
		
		
		// Ű����(a �� ���� �Է� > a\r\n(a�� ����) ����) > �Է� ����(�ӽ� �� �����) > ���α׷��� ���ۿ� ã�ư� ��(a(97)�� \r(13), \n(10))�� ������ > ���ۿ� ���� ���̻� ���� 2���� ���� �� ��������
	}

}
