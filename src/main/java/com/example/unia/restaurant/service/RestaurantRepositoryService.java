package com.example.unia.restaurant.service;

import com.example.unia.restaurant.entity.Restaurant;
import com.example.unia.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantRepositoryService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void updateAddress(Long id, String address){
        Restaurant entity = restaurantRepository.findById(id).orElse(null);

        if(Objects.isNull(entity)){
            log.error("[not found id]: {}", id);
            return;
        }

        entity.changeRestaurantAddress(address);
    }

    @Transactional(readOnly = true)
    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }
}

