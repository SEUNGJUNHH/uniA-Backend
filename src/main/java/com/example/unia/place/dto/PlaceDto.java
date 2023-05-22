package com.example.unia.place.dto;

import com.example.unia.place.entity.Place;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class PlaceDto {

    private String placeName;
    private String placeAddress;
    private String directionUrl;
    private String roadViewUrl;
    private String distance;
    private Integer hitCount;


    public static PlaceDto toPlaceDto(Place place){
        return PlaceDto.builder()
                .placeName(place.getPlaceName())
                .placeAddress(place.getPlaceAddress())
                .directionUrl(place.getDirectionUrl())
                .roadViewUrl(place.getRoadViewUrl())
                .distance(place.getDistance())
                .hitCount(place.getHitCount())
                .build();
    }

}