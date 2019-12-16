package com.scrotify.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.CityDetail;

@Repository
public interface CityRepository extends JpaRepository<CityDetail, Long> {

	CityDetail findByCityId(Long cityId);

}
