package hoon;

public class DVD extends RentalItemInfo{
	
	String foreman;		//감독
	int runingTime;		//상영시간
	int limitAge;		//제한연령
	String story;		//설명
	int launchDate;		//출판일
	String bestTitle;	//인기자료
	int rentalCount;	//대여횟수
	int like;			//관심수
	int numOfItem;		//재고
	int returnDate;		//반납예정일

	//인스턴스 변수 초기화
	DVD(String title, String genre, String localData, String rentInfo,String foreman,String runingTime,int limitAge,String story,int launchDate,String bestTitle) {
		super(title, genre, localData, rentInfo);
		this.foreman = foreman;
		this.rentInfo = rentInfo;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.bestTitle = bestTitle;
	}
	
	DVD(String title, String genre, String localData, String rentInfo,String foreman,String runingTime,int limitAge,String story,int launchDate,String bestTitle,int rentalCount,int like,int numOfItem,int returnDate) {
		super(title, genre, localData, rentInfo);
		this.foreman = foreman;
		this.rentInfo = rentInfo;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.bestTitle = bestTitle;
		this.rentalCount = rentalCount;
		this.like = like;
		this.numOfItem = numOfItem;
		this.returnDate = returnDate;
	}
	

	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("감독 :"+foreman);
	}
	
	@Override
	void showAllinfo() {
		super.showBasicInfo();
		System.out.println("\t제한연령 :"+limitAge+"\t설명 :"+story+"\t출판일 :"+launchDate+"\t인기자료 :"+bestTitle+"\t상영시간 :"+runingTime);
		System.out.println("대여횟수 :"+rentalCount+"\t관심수 :"+like+"\t재고 :"+numOfItem+"\t반납예정일 :"+returnDate);
	}
	
	

}
