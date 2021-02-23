package jpastudy1.jpabulletin;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)       //스프링과 테스트 통합
@SpringBootTest                     //스프링부트를 띄우고 테스트함(안그러면 @Autowird 모두 실패)
@Transactional                      //반복 가능한 테스트를 지원. 테스트마다 트랜젝션 시작하고 끝나면 롤백(테스트에서만 롤백하기)
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("이보미");
        member.setNickname("borobom");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("이보미");

        Member member2 = new Member();
        member2.setName("이보미");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        //member2객체가 예외가 일어났는지 확인
        fail("==================예외발생해야한다====================");
    }

}