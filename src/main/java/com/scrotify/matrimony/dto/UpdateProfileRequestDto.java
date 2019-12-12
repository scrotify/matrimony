package com.scrotify.matrimony.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProfileRequestDto {
	private Long userId;
	private String emailId;
	private Long mobileNo;
	private String password;

	private LocalDate dateOfBirth;
	private String name;
	private String occupation;

	private Double annualIncome;

}
