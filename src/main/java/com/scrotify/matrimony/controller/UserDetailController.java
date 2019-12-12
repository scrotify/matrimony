package com.scrotify.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.exception.UserNotEligibleException;
import com.scrotify.matrimony.service.UserDetailService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserDetailController {
	
	@Autowired
	UserDetailService userDetailService;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> newUser(@RequestBody UserRequestDto userRequestDto) throws UserNotEligibleException {
		return new ResponseEntity<>(userDetailService.newUser(userRequestDto), HttpStatus.OK);
		
	}

}
