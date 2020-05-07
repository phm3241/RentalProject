package lim85;

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
            	System.out.println("찾으시는 도서명을 입력해주세요.");
                String Title = admManager.sc.nextLine();
     			
     			int index = admManager.searchBookInfo(Title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     				break;
     			} else {
     				System.out.println("------------------------");
     				admManager.showBookInfo();
     				System.out.println("------------------------");
     				break;
     			}

     			System.out.println("1.상세정보 보기  | 2.대여 | 3.예약");
     			int selectNum2 = admManager.sc.nextInt();
     			admManager.sc.nextLine();
                
                switch (selectNum2) {
                        
                	case 1:  // 상세정보 보기 
                    		admManager.showBookInfo();
                             System.out.println("1. 뒤로가기");
                             selectNum = admManager.sc.nextInt();
                             // 뒤로가면 어디로가지?
                         
                    case 2:  // 대여
                            //로그인 상태일시 대여메서드 실행
                    		if(admManager.loginCheckIndex()) {
                    		creatRentalList(); 
                    		} else {
                            //비로그인 시
                    			System.out.println("이용하시려면 로그인을 해 주세요.");
                    			admManager.login();
                    		}
                        
                    case 3:  // 예약 	 
                        	/* 예약 메서드 */ 
                        	 break;
                }
                    	 
                    	 
            case 2:
            	System.out.println("찾으시는 DVD명을 입력해주세요.");
                String title = admManager.sc.nextLine();
     			
     			int index = admManager.searchDvdInfo(title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     			} else {
     				System.out.println("------------------------");
     				admManager.books.get(index).showBasicInfo();
     				System.out.println("------------------------");
     			}

                System.out.println("1.상세정보 보기  | 2.대여 | 3.예약");
                selectNum = admManager.sc.nextInt();
                admManager.sc.nextLine();
                
                switch (selectNum) {
                    // 상세정보 보기 
                	case 1:  
                		admManager.books.get(index).showAllinfo();
                         System.out.println("1. 뒤로가기");
                         selectNum = admManager.sc.nextInt();
                         // 뒤로가면 어디로가지?
                         

                     
                	// 대여
                	case 2:  
                        //로그인 상태일시 대여메서드 실행
                		creatRentalList(); 
                		
                        //비로그인 시
                		if(admManager.member.loginCheck==false) {
                			System.out.println("이용하시려면 로그인을 해 주세요.");
                			admManager.login();
                		}
                		
                		
                    // 예약 	 
                    case 3:  
                    	/* 예약 메서드 */ 
                    	 break;                        	 
                    
            	 
            	 
                }    	 
         }
         }
            	 
            	 
            	 
            	 
            	 
            	 
        System.out.println("찾으시는 자료명을 입력해주세요.");
        String Title = admManager.sc.nextLine();
		
		int index = searchIndex(Title);
		
		if(index<0) {
			System.out.println("검색하신 자료의 정보가 없습니다.");
		} else {
			System.out.println("------------------------");
			admManager.itemList.get(index).showBasicInfo();
			System.out.println("------------------------");
		}
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
			String id =admManager.member.loginId(); // 로그인한 id
			String title=admManager.itemList.selecTitle();  // 자료선택한 title;
			
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
			admManager.getMember().get(index).rentalAvail -=1;   // 회원정보 : 대여가능권수 -1
			admManager.getMember().get(index).numOfRent +=1;		// 회원정보 : 대여권수 +1
			
			if(// 받은 타이틀이 )
			admManager.getBooks().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
			admManager.getBooks().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount

			admManager.getDvd().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
			admManager.getDvd().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount

			admManager.getGame().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
			admManager.getGame().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
			
			
			
			
		
		// MemberManager 객체 생성
		info=new MemberManager(id, title, rentalDate, returnDate);
		
		
		// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
		addRental(info); 
		System.out.println(id+"님 "+title+"자료가 대여가 완료되었습니다. ");
		
		
	}  // creatRentalList() end
	




