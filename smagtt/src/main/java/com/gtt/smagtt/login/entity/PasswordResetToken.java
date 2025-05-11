package com.gtt.smagtt.login.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private OurUsers user;
//    @OneToOne
//    @JoinColumn(name = "user_id", unique = true)
//    private User user;

    private LocalDateTime expiryDate;


}
