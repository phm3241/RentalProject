package hoon;

public class Book extends RentalItemInfo{
	
	String author;		//저자
	String limitAge;	//제한연령
	String story;		//설명
	String launchDate;	//출판일
	String bestTitle;	//인기자료
	String rentalCount;	//대여횟수
	String like;		//관심수
	String numOfItem;	//재고
	String returnDate;	//반납예정일
	

	//인스턴스 변수 초기
	Book(String title, String genre, String localData, String rentInfo,String author,String limitAge,String story,String launchDate,String bestTitle) {
		super(title, genre, localData, rentInfo);
		this.author = author;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.bestTitle = bestTitle;
		
	}
	
	Book(String title, String genre, String localData, String rentInfo,String author,String limitAge,String story,String launchDate,String bestTitle,String rentalCount,String like,String numOfItem,String returnDate) {
		super(title, genre, localData, rentInfo);
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
	void showInfo() {
		super.showInfo();
		System.out.println("저자 :"+author+"\t제한연령 :"+limitAge+"\t설명 :"+story+"\t출판일 :"+launchDate+"\t인기자료 :"+bestTitle);
		System.out.println("대여횟수 :"+rentalCount+"\t관심수 :"+like+"\t재고 :"+numOfItem+"\t반납예정일 :"+returnDate);
		
	}
	
	
	

}
