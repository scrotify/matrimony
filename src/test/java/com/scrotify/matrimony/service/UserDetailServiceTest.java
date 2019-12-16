package com.scrotify.matrimony.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.GenderDetail;
import com.scrotify.matrimony.entity.MaritalstatusDetail;
import com.scrotify.matrimony.entity.MothertongueDetail;
import com.scrotify.matrimony.entity.QualificationDetail;
import com.scrotify.matrimony.entity.ReligionDetail;
import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.UserNotEligibleException;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.repository.CasteRepository;
import com.scrotify.matrimony.repository.CityRepository;
import com.scrotify.matrimony.repository.GenderRepository;
import com.scrotify.matrimony.repository.MaritalstatusRepository;
import com.scrotify.matrimony.repository.MothertongueRepository;
import com.scrotify.matrimony.repository.QualificationRepository;
import com.scrotify.matrimony.repository.ReligionRepository;
import com.scrotify.matrimony.repository.StateRepository;
import com.scrotify.matrimony.repository.UserDetailRepository;
import com.scrotify.matrimony.repository.UserRepository;
import com.scrotify.matrimony.util.MatrimonyContants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDetailServiceTest {
	
	@InjectMocks
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Mock
	UserDetailRepository userDetailRepository;
	
	@InjectMocks
	UserLoginServiceImpl userLoginServiceImpl;
	
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
	
	@Test
	public void testUserDetailService() throws UserNotEligibleException {

		GenderDetail genderDetails=new GenderDetail();
		genderDetails.setGender("annn");

		MothertongueDetail mothertongueDetail = new MothertongueDetail();
		mothertongueDetail.setMotherTongue("anisha");

		MaritalstatusDetail maritalstatusDetail = new MaritalstatusDetail();
		maritalstatusDetail.setMaritalStatus("aaa");

		QualificationDetail qualificationDetail = new QualificationDetail();
		qualificationDetail.setQualificationName("aaaa");

		ReligionDetail religionDetail = new ReligionDetail();
		religionDetail.setReligionName("aaaa");

		CityDetail cityDetail = new CityDetail();
		cityDetail.setCityName("aaaaa");

		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateName("aaaa");

		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setName("visha");
		userRequestDto.setDob(LocalDate.parse("2000-01-19"));
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
		
		UserResponseDto result = userDetailServiceImpl.newUser(userRequestDto);
		
		assertEquals(MatrimonyContants.REGISTRATION_SUCCESS_MESSAGE, result.getMessage());

	}
	
	@Test(expected = UserNotEligibleException.class)
	public void testUserDetailServiceForNegative() throws UserNotEligibleException {

		GenderDetail genderDetails=new GenderDetail();
		genderDetails.setGender("annn");

		MothertongueDetail mothertongueDetail = new MothertongueDetail();
		mothertongueDetail.setMotherTongue("anisha");

		MaritalstatusDetail maritalstatusDetail = new MaritalstatusDetail();
		maritalstatusDetail.setMaritalStatus("aaa");

		QualificationDetail qualificationDetail = new QualificationDetail();
		qualificationDetail.setQualificationName("aaaa");

		ReligionDetail religionDetail = new ReligionDetail();
		religionDetail.setReligionName("aaaa");

		CityDetail cityDetail = new CityDetail();
		cityDetail.setCityName("aaaaa");

		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateName("aaaa");

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
		
		UserResponseDto result = userDetailServiceImpl.newUser(userRequestDto);
		
		assertEquals(MatrimonyContants.USER_NOT_ELIGIBLE_MESSAGE,result.getMessage());

	}
	
	@Test
	public void testLogin() throws UserNotFoundException {
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setName("anisha");
		userLoginResponseDto.setStatusCode(MatrimonyContants.LOGIN_SUCCESS_CODE);
		

		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setEmailId("anish@gmail.com");
		userLoginRequestDto.setPassword("1234");
		
		UserDetail userDetails = new UserDetail();
		userDetails.setUserId(1L);
		
		GenderDetail genderDetails=new GenderDetail();
		genderDetails.setGender("annn");
		
		MothertongueDetail mothertongueDetail = new MothertongueDetail();
		mothertongueDetail.setMotherTongue("anisha");
		
		MaritalstatusDetail maritalstatusDetail = new MaritalstatusDetail();
		maritalstatusDetail.setMaritalStatus("aaa");
		
		QualificationDetail qualificationDetail = new QualificationDetail();
		qualificationDetail.setQualificationName("aaaa");
		
		ReligionDetail religionDetail = new ReligionDetail();
		religionDetail.setReligionName("aaaa");
		
		CityDetail cityDetail = new CityDetail();
		cityDetail.setCityName("aaaaa");
		
		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateName("aaaa");
		
		
		userDetails.setAge(12);
		userDetails.setAnnualIncome(10000);
		userDetails.setEmailId("anish@gmail.com");
		userDetails.setGenderDetail(genderDetails);
        userDetails.setGothram("annn");
        userDetails.setHeight(150);
        userDetails.setMaritalstatusDetail(maritalstatusDetail);
        userDetails.setMobileNo(10000000L);
        userDetails.setMothertongueDetail(mothertongueDetail);
        userDetails.setName("anisha");
        userDetails.setOccupation("aaaa");
        userDetails.setPassword("aaaa");
        userDetails.setQualificationDetail(qualificationDetail);
        userDetails.setReligionDetail(religionDetail);
		userDetails.setStateDetail(stateDetail);
		userDetails.setUserId(1L);
		userDetails.setWorkLocation("aaaa");
		
		Mockito.when(userDetailRepository.findByEmailId(Mockito.anyString()))
				.thenReturn(Optional.of(userDetails));
		UserLoginResponseDto actual = userLoginServiceImpl.loginUser(userLoginRequestDto);
		assertNotNull(actual);
	}
	
	@Test
	public void testLoginForNegative() throws UserNotFoundException {
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setName("anisha");
		userLoginResponseDto.setStatusCode(MatrimonyContants.LOGIN_SUCCESS_CODE);
		

		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setEmailId("anish@gmail.com");
		userLoginRequestDto.setPassword("1234");
		
		UserDetail userDetails = new UserDetail();
		userDetails.setUserId(1L);
		
		GenderDetail genderDetails=new GenderDetail();
		genderDetails.setGender("annn");
		
		MothertongueDetail mothertongueDetail = new MothertongueDetail();
		mothertongueDetail.setMotherTongue("anisha");
		
		MaritalstatusDetail maritalstatusDetail = new MaritalstatusDetail();
		maritalstatusDetail.setMaritalStatus("aaa");
		
		QualificationDetail qualificationDetail = new QualificationDetail();
		qualificationDetail.setQualificationName("aaaa");
		
		ReligionDetail religionDetail = new ReligionDetail();
		religionDetail.setReligionName("aaaa");
		
		CityDetail cityDetail = new CityDetail();
		cityDetail.setCityName("aaaaa");
		
		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateName("aaaa");
		
		
		userDetails.setAge(12);
		userDetails.setAnnualIncome(10000);
		userDetails.setEmailId("anish@gmail.com");
		userDetails.setGenderDetail(genderDetails);
        userDetails.setGothram("annn");
        userDetails.setHeight(150);
        userDetails.setMaritalstatusDetail(maritalstatusDetail);
        userDetails.setMobileNo(10000000L);
        userDetails.setMothertongueDetail(mothertongueDetail);
        userDetails.setName("anisha");
        userDetails.setOccupation("aaaa");
        userDetails.setPassword("1234");
        userDetails.setQualificationDetail(qualificationDetail);
        userDetails.setReligionDetail(religionDetail);
		userDetails.setStateDetail(stateDetail);
		userDetails.setUserId(1L);
		userDetails.setWorkLocation("aaaa");
		
		Mockito.when(userDetailRepository.findByEmailId(Mockito.anyString()))
				.thenReturn(Optional.of(userDetails));
		UserLoginResponseDto actual = userLoginServiceImpl.loginUser(userLoginRequestDto);
		assertNotNull(actual);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testLoginForException() throws UserNotFoundException {
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setName("anisha");
		userLoginResponseDto.setStatusCode(MatrimonyContants.LOGIN_SUCCESS_CODE);
		

		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setEmailId("anish@gmail.com");
		userLoginRequestDto.setPassword("1234");
		
		UserDetail
		
		Mockito.when(userDetailRepository.findByEmailId(Mockito.toString()))
				.thenReturn(Optional.of(null));
		UserLoginResponseDto actual = userLoginServiceImpl.loginUser(userLoginRequestDto);
		assertNull(actual);
	}

	@Test
	public void testViewProfile() throws UserNotFoundException {
		List<UserViewProfileResponseDto> list = new ArrayList<>();

		UserDetail userDetails = new UserDetail();
		
		GenderDetail genderDetails=new GenderDetail();
		genderDetails.setGenderId(1L);
		genderDetails.setGender("annn");
		
		MothertongueDetail mothertongueDetail = new MothertongueDetail();
		mothertongueDetail.setMothertongueId(1L);
		mothertongueDetail.setMotherTongue("anisha");
		
		MaritalstatusDetail maritalstatusDetail = new MaritalstatusDetail();
		maritalstatusDetail.setMaritalstatusId(1L);
		maritalstatusDetail.setMaritalStatus("aaa");
		
		QualificationDetail qualificationDetail = new QualificationDetail();
		qualificationDetail.setQualificationId(1L);
		qualificationDetail.setQualificationName("aaaa");
		
		ReligionDetail religionDetail = new ReligionDetail();
		religionDetail.setReligionId(1L);
		religionDetail.setReligionName("aaaa");
		
		CityDetail cityDetail = new CityDetail();
		cityDetail.setCityId(1L);
		cityDetail.setCityName("aaaaa");
		
		StateDetail stateDetail = new StateDetail();
		stateDetail.setStateId(1L);
		stateDetail.setStateName("aaaa");
		
		userDetails.setAge(12);
		userDetails.setAnnualIncome(10000);
		userDetails.setEmailId("anish@gmail.com");
		userDetails.setGenderDetail(genderDetails);
        userDetails.setGothram("annn");
        userDetails.setHeight(150);
        userDetails.setMaritalstatusDetail(maritalstatusDetail);
        userDetails.setMobileNo(10000000L);
        userDetails.setMothertongueDetail(mothertongueDetail);
        userDetails.setName("anisha");
        userDetails.setOccupation("aaaa");
        userDetails.setPassword("aaaa");
        userDetails.setQualificationDetail(qualificationDetail);
        userDetails.setReligionDetail(religionDetail);
		userDetails.setStateDetail(stateDetail);
		userDetails.setUserId(1L);
		userDetails.setWorkLocation("aaaa");
		
		Mockito.when(userDetailRepository.findByUserId(1L)).thenReturn(Optional.of(userDetails));
		UserViewProfileResponseDto profileResponseDto = new UserViewProfileResponseDto();
		profileResponseDto.setAnnualIncome(userDetails.getAnnualIncome());
		profileResponseDto.setDate(userDetails.getDob());
		profileResponseDto.setEmailId(userDetails.getEmailId());
		profileResponseDto.setGender(userDetails.getGenderDetail().getGender());
		profileResponseDto.setGothram(userDetails.getGothram());
		profileResponseDto.setHeight(userDetails.getHeight());
		profileResponseDto.setMaritalStatus(userDetails.getMaritalstatusDetail().getMaritalStatus());
		profileResponseDto.setMobileNo(userDetails.getMobileNo());
		profileResponseDto.setMotherTongue(userDetails.getMothertongueDetail().getMotherTongue());
		profileResponseDto.setName(userDetails.getName());
		profileResponseDto.setOccupation(userDetails.getOccupation());
		profileResponseDto.setQualification(userDetails.getQualificationDetail().getQualificationName());
		profileResponseDto.setRelegion(userDetails.getReligionDetail().getReligionName());
		profileResponseDto.setWorkLocation(userDetails.getWorkLocation());
		
		
		list.add(profileResponseDto);
		
		
		List<UserViewProfileResponseDto> responseDto = userLoginServiceImpl.getByUserId(userDetails.getUserId());
        assertNotNull(responseDto);
	}


}
