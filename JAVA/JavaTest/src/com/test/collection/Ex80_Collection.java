package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Ex80_Collection {
	
	public static void main(String[] args) {
		
		// Ex80_Collection.java
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		m9();
	
	}

	private static void m9() {
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		
		
		list.add(new Employee("남궁대리", 30, 350, 100, Position.대리, 2010, 5, 20));
		list.add(new Employee("이원", 45, 550, 200, Position.부장, 2005, 9, 10));
		list.add(new Employee("김과장", 60, 400, 200, Position.과장, 2008, 8, 15));
		list.add(new Employee("이사원", 25, 200, 50, Position.사원, 2012, 7, 12));
		list.add(new Employee("한사원", 24, 300, 100, Position.사원, 2017, 1, 25));
		
		System.out.println(list);
		
		// 정렬
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {

				return o1.getName().length() - o2.getName().length();
			}
			
		});
		
		System.out.println(list);
		
		System.out.println("===나이순===");
		System.out.println(list);
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return o1.getAge() - o2.getAge();
			}
			
		});
		System.out.println(list);
	
		
		System.out.println("===급여순===");
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return (o1.getSalary() + o1.getBonus()) - (o2.getSalary() + o2.getBonus());
			}
			
		});
		
		System.out.println(list); 
		
		System.out.println("===직급별===");
		// System.out.println(Position.부장 > Position.과장);
		System.out.println(Position.부장.ordinal()); // 0
		System.out.println(Position.과장.ordinal()); // 1
		System.out.println(Position.대리.ordinal()); // 2
		System.out.println(Position.사원.ordinal()); // 3
		
		list.sort(new Comparator<Employee> () {

			@Override
			
			public int compare(Employee o1, Employee o2) {
				
				// o1 - o2 = + -> (2 - 1) -> (1 , 2) 오름차순
				// o1 - o2 = - -> (1 - 2)
				// o2 - o1 = + -> (2(o2) - 1(o1)) -> (2(o1) , 1(o2)) 
				// o2 - o1 = - -> (1(o2) - 2(o1)) -> (2(o1) , 1(o2))
				return o1.getPosition().ordinal() - o2.getPosition().ordinal();
			}
			
			
			
		});
		System.out.println(list);
		
		System.out.println("===입사일===");
		
		list.sort(new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				
				//o1.getDate() - o2.getDate()
				
				
				
				//return (int)(o1.getDate().getTime().getTime()
				//		- o2.getDate().getTime().getTime()); // 틱 값 구하기 
				
				if (o1.getDate().getTime().getTime() > o2.getDate().getTime().getTime()) {
					return 1;
				} else if (o1.getDate().getTime().getTime() < o2.getDate().getTime().getTime()) {
					return -1;
				} else {
					return 0;
				}
				
			}
			
		});
	
		
	}
	
	private static void m8() {
		
		// 순수 배열 -> 컬렉션
		
		Random rnd = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(rnd.nextInt(30) + 1); // 1 ~ 30
		}
		
		System.out.println(list);
		
		// 직접 정렬 -> 오름차순
//		for (int i = 0; i < list.size() - 1; i++) {
//			for (int j = 0; j < list.size() - 1 - i; j++) {
//				
//				// [] : indexer(인덱서) 
//				if (list.get(j) > list.get(j + 1)) {
//					
//					Integer temp = list.get(j);
//					
//					// list.get(j) = list.get(j + 1); X
//					// list.[j] = list[j + 1];
//					
//					list.set(j,  list.get(j + 1));
//					list.set(j + 1, temp);
//					
//				}
//				
//			}
//		}
		
