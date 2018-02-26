import java.util.Calendar;
import java.util.Date;


class Ex21_DateTime {

	public static void main(String[] args) {
		
		// Ex21_DateTime.java

		// ��¥�ð���
		//   - ������
		//   - Date Ŭ����
		//   - Calendar Ŭ����(***)
		
		// 8���� �⺻�� + String + ��¥�ð���

		// �ð� = 2017-12-04 12:30:30  // ��ġ�� ǥ���ϴ� ����
		// �ð� = 1�ð�, 2�ð�         // ���� ǥ���ϴ� ����

		// �ð� + �ð� =       �Ұ���  // �� ���� ������ �ٸ�
		// �ð� - �ð� = �ð�  ����    // 2017-12-04 - 1995-09-20
		// �ð� + �ð� = �ð�  ���� 
		// �ð� + �ð� = �ð�  ����    // 2017-12-04 12:30:30 + 2:30 = 2017-12-04 15:00:30
		// �ð� - �ð� = �ð�  ���� 
		// 1970.1.1 (������) 2018.6.20 21:30:40 (A) ----- 2017.11.5 9:40:15(B)
		// �����Ͽ��� �� �������� �� ������ ����ؼ� ���� (���������� A������ �Ÿ�) - (���������� B������ �Ÿ�) �� A�� B ���� �Ÿ��� ���Ѵ�
		
	// m1();
	// m2();
	// m3();
	// m4();
	// m5();
	// m6();
	m7();


	} // main

	public static void m7() {
	
		// 1. ���� �ð� ��� : Calendar.getInstance();
		// 2. Ư�� �ð� ��� : Calendar.getInstance(); -> set() ���
		// 3. Ư�� �ð� ��� : int ���� 
		// 4. �ð� - �ð� : tick�� ��� 
		// 5. �ð� + �ð� : int ����
		// 6. �ð� - �ð� : int ����
		// 7. �ð� + �ð� : add() ���
		// 8. �ð� - �ð� : add() ���
		

	    // 2�ð� 30�� �ʿ� (X) 2017�� ~�� ~�� 2�� 30�� (O)
		//Calendar c = Calendar.getInstance();
		//c.set(Calendar.HOUR, 2);
		//c.set(Calendar.MINUTE, 30);	
		
		// Ư�� �ð� ��� 
		int hour = 2;
		int min = 30;




	
	
	
	}





	public static void m6() {

		// �ð� - �ð� = �ð� (�� �ð����� ��)
		//  : Ư�� ������ �������� �ؼ� ���� �ð��� ���� -> ������ ���� ��Ų �� ���� 

		// �¾�� �� �ð�?
		//  : ���� - ���� 

		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1995, 2, 25, 13, 30, 0);

		// System.out.println(now - birthday);
		
		// tick ���ϱ� // 1970�� 1�� 1�Ϻ��� �� �и��ʰ� �귶������ ��
		// 1. ���� �ð��� tick 
		System.out.println(System.currentTimeMillis()); // ���� ���� ����

		// 2.
		Date nowDate = now.getTime(); // getTime? 
		long nowTick = nowDate.getTime();
		System.out.println(nowTick);
	
		Date birthdayDate = birthday.getTime(); // �ð��� �Ϸ� �ٲ���
		long birthdayTick = birthdayDate.getTime();
		System.out.println(birthdayTick);

		long span = nowTick - birthdayTick;

		System.out.println(span / 1000 / 60 / 60 / 24 ); // �� ����Ʈ�� ����
					      // �и��� > �� > �� > �ð� > ��




		// ���� ũ�������� ��ĥ ����?
		//  : ũ�������� - ����
		Calendar christmas = Calendar.getInstance();
		christmas.set(2017, 11, 25, 0, 0, 0);
		

	 // �޼ҵ� ü�̴�
		long christmasTick = christmas.getTime().getTime();
		
		span = christmasTick - nowTick; // ms 

