package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Properties;

import model.Member;

public class MemberController {

	
	
	public static ArrayList<Member>memberlist = new ArrayList<>();  //model Member import 안쓰면빨간줄들어간다

	
	
	
	
	
	
	//로그인
	public static boolean login(String id, String password) {
		for(Member member: memberlist) {
			if (member.getId().equals(id)&& member.getPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
		
		
		}
		return false;
	}
	//회원가입
	public static boolean signup(Member member) { // 회원가입 메소드이다
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
		
		
		
		return false;// boolean 이라서 무조건 들어가야한다 
		
	}

	// 2. 로그인 
	public static boolean login( String id , String password ) {
		for( Member member : memberlist ) {
			if( member.getId().equals(id) && 
					member.getPassword().equals(password) ) {
				return true; // 로그인 성공시 
			}
		}
		return false; // 로그인 실패시
	}
	// 3. 아이디찾기 이름 메일을 인수로받아서 메일로보내준다 
	public static boolean forgotid( String name , String email ) {
		for( Member member : memberlist ) {
			if( member.getName().equals(name) &&
					member.getEmail().equals(email) ) { // 같다면 이메일보내준다
				
				
				sendmail(member.getEmail(), 1, member.getId() );//이메일 메소드를 호출하고 1. 받는사람이메일 1 (아이디찾기), 찾은아이디를가져다준다  이메일 아직 잘모르는거같다
				
				return true; // 아이디찾기 성공시  
			}
		}
		return false; // 아이디찾기 실패  
	}
	
	public static boolean forgotpassword( String id , String email ) {// 비밀번호 찾기 아이디와 이메일을 인수로받는다
		for( Member member : memberlist ) {
			if( member.getId().equals(id) && 
					member.getEmail().equals(email) ) {   // 동일시에는 이메일을 보내준다
				
				sendmail(member.getEmail(), 2, member.getPassword() ); // 이메일 보내는 메소드 호출 하고 1. 받는사람이메일 아이디찾기 찾은 비밀번호을알려준다
				
				return true; // 비밀번호찾기 성공시 
			}
		}
		return false; // 비밀번호찾기 실패시 
	}
	// 5. 회원정보 로그인 아이디를 인수로 받아서 회원의 정보를 넘겨준다
		public Member info( String loginid ) {
			Member member = null;
			return member;
		}
		// 6. 회원정보수정 아이디  새로받은 입력값을 넣어서 수정한다
		public boolean info ( String loginid , Member updatemember) {
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
		/*SMTP : 간이 우편 전송 프로토콜
		 *  프로토콜이란 통신규약 약속이다
		 *  사용방법
		 *  1. API 라이브러리 다운 을한다 [ activation.jar , mail.jar ] 
		 *  2. 현재 프로젝트에 라이브러리를 등록한다
		 *  */
		
		
		
		
		String fromemail = "관리자ID@naver.com"; // 설정을 1. 보내는사람의 아이디 ,비밀번호, 메일회사의 호스트를 입력한다
		String frompassword = "관리자ID의 비밀번호";
		
		Properties properties = new Properties(); // 설정 컬렉션 map프레임워크  소프트웨어개발에있어 뼈대역할을한다
		properties.put("mail.smtp.host", "smtp.naver.com"); // host : 호스트 주소 
		properties.put("mail.smtp.port" , 587 ); // port : 호스트의 접속하는 번호 
		properties.put("mail.smtp.auth" , true ); // auth : 회원인증 
		
		// 1. 인증 
		//Session session = Session.getDefaultInstance( properties , new Authenticator() {  코드  } );
		
		session session = Session.getDefaultInstance( properties , new Authenticator() {
			
			
			@Override  //익명구현객체:일회성 객체
			protected PasswordAuthentication getPasswordAuthentication() { 	//패스워드 인증 메소드
				return new PasswordAuthentication(fromemail, frompassword);		
			}									// 인증할 이메일 , 인증할 패스워드 
		}); // 인증 끝 
		
		try {
			// 2. 메일 보내기 
				
			MimeMessage message = new MimeMessage(session); //메세지 보내는 사람의 인증정보..
				
			message.setFrom( new InternetAddress(fromemail) );// 보내는 사람 메일주소설정
				
			message.addRecipient( Message.RecipientType.TO , new InternetAddress(tomail) );//받는사람메일주소 작성
			
			// * type 구분 
			if( type == 1 ) {
				
				message.setSubject("java console( forgot ID ) "); //메일제목
				
				message.setText(" 회원님의 아이디 : " + contents ); // 메일내용
			}
			if( type == 2 ) {
				message.setSubject("java console( forgot Password ) ");
				message.setText(" 회원님의 비밀번호 : " + contents );
			}
			if( type == 3 ) {
				message.setSubject("java console( Member Signup ) ");
				message.setText(" java console에 가입해주셔서 감사합니다 ~~ ");
			}
				// 6. 메일 전송 
			Transport.send(message);
			
		}
		catch (Exception e) {
			System.err.println(" [알림] : 메일전송 실패 [ 관리자에게 문의 ]"+e);
		}
	}		
	

}
