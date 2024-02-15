package start.hellostart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.hellostart.repository.MemberRepository;
import start.hellostart.repository.MemoryMemberRepository;
import start.hellostart.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
