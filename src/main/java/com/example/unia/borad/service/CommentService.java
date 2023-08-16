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
import com.example.unia.member.config.UserCustom;
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
public class CommentService {
    //"각 게시판 별 댓글 목록", 좋아요기능,         프로필사진, 사진 추가 - 인스턴스 사용해서 하기 
   private final MemberRepository memberRepository;
   private final FreeCommentRepository freeCommentRepository;
   private final PromotionCommentRepository promotionCommentRepository;
   private final FreeBoardRepository freeBoardRepository;
   private final PromotionBoardRepository promotionBoardRepository;

    //자유게시판 댓글 추가
   public CommentDto createFreeComment(CommentDto commentDto,Long memberId) {
      Optional<MemberEntity> member = memberRepository.findById(memberId);
      Optional<FreeBoard> freeBoard = freeBoardRepository.findById(commentDto.getBoardId());
       FreeComment freeComment = FreeComment.builder().freeBoard(freeBoard.get()).content(commentDto.getContent()).member(member.get()).build();
       freeBoard.get().setCommentCount(freeBoard.get().getCommentCount()+1);
       freeCommentRepository.save(freeComment);
      return commentDto;
   }
     //홍보게시판 댓글 추가
    public CommentDto createPromotionComment(CommentDto commentDto, Long memberId) {
        Optional<MemberEntity> member = memberRepository.findById(memberId);
        Optional<PromotionBoard> promotionBoard = promotionBoardRepository.findById(commentDto.getBoardId());
        PromotionComment promotionComment = PromotionComment.builder().promotionBoard(promotionBoard.get()).content(commentDto.getContent()).member(member.get()).build();
        promotionBoard.get().setCommentCount(promotionBoard.get().getCommentCount() + 1);
        promotionCommentRepository.save(promotionComment);
        return commentDto;
    }
    //이거 그냥 impl로  짜버리자
   //자유게시판 게시판 별 댓글 list 조회
//   public List<CommentResDto> findFreeCommentList(Long id){
       //자유 게시판 list 출력
//      List<FreeComment> freeCommentList = freeCommentRepository.findByFreeBoard_id(id);
//      return freeCommentList;
//   }
//
//   //홍보게시판 게시판 별 댓글 list 조회
//   public List<CommentResDto> findPromoCommentList(Long id){
//       //홍보 게시판 list 출력
//      List<CommentResDto> promotionComent = promotionCommentRepository.findByPromotionBoard_id(id);
//      return promotionComent;
//   }

}
