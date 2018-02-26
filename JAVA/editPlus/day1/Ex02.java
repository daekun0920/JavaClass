/*

�ڹ� �ܼ� ���α׷� �ۼ�

1. ���α׷� �Ҽ� �ۼ�
    - Java ��� ���
	- *.java ����
	- Ŭ������� ���ϸ��� �ݵ�� ����
	- ���� �� ����� ����ϴ� ��� (����� ����ϴ� �� ����(���̳ʸ� �ڵ�)�� ��ȯ���ִ°��� ������)

2. ������, Compile
    - �ҽ� ���� -> ���� -> ����
	- �����Ϸ�, Compiler // ���α׷�
	- javac.exe // �ڹ� �����Ϸ�
	- javac.exe �ҽ�����
	- ����� : ������ ��� -> *.class ����(Ŭ���� ����, ���� ����, ���̳ʸ� ����)

3. ����, Run
	- *.java > javac.exe > *.class = �߰���� > java.exe �� JRE�� ���� �ش� OS�� �´� ����� 2�� �����ȴ�. 
	- *.java = ���, *.class = ������ ���, �� java.exe �� JRE(����)�� ���� �� �մ�(OS) ���⿡ �°� ����
	
	- 2�� ������, ����������
	- java.exe
	- ����� X - > ����
	- ������ = ����� ����, ���������� = ����� X 
	- ������ = �ʱ� ��� ���̵� > �ð��� �����ɸ�, ���������� = �׶��׶� ���ݾ� �����뿪, �����ϸ� �ʱ⿡ �ð��� ���� �ɸ�
	- JIT �����Ϸ�(Just In Time) = �����ϵ� �ƴϰ� ���������͵� �ƴ� �� �߰��� ��(���̺긮��)

*/

/*

�ĺ��� ��Ģ
- ����, ����, Ŭ������, �޼ҵ��, ������ ���...
1. ������ + ���� + Ư�������� "_" �� (�ѱ� x)
2. ���ڷ� ���� x -> _2017
3. �ǹ��ְ�(******) -> ��� ��� x

�ҽ� ���� -> ���� ��� -> �ڹ� �����Ϸ��� (������ �������) ���ӵ� ������ �����Ѵ�.
1. space
2. ����
3. ��


�ڵ� ������ = �ڵ� ��Ÿ�� ��Ģ��

��ҹ��� ö���ϰ� �����Ѵ�.
���� ���� -> ������ ���

*/
import java.io.*;
class Ex02 
{

	public static void main(String[] args) throws Exception {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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

	}

}
