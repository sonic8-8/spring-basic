package com.chain.springbasic.xml;

import com.chain.springbasic.member.MemberService;
import com.chain.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlApplicationContext {

    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @DisplayName("XML 설정 파일로 스프링 컨테이너를 생성할 수 있다.")
    @Test
    void test() {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // when then
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
