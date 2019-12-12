package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the qualification_details database table.
 * 
 */
@Entity
@Table(name="qualification_details")
public class QualificationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUALIFICATION_DETAILS_QUALIFICATIONID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUALIFICATION_DETAILS_QUALIFICATIONID_GENERATOR")
	@Column(name="qualification_id")
	private Long qualificationId;

	@Column(name="qualification_name")
	private String qualificationName;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="qualificationDetail")
	private List<UserDetail> userDetails;

	public QualificationDetail() {
	}

	public Long getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return this.qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setQualificationDetail(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setQualificationDetail(null);

		return userDetail;
	}

}