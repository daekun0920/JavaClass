package com.test.lambda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

public class Ex07 {
	
	public static void main(String[] args) {
		//m1();
		m2();
	}

	private static void m2() {
		
		// 디렉토리 참조
		String path = "C:\\CLASS\\DB\\스크립트";
		
		File dir = new File(path);
		
		try {
			
			// 1 번 방법
			File[] list = dir.listFiles();
			
			for (File file : list) {
				if (file.isFile() && file.getName().endsWith(".sql")) {
					System.out.println(file.getName());
				}
			}
			
			// 2 번 방법
			FilenameFilter filter = new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					
					return name.endsWith(".sql");
				}
				
			};
			
			list = dir.listFiles(filter);
			
			System.out.println();
			for (File file : list) {
				System.out.println(file.getName());
			}
			
			// 3 번 방법
			list = dir.listFiles((d, name) -> name.endsWith(".sql"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}

	private static void m1() {
		
		// 파일 복사
		// - 바이너리 파일 복사
		
		String path = "a\\hello.zip";
		String copy = "b\\hello.zip";
		
		//File file = new File(path);
		//System.out.println(file.exists());
		
		// 복사 -> 비트(바이트) 복사 
		try {
			
			// 원본으로부터 1, 0을 읽어들이기 위한 스트림
			FileInputStream input = new FileInputStream(path);
			
			// 원본의 1, 0을 가지고 다른곳에 쓰기위한 스트림
			FileOutputStream output = new FileOutputStream(copy);
			
			int b = -1;
			
			// EOF 만날시 -1 리턴 
			while ((b = input.read()) != -1) {
				output.write(b);
			}
			
			output.close();
			input.close();
			
			System.out.println("복사 완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}
}
