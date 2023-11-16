package com.hk2.dap.domain.user.repository;

import com.hk2.dap.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUserIdAndUserPassword(String userId, String password);
    Optional<User> findByUserId(String userId);
}
