package com.test.access;

import java.util.ArrayList;

import com.test.example.Red;

public class Yellow extends Red {
	public void check() {
		
			Red red = new Red();
		
			// default 접근 지정자는 같은 패키지에 있는 모든 클래스에게는 보여지고, 다른 패키지에 있는 모든 클래스에게는 감춰진다.
		
			// 같은 패키지 : public 처럼
			// 다른 패키지 : private 처럼
		
			// protected
			//   - 패키지 같을 때 : public 처럼 
			//   - 패키지 다르면 : private 처럼
			//   - 패키지 상관없이 자식 클래스이면 : public 처럼
			//System.out.println(this.a); // private
			//System.out.println(this.b); // default
			System.out.println(this.c); // protected
			System.out.println(this.d); // public (100% open) 
			ArrayList<String> list = new ArrayList<String>();
	
	}
}
