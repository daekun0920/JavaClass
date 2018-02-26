import java.io.*;
import java.util.*;

class Home05 {

	public static void main(String[] args) throws Exception {

		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();

	}

	public static void m1() throws Exception {
		/*
			����1.
			�䱸����] �̸��� Ƚ���� �Է¹޾Ƽ� Ƚ����ŭ �λ��Ͻÿ�.
			�Է�] �̸� : ȫ�浿
				  Ƚ�� : 3
			���] ȫ�浿�� �ȳ��ϼ���~
				  ȫ�浿�� �ȳ��ϼ���~
				  ȫ�浿�� �ȳ��ϼ���~
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String name = "";
		int count = 0;

		System.out.print("�̸� : ");
		name = reader.readLine();

		System.out.print("Ƚ�� : ");
		count = Integer.parseInt(reader.readLine());

		for (int i=0; i<count; i++) {
			System.out.printf("%s�� �ȳ��ϼ���~\n", name);
		}
	}

	public static void m2() throws Exception {
		/*
			����2.
			�䱸����] ���� 1���� �Է¹޾� 1���� ~ �Է� ���ڱ����� ���� ����Ͻÿ�.
			�Է�] ���� : 5
			���] 1 ~ 5 : 15
			����] õ���� ���
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 0;
		int sum = 0;

		System.out.print("���� : ");
		num = Integer.parseInt(reader.readLine());

		for (int i=1; i<=num; i++) {
			sum += i;
		}

		System.out.printf("1 ~ %d : %,d\n", num, sum);

	}

	public static void m3() throws Exception {
		/*
			����3.
			�䱸����] ���� 10���� �Է¹޾� ¦���� �հ� Ȧ���� ���� ���� ����Ͻÿ�.
			�Է�] ���� : 5
				  ���� : 7
				  ..
				  ���� : 10
			���] ¦���� �� : 52
				  Ȧ���� �� : 46
		*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int oddSum = 0;
		int evenSum = 0;

		for (int i=0; i<10; i++) {
			System.out.print("���� : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 1) {
				oddSum += num;
			} else {
				evenSum += num;
			}
		}

		System.out.printf("¦���� �� : %,d\n", evenSum);
		System.out.printf("Ȧ���� �� : %,d\n", oddSum);

	}

	public static void m4() {
		/*
			����4.
			�䱸����] �Ʒ��� ���� ����Ͻÿ�.
			���] 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
			���] 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		*/




		int sum = 0;

		for (int i=1; i<=10; i++) {
			sum += i;
			System.out.printf("%d + ", i);
		}

		System.out.printf("\b\b= %,d\n", sum);












		sum = 0;

		for (int i=1; i<=10; i++) {

			if (i % 2 == 0) {
				sum -= i;			
				System.out.printf("%d + ", i);
			} else {
				sum += i;			
				System.out.printf("%d - ", i);
			}
		}

		System.out.printf("\b\b= %,d\n", sum);
	}







	public static void m5() {
		/*
			����5.
			�䱸����] �Ʒ��� ���� ����Ͻÿ�.
			���] 1 + 2 + 3 + 4 + 5 + ... + ? = 10XX
			����] �������� 1000�� �Ѿ�� ���������� ����Ͻÿ�.
			���] ���� ���� + break
		*/

		int sum = 0;
		
		for (int i=1; ; i++) {
			sum += i;
			System.out.printf("%d + ", i);

			if (sum >= 1000) {
				break;
			}
		}

		System.out.printf("\b\b= %,d\n", sum);

	}






	public static void m6() throws Exception {
		/*
			����6.
			�䱸����] ���� 1�� 1�� 1�Ϻ��� 2017�� 12�� 6�ϱ��� �� ��ĥ�� �������� ���Ͻÿ�.
			���] �� 4,563,543�� �������ϴ�.
			����] Calendar ��� ����
			���] for�� ���, ���� ���
			����] ��� % 7 = 3
		*/
		
		int year = 2017;
		int month = 12;
		int date = 6;
		int totalDay = 0;
		

		//1.1.1 ~ 2016.12.31
		for (int i=1; i<year; i++) {
			if (isLeafYear(i)) {
				totalDay += 366;
			} else {
				totalDay += 365;
			}
		}

		//2017.1.1 ~ 2017.11.30
		for (int i=1; i<month; i++) {
			totalDay += getMaxDay(year, i);
		}

		//2017.12.1 ~ 2017.12.6
		totalDay += date;

	
		System.out.printf("�� %,d�� �������ϴ�.\n", totalDay);
		System.out.println(totalDay % 7);







		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.set(1, 0, 1, 0, 0, 0);

		long span = c2.getTime().getTime() - c1.getTime().getTime();
		System.out.println(span / 1000 / 60 / 60 / 24);

	}

	public static boolean isLeafYear(int year) {
		if (year % 4 == 0) {			
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}			
			} else {
				return true;
			}		
		} else {
			return false;		
		}
	}

	public static int getMaxDay(int year, int month) {
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (isLeafYear(year)) {
					return 29;
				} else {
					return 28;
				}
			default:
				return 0;
		}
	}

	public static void m7() {
		/*
			����7.
			�䱸����] 369 ������ ����Ͻÿ�.
			���] 1	2	¦	4	5	¦	...
			����] 100����
				  33 - ¦¦
		*/

		for (int i=1; i<=100; i++) {
			
			int d1 = i / 100;
			int d2 = i / 10 % 10;
			int d3 = i % 10;

			boolean flag = false;

			if (d1 != 0 && d1 % 3 == 0) {
				System.out.print("¦");
				flag = true;
			}

			if (d2 != 0 && d2 % 3 == 0) {
				System.out.print("¦");
				flag = true;
			}

			if (d3 != 0 && d3 % 3 == 0) {
				System.out.print("¦");
				flag = true;
			}
			
			/*
			if (flag) {
				System.out.print("\t");
			} else {
				System.out.print(i + "\t");
			}
			*/

			if (!flag) {
				System.out.print(i);
			} 
			
			System.out.print("\t");
		}

	}

}


















