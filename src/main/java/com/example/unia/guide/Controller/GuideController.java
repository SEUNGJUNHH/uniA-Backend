package com.example.unia.guide.Controller;

import com.example.unia.guide.Service.GuideService;
import com.example.unia.guide.entity.Guide;
import com.example.unia.guide.guideDto.GuideContentDto;
import com.example.unia.guide.guideDto.GuideTitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guide")
public class GuideController {
    private final GuideService guideService;
    /**
     * 가이드 db에 추가하기 위한 기능 (해당 기능은 DB에 값 넣는 용도, 실 어플리케이션에 사용 X)
     * [POST] api/v1/guide
     * @return Response.body(guide)
     */
    @PostMapping("")
    public ResponseEntity<Guide> create(@RequestBody Guide guide){
        guideService.create(guide);
        return ResponseEntity.status(HttpStatus.CREATED).body(guide);
    }

    /**
     * 아주 가이드 내용 list로 반환해주는 기능
     * [Get] api/v1/guide/context
     * @return Response.body(dtos)
     */
    @GetMapping("/content")
    public ResponseEntity<List<GuideContentDto>> contextAll(){
        List<GuideContentDto> dtos = guideService.findContextAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    /**
     * 아주 가이드 제목 list로 반환해주는 기능
     * [Get] api/v1/guide/title
     * @return Response.body(dtos)
     */
    @GetMapping("/title")
    public ResponseEntity<List<GuideTitleDto>> titleAll(){
        List<GuideTitleDto> dtos = guideService.findTitleAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

}
