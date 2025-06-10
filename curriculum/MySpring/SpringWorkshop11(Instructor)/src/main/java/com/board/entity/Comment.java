package com.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
