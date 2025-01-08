package com.advertise.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST )
public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	 public EntityNotFoundException(String message) {
	        this.message=message;
	    }
	 
	 public EntityNotFoundException()
	 {
		 this.message="";
	 }

	@Override
	public String toString() {
		return  message;
	}
	
}
