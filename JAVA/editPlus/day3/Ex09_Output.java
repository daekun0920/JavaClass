class Ex09_Output {

	public static void main(String[] args) {
		
		
		// Ex09_Output

		// �ܼ� �⺻ �����, Console Input / Output -> IO
		//   - �⺻ �Է� ��ġ : Ű����
		//   - �⺻ ��� ��ġ : �����
		//   - �⺻ ���� ��ġ : �����
		
	 // Ŭ����.������Ƽ.�޼ҵ�();
   //	System.out.println();
   		
		// �ܼ� ���
		// 1. print �޼ҵ�
		//   - ������ ����ϰ� �׳� ����
		// 2. pritnln �޼ҵ�
		//   - ������ ����ϰ� �����ϰ� ����
		// 3. printf �޼ҵ�, print format (���ڿ� ������) 
		//   - ���� ���ڸ� �����ϴ� ���
		//   - ����ϴ� ���ڿ��� ���� ������ ����� ������ ����
		//   - ���� ���� ���
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
			����Ͻ÷��� �ƹ� Ű�� �����ʽÿ�...
											*/
		
		System.out.println();
		System.out.println();
		
		// ����ǥ
		System.out.println("[�̸�]\t[����]\t[����]\t[����]");
		System.out.println("ȫ�浿\t80\t100\t95");
		System.out.print("�ƹ���\t");
		System.out.print("85\t");
		System.out.print("77\t");
		System.out.print("60");
		System.out.println();

		/*
		  [�̸�]  [����]  [����]  [����]
		  ȫ�浿  80	  100     95  
		  �ƹ���  85      77      60 
		  ����Ͻ÷��� �ƹ� Ű�� �����ʽÿ�...

		  */
		 
		 // printf (���ڿ� ������)
		 // �䱸����) "ȫ�浿��. �ȳ��ϼ���." ���
		String name = "ȫ�浿";
		System.out.println(name + "��. �ȳ��ϼ���.");

		System.out.printf("%s��. �ȳ��ϼ���. \n", name);

		 
		int age = 20;
		System.out.println("ȫ�浿�� ���̴� " + age + "���Դϴ�.");

		System.out.printf("ȫ�浿�� ���̴� %d���Դϴ�. \n", age);

		System.out.println("���� " + name + "�Դϴ�. �� ���̴� " + age + "���Դϴ�.");

		System.out.printf("���� %s�Դϴ�. �� ���̴� %d���Դϴ�.", 
							name, age);




		// ����Ŭ -> SQL
		// insert into tblStudent (num, name, age, address) values ( 10, 'ȫ�浿', 20, '����� ������')

		int num = 10;
		String address = "����� ������";
		System.out.println("insert into tblStudent (num, name, age, address) values (" + num + ", '" + name + "', " + age + ", '" + address + "')");

		System.out.printf("insert into tblStudent (num, name, age, address) values ( %d, '%s', %d, '%s')\n",
																					num, name, age, address);


		System.out.printf("���ڿ� : %s\n", "ȫ�浿");
		System.out.printf("���� : %d\n", 100);
		System.out.printf("�Ǽ�: %f\n", 3.14);
		System.out.printf("���� : %c\n", 'A');
		System.out.printf("���� : %b\n", true);

		System.out.printf("������ : %s\n", 200);		 // ������ : 200 %s�ε� ������ ������ �뵵�� ������ ���� ����(����)�� ����ϴ°��� �����
		System.out.printf("������ : %d\n", (int)3.14);   // 3
		System.out.printf("������ : %d\n", (int)'A');    // 65
		System.out.printf("������ : %c\n", 65);          // A

		
		
		







				 		





	}

}
