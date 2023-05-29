package com.example.unia.guide.entity;

import com.example.unia.guide.guideDto.GuideContentDto;
import com.example.unia.guide.guideDto.GuideTitleDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guide {

    @Id @GeneratedValue
    public Long PK;

    //각 가이드 구분
    public Long id;

    //가이드 별 순서 구분
    public Long indexs;


    public String titles;

    @Column(columnDefinition = "TEXT")
    public String contents;


}
