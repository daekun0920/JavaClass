import java.io.*;

class Homework6 {

	public static void main(String[] args) throws Exception{
		/*
		for��

����1.

�䱸����) �̸��� Ƚ���� �Է¹޾Ƽ� ȹ����ŭ �λ�
�Է�) �̸� : ȫ�浿
      Ƚ�� : 3
���) ȫ�浿�� �ȳ��ϼ���~
      ȫ�浿�� �ȳ��ϼ���~
      ȫ�浿�� �ȳ��ϼ���~
		*/
		//greet();
		/*
����2.

�䱸����) ���� 1���� �Է¹޾� 1���� ~ �Է��� ���ڱ����� ���� ����Ͻÿ�.
�Է�) ���� : 5
���) 1 ~ 5 : 15 
�߰�) õ ���� ���
		*/
		//sum();

		/*

����3. 

�䱸����) ���� 10���� �Է¹޾� ¦���� �հ� Ȧ���� ���� ���� ����Ͻÿ� .
�Է�) ���� : 5
      ���� : 7
      ...
���) ¦���� ��: 52
      Ȧ���� ��: 46
		*/
		//evenOdd();

		/*


����4.

�䱸����) �Ʒ��� ���� ����Ͻÿ�.
���) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
���) 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		sumLine();
		*/
		//sumLine();
		/*
����5.

�䱸����) �Ʒ��� ���� ����Ͻÿ�.
���) 1 + 2 + 3 + 4 + 5 + ... + ? = 10xx
����) �������� 1000�� �Ѿ�� ���������� ����Ͻÿ�.
		
	
		*/
		thousand();
		
		/*
����6.  /*****

�䱸����) ���� 1�� 1�� 1�Ϻ��� 2017�� 12�� 6�ϱ��� �� ��ĥ�� �������� ���Ͻÿ�.
���) �� 4,564,422 �� �������ϴ�.
����) Calendar ��� ����
���) for�� ���, ���� ���
����) ��� % 7 = ? 
		dayCount(); 736,669
*/
	//dayCount();
/*

����7. /*****

�䱸����) 369 ������ ����Ͻÿ�.
���) 1 2 ¦ 4 5 ¦ ....
����) 100 ����
       33 - ¦¦ 

	int d1 = 1/ 100;
	int d2 = i / 10 % 10;
	int d3 = i % 10; 


		*/
	//threeSixNine();
	
	} // main

	public static void threeSixNine() {
		
		for	(int i = 1; i <= 100; i++) {
			
		}
					
	}


	public static void dayCount()	{
	
	int yearCount = 0;
	int i = 0;
	int leapYear = 0;

	for (i = 1;;i++) {
		if (i == 365) {
			yearCount++;
			i = 1;
			if (leapYear % 4 == 0 || leapYear % 100 != 0 || leapYear % 400 == 0) {
				leapYear++;
			}
		if (yearCount == 2017) {
			break;
		}
		}
	}
	int totalDay = (((yearCount * 365 + (2017 / 4)) - 25) - leapYear);
	System.out.printf("�� %d �� �������ϴ�.", totalDay);
	
	} // dayCount()
	
	
	
	
	public static void thousand() {
		/*

����5.

�䱸����) �Ʒ��� ���� ����Ͻÿ�.
���) 1 + 2 + 3 + 4 + 5 + ... + ? = 10xx
����) �������� 1000�� �Ѿ�� ���������� ����Ͻÿ�.
		
		*/

		int sum = 0;
		
		for (int i = 1;;i++) {
			sum += i;
			if (i != 1000) {
			System.out.printf(" %d +", i);
			} else {
			sum += i;
			System.out.printf(" %d = %d\n\n\n", i, sum);	
			break;
			
			
		
			} // if 
		
		} // for
		
	} // thousand()
	
	
	
	
	public static void sumLine() {
			/*

����4.

�䱸����) �Ʒ��� ���� ����Ͻÿ�.
���) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
���) 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		sumLine();

		*/
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
			if (i < 10) { 
			System.out.printf("%d + ", i);
			} else {
			System.out.printf("%d = %d\n", i, sum);
			}
			
		}

		int add = 0;
		for (int i = 1; i <= 10; i++) {
			
			if (i % 2 == 0 && i != 10) {
				add = add - i;
				System.out.printf("- %d +", i);
			
			} else if (i % 2 == 1) {
				add = add + i;
				System.out.printf(" %d ", i);
		
			} else {
				add = add - i;
				System.out.printf("- %d = %d\n\n\n", i, add);
			
			}
		} // for

	} // sumLine()


	public static void evenOdd () throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			/*

����3. 

�䱸����) ���� 10���� �Է¹޾� ¦���� �հ� Ȧ���� ���� ���� ����Ͻÿ� .
�Է�) ���� : 5
      ���� : 7
      ...
���) ¦���� ��: 52
      Ȧ���� ��: 46
			*/

		
		int sumEven = 0;
		int sumOdd = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("���� : ");
			int num = Integer.parseInt(reader.readLine());

			if (num % 2 == 0) {
				sumEven += num;
			} else {
				sumOdd += num;
			}

		} // for

		System.out.printf("¦���� ��: %d\nȦ���� ��: %d\n\n\n", sumEven, sumOdd);
		

	
	
	
	
	}
	
	
	
	public static void sum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				/*
����2.

�䱸����) ���� 1���� �Է¹޾� 1���� ~ �Է��� ���ڱ����� ���� ����Ͻÿ�.
�Է�) ���� : 5
���) 1 ~ 5 : 15 
�߰�) õ ���� ���
				*/
		System.out.print("���� : ");
		int num = Integer.parseInt(reader.readLine());
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.printf("1 ~ %d : %d\n\n\n", num, sum);

	
	
	} // sum();
	
	
	
	public static void greet() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			/*
		for��

����1.

�䱸����) �̸��� Ƚ���� �Է¹޾Ƽ� ȹ����ŭ �λ�
�Է�) �̸� : ȫ�浿
      Ƚ�� : 3
���) ȫ�浿�� �ȳ��ϼ���~
      ȫ�浿�� �ȳ��ϼ���~
      ȫ�浿�� �ȳ��ϼ���~
		*/
		System.out.print("�̸� : ");
		String name = reader.readLine();
		
		System.out.print("Ƚ�� : ");
		int count = Integer.parseInt(reader.readLine());

		for (int i = 0; i < count; i++) {
			System.out.printf("%s�� �ȳ��ϼ���~\n", name);
		
		}
		
	} // greet();


	
}
