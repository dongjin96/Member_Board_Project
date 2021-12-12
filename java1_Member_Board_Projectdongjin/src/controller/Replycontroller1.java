package controller;


import model.Reply1;

public class Replycontroller1 {

	
	
	

	// 메소드 
	
	// 1. 댓글 저장 
	public static boolean add( int index , Reply1 reply ) { //게시물번호 와 //댓글 add 추가
						
		try {
			BoardController.boardlist.get(index).getReplylist().add(reply);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
