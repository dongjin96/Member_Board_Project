package controller;


import java.util.ArrayList;

import database.File2;
import model.Board1;

public class BoardController {

	public static ArrayList<Board1> boardlist = new ArrayList<>();
	
	// 2. 메소드 
		// 게시물 등록 메소드 
		public static boolean add( Board1 board ) {//APPlication에있음
			
			
			boardlist.add(board); //보드리스트에 추가 
			// 4. 파일처리 
			
			File2.filesave(2); // int 타입을 받기로 했음  게시판 저장
			return true; // 등록 성공시 
		}
		// 게시물 상세페이지[조회] 메소드 
		public static Board1 detail( int index ) {
			
			try {
				Board1 board = boardlist.get(index);
				return board; // 검색한 게시물 반환
			}
			catch (Exception e) {
				return null; // 검색한 게시물 없을경우
			}
		}
		// 게시물 삭제 메소드 
		public static boolean delete( int index ) {
			try {
				Board1 board1 = boardlist.remove(index);
				File2.filesave(index);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		}
		// 게시물 수정 메소드 
		public static boolean update( int index , String title , String contents ) {
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;
		}
		
		
		
}
