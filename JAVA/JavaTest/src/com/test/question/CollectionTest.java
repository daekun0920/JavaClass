package com.test.question;

public class CollectionTest {
	
	public static void main(String[] args) {
		
		// 컬렉션 클래스를 선언하시오.
		
		// 공통
		//  a. 멤버변수
		//  b. 생성자
		//  c. toString()
		
		// 1. ArrayList
		//   a. add
		//   b. get
		//   c. set
		//   d. remove
		//   e. size
		//   f. trimToSize
		
		// 2. HashMap -> Key를 관리하는 배열 하나, Value를 관리하는 배열 하나 총 두 배열이 있어야함
		//   a. put : 추가, 수정
		//   b. get
		//   c. remove
		//   d. size
		//   e. trimToSize
		
		// 3. Stack
		//   a. push
		//   b. pop
		//   c. size
		//   d. peek
		//   e. trimToSize
		
		// 4. Queue
		//   a. add
		//   b. poll
		//   c. size
		//   d. peek
		//   e. trimToSize
		
		MyArrayList list = new MyArrayList();
		
		list.add("100");
		list.add("200");
		
	
		list.add(0, "100");
		System.out.println(list.size());
	
		
		
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		//System.out.println(list.get(4));
		//System.out.println(list.get(5));
		//System.out.println(list.get(6));
		//System.out.println(list);
		
		System.out.println(list.size());
		
		
		MyQueue queue = new MyQueue();
		
		queue.add("100"); //
		queue.add("200"); //
		queue.add("300"); //
		queue.add("400"); // 
		queue.add("500");
		queue.add("600");
		queue.add("700");
		queue.add("800");
		            //0123       //3456 
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.poll());
			
		}
		
//		queue.size();
//		
//		System.out.println(queue.poll());
//		queue.size();
//		
//		System.out.println(queue.peek());
//		queue.size();
//		
//		System.out.println(queue.poll());
//		queue.trimToSize();
//		
//
//		System.out.println(queue);
		
	}

}
