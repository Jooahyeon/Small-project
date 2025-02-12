package MemberRf.service;

/* 설명. 트랜잭션 처리(성공 실패에 따라 commit/rollback) 및
    회원관리 비즈니스 로직 처리(유효성검사, 회원추가삭제의 흐름처리, 값의 가공처리 등 DB들어가기 전 처리)
     얘 다음은 repository로 처리함*/

import MemberRf.aggregate.Member;
import MemberRf.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {

    private final MemberRepository mr = new MemberRepository();           //Repository에 있는 걸 갖다 쓸 수 있음

    public void findAllMembers() {                                        //서비스계층부터는 이름을 좀 달리함(대게)
        ArrayList<Member> findMembers = mr.selectAllMembers();    
        //순수 자바이기에 조회의 결과를 자바에서 담고 있어야함 =>Arraylist활용
        System.out.println("Service에서 조회 확인:");
        for (Member member : findMembers) {
            System.out.println(member);
        }
   
    }

    public void findMemberBy(int memNo) {
        Member findMember = mr.selectMemberBy(memNo);

        if(findMember != null) {
            System.out.println("회원 조회 성공: " + findMember);
        } else {
            System.out.println(memNo + "번 회원은 없습니다.");
        }
    }
}
