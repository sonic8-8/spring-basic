package com.chain.springbasic;

import com.chain.springbasic.discount.DiscountPolicy;
import com.chain.springbasic.discount.FixDiscountPolicy;
import com.chain.springbasic.discount.RateDiscountPolicy;
import com.chain.springbasic.member.MemberRepository;
import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import com.chain.springbasic.member.MemoryMemberRepository;
import com.chain.springbasic.order.OrderService;
import com.chain.springbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
