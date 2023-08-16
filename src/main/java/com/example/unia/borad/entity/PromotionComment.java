package com.example.unia.borad.entity;

import com.example.unia.member.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pomo_comment")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;


    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @CreatedDate
    private LocalDateTime createdDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Promo_id")
    private PromotionBoard promotionBoard;

}