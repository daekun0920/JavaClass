package com.test.mvc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

// 한번에 모든 SQL 읽어서 컬렉션으로 관리
public class DataSource {
	
	// *.dat 파일의 위치
	// - com.test.mvc.member.model.sql > member.dat
	// - com.test.mvc.memo.model.sql > memo.dat
	private BufferedReader reader;
	private ArrayList<String> path;
	private HashMap<String, String> sql;
	
	public DataSource() {
		// SQL이 적혀있는 파일들을 관리하는 경로들..
		path = new ArrayList<String>();
		path.add(".\\memo\\com\\test\\mvc\\member\\model\\sql");
		path.add(".\\memo\\com\\test\\mvc\\memo\\model\\sql");
		
		sql = new HashMap<String, String>();
		
		// *.dat -> (SQL) -> 컬렉션에 복사 
		load();
	}
	private void load() {
		
		for (String strPath : path) {
			File dir = new File(strPath);
			File[] files = dir.listFiles(); // *.dat 파일들
			for(File file : files) {
				if (file.getName().endsWith(".dat")) {
					//System.out.println(file.getName());
					try {
						reader = new BufferedReader(new FileReader(file));
						
						String line = "";
						while ((line = reader.readLine()) != null) {
							//System.out.println(line);
							int index = line.indexOf("|");
							sql.put(line.substring(0, index), line.substring(index + 1));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
			}
		}
		
	}
	public String get(String key) {
		if (sql.containsKey(key) ) {
			return sql.get(key);
		} else {
			return null;
		}		
	}
//	public static void main(String[] args) {
//		// 잠시 기능을 테스트하기 위한 도구
//		DataSource ds = new DataSource();
//		System.out.println(ds.get("battery.list"));
//	}
	
}
