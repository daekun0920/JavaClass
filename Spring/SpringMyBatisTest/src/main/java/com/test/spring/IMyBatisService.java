package com.test.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IMyBatisService {

	void test();
	
	void m1();
	
	int m2(int seq);
	
	int m3(String txt);

	int m4(MyBatisDTO dto);

	int m5(HashMap<String, String> map);

	void m6(ArrayList<MyBatisDTO> list);
	
	int m7();

	MyBatisDTO m8();

	List<String> m9();

	List<MyBatisDTO> m10();

	List<MyBatisDTO> m11(String order);
}
