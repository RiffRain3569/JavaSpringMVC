package com.tom.mvc.infrastructure.auth.api.response;

import com.tom.mvc.infrastructure.auth.persistence.entity.AuthToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthGetTokenRes {
    private Long id;
    private String token;
    private String ip;
    private String agent;

    public static AuthGetTokenRes from(AuthToken entity) {
        return new AuthGetTokenRes(
                entity.getId(),
                entity.getToken(),
                entity.getIp(),
                entity.getAgent()
        );
    }
}
