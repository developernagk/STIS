package com.example.board.service;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseDto;

public interface UserService {
  ResponseEntity<ResponseDto> getUser();
}
