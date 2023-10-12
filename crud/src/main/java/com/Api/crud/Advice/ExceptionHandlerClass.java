package com.Api.crud.Advice;

import com.Api.crud.Entity.Employee;
import com.Api.crud.Exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.crypto.ExemptionMechanismException;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice

public class ExceptionHandlerClass {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleExceptionById(EmployeeNotFoundException exception){
        Map<String,String> errorMsg=new HashMap<>();
        errorMsg.put("Message",exception.getLocalizedMessage());
        return  new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> MethodArgumentNotValidException(MethodArgumentNotValidException manve){
        Map<String,String> msgError=new HashMap<>();
        manve.getAllErrors().forEach(e->msgError.put("Message",e.getDefaultMessage()));
        return new ResponseEntity<>(msgError,HttpStatus.BAD_REQUEST);
    }


}
