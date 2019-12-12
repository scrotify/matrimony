package com.scrotify.matrimony.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfileInterestResponseDto {
	
	
	private Long interestMobileNo;
	private LocalDate date;
	private String interestStatus;

}
