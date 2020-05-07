package jaeyoung96;

import java.util.ArrayList;
import java.util.Scanner;





public class AdminManager implements RentalInterface {

	
	//아이템배열 선언
	private ArrayList<Book> books;
	private ArrayList<DVD> dvd;
	private ArrayList<Game> game;
	
	//입력받을 스캐너 객체 생성
	Scanner sc;
	
	//생성자를 통해 아이템 배열 생성,요소의 개수 초기화
	AdminManager (){
		books = new ArrayList<>();
		dvd = new ArrayList<>();
		game = new ArrayList<>();
		sc = new Scanner(System.in);
	}
	private static AdminManager admin = new AdminManager();
	public static AdminManager getInstance() {
		return admin;
	}
	
	//회원정보
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminLogin() {
		// TODO Auto-generated method stub
		
	}
	
	//책입니다---------------------------------------------

	//자료관리
	//도서 정보보기
	@Override
	public void showBookInfo() {
		System.out.println("책정보 출력");
		for(int i=0;i<books.size();i++) {
			books.get(i).showAllinfo();
			System.out.println("-------------");
		}
		
		
	}
	
	//create로 이동
//	@Override
	//도서 정보넣기
//	public void addBookInfo(Book info) {
//		//배열에 추가
//		books.add(info);
//		
//		
//	}
	//도서정보수정
	@Override
	public void editBookInfo() {
		
		System.out.println("변경하고자하는 책 이름을 입력해주세요");
		String title = sc.nextLine();
		
		int index = searchBookInfo(title);

		
		if(index<0) {
			System.out.println("찾으시는 책의 정보가 존재하지 않습니다.");
		}
		else {
			String editTitle = books.get(index).title;
			
			System.out.println("수정 사항을 입력합니다");
			System.out.println("책 이름은: "+editTitle+"입니다");
			System.out.println("자료위치는");
			String localData = sc.nextLine();
			
			books.get(index).localData = localData;
			
			
		}
	}
	//도서정보삭제
	@Override
	public void deleteBookInfo() {
		System.out.println("삭제하고자 하는 책 이름을 선택하여주세요");
		String title = sc.nextLine();
		int index = searchBookInfo(title);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 책이 존재하지 않습니다.");
		}else {
			books.remove(index);
		}
		
	}
	
	//도서정보 검색
	@Override
	public int searchBookInfo(String title) {
		 //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }
		
//DVD입니다----------------------------------------------
	//DVD정보출력
	@Override
	public void showDvdInfo() {
		System.out.println("DVD정보 출력");
		for(int i=0;i<dvd.size();i++) {
			dvd.get(i).showAllinfo();
			System.out.println("-------------");
		}
		
		
		
	}
	
	//create로 이동
//DVD추가
//	@Override
//	public void addDvdInfo(DVD info) {
//		dvd.add(info);
//		
//	}
	
//DVD수정
	@Override
	public void editDvdInfo() {
		System.out.println("변경하고자하는 DVD 이름을 입력해주세요");
		String title = sc.nextLine();
		
		int index = searchDvdInfo(title);
		
		if(index<0) {
			System.out.println("찾으시는 책의 정보가 존재하지 않습니다.");
		}
		else {
			String editTitle = dvd.get(index).title;
			
			System.out.println("수정 사항을 입력합니다");
			System.out.println("DVD 이름은: "+editTitle+"입니다");
			System.out.println("자료위치는");
			String localData = sc.nextLine();
			
			dvd.get(index).localData=localData;
		}
		
	}
//DVD삭제
	@Override
	public void deleteDvdInfo() {
			System.out.println("삭제하고자 하는 DVD 이름을 선택하여주세요");
			String title = sc.nextLine();
			int index = searchDvdInfo(title);
			
			if(index<0) {
				System.out.println("삭제하고자 하는 DVD가 존재하지 않습니다.");
			}else {
				dvd.remove(index);
			}

		
	}
//DVD검색
	@Override
	public int searchDvdInfo(String title) {
		//정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < game.size(); i++) {
            if (dvd.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

//게임입니다---------------------------------------------------
	//게임보기
	@Override
	public void showGameInfo() {
		System.out.println("게임정보 출력");
		for(int i=0;i<game.size();i++) {
			game.get(i).showAllinfo();
			System.out.println("-------------");
		}
		
	}
	//create쪽으로 넣음
//게임추가
//	@Override
//	public void addGameInfo(Game info) {
//		game.add(info);
//		
//	}
//게임수정
	@Override
	public void editGameInfo() {
		System.out.println("변경하고자하는 게임 이름을 입력해주세요");
		String title = sc.nextLine();
		
		int index = searchGameInfo(title);

		
		if(index<0) {
			System.out.println("찾으시는 게임의 정보가 존재하지 않습니다.");
		}
		else {
			String editTitle = game.get(index).title;
			
			System.out.println("수정 사항을 입력합니다");
			System.out.println("게임 이름은: "+editTitle+"입니다");
			System.out.println("자료위치는");
			String localData = sc.nextLine();
			game.get(index).localData=localData;
			
		}
		
	}
//게임삭제
	@Override
	public void deleteGameInfo() {
		System.out.println("삭제하고자 하는 게임 이름을 선택하여주세요");
		String title = sc.nextLine();
		int index = searchDvdInfo(title);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 게임이 존재하지 않습니다.");
		}else {
			dvd.remove(index);
		}
		
	}
//게임검색
	@Override
	public int searchGameInfo(String title) {
		//정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
	}

	//정보 입력단계------------------------------------------------------
	//책 정보 입력
	@Override
	public Book createBookInfo() {
			
			Book info =null;			

			String title=null;
			String genre=null;
			String localData=null;
			String rentInfo=null;
			
			// 기본정보 수집: 책이름, 장르, 책위치, 대여상태
			
			System.out.println("책이름을 입력해주세요.");
			title = sc.nextLine();
			
			System.out.println("장르을 입력해주세요.");
			genre = sc.nextLine();
			
			System.out.println("자료위치를 입력해주세요.");
			localData = sc.nextLine();
			
			System.out.println("대여상태를 입력해주세요.");
			rentInfo = sc.nextLine();
			
			
			System.out.println("저자를 입력해주세요");
			String author = sc.nextLine();
			System.out.println("연령제한 입력해주세요");
			int limitAge = sc.nextInt();
			System.out.println("설명을 입력해주세요");
			String story = sc.nextLine();	//설명
			System.out.println("출판일을 입력해주세요");
			int launchDate= sc.nextInt();	//출판일

			

			info = new Book(title, genre, localData, rentInfo,
					author, limitAge, story, launchDate);
				
			//배열에 추가
			books.add(info);
			return info;
	
}
	//DVD 정보 입력
	@Override
	public DVD createDvdInfo() {
		DVD info =null;			

		String title=null;
		String genre=null;
		String localData=null;
		String rentInfo=null;
		
		// 기본정보 수집: DVD이름, 장르, DVD위치, 대여상태
		
		System.out.println("책이름을 입력해주세요.");
		title = sc.nextLine();
		
		System.out.println("장르을 입력해주세요.");
		genre = sc.nextLine();
		
		System.out.println("자료위치를 입력해주세요.");
		localData = sc.nextLine();
		
		System.out.println("대여상태를 입력해주세요.");
		rentInfo = sc.nextLine();
		
		
		System.out.println("감독를 입력해주세요");
		String foreman = sc.nextLine();
		
		System.out.println("상영시간을 입력해주세요");
		String runingTime = sc.nextLine();
		
		System.out.println("연령제한 입력해주세요");
		int limitAge = sc.nextInt();
		
		System.out.println("설명을 입력해주세요");
		String story = sc.nextLine();	//설명
		
		System.out.println("출판일을 입력해주세요");
		int launchDate= sc.nextInt();	//출판일
		

		
		//DVD 클래스로 인스턴스생성
		info = new DVD(title, genre, localData, rentInfo, foreman, 
				runingTime, limitAge, story, launchDate);
		
		//배열에 추가
		dvd.add(info);
			
		return info;
	}
	//Game 정보 입력
	@Override
	public Game CreateGameInfo() {
		Game info =null;			

		String title=null;
		String genre=null;
		String localData=null;
		String rentInfo=null;
		
		// 기본정보 수집: 게임이름, 장르, 게임위치, 대여상태
		
		System.out.println("책이름을 입력해주세요.");
		title = sc.nextLine();
		
		System.out.println("장르을 입력해주세요.");
		genre = sc.nextLine();
		
		System.out.println("자료위치를 입력해주세요.");
		localData = sc.nextLine();
		
		System.out.println("대여상태를 입력해주세요.");
		rentInfo = sc.nextLine();
		
		
		System.out.println("제작자를 입력해주세요");
		String producer = sc.nextLine();
		
		System.out.println("연령제한 입력해주세요");
		int limitAge = sc.nextInt();
		
		System.out.println("설명을 입력해주세요");
		String story = sc.nextLine();	//설명
		
		System.out.println("출판일을 입력해주세요");
		int launchDate= sc.nextInt();	//출판일
		

		

		
		//2.2.3 Book 클래스로 인스턴스생성
		info = new Game(title, genre, localData, rentInfo, 
				producer, limitAge, story, launchDate);
			
		//배열에 추가
		game.add(info);
		return info;
	}
	
}