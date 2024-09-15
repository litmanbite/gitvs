package com.example.proj1.rest;
import com.example.proj1.Excep.Exception;
import com.example.proj1.Excep.pedidoNotFoundExcep;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors hadleException(Exception ex){
        String msg = ex.getMessage();
        return new ApiErrors(msg);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors hadlePedidoNotFoundExcep(pedidoNotFoundExcep ex){
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors hadleInvalidMethod(MethodArgumentNotValidException ex){
      List<String> l = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .map(e -> e.getDefaultMessage())
            .collect(Collectors.toList());
        return new ApiErrors(l);
    }
}
