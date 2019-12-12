package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.MothertongueDetail;

@Repository
public interface MothertongueRepository extends JpaRepository<MothertongueDetail, Long>{

	MothertongueDetail findByMothertongueId(Long mothertongueId);

}
