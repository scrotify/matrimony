package com.scrotify.matrimony.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the religion_details database table.
 * 
 */
@Entity
@Table(name = "religion_details")
public class ReligionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RELIGION_DETAILS_RELIGIONID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELIGION_DETAILS_RELIGIONID_GENERATOR")
	@Column(name = "religion_id")
	private Long religionId;

	@Column(name = "caste_id")
	private Long casteId;

	@Column(name = "religion_name")
	private String religionName;

	@OneToMany(mappedBy = "religionDetail")
	private List<CasteDetail> casteDetails;

	@OneToMany(mappedBy = "religionDetail")
	private List<UserDetail> userDetails;

	public Long getReligionId() {
		return this.religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public String getReligionName() {
		return this.religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

	public List<CasteDetail> getCasteDetails() {
		return this.casteDetails;
	}

	public void setCasteDetails(List<CasteDetail> casteDetails) {
		this.casteDetails = casteDetails;
	}

	public CasteDetail addCasteDetail(CasteDetail casteDetail) {
		getCasteDetails().add(casteDetail);
		casteDetail.setReligionDetail(this);

		return casteDetail;
	}

	public CasteDetail removeCasteDetail(CasteDetail casteDetail) {
		getCasteDetails().remove(casteDetail);
		casteDetail.setReligionDetail(null);

		return casteDetail;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setReligionDetail(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setReligionDetail(null);

		return userDetail;
	}

}