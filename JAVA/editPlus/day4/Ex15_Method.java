
// Ŭ����
//   - �޼ҵ��� ����
class Ex15_Method {

	// �޼ҵ�

	// main �޼ҵ�
	//   - Ư���� �޼ҵ�
	//   - JVM�� ȣ���Ѵ�. -> main();
	//   - ���α׷� ������(Start Point)
	//   - ���α׷� ��Ʋ�� main �޼ҵ�� �����ϴ�.
	public static void main(String[] args) {
		
		// Ex15_Method.java
		
		// �޼ҵ�, Method
		//   - �Լ�(Function), ���ν���(Procedure), ��ƾ(Routine)..
		//   - Ŭ���� ���ο��� ����� �Լ�
		//   - (��ü��) �ൿ, Behavior
		
		// �޼ҵ� ����(Ư¡)
		// 1. �ݺ��Ǵ� �ڵ带 1���� ���� + ����(***)
		// 2. �ڵ��� ������ ��Ÿ����. -> ������ ���� -> �׷� ����


		// �䱸����) "�ȳ��ϼ���" x 5�� ���
		// ��������) "�ݰ����ϴ�"
		System.out.println("�ȳ��ϼ���");
		System.out.println("�ȳ��ϼ���");
		System.out.println("�ȳ��ϼ���");
		System.out.println("�ȳ��ϼ���");
		System.out.println("�ȳ��ϼ���");
		
		
		
		// 1. �޼ҵ� �����ϱ�
		// 2. �޼ҵ� ȣ���ϱ�
		
		// 2. �޼ҵ� ȣ���ϱ�(����ϱ�)
		//   - �̸��� �θ���.  // �ڵ� ���뼺�� ����
		hello();
		hello();
		hello();
		hello();
		hello();
		
		// �̰����� �� 1���� ��� -> �׷��� �޼ҵ� ��� -> ���� ó�� ��� �˾ƺ��Ⱑ ������(������)
		count();

	} // main  // �޼ҵ� ��ȣ ���� �ּ��ޱ�

	// Ŭ���� ����
	// 1. �޼ҵ� �����ϱ�
	//   - Ŭ���� ���ο����� ���� ����
	//   - �ٸ� �޼ҵ� ���ο��� ���� �Ұ���
	//   - �޼ҵ� ������ ����

	

   // public : ���� ������(������), Access Modifier
   // static : ���� Ű����
   //   void : ��ȯ Ÿ��
   //  hello : �޼ҵ��(�ĺ��� - ���� �޼ҵ� �� �� �޼ҵ带 ����)
   //     () : ���� ����Ʈ, �Ű����� ���, Arguments, Parameters
   //     {} : �޼ҵ� ����, �޼ҵ� ������(**)

	public static void hello() {

		System.out.println("Hi~");
		count();




	} // hello
	





	public static void count() {

		System.out.println("��");
		System.out.println("��");
		System.out.println("��");
		System.out.println("��");
		System.out.println("��");
	

	} // count


	

} //class Ex15
