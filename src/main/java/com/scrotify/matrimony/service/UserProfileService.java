package com.scrotify.matrimony.service;

import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.dto.ProfileUpdateResponseDto;
import com.scrotify.matrimony.dto.UpdateProfileRequestDto;

public interface UserProfileService {

	public ProfileInterestResponseDto sendInterestProfile(ProfileIntersetRequestDto profileIntersetRequestDto);
	public ProfileUpdateResponseDto updateProfile(UpdateProfileRequestDto updateProfileRequestDto);

}
