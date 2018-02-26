package com.test.question;

public class Pen {
	
	private String color;
	private int ink;
	private static int inkSpend;
	private static int lineCount;
	private static int circleCount;
	private static int rectangleCount;
	// getter setter는 외부인을 위한것 / 내부 수정 발생시
	
	// 생성자 
	public Pen() {
//		this.color = "검정색";
//		this.ink = 100;
		
		this("검정색", 100); // 다른 생성자를 불러 코드를 단순화 시켰다.
	}
	public Pen(String color) {
		this(color, 100);
	}
	public Pen(int ink) {
		this("검정색", ink);
	}
	public Pen(String color, int ink) {
		this.color = color;
		this.ink = ink;
	}

	
	// drawLine()
	public void drawLine() {
		drawLine(1); // 중복되는 부분은 코드가 길어지니 이렇게 뺄수있다.
	}
	
	public void drawLine(int thickness) {
		if (this.ink >= (2 * thickness)) {
			System.out.printf("%s으로 선을 그렸습니다.\n", this.color);
			this.ink = this.ink - (2 * thickness);
			lineCount++;
			inkSpend = inkSpend + (2 * thickness);
		} else {
			System.out.printf("잉크가 %dml 모자랍니다.\n", (2 * thickness) - this.ink);
		}
	}
	
	// drawCircle()
	public void drawCircle() {
		drawCircle(1);
	}
	
	public void drawCircle(int thickness) {
		if (this.ink >= (3 * thickness)) {
			System.out.printf("%s으로 원을 그렸습니다.\n", this.color);
			this.ink = this.ink - (3 * thickness);
			circleCount++;
			inkSpend = inkSpend + (3 * thickness);
		} else {
			System.out.printf("잉크가 %dml 모자랍니다.\n", (3 * thickness) - this.ink);
		}
	}
	
	// drawRectangle()
	public void drawRectangle() {
		drawRectangle(1);
	}
	
	public void drawRectangle(int thickness) {
		if (this.ink >= (4 * thickness)) {
			System.out.printf("%s으로 사각형을 그렸습니다.\n", this.color);
			this.ink = this.ink - (4 * thickness);
			rectangleCount++;
			inkSpend = inkSpend + (4 * thickness);
		} else {
			System.out.printf("잉크가 %dml 모자랍니다.\n", (4 * thickness) - this.ink);
		}
	}
	
	// 최종 보고서 
	public static void report() {
		System.out.println("============= 보고서 =============");
		System.out.printf("총 잉크 사용량 : %dml\n선을 그린 횟수 : %d회\n원을 그린 횟수 : %d회\n사각형을 그린 횟수 : %d회",
							inkSpend, lineCount, circleCount, rectangleCount);
	}
	
}
