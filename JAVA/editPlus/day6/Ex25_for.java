class Ex25_for {

	public static void main(String[] args) {
		
		// Ex25_for.java

		/*

		for ��
		-  �ݺ���
		-  ������ �����ϴ� ���� (����) �ݺ��ؼ� �����ض�

		for (�ʱ��; ���ǽ�; ������) {
			���� �ڵ�;
		
		}
		
		*/
			
		//m1();
		m2();

	} // main()
	public static void m2() {

		//for (int i = 0; i < 10; i++) {
		//for (int i = 1; i <= 10; i++) {
		for (int i = 324; i <= 334; i++) {
			System.out.println("���ﵿ");

		}
		
		// ���� ������ ����
		// 1. ȸ�� ���� �����Ѵ�. (�ʱ�)
		// 2. ���� ������ ���� ������ ����Ѵ�. (��/���)

		// �䱸����) ���ڸ� 1 ~ 10000000���� ����Ͻÿ�
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		 // i = i + 1;	// 1, 3, 5, 7, 9		
		 // i += 1;
		 // i++
		 //	i = 5; // ���� ����
		}
		
		// �䱸����) ���� 1 ~ 10 ������ ¦���� ����Ͻÿ�.
		for (int i = 2; i < 11; i = i + 2) {  // 12�� �ȴ��� �Ѱܳ��� 
				//   1����  10 ����
			System.out.println(i);
			
			//if (i % 2 == 0) {
			//System.out.println(i);
			//}
		}

		for (int i = 1; i < 11; i = i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		
		}
	
	} // m2



	public static void m1() {
		
		// �ݺ� -> loop
		// for i, j -> ���� ����(���� ����)
		for (int i = 0; i < 3; i++) {		  // 0 ���� ���� 0 ~ 9							   // �ʱ���� �ʹݿ� �� �ѹ��� ���� 
			System.out.println("�ȳ��ϼ���"); // i < �ʱ�� �ϰ�� ���ǽ� - �ʱ�� = �ݺ� Ƚ�� // i <= �ʱ�� �ϰ�� ���ǽ� - �ʱ�� = �ݺ� Ƚ�� + 1 
		
		
		
		} // �ݺ����� ������ ������ �ٽ� �ö󰣴� 
		
		int j = 0;

		for (j = 0; j < 3; j++) {
			System.out.println("�ݰ����ϴ�.");
		
		}
	
	
	} // m1



}
