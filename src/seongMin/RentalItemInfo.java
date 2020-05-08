package seongMin;

public class RentalItemInfo {

	String title;		//자료명
	String genre;		//장르
	String localData;	//자료위치
	String rentInfo;	//대여상태


	//인스턴스 변수 초기화
	RentalItemInfo(String title,String genre,String localData){
		this.title = title;
		this.genre = genre;
		this.localData = localData;
		this.rentInfo = "대여가능" ;

	}

	public RentalItemInfo() {
		// TODO Auto-generated constructor stub
	}

	//기본정보 출력 메서드
	void showBasicInfo() {
		System.out.println("자료명 : "+title+"\t\t장르 :"+genre+"\t\t\t자료위치 :"+localData+"\t\t대여상태 :"+rentInfo);
	}

	void showAllinfo() {


	}

	boolean checkTitle(String title) {
		return this.title.equals(title);
	}


}
