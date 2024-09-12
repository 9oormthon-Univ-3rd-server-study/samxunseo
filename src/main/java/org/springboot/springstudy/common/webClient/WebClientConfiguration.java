package org.springboot.springstudy.common.webClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient webClient(){
        // 애플리케이션에서 외부 HTTP 통신을 위한 도구
        return WebClient.builder().build();
    }
}
