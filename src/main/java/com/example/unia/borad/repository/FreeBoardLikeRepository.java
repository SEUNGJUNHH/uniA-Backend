package com.example.unia.borad.repository;


import com.example.unia.borad.entity.FreeBoard;
import com.example.unia.borad.entity.FreeBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FreeBoardLikeRepository extends JpaRepository<FreeBoardLike, Long> {
}