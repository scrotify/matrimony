package com.scrotify.matrimony.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
//@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_DETAILS_USERID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_DETAILS_USERID_GENERATOR")
	@Column(name="user_id")
	private Long userId;

	private int age;

	@Column(name="annual_income")
	private double annualIncome;

	@Column(name="dob")
	private LocalDate dob;

	@Column(name="email_id")
	private String emailId;

	private String gothram;

	private int height;
	@Column(name="mobile_no")
	private Long mobileNo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maritalstatus_id")
	private MaritalstatusDetail maritalStatusDetail;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mothertongue_id")
	private MothertongueDetail motherTongueDetail;

	private String name;

	private String occupation;

	private String password;

	@Column(name="work_location")
	private String workLocation;

	//bi-directional many-to-one association to QualificationDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="qualification_id")
	private QualificationDetail qualificationDetail;

	//bi-directional many-to-one association to ReligionDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="religion_id")
	private ReligionDetail religionDetail;

	//bi-directional many-to-one association to StateDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id")
	private StateDetail stateDetail;



	//bi-directional many-to-one association to MaritalstatusDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marital_status_id")
	private MaritalstatusDetail maritalstatusDetail;

	//bi-directional many-to-one association to MothertongueDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mother_tongue_id")
	private MothertongueDetail mothertongueDetail;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gender_id")
	private GenderDetail genderDetail;


	public GenderDetail getGenderDetail() {
		return genderDetail;
	}

	public void setGenderDetail(GenderDetail genderDetail) {
		this.genderDetail = genderDetail;
	}


	public UserDetail() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public MaritalstatusDetail getMaritalStatusDetail() {
		return maritalStatusDetail;
	}

	public void setMaritalStatusDetail(MaritalstatusDetail maritalStatusDetail) {
		this.maritalStatusDetail = maritalStatusDetail;
	}

	public MothertongueDetail getMotherTongueDetail() {
		return motherTongueDetail;
	}

	public void setMotherTongueDetail(MothertongueDetail motherTongueDetail) {
		this.motherTongueDetail = motherTongueDetail;
	}


	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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


	public void setQualificationDetail(QualificationDetail qualificationDetail) {
		this.qualificationDetail = qualificationDetail;
	}

	public ReligionDetail getReligionDetail() {
		return religionDetail;
	}

	public void setReligionDetail(ReligionDetail religionDetail) {
		this.religionDetail = religionDetail;
	}

	public StateDetail getStateDetail() {
		return stateDetail;
	}

	public void setStateDetail(StateDetail stateDetail) {
		this.stateDetail = stateDetail;
	}

	public MaritalstatusDetail getMaritalstatusDetail() {
		return this.maritalstatusDetail;
	}

	public void setMaritalstatusDetail(MaritalstatusDetail maritalstatusDetail) {
		this.maritalstatusDetail = maritalstatusDetail;
	}

	public MothertongueDetail getMothertongueDetail() {
		return this.mothertongueDetail;
	}

	public void setMothertongueDetail(MothertongueDetail mothertongueDetail) {
		this.mothertongueDetail = mothertongueDetail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public QualificationDetail getQualificationDetail() {
		return qualificationDetail;
	}
	

}