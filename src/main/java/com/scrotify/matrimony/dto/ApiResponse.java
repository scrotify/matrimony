package com.scrotify.matrimony.dto;


import com.scrotify.matrimony.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private int statusCode;

    List<SearchResponseDto> searchResponseDtoList;

    public List<SearchResponseDto> getSearchResponseDtoList() {
        return searchResponseDtoList;
    }

    public void setSearchResponseDtoList(List<SearchResponseDto> searchResponseDtoList) {
        this.searchResponseDtoList = searchResponseDtoList;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}



