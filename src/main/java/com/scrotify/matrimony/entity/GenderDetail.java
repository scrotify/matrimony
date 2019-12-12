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
//@NamedQuery(name="MaritalstatusDetail.findAll", query="SELECT m FROM MaritalstatusDetail m")
public class GenderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENDER_DETAIL_GENDERID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENDER_DETAIL_GENDERID_GENERATOR")
	@Column(name="maritalstatus_id")
	private Long cityId;

	private String gender;

	//bi-directional many-to-one association to UserDetail
		@OneToMany(mappedBy="genderDetail")
		private List<UserDetail> userDetails;

		public Long getCityId() {
			return cityId;
		}

		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public List<UserDetail> getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(List<UserDetail> userDetails) {
			this.userDetails = userDetails;
		}
		
	
	

}