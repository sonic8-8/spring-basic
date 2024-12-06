package com.chain.springbasic.singleton;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @DisplayName("스프링이 없는 순수한 DI 컨테이너는 요청이 들어올때마다 객체를 새로 생성한다.")
    @Test
    void pureContainer() {
        // given
        AppConfig appConfig = new AppConfig();

        // when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // then
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @DisplayName("스프링 컨테이너는 여러개의 요청이 들어와도 이미 생성된 하나의 객체만을 공유한다.")
    @Test
    void springContainer() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // then
        assertThat(memberService1).isSameAs(memberService2);

    }

}
