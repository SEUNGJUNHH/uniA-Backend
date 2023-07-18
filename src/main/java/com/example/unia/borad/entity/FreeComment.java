package com.example.unia.borad.entity;

import com.example.unia.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "free_comment")
@Getter
@Setter
@NoArgsConstructor
public class FreeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;


    @Column(columnDefinition = "TEXT")
    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_id")
    private FreeBoard freeBoard;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    @Builder
    public FreeComment(String content, FreeBoard freeBoard, MemberEntity member) {
        this.content = content;
        this.freeBoard = freeBoard;
        this.member = member;
    }
}