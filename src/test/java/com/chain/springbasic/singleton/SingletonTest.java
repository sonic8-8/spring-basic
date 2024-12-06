package com.chain.springbasic.singleton;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @DisplayName("스프링이 없는 순수한 DI 컨테이너는 요청이 들어올때마다 객체를 새로 생성한다.")
    @Test
    void pureContainer() {
        // given
        AppConfig appConfig = new AppConfig();

        // when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // then
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

}
