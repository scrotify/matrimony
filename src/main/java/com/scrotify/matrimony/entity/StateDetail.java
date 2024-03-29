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
 * The persistent class for the state_details database table.
 * 
 */
@Entity
@Table(name = "state_details")
public class StateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "STATE_DETAILS_STATEID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_DETAILS_STATEID_GENERATOR")
	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "state_name")
	private String stateName;

	@OneToMany(mappedBy = "stateDetail")
	private List<CityDetail> cityDetails;

	@OneToMany(mappedBy = "stateDetail")
	private List<UserDetail> userDetails;

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<CityDetail> getCityDetails() {
		return this.cityDetails;
	}

	public void setCityDetails(List<CityDetail> cityDetails) {
		this.cityDetails = cityDetails;
	}

	public CityDetail addCityDetail(CityDetail cityDetail) {
		getCityDetails().add(cityDetail);
		cityDetail.setStateDetail(this);

		return cityDetail;
	}

	public CityDetail removeCityDetail(CityDetail cityDetail) {
		getCityDetails().remove(cityDetail);
		cityDetail.setStateDetail(null);

		return cityDetail;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setStateDetail(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setStateDetail(null);

		return userDetail;
	}

}