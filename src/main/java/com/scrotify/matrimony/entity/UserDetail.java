package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
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

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="email_id")
	private String emailId;

	private String gothram;

	private int height;

	@Column(name="mobile_no")
	private BigInteger mobileNo;

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

	//bi-directional many-to-one association to GenderDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gender_id")
	private GenderDetail genderDetail;

	//bi-directional many-to-one association to MaritalstatusDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marital_status_id")
	private MaritalstatusDetail maritalstatusDetail;

	//bi-directional many-to-one association to MothertongueDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mother_tongue_id")
	private MothertongueDetail mothertongueDetail;

	public UserDetail() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGothram() {
		return this.gothram;
	}

	public void setGothram(String gothram) {
		this.gothram = gothram;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BigInteger getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkLocation() {
		return this.workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public QualificationDetail getQualificationDetail() {
		return this.qualificationDetail;
	}

	public void setQualificationDetail(QualificationDetail qualificationDetail) {
		this.qualificationDetail = qualificationDetail;
	}

	public ReligionDetail getReligionDetail() {
		return this.religionDetail;
	}

	public void setReligionDetail(ReligionDetail religionDetail) {
		this.religionDetail = religionDetail;
	}

	public StateDetail getStateDetail() {
		return this.stateDetail;
	}

	public void setStateDetail(StateDetail stateDetail) {
		this.stateDetail = stateDetail;
	}

	public GenderDetail getGenderDetail() {
		return this.genderDetail;
	}

	public void setGenderDetail(GenderDetail genderDetail) {
		this.genderDetail = genderDetail;
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

}