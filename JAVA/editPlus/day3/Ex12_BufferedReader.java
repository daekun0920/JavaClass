// Ex12_BufferedReader

// import java.io.BufferedReader;  // Ŭ������ import
// import java.io.InputStreamReader;
import java.io.*; // io �ȿ� ����ִ� ��� Ŭ������ �����´�  // ��Ű���� import 

	 // java ���� �ȿ� io ������ BufferedReader

// Ŭ������ ��� ���� > ��Ű��(����)

// java.lang // �⺻ ��Ű���� import ��� ��밡�� (string, system �������)

class Ex12_BufferedReader {

	public static void main(String[] args) throws Exception {
	
		
		// Ex12_BufferedReader.java

		// System.in.read(); // ����Ʈ ���� �Է�
		// BufferedReader    // ���� ���� �Է� (�����ڵ� ����)

		// System.out.print("���� �Է�: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		

		// int n = reader.read(); // �Է���
		// System.out.println((char)n);

	    // String str = reader.readLine();
		// System.out.println(str);

		// str = reader.readLine(); // readLine�� ���� ����(���Ͱ� = \r\n)�� ������ ���� ������ �а� ���ۿ� �ִ� ���Ͱ��� readLine���� ������(�ɷ��ش�)
		// System.out.println(str);

		
		// �Է¹��� �� �ִ� �������� ����?

		// 1. ����
		// System.in.read()
		
		// reader.read() // �Է��� - ���� �ڵ� ��ȯ
		// reader.readLine()       - ���ڿ� ��ȯ
		
		// �䱸����) ���� 1�� �Է� + 100 �� �Ͻÿ�.
		// String num = reader.readLine(); 
		// System.out.println(num + 100);
		
		// int code = reader.read();
		// System.out.println(code - 48 + 100); // �������ڿ� 48�� ������ �־ ���ָ� ���� ���ڰ� �ȴ�

		// �䱸����) ���� 2�ڸ� �Է� + 100 �� �Ͻÿ�.
		
		

		/*****

		int num;

		int code = reader.read(); // ������ �Է��ص� ���ڷ� ��
		System.out.println(code - 48);
		
		num = (code - 48) * 10;

		code = reader.read();
		System.out.println(code - 48);

		num = num + (code - 48);

		System.out.println(num + 100);

		*/
		

		/*****

		String str = reader.readLine();  // �⺻������ �������� ���������� ���ٲ�
		System.out.println(str + 100);   // "25" -> 25
		System.out.println(Integer.parseInt(str) + 100); // �̷��� �ϸ� ����
		
		*/

		// ���ڿ� -> int

		// �ڷ��� -> Wrapper Class(Util Class)
		// byte -> Byte
		// short -> Short
		// int -> Integer
		// long -> Long
		// float -> Float
		// double -> Double
		// boolean -> Boolean

		// System.out.println(Integer.parseInt("100")); // ����ϱ� // 100 
		// System.out.println(Byte.parseInt("100"));
		// System.out.println(Double.parseInt("3.14"));
		// System.out.println(Boolean.parseInt("true"));


		// int�� �ִ밪
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		

		// reader.readLine() ��� ��
		// - ���� �Է� -> "���ڿ�" -> Util Class ParseXXX() ��� -> ����
		// - ���ڿ� �Է� -> ���ڿ�
		// - ���� �Է� -> "���ڿ�" -> '����'

		String str = reader.readLine();
		System.out.println(str); // "a" -> 'a' // (char)str �̷��Դ� �ȵ�  
		System.out.println((int)str.charAt(0));



	}

}
