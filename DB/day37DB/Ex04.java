package com.test.lambda;

import java.util.function.Consumer;

public class Ex04 {
	
	public static void main(String[] args) {
		
		// 함수형 인터페이스 선언 -> 람다식 선언
		
		// JDK 1.8부터 람다식을 사용하기 위한 전용 인터페이스들 제공 -> java.util.function 패키지
		// 람다식을 자주 사용하다보면 나오는 패턴(인자, 반환)을 가지고 미리 인터페이스 구현
		
		/*
		  
		 표준 API 함수형 인터페이스
		 
		 
		 1. Consumer
		 	- 소비자
		 	- 매개변수 O, 반환값 X
		 2. Supplier
		 	- 공급자
		 	- 매개변수X, 반환값O
		 3. Function
		 	- 함수
		 	- 매개변수O, 반환값O
		 4. Operator
		 	- 연산자, 조작자
		 	- 매개변수O, 반환값O
		 5. Predicate
		 	- 서술자
		 	- 매개변수O, 반환값O(boolean)
		 	
		 */
		m1();
	}
	private static void m1() {
		// Consumer
		// -매개변수O, 반환값X
		
		// Consumer<T>
		Consumer<String> c1 = new Consumer<String>() {
		
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		
		};
		c1.accept("홍길동");
		c1.accept("아무개");
		
		Consumer<Integer> c2 = (n) -> System.out.println(n);
		c2.accept(100);
		c2.accept(200);
		
		
		Consumer<Student> c3 = (s) -> {
			if(s.getAge() >= 20) {
				System.out.println(s);
			} else {
				System.out.println("민짜");
			}
		};
		c3.accept(new Student(1, "홍길동", 25));
		c3.accept(new Student(1, "홍길동", 18));
		
		//-------------------------------------------
		Student s1 = new Student(3, "하하하", 25);
		
		Work w = new Work();
		w.working((s) -> System.out.println(s), s1);
		w.working((s) -> s.setAge(s.getAge() + 1), s1);
		w.working((s) -> System.out.println(s.getAge()), s1);
		w.working((s) -> System.out.println(s.getName()), s1);
		
		
	}
	
	
}
class Work {
	
	public void working(Consumer<Student> c, Student s) {
		c.accept(s);
	}

}

class Student {
	private int seq;
	private String name;
	private int age;
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		this(0, null, 0);
	}
	
	public Student(int seq, String name, int age) {
		this.seq = seq;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [seq=" + seq + ", name=" + name + ", age=" + age + "]";
	}
	
	
}