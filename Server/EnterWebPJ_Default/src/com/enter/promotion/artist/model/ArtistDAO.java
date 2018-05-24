package com.enter.promotion.artist.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.enter.sql.DBUtil;



public class ArtistDAO {
      private Connection conn;
      private PreparedStatement stat;
   
      //생성자
      public ArtistDAO() {
         try {
            conn = DBUtil.open();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      
      //가수나 연기자에대해 리스트 돌려주기!!
      public ArrayList<ArtistListDTO> artistList(String arttype) {
         try {
            String sql = "SELECT art.ARTIST_SEQ as artist_seq,CASE WHEN art.STAR_SEQ IS NULL THEN g2.GROUP_NAME WHEN  art.STAR_SEQ IS NOT NULL THEN m.MEMBER_ENGNAME END AS name FROM TBL_ARTIST art LEFT OUTER JOIN TBL_GROUP g2 ON art.GROUP_SEQ = g2.GROUP_SEQ LEFT OUTER JOIN TBL_STAR s on art.STAR_SEQ = s.STAR_SEQ LEFT OUTER JOIN TBL_ACTIVE a ON s.STAR_SEQ = a.STAR_SEQ LEFT OUTER JOIN TBL_GROUP g ON a.GROUP_SEQ = g.GROUP_SEQ LEFT OUTER JOIN TBL_TYPE t on art.TYPE_SEQ = t.TYPE_SEQ LEFT OUTER JOIN TBL_MEMBER m ON s.MEMBER_SEQ = m.MEMBER_SEQ WHERE  (art.STAR_SEQ IS NULL AND t.TYPE_SEQ = (SELECT TYPE_SEQ FROM TBL_TYPE WHERE TYPE_NAME = ? )) OR s.STAR_SEQ IN ( SELECT s.STAR_SEQ FROM TBL_STAR s LEFT OUTER JOIN TBL_MEMBER m ON s.MEMBER_SEQ = m.MEMBER_SEQ LEFT JOIN TBL_ACTIVE a ON s.STAR_SEQ = a.STAR_SEQ LEFT JOIN TBL_ARTIST art ON s.STAR_SEQ = art.STAR_SEQ INNER JOIN tbl_type t ON art.TYPE_SEQ = t.TYPE_SEQ WHERE a.active_seq IS null AND t.TYPE_SEQ = (SELECT TYPE_SEQ FROM TBL_TYPE WHERE TYPE_NAME = ? ))";
            
            stat = conn.prepareStatement(sql);
            stat.setString(1, arttype);
            stat.setString(2, arttype);
            
            ResultSet rs = stat.executeQuery();
            ArrayList<ArtistListDTO> list = new ArrayList<ArtistListDTO>();
            
            while (rs.next()) {
               ArtistListDTO dto = new ArtistListDTO();
               
               dto.setArtist_seq(rs.getString("artist_seq"));
               dto.setName(rs.getString("name"));

               list.add(dto);
            }
               
               return list;
               
            } catch (Exception e) {
               e.printStackTrace();
            }
            return null;
      }

  	//tbl_star_list 에 글쓰기
/*  	public int addStarList(StarListDTO dto) {
  		try {
  			
  			String sql="";
  			
  			stat = conn.prepareStatement(sql);
  			
  		
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
  		
  		return 0;
  	}
      */
      
    
      
      
      
      //tbl_star_profile 에 글쓰기!!
      public int addStarProfile(StarProfileDTO dto) {
         try {
            
            String sql = "insert into tbl_star_profile (star_profile_seq, artist_seq, profile_photo, star_profile_state) values (star_profile_seq.nextval, ?, ?, 1)";
            
            stat = conn.prepareStatement(sql);
            System.out.println(dto.getArtist_seq());
            System.out.println(dto.getProfile_photo());
            
            //아티스트 목록번호
            stat.setString(1, dto.getArtist_seq());
            //첨부파일 추가
            stat.setString(2, dto.getProfile_photo());
            
            return stat.executeUpdate();
            
         } catch (Exception e) {
            e.printStackTrace();
         }
         
         return 0;
      }

      //글 목록 요청!
      public ArrayList<StarProfileDTO> list(String member_seq) {
         try {
            
            //상관 서브쿼리
            //바깥쪽 글쓴 사람이 아이디를 토대로 이름을 불러올 수 있다.
            //바깥쪽 테이블에 alias 있어야 함
            //String sql = "select sp.star_profile_seq, sp.artist_seq, sp.profile_photo, sp.star_profile_state ,  (SELECT CASE WHEN  art.STAR_SEQ IS NULL THEN g2.GROUP_NAME WHEN  art.GROUP_SEQ = 0 THEN m.MEMBER_NAME END AS name FROM TBL_ARTIST art LEFT OUTER JOIN TBL_GROUP g2 ON art.GROUP_SEQ = g2.GROUP_SEQ LEFT OUTER JOIN TBL_STAR s on art.STAR_SEQ = s.STAR_SEQ LEFT OUTER JOIN TBL_ACTIVE a ON s.STAR_SEQ = a.STAR_SEQ LEFT OUTER JOIN TBL_GROUP g ON a.GROUP_SEQ = g.GROUP_SEQ LEFT OUTER JOIN TBL_TYPE t on art.TYPE_SEQ = t.TYPE_SEQ LEFT OUTER JOIN TBL_MEMBER m ON s.MEMBER_SEQ = m.MEMBER_SEQ WHERE  art.artist_seq = sp.ARTIST_SEQ) as starname, (SELECT count(*) FROM tbl_star_like WHERE STAR_LIKE_STATE = 1 and sp.star_profile_seq = sl.star_profile_seq) as likeCount from tbl_star_profile sp LEFT OUTER JOIN TBL_STAR_LIKE sl ON sp.STAR_PROFILE_SEQ = sl.STAR_PROFILE_SEQ order by star_profile_seq desc";
            
            String sql = "select distinct  sp.star_profile_seq, sp.artist_seq, sp.profile_photo, sp.star_profile_state ,  (SELECT CASE WHEN  art.STAR_SEQ IS NULL THEN g2.GROUP_NAME WHEN  art.STAR_SEQ IS NOT NULL THEN m.MEMBER_ENGNAME END AS name FROM TBL_ARTIST art LEFT OUTER JOIN TBL_GROUP g2 ON art.GROUP_SEQ = g2.GROUP_SEQ LEFT OUTER JOIN TBL_STAR s on art.STAR_SEQ = s.STAR_SEQ LEFT OUTER JOIN TBL_ACTIVE a ON s.STAR_SEQ = a.STAR_SEQ LEFT OUTER JOIN TBL_GROUP g ON a.GROUP_SEQ = g.GROUP_SEQ LEFT OUTER JOIN TBL_TYPE t on art.TYPE_SEQ = t.TYPE_SEQ LEFT OUTER JOIN TBL_MEMBER m ON s.MEMBER_SEQ = m.MEMBER_SEQ WHERE  art.artist_seq = sp.ARTIST_SEQ) as starname, (SELECT count(*) FROM tbl_star_like WHERE STAR_LIKE_STATE = 1 and star_profile_seq = sl.star_profile_seq) as likeCount, (select count(*) from tbl_star_like where star_profile_seq = sp.STAR_PROFILE_SEQ and member_seq = ? and STAR_LIKE_STATE = 1) as mycount from tbl_star_profile sp LEFT OUTER JOIN TBL_STAR_LIKE sl ON sp.STAR_PROFILE_SEQ = sl.STAR_PROFILE_SEQ order by star_profile_seq desc";
            
            stat = conn.prepareStatement(sql);
            stat.setString(1, member_seq);
            
            ResultSet rs = stat.executeQuery();
         
            
            //rs -> list에 옮겨담기
            ArrayList<StarProfileDTO> list = new ArrayList<StarProfileDTO>();
            
            while (rs.next()) {
               //레코드 1개 -> DTO 1개
               StarProfileDTO dto = new StarProfileDTO();
               
               dto.setStar_profile_seq(rs.getString("star_profile_seq"));
               dto.setArtist_seq(rs.getString("artist_seq"));
               dto.setProfile_photo(rs.getString("profile_photo"));
               dto.setStar_profile_state(rs.getString("star_profile_state"));
               dto.setStarname(rs.getString("starname"));
               dto.setLikeCount(rs.getString("likeCount"));
               dto.setMycount(rs.getString("mycount"));
   
               
               list.add(dto);
            }
            
            return list;
            
            
         } catch (Exception e) {
            e.printStackTrace();
         }
         
         return null;
      }

      //한번이라도 하트를 눌렀는지?
      public StarLikeDTO checkLike(StarLikeDTO dto) {
         try {
            
            /*String sql = "select * from tbl_star_like where member_seq = ? and star_profile_seq = ?";*/
            
            String sql = "select * from tbl_star_like where member_seq = ? and star_profile_seq = ?";
            
            stat = conn.prepareStatement(sql);
            stat.setString(1, dto.getMember_seq());
            stat.setString(2, dto.getStar_profile_seq());
            
            ResultSet rs = stat.executeQuery();
            
            if(rs.next()) {
               StarLikeDTO sldto = new StarLikeDTO();
               sldto.setStar_like_seq(rs.getString("star_like_seq"));
               sldto.setMember_seq(rs.getString("member_seq"));
               sldto.setStar_profile_seq(rs.getString("star_profile_seq"));
               sldto.setStar_like_state(rs.getString("star_like_state"));
               
               return sldto;
               
            }
            
            
         } catch (Exception e) {
            // TODO: handle exception
         }
         
         return null;
      }

      //하트 갯수 추가!
      public int starAddLike(StarLikeDTO dto) {
         try {
            
         
            String sql = "insert into tbl_star_like (star_like_seq, member_seq, star_profile_seq, star_like_state) values (star_like_seq.nextval ,? ,? ,?)";
            
            stat = conn.prepareStatement(sql);
            
            stat.setString(1, dto.getMember_seq());
            stat.setString(2, dto.getStar_profile_seq());
            stat.setString(3, dto.getStar_like_state());
            
            return stat.executeUpdate(); //1
            
            
         } catch (Exception e) {
            // TODO: handle exception
         }
         return 0;
      }
      
      //하트 상태 바꾸기!!
      public int editLike(StarLikeDTO dto) {
         try {
            
            String sql = "update tbl_star_like set star_like_state = ? where member_seq = ? and star_profile_seq = ?";
            //UPDATE TBL_STAR_LIKE SET STAR_LIKE_STATE = 0 WHERE MEMBER_SEQ = 157 AND STAR_PROFILE_SEQ = 8;

            
            stat = conn.prepareStatement(sql);
            
            stat.setString(1, dto.getStar_like_state());
            stat.setString(2, dto.getMember_seq());
            stat.setString(3, dto.getStar_profile_seq());
            
            return stat.executeUpdate();//성공 1
            
            
         } catch (Exception e) {
            // TODO: handle exception
         }
         return 0;
      }

      //토탈 카운트 가져오기
      public String totalcount(String star_profile_seq) {
         try {
            String sql = "select count(*) as totalcount FROM tbl_star_like WHERE STAR_PROFILE_SEQ = ? and STAR_LIKE_STATE = 1";
            
            stat = conn.prepareStatement(sql);
            stat.setString(1, star_profile_seq);
   
            ResultSet rs = stat.executeQuery();
            
            if(rs.next()) {
               return rs.getString(1);
            }
         
         } catch (Exception e) {
            // TODO: handle exception
         }
         
         return null;
      }


	public StarListDTO getStarList(String star_profile_seq) {
		// TODO Auto-generated method stub
		return null;
	}


	




      

      
}