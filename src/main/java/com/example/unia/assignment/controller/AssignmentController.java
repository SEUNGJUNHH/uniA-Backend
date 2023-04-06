package com.example.unia.assignment.controller;


import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.assignment.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class AssignmentController {

    private final AssignmentService assignmentService;


    /**
     * 과제 조회 [GET]
     * 과제 등록 [POST]
     * 과제 삭제 [DELETE]
     * 과제 수정 [PATCH]
     */

    /**
     * 과제 등록
     * [POST] /todo
     */
    @PostMapping("")
    public ResponseEntity createTodo(@RequestBody AssignmentDTO assignmentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
