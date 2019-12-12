package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



/**
 * The persistent class for the maritalStatus_details database table.
 * 
 */
@Entity
@Table(name="mothertongue_details")
public class MothertongueDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOTHERTONGUE_DETAILS_MOTHERTONGUEID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTHERTONGUE_DETAILS_MOTHERTONGUEID_GENERATOR")
	@Column(name="mothertongue_id")
	private Long mothertongueId;

	@Column(name="mother_tongue")
	private String motherTongue;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="mothertongueDetail")
	private List<UserDetail> userDetails;

	public MothertongueDetail() {
	}

	public Long getMothertongueId() {
		return this.mothertongueId;
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
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}


}