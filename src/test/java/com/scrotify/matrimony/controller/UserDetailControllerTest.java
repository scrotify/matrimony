package com.scrotify.matrimony.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.UserNotEligibleException;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.service.UserDetailService;
import com.scrotify.matrimony.service.UserLoginServiceImpl;
import com.scrotify.matrimony.util.MatrimonyContants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDetailControllerTest {

	@InjectMocks
	UserDetailController userDetailController;

	@Mock
	UserLoginServiceImpl userLoginServiceImpl;

	@Mock
	UserDetailService userDetailService;

	@Test
	public void testNewUser() throws UserNotEligibleException {
		UserRequestDto userRequestDto = null;
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setMessage(MatrimonyContants.REGISTRATION_SUCCESS_MESSAGE);
		userResponseDto.setStatusCode(MatrimonyContants.REGISTRATION_SUCCESS_CODE);
		Mockito.when(userDetailService.newUser(userRequestDto)).thenReturn(userResponseDto);
		ResponseEntity<UserResponseDto> responseDto = userDetailController.newUser(userRequestDto);
		assertNotNull(responseDto);
	}

	@Test
	public void testLogin() throws UserNotFoundException {
		UserLoginRequestDto userLoginRequestDto = null;
		UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setMessage(MatrimonyContants.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setName("anisha");
		userLoginResponseDto.setStatusCode(MatrimonyContants.LOGIN_SUCCESS_CODE);
		Mockito.when(userLoginServiceImpl.loginUser(Mockito.any())).thenReturn(userLoginResponseDto);
		ResponseEntity<UserLoginResponseDto> responseDto = userDetailController.loginUser(userLoginRequestDto);
		Assert.assertNotNull(responseDto);
	}

	@Test
	public void testViewProfile() throws UserNotFoundException {
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(1L);
		UserViewProfileResponseDto userViewProfileResponseDto = new UserViewProfileResponseDto();
		userViewProfileResponseDto.setAnnualIncome(10000);
		userViewProfileResponseDto.setName("anisha");
		userViewProfileResponseDto.setCity("coimbatore");
		userViewProfileResponseDto.setEmailId("anisgha@gmail.com");
		userViewProfileResponseDto.setGender("female");
		userViewProfileResponseDto.setGothram("adg");
		userViewProfileResponseDto.setHeight(190.55F);
		List<UserViewProfileResponseDto> list = new ArrayList<UserViewProfileResponseDto>();
		list.add(userViewProfileResponseDto);
		Mockito.when(userLoginServiceImpl.getByUserId(Mockito.any())).thenReturn(list);
		ResponseEntity<List<UserViewProfileResponseDto>> responseDto = userDetailController
				.getByUserId(userDetail.getUserId());
		Assert.assertNotNull(responseDto);
	}

}
