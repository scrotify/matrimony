package com.scrotify.matrimony.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class SearchResponseDto {

    private Long userId;

    private int age;

    private double annualIncome;

    private Date dob;

    private String emailId;

    private Long genderId;

    private String gothram;

    private int height;

    private BigInteger mobileNo;

    private Long maritalStatusId;

    private Long motherTongueId;

    private String name;

    private String occupation;

    private String password;

    private String workLocation;

    private Long qualificationId;

    private Long religionId;

    private Long stateId;

    private Long cityId;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    private Long mothertongueId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getGothram() {
        return gothram;
    }

    public void setGothram(String gothram) {
        this.gothram = gothram;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(Long maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public Long getMotherTongueId() {
        return motherTongueId;
    }

    public void setMotherTongueId(Long motherTongueId) {
        this.motherTongueId = motherTongueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Long getReligionId() {
        return religionId;
    }

    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getMothertongueId() {
        return mothertongueId;
    }

    public void setMothertongueId(Long mothertongueId) {
        this.mothertongueId = mothertongueId;
    }
}
