package com.scrotify.matrimony.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
	
					
	private String name;			
	private LocalDate dob;	
	private Long genderId;				
	private Long religionId;		
	private Long motherTongueId;
	private Long casteId;
	private Long cityId;
	private String email;		
	private String password;		
	private String gothram;			
	private Long maritalStatusId;			
	private Integer height;			
	private Long qualificationId;			
	private String occupation;				
	private Double annualIncome;				
	private String workLocation;				
	private Long stateId;
	private Long mobileNo;				

}
