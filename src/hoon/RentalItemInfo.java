package hoon;

public class RentalItemInfo {
	
	String title;		//자료명
	String genre;		//장르
	String localData;	//자료위치
	String rentInfo;	//대여상태
	String limitAge;	//제한연령
	String story;		//설명
	String launchDate;	//출판일, 출시일
	String bestTitle;	//인기자료
	
	//인스턴스 변수 초기화
	RentalItemInfo(String title,String genre,String localData,String rentInfo,String limitAge,String story,String launchDate,String bestTitle){
		this.title = title;
		this.genre = genre;
		this.localData = localData;
		this.rentInfo = rentInfo;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.bestTitle = bestTitle;
		
	}
	
	//기본정보 출력 메서
	void showInfo() {
		System.out.println("자료명 : "+title+"\t장르 :"+genre+"\t자료위치 :"+localData+"\t대여상태 :"+rentInfo+"\t제한연령 :"+limitAge+"\t설명 :"+story+"\t출판일 :"+launchDate+"\t인기자료 :"+bestTitle);
	}
	

}
