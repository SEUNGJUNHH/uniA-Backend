package com.example.unia.game.Service;


import com.example.unia.board.dto.BoardDto;
import com.example.unia.board.dto.CommentDto;
import com.example.unia.board.dto.FreeBoardDto;
import com.example.unia.board.dto.PromotionBoardDto;
import com.example.unia.board.entitiy.FreeBoard;
import com.example.unia.board.entitiy.PromotionBoard;
import com.example.unia.board.repository.FreeBoardRepository;
import com.example.unia.board.repository.PromotionBoardRepository;
import com.example.unia.game.Repository.GameRepository;
import com.example.unia.game.entitiy.Country;
import com.example.unia.game.gamedto.CountryDTO;
import com.example.unia.member.entity.MemberEntity;
import com.example.unia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    public CountryDTO click(Long id){
        Optional<Country> byId = gameRepository.findById(id);
        byId.get().setCount(byId.get().getCount()+1);
        CountryDTO countryDTO = new CountryDTO(byId.get());
        return countryDTO;
    }
    public void create(Country country){
        gameRepository.save(country);
    }


    public List<CountryDTO> findAll() {
        List<Country> countryList = gameRepository.findAll(Sort.by(Sort.Direction.DESC,"count"));
        ArrayList<CountryDTO> countryDTOS = new ArrayList<>();
        for (Country country : countryList) {
            countryDTOS.add(new CountryDTO(country));
        }
        return countryDTOS;
    }
}
