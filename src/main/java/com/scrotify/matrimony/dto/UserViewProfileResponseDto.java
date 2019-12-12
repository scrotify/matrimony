package com.scrotify.matrimony.dto;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewProfileResponseDto {

	private Long mobileNo;
	private String name;
	private LocalDate date;
	private String gender;
	private String relegion;
	private String motherTongue;
	private String emailId;
	private String caste;
	private String gothram;
	private String maritalStatus;
	private float height;
	private String qualification;
	private String occupation;
	private double annualIncome;
	private String workLocation;
	private String	state;
	private String city;
	}

