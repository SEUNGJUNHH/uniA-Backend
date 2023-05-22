package com.example.unia.place.service;

import com.example.unia.place.dto.PlaceDto;
import com.example.unia.place.entity.Place;
import com.example.unia.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    public PlaceDto findByPlaceName(String placeName) {
        Optional<Place> place = placeRepository.findByPlaceName(placeName);
        return place.map(PlaceDto::toPlaceDto).orElse(null);
    }
}