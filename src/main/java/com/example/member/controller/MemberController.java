package com.example.member.controller;

import com.example.member.dto.MemberDTO;
import com.example.member.dto.MemberInfoDTO;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;


    //test를 위한 컨트롤러
    @GetMapping("/logout/success")
    public ResponseEntity test1() {
        Map<String,Object> map = new HashMap<>();
        map.put("result", 0);
        return new ResponseEntity(map, HttpStatus.OK);
    }
    //test를 위한 컨트롤러
    @GetMapping("/login/success")
    public ResponseEntity test2() {
        Map<String,Object> map = new HashMap<>();
        map.put("result", 1);
        return new ResponseEntity(map, HttpStatus.OK);
    }


    /**
     * 마이페이지 조회
     * [GET] /api/v1/member/{memberId}
     * @param memberId
     * @return memberInfoDTO
     */
    @GetMapping("/{memberId}")
    public ResponseEntity findByMemberId(@PathVariable Long memberId){
        MemberDTO memberDTO = memberService.findById(memberId);
        if (memberDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member does not exist");
        }

        MemberInfoDTO memberInfoDTO = memberDTO.toMemberInfoDTO();
        return ResponseEntity.status(HttpStatus.OK).body(memberInfoDTO);
    }

    /**
     * 비밀번호 변경
     * [PATCH] /api/v1/member/{memberId}
     * @param memberId
     * @param password
     * @return ResponseEntity<MemberDTO>
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


    /**
     * 회원 탈퇴
     * [DELETE] /api/v1/member/{memberId}
     * @param memberId
     * @return
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteById(@PathVariable Long memberId){
        memberService.deleteById(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}