package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Core implements ICore {

	@Autowired
	private DAO dao;
	
	@Override
	public int getCount() {

		return dao.getCount();
	}
	
}












