package com.tom.mvc.infrastructure.auth.persistence.entity;


import com.tom.mvc.global.entity.RecordTrace;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "auth_token")
@DynamicUpdate
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id", insertable = false, updatable = false)
    private Auth auth;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @Column(length = 500, nullable = false)
    private String token;

    @Column(length = 500, nullable = false)
    private String ip;

    @Column(length = 500, nullable = false)
    private String agent;

    @Embedded
    private RecordTrace recordTrace;

}
