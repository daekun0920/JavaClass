import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex16_Method {

	public static void main(String[] args) throws Exception {
		
		// Ex16_Method.java

		/*
		
		�޼ҵ� ����

		���������� ����Ű���� ��ȯ�� �޼ҵ��(���ڸ���Ʈ) {
		
		������


	     }

		*/
		
		// ���� ����Ʈ(Parameters, Arguments)

		// �䱸����) "ȫ�浿�� �ȳ��ϼ���." - ��� �޼ҵ�
		// System.out.println("ȫ�浿�� �ȳ��ϼ���.");
		// hello();
		
		//public static void hi(String name)
		hi("ȫ�浿");  // ����(�Ķ����) �Ѱ��ֱ� 

		// �߰�����) "�ƹ����� �ȳ��ϼ���." ���
		// System.out.println("�ƹ����� �ȳ��ϼ���.");
		// hello();
		hi("�ƹ���");

		// �߰�����) �츮 ���ǽ��� ��� ��� ���
		// �߰�����) �ѵ� �ǹ�
		// �߰�����) ������


		// hi(); // �Ķ����(Parameters, Arguments) ���̴� ������ �Ұ���
		// hi(100);
		// hi("������", 100);
		add(10, 20);
		add(142, 22);
		add(5350, 1440);
		add(12, 775);
		

		check("ȫ�浿", 25);
		check("�ƹ���", 12);
		check("������", 80);

		int n = num();
		System.out.println(n);
		
		bye();
		
		int m = 5;

		int result = getSquare(m); // ������(�Ű����� ��)
		System.out.println(result);
      // �ؿ� ��� ������ �ϳ� ���ϼ� ���� (�������� �ټ� ������) 
		System.out.println(getSquare(m));

	} // main

	public static void hello() {
		
		System.out.println("ȫ�浿�� �ȳ��ϼ���.");
	

	} // hello
	
	public static void hi(String name) {
		// String name = "ȫ�浿";
		System.out.println(name + "�� �ȳ��ϼ���.");
	

	

	}
	
	public static void add(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);



	}

	public static void check(String name, int age) {
		String result = (age >= 20 && age < 60) ? "���" : "Ż��";
		System.out.printf("�� '%s'���� '%s'�Դϴ�.\n"
						  , name, result);


	
	
	}

	public static int num() {
	
		
		//���Ϲ�, ��ȯ�� 
		return 10; // int������ (��ȯ�� int)
	
	
	
	
	
	}
	
	// �̸��� �Է��ϸ� �λ��ϱ�
	// void = ��ȯ���� ���� 
						//  BufferedReader �� �ִ°��� �װ��� ȣ���Ѱ� 
	public static void bye() throws Exception {
		BufferedReader reader
			= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸� �Է�: ");

		
		String name = reader.readLine();

		System.out.printf("%s�� �ȳ��ϼ���.\n", name);
		

	}

	// ���� 1�� ���� -> �������� ��ȯ
	// 2 -> 4
	// 8 -> 64
	
	// �޼ҵ� ���
	//   -> �޼ҵ� �ñ׳���(Signature)
	//   -> �޼ҵ� ����       

	// ��ȯ��(����) �ڷ����� ��ȯ�� �ڷ����� ���ƾ���
	public static int getSquare(int n) { // ������(�Ű� ����)
		
		int result = 0;
		
		result = n * n;
		

		System.out.println("�۾��� �Ϸ�Ǿ����ϴ�.");

		return result; // �޼ҵ� ����


		// return n * n; (�̰� ����)
		
		// System.out.println("�۾��� �Ϸ�Ǿ����ϴ�."); -> return ���� �޼ҵ尡 ����Ǳ⶧���� �����������ؼ� ������ ����
	
	
	}

	

}
