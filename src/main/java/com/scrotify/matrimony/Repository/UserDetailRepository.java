package com.scrotify.matrimony.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{


	Optional<UserDetail> findUserDetailByEmailId(String emailId);
	Optional<UserDetail> findByEmailId(String emailId);
	Optional<UserDetail> findByUserId(Long userId);


}
