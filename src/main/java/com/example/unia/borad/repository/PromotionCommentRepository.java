package com.example.unia.borad.repository;

import com.example.unia.borad.entity.FreeComment;
import com.example.unia.borad.entity.PromotionComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCommentRepository extends JpaRepository<PromotionComment, Long> {

}