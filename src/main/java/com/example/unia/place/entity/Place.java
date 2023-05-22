package com.example.unia.place.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "place")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeName; // 식당 이름
    private String placeAddress; // 식당 주소
    private String directionUrl; // 길찾기 url
    private String roadViewUrl; // 로드뷰 url
    private String distance; // 거리

    private Integer hitCount; // 좋아요 수

    @PrePersist
    public void prePersist(){
        this.hitCount = this.hitCount == null ? 0 :this.hitCount;
    }
}