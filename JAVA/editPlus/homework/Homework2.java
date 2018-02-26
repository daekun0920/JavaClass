import java.io.BufferedReader;
import java.io.InputStreamReader;


class Homework2  {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



	
		/*
����.txt

����1. 

�䱸����) ���̸� �Է¹޾�  �¾ �⵵�� ����Ͻÿ�.
�Է�) ���� : 27
���) �¾ �⵵: 1990��
����) ���� �⵵ : 2017��

*/

		System.out.print("���� : ");
		String input = reader.readLine();
		int birth_year = 2017 - Integer.parseInt(input);
		System.out.printf("�¾ �⵵ : %d\n\n\n", birth_year);













/*
����2.

�䱸����) ���� 2���� �Է¹޾Ƽ� ��������� ����� ����Ͻÿ�
�Է�) ù��° ���� : 5
      �ι�° ���� : 3
���) 5 + 3 = 8
      5 - 3 = 2
      5 * 3 = 15
      5 / 3 = 1
      5 % 3 = 2

����) �Է°��� ����
      ���� õ���� ǥ��
	  */

	  System.out.print("ù��° ���� : ");
	  String first_num_input = reader.readLine();
	  int first_num = Integer.parseInt(first_num_input);


	  System.out.print("�ι�° ���� : ");
	  String second_num_input = reader.readLine();
	  int second_num = Integer.parseInt(second_num_input);

	  System.out.printf("%d + %d = %d\n\n\n", first_num, second_num, first_num + second_num);




/*

����3.

�䱸����) �簢���� �ʺ�� ���̸� �Է¹޾� ���̿� �ѷ��� ����Ͻÿ�.
�Է�) �ʺ�(cm) : 20cm
      ����(cm) : 10cm

���) ���� : 200cm^2
      �ѷ� : 60cm

*/

System.out.print("�ʺ�(cm) : ");
String length_input = reader.readLine();
int length = Integer.parseInt(length_input);

System.out.print("����(cm) : ");
String height_input = reader.readLine();
int height = Integer.parseInt(height_input);

System.out.printf("���� : %dcm^2\n�ѷ� : %dcm\n\n\n"
				  ,length * height, (height + length) * 2);

/*

����4.

�䱸����) ������ ������(���� 26��ġ). ��޼� �Է¹޾� �� m�� ������ ��� �Ͻÿ�.
����) ��� 1���� -> ���� 1ȸ��
      �Ҽ� ���� ���X
�Է�) ��� �� : 1000
���) �� 3,000m�� �̵��߽��ϴ�.

 ��ġ * 2.54 = cm
*/

System.out.print("��� �� : ");
String pedalCount = reader.readLine();
int pedal = Integer.parseInt(pedalCount);

System.out.printf("�� %dm�� �̵��߽��ϴ�.\n\n\n", pedal * (int)((26 * 2.54) * 3.14) / 100);





/*
����5.

�䱸����) ���ҹ��ڸ� 1�� �Է¹޾� �빮�ڷ� ��ȯ���� ����Ͻÿ�.
�Է�) ����: a
���) 'a'�� �빮�ڴ� 'A'�Դϴ�.
����) ���� �ڵ尪 + �� ��ȯ + (�빮�ڿ� �ҹ��ڰ��� ����?)

*/


System.out.print("���� : ");
int small_letter_input = reader.read();
char capital_letter = (char)(small_letter_input - 32);
System.out.printf("'%s'�� �빮�ڴ� '%s'�Դϴ�.\n\n\n", (char)small_letter_input, capital_letter);




/*

����6.

�䱸����) �Ѵ� ������ �Է¹޾� ���� �ݾ��� ����Ͻÿ�.
�Է�) �ݾ�(��) : 1000000
���) ����(��) : 967,000��
����) ���� : 3.3%
      ��� �Ҽ��� ����x 

*/

/* ���� ���� �߻�

System.out.print("�ݾ�(��) : ");
String salaryInput = reader.readLine();
int salary = Integer.parseInt(salaryInput);

System.out.printf("����(��) : %d��\n\n\n", (int)salary + salary * 0.033);

*/



/*

����7.

�䱸����) ���ڸ� 2�� �Է¹޾� �� �� ū ���ڸ� ����Ͻÿ�.
�Է�) ù��° ���� : 5
      �ι�° ���� : 3
���) ū �� : 5

�Է�) ù��° ���� : 5
      �ι�° ���� : 3
      ����° ���� : 8
���) ���� ū ��  : 8
*/


/* ���� ���� �߻�

System.out.println("ù��° ���� : ");
String first_input = reader.readLine();
int first_numb = Integer.parseInt(first_input);

System.out.print("�ι�° ���� : ");
String second_input = reader.readLine();
int second_numb = Integer.parseInt(second_input);

int bigger_num = (first_numb > second_numb) ? first_numb : second_numb;

System.out.print("����° ���� : ");
String third_input = reader.readLine();
int third_numb = Integer.parseInt(third_input);

int biggest_num = (bigger_num > third_numb) ? bigger_num : third_numb;


System.out.printf("���� ū �� : %d\n", biggest_num);

*/





/*


����8.

�䱸����) 2017�� 11�� 1���� �������Դϴ�. 2017�� 11�� �� �� ��¥�� �Է¹޾� ���� �������� ����Ͻÿ�.
�Է�) ��¥ : 28
���) 28���� ȭ�����Դϴ�.


*/

/* �̿ϼ�
System.out.print("��¥ : ");
String date_input = reader.readLine();
int date = Integer.parseInt(date_input);
  
int dateRest = date % 7
*/



/*
����9. // ���� 5���� ���� ����� �����߻� 

�䱸����) �����ڸ� 1�� �Է¹޾� �빮������ �ҹ������� 
�Է�) ���� : a
���) 'a'�� �ҹ��� �Դϴ�.

�Է�) ���� : H
���) 'H'�� �빮���Դϴ�.
		*/


System.out.print("����: ");
int letterRec = reader.read();
String result = (letterRec > 64 && letterRec < 97) ? "�빮��" : "�ҹ���";
char letter = (char)letterRec;
System.out.printf("'%s'�� %s�Դϴ�.\n\n\n", letter, result);




	}

}
