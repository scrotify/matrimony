package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.StateDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityDetail, Long> {

}
