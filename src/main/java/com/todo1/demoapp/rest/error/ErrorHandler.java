package com.todo1.demoapp.rest.error;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
	   // obtengo errores de spring
       BindingResult result = e.getBindingResult();
       List<FieldError> fieldErrors = result.getFieldErrors();

       // convierto los errores en string
       StringBuilder errorMessage = new StringBuilder();
       fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() +  " "));

       // devuelvo los errores en json standard
       ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(), request.getRequestURI());
       return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
   }
}
