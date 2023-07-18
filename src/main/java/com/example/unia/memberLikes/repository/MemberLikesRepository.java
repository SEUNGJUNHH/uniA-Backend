package com.example.unia.memberLikes.repository;

import com.example.unia.memberLikes.entity.MemberLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberLikesRepository extends JpaRepository<MemberLikesEntity, Long> {
    List<MemberLikesEntity> findAllByMemberId(Long memberId);

    MemberLikesEntity findByMemberIdAndPlaceId(Long memberId, Long id);

}