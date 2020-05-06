package hoon;

public class RentalItemInfo {
	
	String title;		//자료명
	String genre;		//장르
	String localData;	//자료위치
	String rentInfo;	//대여상태
	
	
	//인스턴스 변수 초기화
	RentalItemInfo(String title,String genre,String localData,String rentInfo){
		this.title = title;
		this.genre = genre;
		this.localData = localData;
		this.rentInfo = rentInfo;
		
	}
	
	//기본정보 출력 메서드
	void showInfo() {
		System.out.println("자료명 : "+title+"\t장르 :"+genre+"\t자료위치 :"+localData+"\t대여상태 :"+rentInfo);
	}
	

}
