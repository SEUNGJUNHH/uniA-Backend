package com.example.unia.direction.entity;

import com.example.unia.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "direction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Direction extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputAddress;
    private double inputLatitude;
    private double inputLongitude;

    private String targetRestaurantName;
    private String targetAddress;
    private double targetLatitude;
    private double targetLongitude;

    private double distance;
}
