package com.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06 {
	
	
	//Ex03.java : 컨트롤러 역할
	//Ex03_DAO.java : DAO
	//Ex03_File.java : File 데이터 처리
	//Ex03_DB.java : DB 데이터 처리
	
	public static void main(String[] args) {
		
		// m1();
		// m2();
		m3();
	}

	private static void m3() {
		
		// 오늘 수업의 목표 -> m3() //
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config03.xml");
		
		// Main 클래스는 자신과 관계가 있는 객체? dao(O), db(X), file(X)
		Ex06_DAO dao = (Ex06_DAO) context.getBean("dao2"); // 완제품
		
		System.out.println(dao.getCount());
		
	}

	private static void m2() {

		// 객체 생성 + 관계 <- 스프링으로 구현
		ApplicationContext context = new ClassPathXmlApplicationContext("config03.xml");
		
		// xml -> <bean> x 2 선언 -> getBean() 호출
		
		// DB 객체 생성
		IData data = (IData) context.getBean("db"); // <bean id = "db">
		
		Ex06_DAO dao = (Ex06_DAO) context.getBean("dao"); // <bean id = "dao">
		
		// 관계 맺기 -> 의존 주입
		dao.setData(data);
	
		
		// 업무 실행
		System.out.println(dao.getCount());
		
	}

	private static void m1() {

		// Ex06_Data -> (의존) -> Ex06_DB(Ex06_File)
		
		IData data = new Ex06_File();
		
		// Ex06_DAO dao = new Ex06_DAO(data); // 생성자를 통한 DI 발생
		
		Ex06_DAO dao = new Ex06_DAO();
		dao.setData(data); // setter를 통한 DI 발생
		
		System.out.println(dao.getCount());
		
		
	}

	
	
	
	
}
