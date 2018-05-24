package com.test.spring.di;

public class Ex02_Service {
	
	// 의존 주입(DI) 구현 패턴
	// 1. 메소드 매개 변수 사용 -> setter 사용
	// 2. 생성자 사용
	
	private InputData data;
	
	public Ex02_Service(InputData data) {
		
		this.data = data;
		
	}
	
	public void setData(InputData data) {
		
		this.data = data;
		
	}
	
	public void run() {
		
		String name = data.getName();
		System.out.printf("안녕 ~ %s\n", name);	
	
	}
	
	/*	
	public void run(InputData data) {
		
		// DI : 자신이 필요로 하는 의존 객체를 직접 만들면 안된다! -> 외부에서 전달받아서 사용
		
		// Ex02_Service -> (의존) -> InputData
		// InputData data = new InputData(); // XXX
		// String name = data.getName();
		// System.out.printf("안녕 ~ %s\n", name);
		String name = data.getName();
		System.out.printf("안녕 ~ %s\n", name);
				
	}
	*/
}
