package com.estate.back.service.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.entity.BoardEntity;
import com.estate.back.repository.BoardRepository;
import com.estate.back.repository.UserRepository;
import com.estate.back.service.BoardService;

import lombok.RequiredArgsConstructor;

// Board 모듈의 비즈니스 로직 구현체
@Service
@RequiredArgsConstructor
public class BoardServiceImplementation implements BoardService {
  private final BoardRepository boardRepository;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId) {
    try {
      boolean isExistUser = userRepository.existsByUserId(userId);
      if (!isExistUser) return ResponseDto.authenticationFailed();

      BoardEntity boardEntity = new BoardEntity(dto, userId);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }
  
}
