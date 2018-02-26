package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class DataSource {

	private BufferedReader reader;
	private ArrayList<String> pathList;
	private HashMap<String, String> sqlMap;
	
	public DataSource() {
		
		pathList = new ArrayList<String>();
		
		pathList.add(".\\member\\member\\model\\sql");
		pathList.add(".\\teacher\\teacher\\model\\sql");
	
		pathList.add(".\\admin\\admincourse\\model\\sql");
        pathList.add(".\\admin\\adminsubject\\model\\sql"); 
		
		
		pathList.add(".\\two\\adminteacher\\model\\sql");
        pathList.add(".\\two\\adminstudent\\model\\sql");
		
		pathList.add(".\\ssangsystem\\admingrade\\model\\sql");
        pathList.add(".\\ssangsystem\\adminreview\\model\\sql");
		
		pathList.add(".\\student\\studentreview\\model\\sql");
	    pathList.add(".\\student\\student\\model\\sql");
	    pathList.add(".\\student\\studentinout\\model\\sql");
		
		sqlMap = new HashMap<String, String>();
		
		load();
	}
	
	private void load() {
		
		for(String strPath : pathList) {
			File dir = new File(strPath);
			File[] files = dir.listFiles();
			
			for(File file : files) {
				if(file.getName().endsWith(".dat")) {
					
					try {
						reader = new BufferedReader(new FileReader(file));
						String line = "";
						while((line = reader.readLine()) != null) {
							int index = line.indexOf("|");
							sqlMap.put(line.substring(0, index), line.substring(index+1));
							
						}
						reader.close();
					} catch (Exception e) {
						System.out.println("DataSource.load " + e.toString());
					}
				}
			}
		}
	}
	public String get(String key) {
		if (sqlMap.containsKey(key)) {
			return sqlMap.get(key);
		} else {
			return null;
		}
	}
	
}
