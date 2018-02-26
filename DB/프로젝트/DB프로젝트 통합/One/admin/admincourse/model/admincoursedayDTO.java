package admincourse.model;

//4.개설과정 날짜 course_day_list()
public class admincoursedayDTO {

	private String dayseq;
	private String daystart;
	private String dayend;

	public String getDayseq() {
		return dayseq;
	}

	public void setDayseq(String dayseq) {
		this.dayseq = dayseq;
	}

	public String getDaystart() {
		return daystart;
	}

	public void setDaystart(String daystart) {
		this.daystart = daystart;
	}

	public String getDayend() {
		return dayend;
	}

	public void setDayend(String dayend) {
		this.dayend = dayend;
	}

}
