package com.example.unia.borad.repository;

import com.example.unia.borad.dto.CommentResDto;
import com.example.unia.borad.entity.FreeComment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeCommentRepository extends JpaRepository<FreeComment, Long> {
    List<FreeComment> findByFreeBoard_id(Long id);
}