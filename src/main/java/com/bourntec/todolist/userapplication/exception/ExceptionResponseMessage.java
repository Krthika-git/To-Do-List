package com.bourntec.todolist.userapplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionResponseMessage {
	private LocalDateTime timeStamp;
	private int status;
	private HttpStatus httpStatus;
	private String responseMessage;
	private String requestUrl;

}
