package com.tom.mvc.domain.user.api.response;

import com.tom.mvc.domain.user.enums.UserStat;
import com.tom.mvc.domain.user.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserGetUserRes {
    private Long id;
    private UserStat stat;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserGetUserRes from(User entity) {
        return new UserGetUserRes(
                entity.getId(),
                entity.getStat(),
                entity.getName(),
                entity.getEmail(),
                entity.getRecordTrace().getCreatedAt(),
                entity.getRecordTrace().getUpdatedAt()
        );
    }
}
