package com.tot.backend.repository;

import com.tot.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password=?2 WHERE u.email=?1 ")
    int changePassword(String id, String newPassword);


    Optional<User> findByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);

    Boolean existsByEmail(String email);
}
