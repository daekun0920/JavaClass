package com.test.spring.di;

public class Ex04 {
	
	
	//Ex03.java : 컨트롤러 역할
	//Ex03_DAO.java : DAO
	//Ex03_File.java : File 데이터 처리
	//Ex03_DB.java : DB 데이터 처리
	
	public static void main(String[] args) {
		
		// IData data = new Ex04_DB();
		IData data = new Ex04_File();
		
		// 학생 데이터 -> 인원수 출력
		Ex04_DAO dao = new Ex04_DAO(data);
		
		int count = dao.getCount();
		
		System.out.println("학생 수 : " + count);
		
	}

	
	
	
}
