import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Homework4 {

	public static void main(String[] args)throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		/*
��¥/�ð� ����
   - ��� ��� x
   - ���� ������ o


����1. 

�䱸����) �¾ �⵵�� �Է¹޾� ���̸� ����Ͻÿ�.
�Է�) �⵵ : 1995
���) ���� : 23��
����) ���� �⵵�� ����, �츮���� ����
		*/

	getAge();
	



/*
����2.

�䱸����) ���ڿ� ������ �̸� �Է� + ������ �Է� -> ����� ��� 
�Է�) ���� : ȫ�浿
      ���� : ȣȣȣ
        �� : 2017
	�� :   12
	�� :    4
���) 
=====================================
   'ȫ�浿'��(��) 'ȣȣȣ'�� �����  
=====================================
100��  : 2018�� 3�� 28��
200��  : 2018�� 7�� 10��
300��  : 2018�� 11��  25��
500��  :
1000�� :
*/
	anniversary();





/*
����3.

�䱸����) ����� ���ÿ� �ޱ⸦ ���ϴ� ��. ������ ������ ���� �ֹ�?
����) ¥��� 10�� �� ���� 
        ġŲ 18�� �� ����
	���� 25�� �� ���� 

�Է�) ���ϴ� ���� �ð�
      �� : 17
      �� : 30
���) ¥��� : 17�� 20��
        ġŲ : 17�� 12��
	���� : 17��  5��

		*/
	delivery();

	

	} // main()

	public static void delivery() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("���ϴ� ���� �ð�");
	System.out.print("�� : ");
	String hourInput = reader.readLine();
	int hour = Integer.parseInt(hourInput); 

	System.out.print("�� : ");
	String minInput = reader.readLine();
	int min = Integer.parseInt(minInput);

	// �� : 17 �� : 30 

	Calendar rightTime = Calendar.getInstance();
	rightTime.set(Calendar.HOUR_OF_DAY, hour);
	rightTime.set(Calendar.MINUTE, min);
	
	
	rightTime.add(Calendar.MINUTE, -10);
	System.out.printf("¥��� : %d�� %d��\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	rightTime.add(Calendar.MINUTE, -8);
	System.out.printf("  ġŲ : %d�� %d��\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	rightTime.add(Calendar.MINUTE, -7);
	System.out.printf("  ���� : %d�� %d��\n", rightTime.get(Calendar.HOUR_OF_DAY), rightTime.get(Calendar.MINUTE));
	
	
	
	
	
	
	
	
	} // delivery();






	public static void anniversary() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	System.out.print("���� : ");
	String nameMale = reader.readLine();

	System.out.print("���� : ");
	String nameFemale = reader.readLine();
	
	System.out.print("�� : ");
	String yearInput = reader.readLine();
	int year = Integer.parseInt(yearInput);
	
    System.out.print("�� : ");
	String monthInput = reader.readLine();
	int month = Integer.parseInt(monthInput);

	System.out.print("�� : ");
	String dayInput = reader.readLine();
	int day = Integer.parseInt(dayInput);
	

	System.out.printf("\n=====================================\n   '%s'��(��) '%s'�� �����  \n=====================================\n", nameMale, nameFemale);
    Calendar today = Calendar.getInstance();
	
	today.set(Calendar.YEAR, year);
	today.set(Calendar.MONTH, month + 1);
	today.set(Calendar.DATE, day);

	today.add(Calendar.DATE, 100);
    System.out.printf("100�� : %d�� %d�� %d��\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 100);
	System.out.printf("200�� : %d�� %d�� %d��\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 100);
    System.out.printf("300�� : %d�� %d�� %d��\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
    today.add(Calendar.DATE, 200);
    System.out.printf("500�� : %d�� %d�� %d��\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	today.add(Calendar.DATE, 500);
    System.out.printf("1000�� : %d�� %d�� %d��\n\n\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	
	
	
	
	
	
	} // anniversary();


	public static void getAge() throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	Calendar now = Calendar.getInstance();
	Calendar birthday = Calendar.getInstance();
	
	
	System.out.print("�⵵ : ");
	String birthYearInp = reader.readLine();
	int birthYear = Integer.parseInt(birthYearInp);

	
	birthday.set(Calendar.YEAR, birthYear);

	System.out.printf("���� : %d\n\n\n", (now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR)) + 1);
	
	
	
	
	
	} // getAge()


 } // class
