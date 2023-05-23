package com.example.unia.game.Repository;

import com.example.unia.game.entity.MemberCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCountRepository extends JpaRepository<MemberCount, Long> {

}