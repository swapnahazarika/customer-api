package io.java.springbootapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPasswordException extends Exception  {
	
	public InvalidPasswordException(){  
	 
	}
	public InvalidPasswordException(String s){  
		super(s);  
	}

}
