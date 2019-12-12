package com.scrotify.matrimony.service;

import com.scrotify.matrimony.Repository.*;
import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.MatrimonyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    private static Logger logger = LogManager.getLogger(SearchServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ReligionRepository religionRepository;

    @Autowired
    private CasteRepository casteRepository;

    @Override
    public List<StateDetail> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<CityDetail> getAllCities() {
        return cityRepository.findAll();
    }
    @Override
    public List<CityDetail> getAllCities(Long stateId) throws MatrimonyException {
        logger.info("Get all cities");
        Optional<StateDetail> stateDetailOptional = stateRepository.findById(stateId);
        if (stateDetailOptional.isPresent()) {
            return stateDetailOptional.get().getCityDetails();
        } else {
            logger.info("No cities found for the state " + stateId);
            throw new MatrimonyException("City not found Exception");
        }
    }

    @Override
    public List<UserDetail> searchUsersBy(UserDetail userDetail) {
        //userRepository
        return null;
    }
}
