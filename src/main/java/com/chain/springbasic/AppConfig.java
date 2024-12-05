package com.chain.springbasic;

import com.chain.springbasic.discount.DiscountPolicy;
import com.chain.springbasic.discount.FixDiscountPolicy;
import com.chain.springbasic.member.MemberRepository;
import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import com.chain.springbasic.member.MemoryMemberRepository;
import com.chain.springbasic.order.OrderService;
import com.chain.springbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService MemberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService OrderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
