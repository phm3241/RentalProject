package phm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MemberManager {

	String title = null; // 자료명
//	String rentalDate=null; 	// 대여일#
//	String returnDate=null;		// 반납일#
	private ArrayList<RentalList> rentalList;

	// 날짜포멧
	SimpleDateFormat format= new SimpleDateFormat ("yyyy-MM-dd");
	Date today= new Date();
	
	// 시간 더하기
	Calendar cal = Calendar.getInstance();

	// 회원리스트, 자료리스트 불러오기
	AdminManager adm = AdminManager.getInstance();

	// 기본생성자, 대여리스트 생성
	public MemberManager() {
		rentalList = new ArrayList<>();
//		UserList uList=new UserList<>;
		
//		rentalList.add(uList);
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 자료검색 ㅡ> 결과출력
	void showInfo() {

		System.out.println("1.도서 | 2.DVD | 3. 게임");

		int selectNum = adm.sc.nextInt();
		adm.sc.nextLine();

		switch (selectNum) {
		case 1: // Book 선택시
			System.out.println("------------------------");
			adm.showBookBasic();
			System.out.println("------------------------");

			System.out.println("찾으시는 도서명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			int index = adm.searchBookInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				adm.getBooks().get(index).showAllinfo();
				System.out.println("1.대여 | 2.예약");
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case1(Book) : switch end
				break;
			} // switch : case1(Book) : else end

		case 2: // DVD 선택시
			System.out.println("------------------------");
			adm.showDvdInfo();
			System.out.println("------------------------");

			System.out.println("찾으시는 DVD명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			index = adm.searchDvdInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				adm.getDvd().get(index).showAllinfo();
				System.out.println("1.대여 | 2.예약");
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case2(DVD) : switch end
				break;
			} // switch : case2(DVD) : else end

		case 3: // Game 선택시
			System.out.println("------------------------");
			adm.showGameInfo();
			System.out.println("------------------------");

			System.out.println("찾으시는 Game명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			index = adm.searchGameInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				adm.getGame().get(index).showAllinfo();
				System.out.println("1.대여 | 2.예약");
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case3(Game) : switch end
				break;
			} // switch : case3(Game) : else end

		} // switch end
	} // showInfo() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가
	void addRental(RentalList info) {
		rentalList.add(info);

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 인스턴스 생성
	void creatRentalList() {

		RentalList info = null;

		int index = adm.loginCheckIndex();

		// 대여할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
		String id = adm.getMember().get(index).getId(); // 로그인한 id
		// 회원 카운트 변경
		adm.getMember().get(index).rentalAvail -= 1; // 회원정보 : 대여가능권수 -1
		adm.getMember().get(index).numOfRent += 1; // 회원정보 : 대여권수 +1

		// 대여일 생성
		LocalDateTime rentalDate = LocalDateTime.now();
//			String rentalDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
		System.out.println();
		String start = rentalDate.toString();
//			LocalDate.parse(rentalDate);

		// 반납일 생성 : 대여일+7일
		LocalDateTime returnDate = rentalDate.plusDays(7);
		String end = returnDate.toString();

		// 자료 카운트 변경
		// 만약에 선택한 타이틀이 book이면...book 카운트변경
		if (adm.searchBookInfo(this.title) > 0) {
			adm.getBooks().get(index).numOfItem -= 1; // 자료정보 : 재고 -1 numOfItem
			adm.getBooks().get(index).rentalCount += 1; // 자료정보 : 대여횟수 +1 rentalCount

			// 만약에 선택한 타이틀이 DVD이면...DVD 카운트변경
		} else if (adm.searchDvdInfo(this.title) > 0) {
			adm.getDvd().get(index).numOfItem -= 1; // 자료정보 : 재고 -1 numOfItem
			adm.getDvd().get(index).rentalCount += 1; // 자료정보 : 대여횟수 +1 rentalCount

			// 만약에 선택한 타이틀이 Game이면...Game 카운트변경
		} else if (adm.searchGameInfo(this.title) > 0) {
			adm.getGame().get(index).numOfItem -= 1; // 자료정보 : 재고 -1 numOfItem
			adm.getGame().get(index).rentalCount += 1; // 자료정보 : 대여횟수 +1 rentalCount
		}

		// MemberManager 객체 생성
		info = new RentalList(id, title, start, end);

		// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
		addRental(info);
		System.out.println(id + "님 " + title + "자료가 대여가 완료되었습니다. ");
		System.out.println("대여일 : " + rentalDate + " | 반납예정일 : " + returnDate);

	} // creatRentalList() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 메인에서 4번 눌렀을 떄! ㅡ> 내 대여내역 자동출력, 반납 연장 선택 ㅡ> 반납. 연장 기능
	void returnExten() {
		
		// 내 대여내역 자동출력
		showMyRentalList();
		
		// 내 대여내역에서 반납하거나 연장할 자료를 검색입력
		System.out.println("반납이나 연장하실 자료명을 입력해주세요.");
		String title = adm.sc.nextLine();

		
		// 검색입력 받은 타이틀이 있는 rentalList의 인덱스
		int index=checkTitle(title);
//		rentalList.get(index).showRentalListInfo();  // 확인용. 선택한 타이틀이 있는 나의 대여내역 출력 
		
		itemReturn(index);
		
		// 반납 연장 기능선택
		System.out.println("1. 반납 | 2.연장");

        int selectNum = adm.sc.nextInt();
        adm.sc.nextLine();
   
        	// 선택한 기능 실행
	        switch (selectNum) {
	        case 1:		// 반납 선택시
	        	itemReturn(index);
	        	break;
	        	
	        case 2:		// 연장 선택시
//	        	extention();
	        	break;
	        }
		
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 전체 rentalList 에서 tilte로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int searchRentalIndexTitle(String title) {

		int searchRentalIndex = -1;

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).title.equals(title)) {
				searchRentalIndex = i;
			}
		}
		return searchRentalIndex;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 나의 rentalList 에서 title로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int checkTitle(String title) {

		int index = adm.loginCheckIndex();

		String id = adm.getMember().get(index).getId();
		
		int index2 = -1;
		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id) && rentalList.get(i).title.equals(title)) {
				index2 = i;
				break;
			}
		}
		return index2;
	}
				
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 id로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	void showMyRentalList() {

		int index = adm.loginCheckIndex();

		String id = adm.getMember().get(index).getId();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id)) {

				rentalList.get(i).showRentalListInfo();

			}
		}

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// RentalList 전체 출력
	public void showAllRentalListInfo() {
		for (int i = 0; i < rentalList.size(); i++) {
			rentalList.get(i).showRentalListInfo();
			System.out.println("----------------------------");
		}
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//	// 예약
//	void reserve() {
//
//		// 예약할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
//		int index = adm.loginCheckIndex();
//		String reservId = adm.getMember().get(index).getId(); // 로그인한 id
//
//		searchRentalIndexTitle(this.title);
//
//		// 예약일 생성
//		String reservDate = format.format(cal.getTime());
//		System.out.println("예약일 : " + reservDate);
//
//		// 대여가능일 생성
//		cal.add(Calendar.DATE, 1);
//		String rentalAvailDate = format.format(cal.getTime());
//		System.out.println("대여가능일 : " + rentalAvailDate);
//
//		System.out.println(title + "이(가) " + reservDate + "일자로 예약 되었습니다.");
//		System.out.println(rentalAvailDate + " 부터 대여 가능합니다.");
//
//	} // reserve() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	// 반납
	void itemReturn(int index) {
			
//			RentalList info=null;
//			rentalList.get(index).showRentalListInfo();
			
			// 반납일 = 현재날짜로 생성
			LocalDateTime today=LocalDateTime.now();
			String returnDate=today.toString();
			System.out.println("returnDate"+returnDate);
			
			// 나의 대여리스트 중 해당 인덱스의  반납일이 변경됨.
			rentalList.get(index).returnDate=returnDate;
			rentalList.get(index).rentInfo="반납완료";
			
			
			// 나의 대여리스트 중 해당 인덱스 출력. 확인. 
			rentalList.get(index).showRentalListInfo();

			
//		
//			String today = format.format(cal.getTime());
//			// System.out.println(today); // 오늘날짜
//
//			String strStartDate = rentalList.get(index).rentalDate;
//			String strEndDate = today;
//			String strFormat = "yyyy-MM-dd";
//
////	        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
//
//			Date startDate = null;
//			Date endDate = null;
//			try {
//				startDate = format.parse(strStartDate);
//				endDate = format.parse(strEndDate); // today
//			} catch (ParseException e) {
//				e.printStackTrace();
//			} // rentalDate
//
//			long gap = (startDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000);
//			gap = Math.abs(gap);
			
	
	} // itemReturn(int index) end
	
	
			// System.out.println(gap+"일");

//	        if( gap > 7) {	 // 연체.
//				
//				
//	        	adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//	        	adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//				//numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
//			
//				System.out.println(title + "연체일수가 있습니다.");
//				System.out.println(title + "연체일수는 " + gap + " 입니다.");
//				System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
//				System.out.println("처리 : " + today);	
//			}else if(gap < 7) {	// 연체 없음.
//				
//				returnDate = today;						
//					
//				System.out.println(title+"자료가 정상적으로 반납되었습니다.");
//				System.out.println("처리 : " + today);	
//				
//				adm.getMember().get(adm.loginCheckIndex()).numOfRent --;			// 대여권수
//				adm.getMember().get(adm.loginCheckIndex()).rentalAvail ++;		// 대여가능권수
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 1;		// 연장가능횟수
//				
//			}
//			
//			// 대여가능으로 바꾼다.
//			rentalList.get(index).title
//			rentInfo = "대여가능";

//		}
//
//	} // itemReturn끝.

	
//	
//	// 연장.
//	void extention() {
//		
//
//		System.out.println("연장하고자하는 자료를 입력해주세요.");
//		String title = adm.sc.nextLine();
//		
//		int index = adm.loginCheckIndex();
//		
//		if(index < 0) {	 //연장 실패
//			System.out.println("연장하고자하는 "+ title +" 자료가 없습니다.");
//		}else {	//연장 성공
//			title = adm.get(index).title;	// 도서를 찾는다.
//			
//			//Calendar cal = Calendar.getInstance();
//			//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//			String today = format.format(cal.getTime());
//			cal.add(Calendar.DATE,7);
//			String returnDate = format.format(cal.getTime());		// 7일 연장.
//			
//			String startDate = rentalDate; 
//	        String endDate = today;
//	       
//	        Date startDate1 = null;
//	        Date endDate1 = null;
//	        
//	        try {
//		        
//	        	startDate1 = format.parse(startDate);	// rentalDate
//	            endDate1 = format.parse(endDate);		// today
//		        
//	        } catch(ParseException e) {
//	        	e.printStackTrace();
//	        }
//	        
//	        long gap = startDate1.getTime() - endDate1.getTime() / (24*60*60*1000);
//            gap = Math.abs(gap);
//	        
//	        if((int)gap > 7) { //연체 있을때.
//				System.out.println(title + "연체일수가 " + gap + " 일 입니다.");
//				System.out.println(gap + " 기간동안 연장하실 수 없습니다.");
//				System.out.println("처리 : " + today);
//				
//				adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//				
//			}else if((int)gap < 7) {	// 연체 없을때
//				
//			    returnDate = format.format(cal.getTime());
//				cal.add(Calendar.DATE, 7);
//				String extenDate = format.format(cal.getTime());
//				
//	
//				System.out.println(title + "자료가 정상적으로 7일 연장되었습니다.");
//				System.out.println(returnDate + " 까지 반납하세요.");
//				System.out.println("처리 : " + today);
//				
//				//admManager.getMember().get(admManager.loginCheckIndex()).numOfRent ??? 			// 대여권수, 빌렸던 책이니까 유지	???
//				//admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail ???			// 대여가능권수, ???
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수, 연장을 썼으니까 0으로 바꿔준다.
//			
//				
//			}
//		}
////			rentInfo = "대여중";		// 대여상태 대여중으로 바꾼다.
//			
//			// 연장기간
//			//dateOfExtens = returnDate + 7;
//
//		
//	} //extention 끝.
//	
//	

} // class end
