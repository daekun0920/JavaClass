class Ex10_Output {

	public static void main(String[] args) {
		
	// Ex10_Output.java
		

		// printf()
		// 1. %����d
		//   - ����� ������ �ּ� �ʺ�
		//   - ���/����
		//   - ��� ���� ���ڿ� ����
		System.out.printf("[%d]\n", 100);
		System.out.printf("[%10d]\n", 100); // [       100] // 100�� 3ĭ�� �Һ� �����Ƿ� 7ĭ�� ������ ����
		System.out.printf("[%-10d]\n", 100);  // [100       ] // ���� ����

		System.out.printf("[%10d]\n", 123456789012L); // 123456789012 ������ �������������� �ƹ��ϵ� �Ͼ�� ����
		
		// 2. %.����f
		//   - �Ǽ������� ���� ����
		//   - �Ҽ� ���� �ڸ��� ����

		System.out.printf("%f\n", 3.1234); // 3.123400 // �Ҽ� 6�ڸ� ����� �⺻
		System.out.printf("%.1f\n", 3.1934); // 3.2 // �ݿø� �� 

		// 3. %d 
		//   - �������� ����(%d, %f)
		//   - �ڸ��� ǥ��
		System.out.printf("%d\n", 12345678);   // 12345678
		System.out.printf("%,d\n", 12345678);  // 12,345,678

		// �ѹ��� ��� ����ϱ�
		System.out.printf("%,15.2f\n", 21987.6773);  // �޸� ���� �����ؼ� ĭ�� ����


		System.out.println();
		System.out.println();

		// �ּҷ�
		String name1 = "ȫ�浿";
		String address1 = "����� ������ ���ﵿ";
		String email1 = "hong@naver.com";
		int salary1 = 20000;


		String name2 = "�׽�Ʈ";
		String address2 = "����� �߱�";
		String email2 = "test@naver.com";
		int salary2 = 500;

		System.out.println("=======================================");
		System.out.println("		�ּҷ�");
		System.out.println("=======================================");
		System.out.println("[�̸�]\t[�޿�(��)]\t[�ּ�]\t\t\t[�̸���]");  // ���� �����ʹ� �׻� ������ ����Ѵ�

		System.out.printf("%s\t%,6d\t%-14s\t%s\n"                   //  ȫ�浿   20,000  ����� ������ ���ﵿ    hong@naver.com
						 , name1, salary1, address1, email1); 
		System.out.printf("%s\t%,6d\t%-14s\t%s\n"                   
						 , name2, salary2, address2, email2);


		// ��� �� ���� ����
		//  1. ���ڴ� ��������(***)
		//  2. ����
		//     - a. ����(��)
		//		 	 1. ����
		//				 - ���� ����(�Խ���)
		//			 2. ���
		//				 - ���� ����
		//		
	    //     - b. ����
		//			 1. ����
		//			 2. ���
		//				 - �ֹε�Ϲ�ȣ, ��ȭ��ȣ
		//					 - 010-123-4567
		//					 - 010-1234-4567
		//			 3. ����
		//				 - ��ġ(��)	
		






	}

}
