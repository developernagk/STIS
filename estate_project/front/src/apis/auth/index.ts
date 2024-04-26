import axios from "axios";
import { SignInRequestDto } from "./dto/request";
import { SIGN_IN_REQUEST_URL } from "src/constant";
import { SignInResponseDto } from "./dto/response";
// 파일명이 index.ts일 경우 인터페이스명으로 받아옴

// function : 로그인 API 함수
export const SignInRequest = async (requestBody: SignInRequestDto) => {
  const result = await axios.post(SIGN_IN_REQUEST_URL, requestBody)
    .then(response => {
      const responseBody = response.data as SignInResponseDto;
      return responseBody;
    })
    .catch(error => {})
}