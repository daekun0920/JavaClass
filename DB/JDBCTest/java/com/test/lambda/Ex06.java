package com.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ex06 {
	public static void main(String[] args) {
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
		
		
	}

	private static void m7() {
		
		List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9);
		
		// Optional 클래스
		// - 주로 집계 결과값을 저장하는 용도
		// - 약간의 추가 기능
		
//		double avg = nums.stream().mapToInt(num -> (int)num).filter(num -> num % 2 == 0).average().getAsDouble();
//		System.out.println(avg);

		OptionalDouble avg = nums.stream().mapToInt(num -> (int)num).filter(num -> num % 2 == 0).average();
		
		//System.out.println(avg.getAsDouble());
		
		if (avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		} else {
			System.out.println(0.0);
		}
		
		double avg2 = nums.stream().mapToInt(num -> (int)num).filter(num -> num % 2 == 0).average().orElse(0.0); // orElse 는 위의 if문과 같음
		
		System.out.println(avg2);
		
		
		nums.stream().mapToInt(num -> (int)num).filter(num -> num % 2 == 0).average().ifPresent(avg3 -> System.out.println("평균 : " + avg3)); // null 일때 아무 행동도 하지 않음.
		
		
	}

	private static void m6() {
		
		// 집계
		// - sum(), count(), average(), max(), min()
		List<Integer> nums = Arrays.asList(2, 4, 5, 6, 2, 4, 5, 6, 3, 7, 9, 7, 8, 4);
		
		int m = nums.stream().mapToInt(n -> (int)n).sum();
		System.out.println(m);
		
		long count = nums.stream().count();
		System.out.println(count);
		
		double avg = nums.stream().mapToInt(n -> (int)n).average().getAsDouble(); // 일반 Double로 변환
		System.out.println(avg);
		
		int min = nums.stream().mapToInt(n -> (int)n).min().getAsInt();
		System.out.println(min);
		
		int max = nums.stream().mapToInt(n -> (int)n).max().getAsInt();
		System.out.println(max);
		
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("홍길동", 100, 77, 97));
		list.add(new Student("아무개", 90, 35, 67));
		list.add(new Student("무명씨", 80, 99, 45));
		list.add(new Student("테스트", 70, 22, 87));
		list.add(new Student("하하하", 60, 77, 79));
		
		// 기본 
		list.stream().forEach(s -> System.out.println(s));
		System.out.println();
		
		// 필터
		list.stream().filter(s -> s.getAvg() >= 80).forEach(s -> System.out.println(s));
		System.out.println();
		
		// 과락 제외
		list.stream().filter(s -> {
			return (s.getKor() >= 40 && s.getEng() >= 40 && s.getMath() >= 40)
		;}).forEach(s -> System.out.println(s));
		System.out.println();
		
		// 성적순 출력
		list.stream().sorted((s1, s2) -> s2.getTotal() - s1.getTotal()).forEach(s -> System.out.println(s));
		System.out.println();
		
		// 성적순 출력(영어 성적)
		list.stream().sorted((s1, s2) -> s2.getEng() - s1.getEng()).forEach(s -> System.out.println(s));
		System.out.println();
		
		// map
		// 학생 리스트 -> 학생 평점리스트
		list.stream().mapToDouble(Student::getAvg).sorted().forEach(d -> System.out.println(d));
		System.out.println();
		
		// 학생 전체 평균?
		avg = list.stream().mapToDouble(Student::getAvg).average().getAsDouble();
		System.out.println(avg);
		
		// 영어 평균?
		avg = list.stream().mapToInt(Student::getEng).average().getAsDouble();
		System.out.println(avg);
		
		// 수학 총점 합?
		int total = list.stream().mapToInt(Student::getMath).sum();
		System.out.println(total);
		
		// 국어 가장 높은 점수?
		max = list.stream().mapToInt(Student::getKor).max().getAsInt();
		System.out.println(max);
		
		// 총점 정렬 -> 영어 점수 (다차원 정렬)
		list.stream().sorted((s1, s2) -> {
			if (s2.getTotal() > s1.getTotal()) {
				return 1;
			} else if (s2.getTotal() < s1.getTotal()) {
				return -1;
			} else {
				// return 0;
				if (s2.getEng() > s1.getEng()) {
					return 1;
				} else if (s2.getEng() < s1.getEng()) {
					return -1;
				} else {
					return 0;
				}
			}
		}).forEach(s -> System.out.println(s));
		
	} 

	private static void m5() {
		
		// 매칭
		List<Integer> nums = Arrays.asList(2, 4, 5, 6);
		
		// 요소 모두가 만족하는지?
		// nums는 모두 짝수냐?
		boolean result = nums.stream().allMatch(num -> num % 2 == 0);
		System.out.println(result);
		
		// 3의 배수가 하나라도 있는지? 
		result = nums.stream().anyMatch(num -> num % 3 == 0);
		System.out.println(result);
		
		// 짝수가 1개도 없냐?
		result = nums.stream().noneMatch(num -> num % 2 == 0);
		System.out.println(result);
		

		List<Tablet> list2 = new ArrayList<Tablet>();
		
		list2.add(new Tablet("태블릿B", 10, Tablet.Color.WHITE));
		list2.add(new Tablet("태블릿D", 10, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿G", 14, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿C", 10, Tablet.Color.WHITE));
		list2.add(new Tablet("태블릿A", 8, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿E", 8, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿F", 8, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿H", 8, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿I", 8, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿J", 8, Tablet.Color.BLACK));
		
		// list2 : 태블릿 재고
		// 재고가 모두 8인치 이상이냐?
		if (list2.stream().allMatch(t -> t.getSize() >= 8)) {
			System.out.println("모든 재고 8인치 이상");
		} else {
			System.out.println("모든 재고 8인치 이상 아님");
		}
		
		// 재고 중에 흰색 태블릿이 남아있느냐?
		if (list2.stream().anyMatch(t -> t.getColor().equals(Tablet.Color.WHITE))) {
			System.out.println("재고 중 흰색 있음");
		} else {
			System.out.println("흰색 없음");
		}
		
	}

	private static void m4() {
		
		// mapXXX()
		List<String> list = Arrays.asList("사과", "귤", "바나나", "파인애플", "포도", "오렌지", "자두", "복숭아");
		
		list.stream().forEach(item -> System.out.println(item));
		System.out.println();
		
		// 스트림 요소의 형태 변환
		list.stream().mapToInt(item -> item.length()).forEach(len -> System.out.println(len));
		System.out.println();
		
		List<Tablet> list2 = new ArrayList<Tablet>();
		
		list2.add(new Tablet("태블릿B", 10, Tablet.Color.WHITE));
		list2.add(new Tablet("태블릿D", 10, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿G", 14, Tablet.Color.BLACK));
		list2.add(new Tablet("태블릿C", 10, Tablet.Color.WHITE));
		list2.add(new Tablet("태블릿A", 8, Tablet.Color.BLACK));
	
		list2.stream().map(Tablet::getName).sorted().forEach(name -> System.out.println(name));
		System.out.println();
		
		// 1. 검정색 태블릿
		// 2. 태블릿 정보 -> 폰 정보 -> 객체 생성 -> 스트림 반환
		list2.stream()
			.filter(t -> t.getColor().equals(Tablet.Color.BLACK))
			.map(t -> {
						Phone p = new Phone("스마트폰" + t.getName().replace("태블릿", ""), t.getSize() / 2); 
						return p;
						}).forEach(p -> System.out.println(p));
		
		
		System.out.println();
		
		
	}

	private static void m3() {
		List<Integer> nums = Arrays.asList(1, 5, 2, 3, 6, 7, 8, 9, 4, 2, 3, 5, 7);
		List<String> names = Arrays.asList("홍길동", "이순신", "홍바보", "홍순신", "테스트", "아무개", "아무개", "테스트", "홍길동", "홍길동");
		
		// 중복값 제거
		nums.stream().forEach(num -> System.out.printf("%5d", num));
		System.out.println();
		
		nums.stream().distinct().filter(num -> num % 2 == 0).sorted().forEach(num -> System.out.printf("%5d", num));
		System.out.println();
		
		names.stream().distinct().forEach(name -> System.out.println(name));
		
		List<Tablet> list = new ArrayList<Tablet>();
		
		list.add(new Tablet("태블릿B", 10, Tablet.Color.WHITE));
		list.add(new Tablet("태블릿D", 10, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿G", 14, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿B", 10, Tablet.Color.WHITE));
		list.add(new Tablet("태블릿A", 8, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿E", 8, Tablet.Color.WHITE));
		list.add(new Tablet("태블릿C", 12, Tablet.Color.BLUE));
		list.add(new Tablet("태블릿F", 12, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿F", 12, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿C", 12, Tablet.Color.BLUE));
		
		list.stream().distinct().forEach(t -> System.out.println(t));
		
		Tablet a = new Tablet("태블릿Z", 10, Tablet.Color.WHITE);
		Tablet b = new Tablet("태블릿Z", 10, Tablet.Color.WHITE);
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println(a.equals(b));
		
	}

	private static void m2() {
		
		List<Tablet> list = new ArrayList<Tablet>();
		
		list.add(new Tablet("태블릿B", 10, Tablet.Color.WHITE));
		list.add(new Tablet("태블릿D", 10, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿G", 14, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿A", 8, Tablet.Color.BLACK));
		list.add(new Tablet("태블릿E", 8, Tablet.Color.WHITE));
		list.add(new Tablet("태블릿C", 12, Tablet.Color.BLUE));
		list.add(new Tablet("태블릿F", 12, Tablet.Color.BLACK));
		
		
		list.stream().filter(t -> t.getSize() >= 10).forEach(System.out::println);
		System.out.println();
		
		list.stream().filter(t -> t.getColor().equals(Tablet.Color.BLACK)).forEach(System.out::println);
		System.out.println();
		
		list.stream().filter(t -> t.getSize() >= 10 && t.getColor().equals(Tablet.Color.BLACK)).forEach(System.out::println);
		System.out.println();
		
		list.stream().filter(t -> t.getSize() >= 10 && t.getColor().equals(Tablet.Color.BLACK)).sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).forEach(System.out::println);
		System.out.println();
		
	}

	private static void m1() {
		
		// 필터링
		// - 집합의 일부를 원하는대로 걸러주는 역할
		// - filter(조건) : 조건(true/false)을 만족하는 요소만 스트림으로 반환
		List<Integer> nums = Arrays.asList(1, 5, 2, 3, 6, 7, 8, 9, 4);
		
		// 기본 스트림(요소의 처음 ~ 끝까지 탐색)
		nums.stream().forEach(num -> {
			System.out.printf("%3d", num);
		});
		
		nums.stream().forEach(num -> System.out.println(num));
		
		// 메소드 참조 
		// nums.stream().forEach(System.out::println);
		
		nums.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.printf("%3d", num));
		System.out.println();
		
		///////////////
		List<String> names = Arrays.asList("홍길동", "이순신", "홍바보", "홍순신", "테스트", "아무개");
		
		names.stream().forEach(name -> System.out.printf("%5s", name));
		System.out.println();
		
		// 홍씨
		names.stream().filter(name -> name.startsWith("홍")).forEach(name -> System.out.println(name));
		
		names.stream().filter(Ex06::checkName).forEach(Ex06::printName);
		System.out.println();
		
		
		
	} // m1 
	
	// 메소드 매개변수
	// - String... args
	// - 가변인자 리스트 
	// - 인자의 갯수가 가변적인 경우 사용
	// - printf("형식문자열", 100, true, "홍길동")
	// - printf("형식문자열", 100)
	// - printf("형식문자열", 100, true)
	
	public static void printName (String... args) {
		
		System.out.printf("%4s", args[0]);
		
	}
	
	public static boolean checkName(String name) {
		if (name.startsWith("홍")) {
			return true;
		} else {
			return false;
		}
		
	}
	
}

class Tablet {
	
	// 서브 타입(Tablet 소속)
	public enum Color {BLACK, WHITE, RED, BLUE};
	
	private String name;
	private int size;
	private Color color;
	
	// 생성자 + Getter / Setter + toString()
	public Tablet(String name, int size, Color color) {
		this.name = name;
		this.size = size;
		this.color = color;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Tablet [name=" + name + ", size=" + size + ", color=" + color + "]";
	}
	 //상태가 같은 객체를 동일 객체라고 처리하기 위한 작업
	@Override
	public int hashCode() {
		return (this.name + this.size + this.color).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tablet) {
			Tablet t2 = (Tablet)obj;
			
			
			return this.name.equals(t2.name) && this.size == t2.size && this.color.equals(t2.color);
		} else {
			return false;
		}
	}
}

class Phone {
	
	private String name;
	private int size;
	

	public Phone(String name, int size) {
		this.name = name;
		this.size = size;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Phone [name=" + name + ", size=" + size + "]";
	}
	
}

class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 총점
	public int getTotal() {
		return this.kor + this.eng + this.math;
	}
	
	// 평균
	public double getAvg() {
		return this.getTotal() / 3.0;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", getTotal()="
				+ getTotal() + ", getAvg()=" + getAvg() + "]";
	}
	
	
}



