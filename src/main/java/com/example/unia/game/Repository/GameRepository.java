package com.example.unia.game.Repository;

import com.example.unia.game.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Country, Long> {

}