package com.example.unia.borad.repository;


import com.example.unia.borad.entity.FreeBoard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    List<FreeBoard> findByMember_MemberId(long id);
}