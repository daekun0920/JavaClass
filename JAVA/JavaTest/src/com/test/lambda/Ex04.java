package com.test.lambda;

import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

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
		m2();
		m3();
		m4();
	}
	public static void m4() {
		
		// Operator
		// - 매개변수 O
		// - 반환값 O
		// 매개변수로 해당타입 2개를 넘겨주고 해당타입으로 1개를 반환받는다.
		BinaryOperator<Integer> o1 = (a, b) -> (a > b) ? a : b;
		System.out.println(o1.apply(10, 20));
		System.out.println(o1.apply(40, 30));
		
		BinaryOperator<Student> o2 = (s1, s2) -> {
			if (s1.getAge() > s2.getAge()) {
				s1.setName("형님 : " + s1.getName());
				return s1;
			} else {
				s2.setName("형님 : " + s2.getName());
				return s2;
			}
		};
		
		Student hong = new Student(1, "홍길동", 25);
		Student test = new Student(2, "테스트", 22);
		
		Student result = o2.apply(hong, test);
		System.out.println(result);
	}
	private static void m3() {
		
		// Function
		// - 매개변수 O
		// - 반환값 O
		
		Function<Integer, String> f1 = num -> (num > 0) ? "양수" : "음수";
		System.out.println(f1.apply(10));
		
		Function<String, Student> f2 = name -> new Student(1, name, 20);
		System.out.println(f2.apply("아무개"));
		
		BiFunction<String, Integer, Student> f3 
		// = (String name, Integer age) -> {};
		= (name, age) -> new Student(1, name, age);
		
		System.out.println(f3.apply("홍길동", 30));
		
		// 매개변수타입Function<반환값타입>
		DoubleFunction<String> f4 = (d) -> "홍길동";
		
		IntFunction<String> f5 = (i) -> "홍길동";
		
	}
	private static void m2() {
		
		// Supplier
		// - 매개변수 X
		// - 반환값 O
		
		// Supplier<T>
		Supplier<String> s1 = () -> { return "홍길동"; };
		System.out.println(s1.get());
		
		Supplier<Student> s2 = () -> new Student(1, "아무개", 20);
		System.out.println(s2.get());
		
		// Supplier<Integer>
		// IntSupplier
		IntSupplier s3 = () -> Calendar.getInstance().get(Calendar.HOUR);
		System.out.println(s3.getAsInt());
		
		DoubleSupplier s4 = () -> Math.random();
		System.out.println(s4.getAsDouble());
		
		
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
		
		// Consumer<T>
		// - 매개변수 1개
		// BiConsumer<T.U>
		// - 매개변수 2개
		
		BiConsumer<String, String> c4 = (name, nick) -> { System.out.printf("%s는 %s다", name, nick); };
		c4.accept("나", "강한용사");
		
		BiConsumer<String, Integer> c5 = (name, count) -> {
			for (int i = 0; i < count; i++) {
				System.out.printf("%s님 안녕~\n", name);
			}
		};
		c5.accept("아무개", 5);
		
		// Consumer<Double> c6
		DoubleConsumer c6 = d -> System.out.println(d);
		c6.accept(3.14);
		
		IntConsumer c7 = n -> System.out.println(n);
		c7.accept(100);
		
		//BiConsumer<T, Integer>
		ObjIntConsumer<Student> c8 = (s, age) -> {
			s.setAge(age);
			System.out.println(s.getAge());
		};
		
		c8.accept(new Student(5, "호호호", 20), 25);
		
		// XXXConsumer
		// - 매개변수의 갯수 or 타입 다르게 제공 
		// - 모든 Consumer는 반환값 없다.
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