package com.tom.mvc.global.config;

import com.tom.mvc.global.security.JwtAdminFilter;
import com.tom.mvc.global.security.JwtClientFilter;
import com.tom.mvc.global.security.RestApiFilter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] IGNORE_URI = {
//             "/**" // 임시
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/v1/**").authenticated()
                        .requestMatchers("/api/**").authenticated()
                        .requestMatchers("/signIn", "/signUp", "/admin/signIn").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtClientFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAdminFilter(), JwtClientFilter.class)
                .addFilterBefore(new RestApiFilter(), JwtAdminFilter.class);


        return http.build();
    }
}
