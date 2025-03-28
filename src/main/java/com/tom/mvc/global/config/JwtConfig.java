package com.tom.mvc.global.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class JwtConfig {

    @Value("${project.jwt.client.access.secret}")
    private String clientAccessSecretKey;

    @Value("${project.jwt.client.access.expiration}")
    private long clientAccessExpiration;

    @Value("${project.jwt.client.refresh.secret}")
    private String clientRefreshSecretKey;

    @Value("${project.jwt.client.refresh.expiration}")
    private long clientRefreshExpiration;


    @Value("${project.jwt.admin.access.secret}")
    private String adminAccessSecretKey;

    @Value("${project.jwt.admin.access.expiration}")
    private long adminAccessExpiration;

    @Value("${project.jwt.admin.refresh.secret}")
    private String adminRefreshSecretKey;

    @Value("${project.jwt.admin.refresh.expiration}")
    private long adminRefreshExpiration;

}
