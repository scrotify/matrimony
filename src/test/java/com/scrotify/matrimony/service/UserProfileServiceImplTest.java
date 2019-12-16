package com.scrotify.matrimony.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

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
import com.scrotify.matrimony.entity.ProfileInterest;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.repository.ProfileInterestRepository;
import com.scrotify.matrimony.repository.UserDetailRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserProfileServiceImplTest {
	@InjectMocks
	UserProfileServiceImpl userProfileServiceImpl;
	
	@Mock
	UserDetailRepository userDetailRepository;
	
	@Mock
	ProfileInterestRepository profileInterestRepository;
	
	ProfileInterestResponseDto profileInterestResponseDto=null;
	ProfileIntersetRequestDto profileIntersetRequestDto=null;
	ProfileInterest profileInterest;
	ProfileUpdateResponseDto profileUpdateResponseDto=null;
	UpdateProfileRequestDto updateProfileRequestDto=null;
	UserDetail userdetail=null;
	@Before
	public void setUp() {
		profileInterestResponseDto=new ProfileInterestResponseDto();
		
		profileInterestResponseDto.setMessage("interest has been sent");
		profileInterestResponseDto.setStatusCode(201);
		
		profileIntersetRequestDto=new ProfileIntersetRequestDto();
		profileIntersetRequestDto.setFromUserId(1L);
		profileIntersetRequestDto.setProfileInterestId(2L);
		
		profileInterest=new ProfileInterest();
		profileInterest.setFromUserId(1L);
		profileInterest.setInterestId(2L);
		profileInterest.setDate(LocalDate.parse("2019-03-21"));
		profileInterest.setInterestUserId(3L);
		userdetail=new UserDetail();
		userdetail.setUserId(1L);
		userdetail.setAnnualIncome(60000.44);
		userdetail.setDob(LocalDate.parse("1991-03-21"));
		userdetail.setMobileNo(9916438755L);
		userdetail.setEmailId("mahesh@gmail.com");
		userdetail.setName("mahesh");
		userdetail.setPassword("mahesh@123");
		userdetail.setUserId(1L);
		userdetail.setOccupation("software engineer");
		profileUpdateResponseDto=new ProfileUpdateResponseDto();
		profileUpdateResponseDto.setMessage("your profile has been updated successfully");
		profileUpdateResponseDto.setStatusCode(201);
		updateProfileRequestDto=new UpdateProfileRequestDto();
		updateProfileRequestDto.setAnnualIncome(60000.44);
		updateProfileRequestDto.setDateOfBirth(LocalDate.parse("1992-03-21"));
		updateProfileRequestDto.setMobileNo(9916438755L);
		updateProfileRequestDto.setEmailId("nnaresh21@gmail.com");
		updateProfileRequestDto.setName("naresh");
		updateProfileRequestDto.setPassword("naresh@123");
		updateProfileRequestDto.setUserId(1L);
		updateProfileRequestDto.setOccupation("senior software engineer");
		}
	@Test
	public void testSendInterestProfile() {
		
	Mockito.when(userDetailRepository.findByUserId(1L)).thenReturn(Optional.of(userdetail));
	Mockito.when(profileInterestRepository.findByInterestUserId(profileInterest.getInterestId())).thenReturn(Optional.of(profileInterest));
	ProfileInterestResponseDto response=userProfileServiceImpl.sendInterestProfile(profileIntersetRequestDto);
	assertNotNull(response);
	}
	@Test
	public void testUpdateProfile() {
		Mockito.when(userDetailRepository.findByUserId(1L)).thenReturn(Optional.of(userdetail));
		Mockito.when(userDetailRepository.save(userdetail)).thenReturn(userdetail);
		ProfileUpdateResponseDto response=userProfileServiceImpl.updateProfile(updateProfileRequestDto);
		assertNotNull(response);
	}
}
