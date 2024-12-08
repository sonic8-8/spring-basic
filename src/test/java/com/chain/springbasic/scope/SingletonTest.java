package com.chain.springbasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @DisplayName("싱글톤 스코프로 생성한 빈은 싱글톤 빈이다.")
    @Test
    void singletonScope() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        // when
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        // then
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
    }

    @DisplayName("프로토타입 빈은 요청할 때마다 새로 생성된다")
    @Test
    void prototypeScope() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        // when
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        // then
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }



    @Scope("singleton")
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean destroy");
        }
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean destroy");
        }
    }
}
