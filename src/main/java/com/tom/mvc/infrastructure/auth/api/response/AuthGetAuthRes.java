package com.tom.mvc.infrastructure.auth.api.response;

import com.tom.mvc.infrastructure.auth.persistence.entity.Auth;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthGetAuthRes {
    private Long id;
    private Long userId;

    private List<AuthGetTokenRes> tokens;

    public static AuthGetAuthRes from(Auth entity) {
        return new AuthGetAuthRes(
                entity.getId(),
                entity.getUserId(),
                Objects.isNull(entity.getAuthTokens())
                        ? null
                        : entity.getAuthTokens().stream().map(AuthGetTokenRes::from).collect(Collectors.toList())
        );
    }
}
