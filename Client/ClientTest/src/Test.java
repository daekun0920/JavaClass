import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File("dummy.txt")));
		
		int i = 0;
		int num = 457;
		
		while (i < 155) {
			for (int j = 0;j < 10;j++) {
				writer.write(num + "");
				writer.newLine();
			}
			i++;
			num++;
		}
		
		writer.close();
		System.out.println("완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
