package com.example.unia.borad.entity;

import com.example.unia.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pomo_comment")
@Getter
@Setter
@NoArgsConstructor
public class PromotionComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Long commentId;


    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Promotion_id")
    private PromotionBoard promotionBoard;

    @Builder
    public PromotionComment( String content, MemberEntity member, PromotionBoard promotionBoard) {
        this.content = content;
        this.member = member;
        this.promotionBoard = promotionBoard;
    }
}