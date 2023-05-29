package com.example.unia.guide.Repository;

import com.example.unia.guide.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
