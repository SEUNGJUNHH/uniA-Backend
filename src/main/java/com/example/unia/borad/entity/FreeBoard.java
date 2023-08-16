package com.example.unia.borad.entity;

import com.example.unia.borad.dto.FreeBoardDto;
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
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "free_board")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @CreatedDate
    private LocalDateTime createdDate;

    //columnDefinition = "TEXT"로 설정하여 길이제한을 없애준다.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private Long likeCount = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_memberId")
    private MemberEntity member;

    private Long commentCount= 0L;

    @Builder
    public FreeBoard(FreeBoardDto boardDto, MemberEntity member) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.member = member;
    }


}
