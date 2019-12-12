package com.scrotify.matrimony.Repository;

import com.scrotify.matrimony.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserDetail, Long> {


}
