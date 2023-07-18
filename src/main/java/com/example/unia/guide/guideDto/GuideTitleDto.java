package com.example.unia.guide.guideDto;

import com.example.unia.guide.entity.Guide;
import lombok.Data;

@Data
public class GuideTitleDto {

    public Long indexs;

    public String titles;

    public GuideTitleDto(Guide guide) {
        this.indexs = guide.getIndexs();
        this.titles = guide.getTitles();
    }
}
