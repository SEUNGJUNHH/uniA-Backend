package com.example.unia.assignment.repository;

import com.example.unia.assignment.entity.AssignmentEntity;
import com.example.unia.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {

    List<AssignmentEntity> findByMemberEntity(MemberEntity memberEntity);
}
