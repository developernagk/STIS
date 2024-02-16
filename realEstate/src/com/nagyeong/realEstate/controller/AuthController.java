package com.nagyeong.realEstate.controller;

import com.nagyeong.realEstate.dto.request.CheckIdRequestDto;
import com.nagyeong.realEstate.dto.request.SendCodeRequestDto;
import com.nagyeong.realEstate.dto.response.CheckIdResponseDto;
import com.nagyeong.realEstate.dto.response.SendCodeResponseDto;

public interface AuthController {
	CheckIdResponseDto checkId(CheckIdRequestDto request);
	SendCodeResponseDto sendCode(SendCodeRequestDto request);
}
