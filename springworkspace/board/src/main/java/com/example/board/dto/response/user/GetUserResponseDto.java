package com.example.board.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseCode;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetUserResponseDto extends ResponseDto {
  private String email;
  private String nickName;
  private String profileImage;

  private GetUserResponseDto(String email, String nickName, String profileImage) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.email = email;
    this.nickName = nickName;
    this.profileImage = profileImage;
  }

  public static ResponseEntity<GetUserResponseDto> success(String email, String nickName, String profileImage) {
    GetUserResponseDto body = new GetUserResponseDto(email, nickName, profileImage);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
  
}
