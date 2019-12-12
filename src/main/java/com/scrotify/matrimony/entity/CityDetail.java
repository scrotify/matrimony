package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the city_details database table.
 * 
 */
@Entity
@Table(name="city_details")
public class CityDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CITY_DETAILS_CITYID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CITY_DETAILS_CITYID_GENERATOR")
	@Column(name="city_id")
	private Long cityId;

	@Column(name="city_name")
	private String cityName;

	//bi-directional many-to-one association to StateDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id")
	private StateDetail stateDetail;

	public CityDetail() {
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateDetail getStateDetail() {
		return this.stateDetail;
	}

	public void setStateDetail(StateDetail stateDetail) {
		this.stateDetail = stateDetail;
	}

}