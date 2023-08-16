package com.example.unia.borad.repository;

import com.example.unia.borad.entity.PromotionBoard;
import com.example.unia.borad.entity.promotionBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionBoardLikeRepository extends JpaRepository<promotionBoardLike, Long> {
}