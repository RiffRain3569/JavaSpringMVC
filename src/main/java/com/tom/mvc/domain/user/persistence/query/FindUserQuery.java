package com.tom.mvc.domain.user.persistence.query;

import com.tom.mvc.domain.user.api.request.UserGetUserReq;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FindUserQuery {
    private Collection<Long> ids;
    private Collection<String> stats;
    private String searchWord;


    public static FindUserQuery from(UserGetUserReq req) {
        return new FindUserQuery(
                req.getIds(),
                Objects.isNull(req.getStats()) || req.getStats().isEmpty() ? null : req.getStats().stream().map(Enum::name).collect(Collectors.toList()),
                req.getSearchWord()
        );
    }
}
