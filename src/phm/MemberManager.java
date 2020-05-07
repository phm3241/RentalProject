package phm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MemberManager {

	String id;      		// 회원ID
	String title;			// 자료명
	String rentInfo;		// 대여상태
	String rentalDate;		// 대여일#
	String returnDate;		// 반납예정일#
	String dateOfExtens;	// 연장기간#
	String overdue;			// 연체일#
	 
	
	// 날짜포멧
	SimpleDateFormat format= new SimpleDateFormat ("yyyy-MM-dd");
	Date today= new Date();
	// 시간 더하기
	Calendar cal = Calendar.getInstance();
	
	
	// 회원리스트, 자료리스트 불러오기
	AdminManager admManager=AdminManager.getInstance();
//	AdminManager member=AdminManager.getInstance();
//	AdminManager item=AdminManager.getInstance();
	
	
	// 대여 - 리스트 생성자 (회원ID, 자료 title)
	MemberManager(String id, String title, String rentalDate, String returnDate) {

		this.id=id;      				// 대여한 회원ID
		this.title=title;				// 대여한 자료명
		this.rentalDate=null; 			// 대여일
		this.returnDate=null;			// 반납일
		this.rentInfo="대여중";			// 대여상태
		this.dateOfExtens=null;			// 연장기간
		this.overdue=null;				// 연체기간
	}		
		

		
	// 대여 리스트 생성	
	ArrayList<MemberManager> rentalList=new ArrayList<>();
	
	
	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 자료검색 ㅡ> 결과출력
	void showInfo() {
		
		 System.out.println("1.도서 | 2.DVD | 3. 게임");

         int selectNum = admManager.sc.nextInt();
         admManager.sc.nextLine();

         switch (selectNum) {
            case 1:
            	System.out.println("------------------------");
            	admManager.showBookInfo();
            	System.out.println("------------------------");

            	System.out.println("찾으시는 도서명을 입력해주세요.");
                String title = admManager.sc.nextLine();
     			
     			int index = admManager.searchBookInfo(title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     				break;
     			} else {
     				admManager.getBooks().get(index).showAllinfo();
     				System.out.println("1.대여 | 2.예약");
     				selectNum = admManager.sc.nextInt();
     				admManager.sc.nextLine();
     			
     				switch (selectNum) {
                        
	                    case 1:  // 대여
	                            //로그인 상태일시 대여메서드 실행
	                    		if(admManager.loginCheck()) {
	                    		creatRentalList(); 
	                    		break;
	                    		} else {
	                            //비로그인 시
	                    			System.out.println("이용하시려면 로그인을 해 주세요.");
	                    			admManager.login();
	                    			break;
	                    		}
	                        
	                    case 2:  // 예약 	 
	                        	/* 예약 메서드 */ 
	                        	 break;
                
                } //switch-case1. 도서 선택시 switch end
                    	 
         }  //else end   	 
            	 
         } //switch end
	} //showInfo() end
            	 
            	 
            	 
            	 
            	 
            	 

	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가 
	void addRental(MemberManager info) {
		rentalList.add(info);
		
	}
	

	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 인스턴스 생성
	void creatRentalList() {
		
		MemberManager info = null;
		
			// 대여할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
			String id =admManager.getMember().get(admManager.loginCheckIndex()).id; // 로그인한 id
//			String title=admManager.getBooks().get(admManager.searchIndex()).title;  // 자료선택한 title;
			
			// 대여일 생성
			String rentalDate=format.format(cal.getTime());
			System.out.println("대여일 : " + rentalDate);
			
			// 반납일 생성 : 대여일+7일
			cal.add(Calendar.DATE,7);
			String returnDate=format.format(cal.getTime());
			System.out.println("반납일 : "+returnDate);

			
//			// 연장기간 : 대여일 +14일
//			cal.add(Calendar.DATE,7);
//			String dateOfExtens=format.format(cal.getTime());;	// 연장기간#
//			System.out.println("연장일 : "+dateOfExtens);
//			
//			// 연체일 : 
//			String overdue;			// 연체일#
			
			// 카운트 변경 
//			admManager.getMember().get(index).rentalAvail -=1;   // 회원정보 : 대여가능권수 -1
//			admManager.getMember().get(index).numOfRent +=1;		// 회원정보 : 대여권수 +1
//			
//			if(// 받은 타이틀이 )
//			admManager.getBooks().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
//			admManager.getBooks().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
//
//			admManager.getDvd().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
//			admManager.getDvd().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
//
//			admManager.getGame().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
//			admManager.getGame().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
//			
//			
			
			
		
		// MemberManager 객체 생성
		info=new MemberManager(id, title, rentalDate, returnDate);
		
		
		// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
		addRental(info); 
		System.out.println(id+"님 "+title+"자료가 대여가 완료되었습니다. ");
		
		
	}  // creatRentalList() end
	



//
////	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//	// 예약
//	void reserve() {
//		System.out.println("예약하고자하는 자료명 입력해주세요.");
//		String title = admManager.sc.nextLine();
//		
//		int index = searchIndex(title);
//		
//		if(index<0) {	 //예약 실패
//			System.out.println("연장하고자하는 이름의 (책)가 없습니다.");
//		}else {	// 예약일 생성
//			Date reservDate=rentalList.get(index).returnDate;
//			
//			try {
//				reservDate=format.parse("2020/ 05/ 05");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//			
//			System.out.println(title+"이(가) "+ reservDate + "일자로 예약 되었습니다.");
//			System.out.println(returnDate + " 까지 반납하세요.");
//		}
//	
//	}	//reserve()	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
} //class end

