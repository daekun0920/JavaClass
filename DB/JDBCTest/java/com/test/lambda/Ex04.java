package com.test.lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {
	public static void main(String[] args) {
	
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
	}

	private static void m5() {
		// 디렉토리 목록
		// C:\CLASS\DB\JDBCTest 하위 목록(디렉토리 + 파일) 출력
		try {
			
			// 1. 예전 방식
			File dir = new File("C:\\CLASS\\DB\\JDBCTest");
			File[] files = dir.listFiles();
			for (File file : files) {
				System.out.printf("[%s]%s\n", file.isDirectory() ? "폴더" : "파일", file.getName());
			}
			System.out.println();
			
			// 2. Stream 사용
			//   2.a Files.list() 참조 -> 텍스트 파일 -> 텍스트 라인의 집합 스트림
			//   2.b Files.list() 참조 -> 폴더 -> 하위 요소의 집합(하위 폴더, 파일)
			Path path = Paths.get("C:\\CLASS\\DB\\JDBCTest");
			
			Stream<Path> stream = Files.list(path);
			stream.sorted().forEach(p -> System.out.println(p.getFileName())); // File(Path)
			
			stream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
	}

	private static void m4() {
		
		// 파일 -> 스트림
		
		// 파일 읽기
		try {
		
			// 1. 기존 방법
			BufferedReader reader = new BufferedReader(new FileReader("stream.txt"));
			
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
			
			// 2. Stream 사용
			reader = new BufferedReader(new FileReader("stream.txt"));
			
			Stream<String> stream = reader.lines();
			
			stream.forEach(str -> System.out.println(str));
			System.out.println();
			
			// 3. Stream 사용
			Files.lines(Paths.get("stream.txt")).forEach(Ex04::print);
			Files.lines(Paths.get("stream.txt")).forEach(System.out::println);
			Files.lines(Paths.get("stream.txt")).forEach(str -> System.out.println(str));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}
	private static void print(String line) {
		System.out.println(line);
	}
	
	private static void m3() {
		
		// 중간 메소드 <-> 최종 메소드 
		// - sorted() : 스트림의 항목들을 정렬
		List<String> list = Arrays.asList("홍길동", "아무개", "무명씨", "존도우", "제인도우", "존스미스", "야마다다로", "야마다하나코", "테스트", "하하하");
		
		list.stream().forEach(name -> System.out.println(name));
		System.out.println();
		
//		Collections.sort(list);
//		list.stream().forEach(name -> System.out.println(name));
//		System.out.println();
		
		list.stream().sorted().forEach(name -> System.out.println(name));
		System.out.println();
		
		list.stream().sorted((n1, n2) -> n2.compareTo(n1)).forEach(name -> System.out.println(name));
	}

	private static void m2() {
		
		// 스트림 종류
		// 1. 일반 스트림 : 순차 처리
		// 2. 병렬 스트림 : 병렬 처리 
		 List<String> list = Arrays.asList("홍길동", "아무개", "무명씨", "존도우", "제인도우", "존스미스", "야마다다로", "야마다하나코", "테스트", "하하하");
		 
		// 순차 처리
		long begin = System.nanoTime();
		
		Stream<String> stream = list.stream();
		// stream.forEach(name -> printName(name));
		stream.forEach(Ex04::printName);
		
		
		long end = System.nanoTime();
		System.out.printf("%.3f\n", (end - begin) / 1000000000.0);
	
		// 병렬 처리
		begin = System.nanoTime();
		
		Stream<String> pstream = list.parallelStream();
		pstream.forEach(Ex04::printName);
		
		end = System.nanoTime();
		System.out.printf("%.3f\n", (end - begin) / 1000000000.0);
	}
	private static void printName(String name) {
		System.out.println(name + "님");
	}
	
	private static void m1() {
		
		// Stream, 스트림
		// - 컬렉션, Iterator 관련 지원
		
		// 기존에 Iterator 작업을 람다식을 사용해서 구현
		List<String> list = Arrays.asList("홍길동", "아무개", "하하하", "호호호", "테스트");
		// list.add("우하하"); // 추가 삭제 불가능 -> 읽기 전용
		
		// 탐색
		// Iterator 사용 : List or Set 계열
		Iterator<String> iter = list.iterator();
		
		while (iter.hasNext()) { // 커서 전진 + 데이터 유무 확인
			System.out.println(iter.next()); // 데이터 얻기 
		}
		System.out.println();
		
		// Iterator -> Stream 사용
		Stream<String> stream = list.stream();
		
		// forEach : 컬렉션의 항목들을 순차적으로 접근(반환) -> Consumer -> 1개씩 소비 
		stream.forEach(name -> System.out.println(name));
		
		list.stream().forEach(name -> System.out.println(name));
		
		// 순수 배열
		String[] array = {"가가가", "나나나", "다다다", "라라라", "마마마"};
		
		Arrays.stream(array).forEach(item -> System.out.println(item));
		
		
		// 객체 컬렉션
		List<Ticket> list2 = Arrays.asList(new Ticket("신과 함께", 15000), new Ticket("강철비", 14000), new Ticket("염력", 14500));
		
		list2.stream().forEach(t -> System.out.printf("%s(%d원)\n", t.getName(), t.getPrice()));
		
	}
}
