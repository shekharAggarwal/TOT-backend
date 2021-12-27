package com.tot.backend.repository;

import com.tot.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1 and u.password=?2")
    User login(String username, String password);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password=?3 WHERE u.id=?1 and u.password=?2")
    int changePassword(Long id, String currentPassword, String newPassword);
}
