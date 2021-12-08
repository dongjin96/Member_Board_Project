package controller;

import java.util.ArrayList;

import model.Member;

public class MemberController {

	
	
	public static ArrayList<Member>memberlist = new ArrayList<>();  //model Member import 안쓰면빨간줄들어간다

	
	
	
	
	
	
	
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
	
	public static boolean signup(String id,String password,String name,String email) {
		if
		
		
		
		
		
		return false;
		
	}

}
