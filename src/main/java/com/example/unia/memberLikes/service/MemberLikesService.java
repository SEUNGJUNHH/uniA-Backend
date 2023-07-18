package com.example.unia.memberLikes.service;

import com.example.unia.memberLikes.entity.MemberLikesEntity;
import com.example.unia.memberLikes.repository.MemberLikesRepository;
import com.example.unia.place.entity.Place;
import com.example.unia.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberLikesService {

    private final MemberLikesRepository memberLikesRepository;
    private final PlaceRepository placeRepository;

    public List<String> getLikedPlaceNamesByMemberId(Long memberId) {
        List<MemberLikesEntity> memberLikes = memberLikesRepository.findAllByMemberId(memberId);

        List<String> likedPlaceNames = new ArrayList<>();

        for (MemberLikesEntity memberLikesEntity : memberLikes) {
            Place place = placeRepository.findById(memberLikesEntity.getPlaceId()).get();
            likedPlaceNames.add(place.getPlaceName());
        }

        return likedPlaceNames;
    }

}
