package adminteacher.model;
/*
관리자 - 3. 교사계정관리
AdminTeacherClass
list()에 쓰임

*/
public class AdminTeacherListDTO {

	private String seq;	//basic_info_seq
	private String name;
	private String ssn;
	private String tel;
	private String subjectName;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
}
