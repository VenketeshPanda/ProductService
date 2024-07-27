package dev.venketesh.productservice.exceptions;

import dev.venketesh.productservice.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

//    @ExceptionHandler(NotFoundExpception.class)
//    private ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundExpception notFoundExpception){
//        return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND,notFoundExpception.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }

}
