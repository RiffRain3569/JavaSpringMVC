package com.tom.mvc.domain.user.application;

import com.tom.mvc.domain.user.api.request.UserPostUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;

public interface UserModifyUseCase {

    UserGetUserRes postUser(UserPostUserReq req);
}
