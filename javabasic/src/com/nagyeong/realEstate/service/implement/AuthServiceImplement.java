package com.nagyeong.realEstate.service.implement;

import java.util.Random;

import com.nagyeong.realEstate.dto.request.CheckIdRequestDto;
import com.nagyeong.realEstate.dto.request.SendCodeRequestDto;
import com.nagyeong.realEstate.dto.response.CheckIdResponseDto;
import com.nagyeong.realEstate.dto.response.SendCodeResponseDto;
import com.nagyeong.realEstate.interfaces.Code;
import com.nagyeong.realEstate.repository.EmailAuthenticationRepositiry;
import com.nagyeong.realEstate.repository.UserRepository;
import com.nagyeong.realEstate.service.AuthService;

public class AuthServiceImplement implements AuthService {
	
	private UserRepository userRepository;
	private EmailAuthenticationRepositiry emailAuthenticationRepository;
	
//	private UserRepository userRepository = new UserRepositoryImplement();
	public AuthServiceImplement (UserRepository userRepository, EmailAuthenticationRepositiry emailAuthenticationRepository) {
		this.userRepository = userRepository;
		this.emailAuthenticationRepository = emailAuthenticationRepository;
	}
	

	@Override
	public CheckIdResponseDto checkId(CheckIdRequestDto dto) {
		
		CheckIdResponseDto result = new CheckIdResponseDto();
		
		try {
			String id = dto.getId();
			
			boolean existedId = userRepository.existsById(id);
			
			if (existedId) result.setCode(Code.DI);
			else result.setCode(Code.SU);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			result.setCode(Code.DBE);
		}
		
		return result;
	}

	@Override
	public SendCodeResponseDto sendCode(SendCodeRequestDto dto) {
		
		SendCodeResponseDto result = new SendCodeResponseDto();
		
		try {
			
			String email = dto.getEmail();
			String authenticationCode = randomString();
			
			boolean existedEmail = emailAuthenticationRepository.existByEmail(email);
			if (existedEmail) {
				result.setCode(Code.DE);
				return result;
			}
			
			emailAuthenticationRepository.save(email, authenticationCode);
			result.setCode(Code.SU);
			result.setData(authenticationCode);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			result.setCode(Code.DBE);
		}
		
		return result;
	}
	
	private String randomString() {
		char[] randomString = new char[4];
		Random random = new Random();
		for (int index = 0; index < 4; index++) {
			randomString[index] = (char) (random.nextInt(26) + 65);
		}
		return new String(randomString);
	}

}
