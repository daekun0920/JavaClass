// 1.
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ex13_BufferedReader {

	public static void main(String[] args) throws Exception{ // 2.
		
		// Ex13_BufferedReader.java
		
		char c1 = ' ';  // �����̽��� ���� �ڵ尪�� ������ ����
		System.out.println(c1);

		String s1 = ""; // �� ���ڿ�(Empty String), string�� ������ ����־ ��������
		System.out.println(s1);





		// int num;
		// System.out.println(num); // �ƹ��͵� ����, ���굵 �ȵ� 

		// 3.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // �� 3�ܰ�� �ٷ� �ݻ������� �ٷγ��������� �ͼ���������(�ܿ��� ��)
																					  // �ڵ�� �Ӹ��� �Ἥ ���°͵� ������ ��κ� ���־��̴� �ڵ� ������ �ܿ��� �ݺ����� �ڵ带 �ۼ��ϴ°��� ������
		

		// �䱸����) �¾ �⵵�� �Է¹޾� ���̸� ����Ͻÿ�.
		//          2017 - �¾ �⵵ = ����
		
		System.out.print("�¾ �⵵ : ");

		String input = reader.readLine(); // "1990" > ���ڿ�
		
		int age = 2017 - Integer.parseInt(input);

		System.out.printf("%s�⵵�� �¾ ����� %d���Դϴ�.\n"
							, input, age);

		// �䱸����) ���ڸ� 2�� �Է¹޾� �Ʒ��� ���� ������� ���
		//			2.5 + 3.4 = 5.9
		// ����) �Ҽ����� 1�ڸ������� ���

		System.out.print("ù��° ���� : ");
		String input1 = reader.readLine();
		double num1 = Double.parseDouble(input1);

		System.out.print("�ι�° ���� : ");
		String input2 = reader.readLine();
		double num2 = Double.parseDouble(input2);

		System.out.printf("%.1f + %.1f = %.1f\n"
							, num1, num2, num1 + num2);
		







		


	}

}
