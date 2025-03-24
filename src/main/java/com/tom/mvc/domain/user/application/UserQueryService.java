package com.tom.mvc.domain.user.application;

import com.tom.mvc.domain.user.api.request.UserGetUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;
import com.tom.mvc.domain.user.persistence.entity.User;
import com.tom.mvc.domain.user.persistence.query.FindUserQuery;
import com.tom.mvc.domain.user.persistence.repository.UserJpaRepository;
import com.tom.mvc.global.config.DbConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService implements UserQueryUseCase {

    private final UserJpaRepository userJpaRepository;
    private final DbConfig dbConfig;

    @Override
    public Page<UserGetUserRes> getUsers(UserGetUserReq req, Pageable pageable) {
        Page<User> users = userJpaRepository.findFetchAll(FindUserQuery.from(req), dbConfig, pageable);
        List<UserGetUserRes> contents = users.getContent().stream().map(UserGetUserRes::from).toList();
        return new PageImpl<>(contents, users.getPageable(), users.getTotalElements());
    }
}
