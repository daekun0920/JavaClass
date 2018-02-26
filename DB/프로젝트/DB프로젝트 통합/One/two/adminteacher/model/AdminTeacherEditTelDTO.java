package adminteacher.model;
/*
관리자 - 3. 교사계정관리
AdminTeacherClass
edit_tel()에 쓰임

*/
public class AdminTeacherEditTelDTO {

	private String seq; //기초정보 seq
	private String tel; //전화번호
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
