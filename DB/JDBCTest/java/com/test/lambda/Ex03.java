package com.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class Ex03 {
	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
	}

	private static void m5() {
		
		// 메소드 참조
		// - 람다식 내부에서 사용되는 메소드 참조 표현을 더 줄이기 위한 표현
		// - 함수형 인터페이스의 시그너처와 참조 메소드의 시그너처가 동일(***)
		
		IntBinaryOperator o1;
		o1 = (a, b) -> a + b;
		System.out.println(o1.applyAsInt(10, 20));
		
		o1 = (a, b) -> Calculator.aaa(a, b);
		System.out.println(o1.applyAsInt(30, 40));
		
		o1 = Calculator::aaa; // 정적 메소드 참조
		System.out.println(o1.applyAsInt(50, 60));
		
		
		Calculator c1 = new Calculator();
		
		o1 = (a, b) -> c1.bbb(a, b);
		System.out.println(o1.applyAsInt(70, 80));
		
		o1 = c1::bbb; // 객체 메소드 참조
		System.out.println(o1.applyAsInt(90, 100));
	
	}	

	private static void m4() {
		
		// Operator + minBy(), maxBy()
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(10);
		list1.add(10);
		list1.add(10);
		list1.add(10);
		
		// 내림차순 정렬
		// Collections.sort() : 값형( + 문자열, Calendar)에만 적용
		// obj.sort() : 위의 자료형 + 복합형(객체) 모두 적용 
		Collections.sort(list1); // 오름차순
		Collections.reverse(list1); // 뒤집기
		System.out.println(list1);
		
	
		list1.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
			
				return o2 - o1;
			}
			
		});
		System.out.println(list1);
		
		List<Ticket> list2 = new ArrayList<Ticket>();
		
		list2.add(new Ticket("신과 함께", 14000));
		list2.add(new Ticket("강철비", 13000));
		list2.add(new Ticket("1987", 15000));
		
		// 오름차순 -> 정렬 기준?
		// 질문]
		// 1. sort() 에러 발생 이유? -> Ticket이 Comparator(Comparable)를 구현하지 않아서
		// 2. 해결책?
		//  a. Ticket이 Comparable을 구현 : 대상 클래스내에서 구현 (빈번)
		//  b. Sort() + Comparator를 구현 : 외부에서 구현 (드문 경우)
		//     b.1 Comparator -> 익명 클래스를 사용해서 구현
		//     b.2 Comparator -> 람다식으로 구현 
		Collections.sort(list2);
		System.out.println(list2);
		
		list2.sort(new Comparator<Ticket>() {

			@Override
			public int compare(Ticket o1, Ticket o2) {

				return o2.getPrice() - o1.getPrice();
			}
			
		});
		System.out.println(list2);
		
		list2.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
		System.out.println(list2);
		
		
		Ticket t1 = new Ticket("조선 명탐정", 13000);
		Ticket t2 = new Ticket("염력", 14000);
		
		// 함수형 인터페이스
		// 1. 디폴트 메소드 (객체 메소드)
		// 2. 정적 메소드(정적 메소드)
		
		// minBy() : Comparator를 매개변수로 넣어주면 그 중 더 작은 값을 반환 
		BinaryOperator<Ticket> o1 = BinaryOperator.minBy((a, b) -> a.getPrice() - b.getPrice());
		System.out.println(o1.apply(t1, t2));
		
		o1 = BinaryOperator.maxBy((a, b) -> a.getPrice() - b.getPrice());
		System.out.println(o1.apply(t1, t2));
		
		
	}

	private static void m3() {
		
		// Predicate + and(), or(), negate(), isEqual()
		// - &&, ||, !
		
		//Predicate<Integer>
		IntPredicate p1 = n -> n % 2 == 0;
		System.out.println(p1.test(10));
		System.out.println(p1.test(3));
		System.out.println();
		
		IntPredicate p2 = n -> n % 3 == 0;
		System.out.println(p2.test(10));
		System.out.println(p2.test(3));
		System.out.println();
		
		// p1 && p2 (p1도 만족하고 p2도 만족해야함)
		IntPredicate p3 = p1.and(p2);
		System.out.println(p3.test(9));
		System.out.println(p3.test(6));
		
		IntPredicate p4 = n -> (n % 2 == 0) && (n % 3 == 0);
		
		IntPredicate p5 = p1.or(p2);
		System.out.println(p5.test(9));
		System.out.println(p5.test(7));
		System.out.println();
		
		// !p1
		IntPredicate p6 = p1.negate();
		System.out.println(p1.test(10));
		System.out.println(p6.test(10));
		
		
		
	}

	private static void m2() {
		
		// Function + andThen()
		Address address = new Address("대한민국", "서울");
		Member hong = new Member("홍길동", "hong", address);
		
		Function<Member, Address> f1 = m -> m.getAddress();
		Function<Address, String> f2 = addr -> addr.getCity();
		
		System.out.println(f1.apply(hong));
		System.out.println(f2.apply(address));
		System.out.println();
		
		// f3의 매개변수 = f1의 매개변수
		// f3의 반환값 = f2의 반환값 
		Function<Member, String> f3 = f1.andThen(f2);
		System.out.println(f3.apply(hong));
		
		Function<String, String> f4 = city -> { 
			if (city.equals("서울") || city.equals("경기"))
				return "도심";
			else 
				return "변두리";
		};
		
		String result = f1.andThen(f2).andThen(f4).apply(hong);
		System.out.println(result);
	}

	private static void m1() {
		
		// 함수형 인터페이스
		// - 람다 메소드를 호출하기 위한 추상 메소드 제공
		// - 기타 추가 메소드 제공
		
		// Consumer + andThen()
		Address address = new Address("대한민국", "서울");
		Member hong = new Member("홍길동", "hong", address);
		
		// 보통 Consumer
		Consumer<Member> c1 = (m) -> System.out.println("c1 : " + m.getName());;
		c1.accept(hong);
		
		Consumer<Member> c2 = (m) -> System.out.println("c2 : " + m.getId());
		c2.accept(hong);
		System.out.println();
		
		// andThen()
		Consumer<Member> c3 = c1.andThen(c2);
		c3.accept(hong);
		System.out.println();
		
		
		Consumer<Member> c4 = c2.andThen(c1);
		c4.accept(hong);
		System.out.println();
		
		Consumer<Member> c5 = (m) -> System.out.println("c5 : " + m.getAddress().toString());
		Consumer<Member> c6 = c1.andThen(c5).andThen(c2);
		c6.accept(hong);
		
		Consumer<Member> c7 = c6.andThen(c3).andThen(c1).andThen(c4);
		c7.accept(hong);
		
		Consumer<Member> c8 = m -> { // 사실상 이것과 같음 
			c6.accept(m);
			c3.accept(m);
			c1.accept(m);
			c4.accept(m);	
		};
		
	}
}
class Address {
	
	private String country;
	private String city;
	
	public Address(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [country = " + country + ", city = " + city + "]";
	}
	
}

class Member {
	
	private String name;
	private String id;
	private Address address; // ***
	
	// Source > Generate Constructor using Fields
	// Source > Generate Getters and Setters
	// Source > Generate toString()
	
	public Member(String name, String id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [name = " + name + ", id = " + id + ", address = " + address + "]";
	}	
	
}

class Ticket implements Comparable<Ticket> {
	
	private String name;
	private int price;
	
	public Ticket(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Ticket other) {
		
		return this.price - other.price;
	}
	
	
}

class Calculator {
	
	public static int aaa(int a, int b) {
		return a + b;
	}
	
	public int bbb(int a, int b) {
		return a + b;
	}
	
}