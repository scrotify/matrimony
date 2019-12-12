package com.scrotify.matrimony.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.matrimony.Repository.UserDetailRepository;
import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.util.MatrimonyContants;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException {
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
		return userLoginResponseDto;
	}

	@Override
	public List<UserViewProfileResponseDto> getByUserId(Long userId) throws UserNotFoundException {
		UserViewProfileResponseDto userViewProfileResponseDto = new UserViewProfileResponseDto();
		Optional<UserDetail> user = userDetailRepository.findByUserId(userId);
		List<UserViewProfileResponseDto> list = new ArrayList<>();
		if (user.isPresent()) {
			userViewProfileResponseDto.setAnnualIncome(user.get().getAnnualIncome());
			userViewProfileResponseDto.setCaste(user.get().getReligionDetail().getCasteDetails().get(0).getCasteName());
			userViewProfileResponseDto.setCity(user.get().getStateDetail().getCityDetails().get(0).getCityName());
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
			userViewProfileResponseDto.setState(user.get().getStateDetail().getStateName());
			userViewProfileResponseDto.setWorkLocation(user.get().getWorkLocation());
			list.add(userViewProfileResponseDto);
		} else {
			throw new UserNotFoundException("User Not Found");
		}
		return list;
	}

}
