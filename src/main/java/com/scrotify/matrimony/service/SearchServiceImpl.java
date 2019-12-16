package com.scrotify.matrimony.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.repository.UserRepository;

@Service
public class SearchServiceImpl implements SearchService {

	private static Logger logger = LogManager.getLogger(SearchServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<SearchResponseDto> searchUsersBy(SearchRequestDto searchRequestDto) {
		logger.info("Search service");
		List<UserDetail> userDetails = userRepository.findUsers(searchRequestDto.getAge(),
				searchRequestDto.getGenderId(), searchRequestDto.getStateId(),
				searchRequestDto.getReligionId());

		List<SearchResponseDto> searchResponseDtos = new ArrayList<>();
		searchResponseDtos = userDetails.stream().map(userEntity -> {
			SearchResponseDto searchResponseDto = new SearchResponseDto();
			BeanUtils.copyProperties(userEntity, searchResponseDto);
			searchResponseDto.setStateId(userEntity.getStateDetail().getStateId());
			searchResponseDto.setGenderId(userEntity.getGenderDetail().getGenderId());
			searchResponseDto.setReligionId(userEntity.getReligionDetail().getReligionId());
			return searchResponseDto;
		}).collect(Collectors.toList());

		logger.info("Search service Size:" + searchResponseDtos.size());
		return searchResponseDtos;
	}
}
