package com.useractivitymanagement.repository;

import com.useractivitymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User> findByUserId(Long userId);

    Optional<User> findByEmailEquals(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.userName = ?2 where u.email = ?1")
    void updateByEmail(String email, String username);
}
