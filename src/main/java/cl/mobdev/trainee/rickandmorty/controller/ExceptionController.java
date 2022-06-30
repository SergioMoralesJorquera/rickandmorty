package cl.mobdev.trainee.rickandmorty.controller;

import cl.mobdev.trainee.rickandmorty.exception.CharacterNotFoundException;
import cl.mobdev.trainee.rickandmorty.models.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> numberNotRequired(RuntimeException ex, WebRequest request){
        ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false), new Date());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<ErrorDto> characterNotFound(CharacterNotFoundException ex, WebRequest request){
        ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false), new Date());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
