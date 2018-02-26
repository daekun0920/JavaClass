package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Homework12 {
	private static Scanner scan;
	private static ArrayList<Grade> list;
	private static ArrayList<Search> SearchList;
	
	static {
		list = new ArrayList<Grade>();
		scan = new Scanner(System.in);
		SearchList = new ArrayList<Search>();
	}
	
	public static void main(String[] args) {
		
	
	/*
	 파일 입출력 - 데이터 조작
	  	- 파일 입출력 문제 . zip
	 
	 문제1.
	 리소스] 숫자.dat
	 요구사항] 아라비안 숫자를 찾아서 한글로 바꾸시오. -> 복사본으로 저장하기
	 조건] 0 -> 영, 1 -> 일, ... 9 -> 구
	 	   저장할 파일명 : 숫자_변환.dat
	 */
	
		//changeNumbers();
		
		
	 
	 /*
	 문제2.
	 리소스] 성적.dat
	 파일형식] 홍길동,47,61,73
	 		   이름, 국, 영, 수 
	 
	 요구사항] 합격자 명단을 출력하시오.
	 조건] 합격 조건 : 3과목 평균 60점 이상
	 	   과락 조건 : 40점 미만
	 결과] 홍길동
	 	   하하
	 	   정형돈
	 사용] 컬렉션 사용해서..(Ex77 예제)
	 
	 */
	//getGrade();
		
		
	/*
	 문제3. - 문제1과 동일
	 리소스] 이름수정.dat
	 요구사항] '유재석'을 '메뚜기'로 수정하시오.
	 조건] 이름수정_변환.dat
	 */
	// fixName();
	
	 /*
	 문제4.
	 요구사항] 임의의 숫자를 10개를 입력받아 파일에 저장하시오.
	 입력] 숫자 : 5
	 	   숫자 : 3
	 	   숫자 : 100
	 	   숫자 : 22
	 	   ..
	 
	 파일저장] 
	 100	 
	 22
	 5
	 3
	 
	 조건] 배열 or 컬렉션 사용하지 말 것 (스트림을 적을때 판단)
	 */
		//randomNum();
		
		
		
	 /*
	 문제5.
	 리소스] 일기.dat
	 요구사항] 적혀있는 문장들을 역순으로 저장하시오.
	 조건] 일기_역순.dat
	 */
	// load();
	
	
	
	
	/*
	 ----------------------------------------------------------------
	 
	 
	 문제6.
	 리소스] 단일검색.dat
	 요구사항] 이름을 검색 -> 해당 회원의 모든 정보를 출력하시오.
	 입력] 이름 : 홍길동
	 출력] 
	 번호 : 33
	 이름 : 홍길동
	 주소 : 서울시 강남구 역삼동
	 전화 : 010-2345-6778
	 */
		//searchPerson();
	 
		
		
	 /*  
	 문제7.	// ArrayList 2개? 
	 리소스] 검색_회원.dat, 검색_주문.dat 
	 (회원번호, 이름, 주소)		(주문번호, 물품이름, 수량, 회원번호) 
	 요구사항] 이름을 검색 -> 주문내역을 출력하시오. (한사람이 여러개의 주문이 있을수있다는 가정하에)
	 입력] 회원명 : 홍길동
	 출력] 구매내역
	 [번호]   [이름]   [상품명]   [개수]   [배송지]
	 3 		  홍길동	마우스     3  		서울시 강동구 길동
	 
	 사용] 컬렉션 사용
	 */
		
		// searchOrder();
		
	 /*
	  
	 문제8.
	 리소스] 괄호.java
	 요구사항] 괄호들이 쌍이 맞는지 안맞는지 검사?
	 결과] 올바른(올바르지 않은) 소스입니다. (바르게 직접 수정후) -> 올바른 소스입니다.
	 대상] (), {}
	 사용] stack  (필수는 x)
	 
	 while ((line = ... -> charAt -> 메소드로 짝찾기?
	 
	
	 
	 */
		
		//searchBracket();
		
		
	 /*
	 문제9.
	 리소스] 자바소스.java, 자바예약어.dat
	 요구사항] 소스에서 예약어가 총 몇회 사용되었는지?
	 결과]
	 if : 5회
	 continue : 2회
	 ..
	 abstract : 0회
	 
	 HashMap, ArrayList
	 
	 stack에( (, { ) 넣어서 ), } 짝 찾으면 pop , indexof 로 주석 제외하고 문자열 변수에 넣어서 검사 
	 결과적으로 스택이 비었으면 올바른코드 비지 않았으면 틀린 코드    
	 
	 */
		//countTimes();

		
	 /*
	 문제10.
	 리소스] 출결.dat  날짜,이름,출근시간,퇴근시간
	 요구사항] 각 직원별로 지각횟수, 조퇴횟수를 카운트하시오.
	 조건] 출근 : 정각 9시
	       퇴근 : 정각 6시 
	 
	 결과] 총카운트
	 추가] 날짜별 카운트
	 */
		
	
	}


	private static void countTimes() {
		/*
		 문제9.
		 리소스] 자바소스.java, 자바예약어.dat
		 요구사항] 소스에서 예약어가 총 몇회 사용되었는지?
		 결과]
		 if : 5회
		 continue : 2회
		 ..
		 abstract : 0회
		 
		 indexof -> 카운트 -> 해당 예약어 부분 삭제 -> 다시 검색 -> indexof 가 안나올때까지
		 
		 */
		String pathSource = "D:\\Class\\Java\\파일_입출력_문제\\자바소스.java";
		String javaReserve = "D:\\Class\\Java\\파일_입출력_문제\\자바예약어.dat";
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(javaReserve));
			BufferedReader reader2 = new BufferedReader(new FileReader(pathSource));
					
			String line = "";
			String line2 = "";
			
			while((line = reader.readLine()) != null) {
				map.put(line, 0);
			}
			
			while((line = reader.readLine()) != null) {
				
				while ((line2 = reader2.readLine()) != null) {
					
					for (int i = 0; i < line2.length(); i++) {
						if (line2.contains(line)) {
							map.put(line, map.get(line) + 1);
						}
						
					}
				
				}
				
			}
			reader.close();
			
			for (String key : map.keySet()) {
				System.out.printf("%s : %d회", key, map.get(key));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("countTimes : " + e.toString());
		}
		
		
		
		
		
		
		
		
		
		
	}


	private static void searchBracket() {
		/*
		  
		 문제8.
		 리소스] 괄호.java
		 요구사항] 괄호들이 쌍이 맞는지 안맞는지 검사?
		 결과] 올바른(올바르지 않은) 소스입니다. (바르게 직접 수정후) -> 올바른 소스입니다.
		 대상] (), {}
		 사용] stack  (필수는 x)
		 
		 while ((line = ... -> charAt -> 메소드로 짝찾기?
		 
		 문자열 변수에 저장 -> 한글자씩 검사 -> stack에 삽입 -> 반대쪽 괄호 검사 
		 -> stack이 비면 올바른코드 -> 비지 않으면 틀린코드
		 
		 */
//		try {
//			String path = "D:\\Class\\Java\\파일_입출력_문제\\괄호.java";
//			
//			BufferedReader reader = new BufferedReader(new FileReader(path));
//			Stack<Character> stack = new Stack<Character>();
//			String line = "";
//			
//			while ((line = reader.readLine()) != null) {
//				
//				if (!line.startsWith("//") && !line.contains("//")) {
//					for(int i = 0; i < line.length(); i++) {
//						stack.push(line.charAt('('));
//						stack.push(line.charAt('{'));
//					
//						stack.push(line.charAt(')'));
//						stack.push(line.charAt('}'));
//					}
//					
//				}
//				
//			}
//			
//			reader.close();
//			while (stack.size() > 0) {
//				String pop1 = stack.pop() + "";
//				String pop2 = stack.pop() + "";
//				
//				String compPop = pop1 + pop2;
//				int count = 0;
//				
//				if (!compPop.equals("{}") || !compPop.equals("()")) {
//					count = count + 1;
//					if (count > 1) {
//						System.out.println("올바르지 않은 소스입니다.");
//					} else {
//						System.out.println("올바른 소스입니다.");
//					}
//				}
//			}
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			System.out.println("searchBracket : " + e.toString());
//		}
//		
//		
//		
		
		
	}


	private static void searchOrder() { // #7
		try {
			String path = "D:\\Class\\Java\\파일_입출력_문제\\검색_회원.dat";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			ArrayList<Order> orderList = new ArrayList<Order>();
			String line = "";
			
			System.out.print("이름을 입력해주세요 : ");
			String name = scan.nextLine();
			Order o = new Order();
			
			System.out.println("[번호]   [이름]   [상품명]   [개수]   [배송지]");
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				if (info[1].equals(name)) {
					
					// 검색할 회원의 정보
					o.setNum(info[0]);
					o.setName(info[1]);
					o.setAddress(info[2]);
					
					
					path = "D:\\Class\\Java\\파일_입출력_문제\\검색_주문.dat";
					reader = new BufferedReader(new FileReader(path));
					while((line = reader.readLine()) != null) {
						
						info = line.split(",");
						if (o.getNum().equals(info[3])) {
							// 참조형이라서 값을 바꾸면 그전에 저장한 값도 모조리 바뀐다.
							// 주문한 물품의 정보
							o.setOrderNum(info[0]);
							o.setProName(info[1]);
							o.setQuant(info[2]);
							
							System.out.printf("%s\t%s\t%s\t%s\t%s\n"
									  , o.getNum()
									  , o.getName()
									  , o.getProName()
									  , o.getQuant()
									  , o.getAddress());
						}
					}
					break;
				} else {
					continue;
				}
			} // while 
			reader.close();
		} catch (Exception e) {
			System.out.println("searchOrder : " + e.toString());
		}
	} // searchOrder(#7)


	private static void searchPerson() { // #6
		String path = "D:\\Class\\Java\\파일_입출력_문제\\단일검색.dat";
		String line = "";
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			while ((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				
				Search s = new Search(); // 완전히 다른 객체를 새로 만들어냄 
				 //s = new Search(); // 새로운 객체 참조 
				 
				s.setNum(info[0]);
				s.setName(info[1]);
				s.setAddress(info[2]);
				s.setTel(info[3]);
				
				// 기존 s와는 참조가 끊어지면 ArrayList[인덱스]를 참조변수로 new Search() 객체를 참조한다.
				SearchList.add(s); // 참조가 끊기나?
			}
			reader.close();
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			
			for (int i = 0; i < SearchList.size(); i++) {
				String nameList = SearchList.get(i).getName();
				String numList = SearchList.get(i).getNum();
				String addList = SearchList.get(i).getAddress();
				String telList = SearchList.get(i).getTel();
				
				if (nameList.equals(name)) {
					System.out.printf("\n번호 : %s\n이름 : %s\n주소 : %s\n전화 :%s\n"
									  , numList, nameList, addList, telList);
				}
				
			}
		} catch (Exception e) {
			System.out.println("searchPerson : " + e.toString());
		}
	} // searchPerson(#6)

	
	private static void randomNum() { // #4
		
		String[] nums = new String[10];
		
		for (int i = 0; i < 10; i++) {
			System.out.print("숫자 : ");
			nums[i] = scan.nextLine();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Class\\Java\\파일_입출력_문제\\랜덤숫자.dat"));
		
			for (int i = 0; i < 10; i++) {
				writer.write(nums[i] + "\r\n");
			}
			
			writer.close();
		} catch (Exception e) {
			System.out.println("randomNum : " + e.toString());
		}
		
		System.out.println("파일 작성이 완료 되었습니다.");
		
	} // randomNum(#4)


	private static void fixName() { //#3
		String path = "D:\\Class\\Java\\파일_입출력_문제\\이름수정.dat";
		String line = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String fixed = "";
			while ((line = reader.readLine()) != null) {
				if (line.contains("유재석")) {
					fixed = fixed + line.replace("유재석", "메뚜기") + "\r\n";
				} else {
					fixed = fixed + line + "\r\n";
				}
				
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			writer.write(fixed);
			
			writer.close();
			System.out.println("메뚜기 변경이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("fixName : " + e.toString());
		}
	} // fixName(#3)


	private static void getGrade() { // #2
		String path = "D:\\Class\\Java\\파일_입출력_문제\\성적.dat";
		String line = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			while ((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				
				Grade g = new Grade();
				g.setName(info[0]);
				g.setKor(info[1]);
				g.setEng(info[2]);
				g.setMath(info[3]);
				
				list.add(g);
				
			}
			reader.close();
			String passedStudents = "";
			
			for (int i = 0; i < list.size(); i++) {
				int korScore = Integer.parseInt(list.get(i).getKor());
				int engScore = Integer.parseInt(list.get(i).getEng());
				int mathScore = Integer.parseInt(list.get(i).getMath());
				
				int average = (korScore + engScore + mathScore) / 3;
				if (korScore < 40 || engScore < 40 || mathScore < 40) {
					continue;
				} else if (average < 60) {
					continue;
				} else {
					passedStudents = passedStudents + list.get(i).getName() + "\r\n";
				}
				
			}
			
			System.out.printf("[합격한 학생] \n%s", passedStudents);
		} catch (Exception e) {
			System.out.println("getGrade : " + e.toString());
		}
		
	} // getGrade(#2)


	private static void changeNumbers() { // #1
		String path = "D:\\Class\\Java\\파일_입출력_문제\\숫자.dat";
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String doc = "";
			String temp = "";
			
			while ((line = reader.readLine()) != null) {
				doc = changeToHan(line);
				temp = temp + doc + "\r\n";
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(temp);
			
			System.out.println("성공적으로 변환을 완료했습니다.");
			writer.close();
		} catch (Exception e) {
			System.out.println("changeNumbers : " + e.toString());
		}
	} // changeNumbers(#1) 


	private static String changeToHan(String line) {
		String doc;
		doc = line.replace("0", "영");
		doc = doc.replace("1", "일");
		doc = doc.replace("2", "이");
		doc = doc.replace("3", "삼");
		doc = doc.replace("4", "사");
		doc = doc.replace("5", "오");
		doc = doc.replace("6", "육");
		doc = doc.replace("7", "칠");
		doc = doc.replace("8", "팔");
		doc = doc.replace("9", "구");
		return doc;
	}

	private static void load() { // #5
		String path = "D:\\일기.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path)); // Reader와 Writer 동시에 선언하면 X 
			Stack<String> stack = new Stack<String>(); 
			
			String line = "";
			String diary = "";
			
			while ((line = reader.readLine()) != null) {
				stack.push(line);
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			while (stack.size() > 0) {
				diary = diary + stack.pop() + "\r\n";
			}
			writer.write(diary);
		
			writer.close();
			System.out.println("완료 되었습니다.");
		} catch (Exception e) {
			System.out.println("load : " + e.toString());
		}
		
	} // load (#5)
	
}
