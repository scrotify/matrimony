package com.scrotify.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.StateDetail;

@Repository
public interface StateRepository extends JpaRepository<StateDetail, Long> {

	StateDetail findByStateId(Long stateId);

}
