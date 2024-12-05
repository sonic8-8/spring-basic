package com.chain.springbasic.order;

import com.chain.springbasic.AppConfig;
import com.chain.springbasic.member.Grade;
import com.chain.springbasic.member.Member;
import com.chain.springbasic.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        memberService = appConfig.MemberService();
        orderService = appConfig.OrderService();
    }

    @DisplayName("주문을 생성할 수 있다.")
    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        assertThat(order.getItemName()).isEqualTo("itemA");
    }

}