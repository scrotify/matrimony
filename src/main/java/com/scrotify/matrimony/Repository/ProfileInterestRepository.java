package com.scrotify.matrimony.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.ProfileInterest;

@Repository
public interface ProfileInterestRepository extends JpaRepository<ProfileInterest, Long> {
	
	Optional<ProfileInterest> findByFromUserId(Long fromUserId);
	Optional<ProfileInterest> findByInterestUserId(Long interestUserId);


}
