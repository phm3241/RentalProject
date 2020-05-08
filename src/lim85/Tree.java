//package lim85;
//
//public class Tree {
//
//public class rentalListInfo{
//	
//	String id;      		// 회원ID
//	String title;			// 자료명
//	String rentInfo;		// 대여상태
//	String rentalDate;		// 대여일#
//	String returnDate;		// 반납예정일#
//	String reservDate;		// 예약일#
//	String reservId;		// 예약자
//	String dateOfExtens;	// 연장기간#
//	String overdue;			// 연체일
//	
//	AdminManager admManager=AdminManager.getInstance();
//	
//	rentalListInfo(String id, String title, String rentalDate, String returnDate){
//		
//		this.id=id;      				// 대여한 회원ID
//		this.title=title;				// 대여한 자료명
//		this.rentInfo="대여중";			// 대여상태
//		this.rentalDate=null; 			// 대여일
//		this.returnDate=null;			// 반납일
//		this.reservDate=null;			// 예약일
//		this.reservId=null;				// 예약자
//		this.dateOfExtens=null;			// 연장기간
//		this.overdue=null;				// 연체기간
//	
//	}
//	
//	
//	public void showMyRentalList() {
//			
//			// 로그인 했던 아이디의 인덱스를 받아서
//			int index=admManager.loginCheckIndex();
//			
//			// 그 아이디를 rentalList에서 찾고, 
//			String id =admManager.getMember().get(index).id; 
//			
//			int rentalIndex=searchRentalIndex(id);
//			
//			// rentalList에서 해당 id의 대여내역만 출력
//			rentalList.get(rentalIndex).showRentalListInfo();
//			
//	}
//	
//	
//	public void showAllRentalListInfo() {
//        for (int i = 0; i < rentalList.size(); i++) {
//        	rentalList.get(i).showRentalListInfo();
//            System.out.println("----------------------------");
//        }
//    }
//	
//	
//	public void showRentalListInfo() {
//		System.out.println("대여 ID : "+id+"\t\t대여 자료명 : "+title+"\t\t대여상태 :"+rentInfo);
//		System.out.println("대여일: :"+rentalDate+"\t\t\t반납일 :"+returnDate);
//		System.out.println("예약일: :"+reservDate+"\t\t\t예약자 :"+reservId);
//		System.out.println("연장기간 : "+dateOfExtens+"\t\t연체기간: :"+overdue);
//		System.out.println("--------------------------------------------------------------");  
//
//    }
//	
//	
//
//
//	    
//	    
//	    
//	    
//	
//	
//	
//	
//}
//
//
//}
