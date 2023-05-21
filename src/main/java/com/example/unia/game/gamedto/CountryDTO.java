package com.example.unia.game.gamedto;

import com.example.unia.game.entitiy.Country;
import lombok.Data;

@Data
public class CountryDTO {
    public String name;
    public Long count;

    public CountryDTO(Country country) {
        this.name = country.getName();
        this.count = country.getCount();
    }
}
