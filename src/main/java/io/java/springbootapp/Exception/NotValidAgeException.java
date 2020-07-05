package io.java.springbootapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidAgeException extends Exception {
	public NotValidAgeException(){  
		  
	}
	
	public NotValidAgeException(String s){  
		super(s);  
	}

}
