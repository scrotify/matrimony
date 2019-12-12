package com.scrotify.matrimony.controller;

import java.util.List;

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

import com.scrotify.matrimony.dto.UserLoginRequestDto;
import com.scrotify.matrimony.dto.UserLoginResponseDto;
import com.scrotify.matrimony.dto.UserViewProfileResponseDto;
import com.scrotify.matrimony.exception.UserNotFoundException;
import com.scrotify.matrimony.service.UserLoginService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserDetailController {
  
	@Autowired
	UserLoginService userLoginservice;

@PostMapping("")
public ResponseEntity<UserLoginResponseDto> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) throws UserNotFoundException {
	return new ResponseEntity<UserLoginResponseDto>(userLoginservice.loginUser(userLoginRequestDto), HttpStatus.OK);
}

@GetMapping("/{userId}")
public ResponseEntity<List<UserViewProfileResponseDto>> getByApproverId(@PathVariable Long userId) throws UserNotFoundException {
	return new ResponseEntity<>(userLoginservice.getByUserId(userId), HttpStatus.OK);
}
}