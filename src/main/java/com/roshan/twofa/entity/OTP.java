package com.roshan.twofa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String otp;
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private Users user;
    @Column(nullable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant expiresAt;
    @Column(nullable = false)
    private OtpStatus otpStatus;

}
