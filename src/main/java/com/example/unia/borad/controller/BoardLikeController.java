package com.example.unia.borad.controller;

import com.example.unia.borad.dto.CommentDto;
import com.example.unia.borad.dto.CommentResDto;
import com.example.unia.borad.service.CommentService;
import com.example.unia.member.config.UserCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like")
public class BoardLikeController {


}
