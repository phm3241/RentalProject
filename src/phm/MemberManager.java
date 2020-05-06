package phm;

import java.util.ArrayList;

public class MemberManager {

	String id;      		// 회원ID
	String title;			// 자료명
	String rentalDate;		// 대여일
	String returnDate;		// 반납예정일
	String rentInfo;		// 대여상태
	String dateOfExtens;	// 연장기간
	String overdue;			// 연체기간
	
	
	// 회원리스트 불러오기
//	MemberInfo memberId=MemberInfo.getInstance();
	AdminManager member=AdminManager.getInstance();
	
	// 자료리스트 불러오기
	AdminManager item=AdminManager.getInstance();
	
	
	
	// 대여 - 리스트 생성자 (회원ID, 자료 title)
	MemberManager(AdminManager id, AdmeinManager title);
		this.id=id;      					// 대여한 회원ID
		this.title=title;					// 대여한 자료명
		this.rentalDate=rentalDate;			// 대여일
		this.returnDate=returnDate;			// 반납예정일
		this.rentInfo=rentInfo;				// 대여상태
		this.dateOfExtens=dateOfExtens=0;		// 연장기간
		this.overdue=overdue=0;				// 연체기간
	
	// 대여 리스트 생성	
	ArrayList<MemberManager> rentalList=new ArrayList<>();
	
	// 메서드 1 : 대여 
	void rental() {
		rentalList.add(MemberManager id, MemberM
		
	}
	
	
	// 반납
	
	
	
	
	
		
	
	
	
} //class end
