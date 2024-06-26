package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="board_image")
@Table(name="board_image")
public class BoardImageEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Integer sequence;
  private Integer boardNumber;
  private String imageUrl;
}
