package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		
		//전체 흐름 제어(+ Memo 객체르 사용해서 주업무 실행)
		
		//Memo 객체 생성
		//Memo memo = new Memo(); <- 이렇게 하지 않고 xml 에서 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("memo.xml");
		
		IMemo memo = (IMemo)context.getBean("memo");
		
		//1. 주 업무 실행
		memo.add("메모를 작성합니다.");
		
		//2. 주 업무 실행 - 메모 수정
		memo.edit("수정합니다.");
		memo.edit("수정", "홍길동");
		memo.editName("아무개");
		memo.checkName();
		
		
/*		//3. 주 업무 실행 - 메모 읽기
		try {
			
			for(int i=3; i>-3; i--) {
				memo.read(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		//4. 주업무 - 메모 검색
		System.out.println(memo.search("자바"));	//3
		System.out.println(memo.search("오라클"));	//5
		System.out.println(memo.search("스프링"));	//-1
	}
}
