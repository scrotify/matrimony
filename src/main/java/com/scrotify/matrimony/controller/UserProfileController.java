package com.scrotify.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.dto.ProfileUpdateResponseDto;
import com.scrotify.matrimony.dto.UpdateProfileRequestDto;
import com.scrotify.matrimony.service.UserProfileService;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {
	@Autowired
	UserProfileService userProfileService;

	@PutMapping("/updates")
	public ProfileUpdateResponseDto updateProfile(@RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
		ProfileUpdateResponseDto profileUpdateResponseDto=userProfileService.updateProfile(updateProfileRequestDto);
	return profileUpdateResponseDto;
	}
	@PostMapping("profileinterests")
	public ProfileInterestResponseDto sendInterestProfile(@RequestBody ProfileIntersetRequestDto profileIntersetRequestDto) {
		ProfileInterestResponseDto profileInterestResponseDto=userProfileService.sendInterestProfile(profileIntersetRequestDto);
		return profileInterestResponseDto;
		
	}
	
}
