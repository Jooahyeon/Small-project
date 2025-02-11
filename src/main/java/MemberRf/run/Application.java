package MemberRf.run;
// 프론트엔드 역할 R/V(view)의 역할

import MemberRf.service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();           //백엔드 시작
    // final => 객체가 한번 들어오면 하나만 고정
    // 즉, 해당 메뉴에 대해서 처리하는 객체는 하나로 고정하고 시작
    // (결론 서비스객체(요청받는)는 하나면 된다, 사용자마다 하나의 객체만 사용한다)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====== 회원관리프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");                 //soft delete(다 삭제되지않고 기록은 남는?)
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴를 선택해주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ms.findAllMembers(); break;
                case 2: ms.findMemberBy(chooseMemNo());break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9:                                  //프로그램 종료(main메소드 종료)
                    System.out.println("회원관리 프로그램을 종료합니다. "); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다");
            }
        }
    }
    /* 설명. 회원 번호를 입력 받아 int로 반환하는 메소드 */
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 번호를 입력하세요: ");
        return sc.nextInt();
    }
}
