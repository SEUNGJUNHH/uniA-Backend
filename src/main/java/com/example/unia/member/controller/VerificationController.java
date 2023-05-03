package com.example.unia.member.controller;

import com.example.unia.member.dto.VerificationDTO;

import com.example.unia.member.service.VerificationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/verify")
public class VerificationController {
    private final VerificationService verificationService;

    /**
     * 인증번호 전송
     * [GET] /api/v1/verify/{memberEmail}
     * @param memberEmail
     * @return ResponseEntity
     */
    @GetMapping("/{memberEmail}")
    public ResponseEntity send(@PathVariable String memberEmail){

        if (memberEmail == null || memberEmail.isEmpty()){ // 자바 17은 StringUtils.isBlank(memberEmail) 사용 가능
            return ResponseEntity.badRequest().build();
        }

        verificationService.sendVerificationCode(memberEmail);

        return ResponseEntity.ok().build();

    }

    /**
     * 인증번호 확인
     * [POST] /api/v1/verify
     * @param verificationDTO
     * @return ResponseEntity<?>
     */
    @PostMapping("")
    public ResponseEntity<?> verify(@RequestBody VerificationDTO verificationDTO){
        String email = verificationDTO.getEmail();
        String verificationCode = verificationDTO.getVerificationCode();
        boolean verified = verificationService.verify(email, verificationCode);
        if (verified){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}