package master;

import java.util.Scanner;

public class MainLine {

    public static void main(String[] args) {

        AdminManager adm = AdminManager.getInstance();
        MemberManager mem = new MemberManager();
        Scanner sc = new Scanner(System.in);
        boolean loginCheck = false;

        while (true) {
            System.out.println("메인메뉴");
            System.out.println("1. 검색/대여 | 2.로그인 | 3.이용안내/회원가입 | 4. 내 대여내역(반납/연장) | 5.로그아웃 | 6.관리자페이지");

            int selectNum = sc.nextInt();

            switch (selectNum) {

        		//1. 검색/대여-----------------------------
                case 1:
                    mem.showInfo();
                    break;
                    
                //2. 로그인-----------------------------
                case 2:
                	if(adm.loginCheck()) {
                		System.out.println("이미 로그인 중입니다.");
                		break;
                	}else {
                		adm.login();
    					break;
                	}
                    
                //3.회원가입/이용안내-----------------------------
                case 3:

                    System.out.println("1. 이용안내 | 2.회원가입");
                    selectNum = sc.nextInt();

                    switch (selectNum){
                        case 1:
                            System.out.println("이용안내 출력");
                            break;
                        case 2:
                            adm.addInfo();
                            break;
                    }
                    break;
                    
                //4. 내 대여내역-----------------------------
                case 4:
                	if (adm.loginCheck()) {
    					mem.returnExtends();
    					break;
    				} else {
    					System.out.println("먼저 로그인 해주세요.");

    					continue;
    				}
                	
                //5.로그아웃-----------------------------
                case 5:
                	adm.logOut();
                    System.out.println("로그아웃 되었습니다.");
                	break;
                	
            	//6.관리자페이지-----------------------------
                case 6:
                	
                	adm.AdminLogin();
                	System.out.println("1. 회원관리 | 2. 도서관리 | 3. DVD관리 | 4. 게임관리 | 5. 로그아웃");
                	selectNum = sc.nextInt();
                	switch (selectNum) {
					case 1:
						RentalMenu.memeberView();
						break;
					case 2:
						RentalMenu.bookView();
						break;
					case 3:
						RentalMenu.dvdView();
						break;
					case 4:
						RentalMenu.gameView();
						break;
					case 5:
						break;

					}
                	break;
            }
            
            

        }
    }
}
