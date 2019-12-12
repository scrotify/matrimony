package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.GenderDetail;

@Repository
public interface GenderRepository extends JpaRepository<GenderDetail, Long>{

	GenderDetail findByGenderId(Long genderId);
	 

}
