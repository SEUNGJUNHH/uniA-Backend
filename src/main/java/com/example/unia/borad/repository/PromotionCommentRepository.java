package com.example.unia.borad.repository;


import com.example.unia.borad.dto.CommentResDto;
import com.example.unia.borad.entity.PromotionComment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCommentRepository extends JpaRepository<PromotionComment, Long> {
    List<PromotionComment> findByPromotionBoard_id(Long id);
}