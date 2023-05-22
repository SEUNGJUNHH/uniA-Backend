package com.example.unia.restaurant.service;

import com.example.unia.restaurant.dto.RestaurantDto;
import com.example.unia.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantSearchService {

    private final RestaurantRepositoryService restaurantRepositoryService;
    public List<RestaurantDto> searchRestaurantDtoList(){

        return restaurantRepositoryService.findAll()
                .stream()
                .map(this::convertToRestaurantDto)
                .collect(Collectors.toList());
    }

    private RestaurantDto convertToRestaurantDto(Restaurant restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .restaurantAddress(restaurant.getRestaurantAddress())
                .restaurantName(restaurant.getRestaurantName())
                .latitude(restaurant.getLatitude())
                .longitude(restaurant.getLongitude())
                .build();
    }
}
