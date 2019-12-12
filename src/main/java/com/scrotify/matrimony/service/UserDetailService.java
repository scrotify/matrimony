package com.scrotify.matrimony.service;

import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.exception.UserNotEligibleException;

public interface UserDetailService {
	
	public UserResponseDto newUser(UserRequestDto userRequestDto) throws UserNotEligibleException;

}
