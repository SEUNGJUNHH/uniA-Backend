package com.example.unia.borad.dto;

import com.example.unia.borad.entity.FreeBoard;
import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.member.entity.MemberEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FreeBoardDto {

    private String title;

    private String content;

    private LocalDateTime createdDate;

    public FreeBoardDto() {
    }

    public FreeBoardDto(FreeBoard freeBoard) {
        this.title = freeBoard.getTitle();
        this.content = freeBoard.getContent();
        this.createdDate = freeBoard.getCreatedDate();
    }
}
