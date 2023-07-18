package com.example.unia.borad.dto;

import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.member.entity.MemberEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PromotionBoardDto {


    private String title;

    private String content;

    private LocalDateTime createdDate;

    public PromotionBoardDto() {
    }

    public PromotionBoardDto(PromotionBoard promotionBoard) {
        this.title = promotionBoard.getTitle();
        this.content = promotionBoard.getContent();
        this.createdDate = promotionBoard.getCreatedDate();
    }
}
