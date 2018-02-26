package studentinout.model;

public class StudentinoutDTO {
	
	/*
	 * 
	 * 	출결 테이블 DTO
	 * 
	 * 
	 * 학생 본인의 출결시간과 출결상태를 불러오는 DTO 
	 * 
	 * (전체/월/일) 구분은 자바에서
	 * 
	 */
	private String seq;
	private String name;
	private String in;
	private String out;
	private String bigo;


	
	


	
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
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getBigo() {
		return bigo;
	}
	public void setBigo(String bigo) {
		this.bigo = bigo;
	}
}
