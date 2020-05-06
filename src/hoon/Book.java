package hoon;

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
	

	//인스턴스 변수 초기
	Book(String title, String genre, String localData, String rentInfo,String author,int limitAge,String story,String launchDate,String bestTitle) {
		super(title, genre, localData);
		this.author = author;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.bestTitle = bestTitle;
		
	}
	
	Book(String title, String genre, String localData, String rentInfo,String author,int limitAge,String story,String launchDate,String bestTitle,int rentalCount,int like,int numOfItem,String returnDate) {
		super(title, genre, localData);
		this.author = author;
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
		System.out.println("저자 :"+author);
		
	}
	
	
	@Override
	void showAllinfo() {
		super.showBasicInfo();
		System.out.println("제한연령 :"+limitAge+"\t출판일 :"+launchDate+"\t인기자료 :"+bestTitle+"\r\n설명 :"+story);
		System.out.println("대여횟수 :"+rentalCount+"\t관심수 :"+like+"\t재고 :"+numOfItem+"\t반납예정일 :"+returnDate);
		
	}
	
	

}
