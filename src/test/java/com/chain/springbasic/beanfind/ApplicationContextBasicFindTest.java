package com.chain.springbasic.beanfind;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("이름으로 스프링 빈 조회가 가능하다")
    @Test
    void findBeanByName() {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // when then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("이름 없이 타입으로 스프링 빈 조회가 가능하다")
    @Test
    void findBeanByType() {
        // given
        MemberService memberService = ac.getBean(MemberService.class);
        // when then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @DisplayName("구체 타입으로 스프링 빈 조회가 가능하다")
    @Test
    void findBeanByImplName() {
        // given
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // when then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("등록되지 않은 빈은 예외가 발생한다")
    @Test
    void findBeanByNameX() {
        // given when then
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberServiceImpl.class));
    }

}
