package com.chain.springbasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonServiceTest {

    @DisplayName("싱글톤 컨테이너는 요청이 여러 개 들어와도 하나의 객체만을 사용한다.")
    @Test
    void test() {
        // given when
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1: " + singletonService1);
        System.out.println("singletonService2: " + singletonService2);

        // then
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

}