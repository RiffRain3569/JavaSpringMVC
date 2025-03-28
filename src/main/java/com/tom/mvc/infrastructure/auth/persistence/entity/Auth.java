package com.tom.mvc.infrastructure.auth.persistence.entity;


import com.tom.mvc.global.entity.RecordTrace;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "auth_")
@DynamicUpdate
public class Auth {


    @OneToMany(mappedBy = "auth", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<AuthToken> authTokens = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(length = 500)
    private String password;

    private String provider;
    private String providerId;


    @Embedded
    private RecordTrace recordTrace;

}
