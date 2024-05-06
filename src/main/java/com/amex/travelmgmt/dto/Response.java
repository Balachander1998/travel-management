package com.amex.travelmgmt.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Response {

	private Integer responseCode;
	private String responseMessage;
}
