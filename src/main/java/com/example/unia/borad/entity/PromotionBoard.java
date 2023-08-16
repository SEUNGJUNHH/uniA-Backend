package com.example.unia.borad.entity;

import com.example.unia.borad.dto.PromotionBoardDto;
import com.example.unia.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "promotion_board")
public class PromotionBoard {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promotion_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @CreatedDate
    private LocalDateTime createdDate;

    private Long likeCount= 0L;

    //columnDefinition = "TEXT"로 설정하여 길이제한을 없애준다.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Long commentCount = 0L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_memberId")
    private MemberEntity member;

    @Builder
    public PromotionBoard(PromotionBoardDto boardDto, MemberEntity member) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.member = member;
    }


}