//		System.out.println(list);
		
		// 이미 제공되는 기능으로 정렬
		// 1. 순수 배열 : Arrays.sort() // 오름차순만 가능
		// 2. 컬렉션 : 정렬 기능 // 내림차순도 가능(오름차순 정렬 선행시)
		
		// 오름차순
		// Collections.sort(list);
		
		// System.out.println(list);
		
		// 내림차순(오름차순 선행 되어야함)
		// Collections.reverse(list); // 오름차순을 먼저 하고 해야한다, 기본적으론 정렬이 아닌 단순히 역순으로 뒤집는다.
		
		// System.out.println(list);
		
		
		// 오름 차순 정렬 -> 제공되는 기술(반 조립 제품)
		//   - Comparator, Comparable
		
		// 익명 객체(1회용, 즉석) // 비교자 
		// 재사용이 없을때
		list.sort(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
				//System.out.println(o1 + " : " + o2);
				//System.out.println(list);
				// return o1 - o2; // if 조건문(비교) // 오름차순
				return o2 - o1; // 내림차순 
			}
			
		});
		
		System.out.println(list);
		
		// 재사용 가능한 정식 클래스
		// 재사용이 있을때
		list.sort(new MyComparator());
		
		
		System.out.println(list);
	}

	private static void m7() {
		// 객체 비교
		Item[] items = new Item[5];
		
		items[0] = new Item(3, "빨강");
		items[1] = new Item(5, "파랑");
		items[2] = new Item(7, "노랑");
		items[3] = new Item(2, "검정");
		items[4] = new Item(1, "하양");
		
		// 정렬
		// System.out.println(items[0] > items[1]);
		System.out.println(items[0].getNum() > items[1].getNum());
		System.out.println(items[0].getName().compareTo(items[1].getName()));
		
		// 실행 오류 : java.lang.ClassCastException: com.test.collection.Item cannot be cast to java.lang.Comparable
		// Arrays.sort(items);
		
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				
				// 사용자가 기준 선정 (오름차순)
				//if (items[j].getNum() > items[j + 1].getNum()) {
				if (items[j].getName().compareTo(items[j + 1].getName()) > 0) {	
					// 일부 프로퍼티 비교후 객체 순서 변화 
					Item temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
					
					
				}
				
			}
		} // sort for
		System.out.println(Arrays.toString(items));
		
		
		Student[] list = new Student[] {
			new Student("홍길동", 100, 90, 80),
			new Student("아무개", 70, 23, 42),
			new Student("하하하", 50, 43, 12),
			new Student("호호호", 60, 73, 22),
			new Student("무명씨", 10, 93, 32),
			
		};
		// list 배열객체의 각 객체를 toString을 Arrays의 toString으로 재덤프 ~ 
		System.out.println(Arrays.toString(list));
		
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				
				// 총점 순서대로 정렬 > 내림차순
				if (list[j].getTotal() < list[j + 1].getTotal()) {
					
					Student temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					
					
				}
				
			}
	
		}
		System.out.println(Arrays.toString(list));
	}
	private static void m6() {
		
		String[] list = {"abc", "Abd", "abE", "ABF", "ABG", "aBH"}; // 앞의 문자부터 값의 비교
		
		// Arrays.sort(list);
		// System.out.println(Arrays.toString(list));
		
		String s1 = "def";
		String s2 = "def";
		
		// System.out.println(s1 > s2);
		System.out.println(s1.compareTo(s2)); // 앞의 글자부터 하나씩 문자코드값의 비교  
											  // 결과값이 양의 정수냐, 음의 정수냐, 0 이냐가 중요함
											  // 앞에 있는 변수의 문자코드값이 더 크면 양수, 뒤에 있는 변수의 문자코드값이 더 크면 음수, 같으면 0
		
		// compareToIgnoreCase
		System.out.println(s1.compareToIgnoreCase(s2));	 // 대소문자 구분없이 비교 ***
		
		// 문자열 배열 정렬을 직접 구현
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				
				// 비교 -> 내림차순 정렬 
				if (list[j].compareToIgnoreCase(list[j + 1]) < 0) {
					String temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
				
			}
			
		}
						// list의 toString을 Arrays의 toString으로 재덤프 ~ 
		System.out.println(Arrays.toString(list));
	}

	private static void m5() {
		
		// 배열 정렬
		int [] nums = {5, 3, 2, 4, 1};
		
		System.out.println(Arrays.toString(nums));
		
		// 오름차순
		//   - 순수 배열은 내림차순 정렬이 없다.
		Arrays.sort(nums); // 직접 알고리즘을 짜는것보다 사용은 이것이 더 빠르고 효율적 // 퀵 정렬이다 카더라
		System.out.println(Arrays.toString(nums));
		
		String[] list = {"홍길동", "아무개", "유재석", "박명수", "하하", "정준하", "정형돈", "강호동", "이수근", "테스트"};
		
		System.out.println(Arrays.toString(list));
		
		// 값형 + String 에 한해서만 가능 
		Arrays.sort(list);
		System.out.println(Arrays.toString(list)); // 가나다 순서 : [강호동, 박명수, 아무개, 유재석, 이수근, 정준하, 정형돈, 테스트, 하하, 홍길동]
		
		
		
		
		// 정렬 대상
		// 1. 숫자 : 값의 비교 -> 기능
		// 2. 문자 : 값의 비교 -> 가능
		// 3. 논리 : 사용X
		// 4. 날짜 : 과거 < 미래 -> 가능 
		// 5. 문자열 : 앞의 문자부터 값의 비교 = (ABC) (ABCD) 같은경우 D를 비교할때 (ABC)의 4번째 값은 0으로 본다 > 가능
		// 6. 객체 : 조건을 선택 지정 후 -> 가능 
		
		Calendar[] times = new Calendar[5];
		
			times[0] = Calendar.getInstance();
			times[1] = Calendar.getInstance();
			times[2] = Calendar.getInstance();
			times[3] = Calendar.getInstance();
			times[4] = Calendar.getInstance();
			
			times[0].add(Calendar.DATE, 1);
			times[1].add(Calendar.DATE, -1);
			times[2].add(Calendar.DATE, 2);
			times[3].add(Calendar.DATE, -2);
			
			
			for (Calendar c : times) {
				System.out.printf("%tF\n", c);
			}
			
			Arrays.sort(times);
			System.out.println();
			
			for (Calendar c : times) {
				System.out.printf("%tF\n", c);
			}
			
			/*
			
			2017-12-25
			2017-12-26
			2017-12-27
			2017-12-28
			2017-12-29
			틱 값(정수형 long)으로 정렬했을 가능성 높음
			
			 */
			
	}
	private static void m4() {
		
		// 버블 정렬 (Bubble Sort)
		
		// 상황 -> 배열 -> 오름차순 정렬
		
		// 원본 : {5, 4, 3, 2, 1}
		
		// Step 1 : {5, 4, 3, 2, 1}
		// Step 1 : {4, 5, 3, 2, 1}
		// Step 1 : {4, 3, 5, 2, 1}
		// Step 1 : {4, 3, 2, 5, 1}
		// Step 1 : {4, 3, 2, 1, 5} // 가장 큰수가 맨 뒤로...
		
		// Step 2 : {4, 3, 2, 1, 5}
		// Step 2 : {3, 4, 2, 1, 5}
		// Step 2 : {3, 2, 4, 1, 5}
		// Step 2 : {3, 2, 1, 4, 5} // 두번째 큰수가 그 다음 뒤로..
		
		// Step 3 : {3, 2, 1, 4, 5}
		// Step 3 : {2, 3, 1, 4, 5}
		// Step 3 : {2, 1, 3, 4, 5} // 세번째로 큰수 ..
		
		// Step 4 : {2, 1, 3, 4, 5}
		// Step 4 : {1, 2, 3, 4, 5} // 완료
		
		int [] nums = {5, 4, 3, 2, 1};
		
		for (int i = 0; i < nums.length - 1; i++) {
			
			System.out.println("Step : " + (i + 1));
			
			for (int j = 0; j < nums.length - 1 - i; j++) { // 비교 & 교환
				System.out.println("Sub : " + (j + 1));
				
				if (nums[j] > nums[j + 1]) { // 우위 비교
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				} // if
				
			} // j for
			System.out.println(Arrays.toString(nums));
		} // i for
		
	}

	private static void m3() {
		
		// 정렬, Sort
		//	-> 스왑, Swap
		// 1. 버블 정렬
		// 2. 선택 정렬
		// 3. 삽입 정렬
		// ============
		// 4. 퀵 정렬 (퀵 정렬이 대체적으로 가장 무난하며 보편적으로 쓰인다)
		// 5. 힙 정렬
		// 6. 병합(머지) 정렬
		// 7. 기수 정렬 
		
		int[] nums = new int[] {10, 50, 30};
		
		// for 문 돌렸다는 전제하에 
		// 해당 방 < 다음 방
		int temp = 0;
		
		if (nums[0] < nums[1]) {
			temp = nums[0];
			nums[0] = nums[1];
			nums[1] = temp;
		}
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m2() {
		
		// 순수 배열
		String[] list = new String[] {
				"홍길동", "아무개", "하하하", "호호호", "유재석", "박명수"
			  , "정형돈", "정준하", "강호동", "이수근"
		};
		
		// 규모
		// 1. 작은 코드 > 도움말
		// 2. 큰 코드 > 구글
		// 3. 대형 코드(소규모 프로젝트 단위) > 구글, 해외 커뮤니티
		//                                            - codeproject.com
		// 4. 문제 > 구글, StackOverflow.com ***
		
		
		// *.clone();
		String[] copy = list.clone(); // 깊은 복사 
		String[] copy2 = list; // 얕은 복사
		
		list[0] = "김길동";
		
		System.out.println(copy[0]);  // 깊은 복사 
		System.out.println(copy2[0]); // 얕은 복사
	
		// 컬렉션 생성하기(X)
		List<String> temp = Arrays.asList("아무개", "하하하", "호호호");
		
		System.out.println(temp.get(0));
		
		// 순수배열 -> 컬렉션(ArrayList) 변환하기(*****)
		List<String> temp2 = Arrays.asList(list);
		
		System.out.println(temp2.toString());
		
		
		// 배열 부분 복사(깊은 복사)
		String[] temp3 = Arrays.copyOf(list, 3); // 0 ~ 2  인덱스
		System.out.println(Arrays.toString(temp3));
		
		// 배열 부분 복사 (*****)
		String[] temp4 = Arrays.copyOfRange(list, 3, 6); // 3 ~ 5  인덱스
		
		
		// 배열 비교 // int[] 는 값형이라 deepEquals가 안됨 -> Integer(참조형) 으로 변환
		Integer[] ns1 = new Integer[] {100, 200, 300};
		Integer[] ns2 = new Integer[] {100, 200, 300};
		
		System.out.println(ns1 == ns2); // 참조 변수 비교 = 주소값 비교
		System.out.println(ns1.equals(ns2)); // 위와 같음(주소값 비교 -> 오버라이드 되지 않았음)
		
		// deepEquals();
		System.out.println(Arrays.deepEquals(ns1, ns2));
		
		
		// 배열 채우기
		String[] temp5 = new String[10]; // null
		// loop -> [i] = "미정";
		// Arrays.fill(temp5, "미정"); // 모든 방을 다 채우기
		Arrays.fill(temp5, 3, 7, "미정");  // 3 ~ 6 인덱스 방만 채우기 
						   // 덤프해주는 메소드 Arrays.toString 
		System.out.println(Arrays.toString(temp5));
		
		
		
		
		
	}
	private static void m1() {
		
		// List 계열
		// 1. ArrayList
		// 2. Vector
		//  - 동일한 컬렉션
		//  - 유일한 차이 : 쓰레드 작업 시 동기화 지원 유무
		
		int[] nums1 = new int[5];
		
		nums1[0] = 10;
		nums1[1] = 30;
		nums1[2] = 20;
						  // 덤프해주는 메소드 Arrays.toString 
		System.out.println(Arrays.toString(nums1));
		
		// ----------------------------------------------------- //
		
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		nums2.add(100);
		nums2.add(300);
		nums2.add(200);
						// ArrayList.toString (조상중에 한명이 오버라이드함)
		System.out.println(nums2.toString());
		
		// ArrayList 와 똑같음 
		Vector<Integer> nums3 = new Vector<Integer>();
		
		nums3.add(1000);
		nums3.add(3000);
		nums3.add(2000);
		
		System.out.println(nums3.toString());
		
	}
	
}
class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s(%d)", this.name, this.getTotal());
	}
	
	public int getTotal() {
		
		return this.kor + this.eng + this.math;
	}
	
	
	
}

class Item {
	
	private int num;
	private String name;
	
	
	
	public Item(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [num=" + num + ", name=" + name + "]";
	}
}

class Employee {
	
	private String name; 	// 이름
	private int age;	  	// 나이
	private int salary;  	// 급여
	private int bonus;   	// 보너스
	private Position position; // 직급(enum : 열거형)
	private Calendar date;	// 입사일 
	
	public Employee(String name, int age, int salary, int bonus, Position position, int year, int month, int date) {
		
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.bonus = bonus;
		this.position = position;
		
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, date, 9, 0, 0);
		this.date = c;
	}
	
	@Override
	public String toString() {
		
		String temp = "";
		// temp = this.age + "";
		// temp = this.salary + this.bonus + "";
		// temp = this.position + "";
		temp = String.format("%tF", this.date);
		
		return String.format("%s(%s)", this.name, temp);
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
}	

enum Position {
	부장,
	과장,
	대리,
	사원
}


// list.sort()
// 정식 상속객체와 위의 즉석 객체(일회용 객체, 익명 객체) 는 동급(같다).
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1 - o2;
	}
	
}






