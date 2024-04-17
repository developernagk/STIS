package com.example.board.dto.response;

public interface ResponseCode {
  // 200
  String SUCCESS = "SU";

  // 400
  String VALIDATION_FAIL = "VF";
  String DUPLICATE_EMAIL = "DE";
  String DUPLICATE_NICKNAME = "DN";
  String DUPLICATE_TEL_NUMBER = "DT";
  String NOT_EXIST_USER = "NU";
  String N0T_EXIST_BOARD = "NB";
  
  // 401
  String SIGN_IN_FAIL = "SF";
  String AUTHORIZATION_FAIL = "AF";

  // 403
  String NO_PERMISSION = "NP";

  // 500
  String DATABASE_ERROR = "DBE";

}
