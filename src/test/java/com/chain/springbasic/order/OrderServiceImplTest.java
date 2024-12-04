package com.chain.springbasic.order;

import com.chain.springbasic.member.Grade;
import com.chain.springbasic.member.Member;
import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private final MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

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