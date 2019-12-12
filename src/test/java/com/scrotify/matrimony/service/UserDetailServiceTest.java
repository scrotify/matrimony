package com.scrotify.matrimony.service;

import java.time.LocalDate;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

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
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.util.MatrimonyContants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDetailServiceTest {
	
	@InjectMocks
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Mock
	UserRepository userRepository;

	@Mock
	CasteRepository casteRepository;

	@Mock
	ReligionRepository religionRepository;

	@Mock
	GenderRepository genderRepository;

	@Mock
	MaritalstatusRepository maritalstatusRepository;

	@Mock
	MothertongueRepository mothertongueRepository;

	@Mock
	QualificationRepository qualificatioRepository;

	@Mock
	StateRepository stateRepository;

	@Mock
	CityRepository cityRepository;
	
	public void testUserDetailService() {
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setName("visha");
		userRequestDto.setDob(LocalDate.parse("2019-01-19"));
		userRequestDto.setGenderId(1L);
		userRequestDto.setReligionId(1L);
		userRequestDto.setMotherTongueId(1L);
		userRequestDto.setMaritalStatusId(1L);
		userRequestDto.setMaritalStatusId(1L);
		userRequestDto.setQualificationId(1L);
		userRequestDto.setEmail("vishali@gmail.com");
		userRequestDto.setPassword("abcd");
		userRequestDto.setAnnualIncome(10000.00);
		userRequestDto.setGothram("kashyaba");
		userRequestDto.setHeight(153);
		userRequestDto.setMobileNo(362826575435L);
		userRequestDto.setName("Visha");
		userRequestDto.setOccupation("engineer");
		userRequestDto.setWorkLocation("Bangalore");
		
		UserDetail userDetail = new UserDetail();
		userDetail.setName(userRequestDto.getName());
		userDetail.setDob(userRequestDto.getDob());
		userDetail.setEmailId(userRequestDto.getEmail());
		userDetail.setPassword(userRequestDto.getPassword());
		userDetail.setAnnualIncome(userRequestDto.getAnnualIncome());
		userDetail.setGothram(userRequestDto.getGothram());
		userDetail.setHeight(userRequestDto.getHeight());
		userDetail.setMobileNo(userRequestDto.getMobileNo());
		userDetail.setName(userRequestDto.getName());
		userDetail.setOccupation(userRequestDto.getOccupation());
		userRequestDto.setWorkLocation(userRequestDto.getWorkLocation());
		
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setMessage(MatrimonyContants.REGISTRATION_SUCCESS_MESSAGE);
		userResponseDto.setStatusCode(MatrimonyContants.REGISTRATION_SUCCESS_CODE);
		
		Mockito.when(genderRepository.findByGenderId(1L)).thenReturn(null);
		Mockito.when(stateRepository.findByStateId(1L)).thenReturn(null);
		Mockito.when(maritalstatusRepository.findByMaritalstatusId(1L)).thenReturn(null);
		Mockito.when(mothertongueRepository.findByMothertongueId(1L)).thenReturn(null);
		Mockito.when(qualificatioRepository.findByQualificationId(1L)).thenReturn(null);
		Mockito.when(religionRepository.findByReligionId(1L)).thenReturn(null);
		Mockito.when(userRepository.save(userDetail)).thenReturn(userDetail);

	}

}
