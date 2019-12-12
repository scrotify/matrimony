package com.scrotify.matrimony.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class SearchResponseDto {

    private String userId;

    private double annualIncome;

    private Date dob;

    private String emailId;

    private String gender;

    private String gothram;

    private int height;

    private String maritalStatus;

    private BigInteger mobileNo;

    private String motherTongue;

    private String name;

    private String occupation;

    private int age;
}
