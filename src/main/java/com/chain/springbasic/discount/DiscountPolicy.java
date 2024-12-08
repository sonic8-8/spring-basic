package com.chain.springbasic.discount;

import com.chain.springbasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
