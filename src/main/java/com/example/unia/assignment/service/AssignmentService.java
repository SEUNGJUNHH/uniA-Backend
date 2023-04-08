package com.example.unia.assignment.service;

import com.example.unia.assignment.dto.AssignmentDTO;
import com.example.unia.assignment.entity.AssignmentEntity;
import com.example.unia.assignment.repository.AssignmentRepository;
import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.entity.MemberEntity;
import com.example.unia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;


    public void createAssignment(AssignmentDTO assignmentDTO,String memberEmail) {
        AssignmentEntity assignmentEntity = AssignmentEntity.toAssignmentEntity(assignmentDTO);
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
        MemberEntity member = byMemberEmail.get();
        assignmentRepository.save(assignmentEntity);
        member.getAssignments().add(assignmentEntity);
        System.out.println(member.getAssignments());
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
