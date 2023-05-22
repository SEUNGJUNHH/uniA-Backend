package com.example.unia.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long id;
    private String restaurantName;
    private String restaurantAddress;
    private double latitude;
    private double longitude;
}
