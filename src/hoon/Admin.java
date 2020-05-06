package hoon;

public class Admin extends MemberInfo{
	
	String adminId;		//관리자 아이디
	String adminPw;		//관리자 비번
	

	Admin(String name, int age, String phoneNum, String addr, String email,String adminId,String adminPw) {
		super(name, age, phoneNum, addr, email);
		this.adminId = adminId;
		this.adminPw = adminPw;
		
	}
	@Override
	void AllInformation() {
		super.AllInformation();
	}


}
