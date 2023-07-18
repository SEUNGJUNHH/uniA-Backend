package com.example.unia.borad.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentReqDto {

    private String content;
    private Long boardId;
    private LocalDateTime createdTime;

}
