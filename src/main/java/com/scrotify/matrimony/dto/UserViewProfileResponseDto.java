package com.scrotify.matrimony.dto;


import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewProfileResponseDto {

	private BigInteger mobileNo;
	private String name;
	private Date date;
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

