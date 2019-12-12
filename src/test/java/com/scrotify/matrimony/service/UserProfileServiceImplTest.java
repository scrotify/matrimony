package com.scrotify.matrimony.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.base.Optional;
import com.scrotify.matrimony.Repository.ProfileInterestRepository;
import com.scrotify.matrimony.Repository.UserDetailRepository;
import com.scrotify.matrimony.dto.ProfileInterestResponseDto;
import com.scrotify.matrimony.dto.ProfileIntersetRequestDto;
import com.scrotify.matrimony.entity.ProfileInterest;
import com.scrotify.matrimony.entity.UserDetail;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserProfileServiceImplTest {
	@InjectMocks
	UserProfileServiceImpl userProfileServiceImplTest;
	
	@Mock
	UserDetailRepository userDetailRepository;
	
	@Mock
	ProfileInterestRepository profileInterestRepository;
	
	ProfileInterestResponseDto profileInterestResponseDto=null;
	ProfileIntersetRequestDto profileIntersetRequestDto=null;
	ProfileInterest profileInterest;
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
		//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("21-03-2109");
		
		//profileInterest.setDate(LocalDate.parse(2019-03-21));
		profileInterest.setInterestUserId(3L);
		userdetail=new UserDetail();
		userdetail.setUserId(1L);
			
		}
	@Test
	public void testSendInterestProfile() {
		
	//Mockito.when(userDetailRepository.findByUserId(1L)).thenReturn(profileInterestResponseDto);
	}
}
