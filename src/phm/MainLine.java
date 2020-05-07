package phm;

public class MainLine {

    public static void main(String[] args) {

        boolean loginCheck = false;
        AdminManager manager = AdminManager.getInstance();
        MemberManager memManager =new MemberManager(null, null, null, null);

        while (true) {
            System.out.println("메인메뉴");
            System.out.println("1. 검색/대여 | 2.로그인 | 3.이용안내/회원가입 | 4.로그아웃");

            int selectNum = manager.sc.nextInt();

            switch (selectNum) {

                case 1:
                	memManager.showInfo();
                case 2:

                    System.out.println("1. 회원 | 2.관리자");
                    selectNum = manager.sc.nextInt();

                    switch (selectNum){
                        case 1:
                            manager.login();
                            break;
                        case 2:
                            System.out.println("아이디를 입력해 주세요.");
                            System.out.println("비밀번호를 입력해 주세요.");
                            
                            break;
                    }
                    break;
                case 3:

                    System.out.println("1. 이용안내 | 2.회원가입");
                    selectNum = manager.sc.nextInt();

                    switch (selectNum){
                        case 1:
                            System.out.println("이용안내 출력");
                            break;
                        case 2:
                            System.out.println("회원가입을 시작합시다");

                            System.out.println("이력쭉 후 가입 완료");
                            break;
                    }
                    break;
                case 4:

                    System.out.println("로그아웃 되었습니다. /n 프로그램 종료");
                    break;
            }

        }
    }
}
