package section03.run;

import section03.service.CatService;

import java.util.Scanner;

public class Application1 {

    private static final CatService cs = new CatService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("====== 고양이 관리 프로그램 ======");
            System.out.println("1. 모든 고양이 정보 보기");
            System.out.println("2. 고양이 찾기");
            System.out.println("3. 고양이 등록");
            System.out.println("4. 고양이 정보 수정");
            System.out.println("5. 고양이 정보 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: cs.findAllCats(); break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 5:  break;
                case 9:
                    System.out.println("회원관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }
}
