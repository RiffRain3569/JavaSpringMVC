package com.tom.mvc.domain.user.api;

import com.tom.mvc.domain.user.api.request.UserGetUserReq;
import com.tom.mvc.domain.user.api.request.UserPostUserReq;
import com.tom.mvc.domain.user.api.response.UserGetUserRes;
import com.tom.mvc.domain.user.application.UserModifyUseCase;
import com.tom.mvc.domain.user.application.UserQueryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {

    public final UserQueryUseCase userQueryUseCase;
    public final UserModifyUseCase userModifyUseCase;


    @GetMapping
    public List<UserGetUserRes> getUsers(UserGetUserReq req, Pageable pageable) {
        return userQueryUseCase.getUsers(req, pageable).getContent();
    }

    @PostMapping
    public UserGetUserRes postUser(@Valid @RequestBody UserPostUserReq req) {
        return userModifyUseCase.postUser(req);
    }

}
