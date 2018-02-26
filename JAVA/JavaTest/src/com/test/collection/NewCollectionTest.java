package com.test.collection;

public class NewCollectionTest {
	public static void main(String[] args) {
		
		NewArrayList list = new NewArrayList();
		
		list.add("하나");
		list.add("둘");
		list.add(0, "둘");
		list.add(0, "둘");
		list.add(0, "둘");
		
		System.out.println(list.get(0)); // 하나
		System.out.println(list.get(1)); // 둘
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.length());
		
		// System.out.println(list.get(2)); // null
		
		// System.out.println(list.get(7)); // 오류 
		
		
		System.out.println(list.size());
		
		list.set(0,  "one");
		System.out.println(list.get(0));
		
		// list.set(2, "three");
		
		// [0] [0] [] []
		// [0] [0] [] []
		list.remove(0);
		

		//System.out.println(list.get(1));
		
	}
}
