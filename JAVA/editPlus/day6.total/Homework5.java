import java.io.*;
import java.util.Calendar;

class Homework5 {

	public static void main(String[] args) throws Exception{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
			
		if��(switch��)

����1. (Date nowDate = now.getTime()); < ���� 

�䱸����) ���ڸ� 2�� �Է¹޾� ū ���� ���� ���� ����Ͻÿ�.
�Է�) ù��° ���� : 5
      �ι�° ���� : 3
���) ū ���� 5�̰�, ���� ���� 3�Դϴ�.

		*/
		

		//getNum();

        

		/*

����2.

�䱸����) ������ �Է¹޾� ������ ����Ͻÿ�.
�Է�) ���� : 85
���) �Է��� ���� 85���� B�Դϴ�.
����) 90 ~ 100 : A
      80 ~ 89 : B
      70 ~ 79 : C
      60 ~ 69 : D
      0 ~ 59 : F
�߰�) ��ȿ�� �˻�(���� 0 ~ 100)
���) if, switch(���� - ���� �˻�X)

		*/

		//getGrade();
		
		
	
		

		/*

����3.

�䱸����) ���� 2���� ������ 1���� �Է¹޾� ��������� ����� ����Ͻÿ�.
�Է�) ����1: 5
      ����2: 3
      ������: *
���) 5 * 3 = 15
����) �Է�(����)
      ���(������ �Ҽ����� 1�ڸ�����)
      ������(�������)
���)if 

		*/


		calcNum();

		




		/*

����4.

�䱸����) ���� 1���� �Է¹޾� �Ʒ��� ���� ����Ͻÿ�.
�Է�) ���� : f
���) Father
����) f, F -> Father 
      m, M -> Mother
      s, S -> Sister
      b, B -> Brother
���) if, switch

        */
		
		//family();
		
		
		
		
		
		/*********

����5.

�䱸����) ������ 1���� �Է¹޾� ��/�ҹ��ڸ� ��ȯ/����Ͻÿ�.
�Է�) ���� : a
���) ��� : A

�Է�) ���� : F
���) ��� : f

		*/
		
		//engWord();
		
		
		
		/*

����6.

�䱸����) ��������� ����Ͻÿ�.
�Է�) <���� �ð�>
      �� : 13
      �� : 30
      <���� �ð�>
      �� : 14 
      �� : 20

���) ���� ����� 4,000�� �Դϴ�.
����) ���� ����: 30��
      �ʰ� 10�� : 2,000��

		*/

		 park();


		


		/*

����7.

�䱸����) �⵵�� �Է¹޾� "���" ���� "����"���� ����Ͻÿ�.
�Է�) �Է� : 2017
���) 2017���� '���' �Դϴ�.
����) A. �⵵�� 4�� ������ �������� B. �˻�
						   �������� ������ "���"

	  B. �⵵�� 100���� ������ �������� C �˻�
	  						   �������� ������ "����"
		
	  C. �⵵�� 400���� ������ �������� "����"
	  ������������ "���"

Calendar ��� ����
		
		*/

			//leapYear();


	} // main() 



		public static void getNum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("ù��° ���� : ");
			int firstNum = Integer.parseInt(reader.readLine());

			System.out.print("�ι�° ���� : ");
			int secondNum = Integer.parseInt(reader.readLine());

			if (firstNum > secondNum) {
			System.out.printf("ū ���� %d�̰�, ���� ���� %d�Դϴ�.", firstNum, secondNum);
		
			} else {
			System.out.printf("ū ���� %d�̰�, ���� ���� %d�Դϴ�.", secondNum, firstNum);
		
		
			}	 
		
		} // getNum

		public static void getGrade() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("\n\n\n�Է� : ");
			int score = Integer.parseInt(reader.readLine());
			String grade = "";
		
			
			if (score >= 0 && score <= 100) { 	
				if (score >= 90) {
					grade = "A";
				} else if (score >= 80) {
					grade = "B";
				} else if (score >= 70) {
					grade = "C";
				} else if (score >= 60) {
					grade = "D";
				} else {
					grade = "F";
				}
		
			}
		System.out.printf("�Է��� ���� %d�� %s�Դϴ�.\n\n\n", score, grade);
		
		
		
		} // getGrade

		public static void calcNum() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("����1 : ");
			int num1 = Integer.parseInt(reader.readLine());

			System.out.print("����2 : ");
			int num2 = Integer.parseInt(reader.readLine());

			System.out.print("������ : ");
			String oper = reader.readLine();
		
			int answer = 0;

			if (oper.equals("+")) {
				answer = num1 + num2;
			} else if (oper.equals("-")) {
				answer = num1 - num2;
			} else if (oper.equals("*")) {
				answer = num1 * num2;     
			} else if (oper.equals("/")) {
				float answerFloat = (float)num1 / num2; // �� �κ� !!!  ��� float ���� ��� ?
				System.out.printf("%d %s %d = %.1f\n\n\n",num1, oper, num2, answerFloat);
			} else {
				answer = num1 % num2;	
			}
		
			System.out.printf("%d %s %d = %d\n\n\n",num1, oper, num2, answer);
		
		
		
		} // calcNum

		public static void family() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("���� : ");
			String letter = reader.readLine();
			String family = "";

			if (letter.equals("f") || letter.equals("F")) {
				family = "Father";
			} else if (letter.equals("m") || letter.equals("M")) {
				family = "Mother";
			} else if (letter.equals("s") || letter.equals("S")) {
				family = "Sister";
			} else if (letter.equals("b") || letter.equals("B")) {
				family = "Brother";
			}
		
			System.out.println(family);
		
		
		} // family

		public static void engWord() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("\n\n\n���� : ");
			char word = (char)(reader.read());
			char wordAnswer;
	
			if (word >= 'a' && word <= 'z') {
				wordAnswer = (char)(word - 32);
			} else {
				wordAnswer = (char)(word + 32);
			}	
			System.out.printf("��� : %s", wordAnswer);
			
		
		
		} // engWord 

		public static void park() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
			/*

����6.

�䱸����) ��������� ����Ͻÿ�.
�Է�) <���� �ð�>
      �� : 13
      �� : 30
      <���� �ð�>
      �� : 14 
      �� : 20

���) ���� ����� 4,000�� �Դϴ�.
����) ���� ����: 30��
      �ʰ� 10�� : 2,000��

		*/
			
			System.out.println("<���� �ð�>");
			System.out.print("�� : ");
			int hour = Integer.parseInt(reader.readLine());
			System.out.print("�� : ");
			int minute = Integer.parseInt(reader.readLine());

			System.out.println("<���� �ð�>");
			System.out.print("�� : ");
			int hourOut = Integer.parseInt(reader.readLine());
			System.out.print("�� : ");
			int minuteOut = Integer.parseInt(reader.readLine());

			int parkFair = (((((hourOut * 60 + minuteOut) - (hour * 60 + minute)) - 30) / 10) * 2000);
			
			System.out.printf("���� ����� %d�� �Դϴ�.", parkFair);

		
		}
		

		public static void leapYear() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				/******

����7.

�䱸����) �⵵�� �Է¹޾� "���" ���� "����"���� ����Ͻÿ�.
�Է�) �Է� : 2017
���) 2017���� '���' �Դϴ�.
����) A. �⵵�� 4�� ������ �������� B. �˻�
						   �������� ������ "���"

	  B. �⵵�� 100���� ������ �������� C �˻�
	  						   �������� ������ "����"
		
	  C. �⵵�� 400���� ������ �������� "����"
	  ������������ "���"

Calendar ��� ����
		
		*/

			/*

			System.out.print("\n\n\n�Է� : ");
			int year = Integer.parseInt(reader.readLine());
			String yearAnswer = "";

		
		
			if (year % 4 != 0) {
				yearAnswer = System.out.println("���");

			} else if (year % 100 != 0) { 
				yearAnswer = System.out.println("����");

			} else if (year % 400 == 0) {
				yearAnswer = System.out.println("����");

			} else {
				yearAnswer = System.out.println("���");

			}
			System.out.printf("%d���� '%s' �Դϴ�.", year, yearAnswer);
		
		*/
		}
} // class
