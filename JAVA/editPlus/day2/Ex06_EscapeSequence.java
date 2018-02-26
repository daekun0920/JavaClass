class Ex06_EscapeSequence {

	public static void main(String[] args) {
		

		// Ex06_EscapeSequence.java

		// Escape Sequence, �̽������� ������
		// - Ư�� ���� (����õ)
		// - Escape Character
		// - �ڷ����� char
		// - ����� ���� �����Ͱ� �ƴ϶� �̹� ��ӵ� �ൿ�� �ϱ����� Ư���� ����

		// 1. \n
		//   - new line
		//	 - ���� ����
		char c1 = '\n';
		
		String s1 = "�ȳ��ϼ���. \nȫ�浿��"; 
		System.out.println(s1);
		
		// 2. \r
		//   - carriage return
		//   - ĳ��(caret)�� ��ġ�� ���� ������ ó��(ù��° �÷�)���� �̵��ض�
		System.out.println("�ϳ���\r�³�");  // �³ݵ�
		
		// ���� = \r + \n
		System.out.println("�ϳ�\n��");   
		System.out.println("�ϳ�\r\n��");

		// 3. \b
		//   -backspace
		System.out.println("ȫ��\b��");     // ȫ�� ( �齺���̽� �ϳ��� ��ĭ�� �̵� > �����)
		System.out.println("ȫ�浿��\b\b\b\b����"); // �������� 

		// 4. \t
		//   - tab
		//   - �ַ� ���� ���ߴµ��� ����
		//	 - ���� �������� ���� ��ġ�� ����������
		//   - ���� ����� ���� ��ġ�� �̵��϶� 

		System.out.println("ȫ\t�浿");	
		
		String name = "ȫ�浿";
		String height = "180";
		String address = "����� ������ ���ﵿ";
		
		System.out.println("�̸� : \t" + name);       // concat (�ٿ� ���)
		System.out.println("Ű : \t" + height + "cm");
		System.out.println("���ּ� : \t" + address);  // ���� ����� ���� �ٸ�

		System.out.println("���ڿ�" + 100); // 100�� ���ڿ��� �����ؼ� �ٿ� �����
											// ���ڿ� * ���� �� �ȵ� (�Ǵ� ��� ���� ex. ���̽�)
		
		// 5. \" , \' , \\

		// �䱸���� = ȭ�鿡 <�ȳ��ϼ���, "ȫ�浿" �Դϴ�.> ����Ͻÿ�.
		System.out.println("�ȳ��ϼ���. \"ȫ�浿\"�Դϴ�.");  // �ȳ��ϼ���, "ȫ�浿" �Դϴ�.

		// �䱸���� = ���� ���� ������ ��θ� ���
		// String path = "D:\Class\Java";   ->  illegal escape character (Error)
		String path = "D:\\Class\\Java"; // -> Correct 
		System.out.println(path);

		// \f, \a
		// Java ���� ������ �ʰ� C# ���� ���� ������ ������ escape sequence

		// ���� �����͸� ����� �� ������ ��
		
		// �ֹι�ȣ�� ���ڸ��� �����ؾ� �Ѵ�.
		// - 901220
		int jumin1 = 901220;
		System.out.println("�ֹι�ȣ: " + jumin1); // �ֹι�ȣ: 901220
		
		jumin1 = 011125;  // 0���� �����ؼ� 8������ �ν��Ѵ�.
		System.out.println("�ֹι�ȣ: " + jumin1);

		String jumin2 = "011125";
		System.out.println("�ֹι�ȣ: " + jumin2);

		// �ֹι�ȣ, ��ȭ��ȣ, ��ǰ��ȣ, �л���ȣ, �۹�ȣ ��...
		// - ���´� ���������� ���� ������ ���ڿ�
		// - ���� ���� �����Ͱ� ��� ������ �Ҳ���? ex) ��ȭ��ȣ * 20 , �ֹι�ȣ + 100 ... 

		// �ĺ��� ǥ��� - > ����

		// 1. �밡���� ǥ���
		//   - �ڷ����� �ĺ��ڿ� �ִ� ���
		//   - �ڹ�) �������̽���(ITest) �빮�� I = �������̽�
		String _name;    // ��� �ڷ������� �Ŀ� ���� ����
		String strName;

		int num;
		int inum;

		// 2. �Ľ�Į ǥ���
		//   - �ĺ��ڰ� �� �ܾ� Ȥ�� �� �ܾ� �̻����� ���� -> ��� �ܾ ������� ���� + ��� ���� �ҹ��� + �� �ܾ��� ù ���ڸ� �빮�ڷ� �ٲ�
		//   - �ڹ�) Ŭ������
		String StudentName;

		// NumberParser = Ŭ������
		
		// 3. ĳ�� ǥ���
		//   - �ĺ��ڰ� �� �ܾ� Ȥ�� �� �ܾ� �̻����� ���� -> ��� �ܾ ������� ���� + ��� ���� �ҹ��� + �� �ܾ��� ù ���ڸ� �빮�ڷ� �ٲ�
		//   - But, ���� ���ڸ��� �ҹ��ڷ�
		//   - �ڹ�) ������, �޼ҵ��
		String studentName;
		







	}

}
