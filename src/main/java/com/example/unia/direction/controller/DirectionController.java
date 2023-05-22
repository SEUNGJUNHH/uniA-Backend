package com.example.unia.direction.controller;

import com.example.unia.direction.dto.InputDto;
import com.example.unia.direction.service.DirectionService;
import com.example.unia.place.dto.PlaceDto;
import com.example.unia.place.entity.Place;
import com.example.unia.place.repository.PlaceRepository;
import com.example.unia.restaurant.service.RestaurantRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DirectionController {

    private final RestaurantRecommendationService restaurantRecommendationService;
    private final DirectionService directionService;
    private final PlaceRepository placeRepository;

    @GetMapping("/input")
    public String input(){
        return "input";
    }

    @PostMapping("/search")
    public ModelAndView postDirection(@ModelAttribute InputDto inputDto){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("output");
        modelAndView.addObject("outputFormList",
                restaurantRecommendationService.recommendationRestaurantList(inputDto.getAddress()));

        List<PlaceDto> placeDtos = restaurantRecommendationService.recommendationRestaurantList(inputDto.getAddress());

        placeDtos.forEach(placeDto -> {
            String placeName = placeDto.getPlaceName();
            if(!directionService.isPlaceNameExists(placeName)) {
                String placeAddress = placeDto.getPlaceAddress();
                String directionUrl = placeDto.getDirectionUrl();
                String roadViewUrl = placeDto.getRoadViewUrl();
                String distance = placeDto.getDistance();
                Integer hitCount = placeDto.getHitCount();
                Place place = new Place(null, placeName, placeAddress, directionUrl, roadViewUrl, distance, hitCount);
                placeRepository.save(place);
            }
        });


        return modelAndView;
    }
}