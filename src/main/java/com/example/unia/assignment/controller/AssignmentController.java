package com.example.unia.assignment.controller;


import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.assignment.service.AssignmentService;
import com.example.unia.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class AssignmentController {

    private final AssignmentService assignmentService;


    /**
     * <<구현해야 할 기능>>
     * 과제 조회 [GET]
     * 과제 등록 [POST]
     * 과제 삭제 [DELETE]
     * 과제 수정 [PATCH]
     * 과제 마감기한체크
     * 과제 정렬(마감기한 순대로)
     * etc
     */

    /**
     * 과제 등록
     * [POST] api/v1/todo
     * @param assignmentDTO
     * @return
     */
    @PostMapping("")
    public ResponseEntity createTodo(@RequestBody AssignmentDTO assignmentDTO,@AuthenticationPrincipal User customUser){
        String username = customUser.getUsername();
        assignmentService.createAssignment(assignmentDTO, username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 과제 조회
     * [GET] api/v1/todo/{assignmentId}
     * @param assignmentId
     * @return assignmentDTO
     */
    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentDTO> getTodo(@PathVariable Long assignmentId){
        AssignmentDTO assignmentDTO = assignmentService.getAssignment(assignmentId);
        return ResponseEntity.ok(assignmentDTO);
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
}
