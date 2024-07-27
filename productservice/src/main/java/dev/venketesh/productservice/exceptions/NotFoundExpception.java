package dev.venketesh.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExpception extends Exception{
    public NotFoundExpception(String message){
        super(message);
    }
}
