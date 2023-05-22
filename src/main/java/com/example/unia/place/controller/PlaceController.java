package com.example.unia.place.controller;

import com.example.unia.member.dto.MemberDTO;
import com.example.unia.place.dto.PlaceDto;
import com.example.unia.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class PlaceController {

    private final PlaceService placeService;

    /**
     * DB에 저장된 식당 전체 조회
     * [GET] /api/v1/restaurant/list
     * @return List<MemberDTO>
     */
    @GetMapping("/list")
    public ResponseEntity<List<PlaceDto>> findAll(){
        List<PlaceDto> placeDto = placeService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(placeDto);
    }

    /**
     * 식당 좋아요 수 증가
     * [PATCH] /api/v1/restaurant/{placeName}
     * @param placeName 식당 placeName
     * @return ResponseEntity<String>
     */
    @PatchMapping("/{placeName}")
    public ResponseEntity<String> increaseLikeCount(@PathVariable String placeName){
        PlaceDto placeDto = placeService.findByPlaceName(placeName);
        if (placeDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Place not found");
        }
        placeService.increaseLikeCount(placeName);
        return ResponseEntity.status(HttpStatus.OK).body("Like increase");
    }

    /**
     * 식당 좋아요 수 순으로 조회
     * [GET] /api/v1/restaurant/sorted/like
     * @return ResponseEntity<List<PlaceDto>>
     */
    @GetMapping("/sorted/like")
    public ResponseEntity<List<PlaceDto>> findAllSortedByLikeCount() {
        List<PlaceDto> placeDtoList = placeService.findAllSortedByLikeCount();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(placeDtoList);
    }

    /**
     * 식당 거리 순으로 조회
     * [GET] /api/v1/restaurant/sorted/distance
     * @return ResponseEntity<List<PlaceDto>>
     */
    @GetMapping("/sorted/distance")
    public ResponseEntity<List<PlaceDto>> findAllByDistance() {
        List<PlaceDto> placeDtoList = placeService.findAllByDistance();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(placeDtoList);
    }

}
