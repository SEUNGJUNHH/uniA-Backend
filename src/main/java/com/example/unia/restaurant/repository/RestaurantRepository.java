package com.example.unia.restaurant.repository;

import com.example.unia.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
