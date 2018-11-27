package com.propia.sgdm.service.errors;

import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.propia.sgdm.service.errors.exceptions.BaseException;
import com.propia.sgdm.service.errors.exceptions.ErrorInfo;



@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler  {
	
	Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(value = { ResourceNotFoundException.class})
	public ResponseEntity<ErrorInfo> methodArgumentNotVavueFound(BaseException e, HttpServletRequest request) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
		logger.error("-- "+ e.getStackTrace());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { ConnectException.class, org.hibernate.exception.JDBCConnectionException.class})
	public ResponseEntity<ErrorInfo> SystemError(RuntimeException e, HttpServletRequest request) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cagada en el sistema", request.getRequestURI());
		logger.error("-- "+ e.getStackTrace());
		return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
