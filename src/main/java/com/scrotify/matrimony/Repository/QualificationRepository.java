package com.scrotify.matrimony.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.matrimony.entity.QualificationDetail;

@Repository
public interface QualificationRepository extends JpaRepository<QualificationDetail, Long>{

	QualificationDetail findByQualificationId(Long qualificationId);

}
