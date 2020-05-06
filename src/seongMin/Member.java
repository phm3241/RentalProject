package seongMin;

public class Member extends MemberInfo{

	boolean loginCheck;		//로그인
	String id;				//회원 아이디
	String pw;				//회원 비밀번호
	int level = 1;			//대여 등급 1 -> 2 -> 3
	int numOfRent = 0;		//대여권수 0
	int rentalAvail = 5;	//대여가능횟수 5
	int numOfExtens = 1;	//연장가능횟수 1
	int overdue = 0;		//연체 0
	int rentalDate = 7;		//대여일 7
	String returnData;		//반납예정일 
	String rentInfo;		//대여상태 
	int dataOfExtens = 7;	//연장기간 7
	
	
	
	Member(String name, int age, String phoneNum, String addr, String email, String id, String pw) {
		super(name, age, phoneNum, addr, email);
		this.loginCheck = false;
		this.id = id;
		this.pw = pw;
	
	}

	@Override
	void showAllInfo() {
		super.showBasicInfo();
		System.out.println("등급 :"+level+"\t대여권수 :"+numOfRent+"\t대여가능권수 :"+rentalAvail+"\t연장가능횟수 :"+numOfExtens+"\t연체 :"+overdue);
		
	}
	
	

}
