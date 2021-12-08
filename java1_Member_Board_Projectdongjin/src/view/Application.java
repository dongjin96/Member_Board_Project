package view;

import java.util.Scanner;

import controller.MemberController;

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
				if (ch==1) {
					System.out.println("========로그인페이지===========");
					System.out.println("아이디 입력 :"); String id = scanner.next();
					System.out.println("비밀번호 입력 :"); String password = scanner.next();
					boolean result = MemberController.login(id, password);
				
					if (result) {
						System.out.println("로그인성공했습니다");
						membermenu(id);
					}else {
						System.out.println("로그인실패했습니다");
					}
				
				}//로그인
				if(ch==2) {
					System.out.println("============회원가입페이지====");
					System.out.println("아이디입력:"); String id = scanner.next();
					System.out.println("비밀번호입력 :"); String password = scanner.next();
					System.out.println("이름입력 :"); String name = scanner.next();
					System.out.println("이메일입력 :"); String email = scanner.next();
					boolean result = MemberController.signup
				
				}
				
		}
		
	}//me

	
	
	private static void membermenu(String id) {
		// TODO Auto-generated method stub
		
	}
}//ce
