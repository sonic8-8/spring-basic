package com.chain.springbasic;

import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {

    @DisplayName("컴포넌트 스캔으로 스프링 빈을 등록할 수 있다.")
    @Test
    void test() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        // when then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }

}