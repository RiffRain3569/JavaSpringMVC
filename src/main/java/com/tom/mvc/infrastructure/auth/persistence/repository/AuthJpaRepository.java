package com.tom.mvc.infrastructure.auth.persistence.repository;

import com.tom.mvc.infrastructure.auth.persistence.entity.Auth;
import com.tom.mvc.infrastructure.auth.persistence.query.FindAuthQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthJpaRepository extends JpaRepository<Auth, Long> {


    @Query("SELECT a " +
            "FROM Auth a " +
            "JOIN FETCH a.authTokens at " +
            "WHERE (:#{#query.userId} IS NULL OR a.userId IN :#{#query.userId}) "
    )
    Page<Auth> findFetchAll(FindAuthQuery query, Pageable pageable);

}
