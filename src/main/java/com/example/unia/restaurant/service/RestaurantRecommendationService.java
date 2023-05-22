package com.example.unia.restaurant.service;

import com.example.unia.api.dto.DocumentDto;
import com.example.unia.api.dto.KakaoApiResponseDto;
import com.example.unia.api.service.KakaoAddressSearchService;
import com.example.unia.direction.entity.Direction;
import com.example.unia.direction.service.DirectionService;
import com.example.unia.place.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantRecommendationService {

    private final KakaoAddressSearchService kakaoAddressSearchService;
    private final DirectionService directionService;

    private static final String ROAD_VIEW_BASE_URL = "https://map.kakao.com/link/roadview/";
    private static final String DIRECTION_BASE_URL = "https://map.kakao.com/link/map/";

    public List<PlaceDto> recommendationRestaurantList(String address){
        KakaoApiResponseDto kakaoApiResponseDto = kakaoAddressSearchService.requestAddressSearch(address);

        if(Objects.isNull(kakaoApiResponseDto) || CollectionUtils.isEmpty(kakaoApiResponseDto.getDocumentDtoList())){
            log.error("[RestaurantRecommendationService] {}", address);
            return Collections.emptyList();
        }

        DocumentDto documentDto = kakaoApiResponseDto.getDocumentDtoList().get(0);

        List<Direction> directionList = directionService.buildDirectionListByCategoryApi(documentDto);
        System.out.println(directionList);
        return directionService.saveAll(directionList)
                .stream()
                .map(this::convertToPlaceDto)
                .collect(Collectors.toList());
    }

    private PlaceDto convertToPlaceDto(Direction direction){

        String params = String.join(",", direction.getTargetRestaurantName(),
                String.valueOf(direction.getTargetLatitude()), String.valueOf(direction.getTargetLongitude()));

        String result = UriComponentsBuilder.fromHttpUrl(DIRECTION_BASE_URL + params)
                .toUriString();

        return PlaceDto.builder()
                .placeName(direction.getTargetRestaurantName())
                .placeAddress(direction.getTargetAddress())
                .directionUrl(result)
                .roadViewUrl(ROAD_VIEW_BASE_URL + direction.getTargetLatitude() + "," + direction.getTargetLongitude())
                .distance(String.format("%.2f km", direction.getDistance()))
                .build();
    }
}

