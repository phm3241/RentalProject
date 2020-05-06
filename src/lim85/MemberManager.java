package lim85;

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
	void return() {
		System.out.println("반납하고자하는 (책)을 입력해주세요");
		String title = kb.nextLine();
		
		int index = serchIndex(title);
		
		if(index<0) {	//반납실패
			System.out.println("반납하고자하는 이름의 (책)가 없습니다.");
		}else {
			//반납성공 			
			String rentalTitle = rental.get(index).title;
			
			//반납했으니까 책 리스트에 플러스 시킨다?
			numOfItem ++;
			
			System.out.println(rentalTitle+"이(가) 정상적으로 반납되었습니다.");
			
			//반납일 		// 오늘날짜 찍는다.
			System.out.println(rentalDate);
			
			// 연체 된거 체크해야된다.			// 연체되면 
			if(오늘날짜-빌린날짜>7) {			
				overdue = 뺀 일수;
				
				rentalAvail = 0;		// 대여가능횟수
				numOfExtens = 0;		// 연장가능횟수
				
			System.out.println(rentalTitle + "의 연체일수는 " + overdue + " 입니다.");
			System.out.println(overdue + "일 동안 (책)을 빌리실 수 없습니다.");
			}
			
			
			
			
			// 대여가능으로 바꾼다.
			rentInfo = "대여가능";
			
			
			
			
			
			
		}
			
	}	//return 끝.
	
	
	//연장
	void extention() {
		System.out.println("연장하고자하는 (책)을 입력해주세요.");
		String title = kb.nextLine();
		
		int index = serchIndex(title);
		
		if(index<0) {	 //연장 실패
			System.out.println("연장하고자하는 이름의 (책)가 없습니다.");
		}else {	//연장 성공
			String rentalTilte = rental.get(index).title; // 책을 찾는다.
		
			returnDate = cal.add(Calendar.DATE, 7);		// 7일 연장
			
			// 책 권수는 그대로 유지.
			
			rentInfo = "대여중"		// 대여상태 대여중으로 바꾼다.
			
			System.out.println(rentalTitle + "이(가)  7일 연장되었습니다.");
			System.out.println(returnDate + " 까지 반납하세요.");
		}
	
	}	//extention 끝.	
	
	
	
	
	//배열에서 찾는것 serchIndex
	
	void serchIndex(String title) {		// 책,게임,dvd 이름
									
		int serchIndex = -1;
		
		for(int i=0; i<rental.size(); i++) {
			if(rental.get(i).title.equals.(title)) {
				serchIndex = i;
				break;		
			}
				
		}
		return serchIndex;
		
		
	
	
	} //serchIndex 끝.
	
	
	
	
	
		
	
	
	
} //class end
