package hoon;

public class MemberInfo {
	
	String name;		//이름
	int age;			//나이
	String phoneNum;	//전화번호
	String addr;		//주소
	String email;		//이메일
	boolean loginCheck;	//로그인
	
	MemberInfo(String name,int age, String phoneNum,String addr,String email){
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.loginCheck = false;
				
	}
	void showBasicInfo() {
		System.out.println("이름 :"+name+"\t나이 :"+age+"\t전화번호 :"+phoneNum+"\t주소 :"+addr+"\t이메일 :"+email);
	}
	
	void showAllInfo() {
		
		
		
	}
	
}
