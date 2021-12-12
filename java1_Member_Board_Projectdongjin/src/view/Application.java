package view;

import java.lang.reflect.Member;
import java.util.Iterator;
import java.util.Scanner;

import controller.BoardController;
import controller.MemberController;
import controller.ReplyController;
import controller.Replycontroller1;
import model.Board1;
import model.Member1;

import model.Reply1;

public class Application {
	public static Scanner scanner = new Scanner(System.in); //public static 을 붙여서 클래스 내에서 어디든 사용할수있게한다
	
	public static void main(String[] args) {
		
		mainmenu(); // 처음 시작할떄가 보이게 하는것이 mainmenu로 넘긴다
		
	}

	private static void mainmenu() {
		
		while(true) {
			System.out.println("===========회원 커뮤니티===========");
			System.out.println("1.로그인2.회원가입3.아이디찾기4.비밀번호찾기");
			System.out.println("=================================");
			System.out.println("선택 :");
			int ch = scanner.nextInt();
			if( ch == 1 ) { // 로그인 선택
				System.out.println("++++++++++++ 로그인 페이지 ++++++++++++");
				System.out.print(" Id : "); 		String id = scanner.next();
				System.out.print(" Password : "); 	String password = scanner.next();
				
				boolean result  =  MemberController.login(id, password);   // 멤버 컨트롤러에있는 로그인메소드에 id password 인수를가져간다 그리고 그결과를 true false 로 받겠다고 함
				
				if( result ) {// 로그인 성공시  result 그자체가 true
					System.err.println(" [알림] : 로그인 성공 ");
					membermenu(id); // 회원메뉴 메소드 로 이동 하면서 id를 가져감
					
				}else { // 그게아니면
					System.err.println(" [알림] : 로그인 실패 ( 동일한 회원정보가 없습니다 ) ");
				}
				
			}//로그인
				if(ch==2) {
					System.out.println("============회원가입페이지====");
					System.out.println("아이디입력:"); 		 String id = scanner.next();
					System.out.println("비밀번호입력 :"); 	 String password = scanner.next();
					System.out.println("이름입력 :"); 		 String name = scanner.next();
					System.out.println("이메일입력 :");		 String email = scanner.next();
					
					Member1 member1 = new Member1(id, password, name, email, ch); //객체화 시킴
					
					boolean result = MemberController.signup(member1); // 회원가입 메소드에 가져간다 member1을인수로가져간다
					if (result) {// true 일떄
						System.out.println("회원가입 성공");
						
					}else  {
						System.out.println("회원가입 실패");
					}
					
					
		}// 회원가입 끝
				if (ch==3) {
					System.out.println("이름 를 입력해주세요 :"); String name = scanner.next();
					System.out.println("email 을 입력해주세요"); String eamil= scanner.next();
					
					boolean result = MemberController.forgotid(name, eamil); //name, eamil 를 인수로 forgotid 메소드 실행
					if( result ) {
						System.err.println("회원님의 아이디를 이메일로 전송했습니다 ");
					}else {
						System.err.println(" 동일한 회원정보가 없습니다" );
					}
				}
				if(ch==4) {
					System.out.println("id를 입력하세요:"); String id = scanner.next();
					System.out.println("email 을 입력해주세요"); String eamil= scanner.next();
					boolean result = MemberController.forgotpassword(id, eamil); // id, eamil를 인수로 비밀번호찾기메소드 호출

					if( result ) {
						System.err.println(" 회원님의 비밀번호를 이메일로 전송했습니다 ");
					}else {
						System.err.println(" 동일한 회원정보가 없습니다" );
					}
				
				
				}
				
			}//we
	}//me
///////////////////////////////////로그인페이지끝
	public static void membermenu(String id) {// 회원메뉴
		
		while(true) {
			try {
			
			
			System.out.println("++++++++++++++++++회원메뉴++++++++++++++++");
			System.out.println("1.회원정보 2.커뮤니티 3.로그아웃 ");
			int ch = scanner.nextInt();
			
			if (ch==1) {
						System.out.println("=======회원정보=======");
						System.out.println("====================");
						
				
			}
			if (ch==2) {
				boardmenu(id);
			}
			if (ch==3) {
				System.out.println("로그아웃되었습니다");
				return; // 현재 메소드 리턴끝내기
				//break 는 가장 가까운 무한 루프 끝내기
				
			}
			
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
			
	}
	
	
	
	
//////////////////////////////////////////////////////////board 메뉴
	
	public static void boardmenu(String id) {/// 게시판 메소드
		
		while(true) {
			
		try {
			System.out.println("\n++++++게시판페이지++++++++++");
			System.out.println("\n번호\t제목\t작성자\t작성일\t조회수");
			
			int i = 1; // for 반복횟수 i => 게시물번호
			for(Board1  board1 : BoardController.boardlist) {
				System.out.println( i +// 보드번호
						"\t"+ board1.getTitle() + // 제목가져오기
						"\t\t"+board1.getWriter() + // 작성자가져오기
						"\t" + board1.getDate() +	//ㅇ날짜가져오기
						"\t"+board1.getView() );	// 조회수
				i++;	// 증가할때마다 보드번호증가
			}
			System.out.println("=======================================");
			System.out.println("1. 등록2.상세보기3.뒤로가기>>>:");
						int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("===========게시물 등록=============");
				scanner.nextLine();//이거 사용안하면 오류남  nextline은 글쓸떄 띄어쓰기도 사용할수있게함
				System.out.println("제목 :"); String title = scanner.nextLine();
				System.out.println("작성자 :");String writer = scanner.nextLine();
				Board1 board1 = new Board1(title, title, writer); //적은내용 객체화해서저장해버릭~!
				BoardController.add(board1);//저장~!
			}
			if(ch==2) {
				System.out.println(":게시물번호 :"); int index = scanner.nextInt();
				Board1 board1 = BoardController.detail(index-1); // 왜 일을 깍는지----------------------
				System.out.println("===========게시물 상세보기=================");
				if(board1 ==null) {
					System.out.println("선택한 게시물은 존재하지않습니다");
				}else {
					System.out.println("=-------게시물상세-----------");
					System.out.println(" 제목 : " + board1.getTitle() );
					System.out.println(" 내용 : " + board1.getContents() );
					System.out.println(" 작성자 : " + board1.getWriter() );
					System.out.println(" 작성일 : " + board1.getDate() );
					System.out.println(" 조회수 : " + board1.getView() );
					System.out.println("-------------------댓글-------------------");
					System.out.println("작성자\t댓글내용\t\t작성일"); // 댓글 창만들기
					
					for(Reply1 reply1 : board1.getReplylist()) {
						System.out.println(reply1.getWriter()+"\t"+reply1.getContents()+"\t\t"+reply1.getDate());
								
					}
					System.out.println("1.댓글쓰기 2. 뒤로가기");
					if (board1.getWriter().equals(id)) {// 글쓴이가 로그인한아이디가 같으면 게시물삭제 게시물 수정가능
						System.out.println("3. 게시물 삭제4. 게시물수정");
						
					}
					int ch2 = scanner.nextInt();
					if(ch2==1) {
						scanner.nextLine();//이거 안쓰면 에러가뜬다
						System.out.println("\n내용  :"); String contents = scanner.nextLine();
						Reply1 reply1 = new Reply1(contents, id ); // 내용 작성자 
						boolean result = Replycontroller1.add(index-1, reply1); // 마이너스 1하는이유
						
						if(result) {// 진실일시
							System.out.println("댓글등록성공");
						}else {
							System.out.println("댓글등록 실패");
							
						}
					}
					if( ch2 == 2 ) { return; }
					if( ch2 == 3 ) {} // 게시물 삭제 아마 디비 로 사용하면 delete 해서 할수있어서 안한듯!!
					if( ch2 == 4 ) {}// 게시물 수정
				}
			}
			if(ch==3) {
				return; // 현재 메소드 리턴[반환] 끝내기 
				//break;는 가장 가까운 while 문 나오기
			}
		}
		catch (Exception e) {
			System.err.println(" [알림] : 메뉴 페이지 오류 [ 관리자문의 ] ");
			scanner = new Scanner(System.in);
		}
	
	
	
	
	
	
	
	

					
		}
		}
}//ce
