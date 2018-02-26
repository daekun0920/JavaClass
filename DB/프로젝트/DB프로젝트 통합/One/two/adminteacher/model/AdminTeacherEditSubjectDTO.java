package adminteacher.model;
/*
관리자 - 3. 교사계정관리
AdminTeacherClass
edit_subject()에 쓰임

*/
public class AdminTeacherEditSubjectDTO {

	private String seq; //교사번호
	private String sseq; //과목번호
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSseq() {
		return sseq;
	}
	public void setSseq(String sseq) {
		this.sseq = sseq;
	}
	
	
	
	
}
