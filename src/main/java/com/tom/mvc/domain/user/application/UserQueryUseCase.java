package com.tom.mvc.domain.user.application;

import com.tom.mvc.domain.user.api.request.UserGetUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserQueryUseCase {
    Page<UserGetUserRes> getUsers(UserGetUserReq req, Pageable pageable);
}
