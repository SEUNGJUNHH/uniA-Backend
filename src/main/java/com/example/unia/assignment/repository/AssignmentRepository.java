package com.example.unia.assignment.repository;

import com.example.unia.assignment.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
