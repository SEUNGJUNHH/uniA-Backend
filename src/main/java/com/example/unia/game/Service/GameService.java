package com.example.unia.game.Service;

import com.example.unia.game.Repository.GameCountRepository;
import com.example.unia.game.Repository.GameRepository;
import com.example.unia.game.entity.Country;
import com.example.unia.game.entity.MemberCount;
import com.example.unia.game.gamedto.CountryDTO;
import com.example.unia.member.config.UserCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
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
    private final GameCountRepository gameCountRepository;

    public CountryDTO click(Long id, UserCustom userCustom){
        Optional<Country> byId = gameRepository.findById(id);
        boolean check = memberCheck(userCustom);
        if(check==true){
         byId.get().setCount(byId.get().getCount()+1);
         CountryDTO countryDTO = new CountryDTO(byId.get());
         return countryDTO;
        }
        else return null;
    }
    //맴버 카운트
    private boolean memberCheck(UserCustom userCustom){
        Optional<MemberCount> memberCount = gameCountRepository.findById(userCustom.getUserId());
        if(memberCount.isEmpty()) {gameCountRepository.save(new MemberCount(userCustom.getUserId(), 1L));return true;}
        else if (memberCount.get().getCount()==20)  return false;
        else memberCount.get().setCount(memberCount.get().getCount()+1);
        return true;
    }
    @Scheduled(cron = "0 0 0 * * *")
    protected void checkReset(){
        gameCountRepository.deleteAll();
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
    public List<Country> findCountry(){
        List<Country> all = gameRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return all;
    }
    public void deleteById(Long id){
      gameRepository.deleteById(id);
    }
}
