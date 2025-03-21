package com.tom.mvc.domain.user.application;

import com.tom.mvc.domain.user.api.request.UserPostUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;
import com.tom.mvc.domain.user.exception.UserErrorType;
import com.tom.mvc.domain.user.exception.UserException;
import com.tom.mvc.domain.user.persistence.entity.User;
import com.tom.mvc.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class UserModifyService implements UserModifyUseCase {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserGetUserRes postUser(UserPostUserReq req) {
        User duplicateUser = userJpaRepository.findByEmail(req.getEmail()).orElse(null);

        if (Objects.nonNull(duplicateUser)) {
            if (duplicateUser.getEmail().equalsIgnoreCase(req.getEmail())) {
                throw new UserException(UserErrorType.USER_SIGN_UP_DUPLICATE_EMAIL);
            }
        }
        
        User user = userJpaRepository.save(User.create(req));
        return UserGetUserRes.from(user);
    }
}
