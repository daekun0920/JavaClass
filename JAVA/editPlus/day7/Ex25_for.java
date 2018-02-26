import java.io.*;
import java.util.Random;

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
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		//m13();
		//m14();
		m15();
	
	
	
	} // main()
	public static void m15() {

		// 2�� for�� -> �����

		for (int i = 0; i < 5; i++) {	// ��
			for (int j = 0; j < (5 - i); j++) { // �� 
				System.out.print("*");

			}
			System.out.println();
		}


	
	
	
	
	}

	public static void m14() {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {


				if (j > 5 || i < 3) {
					//break;
					continue;
				}


				System.out.printf("i : %d, j : %d\n", i, j);

			}

		}

	
	}

	
	public static void m13() {
		




		// ������ ���



		for (int j = 2; j < 10; j++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d x %d = %2d\n", j, i, j * i);

			}
			System.out.println();
		}


	}

	public static void m12() {
		
		// 25��
		// 6���ǽ�
		// �л����� ������� ���� üũ
		for (int i = 1; i <= 6; i++) {		// ���ǽ�
			for (int j = 1; j <= 25; j++) { // �л�
				System.out.printf("%d ���ǽ� %d�� �л� ����üũ\n"
								 , i , j);
			}
		}
		// ����Ʈ
		for (int k = 1; k <= 5; k++) {
			// 5����
			for (int j = 1; j <= 23; j++) {
				// 23��
				for (int i = 1; i <= 10; i++) {
					// 10����
					// 1�� 1ȣ -> 101ȣ
					// 1�� 12ȣ -> 112ȣ 
					System.out.printf("%d�� %d%sȣ\n", k, j, getNum(i));

				}
			}
		}
	}


	public static String getNum(int i) {
		//  1 -> "01"
		// 10 ->  10
		if (i < 10) {
			return "0" + i;
		
		
		} else {
			//return String.valueOf(i); // ���ڿ��� ��ȯ
			return i + ""; // ���ڿ��� ��ȯ
		}	
	
	}

	public static void m11() {
		
		// ��ø
		//   - for���ȿ� �� �ٸ� for���� ��� 
		
		// 2�� for�� 
		/*
		for (int i = 0; i < 12; i++) {
			// x 10ȸ
			// System.out.println("Hi~");
			for (int j = 0; j < 60; j++) {
				// x 10ȸ
				// System.out.println("�ȳ�~");
				System.out.printf("i : %d, j : %d\n", i, j);
			}

		}
		*/

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					System.out.printf("i : %d, j : %d, k : %d\n"
									  , i, j, k);

				}

			}

		}

	
	} // m11

	public static void m10() {

		// break, continue
		//   - �������� ����� ���ϰ� �ٸ� ����� �Բ� ����Ѵ�.
		//   - �ݺ����� ���� �� ����Ѵ�.
		
		// break
		//   - �ڽ��� ���� ����� Ż���Ѵ�. (�޼ҵ��� return�� ����(return�� �޼ҵ� Ż��))
		//   - if�� ����(if���� �ν����� �ʴ´�.) (if���� �� ������ ����� Ż��)

		// continue
		//   - �ϴ����� ���߰� �ٽ� �����(������)�� ���ư���
		//   - if�� ����(if���� �ν����� �ʴ´�.)

		for (int i = 1; i <= 10; i++) {
			
			
			if (i == 5) {
				//break;
				continue;  // �ϴ����� ���߰� �ٽ� �����(������)�� ���ư���
			}
			System.out.println(i); // 1 2 3 4 6 7 8 9
		}
		//�䱸����) �б� ���� ������ -> �л� ��� -> ��ȣ ������� ...
		for (int i = 1; i <= 30; i++) {

			// 15��������..
			//if (i == 16) {
			//	break;

			//}
			


			// 7�� �Ἦ
			if (i == 7 || i == 12 || i == 25) {
				continue;
			
			}
			System.out.printf("%2d�� �л� �����...\n", i);

		} // for 
	

	} // m10 

	public static void m9() {
		Random rnd = new Random();

		// ���� ���� // �ʱ���̳� �������� 2���� ���������� ���ǽ��� and �� or�� ����
		for (int i = 0, j = 0; i < 10 && j < 50; i++, j += 2 + i) {
			System.out.printf("i : %d, j : %d\n", i, j);
		}
	}


	public static void m8() {
		Random rnd = new Random();
		// ���� ����

		// for (int i = 0; i >= 0; i++) {
		// for (int i = 0; true; i++) {
		// for (;;) { // ���� fm���� ������ ���ѷ��� (�ƹ����� ��������)
		for (int i = 1;;i += 3) { // ���ǽ� ������ �ʾƵ���
			// System.out.println(rnd.nextInt(1000));  // 0 ���� 999 ����
			System.out.println(i);
		
		
		}



	}


	public static void m7() {
		
		// ���� -> ������ ��

		// �ڹ� ���� ������
		// Random Ŭ����java.util 

		Random rnd = new Random();
		int sum = 0;

		// Math Ŭ����  java.lan
		
		// * 10 (���ϱ� 10) 
		// 0.0 -> 0.0
		// 0.1 -> 1.0
		// 0.2 -> 2.0
		// 0.3 -> 3.0
		// 0.4 -> 4.0 
		// 0.99 -> 9.9  // 0 ~ 9 
		

		// 0(inclusive) ~ 1(exclusive) (0 �̻� 1 �̸�) ������ �Ǽ� ��ȯ 
		for (int i = 0; i < 10; i++) {
			// Math Ŭ���� 
			// System.out.println(Math.random());

			// 1 ~ 10
			// System.out.println((int)(Math.random() * 10) + 1);  // ���� ��ȯ 
			
			// 1 ~ 45
			// System.out.println(((int)Math.random() * 45) + 1);

			// Random Ŭ���� 
			// System.out.println(rnd.nextInt(10));	 // �ּڰ� 0 �ִ� 9
			// System.out.println(rnd.nextInt(10) + 1); // �ּڰ� 0 �ִ� 10
			// System.out.println(rnd.nextDouble());
			// System.out.println(rnd.nextBoolean());
			
			sum += rnd.nextInt(10) + 1; // 0 ���� 10������ ������ ���� 10�� ���Ͻÿ�

		} // for 
		System.out.println(sum);
	
	
	} // m7


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
