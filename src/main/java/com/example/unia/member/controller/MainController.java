package com.example.unia.member.controller;

import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("")
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


    /**
     * 로그인 없이 회원 삭제 기능
     * [DELETE] /api/v1/delete/{memberId}
     */
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<?> deleteById(@PathVariable Long memberId){
        memberService.deleteById(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }

}
