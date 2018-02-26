package question.arraylist;

public class MyArrayList {

	//배열
	private int[] list;
		
	//현재 인덱스
	private int index;
	
	public MyArrayList() {
		
		//this.list = new int[4];
		//this.index = 0;//가장 처음에 add() 실행하면 0번째 방 추가
		this(4);
	}
	
	public MyArrayList(int initCapacity) {
		this.list = new int[initCapacity];
		this.index = 0;
	
	
	
	
	public void add(int n) {
		
		checkLength();
		
		//요소 추가(n) - 마지막 방
		this.list[this.index] = n;//append
		this.index++;//끝방 번호를 갱신		
		
	}

	private void checkLength() {
		
		//방의 갯수가 충분? -> 모자라면 확장!!
		if (this.index >= this.list.length} {
			
			//기존배열 -> 확장된 임시배열 복사
			int[] temp = new int[this.list.length * 2];
			
			//list[0] -> temp[0]
			for {int i=0; i<this.list.length; i++) {
				temp[i] = list[i];
			}
			
			this.list = temp;//갈아끼움
			
		}
		
	}
	
	
	
	//확인용
	@Override
	public String toString() {
	
		String temp = "";
		
		for (int i=0; i<this.list.length; i++) {
			temp += String.format("list[%d] = %d\n"
								, i
								, this.list[i]);
		}
		
		return String.format("length : %d\n"
				+ "this.index(size) : %d\n"
				+ "%s\n"
				, this.list.length
				, this.index
				, temp);
	}
	
	
	public int size() {
		//배열의 길이(X) -> 현재까지 넣은 데이터의 갯수 -> 요소의 갯수
		return this.index;
	}
	
	
	public int get(int index) {
		
		//없는 방번호를 요청하면?
		if (index >= this.index) {
			//에러 처리
			//System.out.println("존재하지 않는 방입니다.");
			
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return this.list[index];		
	}
	
	
	
	public void set(int index, int n) {
		
		this.list[index] = n;
	}
	
	
	public void remove(int index) {
		
		//이사
		for (int i=index; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;//***
		
	}
	
	
	
	public void add(int index, int n) {
		
		checkLength();
		
		//이사
		for (int i=this.list.length-2; i>=index; i--) {
			this.list[i+1] = this.list[i];
		}
		
		//빈방에 데이터 추가
		this.list[index] = n;
		
		//
		this.index++;
		
	}

	
	public void clear() {
		
		//A.
		//this.list = new int[4];
		
		//B.
		//for (int i=0; i<this.list.length; i++) {
		//	this.list[i] = 0;
		//}
		
		this.index = 0;//***
		
	}
	
	
	
	public void trimToSize() {
		
		int[] temp = new int[this.index];//****
		
		for (int i=0; i<temp.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
	}

	
}

