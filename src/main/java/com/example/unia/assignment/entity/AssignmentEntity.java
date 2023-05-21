package com.example.unia.assignment.entity;

import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@Table(name = "assignment_table")
public class AssignmentEntity {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentId; // 과제ID

    @Column(nullable = false)
    private String name; // 과제명

    @Column(nullable = false)
    private String lectureName; // 강의명

    @Column(nullable = false)
    private LocalDateTime deadline; // 마감일자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static AssignmentEntity toAssignmentEntity(AssignmentDTO assignmentDTO){
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setName(assignmentDTO.getName());
        assignmentEntity.setLectureName(assignmentDTO.getLectureName());
        assignmentEntity.setDeadline(assignmentDTO.getDeadline());
        return assignmentEntity;
    }
}