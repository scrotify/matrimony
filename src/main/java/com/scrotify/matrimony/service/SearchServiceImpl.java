package com.scrotify.matrimony.service;

import com.scrotify.matrimony.Repository.*;
import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;
import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.MatrimonyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private static Logger logger = LogManager.getLogger(SearchServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
   /* @Autowired
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
    }*/

    @Override
    public List<SearchResponseDto> searchUsersBy(SearchRequestDto searchRequestDto) {
        List<UserDetail> userDetails = userRepository.findUsers(
                searchRequestDto.getAge(), searchRequestDto.getGenderId(),
                searchRequestDto.getStateId(),
                //searchRequestDto.getCityId(),
                searchRequestDto.getReligionId()
        );

        List<SearchResponseDto> searchResponseDtos = new ArrayList<>();
        searchResponseDtos = userDetails.stream().map(userEntity -> {
            SearchResponseDto searchResponseDto = new SearchResponseDto();
            BeanUtils.copyProperties(userEntity, searchResponseDto);
            searchResponseDto.setCityId(userEntity.getStateDetail().getCityDetails().get(0).getCityId());
            searchResponseDto.setStateId(userEntity.getStateDetail().getStateId());
            searchResponseDto.setGenderId(userEntity.getGenderDetail().getGenderId());
            searchResponseDto.setReligionId(userEntity.getReligionDetail().getReligionId());
            return searchResponseDto;
        }).collect(Collectors.toList());

        return  searchResponseDtos;
    }
}
