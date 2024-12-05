package com.chain.springbasic.member;

import com.chain.springbasic.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberService = appConfig.memberService();
    }

    @DisplayName("회원 가입 할 수 있다.")
    @Test
    void join() {
        // given
        Member member = new Member(1L, "member1", Grade.VIP);

        // when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(member1);
    }

}