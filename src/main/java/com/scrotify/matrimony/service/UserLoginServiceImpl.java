package com.scrotify.matrimony.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.repository.UserDetailRepository;
import com.scrotify.matrimony.util.MatrimonyContants;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	private static Logger logger = LogManager.getLogger(UserLoginServiceImpl.class);

	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException {
		logger.info("Entering into user login service method");
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		Optional<UserDetail> user = userDetailRepository.findByEmailId(userLoginRequestDto.getEmailId());
		if (user.isPresent()) {
			if (user.get().getEmailId().equals(userLoginRequestDto.getEmailId())
					&& user.get().getPassword().equals(userLoginRequestDto.getPassword())) {
				userLoginResponseDto.setName(user.get().getName());
				userLoginResponseDto.setStatusCode(MatrimonyContants.LOGIN_SUCCESS_CODE);
				userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_SUCCESS_MESSAGE);
			} else {
				userLoginResponseDto.setStatusCode(MatrimonyContants.INVALID_CODE);
				userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_FAILURE);
			}

		} else {
			throw new UserNotFoundException("User Not Found");
		}
		logger.info("Ending of login user service method");
		return userLoginResponseDto;
	}

	@Override
	public List<UserViewProfileResponseDto> getByUserId(Long userId) throws UserNotFoundException {
		logger.info("Entering into view profile by userId method");
		UserViewProfileResponseDto userViewProfileResponseDto = new UserViewProfileResponseDto();
		Optional<UserDetail> user = userDetailRepository.findByUserId(userId);
		List<UserViewProfileResponseDto> list = new ArrayList<>();
		if (user.isPresent()) {
			userViewProfileResponseDto.setAnnualIncome(user.get().getAnnualIncome());
			userViewProfileResponseDto.setDate(user.get().getDob());
			userViewProfileResponseDto.setEmailId(user.get().getEmailId());
			userViewProfileResponseDto.setGender(user.get().getGenderDetail().getGender());
			userViewProfileResponseDto.setGothram(user.get().getGothram());
			userViewProfileResponseDto.setHeight(user.get().getHeight());
			userViewProfileResponseDto.setMaritalStatus(user.get().getMaritalstatusDetail().getMaritalStatus());
			userViewProfileResponseDto.setMobileNo(user.get().getMobileNo());
			userViewProfileResponseDto.setMotherTongue(user.get().getMothertongueDetail().getMotherTongue());
			userViewProfileResponseDto.setName(user.get().getName());
			userViewProfileResponseDto.setOccupation(user.get().getOccupation());
			userViewProfileResponseDto.setQualification(user.get().getQualificationDetail().getQualificationName());
			userViewProfileResponseDto.setRelegion(user.get().getReligionDetail().getReligionName());
			userViewProfileResponseDto.setWorkLocation(user.get().getWorkLocation());
			list.add(userViewProfileResponseDto);
		} else {
			throw new UserNotFoundException("User Not Found");
		}
		logger.info("Ending of view profile service method");
		return list;
	}

}
