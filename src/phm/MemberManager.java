package phm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MemberManager {

	String id;      		// 회원ID
	String title;			// 자료명
	String rentInfo;		// 대여상태
	
	
	// 날짜포멧
	SimpleDateFormat format= new SimpleDateFormat ("yyyy/ MM/ dd");
	Date today= new Date();
	// 시간 더하기
	Calendar cal = Calendar.getInstance();

			출처: https://d4emon.tistory.com/60 [게으른 개발자!!!]
	String rentalDate;		// 대여일#
	String returnDate;		// 반납예정일#
	String dateOfExtens;	// 연장기간#
	String overdue;			// 연체일#
	Scanner kb;				// 스캐너
	 
	
	
	// 회원리스트 불러오기
//	MemberInfo memberId=MemberInfo.getInstance();
	AdminManager member=AdminManager.getInstance();
	
	// 자료리스트 불러오기
	AdminManager item=AdminManager.getInstance();
	
	
	
	// 대여 - 리스트 생성자 (회원ID, 자료 title)
	MemberManager(AdminManager id, AdmeinManager title);
		this.id=id;      							// 대여한 회원ID
		this.title=title;							// 대여한 자료명
		

		rentalDate = ; 			// 대여일
		
		
		
		this.returnDate=returnDate=rentalDate+7;	// 반납예정일
		// ◆◆◆ String 인데7을 어떻게 더하지? 
		
		this.rentInfo=rentInfo="대여중";				// 대여상태
		this.dateOfExtens=dateOfExtens=0;			// 연장기간
		this.overdue=overdue=0;						// 연체기간
		kb=new Scanner(system.in);					// 검색할때 ㅡ> 자료명검색, 반납, 예약
	
		
		
				
		Date rentalDate = 
				
				
		System.out.println(time1);
		
		
		
		
		
		
		
		
		
		
	// 대여 리스트 생성	
	ArrayList<MemberManager> rental=new ArrayList<>();
	
	
	// 메서드 1-1 : 대여, 배열에 추가 
	void addRental(MemberManager info) {
		rental.add(info);
		
	}
	
	// 메서드 1-2 : 인스턴스 생성
	void creatRentalList() {
		
		MemberManager info = null;
		
		// 대여할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
		id = member.getId;
		title=item.getTile;
		
		info=MemberManager(id, title);
		
		// 대여리스트에 추가 메서드 1-1. 호출.
		addRental(info); 
		
		
	}
	
	
	// 반납
	
	
	
	
	
		
	
	
	
} //class end
