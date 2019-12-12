package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the religion_details database table.
 * 
 */
@Entity
@Table(name="religion_details")
public class ReligionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RELIGION_DETAILS_RELIGIONID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RELIGION_DETAILS_RELIGIONID_GENERATOR")
	@Column(name="religion_id")
	private Long religionId;

	@Column(name="caste_id")
	private Long casteId;

	@Column(name="religion_name")
	private String religionName;

	//bi-directional many-to-one association to CasteDetail
	@OneToMany(mappedBy="religionDetail")
	private List<CasteDetail> casteDetails;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="religionDetail")
	private List<UserDetail> userDetails;

	public ReligionDetail() {
	}

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