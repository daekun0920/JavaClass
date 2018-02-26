package com.test.example;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Ex52_Casting {
	public static void main(String[] args) {
		
		// Ex52_Casting.java
		
		// 참조형의 형변환
		//   - 대상 : 상속 관계를 맺은 클래스끼리(일반클래스, 추상클래스)
		// 1. 업 캐스팅
		//   - 부모클래스 = 자식클래스;
		//   - 100% 가능 
		// 2. 다운 캐스팅
		//   - 자식클래스 = 부모클래스;
		//   - 100% 불가능 -> (업캐스팅 -> 다운캐스팅) 가능 
		
		AAAA a = new AAAA();
		AAAA b = new BBBB();  // 업캐스팅, 부모 = 자식 
		AAAA c = new CCCC();  // 업캐스팅, 할아버지 = 손자 
		AAAA d = new DDDD();  // 업캐스팅, 증조할아버지 = 증손자 
		
		AAAA[] list = new AAAA[4];
		list[0] = new AAAA();
		list[1] = new BBBB();
		list[2] = new CCCC();
		list[3] = new DDDD();
		
		// *** Object : 자바에 존재하는 모든 클래스의 최상위 클래스 
		Object o1 = new Object();
		Object o2 = new AAAA();
		Object o3 = new BBBB();
		Object o4 = new CCCC();
		Object o5 = new DDDD();
	
		Object o6 = new Random();
		Object o7 = new Scanner(System.in);
		Object o8 = Calendar.getInstance();
		
		// Object 변수는 만능 : 세상에 존재하는 모든 데이터를 담을 수 있는 타입
		
		// 모든 데이터를 한번에 제어할 수 있는 집합
		
		
		// 만능 -> 물리 장점
		//      -> 개발자 입장 -> 다시 접근 -> 해당 요소의 자료형 ? -> 가독성 + 관리 최악  -> ex) instanceof 연산자 사용
		//      -> 개발자 -> 논리적 약속 & 기억 -> 반드시 오류 발생(사람이라서.. 실수) 
		//      -> ******* Object 참조 변수를 사용할 때 주의점!! -> 처음에 넣은 자료형을 끝까지 사용한다. (처음 넣은 자료형 이외의 타입을 다시 넣지 않는다.) *******
		//      -> 한 배열은 한 자료형 타입만 넣어 사용한다
		
		Object[] list2 = new Object[100];
		
		list2[0] = new Random();
		list2[1] = Calendar.getInstance();
		list2[2] = new BBBB();
		
		// 무엇이 들어있는지 사실상 예측이 되지않는 단점이있다 .
		Object aaaa = new AAAA();
		AAAA aaaa2 = new AAAA();
		
		aaaa = new BBBB();
		aaaa = new CCCC();
		
		// 이상한점?
		
		// Object 클래스에 한해서... 
		// 참조변수 = 값데이터;
		// 물리적으로 불가능한 상황
		// 박싱(Boxing) 발생
		// 100(Integer), true(Boolean) 각 클래스(Integer.parseInt(), Boolean...) 객체안에 멤버값에 들어있는 상태로 힙 구역에 저장됨 (박싱)
		Object o9 = 100;	// 값형
		Object o10 = true; // 값형
		Object o11 = 'a';  // 값형
		
		Object o12 = "홍길동"; // String - 참조형 (이건 안이상함)
	
		System.out.println(o9);
		
		
		
		Object num = 100; // 박싱 
		int num2 = 100;
		
		System.out.println(num); // 데이터 출력 X -> 주소값 따라감 -> 객체 출력 -> toString()
		System.out.println(num.toString()); // 데이터를 돌려주도록 재정의 (오버라이드)
		
		System.out.println(num2); // 데이터 출력
		// System.out.println(num + num2);    // 주소값 + 값 이라서 연산이 불가능함 
		
		// 언박싱(Unboxing) : Object 참조 변수에 넣어놨던 값형의 데이터를 다시 꺼내는 작업(Object -> int)
		System.out.println((int)num + num2); // 연산을 위해 다운캐스팅, 언박싱(Unboxing)
		System.out.println((Integer)num + num2);
		
		Object temp = true;
		System.out.println(temp);
		
		if ((boolean)temp) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		// Object 특징
		// 1. 장점
		//    - 모든 자료형(참조형, 값형)을 담을 수 있다. -> 코드 유연하게..
		// 2. 단점
		//    - 원래 자료형으로 꺼낼때(형변환) 원래 자료형이 어떤 타입이었는지를 알기가 힘들다.(초기화 구문을 직접 보기 전에는 알기 힘듬)
		//    - 고비용(박싱 + 언박싱)
		Object n = 10;
		System.out.println((int)n + 10);
		
		
		
	}
}

class AAAA {}
class BBBB extends AAAA {}
class CCCC extends BBBB {}
class DDDD extends CCCC {}
