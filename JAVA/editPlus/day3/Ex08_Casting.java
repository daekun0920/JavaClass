class Ex08_Casting {

	public static void main(String[] args) {
		
		// Ex08_Casting // �� �ڵ� ����

		// ����ȯ
		// 1. �Ͻ����� ����ȯ
		// 2. ������� ����ȯ

		// ���� -> ����

		byte b1 = 10; // ����   1 byte
		long l1;	  // ���纻 8 byte
		
		// �Ͻ����� ����ȯ(���� �ս� x)
		// l1 = b1;
		l1 = (long)b1; //�����Ϸ��� �ڵ������� ������ ���������� (long) ���°��� ����
		
		System.out.println(l1); // 10 // ���纻 Ȯ�� 

		// �Ǽ���
		float f1 = 3.14F;  // ����
		double d1;		  // ���纻
		
		// �Ͻ����� ����ȯ
		d1 = f1;
		
		// Ű ��ũ�� alt + 1
		
		System.out.println(d1);

		double d2 = 1.23456789012345; // ����
		float f2;					  // ���纻
		
		System.out.println(d2);      // 1.23456789012345

		f2 = (float)d2;

		System.out.println(f2);      // 1.2345679 (�ݿø� ��)

		// �Ǽ� <-> ����
		
		double d3 = 3.994;	// ����
 		int n3;				// ���纻
		
		// ������� ����ȯ (8 byte -> 4 byte)
		n3 = (int)d3;

		System.out.println(n3);   // 3  // �Ҽ��� ������ ����(floor, trunc)

		float f4 = 3.14F;
		long l4;
		
		// ū��(8) = ������(4) //f4�� �� ū���� ( ǥ���� �Ҽ��ִ� ���� ������ �ξ� ����) // ������� ����ȯ
		// ���� ����(O), ����Ʈ ũ�� ��(X)
		l4 = (long)f4;

		System.out.println(l4); // 3.140000104904175

		// �⺻���� ���� �� 
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//           char(2)
		// boolean(1)
		// ** �⺻���� ������������ ��ȯ�� �Ұ���(�޸� ���� ������)
		
		// boolean�� ����ȯ�� ����� �� �� ����.

		// ������ ����ȯ
		//  - 'A' -> 65(���� �ڵ尪)  // �������� ���������θ� �ٲܼ� �ִ�.
		
		char c5 = '��'; // 2 byte
		short s5;      // 2 byte
		// ���� = ����
		s5 = (short)c5; // -21504  // ����� 
		// char�� ��ȣ��ȣ�� ������� �ʾƼ� 2 byte ��� ����ϰ� �Ǽ� �ִ� ���� 60000(���) ������
		// short �� ��ȣ��ȣ�� ����ϹǷ� �ִ� ����� �뷫 30000�̶� �����Ⱚ�� ���´�.

		System.out.println(s5); // 65
		

		System.out.println((char)66); // B

		char c6 = '��'; // 2 byte
		int n6; // 4 byte
		
		n6 = c6;
		System.out.println(n6);  // 44032

		int n7 = 5;
		char c7 = '5';

		System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');   // 65
		System.out.println((int)'Z');	// 90	
		System.out.println((int)'a');	// 97
		System.out.println((int)'z');	// 122 
		System.out.println((int)'0');	// 48
		System.out.println((int)'9');	// 57
		
		System.out.println((int)'��');	// 44032
		System.out.println((int)'�R');	// 55203
		
		// 'A' 'a' '0'

		
















	}

}
