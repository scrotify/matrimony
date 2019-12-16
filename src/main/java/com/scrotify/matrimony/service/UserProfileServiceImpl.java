package com.scrotify.matrimony.service;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.dto.ProfileUpdateResponseDto;
import com.scrotify.matrimony.dto.UpdateProfileRequestDto;
import com.scrotify.matrimony.entity.ProfileInterest;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.repository.ProfileInterestRepository;
import com.scrotify.matrimony.repository.UserDetailRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	private static Logger logger = LogManager.getLogger(UserProfileServiceImpl.class);
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	ProfileInterestRepository profileInterestRepository;

	@Override
	public ProfileInterestResponseDto sendInterestProfile(ProfileIntersetRequestDto profileIntersetRequestDto) {
		logger.info("ENtering into send interest profile service method");
		ProfileInterestResponseDto profileInterestResponseDto = new ProfileInterestResponseDto();
		Optional<UserDetail> userId = userDetailRepository.findByUserId(profileIntersetRequestDto.getFromUserId());
		if (userId.isPresent()) {
			Optional<ProfileInterest> intersId = profileInterestRepository
					.findByInterestUserId(profileIntersetRequestDto.getProfileInterestId());
			if (!intersId.isPresent()) {
				ProfileInterest profileInterest = new ProfileInterest();
				profileInterest.setFromUserId(userId.get().getUserId());
				profileInterest.setInterestUserId(profileIntersetRequestDto.getProfileInterestId());
				profileInterest.setDate(LocalDate.now());
				profileInterestRepository.save(profileInterest);
				profileInterestResponseDto.setMessage("interest has been sent");
				profileInterestResponseDto.setStatusCode(201);
			} else {
				profileInterestResponseDto.setMessage("already interest has been sent");
			}
		}
		logger.info("Ending of send interest profile method");
		return profileInterestResponseDto;

	}

	@Override
	public ProfileUpdateResponseDto updateProfile(UpdateProfileRequestDto updateProfileRequestDto) {
		logger.info("Entering into update profile service method");
		ProfileUpdateResponseDto profileUpdateResponseDto = new ProfileUpdateResponseDto();
		Optional<UserDetail> optionaluser = userDetailRepository.findByUserId(updateProfileRequestDto.getUserId());
		if (optionaluser.isPresent()) {
			UserDetail userDetail = optionaluser.get();
			userDetail.setEmailId(updateProfileRequestDto.getEmailId());
			userDetail.setDob(updateProfileRequestDto.getDateOfBirth());
			userDetail.setMobileNo(updateProfileRequestDto.getMobileNo());
			userDetail.setOccupation(updateProfileRequestDto.getOccupation());
			userDetail.setName(updateProfileRequestDto.getName());
			userDetail.setAnnualIncome(updateProfileRequestDto.getAnnualIncome());
			userDetail.setPassword(updateProfileRequestDto.getPassword());
			userDetailRepository.save(userDetail);
			profileUpdateResponseDto.setMessage("your profile has been updated successfully");
			profileUpdateResponseDto.setStatusCode(201);

		} else {
			profileUpdateResponseDto.setMessage("user not found");

		}
		logger.info("Ending of update profile method");
		return profileUpdateResponseDto;
	}

}
