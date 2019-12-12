package com.scrotify.matrimony.service;

/**
 * The Class HospitalServiceImpl.
 * 
 * @author anisha
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scrotify.matrimony.Repository.StateDetailRepository;
import com.scrotify.matrimony.entity.StateDetail;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StateDetailServiceImpl implements StateDetailService {

	@Autowired
	StateDetailRepository stateDetailRepository;

	/**
	 * Gets the all States.
	 *
	 * @return
	 */

	@Override
	public List<StateDetail> getAllStates() {
		log.info("Enter StateServiceImpl:getAllStates()");
		List<StateDetail> stateDetails = stateDetailRepository.findAll();
		return stateDetails;
	}

}
