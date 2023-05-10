package com.example.unia.member.dto;

import com.example.unia.member.entity.MemberEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
public class MemberUpdateDTO {

    @NotBlank(message = "Please enter your first name")
    private String firstName; // 이름

    @NotBlank(message = "Please enter your last name")
    private String lastName; // 성


    @NotBlank(message = "Please enter your major")
    private String memberMajor; // 학과




    public Long toMemberDTO(MemberEntity memberEntity ,MemberUpdateDTO memberUpdateDTO ){
        memberEntity.setLastName(memberUpdateDTO.getLastName());
        memberEntity.setFirstName(memberUpdateDTO.getFirstName());
        memberEntity.setMemberMajor(memberUpdateDTO.getMemberMajor());
        return memberEntity.getMemberId();
    }




}

