import java.io.*;


class Ex24_switch {

	public static void main(String[] args) throws Exception {
		
		//Ex24_switch.java

		/*
		
			switch (���ǰ�) {
				case �� :
					�����ڵ�;
					break;
				[case �� :       // ���ȣ�� ���� �ᵵ �ǰ� �Ƚᵵ �ȴٴ� �ǹ�
					�����ڵ�;
					break;]
				[case �� :
					�����ڵ�;
					break;]
				[default:
					�����ڵ�;
					break;]
			
			}


		*/
		
		// �䱸����) ���� �Է�(1 ~ 3) �޾� �ѱ۷� ��� 
		int num = 1;

		// switch ���� ���ǰ��� ������ �����ϴ�. + String ����		  // ���� ����ġ ���̽��� �����ϴ°��� �� ����� 
		switch (num) { // ������ �ϳ��� �����͸� �� 
			case 1:
				System.out.println("�ϳ�");
				break; // ������ �ƴ� // break ������ ������ �귯���� // ���� �ڽ��� ���� ����� Ż��

			case 2:
				System.out.println("��");
				break;

			case 3:
				System.out.println("��");
				break;

			default: // if���� else�� ���� 
				System.out.println("��");
				break;
		
		
		}

	// ���Ǳ� -> ���� ���� -> ���� ���

	System.out.println("====================================");
	System.out.println("		���Ǳ�");
	System.out.println("====================================");
	System.out.println("1. �ݶ�");
	System.out.println("2. ���̴�");
	System.out.println("3. ��ī��");
	System.out.println("====================================");
	System.out.print("���� ����(��ȣ): ");

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String input = reader.readLine();

	switch (input) {
		case "1": 
	     // System.out.println("700���Դϴ�.");  // �ݶ�� ���̴� ���� ���� (�귯����) -> ���� ��� 
		 // break;
		case "2":
			System.out.println("700���Դϴ�.");
			break;
		case "3":
			System.out.println("500���Դϴ�.");
			break;

	}

	//���� ��ǰ or ���θ�

	//ī�޶� ����
	// 1. �ɼ� : ī�޶� + �޸� + �ﰢ��
	// 2. �ɼ� : ī�޶� + �޸�
	// 3. �ɼ� : ī�޶�

	System.out.println("\nī�޶� ���θ�");
	System.out.print("�ɼ� ���� : ");
	input = reader.readLine();
	
	switch (input) {
		case "1":
			//System.out.println("ī�޶�"); 
			//System.out.println("�޸�");
			System.out.println("�ﰢ��");
			//break;
		case "2":
			//System.out.println("ī�޶�");
			System.out.println("�޸�");
			//break;
		case "3":
			System.out.println("ī�޶�");
			break;
			
	}


	}

}
