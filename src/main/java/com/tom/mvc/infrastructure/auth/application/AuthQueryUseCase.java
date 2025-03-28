package com.tom.mvc.infrastructure.auth.application;

import com.tom.mvc.infrastructure.auth.api.request.AuthGetAuthReq;
import com.tom.mvc.infrastructure.auth.api.response.AuthGetAuthRes;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthQueryUseCase {
    List<AuthGetAuthRes> getAuths(AuthGetAuthReq req, Pageable pageable);
}
