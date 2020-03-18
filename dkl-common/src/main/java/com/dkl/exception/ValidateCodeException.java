package com.dkl.exception;

/**
 * @author: dalele
 * @date: 2020/3/19 01:56
 * @description:
 */
public class ValidateCodeException extends Exception{

	private static final long serialVersionUID = 7514854456967620043L;

	public ValidateCodeException(String message){
			super(message);
	}


}
