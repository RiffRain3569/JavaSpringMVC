package com.tom.mvc.infrastructure.auth.api;

import com.tom.mvc.infrastructure.auth.api.request.AuthGetAuthReq;
import com.tom.mvc.infrastructure.auth.api.response.AuthGetAuthRes;
import com.tom.mvc.infrastructure.auth.application.AuthQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auths")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthQueryUseCase authQueryUseCase;

    @GetMapping
    public List<AuthGetAuthRes> getAuths(AuthGetAuthReq req, Pageable pageable) {
        return authQueryUseCase.getAuths(req, pageable);
    }

}
