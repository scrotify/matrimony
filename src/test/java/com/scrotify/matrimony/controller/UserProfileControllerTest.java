package com.scrotify.matrimony.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.dto.ProfileUpdateResponseDto;
import com.scrotify.matrimony.dto.UpdateProfileRequestDto;
import com.scrotify.matrimony.service.UserProfileServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserProfileControllerTest {

	@InjectMocks
	UserProfileController userProfileController;
	
	@Mock
	UserProfileServiceImpl userProfileServiceImpl;
	ProfileInterestResponseDto profileInterestResponseDto=null;
	ProfileIntersetRequestDto profileIntersetRequestDto=null;
	UpdateProfileRequestDto updateProfileRequestDto=null;
	ProfileUpdateResponseDto updateProfileResponseDto=null;
	@Before
	public void setUp() {
		profileInterestResponseDto=new ProfileInterestResponseDto();
		profileInterestResponseDto.setMessage("interest has been sent");
		profileInterestResponseDto.setStatusCode(201);
		profileIntersetRequestDto=new ProfileIntersetRequestDto();
		profileIntersetRequestDto.setFromUserId(1L);
		profileIntersetRequestDto.setProfileInterestId(2L);
		updateProfileRequestDto=new UpdateProfileRequestDto();
		updateProfileRequestDto.setAnnualIncome(60000.44);
		updateProfileRequestDto.setDateOfBirth(LocalDate.parse("1992-03-21"));
		updateProfileRequestDto.setMobileNo(9916438755L);
		updateProfileRequestDto.setEmailId("nnaresh21@gmail.com");
		updateProfileRequestDto.setName("naresh");
		updateProfileRequestDto.setPassword("naresh@123");
		updateProfileRequestDto.setUserId(1L);
		updateProfileRequestDto.setOccupation("senior software engineer");
		updateProfileResponseDto=new ProfileUpdateResponseDto();
		updateProfileResponseDto.setMessage("your profile has been updated successfully");
		updateProfileResponseDto.setStatusCode(201);
	}
	@Test
	public void testsendInterestProfile() {
		
		Mockito.when(userProfileServiceImpl.sendInterestProfile(profileIntersetRequestDto)).thenReturn(profileInterestResponseDto);
		ProfileInterestResponseDto response=userProfileController.sendInterestProfile(profileIntersetRequestDto);
		
		assertNotNull(response);
	}
	@Test
	public void testUpdateProfile() {
		Mockito.when(userProfileServiceImpl.updateProfile(updateProfileRequestDto)).thenReturn(updateProfileResponseDto);
		ProfileUpdateResponseDto response=userProfileController.updateProfile(updateProfileRequestDto);
		assertNotNull(response);
	}
}
