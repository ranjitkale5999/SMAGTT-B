package com.gtt.smagtt.login.repository;

import com.gtt.smagtt.login.entity.OurUsers;
import com.gtt.smagtt.login.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    boolean existsByToken(String token); // Add this line
    Optional<PasswordResetToken> findByUser(OurUsers user);
}
