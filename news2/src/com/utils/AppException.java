package com.utils;

public class AppException extends Exception{

	private int exceptionCode;//异常编号
	private String message;//异常消息
	
	//构造方法
	public AppException(String message){
		this.message = message;
	}
	
	//构造方法
	public AppException(int exceptionCode, String message) {
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
	
	//获取异常编号
	public int getExceptionCode(){
		return exceptionCode;
	}
	
	//获取异常消息
	public String getMessage(){
		String detilMessage = "Detail message:" + exceptionCode + "" + message;
		return detilMessage;
	}
}
