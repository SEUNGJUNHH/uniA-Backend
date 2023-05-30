package com.example.unia.memberLikes.dto;

import com.example.unia.memberLikes.entity.MemberLikesEntity;
import lombok.Data;

@Data
public class MemberLikesDto {
    private Long memberLikesId;
    private Long memberId;
    private Long placeId;

    public static MemberLikesDto toMemberLikesDto(MemberLikesEntity memberLikesEntity){
        MemberLikesDto memberLikesDto = new MemberLikesDto();
        memberLikesDto.setMemberLikesId(memberLikesEntity.getMemberLikesId());
        memberLikesDto.setMemberId(memberLikesEntity.getMemberId());
        memberLikesDto.setPlaceId(memberLikesEntity.getPlaceId());
        return memberLikesDto;
    }
}
