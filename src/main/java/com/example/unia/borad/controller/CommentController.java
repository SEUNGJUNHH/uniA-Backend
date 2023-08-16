package com.example.unia.borad.controller;

import com.example.unia.borad.dto.CommentDto;
import com.example.unia.borad.dto.CommentResDto;
import com.example.unia.borad.dto.FreeBoardDto;
import com.example.unia.borad.dto.PromotionBoardDto;
import com.example.unia.borad.service.CommentService;
import com.example.unia.member.config.UserCustom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/promotion-comment")
    public ResponseEntity<CommentDto> createPromotionComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal UserCustom User ){
        Long userid = User.getUserId();
        CommentDto promotionComment = commentService.createPromotionComment(commentDto, userid);
        return ResponseEntity.status(HttpStatus.CREATED).body(promotionComment);
    }

    @PostMapping("/free-comment")
    public ResponseEntity<CommentDto> createFreeComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal UserCustom User ){
        Long userid = User.getUserId();
        CommentDto freeComment = commentService.createFreeComment(commentDto, userid);
        return ResponseEntity.status(HttpStatus.CREATED).body(freeComment);
    }

//    /**
//     * 자유게시판 별 댓글 조회
//     * [Get] api/v1/board/freeList/{id}
//     * @return List<FreeBoardDto>
//     */
//    @GetMapping("/free-comment/{id}")
//    public ResponseEntity<List<CommentResDto>> findFreeCommentList(@PathVariable Long id){
//        List<CommentResDto> freeCommentList = commentService.findFreeCommentList(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(freeCommentList);
//    }
//
//    /**
//     * 홍보게시판 별 댓글 조회
//     * [Get] api/v1/board/promotionList/{id}
//     * @return List<PromotionBoardDto>
//     */
//    @GetMapping("/promotion-comment/{id}")
//    public ResponseEntity<List<CommentResDto>> findPromoCommentList(@PathVariable Long id){
//        List<CommentResDto> promoCommentList = commentService.findPromoCommentList(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(promoCommentList);
//    }
}
