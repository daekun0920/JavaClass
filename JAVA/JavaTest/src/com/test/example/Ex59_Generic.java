package com.test.example;

public class Ex59_Generic {
	
	public static void main(String[] args) {
		
		// Ex59_Generic.java
		
		// 제네릭, Generic (사용빈도 높음)
		//   - 일반적인, 포괄적인..
		
		// 제네릭
		// 1. 제네릭 클래스(**)
		// 2. 제네릭 메소드
		
		// 제네릭을 도입한 이유
		//   -> 제네릭 컬렉션을 지원하기 위해서... (기존에는 그냥 컬렉션이라는것이 존재했었음) 
		
		// Object 클래스와의 관계
		//   -> Object의 장점을 계승하고 단점을 배제한 기술
		
		/*WrapperInt n1 = new WrapperInt(100);
		System.out.println(n1.getData());
		n1.setData(200);
		System.out.println(n1);
		System.out.println(n1.getData() + 100);*/
		
		WrapperObject n2 = new WrapperObject(200);
		System.out.println(n2.getData());
		n2.setData(300);
		System.out.println(n2);
		System.out.println((int)n2.getData() + 200);
		
		
		
		// 제네릭(Generic) 예제
		// Object의 장점만을 취하고 단점을 버린것이 제네릭이다.
		// 제네릭은 잘못된 값이 들어올경우 오류를 내기때문에 쉽게 문제점을 찾을수 있다 / 반면 Object는 오류를 표시하지않아 잡기 힘들다 
		// 제네릭은 다운캐스팅이 필요없다
		Wrapper<Integer> n3 = new Wrapper<Integer>(300);  //// 
		System.out.println(n3.getData());
		n3.setData(400);
		System.out.println(n3);
		System.out.println(n3.getData() + 300); // Int로 돌려줘서 캐스팅 필요없음
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.getData());
		b3.setData(false);
		if (b3.getData()) {
			
		} else {
			
		}
		
		Wrapper<String> s3 = new Wrapper<String>("홍길동");
		System.out.println(s3.getData());
		s3.setData("아무개");
		System.out.println(s3.getData().length());
		
		System.out.println("=============");
		////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.getData());
		b1.setData(false);
		System.out.println(b1);
		if (b1.getData()) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		WrapperObject n4 = new WrapperObject(false);
		System.out.println(n4.getData());
		n4.setData(true);
		System.out.println(n4);
		if ((boolean)n4.getData()) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.getData());
		s1.setData("아무개");
		System.out.println(s1);
		System.out.println(s1.getData().length());
		
		WrapperObject s2 = new WrapperObject("무명씨");
		System.out.println(s2.getData());
		s2.setData("하하하");
		System.out.println(s2);
		System.out.println(((String)s2.getData()).length());
		s2.setData(1000);
		
	} 
}

// 요구사항) int값 1개를 중심으로 그 값을 제어(조작)하는 클래스 선언
// 요구사항) boolean값 1개를 중심으로 그 값을 제어(조작)하는 클래스 선언 
// 요구사항) String값 1개를 중심으로 그 값을 제어(조작)하는 클래스 선언
// 요구사항) byte, short, long, float, double, char
// 값형(8개), 참조형(무한대) -> 어떻게 해결?

// 해법) Object 사용해서 해결
//        -> 문제점
//   	  1. 의도하지 않은 자료형의 데이터가 대입되는 경우 제어 불가능
//		  2. 원형 타입으로 접근을 할 때 다운캐스팅 문제
// 		  해법) 제네릭 클래스를 사용해서 해결 

class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		// 추가 업무
		// if (data > 0) {}  	(제네릭 단점) -> 한 자료형에 종속된 작업이 불가능하다. 유효성 검사 등등 
		this.data = data;
		
	}
	 @Override
	public String toString() {
		return this.data + "";
	}
	
}


class WrapperObject {
	
	private Object data; // <- 핵심. 클래스의 모든 업무의 중심
	
	public WrapperObject(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return this.data + "";
		
	}

}



class WrapperBoolean {
	
	private boolean data; // <- 핵심. 클래스의 모든 업무의 중심
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return this.data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return this.data + "";
		
	}

}

class WrapperString {
	
	private String data; // <- 핵심. 클래스의 모든 업무의 중심
	
	public WrapperString(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return this.data + "";
		
	}

}

