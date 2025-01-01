package com.roshan.twofa.service;

import com.roshan.twofa.entity.OTP;
import com.roshan.twofa.entity.OtpStatus;
import com.roshan.twofa.repo.OtpRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public class OtpService {
    private final Random random = new Random();
    private final int length = 10;
    private final StringBuilder otp = new StringBuilder(length);

    private final OtpRepo otpRepo;

    public OtpService(OtpRepo otpRepo) {
        this.otpRepo = otpRepo;
    }

    public String generateOtp() {
        for (int i = 0; i < length; i++)
        {
            String numbers = "0123456789";
            otp.append(numbers.charAt(random.nextInt(numbers.length())));

        }
        String otpString = otp.toString();
        otp.delete(0, otp.length());
        return otpString;
    }

    public OTP getOtp() {
        OTP otp1 = new OTP();
        otp1.setOtp(generateOtp());
        otp1.setCreatedAt(Instant.now());
        otp1.setExpiresAt(Instant.now().plusSeconds(60 * 5));
        otp1.setOtpStatus(OtpStatus.VERIFYING);
        otpRepo.save(otp1);
        return otp1;
    }
}
