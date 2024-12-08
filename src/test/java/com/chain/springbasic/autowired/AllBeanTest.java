package com.chain.springbasic.autowired;

import com.chain.springbasic.AutoAppConfig;
import com.chain.springbasic.discount.DiscountPolicy;
import com.chain.springbasic.member.Grade;
import com.chain.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        public int discount(Member member, int price, String discountPolicyCandidate) {
            DiscountPolicy discountPolicy = policyMap.get(discountPolicyCandidate);

            return discountPolicy.discount(member, price);
        }
    }

    @DisplayName("컬렉션을 이용해 동적으로 모든 빈을 조회할 수 있다.")
    @Test
    void findAllBean() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int fixDiscountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        // then
        assertThat(fixDiscountPrice).isEqualTo(1000);
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }
}
