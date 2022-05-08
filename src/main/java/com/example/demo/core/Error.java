package com.example.demo.core;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

public Error(int code, String massege, List<String> params) {
	this.code = code ;
	this.massege =  massege ;
	this.params = params ;
	}
private Integer code ;
private String massege ;
private List<String> params ;

public Error(int code, String massege, String... params) {
	this.code = code ;
	this.massege =  massege ;
	this.params = Arrays.asList(params)  ;
	}

}
