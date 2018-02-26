package homework;

import java.io.File;

public class FileEx01 {
	
	public static void main(String[] args) {
		
		String path = "D:\\Class\\Java\\디렉토리 문제\\Music";
		File dir = new File(path);
		
		File[] files = dir.listFiles();
		
		int n = 1;
		for (File file : files) {
			
			if (file.isFile()) {
				
				String renamePath = String.format("%s\\[%s]%s", path, getNumber(n), file.getName());
				File renameFile = new File(renamePath);
				file.renameTo(renameFile);
				n++;
			}
			
		}
		
		System.out.println("종료");
		
	}
	
	public static String getNumber(int num) {
		if (num < 10) return "00" + num;
		else if (num < 100) return "0" + num;
		else return num + "";
	}
	
}
