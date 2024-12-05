package com.chain.springbasic.beanfind;

import com.chain.springbasic.discount.DiscountPolicy;
import com.chain.springbasic.discount.FixDiscountPolicy;
import com.chain.springbasic.discount.RateDiscountPolicy;
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

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixeDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    @Test
    void findBeanByParentTypeDuplicate() {
        // given when then
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    @Test
    void findBeanByName() {
        // given when
        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        // then
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("특정 하위 타입으로 조회할 수 있다. (권장 X)")
    @Test
    void findBeanBySubType() {
        // given
        RateDiscountPolicy discountPolicy = ac.getBean(RateDiscountPolicy.class);
        // when then
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("부모 타입으로 자식 빈을 모두 조회할 수 있다.")
    @Test
    void findAllBeanByParentType() {
        // given
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("Key: " + key + " Object: " + beansOfType.get(key));
        }
        // when then
        assertThat(beansOfType).hasSize(2);
    }

    @DisplayName("부모 타입으로 자식 빈을 모두 조회할 수 있다. - Object")
    @Test
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("Key: " + key + " Object: " + beansOfType.get(key));
        }
    }

}
