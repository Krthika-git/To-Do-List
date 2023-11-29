package com.bourntec.todolist.userapplication.exception;

import lombok.Getter;

@Getter

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(String message){
        super(message);
    }
	public RecordNotFoundException(){
        super();
    }
	

}
