package com.example.member.controller;

import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MainController {

    private final MemberService memberService;

    /**
     * 초기화면, 연결 확인을 위한 용도
     * [GET] /api/v1
     * @return index.html
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * DB에 저장된 회원 전체 조회, 실제 기능 아님
     * [GET] /api/v1/list
     * @return List<MemberDTO>
     */
    @GetMapping("/list")
    public ResponseEntity<List<MemberDTO>> findAll(){
        List<MemberDTO> memberDTOList = memberService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTOList);
    }
}
