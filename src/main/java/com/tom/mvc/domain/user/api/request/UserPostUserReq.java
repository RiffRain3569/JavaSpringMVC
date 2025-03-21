package com.tom.mvc.domain.user.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostUserReq {

    @NotBlank(message = "이름은 필수 입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email;
}
