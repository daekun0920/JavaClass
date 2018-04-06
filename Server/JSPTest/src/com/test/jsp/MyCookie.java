package com.test.jsp;

import javax.servlet.http.Cookie;

public class MyCookie {
	public static String getCookie(Cookie[] cookies, String name) {
		
		for (int i = 0; i < cookies.length;i++) {
			if (cookies[i].getName().equals(name)) {
				return cookies[i].getValue();
			}
		}
		
		return null;
		
	}
}
