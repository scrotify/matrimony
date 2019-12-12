package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateDetail, Long> {

	StateDetail findByStateId(Long stateId);

}
