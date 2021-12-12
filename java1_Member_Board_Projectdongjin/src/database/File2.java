package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.BoardController;
import controller.MemberController;
import model.Board1;
import model.Member1;

public class File2 {

	
	
	// �ʵ� 
		
	private static String memberpath= // ȸ�������� �����ϴ°��
	"C:/Users/������/Desktop/Member_Board_Project/java1_Member_Board_Projectdongjin/src/database/memberlist.txt";
	private static String boardpath=
			"C:/Users/������/Desktop/Member_Board_Project/java1_Member_Board_Projectdongjin/src/database/boardlist.txt/";
	
	
	
	
	public static boolean filesave(int type) {
		
		try {
			FileOutputStream fileOutputStream = null; // ���ְ� ������
			if (type==1) {//�μ��� int type���������� 1���� ȸ���������� ����
				fileOutputStream = new FileOutputStream( memberpath);// ��θ� memberpath�μ����ߴ�
				
				for(Member1 member1 : MemberController.memberlist) {// ȸ�� ����Ʈ�� ������������ �ݺ����� ����ߴ�
					String outString = member1.getId()+","+member1.getPassword()+","+
							member1.getName()+","+member1.getEmail()+","+
							member1.getPoint()+"\n";
					fileOutputStream.write(outString.getBytes()); // ����Ʈ�� ��������~!!
				}
				
				//��Ʈ�� ����� �ʱ�ȭ���Ѿ��Ѵ� close ���ϸ� ��� �����ִ´�
				fileOutputStream.flush();// ���Ͻ�Ʈ�� �ʱ�ȭ 
				fileOutputStream.close();//���Ͻ�Ʈ���ݱ�
				return true; // ����ó�� ����
			}
			
			if(type==2) { // �̹����� �Խ���
				fileOutputStream = new FileOutputStream( boardpath ); //boardpath�ΰ�θ� �����Ѵ�
				for( Board1 board : BoardController.boardlist ) { // �ݺ���������ؼ� boardlist���� ������ �����´�
					String outstring = board.getTitle()+","+board.getContents()+","+
										board.getWriter()+","+board.getDate()+","+
										board.getView()+"\n";//���� ����
					fileOutputStream.write( outstring.getBytes() );// ����Ʈ�γ�������
				}// ��Ʈ�� �ʱ�ȭ �� �ݱ�
				fileOutputStream.flush();
				fileOutputStream.close(); 
				return true;
		
			}
			if( type == 3 ) {}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false; // ����ó�� ����
	}
	//////////���� �����ⳡ
	public static boolean fileload(int type) {
		try {
			FileInputStream fileInputStream = null;
			if (type==1) {
				fileInputStream = new FileInputStream(boardpath);// ��θ� �����Ѵ�
				byte[] bytes = new byte[10000]; // �޾ƿ� ����Ʈ�� 10000���� ����
				
				fileInputStream.read(bytes); //����Ʈ�� �п��� ����
				String instring = new String(bytes); // ����Ʈ�迭�� ���ڿ��� �ٲٴ� �۾�
				String[] members = instring.split("\n"); //split���̿��ؼ� �����ؼ� �����Ѵ�(����ȸ�� �� �߰��Ѵ�)
				for(int i= 0 ; i<members.length;i++) {
					String[] field =members[i].split(","); // �ݺ����� ����ؼ� �ʵ���� �����Ѵ�
					// �и��� �ʵ带 ��üȭ��Ų�� point �ʵ�� int ������ ��ȯ String -> Int ( Integer.parseInt ) ����Ʈ�� ���ڿ��� �޾����ϱ�  Integer.parseInt ������ؼ� int�ιٲ۴� 
					Member1 member = new Member1( field[0] , field[1] ,  
							field[2], field[3],  
							Integer.parseInt(field[4] ));
			
			MemberController.memberlist.add(member); // ���� ��ü�� ����Ʈ�� �����Ѵ�
				}
				fileInputStream.close(); // ��Ʈ�� �ݱ� 
				return true; // ���� �ҷ����� ����
			}
			if( type == 2 ) {///�̹����� �Խ��Ǻҷ�����!!
				
				fileInputStream = new FileInputStream(boardpath); //  ���ϰ�� boardpath�μ���
				byte[] bytes = new byte[10000]; // ����Ʈ 10000���� 10kb�����ȴ��ϳ�
				fileInputStream.read( bytes );	// ����Ʈ�� �����о����
				String instring = new String(bytes); // string ���� ���ڿ��� ��ȯ�Ѵ�
				String[] boards = instring.split("\n"); // �Խù���"\n"������ؼ� �ʵ�� ����
				
				for( int i = 0 ; i<boards.length-1 ;i++ ) { //  �ݺ���������ؼ� ������ split(",")�α����ϸ鼭 Integer.parseInt������ؼ� �ٽ� int�����ιٲ۴�
					String[] field = boards[i].split(",");
					Board1 board = new Board1( field[0] , field[1] , field[2], 
									field[3]  , Integer.parseInt(field[4]));
					BoardController.boardlist.add(board);
				}
				
				fileInputStream.close(); // ��Ʈ�� �ݱ� 
				return true; // ���� �ҷ����� ����
			}
			if( type == 3 ) {}
		}
		catch (Exception e) {
			System.out.println(" [�˸�] : ���� �ҷ����� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false; // ���� ������ ����
	}
}
