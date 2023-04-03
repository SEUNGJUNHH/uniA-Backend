

package com.example.unia.member.dto;

import lombok.Data;

@Data
public class VerificationDTO {
    private String email;
    private String verificationCode;
}
