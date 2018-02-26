import java.io.*;

class Ex25_for {

	public static void main(String[] args)throws Exception{
		
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
		//m2();
		//m3();
		//m4();
		//m5();
		m6();

	} // main()
	public static void m6() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// �䱸����) ����ڰ� �Է��� 10���� ������ ������ ���Ͻÿ�.
		// �Է�) ���� : 5
		//       ���� : 7
		// ...
		//       ����: 10
		// ���) ���� : 424


		// ��������
		// for�� �ȿ��� ������ �ȵ�
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("���� : ");
			int num = Integer.parseInt(reader.readLine());
			

			// ����
			sum += num;
			
		}	
		System.out.println(sum);
	
	
	
	
	}

	public static void m5() {
		
		// ���� -> ������ ���ϱ� 

		//�䱸����) 1 ~ 10 ������ �� ���ϱ�
		//    0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		//   (0 + 1) + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		//  ((0 + 1) + 2) + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		// (((0 + 1) + 2) + 3) + 4 + 5 + 6 + 7 + 8 + 9 + 10

		// ���� ����
		//   - ���� ������ ���� ���꿡 ������ ���� �ʱ� ���ؼ� �׻� 0���� �ʱ�ȭ

		int sum = 0; // for���� ����ȴٴ� ������ ���⶧���� �ʱ�ȭ�� �ؾ��Ѵ� // for���� ����ǵ� Null + 1 �� �Ǳ⶧���� �ݵ�� �ʱ�ȭ �ؾ���

		for (int i = 1; i <= 10; i++) {
			sum = sum + i; // ����
		}
		System.out.println(sum);
		

		// 1 ~ 100 ������ ¦���� ��
		sum = 0;
		for ( int i = 2; i <= 100; i += 2) {
			sum += i; // sum = sum + i 

		}
		System.out.println(sum);
		
		// 1 ~ 100 ������ Ȧ���� ��
		sum = 0;
		for ( int i = 1; i <= 100; i += 2) {
			sum += i; // sum = sum + i 

		}
		System.out.println(sum);



		int stack = 0;

		for (int i = 1; i <= 10; i++) {
			stack = stack + i;
			System.out.println(stack);
		}

	
	}

	
	public static void m4() throws Exception {

		// ������ ����ϱ�
		// 5 x 1  = 5
		// 5 x 2 = 10 
		// 5 x 3 = 15
		// ..
		// 5 x 9 = 45
		// System.out.println("===============");
		// System.out.println("      5��");
		// System.out.println("===============");
		
		for (int i = 1; i < 10; i++) {
			//System.out.printf("5 x %d = %2d\n", i, 5 * i);
									// 2 �ڸ� ���� ������
		}							// ��� - ��������, ���� - ��������
		// �䱸����) ����ڷκ��� ���ϴ� �ܰ� �ִ밪�� �Է¹޾Ƽ� �������� ����Ͻÿ�.
		// �Է�) ��: 5
		//   �ִ밪: 15
		// ���) 5 x 1 = 5
		//       ..
		//       5 x 15 = 75
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int dan = 0;
		int max = 0;

		System.out.print("�� : ");
		dan = Integer.parseInt(reader.readLine());

		System.out.print("�ִ밪 : ");
		max = Integer.parseInt(reader.readLine());

		System.out.println("===============");
		System.out.printf("      %d��\n", dan);
		System.out.println("===============");

		for (int i = 1; i <= max; i++) {
			System.out.printf("%2d x %2d = %4d\n", dan, i, dan * i);
		
		
		}
		
		
	
	} // m4

	public static void m3() {
		
		for (int i = 1; i <= 10; i++) {  // 1 ���� 10 ���� 
			// System.out.println(i + "\t");
			System.out.println(11 - i + "\t");
		}
		System.out.println();
		
		//�䱸����) 10 ~ 1 ���
		for (int i = 10; i >= 1; i--) {
			System.out.println(i + "\t");
		
		}
	
	
	
	} // m3




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
