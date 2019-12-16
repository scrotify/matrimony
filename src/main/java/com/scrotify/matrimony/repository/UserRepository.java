package com.scrotify.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {

	/*
	 * List<UserDetail>
	 * findByAgeAndGenderDetailGenderIdAndStateDetailstateIdAndStateDetailCityDetailCityIdAndReligionDetailReligionId(
	 */

	@Query("select ud from UserDetail ud where ud.age =:age and ud.genderDetail.genderId=:genderId "
			+ " or ud.stateDetail.stateId= :stateId or ud.religionDetail.religionId =:religionId")
	List<UserDetail> findUsers(@Param("age") Integer age, @Param("genderId") Long genderId,
			@Param("stateId") Long stateId,
			@Param("religionId") Long religionId);
}
