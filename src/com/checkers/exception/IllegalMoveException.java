package com.checkers.exception;

public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = 4633503268337501015L;

	public IllegalMoveException(String message){
		super(message);
	}
	
}
