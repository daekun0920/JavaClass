import java.util.Calendar;

class Ex23_if {

	public static void main(String[] args) {
		
		// Ex23_if.java

		// m1();
		// m2();
		// System.out.println(m3());
		// m4();
		// m5();
		m6();
	} // main
	public static void m6() {

		// �䱸����) ���� 1�� �Է� -> ���ҹ���?

		String input = "e";

		char c = input.charAt(0);   // "e" -> 'e' ĳ���� ȭ 

		int code = (int)c; // 101
		
	 // if (code >= 97 && code <=)
	 // if (code >= (int)'a' && (int)'z' <=)
		if (c >= 'a' && c <= 'z') {
			System.out.println("�ҹ���O");
		
		} else {
			System.out.println("�ҹ���X");
		
		}
		

		c = 'A';
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
								   || (c >= '0' && c <= '9')) {
			System.out.println("������O + ����O");
		
		} else {
			System.out.println("������X + ���� X");
		
		}


	
	
	
	
	} // m6





	public static void m5() {
		
		// ��ø�� if��, Nested if Statements
		/*

			if () {
				if () {
					if () {
					
					}	
				}	
			} else if () {
				if () {
					
				}	
			} else {
				if () {
					
				}	
			}
		*/

		// ���� ���� �Է� -> �հ�, ���հ�?
		// ���� : 60�� �̻�
		
		int kor = 90;
		
		if (kor >= 60) {
			System.out.println("�հ�");
		} else {
			System.out.println("���հ�");
		}
		

		kor = 85;
		// ��ȿ�� �˻�
		if (kor >= 0 && kor <= 100) {      
			
			// ����Ͻ� �ڵ�, ���� �ڵ�
			if (kor >= 60) {                    
				System.out.println("�հ�");
			} else {
				System.out.println("���հ�");
			}

		} else {
			
		    // ���� ó�� �ڵ�
			System.out.println("���� �ٽ� �Է�");  // true�� = ����Ͻ� �ڵ�, false�� = ���� ó�� �ڵ�
		}

		
	} // m5

	public static void m4() {
		
		System.out.println("�ϳ�");
		
		Calendar c = Calendar.getInstance();

		if (c.get(Calendar.SECOND) % 2 == 0) {
			return;   // �� return�� -> �޼ҵ带 ���� ��Ű�� ����(�� ��)

		}

		System.out.println("��");

		System.out.println("��");


	} // m4



	public static String m3() {

		// return��
		
		int num = 10;

		if (num > 0) {    // �����Ϸ��� true���� false���� �� (�����Ҷ��� �˼�����) true�϶��� ������ ������ false�� ��쿡�� ������ ���� �����Ϸ��� true���� false���� ���� ���Ѵ�. �׷��� �����Ϸ� ������ ��						(false�� ����� ���ϰ��� �־����*******)
			return "���";
		}
			return "����";
			
	
	
	
	} // m3
		




	public static void m2() {
		
		if (true) {   // ��� X
			System.out.println("��");
		} else {
			System.out.println("����");
		}
		
		
		boolean flag = true;
		
		if (flag) {   // ��� O 
			System.out.println("��");
		} else {
			System.out.println("����");
		}
		
		// C -> Java // C��� : Boolean�� ����. -> true(1), false(0)
		// C��� : Boolean�� ����.
		// - ���� : 0(false), ������(true)
		// - �Ǽ� : 0.0(false), ������(true)
		// - ���� : '\0' (false), ������(true)
		// - ���ڿ� : "" (false), ������(true)
		if (true) {     
			System.out.println("��");
		} else {
			System.out.println("����");
		}
			
	} // m2

	public static void m1() {

		// �䱸����) ���� 1�� �Է¹޾� ¦��? Ȧ��?
		int num = 5;
		String result = ""; // ��� ������ �������̴��� �ʱ�ȭ�� �����ִ°��� ����. // String result; ó�� �ʱⰪ�� ������(else�� else if�� ��쿡��) else if �� ���� ���� ���Ұ��� ����Ͽ� result�� ���� �������� �����Ƿ� �����Ϸ� ������ ����� 

		if (num % 2 == 0) {
		    // ¦��
			// System.out.printf("�Է��� ���� %d�� ¦���Դϴ�.\n", num);
			result = "¦��";
		} else {
			// Ȧ��
			// System.out.printf("�Է��� ���� %d�� Ȧ���Դϴ�.\n", num);
			result = "Ȧ��";
		}
	System.out.printf("�Է��� ���� %d�� %s�Դϴ�.\n", num, result);     // ���� ȿ������ �ڵ���. �ٲܶ� ������ �ٲ� �ʿ���� 
	
	} // m1



}