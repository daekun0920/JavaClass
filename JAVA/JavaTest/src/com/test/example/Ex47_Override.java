package com.test.example;

public class Ex47_Override {
	public static void main(String[] args) {
		
		// Ex47_Override.java
		
		// 면접에서 잘 물어봄
		// 메소드 오버라이드, Method Override
		//   - 메소드 재정의 > 상속 할 때 발생
		//   - 메소드 오버로딩 vs 메소드 오버라이딩
		//   - 부모가 추상이던 일반이던 타입에 관계 없이 발생한다.
		
		OverrideParent p = new OverrideParent();
		p.hello();
		
		OverrideChild c = new OverrideChild();
		c.hello();
		// c.hi();
		
	}
}

// 동네 주민
class OverrideParent {
	public String name;
	
	public void hello() {
		System.out.println("안녕하세요.");
	}
	
}

class OverrideChild extends OverrideParent {
//	public void hi() {
//		System.out.println("하이");
//	}
	// 메소드 오버라이딩(재정의) 
	public void hello() {  			// 부모가 준 메소드 수정이나 다름 없음 // 부모가 물려준 메소드와 자식이 만든 메소드가 부딪히면 항상 자식이 이긴다.
		System.out.println("하이~");
	}

}





































