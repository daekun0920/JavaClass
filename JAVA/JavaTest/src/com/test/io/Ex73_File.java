package com.test.io;

import java.io.File;
import java.util.Calendar;

public class Ex73_File {
	
	public static void main(String[] args) {
		
		// Ex73_File.java
		
		// 파일 & 디렉토리
		// 1. 액세스 & 조작 : 윈도우 탐색기*
		// 2. 파일 데이터 입/출력 : 메모장*
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10(); // *******
	}
	
	private static void m10() {
		
		// m9()와 동일한 업무
		// 특정 폴더의 파일이 총 몇개?
		// 파일 : 5835, 폴더 : 1568
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		int count = 0; // 누적 변수
		
		count = getFileCount(dir, count);
		
		System.out.println("파일 갯수 : " + count);
	} // m10
	
	
									// dir은 원하던게 맞고 count는 아님(참조형, 값형)
	private static int getFileCount(File dir, int count) {
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					// 이 부분이 업무에 맞게 수정 > 해당 폴더와 관련된 정보를 취득할 수 있다.
					count++; // 전체 파일 갯수
					file.length(); // 누적시키면 전체 파일 크기가 된다
				}
			}
			for (File subdir : files) {
				if (subdir.isDirectory()) {
					// 부모와 동일한 업무 다시 반복
					count = getFileCount(subdir, count); // 재귀
				}
			}
		}
		
		return count;
		
	} // getFileCount

	
	
	private static void m9() {
		
		// 특정 폴더의 파일이 총 몇개?
		// 파일 : 5835, 폴더 : 1568
		String path = "C:\\eclipse";
		File dir = new File(path);
		int count = 0; // 누적 변수
		
		if (dir.exists()) {
			
			// 자식들
			File[] files = dir.listFiles();
			
			// 자식 파일 갯수 세기
			for (File file : files) {
				if (file.isFile()) {
					count++; // 파일 갯수 ++
				}
			}
			
			// 자식 폴더를 대상으로 자신의 행동과 동일한 행동 실행
			for (File subdir : files) {
				if (subdir.isDirectory()) {
					
					// 손자 목록
					File[] subfiles = subdir.listFiles();
					
					for (File subfile : subfiles) {
						if (subfile.isFile()) {
							count++;
						}
					}
					
					for (File subsubdir : subfiles) {
						if (subsubdir.isDirectory()) {
							
							// 손자 폴더들..
						}
					}
					
				}
			}
			
		} // if
		System.out.printf("총 파일 갯수 : %d개\n", count);
	}

	
	
	private static void m8() {
		
		// 폴더의 내용 보기
		//   - 현재 폴더내에 들어있는 자식 폴더와 파일들을 가져오기
		
		String path = "C:\\eclipse";
		
		File dir = new File(path);
		if(dir.exists()) {
			
//			// 자식들 이름(폴더명 + 파일명)
//			String[] list = dir.list(); // list();
//			
//			for (String name : list) {
//				//System.out.println(name);
//				File file = new File(path + "\\" + name);
//				
//				System.out.println(file.getName());
//				System.out.println(file.isFile()); // 파일인가?
//				System.out.println(file.length()); // (크기) 폴더는 무조건 0
//			}
		
		File[] files = dir.listFiles();
		
		for (File file : files) {
			//System.out.println(file.getName());
			if (file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");
			}
		}
		
		for (File file : files) {
			//System.out.println(file.getName());
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
			
	}
	
	}
	
	

	private static void m7() {
		
		// 폴더 삭제하기
		//   - 반드시 빈 폴더일 경우에만 삭제가 된다.***
		String path = "D:\\AAA";
		File dir = new File(path);
		
		if (dir.exists()) {
			System.out.println(dir.delete()); // Boolean 리턴 (성공 여부)
		}
	
		
		
	}

	
	
	private static void m6() {
		
		// 폴더명 바꾸기 & 이동하기
		// D:\AAA\BBB -> D:\CCC\BBB
		
		String path = "D:\\AAA\\BBB";
		File oriDir = new File(path);
		
		String destPath = "D:\\CCC\\FFF";
		File destDir = new File(destPath);
		
		if (oriDir.exists()) {
			oriDir.renameTo(destDir); // 폴더 이동
 		}
		
		System.out.println("완료");
	}

	
	
	private static void m5() {
		
		// 폴더 생성하기
		String path = "D:\\AAA\\DDD";
		
		File dir = new File(path);
		
		if (!dir.exists()) {
			// 없으면 
			dir.mkdir(); // 폴더 생성 // Boolean 리턴(성공 여부)
			System.out.println("생성 완료");
		} else {
			// 있으면
			System.out.println("같은 이름의 폴더가 이미 존재합니다.");
		}
		
		//------------------------------
		
		// 회원 정보 -> 각 회원별 개인 파일을 저장할 폴더가 필요
		String[] list = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
		
		for (String name : list) {
			
			path = String.format("D:\\AAA\\[개인폴더]%s", name);
			
			dir = new File(path);
			dir.mkdir();
			
			System.out.printf("%s 회원의 개인 폴더를 생성합니다.\n", name); // log
			
			
			
		}
		
		// 2018-01-01 ~ 2018-12-31 365개의 날짜 폴더
		Calendar c = Calendar.getInstance();
		c.set(2018, 0, 1);
		
		for (int i = 0; i < 365; i++) {		// 년월일을 대시로 연결해서 보여주는 형식 문자열	
			String dirName = String.format("%tF", c);
			
			// D:\AAA\2018-01-01
			dir = new File("D:\\AAA\\" + dirName);
			dir.mkdir();
			
			c.add(Calendar.DATE, 1); // 현재 시각 수정 
		}
		System.out.println("완료");
		
	}

	
	
	private static void m4() {

		// 파일 삭제하기
		String path = "D:\\AAA\\파일.txt";
		File file = new File(path);
		
		if (file.exists()) {
			boolean result = file.delete(); // 복구 불가(영구 삭제) // 리턴 값 Boolean(삭제 성공 여부 리턴)
			System.out.println("삭제 완료 : " + result);
		}
		
	}

	
	
	private static void m3() {

		// 파일 이동하기
		
		// 파일.txt -> [2017.12.21]파일.txt
		String path = "D:\\AAA\\파일.txt";
		File file = new File(path);
		
		if (file.exists()) {
			
			// String dest = "D:\\CCC\\홍길동.txt"; // 옮기고 난 후의 모습 
			
			// 파일.txt -> [2017.12.21]파일.txt
//			Calendar now = Calendar.getInstance();
//			String dest = String.format("D:\\CCC\\[%d. %d. %d]%s", now.get(Calendar.YEAR)
//																 , now.get(Calendar.MONTH) + 1
//																 , now.get(Calendar.DAY)
//																 , file.getName()); 
			
			// 파일 이름 바꾸기
			String dest = "D:\\AAA\\홍길동.txt"; // 같은 폴더 내에서 이름만 바뀐다(Rename, 파일명 바꾸는 기능도 가능)
			
			File destFile = new File(dest);
			
			// 이동하기
			file.renameTo(destFile);
			
			System.out.println("이동 완료");
		}
		
		
		
	}
	
	

	private static void m2() {
		
		// 디렉토리 접근 > 폴더의 정보 얻어오기 (탐색기)
		// 폴더는 실제의 공간의 개념이아니라 지표의 개념이다, 크기가 존재하지않는 특수한 파일이다.
		
		String path = "D:\\AAA";
		
		File dir = new File(path); // 그냥 파일과 디렉토리는 거의 동급이다.
		// Alt + Shift + A = 토글 블록 셀렉션 (토글 수정)
		if (dir.exists()) {
			System.out.println(dir.getName()); // 파일명(***)
			System.out.println(dir.isFile());  // 파일인지? (***)
			System.out.println(dir.isDirectory()); // 폴더인지? (***)
			System.out.println(dir.lastModified()); // 마지막 수정 날짜 (틱 값 : 1970년 1월 1일부터 흐른 밀리초)
			System.out.println(dir.canRead()); // 읽기 가능? 
			System.out.println(dir.canWrite()); // 쓰기 가능?
			System.out.println(dir.isHidden()); // 숨김 파일?
			System.out.println(dir.length()); // 파일 크기(바이트) (***)
			System.out.println(dir.getPath()); // 파일 경로 (***)
			System.out.println(dir.getAbsolutePath()); // 파일 경로 (***) 
			System.out.println(dir.canExecute()); // 실행 가능 
		} else {               
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		
	}

	
	
	
	private static void m1() {

		// 파일 접근 > 파일의 정보 얻어오기 (탐색기)
		
		
		// 파일 참조 객체 생성 > 객체 조작 > 파일 조작 
		
		String path = "D:\\파일.txt";
		
		File file = new File(path);
		
		System.out.println(file.exists());
	
		if (file.exists()) {
			// 파일 있음
			
			System.out.println(file.getName()); // 파일명(***)
			System.out.println(file.isFile());  // 파일인지? (***)
			System.out.println(file.isDirectory()); // 폴더인지? (***)
			System.out.println(file.lastModified()); // 마지막 수정 날짜 (틱 값 : 1970년 1월 1일부터 흐른 밀리초)
			System.out.println(file.canRead()); // 읽기 가능? 
			System.out.println(file.canWrite()); // 쓰기 가능?
			System.out.println(file.isHidden()); // 숨김 파일?
			System.out.println(file.length()); // 파일 크기(바이트) (***)
			System.out.println(file.getPath()); // 파일 경로 (***)
			System.out.println(file.getAbsolutePath()); // 파일 경로 (***) 
			System.out.println(file.canExecute()); // 실행 가능 
			
		} else {
			// 파일 없음
			System.out.println("파일이 없습니다.");
		}
		
		
	}
	
	
	
}
