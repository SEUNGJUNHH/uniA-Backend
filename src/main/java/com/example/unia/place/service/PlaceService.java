package com.example.unia.place.service;

import com.example.unia.member.dto.MemberDTO;
import com.example.unia.member.entity.MemberEntity;
import com.example.unia.place.dto.PlaceDto;
import com.example.unia.place.entity.Place;
import com.example.unia.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
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

    public List<PlaceDto> findAll() {
        List<Place> placeList = placeRepository.findAll();
        List<PlaceDto> placeDtoList = new ArrayList<>();
        for (Place place: placeList){
            placeDtoList.add(PlaceDto.toPlaceDto(place));
        }
        return placeDtoList;
    }

    public PlaceDto findByPlaceId(Long id){
        Optional<Place> place = placeRepository.findById(id);
        return place.map(PlaceDto::toPlaceDto).orElse(null);
    }

    public void increaseLikeCount(String placeName) {
        Optional<Place> placeOptional = placeRepository.findByPlaceName(placeName);
        placeOptional.ifPresent(place ->  {
            place.setHitCount(place.getHitCount() + 1);
            placeRepository.save(place);
        });
    }

    public List<PlaceDto> findAllSortedByLikeCount() {
        List<Place> placeList = placeRepository.findAll(Sort.by(Sort.Direction.DESC, "hitCount"));
        List<PlaceDto> placeDtoList = new ArrayList<>();
        for (Place place : placeList){
            placeDtoList.add(PlaceDto.toPlaceDto(place));
        }
        return placeDtoList;
    }

    public List<PlaceDto> findAllByDistance() {
        List<Place> placeList = placeRepository.findAll(Sort.by(Sort.Direction.ASC, "distance"));
        List<PlaceDto> placeDtoList = new ArrayList<>();
        for (Place place : placeList) {
            placeDtoList.add(PlaceDto.toPlaceDto(place));
        }
        return placeDtoList;
    }
}