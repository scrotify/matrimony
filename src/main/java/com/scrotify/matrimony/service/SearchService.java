package com.scrotify.matrimony.service;

import java.util.List;

import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;

public interface SearchService {

	public List<SearchResponseDto> searchUsersBy(SearchRequestDto searchRequestDto);

}
