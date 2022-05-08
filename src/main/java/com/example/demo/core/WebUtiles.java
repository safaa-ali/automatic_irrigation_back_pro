package com.example.demo.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.enums.DashboardErrorCode;

public class WebUtiles {
public static ResponseEntity<List<Error>> prepareErrorResponse(HttpStatus status , DashboardErrorCode error , String... params){
	List<Error> errors = new ArrayList<Error>();
	if(params !=null && params.length > 0) {
		errors.add(new Error(error.getCode(), error.getKey(),params));
	}else {
		errors.add(new Error(error.getCode(), error.getKey()));

	}
	return new ResponseEntity<List<Error>>(errors,status) ;
}
}
