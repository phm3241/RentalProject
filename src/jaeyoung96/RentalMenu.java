package jaeyoung96;


public class RentalMenu {
	
	public static AdminManager adm = AdminManager.getInstance();
	MemberManager mem = new MemberManager();
	
	
	//6-1 관리자 페이지-회원관리
	public static void memeberView() {

        System.out.println("회원관리페이지입니다.");
        System.out.println("1.회원 상세정보 | 2.회원정보 수정 | 3.회원정보 삭제");
        int selectNum = adm.sc.nextInt();

        switch (selectNum){

            case 1:
                adm.showInfo();
            case 2:
                adm.editInfo();
            case 3:
                adm.deleteInfo();
        }
    
    }
	//6-2 관리자페이지-도서관리
	public static void bookView() {
		
		System.out.println("도서관리 페이지 입니다.");
		System.out.println("1. 도서 전체 정보 2. 도서추가 3. 도서수정 4. 도서삭제");
		
		int selectNum = adm.sc.nextInt();
		switch(selectNum) {
		
		case 1:
			adm.showBookInfo();
			break;
		case 2:
			adm.createBookInfo();
			break;
		case 3:
			adm.editBookInfo();
			break;
		case 4:
			adm.deleteBookInfo();
			break;
		}
	}
	
	//6-3 관리자페이지-DVD관리
		public static void dvdView() {
			
			System.out.println("도서관리 페이지 입니다.");
			System.out.println("1. DVD 전체 정보 2. DVD추가 3. DVD수정 4. DVD삭제");
			
			int selectNum = adm.sc.nextInt();
			switch(selectNum) {
			
			case 1:
				adm.showDvdInfo();
				break;
			case 2:
				adm.createDvdInfo();
				break;
			case 3:
				adm.editDvdInfo();
				break;
			case 4:
				adm.deleteDvdInfo();
				break;
			}
		}
		
		
		//6-4 관리자페이지-게임관리
		public static void gameView() {
			
			System.out.println("도서관리 페이지 입니다.");
			System.out.println("1. 게임 전체 정보 2. 게임추가 3. 게임수정 4. 게임삭제");
			
			int selectNum = adm.sc.nextInt();
			switch(selectNum) {
			
			case 1:
				adm.showGameInfo();
				break;
			case 2:
				adm.CreateGameInfo();
				break;
			case 3:
				adm.editGameInfo();
				break;
			case 4:
				adm.deleteGameInfo();
				break;
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
