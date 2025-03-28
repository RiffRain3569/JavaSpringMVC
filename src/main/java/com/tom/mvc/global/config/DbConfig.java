package com.tom.mvc.global.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DbConfig {
    
    @Value("${project.db.crypt.secret}")
    private String secretKey;

    @Value("${project.db.crypt.iv}")
    private String iv;


}
