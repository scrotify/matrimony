package com.scrotify.matrimony.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the maritalStatus_details database table.
 * 
 */
@Entity
@Table(name = "maritalstatus_details")
//@NamedQuery(name = "MaritalstatusDetail.findAll", query = "SELECT m FROM MaritalstatusDetail m")
public class MaritalstatusDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MARITALSTATUS_DETAIL_MARITALSTATUSID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARITALSTATUS_DETAIL_MARITALSTATUSID_GENERATOR")
	@Column(name = "maritalstatus_id")
	private Long maritalstatusId;

	@Column(name = "marital_status")
	private String maritalStatus;

	// bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy = "maritalstatusDetail")
	private List<UserDetail> userDetails;

	public Long getMaritalstatusId() {
		return maritalstatusId;
	}

	public void setMaritalstatusId(Long maritalstatusId) {
		this.maritalstatusId = maritalstatusId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

}