package com.example.unia.game.Repository;

import com.example.unia.board.entitiy.Comment;
import com.example.unia.game.entitiy.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Country, Long> {

}