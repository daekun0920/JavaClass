import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			if (line.length() > 100
			 || line.startsWith(" ") 
			 || line.endsWith(" ")
			 || line.isEmpty()) {
				continue;
			} 
			for (int j = 0; j < line.length(); j++) {
				char word = line.charAt(j);
				if (word == 32 
				|| (word >= 48 && word <= 57) 
				|| (word >= 65 && word <= 90) 
				|| (word >= 97 && word <= 122)
				|| (word == 32)) {
					if (j == line.length() - 1) {
						System.out.println(line);
                  
					}
					continue;
				} else {
					break;
				}
			}
		}
		
		scan.close();
	}
	
}