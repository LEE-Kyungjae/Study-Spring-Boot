package com.sbcrud.webpj.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime lastFixDate;
}
