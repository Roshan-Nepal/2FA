package com.roshan.twofa.repo;

import com.roshan.twofa.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepo extends JpaRepository<OTP,Long> {
}
