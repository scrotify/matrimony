package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.UserDetail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {

    /*List<UserDetail>  findByAgeAndGenderDetailGenderIdAndStateDetailstateIdAndStateDetailCityDetailCityIdAndReligionDetailReligionId(
            int age, Long genderId,  Long stateId, Long cityId, Long religionId);*/

    @Query("select ud from UserDetail ud where ud.age =:age and ud.genderDetail.genderId=:genderId " +
            " and ud.stateDetail.stateId= :stateId and ud.religionDetail.religionId =:religionId")
    List<UserDetail>  findUsers(
            @Param("age") Integer age, @Param("genderId") Long genderId,
            @Param("stateId") Long stateId,
          //  @Param("cityId") Long cityId,
            //and ud.stateDetail.cityDetails.cityId =:cityId
            @Param("religionId") Long religionId);
}
