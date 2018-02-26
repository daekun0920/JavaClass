package dataTable;

public class Board {
		private String boardIndex;		//게시글 번호
		private String boardId;			//게시글 작성자 아이디
		private String boardPw;			//게시글 작성자 패스워드 <- 게시글 수정, 삭제 시 이용
		private String boardContent;	//게시글 본문
		private String writingTime;		//게시글 작성 시간
		
		public Board(String index, String boardId, String boardPw, String boardContent, String writingTime) {	
			
			this.boardIndex = index;
			this.boardId = boardId;
			this.boardPw = boardPw;
			this.boardContent = boardContent;
			this.writingTime = writingTime;
		}
		
		public String getBoardIndex() {
			return boardIndex;
		}
		public void setBoardIndex(String boardIndex) {
			this.boardIndex = boardIndex;
		}
		public String getBoardId() {
			return boardId;
		}
		public void setBoardId(String boardId) {
			this.boardId = boardId;
		}
		public String getBoardPw() {
			return boardPw;
		}
		public void setBoardPw(String boardPw) {
			this.boardPw = boardPw;
		}
		public String getBoardContent() {
			return boardContent;
		}
		public void setBoardContent(String boardContent) {
			this.boardContent = boardContent;
		}
		public String getWritingTime() {
			return writingTime;
		}
		public void setWritingTime(String writingTime) {
			this.writingTime = writingTime;
		}

		@Override
		public String toString() {
			//return boardIndex + "\t" + boardId + "\t" + boardContent + "\t" + writingTime;
			return String.format("%s\t%s\t%s\t%s", boardIndex,  writingTime, boardId, boardContent);
		}
		
		
}
