package com.utils;

public class AppException extends Exception{

	private int exceptionCode;//�쳣���
	private String message;//�쳣��Ϣ
	
	//���췽��
	public AppException(String message){
		this.message = message;
	}
	
	//���췽��
	public AppException(int exceptionCode, String message) {
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
	
	//��ȡ�쳣���
	public int getExceptionCode(){
		return exceptionCode;
	}
	
	//��ȡ�쳣��Ϣ
	public String getMessage(){
		String detilMessage = "Detail message:" + exceptionCode + "" + message;
		return detilMessage;
	}
}
