package com.estate.back.dto.response;

// Response의 공통된 message 값
public interface ResponseMessage {
  String SUCCESS = "Success.";
  String VALIDATION_FAILED = "Validation Failed.";
  String DUPLICATED_ID = "Duplicated Id.";
  String DUPLICATED_EMAIL = "Duplicated Email.";
  String NO_EXIST_BOARD = "No Exist Board.";
  String SIGN_IN_FAILED = "Sign in Failed.";
  String AUTHENTICATION_FAILED = "Authentication Failed.";
  String TOKEN_CREATEION_FAILED = "Token creation Failed.";
  String MAIL_SEND_FAILED = "Mail send Failed.";
  String DATABASE_ERROR = "Database Error.";
}
