package com.test.mvc.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mvc.sql.DBUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement stat;
	
	public BoardDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// AddOk 서블릿이 dto를 줄테니 글을 써달라고 요청
	public int add(BoardDTO dto) {
		
		try {
			
			String sql = "INSERT INTO tblBoard(seq, subject, content, id, regdate, readcount, tag, thread, depth, filename, orgfilename, notice, secret, movie) VALUES (board_seq.nextval, ?, ?, ?, DEFAULT, DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getId());
			stat.setString(4, dto.getTag());
			stat.setInt(5, dto.getThread());
			stat.setInt(6, dto.getDepth());
			stat.setString(7, dto.getFilename());
			stat.setString(8, dto.getOrgfilename());
			stat.setString(9, dto.getNotice());
			stat.setString(10, dto.getSecret());
			stat.setString(11, dto.getMovie());
			
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	// List 서블릿이 DB에서 목록 주세요.. 위임
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			String where = "";
			String ee = "";
			String tt = "";
			String eee = "";
			String inner = "";
			
		
			if (map.get("isSearch").equals("true")) {
				where = String.format("AND %s like '%%%s%%'", map.get("column"), map.get("word"));
				if (map.get("column").equals("hashtag")) {
			
					
					
					
				}
				
			}
			
			//System.out.println(where);
			
			
			// My-SQL : limit
			// Oracle : rownum
			// MS-SQL : top
			String sql = "SELECT seq,"
						+ " subject,"
						+ " id,"
						+ " (SELECT name FROM tblMember ms WHERE ms.id = b.id) as name,"
						+ " regdate,"
						+ " readcount, filename, orgfilename, depth, notice, secret, movie, "
						+ " round((sysdate - regdate) * 24 * 60) as gap,"
						+ " (SELECT count(*) FROM tblComment cc WHERE b.SEQ = cc.PSEQ) as ccount "
						+ "FROM tblBoard b WHERE notice = 1 ORDER BY seq DESC" + where;
			
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			// rs -> list
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				// 레코드 1개 -> DTO 1개
				BoardDTO dto = new BoardDTO();
				
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setGap(rs.getInt("gap"));
				dto.setCcount(rs.getInt("ccount"));
				dto.setDepth(rs.getInt("depth"));
				dto.setFilename(rs.getString("filename"));
				dto.setOrgfilename(rs.getString("orgfilename"));
				dto.setNotice(rs.getString("notice"));
				dto.setSecret(rs.getString("secret"));
				dto.setMovie(rs.getString("movie"));
				
				list.add(dto);
			}
			
			sql = "SELECT * FROM " + 
					"    (SELECT se.*," + 
					"            rownum as rnum," + 
					"            (SELECT name FROM tblMember ms WHERE ms.id = se.id) as name," + 
					"            (SELECT count(*) FROM tblComment cc WHERE se.SEQ = cc.PSEQ) as ccount," + 
					"            round((sysdate - regdate) * 24 * 60) as gap" + 
					"            FROM " + 
					"            (SELECT * FROM tblBoard WHERE notice = 0 order by thread DESC) se) WHERE rnum >= ? AND rnum <= ?" + where;
					
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, map.get("start"));
				stat.setString(2, map.get("end"));
				
				
				rs = stat.executeQuery();
				
				while (rs.next()) {
					// 레코드 1개 -> DTO 1개
					BoardDTO dto = new BoardDTO();
					
					
					dto.setSeq(rs.getString("seq"));
					dto.setSubject(rs.getString("subject"));
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setRegdate(rs.getString("regdate"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setGap(rs.getInt("gap"));
					dto.setCcount(rs.getInt("ccount"));
					dto.setDepth(rs.getInt("depth"));
					dto.setFilename(rs.getString("filename"));
					dto.setOrgfilename(rs.getString("orgfilename"));
					dto.setNotice(rs.getString("notice"));
					dto.setSecret(rs.getString("secret"));
					dto.setMovie(rs.getString("movie"));
					
					list.add(dto);
				}
				
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	// View 서블릿이 글번호를 줄테니 레코드(DTO)를 주세요..
	public BoardDTO get(String seq) {
		
		 try {
			
			 String sql = "SELECT b.*, (SELECT name FROM tblMember WHERE id = b.id) as name FROM tblBoard b WHERE seq = ?";
			 stat = conn.prepareStatement(sql);
			 stat.setString(1, seq);
			 
			 ResultSet rs = stat.executeQuery();
			 
			 // rs -> dto
			 BoardDTO dto = new BoardDTO();
			 
			 if (rs.next()) {
				 // 레코드 1건 -> dto 1개
				 dto.setSeq(rs.getString("seq"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setContent(rs.getString("content"));
				 dto.setId(rs.getString("id"));
				 dto.setName(rs.getString("name"));
				 dto.setRegdate(rs.getString("regdate"));
				 dto.setReadcount(rs.getInt("readcount"));
				 dto.setTag(rs.getString("tag"));
				 dto.setThread(rs.getInt("thread"));
				 dto.setDepth(rs.getInt("depth"));
				 dto.setFilename(rs.getString("filename"));
				 dto.setOrgfilename(rs.getString("orgfilename"));
				 dto.setDownloadcount(rs.getString("downloadcount"));
				 dto.setNotice(rs.getString("notice"));
				 dto.setSecret(rs.getString("secret"));
				 dto.setMovie(rs.getString("movie"));
			 }
			 
			 return dto;
			 
		 } catch (Exception e) {
			System.out.println("BoardDAO.get : " + e.toString());
		 }
		
		 return null;
		 
	}

	public void updateReadCount(String seq) {
		
		try {
			
			String sql = "UPDATE tblBoard SET readcount = readcount + 1 WHERE seq = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// EditOk 서블릿이 dto를 줄테니 수정해주세요..
	public int edit(BoardDTO dto) {
		try {
			
			String sql = "UPDATE tblBoard SET subject = ?, content = ?, tag = ?, filename = ?, orgfilename = ? WHERE seq = ?";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getSubject());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getTag());
			stat.setString(4, dto.getFilename());
			stat.setString(5, dto.getOrgfilename());
			stat.setString(6, dto.getSeq());
			
			
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String seq) {
		try {
			
			String sql = "DELETE FROM tblBoard WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			return stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	// List 서블릿이 게시물의 총 갯수를 반환해달라고 요청
	public int getTotalCount(HashMap<String, String> map) {
		try {
			String sql = "SELECT count(*) as cnt FROM tblBoard";
			String where = "";
			if (map.get("isSearch").equals("true")) {
				if (map.get("column").equals("name")) {
					sql = "SELECT count(*) FROM tblBoard WHERE name = " + map.get("word");
				}
				System.out.println(map.get("column") + " " + map.get("word"));
				
				where = String.format(" WHERE %s like '%%%s%%'", map.get("column"), map.get("word"));
				if (map.get("column").equals("hashtag")) {
					sql = "SELECT count(*) as cnt FROM tblHashTag tt INNER JOIN tblBoard b ON tt.bseq = b.seq";
					where = String.format(" WHERE %s like '%%%s%%'", "tt.tag", map.get("word"));
				}
			
				sql = sql + where;
				
				sql = sql + " AND notice = '0'";
				
			} else {
				sql = sql + " WHERE notice = '0'";
			}
			
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt("cnt"));
				return rs.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			System.out.println("getTotalCount" + "" + e.toString());
		}
		
		return 0;
	}
	
	//  AddComment 서블릿이 dto를 줄테니 댓글 써달라고 요청
	public int addcomment(CommentDTO dto) {
		try {
			
			String sql = "INSERT INTO tblComment (seq, id, content, regdate, pseq) VALUES (comment_seq.nextval, ?, ?, DEFAULT, ?)";
			
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getId());
			stat.setString(2, dto.getContent());
			stat.setString(3, dto.getPseq());
			
			
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// View 서블릿이 댓글 목록 달라고 요청
	public ArrayList<CommentDTO> clist(String pseq, String sort) {
		try {
			
				String sql = "SELECT c.*, (SELECT name FROM tblMember WHERE id = c.id) as name FROM tblComment c WHERE pseq = ? ORDER BY seq " + sort;
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, pseq);
			System.out.println(sql);
			ResultSet rs = stat.executeQuery();
			
			ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				
				// 레코드 1개 -> DTO 1개
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPseq(rs.getString("pseq"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
				
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	// DelComment 서블릿이 댓글번호 줄테니 삭제 요청
	public int delcomment(String seq) {
		try {
			
			String sql = "DELETE FROM tblComment WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			return stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	// DelComment 서블릿이 댓글 번호를 줄테니 작성자 ID를 반환
	public String getCommentId(String seq) {
		try {
			
			String sql = "SELECT id FROM tblComment WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//EditComment 서블릿이 dto를 줄테니 댓글을 수정해달라고 요청
	public int editcomment(CommentDTO dto) {
		try {
			
			String sql = "UPDATE tblComment SET content = ? WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getContent());
			stat.setString(2, dto.getSeq());
			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	// AddOk 서블릿이 가장 큰 thread값 주세욧..
	public int getThread() {
		try {
			
			String sql = "SELECT nvl(max(thread), 0) + 1000 FROM tblBoard"; // nvl : null 값 처리
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;	
		
		
		
	}

	// AddOk 서블릿이 부모 thread와 이전 thread 줄테니 그 사이 -1 업데이트...
	public void updateThread(int pthread, int prevThread) {
		try {
			
			String sql = "UPDATE tblBoard SET thread = thread - 1 WHERE thread > ? AND thread < ?"; // BETWEEN 은 포함이라 비교연산자 사용
			
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, prevThread);
			stat.setInt(2, pthread);

			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateDownloadCount(String seq) {
			try {
				
				String sql = "UPDATE tblBoard SET downloadcount = downloadcount + 1 WHERE seq = ?";
				
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, seq);
				
				stat.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	// EditOk 서블릿이 건내준 글의 파일명을 없애달라고..
	public void updateFileName(String seq) {
		try {
			
			String sql = "UPDATE tblBoard SET filename = null, orgfilename = null WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	// Good 서블릿이 좋아요/싫어요 버튼 눌러주세요.
	public int addGood(GoodDTO dto) {
		try {
			
			String sql = "INSERT INTO tblGood (seq, state, id, bseq) VALUES (good_seq.nextval, ?, ?, ?)";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getState());
			stat.setString(2, dto.getId());
			stat.setString(3, dto.getBseq());
			
			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	// View 서블릿이 좋아요/싫어요 총 카운트 달라고 요청
	public GoodResultDTO getGoodResult(String seq) {
		
		try {
			
			String sql = "SELECT" + 
					"(SELECT count(*) FROM tblGood WHERE bseq = ? AND state = 'g') as good," + 
					"(SELECT count(*) FROM tblGood WHERE bseq = ? AND state = 'b') as bad " + 
					"FROM dual";
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			stat.setString(2, seq);
			
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				GoodResultDTO dto = new GoodResultDTO();
				
				dto.setGood(rs.getInt("good"));
				dto.setBad(rs.getInt("bad"));
				
				return dto;
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	// Good 서블릿이 현재 good 상태를 확인하고자 요청
	public GoodDTO checkGood(GoodDTO dto) {
		
		try {
		
			String sql = "SELECT * FROM tblGood WHERE bseq = ? AND id = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getBseq());
			stat.setString(2, dto.getId());
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				GoodDTO gdto = new GoodDTO();
				gdto.setSeq(rs.getString("seq"));
				gdto.setState(rs.getString("state"));
				gdto.setId(rs.getString("id"));
				gdto.setBseq(rs.getString("bseq"));
				
				return gdto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// Good 서블릿이 good 상태 바꿔달라고 요청
	public int editGood(GoodDTO dto) {
		try {
			
			String sql = "UPDATE tblGood SET state = ? WHERE id = ? AND bseq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, dto.getState());
			stat.setString(2, dto.getId());
			stat.setString(3, dto.getBseq());
			
			
			return stat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void delgood(String seq) {
		try {
			
			String sql = "DELETE FROM tblGood WHERE seq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			
			stat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void addHashTag(String t, String seq) {
		try {
			
			String sql = "INSERT INTO tblHashTag (seq, tag, bseq) VALUES (hashtag_seq.nextval, ?, ?)"; 
				
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, t);
			stat.setString(2, seq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// AddOk 서블릿이 방금 쓴글의 번호를 달라고 요청
	public String getSeq() {
		try {
			
			String sql = "SELECT max(seq) FROM tblBoard"; // nvl : null 값 처리
			
			stat = conn.prepareStatement(sql);
			
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<String> listHashTag(String seq) {
		try {
			
			String sql = "SELECT tag FROM tblHashTag WHERE bseq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			ResultSet rs = stat.executeQuery();
			
			
			ArrayList<String> tlist = new ArrayList<>();
			while (rs.next()) {
				
				
				tlist.add(rs.getString(1));
				
			}
			
			return tlist;
		} catch (Exception e) {
		}
		return null;
	}

	public void delTags(String seq) {
		try {
			
			String sql = "DELETE FROM tblHashTag WHERE bseq = ?";
			
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
