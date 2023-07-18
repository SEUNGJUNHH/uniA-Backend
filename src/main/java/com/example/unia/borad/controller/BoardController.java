package com.example.unia.borad.controller;


import com.example.unia.borad.dto.FreeBoardDto;
import com.example.unia.borad.dto.PromotionBoardDto;
import com.example.unia.borad.service.BoardService;
import com.example.unia.member.config.UserCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//신고기능 생각하기
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;
    /**
     * 자유게시판 등록
     * [POST] api/v1/board/freeCreate
     * @param boardDto
     * @return Response.body(boardDto)
     */
    @PostMapping("/freeCreate")
    public ResponseEntity<FreeBoardDto> createFreeBoard(@RequestBody FreeBoardDto boardDto, @AuthenticationPrincipal UserCustom User){
        Long userId = User.getUserId();
        boardService.createFreeBoard(boardDto,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardDto);
    }
    /**
     * 홍보게시판 등록
     * [POST] api/v1/board/freeCreate
     * @param boardDto
     * @return Response.body(boardDto)
     */
    @PostMapping("/promotionCreate")
    public ResponseEntity<PromotionBoardDto> createPromotionBoard(@RequestBody PromotionBoardDto boardDto, @AuthenticationPrincipal UserCustom User ){
        Long userid = User.getUserId();
        boardService.createPromotionBoard(boardDto,userid);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardDto);
    }

    /**
     * 자유게시판 리스트 (기능X, 확인용)
     * [Get] api/v1/board/freeList
     * @return List<FreeBoardDto>
     */
    @GetMapping("/freeList")
    public ResponseEntity<List<FreeBoardDto>> FreeBoardAll(){
        List<FreeBoardDto> freeBoardDtos = boardService.searchFreeBoardAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(freeBoardDtos);
    }
    /**
     * 홍보게시판 리스트 (기능X, 확인용)
     * [Get] api/v1/board/promotionList
     * @return List<promotionBoardDtos>
     */
    @GetMapping("/promotionList")
    public ResponseEntity<List<PromotionBoardDto>> PromotionBoardAll(){
        List<PromotionBoardDto> promotionBoardDtos = boardService.searchPromotionBoardAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(promotionBoardDtos);
    }

    /**
     * 자유 게시판 삭제 기능
     * [Delete] api/v1/board/freeBoard/{id}
     * @return Response.body("Delete Success")
     */
    @DeleteMapping("/freeBoard/{id}")
    public ResponseEntity<String> FreeBoardDelete(@PathVariable Long id){
    boardService.deleteFreeBoard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }

    /**
     * 홍보 게시판 삭제 기능
     * [Delete] api/v1/board/promotionBoard/{id}
     * @return Response.body("Delete Success")
     */
    @DeleteMapping("/promotionBoard/{id}")
    public ResponseEntity<String> PromotionBoardDelete(@PathVariable Long id){
        boardService.deletePromotionBoard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }

    /**
     * 자유게시판 맴버 별 리스트
     * [Get] api/v1/board/freeList/{id}
     * @return List<FreeBoardDto>
     */
    @GetMapping("/freeList/{id}")
    public ResponseEntity<List<FreeBoardDto>> FreeBoardMember(@PathVariable Long id){
        List<FreeBoardDto> freeBoardDtos = boardService.searchFreeMemberId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(freeBoardDtos);
    }
    /**
     * 홍보게시판 맴버 별 리스트
     * [Get] api/v1/board/promotionList/{id}
     * @return List<PromotionBoardDto>
     */
    @GetMapping("/promotionList/{id}")
    public ResponseEntity<List<PromotionBoardDto>> PromotionBoardMember(@PathVariable Long id){
        List<PromotionBoardDto> promotionBoardDtos = boardService.searchPromotionMemberId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(promotionBoardDtos);
    }



}
