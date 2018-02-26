package com.test.lambda;

import java.util.Calendar;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex01 {
	public static void main(String[] args) {
		
		// java > com.test.lambda > Ex01.java
		m1();
		
		
		
	}

	private static void m1() {
	
		// 람다식 -> 표현 간단한 메소드 구현 <- 인터페이스 필요(익명 클래스)  -> com.util.function 패키지(람다용 인터페이스들 제공)
		// 람다식에 사용하는 함수형 인터페이스는 Consumer(***), Supplier(***), Function(***), Operator, Predicate가 있다.
		
		// Consumer : 매개변수 O, 반환값 X
		Consumer<String> c1 = str -> System.out.println(str);
		Consumer<Integer> c2 = n -> System.out.println(n);
	
		c1.accept("홍길동");
		c2.accept(100);
		
		// Supplier : 매개변수 X, 반환값 O
		Supplier<String> s1 = () -> { return "홍길동"; };
		Supplier<Integer> s2 = () -> 100;
		Supplier<Double> s3 = () -> Math.random();
		
		System.out.println(s1.get());
		System.out.println(s2.get());
		System.out.println(s3.get());
		
		
		// Function : 매개변수 O, 반환값 O
		Function<String, String> f1 = name -> name.substring(0, 1);
		System.out.println(f1.apply("홍길동"));
		
		Function<String, Integer> f2 = name -> name.length();
		System.out.println(f2.apply("홍길동"));
		
		Function<Integer, Boolean> f3 = n -> n % 3 == 0;
		System.out.println(f3.apply(15));
		System.out.println(f3.apply(17));
		
		BiFunction<Integer, Integer, Boolean> f4 = (a, b) -> a > b;
		System.out.println(f4.apply(10, 3));
		System.out.println(f4.apply(3, 10));
		
		BiFunction<Calendar, Calendar, Long> f5 = (cc1, cc2) -> ((cc1.getTimeInMillis() - cc2.getTimeInMillis()) / 1000 / 60 / 60 / 24);
		
		Calendar cc3 = Calendar.getInstance();
		Calendar cc4 = Calendar.getInstance();
		cc4.set(2018, 1, 30); // 1 -> 2월 
		
		System.out.println(f5.apply(cc4, cc3));
		
		// Operator : 매개변수 O, 반환값 O, 매개변수 자료형 = 반환값 자료형
		BinaryOperator<Integer> b1 = (a, b) -> (a > b) ? a : b;
		System.out.println(b1.apply(10, 3));
		System.out.println(b1.apply(3, 10));
		
		// Predicate : 매개변수 O, 반환값 O, 반환값 타입 무조건 Boolean
		Predicate<Integer> p1 = n -> n > 0;
		System.out.println(p1.test(10));
		System.out.println(p1.test(-1));
		
		
		
		
	}
}
