package com.tom.mvc.domain.user.persistence.repository;

import com.tom.mvc.domain.user.persistence.entity.User;
import com.tom.mvc.domain.user.persistence.query.FindUserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {


    @Query("SELECT u " +
            "FROM User u " +
            "WHERE (:#{#query.ids} IS NULL OR u.id IN :#{#query.ids}) " +
            "  AND (:#{#query.stats} IS NULL OR u.stat IN :#{#query.stats}) " +
            "  AND (:#{#query.searchWord} IS NULL " +
            "           OR u.name LIKE %:#{#query.searchWord}% " +
            "           OR u.email LIKE %:#{#query.searchWord}%" +
            "      ) "
    )
    Page<User> findFetchAll(FindUserQuery query, Pageable pageable);
}
