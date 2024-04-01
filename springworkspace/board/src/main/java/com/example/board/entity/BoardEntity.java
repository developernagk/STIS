package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="board")
@Table(name="board")
public class BoardEntity {
  private Integer boardNumber;
  private String title;
  private String contents;
  private Integer favoriteCount;
  private Integer commentCount;
  private Integer viewCount;
  private String writerEmail;
}
