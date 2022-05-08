package com.example.demo.enums;

public enum DashboardErrorCode {
SUCCESS (0,"status.success") ,
	FALIURE (1,"status.failure"),
	
	OBJECT_NOT_FOUND (1," SORRY YOUR PLOT ID NOT FOUND !");



	
	private int code ;
	private String key ;
DashboardErrorCode(int code, String key) {
	this.code = code ;
	this.key = key ;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}

}
