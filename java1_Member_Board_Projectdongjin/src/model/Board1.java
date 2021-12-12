package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board1 {

	// 1. 필드 
	private String title;
	private String contents;
	private String writer;
	private String date;
	private int view;
	// 하나의 게시물의 여러개 댓글 저장하기 위한 
	private ArrayList<Reply1> replylist;  // 댓글 리스트 메모리할당한다
	
	// 2. 생성자 
	public Board1() { // 빈생성자 : 메소드 호출시 또는 나중에 사용할수있으니 ,,필요
		
	}
	// 게시물 등록시 사용되는 생성자 
	public Board1(String title, String contents, String writer) {
		
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		
		Date date = new Date(); // 현재시간 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date =simpleDateFormat.format(date );
		
		this.view = 1;
		this.replylist = new ArrayList<>(); 
	}
	// 파일로드시 사용되는 생성자 
	public Board1(String title, String contents, String writer, String date, int view) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.replylist = new ArrayList<>();
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public ArrayList<Reply1> getReplylist() {
		return replylist;
	}
	public void setReplylist(ArrayList<Reply1> replylist) {
		this.replylist = replylist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}