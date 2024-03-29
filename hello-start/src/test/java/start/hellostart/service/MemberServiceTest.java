package start.hellostart.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import start.hellostart.domain.Member;
import start.hellostart.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        //memberService = new MemberService();
    }
    @AfterEach
    public void AfterEach(){
        memberRepository.clearStore();
    }
    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberRepository.findById(saveId).get();
        Assertions.assertEquals(member.getName(),findMember.getName());
    }
    @Test
    public void 중복_회원_예외()throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,()->memberService.join(member2));
        //then
        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


    }
}
