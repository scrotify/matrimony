package com.scrotify.matrimony.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the maritalStatus_details database table.
 * 
 */
@Entity
@Table(name="maritalstatus_details")
@NamedQuery(name="MaritalstatusDetail.findAll", query="SELECT m FROM MaritalstatusDetail m")
public class MothertongueDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOTHERTONGUE_DETAIL_MOTHERTONGUEID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTHERTONGUE_DETAIL_MOTHERTONGUEID_GENERATOR")
	@Column(name="mothertongue_id")
	private Long mothertongueId;

	@Column(name="mother_tongue")
	private String motherTongue;
	
	//bi-directional many-to-one association to UserDetail
		@OneToMany(mappedBy="mothertongueDetail")
		private List<UserDetail> userDetails;

	public Long getMothertongueId() {
		return mothertongueId;
	}

	public void setMothertongueId(Long mothertongueId) {
		this.mothertongueId = mothertongueId;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public List<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}


	
	

}