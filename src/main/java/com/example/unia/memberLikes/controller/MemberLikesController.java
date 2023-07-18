package com.example.unia.memberLikes.controller;

import com.example.unia.memberLikes.service.MemberLikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class MemberLikesController {

    private final MemberLikesService memberLikesService;

    /**
     * 회원이 좋아요 한 식당만 조회
     * [GET] /api/v1/restaurant/memberLikes/{memberId}
     * @param memberId 회원 ID
     * @return likedPlaceIdsByMemberId
     */
    @GetMapping("/memberLikes/{memberId}")
    public ResponseEntity<List<String>> getLikedPlaceIdsByMemberId(@PathVariable Long memberId){
        List<String> likedPlaceNamesByMemberId = memberLikesService.getLikedPlaceNamesByMemberId(memberId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(likedPlaceNamesByMemberId);
    }

}
