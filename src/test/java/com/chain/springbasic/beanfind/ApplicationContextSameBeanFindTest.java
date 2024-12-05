package com.chain.springbasic.beanfind;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.member.MemberRepository;
import com.chain.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    @Test
    void findBeanByDuplicateType() {
        // given when then
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    @Test
    void findBeanByName() {
        // given
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);

        // when then
        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }

    @DisplayName("특정 타입을 모두 조회하기")
    @Test
    void test() {
        // given when
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("Key: " + key + " Object: " + beansOfType.get(key));
        }
        // then
        assertThat(beansOfType).hasSize(2);

    }

}
