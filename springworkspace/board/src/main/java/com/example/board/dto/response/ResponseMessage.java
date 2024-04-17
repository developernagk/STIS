package com.example.board.dto.response;

public interface ResponseMessage {
  // 200
  String SUCCESS = "Success.";

  // 400
  String VALIDATION_FAIL = "Validation failed.";
  String DUPLICATE_EMAIL = "Duplicate email.";
  String DUPLICATE_NICKNAME = "Duplicate nickname.";
  String DUPLICATE_TEL_NUMBER = "Duplicate telephone number.";
  String NOT_EXIST_USER = "This user does not exist.";
  String N0T_EXIST_BOARD = "This board does not exist.";

  // 401
  String SIGN_IN_FAIL = "Login information mismatch.";
  String AUTHORIZATION_FAIL = "Authorization Failed.";

  // 403
  String NO_PERMISSION = "Do not have permission.";

  // 500
  String DATABASE_ERROR = "Database error.";

}
