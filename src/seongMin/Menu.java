package seongMin;

public class Menu {


    public static AdminManager adm = AdminManager.getInstance();

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
}
