package com.tom.mvc.domain.user.application;

import com.tom.mvc.domain.user.api.request.UserPostUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;
import com.tom.mvc.domain.user.persistence.entity.User;
import com.tom.mvc.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserModifyService implements UserModifyUseCase {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserGetUserRes postUser(UserPostUserReq req) {
        User user = userJpaRepository.save(User.create(req));
        return UserGetUserRes.from(user);
    }
}
