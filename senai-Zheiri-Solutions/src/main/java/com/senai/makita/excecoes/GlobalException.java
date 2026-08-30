package com.senai.makita.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    // Para que serve ?
    //@RestControllerAdvice - @ExceptionHandler



    // Recurso não encontrado 404
    @ExceptionHandler(ResourceNotFoundExceptio.class)
    public ResponseEntity<String> ResourceNotFoundExceptio(ResourceNotFoundExceptio ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    // Recurso duplicado 400/409
    @ExceptionHandler(DuplicateRequestException.class)
    public ResponseEntity<String> DuplicateRequestException(DuplicateRequestException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    // Erros causados por dados inválidos enviados pelo cliente - 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> BadRequestException(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
