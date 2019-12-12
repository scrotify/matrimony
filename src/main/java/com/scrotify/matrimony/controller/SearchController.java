package com.scrotify.matrimony.controller;

import com.scrotify.matrimony.dto.ApiResponse;
import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;
import com.scrotify.matrimony.entity.UserDetail;
import com.scrotify.matrimony.service.SearchServiceImpl;
import com.scrotify.matrimony.util.MatrimonyContants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    private static Logger logger = LogManager.getLogger(SearchController.class);

    @Autowired
    private SearchServiceImpl searchService;

    @GetMapping
    public ResponseEntity<ApiResponse> search(@RequestParam Optional<String>  age, @RequestParam Optional<String>  cityId,
    		@RequestParam Optional<String>  genderId,
            @RequestParam Optional<String>  religionId,
            @RequestParam Optional<String>  stateId) {
        logger.info("Entering into search ");
        SearchRequestDto searchRequestDto = new SearchRequestDto();
        searchRequestDto.setReligionId(Long.parseLong(religionId.orElse("1")));
        searchRequestDto.setGenderId(Long.parseLong(genderId.orElse("1")));
        searchRequestDto.setStateId(Long.parseLong(stateId.orElse("1")));
        searchRequestDto.setCityId(Long.parseLong(cityId.orElse("1")));
        ApiResponse response = new ApiResponse();
        List<SearchResponseDto> userDetails = searchService.searchUsersBy(searchRequestDto);
        response.setSearchResponseDtoList(userDetails);
        response.setMessage(MatrimonyContants.SEARCH_SUCCESS);
        logger.info("Ending of search ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
