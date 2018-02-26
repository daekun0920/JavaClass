import java.io.BufferedReader;
import java.io.InputStreamReader;

class Homework3 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 
		�޼ҵ� ����

����1. 

�䱸����) �̸��� �ǳ��ָ� �̸��ڿ� "��"�� �ٿ��� ��ȯ�ϴ� �޼ҵ� ����
�Է�) �̸� : ȫ�浿
���) �� : ȫ�浿��
����) String getName(String name)
		*/
		System.out.print("�̸� : ");
		String name = reader.readLine();
		System.out.println(getName(name));
		
	
		
		
		
		/*

����2.

�䱸����) ���ڸ� �ǳ��ָ� '¦��'���� 'Ȧ��'���� ��ȯ�ϴ� �޼ҵ� ����
�Է�) ���� : 5
���) �Է��Ͻ� ���� 5��(��) 'Ȧ��'�Դϴ�.
����) String getNumber(int num)

*/
		System.out.print("���� : ");
		String numInput = reader.readLine();
		int num = Integer.parseInt(numInput);
		String answer = getNumber(num);
		System.out.printf("�Է��Ͻ� ���� %d�� %s�Դϴ�.\n\n\n", num, answer);
	

		
		

/*

����3.

�䱸����) ��/��/�� ������ �ǳ��ָ� �հ�/���հ��� ��ȯ�ϴ� �޼ҵ�
�Է�) ���� : 80
      ���� : 75
      ���� : 60

���) (��)�հ��Դϴ�.
����) ��� 60�� �̻� �հ�, �̸� ���հ�
�߰�����) ���� 40�� �̸� ���հ�
����) String test(int kor, int eng, int math) // ���� ���������� ���� ���� ���� �ش��ϴ��� ( ������ ����, ���� �������� �������� ������ �н�)

*/
		System.out.print("���� : ");
		String strKor = reader.readLine();
		int kor = Integer.parseInt(strKor);
		System.out.print("���� : ");
		String strEng = reader.readLine();
		int eng = Integer.parseInt(strEng);
		System.out.print("���� : ");
		String strMath = reader.readLine();
		int math = Integer.parseInt(strMath);
		
		String finalAnswer = test(kor, eng, math);
		System.out.printf("%s�Դϴ�.\n\n\n", finalAnswer);


/*

����4.

�䱸����) ����ö ���� ����, ȯ�� Ƚ�� �Է¹޾� �� �ҿ�ð��� ��ȯ�ϴ� �޼ҵ�
�Է�) ���� ���� : 15
      ȯ�� Ƚ�� : 1

���) �� �ҿ� �ð��� 33�� �Դϴ�.
����) �� ���� �ҿ�ð� : 2�� 
      ȯ�� �ð� : 3��
����) int getTime(int, int) �� ����, ȯ�� Ƚ��

�߰�) ���� ���� : 15
      ȯ�� Ƚ�� : 1
      ���� : ���

�߰�) ȯ�� �ҿ�ð� 
      - ��� : 3�� 
      - ��� : 4��
      - ��� : 5��

����) int getTime(int, int, String)
*/
		System.out.print("���� ���� : ");
		String stationsNum = reader.readLine();
		int stations = Integer.parseInt(stationsNum);
		System.out.print("ȯ�� Ƚ�� : ");
		String transferNum = reader.readLine();
		int transfer = Integer.parseInt(transferNum);
		System.out.print("���� : ");
		String timeStatus = reader.readLine();

		
		int totalTime = getTime(stations, transfer, timeStatus);
		System.out.printf("�� �ҿ� �ð��� %d�� �Դϴ�.\n\n\n", totalTime);



/*


����5.

�䱸����) �������. ��ĥ ������ �� ����� ��� ��������?
�Է�) ���� �� : 20
      �帰 �� : 5
 
���) ����� �� x �� ���Ƚ��ϴ�.

����) ������� ó�� �ɾ����� : ���� 0m
      ���� �� ����� : 5cm 
      �帰 �� ����� : 2cm
      ��������� 1m �Ѵ� �������� ����� ������.
      1m �Ѵ� ������ 10cm �ڶ������� ����� 1���� ������. // 110cm ����

����) int getApple(int, int)
	

	*/
		

	System.out.print("���� �� : ");
	String goodWeather = reader.readLine();
	int niceDay = Integer.parseInt(goodWeather);

	System.out.print("�帰 �� : ");
	String badWeather = reader.readLine();
	int badDay = Integer.parseInt(badWeather);

	int appleNum = getApple(niceDay, badDay);
	
	System.out.printf("����� �� %d�� ���Ƚ��ϴ�.\n\n\n", appleNum);
	







	} // main

	public static int getApple(int niceDay, int badDay) throws Exception {
		int heightTree = 0;
		heightTree = (heightTree + ((niceDay * 5) + (badDay * 2)));
		heightTree = heightTree - 100;
		int appleNum = heightTree / 10;
		return appleNum;

   // ctrl + d = ��¥

	} // getApple

	public static String getName(String name) throws Exception {
	

	return ("�� : " + name + "��\n\n\n");


	} // getName
	
	public static String getNumber(int num) throws Exception {
	
	String answer = num % 2 == 1 ? "Ȧ��" : "¦��";

	return answer;

	} // getNumber
	
	public static String test (int kor, int math, int eng) throws Exception {
	
	 String answer = (kor + math + eng) / 3 < 60  ? "���հ�" : "�հ�";
	 int smallerNum = kor < math ? kor : math;
	 int smallestNum = smallerNum < eng ? smallerNum : eng;
	 String answer1 = smallestNum < 40 ?  "���հ�" : "�հ�";
	 String finalAnswer = answer == "�հ�" && answer1 == "�հ�" ? "�հ�" : "���հ�";

	 return finalAnswer;



	
	} // test

 
	public static int getTime (int stations, int transfer1, String timeStatus) throws Exception {
	int zero = 0; // ȯ�� �κ� ��� 0���� ����

	//***��� ������(���ڿ�)�� �񱳴� �� ������(==, !=)�� ����ϸ� �ȵȴ� (��� ���� �Ұ�). -> equals() �޼ҵ� ���
	int time1 = timeStatus.equals("���") ? transfer1 * 3 : zero;
	int time2 = timeStatus.equals("���") ? transfer1 * 4 : zero;
	int time3 = timeStatus.equals("���") ? transfer1 * 5 : zero;
	System.out.println(transfer1);
	System.out.println(timeStatus);
	int biggerNum = time1 > time2 ? time1 : time2;
	int biggestNum = biggerNum > time3 ? biggerNum : time3;
	System.out.println(time1);
	System.out.println(time2);
	System.out.println(time3);

	return (stations * 3) + biggestNum;

	
	
	
	
	} // getTime

	



} // class