		System.out.println(span / 1000.0 / 60 / 60 / 24 );

		
	
	
	}
	






	public static void m5() {
	
		// ���� 
		// void add(int, int)
		// ������ �����Ѵ�.

		// 100��°?
		// = ����(�ð�) + 100��(�ð�)

		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 100);   // today�� Calendar.DATE�� ���� 100�� �߰� 
	 // today.add(Calendar.YEAR, 100);   // 100�� �߰�

		System.out.printf("100��° : %tF\n", today);
		
		today = Calendar.getInstance();  // �ʱ�ȭ
		
		today.add(Calendar.HOUR, 5);     // 5�ð� �߰�
		today.add(Calendar.MINUTE, 35);  //  35�� �߰�

		System.out.printf("%tF %tT\n", today, today);


		// 100�� ��� Ŀ�� -> ������?

		today = Calendar.getInstance();

		today.add(Calendar.DATE, -100);

		System.out.printf("100���� : %tF\n", today);
	
	
	
	
	
	
	}

















	public static void m4() {
	

		// printf() �޼ҵ�
		//  - ��¥/�ð� ����
		Calendar c = Calendar.getInstance();

		System.out.printf("%tF\n", c);  // %tF ���Ĺ��� ���               // 2017-12-04
		System.out.printf("%tT\n", c);  // %tT ���Ĺ��� ���               // 14:48:40
		System.out.printf("%tR\n", c);  // %tR                             // 14:49
		System.out.printf("%tr\n", c);  // %tr                             // 02:50:12 ����
		System.out.printf("%tA\n", c);	// %tA							   // ������

		
		// System.out.printf("%d-%d-%d\n", birth.get(Calendar.YEAR)        // 2017-12-04
		//							     , birth.get(Calendar.MONTH) + 1
		//							     , birth.get(Calendar.DATE));




	
	
	
	} // m4








	public static void m3() {
	
		// m1(), m2() -> ���� �ð�
		// m3() -> Ư�� �ð�

		// �� ���� : 1995�� 3�� 25�� 15�� 30�� 0��
		Calendar birth = Calendar.getInstance();

		// �� ���Ϸ� ��ġ��(�� ����)
		// void set(int, int)
		// void set(int, int, int)				  // set �޼ҵ尡 �����ε��� �����Ѵ�
		// void set(int, int, int, int, int, int) // �� �� �� �� �� �� 

		// birth.set(Calendar.YEAR, 1995);
		// birth.set(Calendar.MONTH, 2);
		// birth.set(Calendar.DATE, 25);
		
		
		// birth.set(1995, 2, 25); // �� �� �ٲ���Ҷ� // �� �� �ʸ� �ٲٷ��� �����ε����� �Ϻκ� ���� �ؾߵ� 
		
		// 2017-12-1
		// birth.set(2017, 11, 1);
		// birth.set(Calendar.DATE, 1); // �Ϻθ�
		
		birth.set(1995, 2, 25, 13, 30, 0); // �����ε� �Ѳ����� 

		System.out.printf("%d-%d-%d\n", birth.get(Calendar.YEAR)
									  , birth.get(Calendar.MONTH) + 1
									  , birth.get(Calendar.DATE));
	
	

	
	
	
	} // m3








	public static void m2() {
		
		Calendar c = Calendar.getInstance();
		
		// int get(int)
		// System.out.println((c.get(1)));  //c�� 1���� �ش��ϴ°��� �����´� 2017
		// System.out.println((c.get(2)));
		// System.out.println((c.get(3)));
		// System.out.println((c.get(4)));
		// System.out.println((c.get(5))); 
		// �� ��쿣 �� ���ڰ� �ǹ��ϴ¹ٸ� ����ϱ� ������� ������ �־��ִ°��� �� ����

		int year = 1;
		int month = 2;

		
		System.out.println(c.get(year));
		System.out.println(c.get(month));
		
		// Ķ���� ���
		System.out.println(Calendar.YEAR);  // ������ // 1 
		System.out.println(Calendar.MONTH); // 2
	
	
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		
		
		
		System.out.println(c.get(Calendar.YEAR));			// ��
		System.out.println(c.get(Calendar.MONTH));			// ��(0 ~ 11)
		System.out.println(c.get(Calendar.DATE));			// �� 
		System.out.println(c.get(Calendar.HOUR));			// ��(12�ð� ü��)
		System.out.println(c.get(Calendar.HOUR_OF_DAY));    // ��(24�ð� ü��)
		System.out.println(c.get(Calendar.MINUTE));			// ��
		System.out.println(c.get(Calendar.SECOND));			// ��
		System.out.println(c.get(Calendar.MILLISECOND));	// �и���(1000���� 1��)
		System.out.println(c.get(Calendar.DAY_OF_WEEK));    // ����(�Ͽ��� 1 ~ 7)
		System.out.println(c.get(Calendar.AM_PM));			// ����(0) ����(1)
		

		// ���� ��¥�� 2017�� 12�� 4���Դϴ�. - ��� 
		System.out.printf("���� ��¥�� %d�� %d�� %d���Դϴ�.\n",
						  c.get(Calendar.YEAR),
						  c.get(Calendar.MONTH) + 1,
						  c.get(Calendar.DATE));


	
	
	} // m2
	
	
	
	
	
	
	public static void m1()  {
		
		//���� �ý����� �ð��� ������
		int a;
		a = 10;

		String b; 
		b = "���ڿ�";

		Calendar c; // ���� ���� �Ѱ���.
		c = Calendar.getInstance();

		System.out.println(c);
	
	
	
	} // m1

	

} // class 
