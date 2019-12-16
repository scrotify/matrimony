package com.scrotify.matrimony.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static Logger logger = LogManager.getLogger(UserProfileController.class);
	
	@Autowired
	UserProfileService userProfileService;

	@PutMapping("/updates")
	public ProfileUpdateResponseDto updateProfile(@RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
		logger.info("Entering into upadte profile method");
		return userProfileService.updateProfile(updateProfileRequestDto);
	}

	@PostMapping("/profileinterests")
	public ProfileInterestResponseDto sendInterestProfile(
			@RequestBody ProfileIntersetRequestDto profileIntersetRequestDto) {
		logger.info("Entering into send interested profile method");
		return userProfileService
				.sendInterestProfile(profileIntersetRequestDto);

	}

}
