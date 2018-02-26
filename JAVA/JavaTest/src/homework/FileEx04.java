package homework;

import java.io.File;

public class FileEx04 {
	
	public static void main(String[] args) {
		
		String path = "D:\\Class\\Java\\디렉토리 문제\\파일 제거";
		
		File dir = new File(path);
		
		File[] files = dir.listFiles();
		
		for (File file : files) {
			if (file.isFile()) {
				if (file.length() == 0) {
					file.delete(); // 사이즈 0 바이트
					
					
				}
			}
		}
		System.out.println("삭제 완료");
	}	
}
