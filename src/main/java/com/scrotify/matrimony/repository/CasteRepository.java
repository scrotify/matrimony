package com.scrotify.matrimony.repository;

import com.scrotify.matrimony.entity.CasteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasteRepository extends JpaRepository<CasteDetail, Long> {

}
