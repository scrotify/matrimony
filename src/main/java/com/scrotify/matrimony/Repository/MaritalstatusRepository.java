package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.MaritalstatusDetail;

@Repository
public interface MaritalstatusRepository extends JpaRepository<MaritalstatusDetail, Long>{

	MaritalstatusDetail findByMaritalstatusId(Long maritalStatusId);

}
