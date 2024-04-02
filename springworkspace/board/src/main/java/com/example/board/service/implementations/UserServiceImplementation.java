package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
    
    try {

      return ResponseDto.notExistUser();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    // 위에서 return을 해놨기 때문에 컴파일 에러
    // return GetUserResponseDto.success("email@emaail.com", "홍길동", null);


  }


  
}
