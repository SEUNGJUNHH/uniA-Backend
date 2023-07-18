package com.example.unia.guide.guideDto;

import com.example.unia.guide.entity.Guide;
import lombok.Data;

@Data
public class GuideContentDto {
    public Long indexs;
    public String contents;

    public GuideContentDto(Guide guide) {
        this.indexs = guide.getIndexs();
        this.contents = guide.getContents();
    }
}

