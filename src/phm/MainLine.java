package phm;

import java.util.Scanner;

public class MainLine {

	public static void main(String[] args) {

		AdminManager adm = AdminManager.getInstance();
		MemberManager mem = new MemberManager();
		Scanner sc = new Scanner(System.in);
		boolean loginCheck = false;

		while (true) {
			System.out.println("메인메뉴");
			System.out.println("1. 검색/대여 | 2.로그인  | 3. 이용안내/회원가입  | 4.내 대여내역(반납/연장) | 5.로그아웃 | 6.관리자");

			int selectNum = sc.nextInt();

			switch (selectNum) {

			case 1:
				mem.showInfo();
				break;
			case 2:
				if (adm.loginCheck()) {
					System.out.println("이미 로그인 중입니다.");
					break;
				} else {
					adm.login();
					break;
				}

			case 3:
				System.out.println("1. 이용안내 | 2.회원가입");
				selectNum = sc.nextInt();

				switch (selectNum) {
				case 1:
					System.out.println("이용안내 출력");
					break;
				case 2:
					adm.addInfo();
					break;
				}
				break;

			case 4:
				if (adm.loginCheck()) {
					mem.returnExten();
					break;
				} else {
					System.out.println("먼저 로그인 해주세요.");

					continue;
				}

			case 5:
				adm.logOut();
				System.out.println("로그아웃 되었습니다. /n 프로그램 종료");
				break;
			}

		}
	}
}
