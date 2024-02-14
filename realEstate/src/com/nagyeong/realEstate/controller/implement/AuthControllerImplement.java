package com.nagyeong.realEstate.controller.implement;

import com.nagyeong.realEstate.controller.AuthController;
import com.nagyeong.realEstate.dto.request.CheckIdRequestDto;
import com.nagyeong.realEstate.dto.request.SendCodeRequestDto;
import com.nagyeong.realEstate.dto.response.CheckIdResponseDto;
import com.nagyeong.realEstate.dto.response.SendCodeResponseDto;
import com.nagyeong.realEstate.interfaces.Code;
import com.nagyeong.realEstate.service.AuthService;
import com.nagyeong.realEstate.service.implement.AuthServiceImplement;

public class AuthControllerImplement implements AuthController {
	
	private AuthService authService;
	
//	private AuthService authService = new AuthServiceImplement();
	public AuthControllerImplement (AuthService authService) {
		this.authService = authService;
	}

	@Override
	public CheckIdResponseDto checkId(CheckIdRequestDto request) {
		boolean validId = request.validId();
		if (!validId) return new CheckIdResponseDto(Code.VF, null);
		
		CheckIdResponseDto response = authService.checkId(request);
		return response;
	}

	@Override
	public SendCodeResponseDto sendCode(SendCodeRequestDto request) {
		boolean valid = request.validEmail();
		if (!valid) return new SendCodeResponseDto(Code.VF, null);
		
		SendCodeResponseDto response = authService.sendCode(request);
		return response;
	}

}
