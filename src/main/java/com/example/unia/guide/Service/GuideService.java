package com.example.unia.guide.Service;

import com.example.unia.guide.Repository.GuideRepository;
import com.example.unia.guide.entity.Guide;
import com.example.unia.guide.guideDto.GuideContentDto;
import com.example.unia.guide.guideDto.GuideTitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GuideService {

    private final GuideRepository guideRepository;

    public void create(Guide guide){
        guideRepository.save(guide);
    }

    public List<GuideTitleDto> findTitleAll(){
        List<Guide> guides = guideRepository.findAll();
        List<GuideTitleDto> dtos = new ArrayList<>();
        for (Guide guide : guides) {
            dtos.add(new GuideTitleDto(guide));
        }
        return dtos;
    }
    public List<GuideContentDto> findContextAll(){
        List<Guide> guides = guideRepository.findAll();
        List<GuideContentDto> dtos = new ArrayList<>();
        for (Guide guide : guides) {
            dtos.add(new GuideContentDto(guide));
        }
        return dtos;
    }

}
