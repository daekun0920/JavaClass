// class Ex05_Variable { = K&R ��Ÿ��(����̾� Ŀ���� & ���Ͻ� ��ġ)

class Ex05_Variable
{ // Allman ��Ÿ��

	public static void main(String[] args) {
		//Ex05_Variable.java

		byte a;
		// Ÿ�Կ� ������� ��� ������ �ߺ��ɼ� ����.
		//byte a;
		//int a;
		//a = 10;

		//����, ����, ����
		int kor, eng, math; // ����, ����, ����

		// 1��1 ���� �ּ� �ޱⰡ �� ���� ����
		int weight, // ������
			height; // Ű
		
		// ���ڷ��� ���� ���� + ������

		// ������
		// 1. byte

		//������ ���, ������ ���ͷ�
		byte b1 = 10; //b1(����), 10(������, ���, Literal)
		// b1 = 128; < �����÷ο�(overflow), Error
		// b1 = -129; < ����÷ο�(underflow), Error

		//2. short
		short s1;
		s1 = 10;
		// s1 = 32768; // incompatible types: possible lossy conversation from int to short

		//3. int
		int n1 = 10;
		// n1 = 2200000000; // integer number too large: 2200000000
		//4. long
		long l1 = 10;
		l1 = 10000000000000000L; // interger number too large: 10000000000000000
		// Long �� ����� ���ؼ��� ���(���ͷ�) �������� L,l�� �ٿ��־���Ѵ�.

		// ��� ����� integer Ÿ�� �̴�.

		// ���� ������
		// - ���� = ��;
		// - LValue(����) = RValue(����, ���);
		// - �ݵ�� LValue�� RValue�� �ڷ����� ��ġ
		// �����Ϸ����� �ڵ������� �ǿ��� ���ش� byte ~ short = ���(int)

		int a1 = 10;
		int b;
		b = a1;

		// �Ǽ��� 
		float f1 = 3.14F;
		f1 = 1234567890123456789.12345678901234567890F;
		System.out.println(f1);

		// double = �� �� ������, �⺻ �ڷ���
		double d1 = 2.58;
		d1 = 1234567890123456789.12345678901234567890;
		System.out.println(d1);

		// ����
		boolean flag = true;
		flag = false;
		System.out.println(flag);

		// ������
		char c1 = 'A';
		System.out.println(c1);

		c1 = '��';
		System.out.println(c1);

		//c1 = 'ABC'; > ���� �Ѱ��� ������ ����(����)
		//System.out.println(c1);

		c1 = '1'; // ���� 1 �� �ƴ� ���ڷμ��� '1' ��
		System.out.println(c1);

		// �⺻�� x
		// ������ o

		// char : ���� 1 ��
		// String : ���� ������

		// ȫ�浿
		
		String name = "ȫ�浿"; // ���� 1 �� : ' ' , ���� ������ : " " 


		int num = 10;
		int Num = 20;
		int nuM = 30;
		int nUm = 40;

		// �ڹٿ���..
		// ������ ����
		// 1. �ܾ �ҹ��ڷ� ����
		int NUM = 10; // ��� �빮�ڷ� �����Ұ�� �����
		int num1 = 10;

		// �л� ��ȣ
		// Student Number
		int studentnumber; // ������ ������, ù ���ڴ� ������ �ҹ��ڷ� �����ؾ���
		int studentNumber; // ĳ�� ǥ���
		int student_number; // ������ũ ǥ���

		
		// �����(�����)
		// 10����, 2����, 8����, 16����..

		int n2 = 10;   // 10 ����
		System.out.println(n2);

		int n3 = 010;  // 8 ����
		System.out.println(n3);

		int n4 = 0x10; // 16 ����
		System.out.println(n4);
		

		
	}

}
