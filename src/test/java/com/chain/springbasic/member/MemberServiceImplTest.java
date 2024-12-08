package com.chain.springbasic.member;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceImplTest {

    @DisplayName("싱글톤 컨테이너에 등록되면 객체는 한 번만 생성되고 공유된다.")
    @Test
    void configurationTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        // when then
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @DisplayName("@Configuration은 AppConfig에 CGLIB 라이브러르의 바이트코드 조작을 통해 AppConfig@CGLIB로 만들고 이를 스프링 빈으로 등록한다.")
    @Test
    void configurationTestDeep() {
        // 출력용 테스트
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.toString());
    }

}