package section01.storemanage.run;

import section01.storemanage.service.StoreService;

import java.util.Scanner;

public class Application {

    private static final StoreService ss = new StoreService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("===== 상품 관리 프로그램 =====");
            System.out.println("1. 모든 상품 조회");
            System.out.println("2. 상품 찾기");
            System.out.println("3. 상품 수정");
            System.out.println("4. 상품 삭제");
            System.out.println("5. 상품 등록");
            System.out.println("9. 프로그램 종료");
            System.out.print("몇 번을 입력하시겠습니까? : ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ss.findAllProducts(); break;
                case 2: ss.findProductsBy(chooseProNum()); break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9:
                    System.out.println("상품관리 프로그램을 종료합니다. "); return;
                default:
                    System.out.println("숫자 입력 다시");
            }
        }
    }

    private static int chooseProNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("찾고자 하는 상품 번호를 입력하세요 : ");
        return sc.nextInt();

    }
}
