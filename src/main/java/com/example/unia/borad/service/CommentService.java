package com.example.unia.borad.service;

import com.example.unia.borad.dto.CommentDto;

import com.example.unia.borad.dto.CommentReqDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    //각 게시판 별 댓글 목록 조회,좋아요기능, 프로필사진, 사진 추가
   private final MemberRepository memberRepository;
   private final FreeCommentRepository freeCommentRepository;
   private final PromotionCommentRepository promotionCommentRepository;
   private final FreeBoardRepository freeBoardRepository;
   private final PromotionBoardRepository promotionBoardRepository;

    //자유게시판 댓글 추가
   public CommentDto createFreeComment(CommentDto commentDto, UserCustom userCustom) {
      Optional<MemberEntity> member = memberRepository.findById(userCustom.getUserId());
      Optional<FreeBoard> freeBoard = freeBoardRepository.findById(commentDto.getBoardId());
       FreeComment freeComment = FreeComment.builder().freeBoard(freeBoard.get()).content(commentDto.getContent()).member(member.get()).build();
       freeBoard.get().setCommentCount(freeBoard.get().getCommentCount()+1);
       freeCommentRepository.save(freeComment);
      return commentDto;
   }
     //홍보게시판 댓글 추가
    public CommentDto createPromotionComment(CommentDto commentDto, UserCustom userCustom) {
        Optional<MemberEntity> member = memberRepository.findById(userCustom.getUserId());
        Optional<PromotionBoard> promotionBoard = promotionBoardRepository.findById(commentDto.getBoardId());
        PromotionComment promotionComment = PromotionComment.builder().promotionBoard(promotionBoard.get()).content(commentDto.getContent()).member(member.get()).build();
        promotionBoard.get().setCommentCount(promotionBoard.get().getCommentCount() + 1);
        promotionCommentRepository.save(promotionComment);
        return commentDto;
    }

   //자유게시판 게시판 별 댓글 list 조회
   public List<CommentReqDto> findFreeBoardList(Long id){
       //여기를 임플로 바꿔야하나
      List<FreeComment> freeBoardList = freeCommentRepository.findAll(id);
      ArrayList<CommentDto> commentDtos = new ArrayList<>();

      return commentDtos;
   }

   //list출력은 각 보드 테이블에 저장한 list를 dto로 변환 후 리스트 타입을 리턴 해보자.
   public List<CommentDto> findFreeComment(Long boardid){
      Optional<FreeBoard> freeBoard = freeBoardRepository.findById(boardid);
      ArrayList<CommentDto> commentDtos = new ArrayList<>();
      List<Comment> commentList = freeBoard.get().getCommentList();
      for (Comment comment : commentList) {
         commentDtos.add(new CommentDto(comment));
      }
      return commentDtos;
   }

   public List<CommentDto> findPromotionComment(Long boardid){
      Optional<PromotionBoard> promotionBoard = promotionBoardRepository.findById(boardid);
      ArrayList<CommentDto> commentDtos = new ArrayList<>();
      List<Comment> commentList = promotionBoard.get().getCommentList();
      for (Comment comment : commentList) {
         commentDtos.add(new CommentDto(comment));
      }
      return commentDtos;
   }

}
