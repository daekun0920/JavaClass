package com.test.example;

public class Time {

	// 1. 멤버 변수
	private int hour;
	private int min;
	private int sec;
	
	// 2. 생성자
	public Time() {
		this.hour = 0;
		this.min = 0;
		this.sec = 0;
	}
	
	// Time(2, 120, 30) -> Time(4, 0, 30)
	public Time(int hour, int min, int sec) {
		/*this.hour = hour;
		this.min = min;
		this.sec = sec;*/
		
		if (hour >= 0) {
			this.hour = hour;
		}
		
		if (min >= 0) {
			if (min < 60) {
				this.min = min;
			} else {
				// 60분 이상 -> 시 반올림
				// 110분
				//   -> 110 / 60 -> 1
				//   -> 100 / 60 -> 50
				this.hour = this.hour + min / 60;
				this.min = min % 60;
			}
		}
		
		if (sec >= 0) {
			if (sec < 60) {
				this.sec = sec;
			} else {
				this.min = this.min + sec / 60;
				this.sec = sec % 60;
			}
		}
	
	}
	
	// new Time(10000) -> new Time(0, 0, 10000)
	public Time (int sec) {
		// this(0, 0, sec);

		// 직접 구현
		
		
		
	}
	
	// 3. checkTime()
	public void checkTime() {
		System.out.printf("%d : %d : %d\n"
						   , this.hour, this.min, this.sec);
	}
	


}
