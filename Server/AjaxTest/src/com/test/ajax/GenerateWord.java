package com.test.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GenerateWord {

	public static void main(String[] args) {
		
		String txt = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti minima quas praesentium obcaecati dignissimos recusandae libero at esse quam dicta soluta ullam illo iusto vitae autem distinctio nisi earum facere a blanditiis. Repellendus dolore voluptatum illum voluptatem sunt. Rerum esse officia veritatis saepe necessitatibus ullam labore porro pariatur impedit nobis! Minus laudantium sunt quasi itaque nam dolor accusamus quia fugiat necessitatibus voluptates commodi repellendus iure doloremque tempora officia dignissimos sequi harum qui nulla dolorum sed deserunt accusantium similique. Asperiores enim dignissimos ab libero maxime sequi assumenda voluptas corporis cumque distinctio beatae eum deleniti nemo vitae fugit. Excepturi velit error esse!";
		
		txt.replace(",", "").replace(".", "").replace("!", "");
		
		String[] temp = txt.split(" ");
		try {
			
			Connection conn = DBUtil.open();
			
			PreparedStatement stat = null;
			
			String sql = "insert into tblWord (word) values (?)";
			
			
		for (String word : temp) {
			System.out.println(word);
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, word);
			
			stat.executeUpdate();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
