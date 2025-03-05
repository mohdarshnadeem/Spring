package com.arsh.RestfullWebServicesPart1.Question2345789.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleResourceNotFound(Exception ex, WebRequest request) throws Exception{
       ErrorDetails details = new ErrorDetails(ex.getMessage(), LocalDateTime.now(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
    }

    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        if(ex.getErrorCount()==1) {
            ErrorDetails errorDetails = new ErrorDetails("Total error found " +
                    ex.getErrorCount() + ", that is: " + ex.getFieldError().getDefaultMessage(),
                    LocalDateTime.now(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
        }else{
            ErrorDetails errorDetails = new ErrorDetails("Total error found " +
                    ex.getErrorCount() + ", first one is: " + ex.getFieldError().getDefaultMessage(),
                    LocalDateTime.now(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
        }

    }
}
