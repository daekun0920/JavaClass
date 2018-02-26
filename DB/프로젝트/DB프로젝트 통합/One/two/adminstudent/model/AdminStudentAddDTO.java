package adminstudent.model;

/*
관리자 - 6. 교육생계정관리
AdminStudentClass
add()에 쓰임

*/

public class AdminStudentAddDTO {

	private String id;
	private String ssn;
	private String type;
	private String name;
	private String tel;
	private String eseq; //수강현황키
	private String cseq; //과정키
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEseq() {
		return eseq;
	}
	public void setEseq(String eseq) {
		this.eseq = eseq;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	
	
}
