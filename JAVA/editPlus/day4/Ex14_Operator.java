class Ex14_Operator {

	public static void main(String[] args) {
		
		//Ex14_Operator.java

		//������, Operator
		//   - �ǿ�����(Operand)�� ������� �̸� ������ ������ �� �Ŀ� ������� ��ȯ�ϴ� ����
		
		// 1. ��� ������
		//   - +, -, *, /, %(������ ������, mod)
		//   - ���� ������(2��) // 1 + 2 = �ǿ����� ������ 2����
		
		int a = 10;
		int b = 3;

		System.out.println(a + b); // 13
		System.out.println(a - b); // 7
		System.out.println(a * b); // 30
		System.out.println(a / b); // 3   ���� ������ ������ ������.
		System.out.println(a % b); // 1

		// 1. �ش� ��.���� ��������
		// 2. �ش� ��.���� 1�� -> ���� ���� -> ���� ��


		// ������ �۾�

		// ���� / ���� = ����
		// �Ǽ� / �Ǽ� = �Ǽ�
		// ���� / �Ǽ� or �Ǽ� / ���� = �Ǽ�
		// -> ��� ��� ������ �� �ǿ����� �� �� ū �ڷ������� ���� ����� ��ȯ�ȴ�.(*****)
		System.out.println(10 / 3);		// 3
		System.out.println(10.0 / 3.0);	// 3.33333...
		System.out.println((int)(10 * 5.0));   // 3.33333...
		System.out.println(10.0 / 3);   // 3.33333...
		
		byte b1 = 10;
		int n1 = 20;
		System.out.println(b1 + n1); // 4 ����Ʈ�� ���

		int n2 = 2000000000;
		int n3 = 1000000000;
		System.out.println(n2 + (long)n3); // �� ū �ڷ����� Long���� 30�� ��µ�

		// ������ ���ͷ� = int�� <- os ������ (32��Ʈ �ü���� ���߾)
		
		byte b2 = 10, b3 = 20, b4;

		b4 = (byte)(b2 + b3); // 30 // byte �ΰ��� ���� int�� �����⶧����, (byte) ���̴� �� �ս� ���� �߻�
		System.out.println(b4);

		// 2. �� ������
		//	- �ǿ����ڵ��� �� ������ ��ȯ�ϴ� ����
		//	- ���� ������
		//  - >, >=, <, <=, ==(equal), !=(not equal)
		//	- A > B : ������, �Ǽ��� ���
		//  - �׻� ������ ����� boolean�� ��ȯ�Ѵ�. (true, false)

		int result = 0;

		result = 1 + 2 * 3 + 4;
		System.out.println(result); // ���� �켱���� �߿� // ��� ������ �� ���꺸�� �켱 // ���� �����ڴ� ���� �ļ���


		a = 10;
		b = 3;

		/*
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a =< b);
		System.out.println(a == b);
		System.out.println(a != b);
		*/

		// �Ǽ��� �������� ��
		System.out.println(3.5 > 3);

		// ���� ��X
		// System.out.println(true > false);
		System.out.println(true == true);

		// ������ ��
		System.out.println('A' > 'B');

		// ����� ���� �Է� -> 'c' -> ���� �ҹ���?
		char input = 'D';

		System.out.println(input >= 'a');
		System.out.println(input <= 'z');

		// ���ڿ�(������) ��
		String s1 = "ȫ�浿";
		String s2 = "ȫ�浿";
		String s3 = "ȫ";
		s3 = s3 + "�浿";

		System.out.println(s1 == s2);
		System.out.println(s1 == s3); // false

		//***��� ������(���ڿ�)�� �񱳴� �� ������(==, !=)�� ����ϸ� �ȵȴ� (��� ���� �Ұ�). -> equals() �޼ҵ� ���
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println();


		int m1 = 10;
		int m2 = 10;
		int m3 = 5;
		m3 = m3 + 5;

		System.out.println(m1 == m2);
		System.out.println(m1 == m3);

		System.out.println(2 * 3 > 4 / 2);
		System.out.println((2 * 3) > (4 / 2));

		// 3. �� ������
		// - �̹� ������ ���� ��Ģ�� ���� ����� ��ȯ
		// - ���� ������(&&, ||)
		// - ���� ������(!)
		// - &&(and), ||(or), !(not)
		// - �ǿ����ڸ� boolean�� ���´�.
		// - ������ ����� boolean�� ��ȯ�Ѵ�.
		System.out.println("\n\n\n\n\n");

		boolean f1 = true;
		boolean f2 = false;
		
		System.out.println(f1 && f2);
		System.out.println(f1 || f2);

		// ���� �Է� -> ���, ����
		// ���� : 20�� �̻� ~ 60�� �̸�
		int age = 25;

		// ���ʺ��� ������� 20 <= age ->(20 <= age �������) true < 60 -> ����
		//System.out.println(20 <= age < 60); 

		System.out.println((20 <= age) && (age < 60)); 
		System.out.println((age >= 20) && (age < 60)); // ���� �� ����
		
		// && -> ||
		System.out.println(!((age < 20) || (age >= 60)));

		//age >= 20 // O  // ����� ������ ���� ����
		//20 <= age // X  

		// short circuit // �ڹٿ��� and,or ������ ��쿡�� �� ���̽��� f�� t�� �����(f, t)�� ���������ϱ⶧���� ������ ������ �����ʰ� �ٷ� ������� ����
		age = 10;
		System.out.println((age >= 20) && (age < 60));
		System.out.println(!((age < 20) && (age >= 60)));

		// 4. ���� ������
		//   - �Ҵ� ������
		//   - ���� ������
		//   - LValue(����) = RValue(���, ����)
		//   - LValue�� RValue�� �ݵ�� �ڷ��� ����(����ȯ ����)
		//   - = 
		//   - +=, -=, *=, /=, %=  // ���� ���� ������
		//   - ������ �켱 ������ ���� ����.

		int num = 10;
		
		// ����
		num = num + 1;
		num += 1;
		System.out.println(num);  // 12

		num = num - 1;
		num -= 1;
		System.out.println(num);  // 10

		num *= 3; // num = num * 3
		System.out.println(num);  // 30

		num /= 4; // num = num / 4;
		System.out.println(num);  // 7

		num %= 3; // num = num % 3;
		System.out.println(num);  // 1
		
		
		// ���� �Ǽ�
		// num = 100 - num; -> num -= 100; (X)
		
		// ���� �켱 ����
		//   - �� ���峻���� �����ڵ��� 2�� �̻� ������ �� ������ ����
		//   - () > ��� > �� > �� > ����

		// ������ ���� ����
		//   - �� ���峻���� ������ �����ڰ� 2�� �̻� ������ ��
		//   - ��κ� : ���� -> ������
		//   - ���� ������ : ���� <- ������ 
		
		/*
		int a, b, c;
		a = 10;
		b = a;
		c = a;

		c = b = a; // ������ ǥ�� 
		*/

		// 5. ���� ������
		//   - ++(����), --(����)
		//   - ���� ������
		//   - �ǿ������� ���� +1/-1
		//   - ��Ȳ�� ���� ������ �켱 ������ �ٲ��.
		//     a. ++num : ����(������ �켱 ���� �ְ�)
		//	   b. num++ : ����(������ �켱���� ����) // ���� ������ ���� ������ ������

		num = 10;
		
		// num = num + 1
		// num += 1
		++num; 
		
		System.out.println(num);  // 11
		
		--num;
		
		System.out.println(num);  // 10
		
		num = 10;
		result = 0;

		// result = 20 + ++num;
		++num;
		result = 20 + num;

		System.out.println(result);
		
		num = 10;
		result = 0;

		// result = 20 + num++;
		result = 20 + num;
		num++;           // ������ �����ڶ� �켱 ���� ���x

		System.out.println(num);    // 11 (������ �켱 ���� ����)
		System.out.println(result); // 30
		
		int o = 10;
		System.out.println(--o - o--); // �ǵ��� �Ⱦ��°� ����
		
		
		num++;
		++num;
		num--;
		--num;

		// 6. ���� ������
		//	 - ������ �����ϰ� �� ����� ���� ������ ����� ��ȯ
		//   - ���� ������
		//   - A ? B : C 
		//   - A(���ǽ� -> �ݵ�� Boolean��)
		//   - B, C : ����, ���

		// 1. ���ǽ�(A)�� true���� false���� Ȯ�� -> true�� ��� 10(B) ��ȯ�� �� ���� / false�� ��� 20(C) ��ȯ�� �� ���� -> �� ��ü�� ������� ������ ��ȯ��(��ȯ)
		num = true ? 10 : 20; 
		System.out.println(num);

		age = 25;
		String msg = (age >= 20 && age < 60) ? "���" : "����";  // �߿� 
		System.out.printf("���� %d���� '%s'�Դϴ�\n"
						  , age, msg );
		




		 /*
			A || B (or)

			T  T  T
			T  F  T
			F  T  T
			F  F  F
				    */	
				



		

		


	}

}








