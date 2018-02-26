package com.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex03 {
   
   public static void main(String[] args) {
      
      
      //익명개체 사용 -> 람다식 사용
      
      List<Integer>list = new ArrayList<Integer>();
      
      list.add(10); list.add(50);list.add(20); list.add(40); list.add(30);
      
      System.out.println(list);
      
      //Collections.sort(list); //단순한 + 값형(+String + 날짜)
      //list.sort(c); //사용자 정의+복잡한(객체)
      
//      list.sort(new Comparator<Integer>() {
//
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			
//			return o1 - o2;
//		}
//		
//      });
      // sort 인자값 확인하면 이해 쉬움
      list.sort((o1, o2) -> o1 - o2);
      
      Comparator<Integer> c2 = (o1, o2) -> o1 - o2;
      
      System.out.println(list);
   }
   

}




