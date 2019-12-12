package com.scrotify.matrimony.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {

	private String emailId;
	private String password;
	private String message;
	private int statusCode;
	private String name;
}
