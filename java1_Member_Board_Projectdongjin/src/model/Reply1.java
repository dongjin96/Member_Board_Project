package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply1 {
	private String contents;
	private String writer;
	private String date;
	
	public Reply1() {}

	public Reply1(String contents, String writer) {
		
		this.contents = contents;
		this.writer = writer;
		
		Date date = new Date(); // 현재시간 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date =simpleDateFormat.format(date );
		
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

}
