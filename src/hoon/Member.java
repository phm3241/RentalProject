package hoon;

public class Member extends MemberInfo{

	boolean loginCheck;	//로그인
	String id;			//회원 아이디
	String pw;			//회원 비밀번호
	
	
	
	Member(String name, int age, String phoneNum, String addr, String email) {
		super(name, age, phoneNum, addr, email);
	
	}
	
	

}
