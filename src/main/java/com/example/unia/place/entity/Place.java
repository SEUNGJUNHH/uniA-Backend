package com.example.unia.place.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "place")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placeName; // 식당 이름
    @Column(nullable = false)
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