package com.example.unia.assignment.entity;

import com.example.unia.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "assignment_table")
public class AssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId; // 과제ID

    @Column(nullable = false)
    private String name; // 과제명

    @Column(nullable = false)
    private String lectureName; // 강의명

    @Column(nullable = false)
    private LocalDateTime deadline; // 마감일자

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberEntity;

}
