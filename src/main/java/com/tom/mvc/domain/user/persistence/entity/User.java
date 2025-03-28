package com.tom.mvc.domain.user.persistence.entity;


import com.tom.mvc.domain.user.api.request.UserPostUserReq;
import com.tom.mvc.domain.user.enums.UserStat;
import com.tom.mvc.global.converter.DbDataConverter;
import com.tom.mvc.global.entity.RecordTrace;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_")
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 36, unique = true, nullable = false)
    private String uuid;

    @Enumerated(EnumType.STRING)
    @Column(length = 32, nullable = false, columnDefinition = "VARCHAR(32)")
    private UserStat stat;

    @Column(length = 500, nullable = false)
    @Convert(converter = DbDataConverter.class)
    private String name;
    @Column(length = 500, unique = true, nullable = false)
    @Convert(converter = DbDataConverter.class)
    private String email;
    @Column(length = 500)
    private String img;

    @Embedded
    private RecordTrace recordTrace;

    public static User create(UserPostUserReq req) {
        User entity = new User();
        entity.uuid = UUID.randomUUID().toString();
        entity.stat = UserStat.NORMAL;
        entity.name = req.getName();
        entity.email = req.getEmail();

        entity.recordTrace = RecordTrace.create();
        return entity;
    }
}
