package com.scrotify.matrimony.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {

	private String message;
	private int statusCode;
	private String name;
}
