package com.tom.mvc.domain.user.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostUserReq {
    private String name;
    private String email;
}
