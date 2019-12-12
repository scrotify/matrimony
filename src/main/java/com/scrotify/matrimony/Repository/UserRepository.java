package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long>{

}
