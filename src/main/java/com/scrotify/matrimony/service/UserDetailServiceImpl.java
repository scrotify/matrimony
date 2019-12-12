package com.scrotify.matrimony.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scrotify.matrimony.Repository.CasteRepository;
import com.scrotify.matrimony.Repository.CityRepository;
import com.scrotify.matrimony.Repository.GenderRepository;
import com.scrotify.matrimony.Repository.MaritalstatusRepository;
import com.scrotify.matrimony.Repository.MothertongueRepository;
import com.scrotify.matrimony.Repository.QualificationRepository;
import com.scrotify.matrimony.Repository.ReligionRepository;
import com.scrotify.matrimony.Repository.StateRepository;
import com.scrotify.matrimony.Repository.UserRepository;
import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.entity.CasteDetail;
import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.GenderDetail;
import com.scrotify.matrimony.entity.MaritalstatusDetail;
import com.scrotify.matrimony.entity.MothertongueDetail;
import com.scrotify.matrimony.entity.QualificationDetail;
import com.scrotify.matrimony.entity.ReligionDetail;
import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.UserNotEligibleException;
import com.scrotify.matrimony.util.MatrimonyContants;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ReligionRepository religionRepository;

	@Autowired
	GenderRepository genderRepository;

	@Autowired
	MaritalstatusRepository maritalstatusRepository;

	@Autowired
	MothertongueRepository mothertongueRepository;

	@Autowired
	QualificationRepository qualificatioRepository;

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CasteRepository casteRepository;

	@Override
	public UserResponseDto newUser(UserRequestDto userRequestDto) throws UserNotEligibleException {
		UserResponseDto userResponseDto = new UserResponseDto();
		UserDetail userDetail = new UserDetail();
		LocalDate date = LocalDate.now();
		LocalDate dob = userRequestDto.getDob();
		Integer age = Math.abs(Period.between(date, dob).getYears());
		if (age > 18) {
			userDetail.setAnnualIncome(userRequestDto.getAnnualIncome());
			userDetail.setDob(userRequestDto.getDob());
			userDetail.setAge(age);
			ReligionDetail religion = religionRepository.findByReligionId(userRequestDto.getReligionId());
			Optional<CasteDetail> casteDetail = casteRepository.findById(userRequestDto.getCasteId());
			if(casteDetail.isPresent()) {
				religion.addCasteDetail(casteDetail.get());
			}
			userDetail.setReligionDetail(religion);
			userDetail.setGothram(userRequestDto.getGothram());
			userDetail.setEmailId(userRequestDto.getEmail());
			userDetail.setPassword(userRequestDto.getPassword());
			userDetail.setName(userRequestDto.getName());
			userDetail.setOccupation(userRequestDto.getOccupation());
			userDetail.setMobileNo(userRequestDto.getMobileNo());
			GenderDetail genderDetail = genderRepository.findByGenderId(userRequestDto.getGenderId());
			userDetail.setGenderDetail(genderDetail);
			MaritalstatusDetail maritalStatus = maritalstatusRepository
					.findByMaritalstatusId(userRequestDto.getMaritalStatusId());
			userDetail.setMaritalstatusDetail(maritalStatus);
			StateDetail state = stateRepository.findByStateId(userRequestDto.getStateId());
			
			
			Optional<CityDetail> cityDetailsOptional = cityRepository.findById(userRequestDto.getCityId());
			if (cityDetailsOptional.isPresent() ) {
				state.addCityDetail(cityDetailsOptional.get());	
			}
			userDetail.setStateDetail(state);
 			
			QualificationDetail qualification = qualificatioRepository
					.findByQualificationId(userRequestDto.getQualificationId());
			userDetail.setQualificationDetail(qualification);
			userDetail.setWorkLocation(userRequestDto.getWorkLocation());
			MothertongueDetail motherTongue = mothertongueRepository
					.findByMothertongueId(userRequestDto.getMotherTongueId());
			userDetail.setMothertongueDetail(motherTongue);
			userRepository.save(userDetail);
			userResponseDto.setMessage(MatrimonyContants.REGISTRATION_SUCCESS_MESSAGE);
			userResponseDto.setStatusCode(MatrimonyContants.REGISTRATION_SUCCESS_CODE);
		} else {
			throw new UserNotEligibleException(MatrimonyContants.USER_NOT_ELIGIBLE_MESSAGE);
		}
		return userResponseDto;

	}

}
