package com.tom.mvc.global.jwt;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtClientPayloadDto {
    private final Long adminId;

    public static JwtClientPayloadDto from(Claims claim) {
        return new JwtClientPayloadDto(Long.valueOf(claim.get("adminId").toString()));
    }

}
