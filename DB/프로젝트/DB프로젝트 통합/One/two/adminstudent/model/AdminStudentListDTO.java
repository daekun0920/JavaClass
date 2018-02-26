package adminstudent.model;

/*
관리자 - 6. 교육생계정관리
AdminStudentClass
list()에 쓰임

*/
public class AdminStudentListDTO {

	private String seq;
	private String name;
	private String ssn;
	private String sseq;
	private String tel;
	private String regdate;
	private String statusCount;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSseq() {
		return sseq;
	}
	public void setSseq(String sseq) {
		this.sseq = sseq;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getStatusCount() {
		return statusCount;
	}
	public void setStatusCount(String statusCount) {
		this.statusCount = statusCount;
	}
	
	
	
	
	
	
}
