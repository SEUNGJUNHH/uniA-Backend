package com.example.unia.assignment.service;

import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.assignment.entity.AssignmentEntity;
import com.example.unia.assignment.repository.AssignmentRepository;
import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;


    public void createAssignment(AssignmentDTO assignmentDTO) {
        AssignmentEntity assignmentEntity = AssignmentEntity.toAssignmentEntity(assignmentDTO);
        assignmentRepository.save(assignmentEntity);
    }

    public AssignmentDTO getAssignment(Long assignmentId) {
        Optional<AssignmentEntity> optionalAssignmentEntity = assignmentRepository.findById(assignmentId);
        if (optionalAssignmentEntity.isPresent()) {
            return AssignmentDTO.toAssignmentDTO(optionalAssignmentEntity.get());
        } else {
            return null;
        }
    }

    public List<AssignmentDTO> findAll() {
        List<AssignmentEntity> assignmentEntityList = assignmentRepository.findAll();
        List<AssignmentDTO> assignmentDTOList = new ArrayList<>();
        for (AssignmentEntity assignmentEntity : assignmentEntityList) {
            assignmentDTOList.add(AssignmentDTO.toAssignmentDTO(assignmentEntity));
        }
        return assignmentDTOList;
    }
}
