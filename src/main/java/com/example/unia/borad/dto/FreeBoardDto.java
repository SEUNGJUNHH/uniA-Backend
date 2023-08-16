package com.example.unia.borad.dto;

import com.example.unia.borad.entity.FreeBoard;
import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.member.entity.MemberEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FreeBoardDto {

    private String title;

    private String content;


    public FreeBoardDto(FreeBoard freeBoard) {
        this.title = freeBoard.getTitle();
        this.content = freeBoard.getContent();
    }
}
