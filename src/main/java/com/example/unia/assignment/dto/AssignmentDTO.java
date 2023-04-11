package com.example.unia.assignment.dto;

import com.example.unia.assignment.entity.AssignmentEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentDTO {

    private Long assignmentId; // 과제ID

    private String name; // 과제명

    private String lectureName; // 강의명

    private LocalDateTime deadline; // 마감일자

//
//    private Long memberId;


    public static AssignmentDTO toAssignmentDTO(AssignmentEntity assignmentEntity){
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setAssignmentId(assignmentEntity.getAssignmentId());
        assignmentDTO.setName(assignmentEntity.getName());
        assignmentDTO.setLectureName(assignmentEntity.getLectureName());
        assignmentDTO.setDeadline(assignmentEntity.getDeadline());

//        assignmentDTO.setMemberId(assignmentEntity.getMemberEntity().getMemberId());

        return assignmentDTO;
    }
}