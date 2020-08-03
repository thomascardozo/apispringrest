package com.softdesing.api;

import java.sql.SQLException;
import java.util.List;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Classe que centraliza a ocorrência de erros

@RestControllerAdvice
@ControllerAdvice
public class ControleExcecoes extends ResponseEntityExceptionHandler{
	
	/*Intercepta erros mais comuns do projeto*/
	@ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String message = "";
		
		if(ex instanceof MethodArgumentNotValidException) {
			
			List<ObjectError> list = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
			for (ObjectError objectError : list) {
				message += objectError.getDefaultMessage() + "\n";
			}
			
		} else {
			message = ex.getMessage();
		}
		
		ObjetoError objetoError = new ObjetoError();
		objetoError.setErro(message);
		objetoError.setCode(status.value() + " ==> " + status.getReasonPhrase());
		
		return new ResponseEntity<>(objetoError, headers, status);	
		
	}
	
	/*Interpreta e trata a maioria dos erros de banco de dados*/
	@ExceptionHandler({DataIntegrityViolationException.class, SQLException.class})
	protected ResponseEntity<Object> handleExceptionDataIntegry(Exception ex){
		
		String msg = "";
		
		if(ex instanceof DataIntegrityViolationException) {
			msg = ((DataIntegrityViolationException)ex).getCause().getCause().getMessage();
		}
		
		else if (ex instanceof SQLException) {
			msg = ((SQLException)ex).getCause().getCause().getMessage();
		}		
		else {
			msg = ex.getMessage();/*outras mensagens de erros mais genéricas*/
		}
		
		ObjetoError oe = new ObjetoError();
		oe.setErro(msg);
		oe.setCode(HttpStatus.INTERNAL_SERVER_ERROR + " ==> " + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		
		return new ResponseEntity<>(oe,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
