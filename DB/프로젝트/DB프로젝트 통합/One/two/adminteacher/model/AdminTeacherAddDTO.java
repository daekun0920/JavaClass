package adminteacher.model;

/*
관리자 - 3. 교사계정관리
AdminTeacherClass
add()에 쓰임

*/
public class AdminTeacherAddDTO {

	private String id;
	private String ssn;
	private String type;
	private String name;
	private String tel;
	private String subjectNum; //강의가능과목 번호
	
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
	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}
	
	
	
	
}

	
	
	

