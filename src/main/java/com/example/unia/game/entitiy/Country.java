package com.example.unia.game.entitiy;


import com.example.unia.assignment.entity.AssignmentEntity;
import com.example.unia.board.entitiy.FreeBoard;
import com.example.unia.board.entitiy.PromotionBoard;
import com.example.unia.game.gamedto.CountryDTO;
import com.example.unia.member.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
