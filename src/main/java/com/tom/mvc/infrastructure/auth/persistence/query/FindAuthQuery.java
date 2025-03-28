package com.tom.mvc.infrastructure.auth.persistence.query;

import com.tom.mvc.infrastructure.auth.api.request.AuthGetAuthReq;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FindAuthQuery {
    private Long userId;


    public static FindAuthQuery from(AuthGetAuthReq req) {
        return new FindAuthQuery(
                req.getUserId()
        );
    }
}
