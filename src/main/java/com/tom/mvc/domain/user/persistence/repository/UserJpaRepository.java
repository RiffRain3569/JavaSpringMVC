package com.tom.mvc.domain.user.persistence.repository;

import com.tom.mvc.domain.user.persistence.entity.User;
import com.tom.mvc.domain.user.persistence.query.FindUserQuery;
import com.tom.mvc.global.config.DbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {


    @Query("SELECT u " +
            "FROM User u " +
            "WHERE (:#{#query.ids} IS NULL OR u.id IN :#{#query.ids}) " +
            "  AND (:#{#query.stats} IS NULL OR u.stat IN :#{#query.stats}) " +
            "  AND (:#{#query.searchWord} IS NULL " +
            "           OR LOWER(CAST(AES256_DECRYPT(u.name, :#{#dbConfig.secretKey}, :#{#dbConfig.iv}) as string))  LIKE CONCAT('%', LOWER(:#{#query.searchWord}), '%') " +
            "           OR LOWER(CAST(AES256_DECRYPT(u.email, :#{#dbConfig.secretKey}, :#{#dbConfig.iv}) as string)) LIKE CONCAT('%', LOWER(:#{#query.searchWord}), '%') " +
            "      ) "
    )
    Page<User> findFetchAll(FindUserQuery query, DbConfig dbConfig, Pageable pageable);

    Optional<User> findByEmail(String email);
}
