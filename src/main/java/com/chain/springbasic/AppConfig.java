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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    public MemberService memberService() {
//        System.out.println("call AppConfig.memberService");
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    public OrderService orderService() {
//        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        System.out.println("call AppConfig.memberRepository");
//        return new MemoryMemberRepository();
//    }
//
//    @Bean
//    public DiscountPolicy discountPolicy() {
//        System.out.println("call AppConfig.discountPolicy");
//        return new RateDiscountPolicy();
//    }

}
