package com.example.unia.guide.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guide {
    @Id
    public Long indexs;

    public String titles;

    @Column(columnDefinition = "TEXT")
    public String contents;
}
