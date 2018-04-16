package com.test.mvc.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressDAO {
	
	private Connection conn;
	private PreparedStatement stat;
	
	
	public AddressDAO() {
		try {
			
			conn = DBUtil.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// AddOk 서블릿이 dto를 주면서 insert 해달라고~~~`
	public int add(AddressDTO dto) {
		
		try {
			
			String sql = "INSERT INTO tblAddress (seq, name, age, gender, tel, address) VALUES (address_seq.nextval, ?, ?, ?, ?, ?)";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getName());
			stat.setString(2, dto.getAge());
			stat.setString(3, dto.getGender());
			stat.setString(4, dto.getTel());
			stat.setString(5, dto.getAddress());
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}


	public ArrayList<AddressDTO> list() {
		try {
			
			
			
			String sql = "SELECT * FROM tbladdress ORDER BY name ASC";
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			while (rs.next()) {
				AddressDTO dto = new AddressDTO();
				
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
				
			}
			
			return list; // 컨트롤러에게 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
