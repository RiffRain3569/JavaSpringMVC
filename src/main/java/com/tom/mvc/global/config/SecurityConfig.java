package com.tom.mvc.global.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] IGNORE_URI = {
            "/**",
    };

    @PostConstruct
    public void enableSecurityContextHolderStrategy() {
        // 메인, 자식 스레드 모두 Security Context Holder 를 공유한다.
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring().requestMatchers(IGNORE_URI);
    }

}
