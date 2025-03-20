package com.tom.mvc.domain.user.api.request;

import com.tom.mvc.domain.user.enums.UserStat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserGetUserReq {
    private Collection<Long> ids;
    private Collection<UserStat> stats;
    private String searchWord;
}
