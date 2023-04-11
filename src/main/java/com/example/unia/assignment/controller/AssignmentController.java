package com.example.unia.assignment.controller;


import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.assignment.service.AssignmentService;
import com.example.unia.member.config.UserCustom;
import com.example.unia.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class AssignmentController {

    private final AssignmentService assignmentService;


    /**
     * <<구현해야 할 기능>>
     * 과제 조회 list [GET] 0
     * member별 과제조회[GET] 0
     * 과제 등록 [POST] 0
     * 과제 삭제 [DELETE] 0
     * 과제 수정 [PUT] 0
     * 과제 마감기한체크
     * 과제 정렬(마감기한 순대로)
     * etc
     */

    /**
     * 과제 등록 - 로그인 정보도 함께 넣어서 해당 url사용하려면 로그인 페이지가서 로그인 후 해야함
     * [POST] api/v1/todo
     * @param assignmentDTO
     * @return
     */
    @PostMapping("")
    public ResponseEntity createTodo(@RequestBody AssignmentDTO assignmentDTO,@AuthenticationPrincipal UserCustom User ){
        Long userid = User.getUserId();
        assignmentService.createAssignment(assignmentDTO, userid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



    /**
     * 회원 과제 목록 조회
     * [GET] api/v1/todo/{memberId}
     * @param memberId
     * @return assignmentDTO
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<List<AssignmentDTO>> getTodoList(@PathVariable Long memberId){
        List<AssignmentDTO> assignmentEntityList = assignmentService.getAssignment(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(assignmentEntityList);
    }

    /**
     * DB에 저장된 과제 전체 조회, 실제 기능 아님
     * [GET] /api/v1/todo/list
     * @return List<MemberDTO>
     */
    @GetMapping("/list")
    public ResponseEntity<List<AssignmentDTO>> findAll(){
        List<AssignmentDTO> AssignmentDTOList = assignmentService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(AssignmentDTOList);
    }
    /**
     * DB에 저장된 과제 삭제
     * [Delete] /api/v1/todo/{assignmentId}
     * @return ResponseEntity
     */
    @DeleteMapping("/{assignmentId}")
    public ResponseEntity deleteById(@PathVariable Long assignmentId){
        assignmentService.deleteById(assignmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }
    /**
     * DB에 저장된 과제 수정(입력을 전체를 받을 생각이여서 put매핑으로 생성)
     * [Put] /api/v1/todo/{assignmentId}
     * @return ResponseEntity
     */
    @PutMapping("/{assignmentId}")
    public ResponseEntity updateById(@RequestBody AssignmentDTO assignmentDTO,@PathVariable Long assignmentId) {
        assignmentService.update(assignmentId,assignmentDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("update Success");
    }


}