package com.example.unia.game.Controller;

import com.example.unia.game.Service.GameService;
import com.example.unia.game.entity.Country;
import com.example.unia.game.gamedto.CountryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/game")
public class GameController {
    private final GameService gameService;
    /**
     * 국가 추가 기능 (해당 기능은 DB에 값 넣는 용도, 실 어플리케이션에 사용 X)
     * [POST] api/v1/game
     * @return Response.body(country)
     */
    @PostMapping("")
    public ResponseEntity<Country> create(@RequestBody Country country){
        gameService.create(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(country);
    }


    /**
     * 국가 count 증가 기능
     * [POST] api/v1/game/{Id}
     * @return Response.body(CountryDTO)
     */
    @PostMapping("/{id}")
    public ResponseEntity<CountryDTO> createCount(@PathVariable Long id){
        CountryDTO click = gameService.click(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(click);
    }

    /**
     * 국가 List 확인 기능(count로 내림차순)
     * [GET] api/v1/game/list
     * @return Response.body(countryDTOS)
     */
    @GetMapping("/list")
    public ResponseEntity<List<CountryDTO>> findAllDto(){
        List<CountryDTO> countryDTOS = gameService.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryDTOS);
    }
    /**
     * 국가 List 확인 기능(id로 오름차순) - 유지관리용
     * [GET] api/v1/game/list/test
     * @return Response.body(countrys)
     */
    @GetMapping("/test/list")
    public ResponseEntity<List<Country>> findAllCountry(){
        List<Country> countrys = gameService.findCountry();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countrys);
    }


    /**
     * 국가 삭제
     * [DELETE] api/v1/game/test/{id}
     * @param id
     * @return ResponseEntity body("Delete Success")
     */
    @DeleteMapping("/test/{id}")
    public ResponseEntity<String > deleteCountry(@PathVariable Long id){
        gameService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }
}
