package com.example.unia.borad.dto;

import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.member.entity.MemberEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PromotionBoardDto {


    private String title;

    private String content;


    public PromotionBoardDto(PromotionBoard promotionBoard) {
        this.title = promotionBoard.getTitle();
        this.content = promotionBoard.getContent();
    }
}
