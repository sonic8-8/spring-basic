package com.chain.springbasic.order;

import com.chain.springbasic.discount.DiscountPolicy;
import com.chain.springbasic.discount.FixDiscountPolicy;
import com.chain.springbasic.member.Member;
import com.chain.springbasic.member.MemberRepository;
import com.chain.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}