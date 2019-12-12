package com.scrotify.matrimony.service;

import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;
import com.scrotify.matrimony.entity.CityDetail;
import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.exception.MatrimonyException;

import java.util.List;

public interface SearchService {

//    List<StateDetail> getAllStates();
//
//    List<CityDetail> getAllCities(Long stateId) throws MatrimonyException;
//
//    public List<CityDetail> getAllCities();

    public List<SearchResponseDto> searchUsersBy(SearchRequestDto searchRequestDto);

}
