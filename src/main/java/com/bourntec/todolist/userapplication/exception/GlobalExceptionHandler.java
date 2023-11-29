package com.bourntec.todolist.userapplication.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ RecordNotFoundException.class })
	public ResponseEntity<ExceptionResponseMessage> handleRecordNotFoundException(Exception exception,
			final HttpServletRequest httpServletRequest) {
		ExceptionResponseMessage exceptionResponseMessage = new ExceptionResponseMessage();
		exceptionResponseMessage.setResponseMessage(exception.getMessage());
		exceptionResponseMessage.setRequestUrl(httpServletRequest.getRequestURI());
		exceptionResponseMessage.setHttpStatus(HttpStatus.NOT_FOUND);
		exceptionResponseMessage.setTimeStamp(LocalDateTime.now());
		exceptionResponseMessage.setStatus(exceptionResponseMessage.getHttpStatus().value());
		return new ResponseEntity<>(exceptionResponseMessage, exceptionResponseMessage.getHttpStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
		List<String> errors = new ArrayList<>();
		ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
		Map<String, List<String>> result = new HashMap<>();
		result.put("errors", errors);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

}
