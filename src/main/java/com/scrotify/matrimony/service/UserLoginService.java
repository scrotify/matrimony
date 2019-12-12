package com.scrotify.matrimony.service;

import java.util.List;

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.exception.UserNotFoundException;


public interface UserLoginService {

	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException;
	
	public List<UserViewProfileResponseDto> getByUserId(Long userId) throws UserNotFoundException;

}
