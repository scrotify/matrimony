package com.scrotify.matrimony.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scrotify.matrimony.dto.UserRequestDto;
import com.scrotify.matrimony.dto.UserResponseDto;
import com.scrotify.matrimony.exception.UserNotEligibleException;
import com.scrotify.matrimony.service.UserDetailService;
import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.service.UserLoginService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserDetailController {

	private static Logger logger = LogManager.getLogger(UserDetailController.class);

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	UserLoginService userLoginservice;

	@PostMapping
	public ResponseEntity<UserResponseDto> newUser(@RequestBody UserRequestDto userRequestDto)
			throws UserNotEligibleException {
		logger.info("Entering into new user for registration method");
		return new ResponseEntity<>(userDetailService.newUser(userRequestDto), HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDto> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto)
			throws UserNotFoundException {
		logger.info("Entering into login user method");
		return new ResponseEntity<>(userLoginservice.loginUser(userLoginRequestDto), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<UserViewProfileResponseDto>> getByUserId(@PathVariable Long userId)
			throws UserNotFoundException {
		logger.info("Entering into get the list of users by userId method");
		return new ResponseEntity<>(userLoginservice.getByUserId(userId), HttpStatus.OK);
	}

}
