package hoon;

public class Admin extends MemberInfo{
	
	boolean loginCheck;		//로그인
	String adminId;		//관리자 아이디
	String adminPw;		//관리자 비번
	

	Admin(String adminId, String adminPw) {
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.loginCheck = false;
		
	}
	@Override
	void AllInformation() {
		super.AllInformation();
	}


}
