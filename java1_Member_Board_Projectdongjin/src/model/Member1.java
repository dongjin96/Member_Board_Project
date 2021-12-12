package model;

public class Member1 {


	// 1. 필드 
	private String id;
		// private : 회원들의 정보 이므로 유출되지않게 private 를 사용해야한다
	private String password;
	private String name;
	private String email;
	private int point;
	
	// 2. 생성자 : 생성자를 사용하는 이유?? 
	public Member1() {   //생성자는 클래스와 같은이름쓰고 리턴값안준다 다른 곳에서 new 객체생성시 호출된다
	
	}
	public Member1(String id, String password, String name, String email, int point) {  // 생성자에서 다른 생성자를 호출할떄는 this 를 사용한다
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.point = point;
	}
	
	
	public Member1(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	// 3. 메소드 [ get , set 사용하는 이유 ?? 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}