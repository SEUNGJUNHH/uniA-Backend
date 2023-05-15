package com.example.unia.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class VerificationService {
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;
    private final Duration codeExpiration = Duration.ofMinutes(3);
    public void sendVerificationCode(String memberEmail) {
        String verificationCode = generateVerificationCode();

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(memberEmail);
            message.setSubject("Registration verification code");
            message.setText("Verification code: " + verificationCode);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String redisKey = getRedisKey(memberEmail);
        redisTemplate.opsForValue().set(redisKey, verificationCode, codeExpiration);
    }

    public boolean verify(String memberEmail, String verificationCode) {
        String redisKey = getRedisKey(memberEmail);
        String savedCode = redisTemplate.opsForValue().get(redisKey);
        if (savedCode == null) {
            return false;
        }

        if (savedCode.equals(verificationCode)) {
            redisTemplate.delete(redisKey);
            return true;
        }

        return false;
    }

    public boolean validateVerificationCode(String memberEmail, String verificationCode) {
        String redisKey = getRedisKey(memberEmail);
        String savedCode = redisTemplate.opsForValue().get(redisKey);
        if (savedCode == null) {
            return false;
        }

        boolean isValid = savedCode.equals(verificationCode);
        boolean isExpired = Boolean.FALSE.equals(redisTemplate.hasKey(redisKey));
        return isValid && !isExpired;
    }

    private String getRedisKey(String memberEmail) {
        return "verification_code:" + memberEmail;
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}