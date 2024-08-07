package com.desafioItau.config;

import com.desafioItau.controller.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.*;


@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UnprocessableEntity.class)
    public ResponseEntity handleUnprossessableEntity(UnprocessableEntity exception){
    ExceptionDTO exceptionDTO = new ExceptionDTO("Formato de dados inválido", "422");
    return ResponseEntity.unprocessableEntity().body(exceptionDTO);
    }

}