//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 예약
	void reserve() {
		System.out.println("예약하고자하는 자료명 입력해주세요.");
		String title = admManager.sc.nextLine();
		
		int index = searchIndex(title);
		
		if(index<0) {	 //예약 실패
			System.out.println("연장하고자하는 이름의 (책)가 없습니다.");
		}else {	// 예약일 생성
			Date reservDate=rentalList.get(index).returnDate;
			
			try {
				reservDate=format.parse("2020/ 05/ 05");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
			
			System.out.println(title+"이(가) "+ reservDate + "일자로 예약 되었습니다.");
			System.out.println(returnDate + " 까지 반납하세요.");
		}
	
	}	//reserve()	
	
	
	
	// 반납
	void itemReturn() {
		
		System.out.println("반납하고자하는 도서를 입력해주세요");
		String title = admManager.sc.nextLine();
		
		int index = serchIndex(title);
		
		if(index<0) {	//반납실패
			System.out.println("반납하고자하는 "+ title +" 자료가 없습니다.");
		}else {
			//반납성공 			
			title = rental.get(index).title;		// 책을 찾는다.
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf1.format(cal.getTime());
			System.out.println(today);		
			
			String strStartDate = rentalDate;		// 빌린날짜	"2020-04-01";	rentalDate;
	        String strEndDate = today;
	        String strFormat = "yyyy-MM-dd";    //strStartDate 와 strEndDate 의 format
	        
	        //SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
	        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
	        try{
	            Date startDate = sdf2.parse(strStartDate);	//빌린날짜
	            Date endDate = sdf2.parse(strEndDate);		//오늘날짜
	 
	            //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
	            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
	            gap = Math.abs(gap);
	            //System.out.println(gap+"일");
	        }catch(ParseException e){
	            e.printStackTrace();
	        }
	        
	        if(gap > 7) {	 // 연체.
				
				
				rentalAvail = 0;		// 대여가능권수
				numOfExtens = 0;		// 연장가능횟수
				numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
			
			System.out.println(title + "연체일수가 있습니다.");
			System.out.println(title + "연체일수는 " + gap + " 입니다.");
			System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
			System.out.println("처리 : " + today);	
			}else if(gap < 7) {	// 연체 없음.
				
				returnDate = today;						
					
				System.out.println(Title+"자료가 정상적으로 반납되었습니다.");
				System.out.println("처리 : " + today);	
				
				numOfRent --;				// 대여권수
				rentalAvail ++;			// 대여가능권수
				numOfExtens = 1;		// 연장가능횟수
				
			}
			
			// 대여가능으로 바꾼다.
			rentInfo = "대여가능";
			
			
			
	
	
	} //itemReturn끝.
	
	
	// 연장
		void extention() {
			

			System.out.println("연장하고자하는 도서를 입력해주세요.");
			String title = admManager.sc.nextLine();
			
			int index = serchIndex(title);
			
			if(index<0) {	 //연장 실패
				System.out.println("연장하고자하는 "+ title +" 자료가 없습니다.");
			}else {	//연장 성공
				Title = rental.get(index).title;	// 도서를 찾는다.
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf1.format(cal.getTime());
				System.out.println(today);		
				
				String strStartDate = rentalDate;		// 빌린날짜	"2020-04-01";	rentalDate;
		        String strEndDate = today;
		        String strFormat = "yyyy-MM-dd";    //strStartDate 와 strEndDate 의 format
		        
		        //SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
		        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
		        try{
		            Date startDate = sdf2.parse(strStartDate);	//빌린날짜
		            Date endDate = sdf2.parse(strEndDate);		//오늘날짜
		 
		            //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
		            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
		            gap = Math.abs(gap);
		            //System.out.println(gap+"일");
		        }catch(ParseException e){
		            e.printStackTrace();
		        }
				
				
				if(gap > 7) { //연체 있을때.
					System.out.println(title + "연체일수가 " + gap + " 일 입니다.");
					System.out.println(overdue + " 기간동안 연장하실 수 없습니다.");
					System.out.println("처리 : " + today);
					
					rentalAvail = 0;		// 대여가능권수
					numOfExtens = 0;		// 연장가능횟수
					
				}else if(gap < 7) {	// 연체 없을때
					
					returnDate = cal.add(Calendar.DATE, 7);		//7일 연장
					
					
					System.out.println(Title + "자료가 정상적으로 7일 연장되었습니다.");
					System.out.println(returnDate + " 까지 반납하세요.");
					System.out.println("처리 : " + today);
					
					numOfRent ??? 			// 대여권수, 빌렸던 책이니까 유지	???
					rentalAvail ???			// 대여가능권수, ???
					numOfExtens = 0;		// 연장가능횟수, 연장을 썼으니까 0으로 바꿔준다.
				
					
				}
				
				rentInfo = "대여중";		// 대여상태 대여중으로 바꾼다.
				
				// 연장기간
				dateOfExtens = returnDate + 7;

			
		} //extention 끝.
	
	
	
	
	
	
	
	
	
	
	
	
	public class Book extends RentalItemInfo{
		
		String author;		//저자
		int limitAge;		//제한연령
		String story;		//설명
		String launchDate;	//출판일
		String bestTitle;	//인기자료
		int rentalCount;	//대여횟수
		int like;			//관심수
		int numOfItem;		//재고
		String returnDate;	//반납예정일
	
	
	
	
	//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	
	// 메서드 2 : 예약 ㅡ> 대여리스트에서 해당 인덱스 찾아서 예약처리.
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
} //class end

