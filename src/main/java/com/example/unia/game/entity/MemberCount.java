package com.example.unia.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCount {

    @Id
    public Long MemberId;
    public Long count;
    public MemberCount(Long memberId, Long count) {
        MemberId = memberId;
        this.count = count;
    }

}
