package com.tom.mvc.infrastructure.auth.application;

import com.tom.mvc.infrastructure.auth.api.request.AuthGetAuthReq;
import com.tom.mvc.infrastructure.auth.api.response.AuthGetAuthRes;
import com.tom.mvc.infrastructure.auth.persistence.query.FindAuthQuery;
import com.tom.mvc.infrastructure.auth.persistence.repository.AuthJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthQueryService implements AuthQueryUseCase {

    private final AuthJpaRepository authJpaRepository;

    @Override
    public List<AuthGetAuthRes> getAuths(AuthGetAuthReq req, Pageable pageable) {
        return authJpaRepository.findFetchAll(FindAuthQuery.from(req), pageable).getContent().stream()
                .map(AuthGetAuthRes::from).collect(Collectors.toList());
    }
}
