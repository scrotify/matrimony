package com.scrotify.matrimony.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maritalStatus_details database table.
 * 
 */
@Entity
@Table(name="maritalstatus_details")
//@NamedQuery(name="MaritalstatusDetail.findAll", query="SELECT m FROM MaritalstatusDetail m")



 public class GenderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENDER_DETAILS_GENDERID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENDER_DETAILS_GENDERID_GENERATOR")
	@Column(name="gender_id")
	private Long genderId;

	private String gender;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="genderDetail")
	private List<UserDetail> userDetails;

	public GenderDetail() {
	}

	public Long getGenderId() {
		return this.genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}
}