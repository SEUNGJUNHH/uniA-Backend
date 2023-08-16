package com.example.unia.borad.repository;

import com.example.unia.borad.entity.PromotionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionBoardRepository extends JpaRepository<PromotionBoard, Long> {
    List<PromotionBoard> findByMember_MemberId(long id);
}