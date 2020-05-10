package master;

import java.time.LocalDateTime;
import java.util.ArrayList;

//import data.UserList;
//import data.UserList10;
//import data.UserList11;
//import data.UserList12;
//import data.UserList13;
//import data.UserList14;
//import data.UserList15;
//import data.UserList16;
//import data.UserList2;
//import data.UserList3;
//import data.UserList4;
//import data.UserList5;
//import data.UserList6;
//import data.UserList7;
//import data.UserList8;
//import data.UserList9;

public class MemberManager {

	String title = null; // 자료명
//	String rentalDate=null; 	// 대여일#
//	String returnDate=null;		// 반납일#
	public ArrayList<RentalList> rentalList;

	// 회원리스트, 자료리스트 불러오기
	public AdminManager adm = AdminManager.getInstance();

	// 기본생성자, 대여리스트 생성
	public MemberManager() {
		rentalList = new ArrayList<>();
	}
	
		
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 로그인한 id의 정보를 반환하는 메서드
	public Member getloginIdInfo() {

		// 로그인한 회원 Id의 인덱스 찾고,
		int index = adm.loginCheckIndex();

		// 그 회원의 정보 반환
		Member loginIdInfo = null;
		loginIdInfo = adm.getMember().get(index);

		return loginIdInfo;
	}

	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 전체 rentalList 에서 title로 검색하기 ㅡ> 인덱스 반환
	public int searchRentalIndexTitle(String title) {

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
	public int checkTitle(String title) {
		String id = getloginIdInfo().getId();
		System.out.println(title);
		System.out.println(id);
		
		int index = 1;
		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).title.equals(title)) {

				rentalList.get(i).showRentalListInfo();
				index=i;

				}
		}
		return index;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 id로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	public void showMyRentalList() {

		String id = getloginIdInfo().getId();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id)) {

				rentalList.get(i).showRentalListInfo();

			}
		}

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 title로 검색하기(관리자사용) ㅡ> 인덱스 반환
	public void showTitleRentalList() {

		System.out.println("찾아보실 자료명을 입력해주세요.");
		String title = adm.sc.nextLine();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).title.equals(title)) {

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
	public void showGuide() {
		System.out.println("=====이용안내=====");
		System.out.println();
		System.out.println("대여자료 : 도서 / DVD / 게임");
		System.out.println("대여가능 자료수 : id당 5개");
		System.out.println("대여기간 : 자료당 7일");
		System.out.println();
		System.out.println("연장가능 횟수 : id당 1회");
		System.out.println("연장가능 일수 : 7일");
		System.out.println("연체시 연체일수만큼 대여불가");

	}
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//	// 작업하려다 못한 메서드.. 선택한 자료의 타입을 확인하고 아이템인덱스 반환.. 
//	// RentalItemInfo를 상속받아 작성된 Books, Dvd, Game이 ArrayList로 되어 있을 때, 다형성이 어떻게 되는지..
	
//	RentalItemInfo checkTypeIndex() {
//
//		int index = 0;
//		RentalItemInfo itemIndex = null;
//
//		if (adm.searchBookInfo(this.title) >= 0) {
//			index = adm.searchBookInfo(this.title);
//			itemIndex = adm.getBooks().get(index);
//			return itemIndex;
//
//		} else if (adm.searchDvdInfo(this.title) >= 0) {
//			index = adm.searchDvdInfo(this.title);
//			itemIndex = adm.getDvd().get(index);
//			return itemIndex;
//
//		} else if (adm.searchGameInfo(this.title) >= 0) {
//			index = adm.searchGameInfo(this.title);
//			itemIndex = adm.getGame().get(index);
//			return itemIndex;
//		}
//		return itemIndex;
//	}
	
	
} //class end
