package com.test.spring.di;

public class Ex02 {
	
	public static void main(String[] args) {
		
		// 기존의 코드 -> DI 패턴 적용
		
		
		// DI
		// - 현재 상황 : 업무 객체(Ex02_Service)가 자신이 필요로 하는 의존 객체(InputData)를 직접 생성해서 사용
		// - 수정 상황 : 의존 객체(InputData)를 필요로 하는 객체(Ex02_Service)에게 의존 객체(InputData)를 필요로 하는 객체(Ex02_Service)에게 직접 만들게 하지 않고, 외부에서 생성하게 
		
		
		// Ex02 -> (의존) -> Ex02_Service : 의존 객체(Dependency Object)
		
		InputData data = new InputData();
	
		//Ex02_Service service = new Ex02_Service();
		
		//service.run(data); // 의존 주입
	
		
		
		Ex02_Service service = new Ex02_Service(data); // 의존 주입
		
		service.run(); 
		
	
	}
	
}
