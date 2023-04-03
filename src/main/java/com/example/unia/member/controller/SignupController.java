package com.example.unia.member.controller;

import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SignupController {

    private final MemberService memberService;

    /**
     * 회원가입
     * [POST] /api/v1/create
     * @param memberDTO
     * @param bindingResult
     * @return memberDTO
     */
    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody MemberDTO memberDTO, BindingResult bindingResult){

        if (!(memberDTO.getMemberPassword().equals(memberDTO.getMemberConfirmPassword()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passwords do not match");
        }

        if (bindingResult.hasErrors()){
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(objectError -> {
                        FieldError fieldError = (FieldError) objectError;
                        return "Error field : " + fieldError.getField() + "\nError message : " + objectError.getDefaultMessage();
                    })
                    .collect(Collectors.joining("\n"));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        memberService.create(memberDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberDTO);
    }


    /**
     * 이메일 중복 확인
     * [GET] /api/v1/email-check/{memberEmail}
     * @param memberEmail
     * @return ResponseEntity
     */
    @GetMapping("/email-check/{memberEmail}")
    public ResponseEntity checkEmailDuplicate(@PathVariable String memberEmail){

        if (memberEmail == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please enter your email");
        }

        if(memberService.checkEmailDuplicate(memberEmail)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The email already exists");
        }

        return ResponseEntity.status(HttpStatus.OK).body("The email is available");
    }


}
