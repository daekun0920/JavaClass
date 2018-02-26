package homework;

import java.io.File;

public class FileEx07 {
	public static void main(String[] args) {
		
		
	 // 직원명_년도_일련번호.txt
	 // 아무게_2014_32.txt
		
	String path = "D:\\Class\\Java\\디렉토리 문제\\직원";
	
	File dir = new File(path);
	
	File[] files = dir.listFiles(); // 파일 목록
	
	for (File file : files) {
		if (file.isFile()) {
			
			// 아무게_2014_32.txt
			int index = file.getName().indexOf("_");
			
			String name = file.getName().substring(0, index);
			System.out.println(name);
			
			String temp = file.getName().replace("__", "_");
																				  // 언더라인 2개를 하나로 바꾸기 
			String year = temp.substring(index + 1, temp.lastIndexOf("_"));
			System.out.println(year);
			
			// 이름으로 폴더 생성하기
			File nameDir = new File(path + "\\" + name);
			
			if (!nameDir.exists()) nameDir.mkdir();
			
			// 이름 > 년도 로 폴더 생성하기
			File yearDir = new File(path + "\\" + name + "\\" + year);
			
			if (!yearDir.exists()) yearDir.mkdir();
			
			// 파일 이름 > 년도 폴더로 이동하기
			File move = new File(path + "\\" + name + "\\" + year + "\\" + file.getName());
			file.renameTo(move);
		
		}
	}
	
	}

}
