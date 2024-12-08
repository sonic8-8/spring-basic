package com.chain.springbasic.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @DisplayName("빈의 생성과 초기화, 소멸 전 콜백 시점을 확인할 수 있다.")
    @Test
    void test() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(NetworkConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class NetworkConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://basic-spring.dev");
            return networkClient;
        }
    }
}
