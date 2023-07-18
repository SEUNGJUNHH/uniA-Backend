package com.example.unia.borad.service;


import com.example.unia.borad.dto.FreeBoardDto;
import com.example.unia.borad.dto.PromotionBoardDto;
import com.example.unia.borad.entity.FreeBoard;
import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.borad.repository.FreeBoardRepository;
import com.example.unia.borad.repository.PromotionBoardRepository;
import com.example.unia.member.entity.MemberEntity;
import com.example.unia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final PromotionBoardRepository promotionBoardRepository;
    private final MemberRepository memberRepository;
    public void createFreeBoard(FreeBoardDto boardDto, Long id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        FreeBoard freeBoard = FreeBoard.builder().boardDto(boardDto).member(memberEntity.get()).build();
        freeBoardRepository.save(freeBoard);
    }
    public void createPromotionBoard(PromotionBoardDto boardDto, Long id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        PromotionBoard promotionBoard = PromotionBoard.builder().boardDto(boardDto).member(memberEntity.get()).build();
        promotionBoardRepository.save(promotionBoard);
    }

    public void deleteFreeBoard(Long id){
        freeBoardRepository.deleteById(id);
    }
    public void deletePromotionBoard(Long id){
        promotionBoardRepository.deleteById(id);
    }

    public List<FreeBoardDto> searchFreeBoardAll(){
        List<FreeBoard> freeBoards = freeBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        ArrayList<FreeBoardDto> freeBoardDtos = new ArrayList<>();
        for (FreeBoard freeBoard : freeBoards) {
            FreeBoardDto freeBoardDto = new FreeBoardDto(freeBoard);
            freeBoardDtos.add(freeBoardDto);
        }
        return freeBoardDtos;
    }

    public List<PromotionBoardDto> searchPromotionBoardAll(){
        List<PromotionBoard> promotionBoards = promotionBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        ArrayList<PromotionBoardDto> promotionBoardDtos = new ArrayList<>();
        for (PromotionBoard promotionBoard : promotionBoards) {
            PromotionBoardDto promotionBoardDto = new PromotionBoardDto(promotionBoard);
            promotionBoardDtos.add(promotionBoardDto);
        }
        return promotionBoardDtos;
    }

    public List<FreeBoardDto> searchFreeMemberId(Long id){
        Optional<MemberEntity> member = memberRepository.findById(id);
        List<FreeBoard> freeBoardList = freeBoardRepository.findByMember_MemberId(member.get().getMemberId());
        ArrayList<FreeBoardDto> freeBoardDtos = new ArrayList<>();
        for (FreeBoard freeBoard : freeBoardList) {
            FreeBoardDto freeBoardDto = new FreeBoardDto(freeBoard);
            freeBoardDtos.add(freeBoardDto);
        }
        return freeBoardDtos;
    }
    public List<PromotionBoardDto> searchPromotionMemberId(Long id){
        Optional<MemberEntity> member = memberRepository.findById(id);
        List<PromotionBoard> promotionBoardList = promotionBoardRepository.findByMember_MemberId(member.get().getMemberId());
        ArrayList<PromotionBoardDto> PromotionBoardDtos = new ArrayList<>();
        for (PromotionBoard promotionBoard : promotionBoardList) {
            PromotionBoardDto promotionBoardDto = new PromotionBoardDto(promotionBoard);
            PromotionBoardDtos.add(promotionBoardDto);
        }
        return PromotionBoardDtos;
    }


}
