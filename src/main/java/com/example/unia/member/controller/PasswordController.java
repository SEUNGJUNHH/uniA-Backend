package com.example.unia.member.controller;

import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/resetPassword")
public class PasswordController {

    private final MemberService memberService;

    /**
     * 이메일 입력 후 학번 출력
     * [GET] /api/v1/resetPassword/{memberEmail}
     * @param memberEmail 회원이메일
     * @return memberDTO.getMemberId()
     */
    @GetMapping("/{memberEmail}")
    public ResponseEntity<?> resetPassword(@PathVariable String memberEmail){
        MemberDTO memberDTO = memberService.findByMemberEmail(memberEmail);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO.getMemberId());
    }

    /**
     * 비밀번호 변경
     * [PATCH] /api/v1/resetPassword/{memberId}
     * @param memberId 학번
     * @param password 비밀번호
     * @return ResponseEntity body(existMember)
     */
    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberDTO> updatePassword(@PathVariable Long memberId, @RequestParam("newPassword") String password) {


        if (password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        MemberDTO existMember = memberService.findById(memberId);

        if (existMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        existMember.setMemberPassword(passwordEncoder.encode(password));

        memberService.update(existMember);
        return ResponseEntity.status(HttpStatus.OK).body(existMember);

    }
}
