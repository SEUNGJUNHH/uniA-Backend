package com.example.unia.borad.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class CommentDto {

    private String content;
    private Long boardId;

}
