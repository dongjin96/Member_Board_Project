package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Properties;
import database.File2;
import model.Member1;

public class MemberController {

	
	
	public static ArrayList<Member1>memberlist = new ArrayList<>();  //model Member import 안쓰면빨간줄들어간다

	
	
	//로그인
	public static boolean login( String id , String password ) {
		for( Member1 member : memberlist ) {
			if( member.getId().equals(id) && 
					member.getPassword().equals(password) ) {
				return true; // 로그인 성공시 
			}
		}
		return false; // 로그인 실패시
	}
	//회원가입
	public static boolean signup(Member1 member) { // 회원가입 메소드이다
		if( member.getId().length()<4 ){  // 글자수 제한
			System.out.println("  ID는 4글자이상 가능 합니다"); 
			return false; 
		}
		if(member.getPassword().length() !=4) { //4글자가아니먄
			System.out.println("비밀번호는 4글자로만 설정가능합니다");
			return false;
		}
		if( member.getName().length() < 2 ) {  // 2글자이상
			System.out.println(" 이름는 2글자이상 가능 입니다"); 
			return false; 
		}
		if( !member.getEmail().contains("@") ) {  // 골뱅이가 포함되어야한다
			System.out.println("  이메일 @ 포함 가능 합니다"); 
			return false; 
		}
		
		
		// 2. ID 중복체크 [ 리스트내 동일한 아이디가 있는지 확인 ]
				for( Member1 temp : memberlist ) {
					if( temp.getId().equals( member.getId()) ) {
						System.out.println(" [알림] : 이미 사용중인 아이디 입니다");
						return false;
					}
				}
				// 3. 리스트 저장 
				memberlist.add(member);
				// 4. 파일 처리 
				File2.filesave(1);
				//File file = new File();
				//file.filesave(1);
				
				// 5. 가입메일 전송 
				sendmail(member.getEmail(), 3, "" );
				return true;
				
	
		
	}
	// 회원 리스트

	
	// 3. 아이디찾기 이름 메일을 인수로받아서 메일로보내준다 
	public static boolean forgotid( String name , String email ) {
		for( Member1 member : memberlist ) {
			if( member.getName().equals(name) &&
					member.getEmail().equals(email) ) { // 같다면 이메일보내준다
				
				
				sendmail(member.getEmail(), 1, member.getId() );//이메일 메소드를 호출하고 1. 받는사람이메일 1 (아이디찾기), 찾은아이디를가져다준다  이메일 아직 잘모르는거같다
				
				return true; // 아이디찾기 성공시  
			}
		}
		return false; // 아이디찾기 실패  
	}
	
	public static boolean forgotpassword( String id , String email ) {// 비밀번호 찾기 아이디와 이메일을 인수로받는다
		for( Member1 member : memberlist ) {
			if( member.getId().equals(id) && 
					member.getEmail().equals(email) ) {   // 동일시에는 이메일을 보내준다
				
				sendmail(member.getEmail(), 2, member.getPassword() ); // 이메일 보내는 메소드 호출 하고 1. 받는사람이메일 아이디찾기 찾은 비밀번호을알려준다
				
				return true; // 비밀번호찾기 성공시 
			}
		}
		return false; // 비밀번호찾기 실패시 
	}
	
	
	///////////////////////////////로그인 메뉴 끝 //////
	// 5. 회원정보 로그인 아이디를 인수로 받아서 회원의 정보를 넘겨준다
		
	
	public Member1 info( String loginid ) {
			Member1 member = null;
			return member;
		}
		// 6. 회원정보수정 아이디  새로받은 입력값을 넣어서 수정한다
		public boolean info ( String loginid , Member1 updatemember) {
			return true;
		}
		// 7. 회원탈퇴  아이디입력받아 탈퇴
		public boolean delete( String loginid ) {
			return true;
		}
		
		// 8. 메일전송 메소드 
		public static void sendmail( String tomail , int type , String contents ) {
							// tomail : 받는사람 이메일 	// type : 아이디찾기(1),비밀번호찾기(2),가입메일(3)
							// contents : 메일에 넣을 정보
		}	
	

}
