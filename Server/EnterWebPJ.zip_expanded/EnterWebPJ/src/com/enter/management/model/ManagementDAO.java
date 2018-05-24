package com.enter.management.model;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.enter.sql.DBUtil;
import com.enter.sql.DataSource;

public class ManagementDAO {
	DataSource ds;
	Connection conn;
	
	
	public ManagementDAO() {
		try {
			
			// ds = new DataSource();
			
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("ManagementDAO.Constructor" + e.toString());
		}
	}
	
	public ArrayList<ArtistDTO> searchartists(String keyword, String type) {
		String sql = "";
		try {
			
			if (type.equals("1") || type.equals("2")) {
				sql = "SELECT member_name, artist_seq FROM vw_search_stars WHERE member_name like '%" + keyword + "%' AND type_seq =" + type;
				
			} else if (type.equals("3")) {
				sql = "SELECT group_name, artist_seq FROM vw_search_group WHERE group_name like '%" + keyword + "%'";
					
			}
			ArrayList<ArtistDTO> list = new ArrayList<>();
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			//pstat.setString(1, keyword);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				ArtistDTO dto = new ArtistDTO();
				
				dto.setName(rs.getString(1));
				dto.setArtist_seq(rs.getString(2));
				
				
				
				list.add(dto);
			}
			
			
			return list;
			
		} catch (Exception e) {
			
			
			
		}
		
		
		return null;
	}

	public ArrayList<ScheduleDTO> getSchedule(String art_seq) {
		try {
			String sql = "SELECT * FROM tbl_schedule s INNER JOIN tbl_schedule_type st ON s.schedule_type_seq = st.schedule_type_seq INNER JOIN tbl_member m ON m.member_seq = s.member_seq"
					+ " WHERE s.schedule_state_seq = ? AND s.artist_seq = ? ORDER BY schedule_seq ASC";
			
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, "1");
			pstat.setString(2, art_seq);
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
			
			while (rs.next()) {
				ScheduleDTO dto = new ScheduleDTO();
				
				dto.setName(rs.getString("schedule_name"));
				dto.setArt_seq(rs.getString("artist_seq"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setSchedule_place(rs.getString("schedule_place"));
				dto.setSchedule_start(rs.getString("schedule_start"));
				dto.setSchedule_end(rs.getString("schedule_end"));
				dto.setSchedule_pay(rs.getString("schedule_pay"));
				dto.setSchedule_type_name(rs.getString("schedule_type_name"));
				dto.setSchedule_state(rs.getString("schedule_state_seq"));
				dto.setSchedule_seq(rs.getString("schedule_seq"));
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ScheduleDTO getScheduleInfo(String schedule, String type) {
		try {
			String sql;
			
			if (type.equals("3")) {
				sql = "SELECT * FROM tbl_schedule s INNER JOIN tbl_schedule_type st ON s.schedule_type_seq = st.schedule_type_seq INNER JOIN tbl_member m ON m.member_seq = s.member_seq INNER JOIN tbl_artist aa ON aa.artist_seq = s.artist_seq INNER JOIN vw_search_group vv ON vv.artist_seq = aa.artist_seq WHERE s.schedule_seq = ?";
			} else {
				sql = "SELECT * FROM tbl_schedule s INNER JOIN tbl_schedule_type st ON s.schedule_type_seq = st.schedule_type_seq INNER JOIN tbl_member m ON m.member_seq = s.member_seq WHERE s.schedule_seq = ?";
			}
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, schedule);
			
			ResultSet rs = pstat.executeQuery();
			
			ScheduleDTO dto = new ScheduleDTO();
			System.out.println(sql);
			if (rs.next()) {
				
				dto.setMember_name(rs.getString("member_name"));
				dto.setName(rs.getString("schedule_name"));
				dto.setSchedule_place(rs.getString("schedule_place"));
				dto.setSchedule_pay(rs.getString("schedule_pay"));
				dto.setSchedule_type_name(rs.getString("schedule_type_name"));	
				dto.setSchedule_start(rs.getString("schedule_start"));
				dto.setSchedule_end(rs.getString("schedule_end"));
				dto.setSchedule_seq(rs.getString("schedule_seq"));
				dto.setArt_seq(rs.getString("artist_seq"));
				
				if (type.equals("3")) {
					dto.setStar_name(rs.getString("group_name"));
				} else {
					dto.setStar_name(getName(rs.getString("artist_seq")));
				}
			}
			conn.close();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int delSchedule(String seq) {
		try {
			
			String sql = "DELETE FROM tbl_schedule WHERE schedule_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			System.out.println(seq);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int editSchedule(ScheduleDTO dto) {
		try {
			
			String sql = "UPDATE tbl_schedule SET schedule_name = ?, schedule_place = ?, schedule_start = ?, schedule_end = ?, schedule_pay = ? WHERE schedule_seq = ?";
			System.out.println(dto.getSchedule_seq());
			System.out.println(sql);
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			java.sql.Timestamp ds = java.sql.Timestamp.valueOf(dto.getSchedule_start());
			java.sql.Timestamp de = java.sql.Timestamp.valueOf(dto.getSchedule_end());
			
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getSchedule_place());
			pstat.setTimestamp(3, ds);
			pstat.setTimestamp(4, de);
			pstat.setString(5, dto.getSchedule_pay());
			pstat.setString(6, dto.getSchedule_seq());
			
			
			int result = pstat.executeUpdate();
			
		
			
			return result;
		
		} catch (Exception e) {

		
		} 
		
		return 0;
	}

	public ArrayList<ScheduleDTO> getScheduleRequest(int startPage,
													 int endPage,
													 String isSearch,
													 String keyword,
													 String category,
													 String star,
													 String type) {
		try {
			String where = "";
			String sql = "";
			if (type.equals("1") || type.equals("2")) {
				sql = "SELECT * FROM " + 
					"    (SELECT tt.*, rownum as rnum FROM " + 
					"        (SELECT * FROM tbl_schedule s " + 
					"            INNER JOIN tbl_artist a ON s.artist_seq = a.artist_seq  " + 
					"                INNER JOIN tbl_schedule_type t ON s.schedule_type_seq = t.schedule_type_seq " +
					"					INNER JOIN tbl_member m ON s.member_seq = m.member_seq " +
					"                    	WHERE s.schedule_state_seq = 2 AND a.artist_seq = ? ORDER BY s.schedule_seq DESC) " + 
					"    tt) WHERE (rnum >= ? AND rnum <= ?)";
			} else {
				sql = "SELECT * FROM " + 
						"    (SELECT tt.*, rownum as rnum FROM " + 
						"        (SELECT * FROM tbl_schedule s " + 
						"            INNER JOIN tbl_artist a ON s.artist_seq = a.artist_seq  " + 
						"                INNER JOIN tbl_schedule_type t ON s.schedule_type_seq = t.schedule_type_seq " +
						"					INNER JOIN tbl_member m ON s.member_seq = m.member_seq INNER JOIN vw_search_group vv ON vv.artist_seq = a.artist_seq" +
						"                    	WHERE s.schedule_state_seq = 2 AND a.artist_seq = ? ORDER BY s.schedule_seq DESC) " + 
						"    tt) WHERE (rnum >= ? AND rnum <= ?)";
				
			}
			PreparedStatement pstat = null;
			
			if (isSearch != null) {
				if (category.equals("title")) {
					
					where = " AND (schedule_name = ?)";
					
					sql = sql + where;
					
					pstat = conn.prepareStatement(sql);
					
					pstat.setInt(2, startPage);
					pstat.setInt(3, endPage);
					pstat.setString(1, star);
					pstat.setString(4, keyword);
					
				} else if (category.equals("writer")) {
					
					where = " AND (m.member_name = ?)";
					
					sql = sql + where;
					
					pstat = conn.prepareStatement(sql);
					
					pstat.setString(1, star);
					pstat.setInt(2, startPage);
					pstat.setInt(3, endPage);
					pstat.setString(4, keyword);
				}
			} else {
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, star);
				pstat.setInt(2, startPage);
				pstat.setInt(3, endPage);
			}
			
			
			
			
			ResultSet rs = pstat.executeQuery();
			
			
			ArrayList<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
			
			while (rs.next()) {
				ScheduleDTO dto = new ScheduleDTO();
				
				dto.setName(rs.getString("schedule_name"));
				dto.setArt_seq(rs.getString("artist_seq"));
				dto.setMember_seq(rs.getString("member_seq"));
				
				if (type.equals("1") || type.equals("2")) {
					dto.setStar_name(getName(rs.getString("artist_seq")));
				} else {
					dto.setStar_name(rs.getString("group_name"));
				}
				dto.setSchedule_place(rs.getString("schedule_place"));
				dto.setSchedule_start(rs.getString("schedule_start"));
				dto.setSchedule_end(rs.getString("schedule_end"));
				dto.setSchedule_pay(rs.getString("schedule_pay"));
				dto.setSchedule_type_name(rs.getString("schedule_type_name"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setSchedule_seq(rs.getString("schedule_seq"));
				
				
				list.add(dto);
			}
				
			
			
			
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	private String getName(String seq) {
		try {
			
			String sql = "SELECT member_name FROM tbl_member m WHERE m.member_seq = (SELECT member_seq FROM tbl_star WHERE star_seq = ?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			ResultSet rs = pstat.executeQuery();
			
			if (rs.next()) {
			
				String name = rs.getString("member_name");
			
			
			
				return name;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	
	public int countPosts(String seq) {
		try {
			
			String sql = "SELECT count(*) as cnt FROM tbl_schedule WHERE schedule_state_seq = 2 AND artist_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			ResultSet rs = pstat.executeQuery();
			
			rs.next();
			
			int count = rs.getInt("cnt");
			
			conn.close();
			
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public int acptSchedule(String seq, String type, String star) {
		try {
				String sql = "SELECT count(*) as cnt FROM tbl_schedule WHERE schedule_state_seq = ? AND artist_seq = ? AND (schedule_start = (SELECT schedule_start FROM tbl_schedule WHERE schedule_seq = ?) OR schedule_end = (SELECT schedule_end FROM tbl_schedule WHERE schedule_seq = ?) )";
				
				PreparedStatement pstat = conn.prepareStatement(sql);
			
				pstat.setInt(1, 1);
				pstat.setString(2, star);
				pstat.setString(3, seq);
				pstat.setString(4, seq);
				
				ResultSet rs = pstat.executeQuery();
				
				int answer = 0;
				
				if (rs.next()) {
					
					answer = rs.getInt("cnt");
					System.out.println(rs.getInt("cnt"));
					System.out.println("시퀀스 " + seq);
				}
				
				if (answer == 0) {
					sql = "UPDATE tbl_schedule SET schedule_state_seq = ? WHERE schedule_seq = ?";
					
					pstat = conn.prepareStatement(sql);
					System.out.println("시퀀스 " + seq);
					pstat.setInt(1, 1);
					pstat.setString(2, seq);
					
					
					int result = pstat.executeUpdate();
					
					conn.close();
					
					return result;
				} else {
					
					return 0;
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addoffer(ScheduleDTO dto, String type) {
		try {
			
			
			if (type.equals("1") || type.equals("2")) {
			
				String sql = "{ call proc_addoffer(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
				
				CallableStatement pstat = conn.prepareCall(sql);
				
				String sdate = dto.getSchedule_start().replace("T", " ");
				String edate = dto.getSchedule_end().replace("T", " ");
				
				
				
				pstat.setString(1, dto.getName());
				pstat.setString(2, dto.getArt_seq());
				pstat.setString(3, dto.getMember_seq());
				pstat.setString(4, dto.getSchedule_place());
				pstat.setTimestamp(5, java.sql.Timestamp.valueOf(sdate += ":00"));
				pstat.setTimestamp(6, java.sql.Timestamp.valueOf(edate += ":00"));
				pstat.setString(7, dto.getSchedule_pay());
				pstat.setString(8, dto.getSchedule_type());
				pstat.registerOutParameter(9, oracle.jdbc.OracleTypes.NUMBER);
				
				
				
				
				pstat.execute();
				
				///////
				
				BigDecimal bigDecimal;
				int result;
			
				bigDecimal = (java.math.BigDecimal)pstat.getObject(9);
			
				result = bigDecimal.toBigInteger().intValue();
				
				////////
				
				conn.close();
				
				return result;
			
			} else if (type.equals("3")) {
				String sql = "{ call proc_addoffer(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
				String group_Seq = dto.getArt_seq();
				CallableStatement pstat = conn.prepareCall(sql);
				
				String sdate = dto.getSchedule_start().replace("T", " ");
				String edate = dto.getSchedule_end().replace("T", " ");
				
				
				
				pstat.setString(1, dto.getName());
				pstat.setString(2, dto.getArt_seq());
				pstat.setString(3, dto.getMember_seq());
				pstat.setString(4, dto.getSchedule_place());
				pstat.setTimestamp(5, java.sql.Timestamp.valueOf(sdate += ":00"));
				pstat.setTimestamp(6, java.sql.Timestamp.valueOf(edate += ":00"));
				pstat.setString(7, dto.getSchedule_pay());
				pstat.setString(8, dto.getSchedule_type());
				pstat.registerOutParameter(9, oracle.jdbc.OracleTypes.NUMBER);
				
				pstat.execute();
				
				//////////////////// 그룹 스케쥴 인서트 후 개별 스케쥴에도 추가
				
				sql = "SELECT artist_seq FROM tbl_artist WHERE group_seq = ?";
				
				PreparedStatement stat = conn.prepareStatement(sql);
				
				stat.setString(1, getGroupSeq(dto.getArt_seq()));
				
				ResultSet rs = stat.executeQuery();
				
				ArrayList<String> list = new ArrayList<>();
				
				while (rs.next()) {
					
					list.add(rs.getString(1));
					
				}
				
				for (String art_seq : list) {
					if (!art_seq.equals(group_Seq) ) {
						sql = "{ call proc_addoffer(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
						System.out.println(art_seq);
						pstat = conn.prepareCall(sql);
						
						sdate = dto.getSchedule_start().replace("T", " ");
						edate = dto.getSchedule_end().replace("T", " ");
						
						System.out.println(art_seq + "아트 시퀀스");
						
						pstat.setString(1, dto.getName());
						pstat.setString(2, art_seq);
						pstat.setString(3, dto.getMember_seq());
						pstat.setString(4, dto.getSchedule_place());
						pstat.setTimestamp(5, java.sql.Timestamp.valueOf(sdate += ":00"));
						pstat.setTimestamp(6, java.sql.Timestamp.valueOf(edate += ":00"));
						pstat.setString(7, dto.getSchedule_pay());
						pstat.setString(8, dto.getSchedule_type());
						pstat.registerOutParameter(9, oracle.jdbc.OracleTypes.NUMBER);
						
						pstat.execute();	
					}
				} // for

				BigDecimal bigDecimal;
				int result;
			
				bigDecimal = (java.math.BigDecimal)pstat.getObject(9);
			
				result = bigDecimal.toBigInteger().intValue();
				
				return result;
				
				
				
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	private String getGroupSeq(String art_seq) {
		try {
			String sql = "SELECT group_seq FROM tbl_artist WHERE artist_seq = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, art_seq);
			
			ResultSet rs = pstat.executeQuery();
			
			String gseq = "";
			
			if (rs.next()) {
				
				gseq = rs.getString("group_seq");
				
			}
			
			
			return gseq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<StaffDTO> getStaffs() {
		try {
			String sql = "SELECT s.staff_seq, m.member_name FROM tbl_staff s INNER JOIN tbl_member m ON s.member_seq = m.member_seq WHERE s.staff_seq NOT IN (SELECT staff_seq FROM tbl_staff_matching) ORDER BY m.member_seq";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<StaffDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				StaffDTO dto = new StaffDTO();
				
				dto.setStaff_seq(rs.getString(1));
				dto.setStaff_name(rs.getString(2));
			
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public StaffDTO currstaff(String stafftype, String star) {
		try {
			String sql = "SELECT count(*) as cnt FROM tbl_staff_matching WHERE artist_seq = ? AND staff_type_seq = ?";
			
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, star);
			pstat.setString(2, stafftype);
			
			ResultSet rs = pstat.executeQuery();
			
			int cnt = 0;
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
				
			}
			
			StaffDTO dto = new StaffDTO();
			
			if (cnt == 0) {
				dto = new StaffDTO();
				
				dto.setStaff_name("지정된 스태프가 없습니다.");
				dto.setStaff_seq("0");
				
				
			} else {
				sql = "SELECT mm.member_name, m.staff_seq FROM tbl_staff_matching m INNER JOIN tbl_staff s ON m.staff_seq = s.staff_seq INNER JOIN tbl_member mm ON mm.member_seq = s.member_seq WHERE m.artist_seq = ? AND m.staff_type_seq = ?";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, star);
				pstat.setString(2, stafftype);
				
				rs = pstat.executeQuery();
				
				if (rs.next()) {
					dto = new StaffDTO();
					
					dto.setStaff_name(rs.getString(1));
					dto.setStaff_seq(rs.getString(2));
					
					
				}
			}
			
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public int changeStaff(StaffDTO dto, String star) {
		try {
			String sql = "{ call proc_match_staff(?, ?, ?, ?) }";
			
			CallableStatement cstat = conn.prepareCall(sql);
			System.out.println("hello!");
			cstat.setString(1, dto.getStaff_seq());
			cstat.setString(2, star);
			cstat.setString(3, dto.getStaff_type());
			cstat.registerOutParameter(4, oracle.jdbc.OracleTypes.NUMBER);
			
			cstat.execute();
			
			
			BigDecimal bigDecimal;
			int result;
		
			bigDecimal = (java.math.BigDecimal)cstat.getObject(4);
		
			result = bigDecimal.toBigInteger().intValue();
			
			return result;			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
