package com.test.collection;

import java.util.ArrayList;

public class Ex72_Collection {
	
	public static void main(String[] args) {
		
		// Ex72_Collection.java
		
		// 모든 컬렉션은 길이가 가변이다.
		// 모든 컬렉션은 배열이다. -> 내부에 배열을 가지고 있다.
		
		// size = 실제 방의 갯수가 아닌 현재 존재하는 아이템의 실제 갯수 
													// capacity 값 
		ArrayList<String> list = new ArrayList<String>(1025); // 2. 해결법! 딱 필요한 방만 만들기 (이 방갯수 초과하면 현재상태 (1025개) 에서 2배로 늘어남)
		
		// 내부 배열 길이 : 0
		list.add("빨강"); // 내부 배열 길이 4칸 짜리 방이 만들어진다. 
		list.add("파랑");
		list.add("노랑");
		list.add("검정");
		
		list.add("주황"); // 내부 배열 길이 : 4 -> 8 (더블링) - (기존 4개짜리 8개짜리 새로운 배열로 복사한다음 기존 4개 배열 삭제후 8개짜리 배열을 그자리로 옮김)
		
		// 4 -> 8 -> 16 -> 32 -> 64 -> 128 -> 256 -> 512 -> 1024 -> 2048 (1000여개 방 낭비) 1. 해결법?
		for (int i = 0; i < 1025; i++) {
			list.add("색상");
		}
		
		list.add("추가"); // 1025 -> 2050
		
		// 1024개의 빈공간 발생
		list.trimToSize(); // -> 1026 (현재 들어있는 아이템의 갯수에 딱 맞게 방을 줄인다) 
		
		
	}
	
}
