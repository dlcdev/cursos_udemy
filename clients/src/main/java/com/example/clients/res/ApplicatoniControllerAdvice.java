package com.example.clients.res;

import com.example.clients.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicatoniControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors().stream().map(
                objectError -> objectError.getDefaultMessage()
        ).collect(Collectors.toList());

        return new ApiErrors(messages);
    }

    public ResponseEntity handleResponseException(ResponseStatusException ex) {
        String mensagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity(apiErrors, codigoStatus);
    }
}
