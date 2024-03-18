package com.nagyeong.realEstate.service;

import com.nagyeong.realEstate.dto.request.CheckIdRequestDto;
import com.nagyeong.realEstate.dto.request.SendCodeRequestDto;
import com.nagyeong.realEstate.dto.response.CheckIdResponseDto;
import com.nagyeong.realEstate.dto.response.SendCodeResponseDto;

public interface AuthService {
	CheckIdResponseDto checkId(CheckIdRequestDto dto);
	SendCodeResponseDto sendCode(SendCodeRequestDto dto);
}
