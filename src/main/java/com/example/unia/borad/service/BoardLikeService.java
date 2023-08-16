package com.example.unia.borad.service;

import com.example.unia.borad.dto.CommentDto;
import com.example.unia.borad.dto.CommentResDto;
import com.example.unia.borad.entity.FreeBoard;
import com.example.unia.borad.entity.FreeComment;
import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.borad.entity.PromotionComment;
import com.example.unia.borad.repository.FreeBoardRepository;
import com.example.unia.borad.repository.FreeCommentRepository;
import com.example.unia.borad.repository.PromotionBoardRepository;
import com.example.unia.borad.repository.PromotionCommentRepository;
import com.example.unia.member.entity.MemberEntity;
import com.example.unia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardLikeService {
//    //자유 , 프로모 좋아요 저장 하면서 보드 엔티티 좋아요 +하기, 만일 이미 db에 존재하면 -해주기
//    private final FreeBoardRepository freeBoardRepository;
//    private final PromotionBoardRepository promotionBoardRepository;
//    private final MemberRepository memberRepository;
//    private final
//    //자
//    public CommentDto createFreeComment(Long freeId,Long memberId) {
//        Optional<MemberEntity> member = memberRepository.findById(memberId);
//        Optional<FreeBoard> freeBoard = freeBoardRepository.findById(freeId);
//        FreeComment freeComment = FreeComment.builder().freeBoard(freeBoard.get()).content(commentDto.getContent()).member(member.get()).build();
//        freeBoard.get().setCommentCount(freeBoard.get().getCommentCount()+1);
//        freeCommentRepository.save(freeComment);
//        return commentDto;
//    }
}
