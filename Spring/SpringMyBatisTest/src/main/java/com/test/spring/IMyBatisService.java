package com.test.spring;

import java.util.ArrayList;
import java.util.HashMap;

public interface IMyBatisService {

	void test();
	
	void m1();
	
	int m2(int seq);
	
	int m3(String txt);

	int m4(MyBatisDTO dto);

	int m5(HashMap<String, String> map);

	void m6(ArrayList<MyBatisDTO> list);
}
