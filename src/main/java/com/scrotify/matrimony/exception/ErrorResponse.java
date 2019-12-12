package com.scrotify.matrimony.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
	private String message;
	private Integer statusCode;

}
