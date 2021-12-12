package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.BoardController;
import controller.MemberController;
import model.Board1;
import model.Member1;

public class File2 {

	
	
	// 필드 
		
	private static String memberpath= // 회원정보를 저장하는경로
	"C:/Users/오동진/Desktop/Member_Board_Project/java1_Member_Board_Projectdongjin/src/database/memberlist.txt";
	private static String boardpath=
			"C:/Users/오동진/Desktop/Member_Board_Project/java1_Member_Board_Projectdongjin/src/database/boardlist.txt/";
	
	
	
	
	public static boolean filesave(int type) {
		
		try {
			FileOutputStream fileOutputStream = null; // 빈값주고 선언만함
			if (type==1) {//인수를 int type값으로줬음 1번은 회원저장으로 설정
				fileOutputStream = new FileOutputStream( memberpath);// 경로를 memberpath로설정했다
				
				for(Member1 member1 : MemberController.memberlist) {// 회원 리스트를 가져오기위해 반복문을 사용했다
					String outString = member1.getId()+","+member1.getPassword()+","+
							member1.getName()+","+member1.getEmail()+","+
							member1.getPoint()+"\n";
					fileOutputStream.write(outString.getBytes()); // 바이트로 내보내기~!!
				}
				
				//스트림 사용후 초기화시켜야한다 close 안하면 계속 남아있는다
				fileOutputStream.flush();// 파일스트림 초기화 
				fileOutputStream.close();//파일스트림닫기
				return true; // 파일처리 성공
			}
			
			if(type==2) { // 이번에는 게시판
				fileOutputStream = new FileOutputStream( boardpath ); //boardpath로경로를 설정한다
				for( Board1 board : BoardController.boardlist ) { // 반복문을사용해서 boardlist에서 정보를 뺴내온다
					String outstring = board.getTitle()+","+board.getContents()+","+
										board.getWriter()+","+board.getDate()+","+
										board.getView()+"\n";//구분 성공
					fileOutputStream.write( outstring.getBytes() );// 바이트로내보내기
				}// 스트림 초기화 및 닫기
				fileOutputStream.flush();
				fileOutputStream.close(); 
				return true;
		
			}
			if( type == 3 ) {}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false; // 파일처리 실패
	}
	//////////파일 보내기끝
	public static boolean fileload(int type) {
		try {
			FileInputStream fileInputStream = null;
			if (type==1) {
				fileInputStream = new FileInputStream(boardpath);// 경로를 설정한다
				byte[] bytes = new byte[10000]; // 받아올 바이트를 10000으로 제한
				
				fileInputStream.read(bytes); //바이트를 읽오와 저장
				String instring = new String(bytes); // 바이트배열을 문자열로 바꾸는 작업
				String[] members = instring.split("\n"); //split을이용해서 구분해서 저장한다(공백회원 을 추가한다)
				for(int i= 0 ; i<members.length;i++) {
					String[] field =members[i].split(","); // 반복문을 사용해서 필드명을 구분한다
					// 분리된 필드를 객체화시킨다 point 필드는 int 형으로 변환 String -> Int ( Integer.parseInt ) 포인트도 문자열로 받았으니깐  Integer.parseInt 를사용해서 int로바꾼다 
					Member1 member = new Member1( field[0] , field[1] ,  
							field[2], field[3],  
							Integer.parseInt(field[4] ));
			
			MemberController.memberlist.add(member); // 받은 객체를 리스트에 저장한다
				}
				fileInputStream.close(); // 스트림 닫기 
				return true; // 파일 불러오기 성공
			}
			if( type == 2 ) {///이번에는 게시판불러오기!!
				
				fileInputStream = new FileInputStream(boardpath); //  파일경로 boardpath로설정
				byte[] bytes = new byte[10000]; // 바이트 10000설정 10kb정도된다하낟
				fileInputStream.read( bytes );	// 바이트로 파일읽어오기
				String instring = new String(bytes); // string 으로 문자열로 변환한다
				String[] boards = instring.split("\n"); // 게시물을"\n"을사용해서 필드명 구분
				
				for( int i = 0 ; i<boards.length-1 ;i++ ) { //  반복문을사용해서 정보를 split(",")로구분하면서 Integer.parseInt를사용해서 다시 int형으로바꾼다
					String[] field = boards[i].split(",");
					Board1 board = new Board1( field[0] , field[1] , field[2], 
									field[3]  , Integer.parseInt(field[4]));
					BoardController.boardlist.add(board);
				}
				
				fileInputStream.close(); // 스트림 닫기 
				return true; // 파일 불러오기 성공
			}
			if( type == 3 ) {}
		}
		catch (Exception e) {
			System.out.println(" [알림] : 파일 불러오기 오류 발생 [ 관리자에게 문의 ]");
		}
		return false; // 파일 블러오기 실패
	}
}
