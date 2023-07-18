package com.example.unia.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {

 @Id @GeneratedValue(strategy = GenerationType.AUTO)
 public Long id;

 public String name;
 public Long count;

}
