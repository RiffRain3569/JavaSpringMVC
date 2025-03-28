package com.tom.mvc.global.jwt;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtAdminPayloadDto {
    private final Long adminId;

    public static JwtAdminPayloadDto from(Claims claim) {
        return new JwtAdminPayloadDto(Long.valueOf(claim.get("adminId").toString()));
    }
}
