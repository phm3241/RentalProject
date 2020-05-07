package jaeyoung96;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbsAdminManager {

	private ArrayList<Member> member;
    Scanner sc;

    //아이템배열 선언
    private ArrayList<Book> books;

	private ArrayList<DVD> dvd;
    private ArrayList<Game> game;
    
    private AbsAdminManager() {
        this.member = new ArrayList<Member>();
        this.books = new ArrayList<>();
        this.dvd = new ArrayList<>();
        this.game = new ArrayList<>();
        sc = new Scanner(System.in);
    }

	//1. 회원관리
	//1.1 회원정보보기
	void showInfo(){}
	//1.2 회원정보추가
	void addInfo(){}
	//1.3 회원정보수정
	void editInfo(){}
	//1.4 회원정보삭제
	void deleteInfo(){}
	//1.5 회원로그인
	void login(){}
	//1.5.1 회원 로그아웃
	void logOut(){}
	//1.6 관리자 로그인
	void adminLogin(){}
	//1.6.1 관리자 로그아웃
	void adminLogOut(){}
	//1.7회원정보 검색
	int searchIndex(String id) {return 0;}
	//로그인체크
	int loginCheckIndex() {
			return 0;
    }
	
	
	
	//자료관리
	//2.1도서보기
	void showBookInfo() {}
	//2.2도서자료추가
	//void addBookInfo(Book info);
	//2.3도서자료수정
	void editBookInfo(){}
	//2.4도서자료삭제
	void deleteBookInfo(){}
	//2.5도서정보검색
	int searchBookInfo(String title){
		return 0;
	}
	//자료관리
	//3.DVD보기
	void showDvdInfo(){}
	//3.DVD자료추가
	//void addDvdInfo(DVD info);
	//3.3DVD자료수정
	void editDvdInfo(){}
	//3.4DVD자료삭제
	void deleteDvdInfo(){}
	//3.5도서정보검색
	int searchDvdInfo(String title){
		return 0;
	}
	
	//자료관리
	//4.1게임보기
	void showGameInfo(){}
	//4.2게임자료추가
	//void addGameInfo(Game info);
	//4.3게임자료수정
	void editGameInfo(){}
	//4.4게임자료삭제
	void deleteGameInfo(){}
	//4.5도서정보검색
	int searchGameInfo(String title){return 0;}
	
	Book createBookInfo(){return createBookInfo();}
	DVD createDvdInfo(){return createDvdInfo();}
	Game CreateGameInfo(){return CreateGameInfo();}
}
