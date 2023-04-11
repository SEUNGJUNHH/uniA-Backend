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


    public void createAssignment(AssignmentDTO assignmentDTO,Long userid) {
        AssignmentEntity assignmentEntity = AssignmentEntity.toAssignmentEntity(assignmentDTO);
        MemberEntity member = memberRepository.findById(userid).get();
        assignmentEntity.setMemberEntity(member);
        assignmentRepository.save(assignmentEntity);

    }
    public void deleteById(Long id) {
        assignmentRepository.deleteById(id);
    }


    public List<AssignmentDTO> getAssignment(Long memberId) {

        MemberEntity memberEntity = memberRepository.findById(memberId).get();

        List<AssignmentEntity> assignmentEntityList = assignmentRepository.findByMemberEntity(memberEntity);

        List<AssignmentDTO> assignmentDTOList = new ArrayList<>();
        for (AssignmentEntity assignmentEntity : assignmentEntityList) {
            assignmentDTOList.add(AssignmentDTO.toAssignmentDTO(assignmentEntity));
        }
        return assignmentDTOList;
    }
    public void update(long assignmentId,AssignmentDTO assignmentDTO){
        Optional<AssignmentEntity> byId = assignmentRepository.findById(assignmentId);
        AssignmentEntity assignmentEntity = byId.get();
        assignmentEntity.setName(assignmentDTO.getName());
        assignmentEntity.setLectureName(assignmentDTO.getLectureName());
        assignmentEntity.setDeadline(assignmentDTO.getDeadline());
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
