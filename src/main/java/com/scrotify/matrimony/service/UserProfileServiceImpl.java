package com.scrotify.matrimony.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.matrimony.Repository.ProfileInterestRepository;
import com.scrotify.matrimony.Repository.UserDetailRepository;
import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.dto.ProfileUpdateResponseDto;
import com.scrotify.matrimony.dto.UpdateProfileRequestDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.ErrorResponse;

@Service
public class UserProfileServiceImpl implements UserProfileService {
@Autowired
UserDetailRepository  userDetailRepository;
@Autowired
ProfileInterestRepository profileInterestRepository;
	@Override
	public ProfileInterestResponseDto sendInterestProfile(ProfileIntersetRequestDto profileIntersetRequestDto) {
		/*
		 * ProfileInterestResponseDto profileInterestResponseDto=null; if
		 * (profileInterestRepository.findByMobile(fromMobile).isEmpty() ||
		 * profileInterestRepository.findByMobile(targetMobile).isEmpty()) throw new
		 * MatromonyException(" profiles not existed");
		 * 
		 * return null;
		 */
		return null;
	}

	@Override
	public ProfileUpdateResponseDto updateProfile(UpdateProfileRequestDto updateProfileRequestDto) {
		ProfileUpdateResponseDto profileUpdateResponseDto=new ProfileUpdateResponseDto();
	//	ErrorResponse errorResponse=new ErrorResponse();
		Optional<UserDetail> Optionaluser=userDetailRepository.findByUserId(updateProfileRequestDto.getUserId());
		if(Optionaluser.isPresent()) {
			UserDetail userDetail= Optionaluser.get();
			
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
			
		}else {
			profileUpdateResponseDto.setMessage("user not found");
		 
		}
		return profileUpdateResponseDto;
	}

}
